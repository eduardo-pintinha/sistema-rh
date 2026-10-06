package sistema_rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema_rh.entity.Cargos;
import java.util.List;
import java.util.Optional;

// Interface que o Spring transforma em acesso ao banco
public interface CargosRepository extends JpaRepository<Cargos, Long> {

    List<Cargos> findByEmpresaId(Long empresaId);

    // Busca um cargo pelo id, só se for da empresa
    Optional<Cargos> findByIdAndEmpresaId(Long id, Long empresaId);

    // Diz se a empresa já tem um cargo com esse nome
    boolean existsByEmpresaIdAndNome(Long empresaId, String nome);
}