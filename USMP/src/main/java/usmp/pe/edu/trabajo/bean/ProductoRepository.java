package usmp.pe.edu.trabajo.bean;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends Repository<Producto, Long> {

	void save(Producto producto) throws DataAccessException;
	@Cacheable("productos")
	List<Producto> findAll();

	Producto findOne(Long codigo);
	
	void delete(Long codigo);
	
	@Query("from Producto p where lower(p.nombre) like lower(:nombre)")
	 List<Producto> filtroProductos(@Param("nombre") String nombre);
}
