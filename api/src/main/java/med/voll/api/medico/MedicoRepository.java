package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface MedicoRepository extends JpaRepository <Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}


//fazer a persistência, pegar o objeto Medico e salvar no banco de dados, o Spring Data tem o Repository

// Usando Repository no lugar do padrão DAO