package sistema_rh.service;

import org.springframework.stereotype.Service;
import sistema_rh.entity.Empresa;
import sistema_rh.repository.EmpresaRepository;
import java.util.List;

// Service: camada da lógica do sistema.
// Fica entre o Controller (recebe o pedido) e o Repository (acessa o banco).
// O Repository chega pelo construtor (injeção de dependência),
// eu não preciso criar com "new".


@Service // @Service = o Spring cria e gerencia essa classe sozinho.
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }
}
