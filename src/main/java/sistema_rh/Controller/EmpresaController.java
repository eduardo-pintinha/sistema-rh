package sistema_rh.Controller;

import org.springframework.web.bind.annotation.PostMapping;  // permite usar @PostMapping (cadastrar)
import org.springframework.web.bind.annotation.RequestBody; // permite usar @RequestBody (receber JSON)
import org.springframework.web.bind.annotation.RequestMapping;  // permite usar @RequestMapping (endereço base)
import org.springframework.web.bind.annotation.RestController;  // permite usar @RestController (API web)
import org.springframework.web.bind.annotation.GetMapping;       // permite usar @GetMapping (buscar)
import sistema_rh.entity.Empresa;// a ficha da empresa
import sistema_rh.service.EmpresaService; // a lógica do sistema
import java.util.List;


// Esta classe recebe pedidos da internet e responde em JSON
@RestController
// Endereço base de tudo aqui: http://localhost:8080/empresas
@RequestMapping("/empresas")
public class EmpresaController {

    // Ferramenta para chamar a lógica (Service). final = não troca depois
    private final EmpresaService empresaService;

    // Construtor: o Spring entrega o Service pronto (injeção de dependência)
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    // @RequestBody: pega o JSON enviado e transforma em objeto Empresa
    public Empresa salvar(@RequestBody Empresa empresa) {
        return empresaService.salvar(empresa);
    }

    @GetMapping
    public List<Empresa> listar() {
        return empresaService.listar();
    }
}