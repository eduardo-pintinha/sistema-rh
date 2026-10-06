package sistema_rh.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sistema_rh.entity.Empresa;
import sistema_rh.entity.Cargos;
import sistema_rh.repository.EmpresaRepository;
import sistema_rh.repository.CargosRepository;
import java.util.List;

// Marca a classe como camada de regras
@Service
public class CargosService {

    // Acesso ao banco dos cargos
    private final CargosRepository cargosRepository;
    // Acesso ao banco das empresas
    private final EmpresaRepository empresaRepository;

    // Construtor: o Spring entrega os dois repositórios
    public CargosService(CargosRepository cargosRepository, EmpresaRepository empresaRepository) {
        this.cargosRepository = cargosRepository;
        this.empresaRepository = empresaRepository;
    }

    // Cria um cargo dentro de uma empresa
    public Cargos criar(Long empresaId, Cargos cargo) {
        // Busca a empresa; se não existir, erro 404
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
        // Se já existe cargo com esse nome na empresa, erro 409
        if (cargosRepository.existsByEmpresaIdAndNome(empresaId, cargo.getNome())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cargo já cadastrado nesta empresa");
        }
        // Garante que é um cargo novo
        cargo.setId(null);
        // Liga o cargo à empresa da URL
        cargo.setEmpresa(empresa);
        // Todo cargo novo começa ativo
        cargo.setAtivo(true);
        // Salva e devolve
        return cargosRepository.save(cargo);
    }

    // Lista os cargos de uma empresa
    public List<Cargos> listar(Long empresaId) {
        return cargosRepository.findByEmpresaId(empresaId);
    }

    // Busca um cargo pelo id, só se for da empresa
    public Cargos buscar(Long empresaId, Long id) {
        return cargosRepository.findByIdAndEmpresaId(id, empresaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));
    }

    // Atualiza nome e descrição
    public Cargos atualizar(Long empresaId, Long id, Cargos dados) {
        // Busca o cargo existente (já valida a empresa)
        Cargos cargo = buscar(empresaId, id);
        // Se mudou o nome e o novo já existe na empresa, erro 409
        if (!cargo.getNome().equals(dados.getNome())
                && cargosRepository.existsByEmpresaIdAndNome(empresaId, dados.getNome())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cargo já cadastrado nesta empresa");
        }
        // Troca nome e descrição
        cargo.setNome(dados.getNome());
        cargo.setDescricao(dados.getDescricao());
        // Salva a alteração
        return cargosRepository.save(cargo);
    }

    // Marca o cargo como inativo, sem apagar
    public void desativar(Long empresaId, Long id) {
        Cargos cargo = buscar(empresaId, id);
        cargo.setAtivo(false);
        cargosRepository.save(cargo);
    }
}