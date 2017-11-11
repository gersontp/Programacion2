package usmp.pe.edu.trabajo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@NotEmpty(message="Debe ingresar un nombre")
	@Size(min=3, max=10,message="Debe tener una longitud mínima de {min} y máxima {max}")
	private String nombre;
	@NotEmpty(message="Debe ingresar un apellido")
	@Size(min=2, max=30, message="Debe tener una longitud mínima de {min} y máxima {max}")
	private String apellido;
	@NotEmpty(message="Debe ingresar una dirección")
	@Size(min=2, max=30, message="Debe tener una longitud mínima de {min} y máxima {max}")
	private String direccion;
	
	@OneToOne
	@JoinColumn(name = "codigo_user")
	private Usuario user;
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}


	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	
}
