package usmp.pe.edu.trabajo.bean;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface PersonaRepository extends Repository<Persona, Long> {

	void save(Persona persona) throws DataAccessException;

	List<Persona> findAll();

	Persona findOne(Long codigo);
	
	void delete(Long codigo);
	
}
