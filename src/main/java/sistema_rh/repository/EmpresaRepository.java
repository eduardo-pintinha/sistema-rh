package sistema_rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema_rh.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

    // Repository: é o intermediário entre o meu código e o banco de dados.
// Ao estender JpaRepository, ganho métodos prontos (save, findAll,
// findById, deleteById...) sem escrever SQL.
// <Empresa, Long> = trabalha com a entidade Empresa, cujo id é do tipo Long.
// É uma interface: o Spring cria a implementação sozinho ao iniciar o projet
}