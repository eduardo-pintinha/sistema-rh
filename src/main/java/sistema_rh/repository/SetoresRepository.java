package sistema_rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema_rh.entity.Setores;

import java.util.List;
import java.util.Optional;

// Interface que o Spring transforma em acesso ao banco
public interface SetoresRepository extends JpaRepository<Setores, Long> {

    // Lista só os setores de uma empresa
    List<SetoresRepository> findByEmpresaId(Long empresaId);

    // Busca um setor pelo id, mas só se for dessa empresa
    Optional<SetoresRepository> findByIdAndEmpresaId(Long id, Long empresaId);
}