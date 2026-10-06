package sistema_rh.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sistema_rh.entity.Empresa;
import sistema_rh.entity.Setores;
import sistema_rh.repository.EmpresaRepository;
import sistema_rh.repository.SetoresRepository;

import java.util.List;

// Marca a classe como camada de regras
@Service
public class SetoresService {

    // Acesso ao banco dos setores
    private final SetoresRepository setoresRepository;
    // Acesso ao banco das empresas
    private final EmpresaRepository empresaRepository;

    // Construtor: o Spring entrega os dois repositórios
    public SetoresService(SetoresRepository setoresRepository, EmpresaRepository empresaRepository) {
        this.setoresRepository = setoresRepository;
        this.empresaRepository = empresaRepository;
    }

    // Cria um setor dentro de uma empresa
    public Setores criar(Long empresaId, Setores setor) {
        // Busca a empresa; se não existir, erro 404
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
        // Garante que é um setor novo
        setor.setId(null);
        // Liga o setor à empresa da URL
        setor.setEmpresa(empresa);
        // Todo setor novo começa ativo
        setor.setAtivo(true);
        // Salva e devolve
        return setoresRepository.save(setor);
    }

    // Lista os setores de uma empresa
    public List<SetoresRepository> listar(Long empresaId) {
        return setoresRepository.findByEmpresaId(empresaId);
    }

    // Busca um setor pelo id, só se for da empresa
    public Setores buscar(Long empresaId, Long id) {
        return (Setores) setoresRepository.findByIdAndEmpresaId(id, empresaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Setor não encontrado"));
    }

    // Atualiza nome e descrição
    public Setores atualizar(Long empresaId, Long id, Setores dados) {
        // Busca o setor existente (já valida a empresa)
        Setores setor = buscar(empresaId, id);
        // Troca só nome e descrição
        setor.setNome(dados.getNome());
        setor.setDescricao(dados.getDescricao());
        // Salva a alteração
        return setoresRepository.save(setor);
    }

    // Marca o setor como inativo, sem apagar
    public void desativar(Long empresaId, Long id) {
        Setores setor = buscar(empresaId, id);
        setor.setAtivo(false);
        setoresRepository.save(setor);
    }
}