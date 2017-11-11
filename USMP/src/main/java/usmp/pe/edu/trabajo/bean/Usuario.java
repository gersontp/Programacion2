package usmp.pe.edu.trabajo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
//	@NotEmpty(message="Debe ingresar un usuario")
//	@Size(min=3, max=10, message="Debe tener una longitud mínima de {min} y máxima {max}")
	private String stusuario;
//	@NotEmpty(message="Debe ingresar una clave")
//	@Size(min=3, max=10, message="Debe tener una longitud mínima de {min} y máxima {max}")
	private String clave;
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getStusuario() {
		return stusuario;
	}
	public void setStusuario(String stusuario) {
		this.stusuario = stusuario;
	}
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", stusuario=" + stusuario + ", clave=" + clave + "]";
	}
	
	
	
}
