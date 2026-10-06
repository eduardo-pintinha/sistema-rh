package sistema_rh.Controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sistema_rh.entity.Setores;
import sistema_rh.repository.SetoresRepository;
import sistema_rh.service.SetoresService;
import java.util.List;

// Recebe requisições HTTP e devolve JSON
@RestController
// Endereço base das rotas
@RequestMapping("/empresas/{empresaId}/setores")
public class SetoresController {

    // Service com as regras
    private final SetoresService service;

    // Construtor: o Spring entrega o service
    public SetoresController(SetoresService service) {
        this.service = service;
    }

    // POST: cria setor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Setores criar(@PathVariable Long empresaId, @Valid @RequestBody Setores setor) {
        return service.criar(empresaId, setor);
    }

    // GET: lista os setores da empresa
    @GetMapping
    public List<SetoresRepository> listar(@PathVariable Long empresaId) {
        return service.listar(empresaId);
    }

    // GET com id: busca um setor
    @GetMapping("/{id}")
    public Setores buscar(@PathVariable Long empresaId, @PathVariable Long id) {
        return service.buscar(empresaId, id);
    }

    // PUT: atualiza um setor
    @PutMapping("/{id}")
    public Setores atualizar(@PathVariable Long empresaId, @PathVariable Long id,
                             @Valid @RequestBody Setores dados) {
        return service.atualizar(empresaId, id, dados);
    }

    // DELETE: desativa o setor
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desativar(@PathVariable Long empresaId, @PathVariable Long id) {
        service.desativar(empresaId, id);
    }
}