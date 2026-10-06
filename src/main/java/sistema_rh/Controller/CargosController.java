package sistema_rh.Controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sistema_rh.entity.Cargos;
import sistema_rh.service.CargosService;
import java.util.List;@RestController
// Endereço base das rotas
@RequestMapping("/empresas/{empresaId}/cargos")
public class CargosController {

    // Service com as regras
    private final CargosService service;

    // Construtor: o Spring entrega o service
    public CargosController(CargosService service) {
        this.service = service;
    }

    // POST: cria cargo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cargos criar(@PathVariable Long empresaId, @Valid @RequestBody Cargos cargo) {
        return service.criar(empresaId, cargo);
    }

    // GET: lista os cargos da empresa
    @GetMapping
    public List<Cargos> listar(@PathVariable Long empresaId) {
        return service.listar(empresaId);
    }

    // GET com id: busca um cargo
    @GetMapping("/{id}")
    public Cargos buscar(@PathVariable Long empresaId, @PathVariable Long id) {
        return service.buscar(empresaId, id);
    }

    // PUT: atualiza um cargo
    @PutMapping("/{id}")
    public Cargos atualizar(@PathVariable Long empresaId, @PathVariable Long id,
                            @Valid @RequestBody Cargos dados) {
        return service.atualizar(empresaId, id, dados);
    }

    // DELETE: desativa o cargo
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desativar(@PathVariable Long empresaId, @PathVariable Long id) {
        service.desativar(empresaId, id);
    }
}