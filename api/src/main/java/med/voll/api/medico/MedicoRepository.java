package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository <Medico, Long> {
}


//fazer a persistĂȘncia, pegar o objeto Medico e salvar no banco de dados, o Spring Data tem o Repository