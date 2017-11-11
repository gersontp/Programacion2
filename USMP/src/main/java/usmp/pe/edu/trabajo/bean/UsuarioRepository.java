package usmp.pe.edu.trabajo.bean;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends Repository<Usuario, Long> {

	void save(Usuario usuario) throws DataAccessException;

	List<Usuario> findAll();
	
	@Query("select u from Usuario u where u.stusuario = :stusuario and u.clave = :clave")
	List<Usuario> findUsuario(@Param("stusuario") String stusuario, @Param("clave") String clave);
	
	Usuario findOne(Long codigo);
	
	void delete(Long codigo);

}
