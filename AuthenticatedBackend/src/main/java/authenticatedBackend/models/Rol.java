package authenticatedBackend.models;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// La clase representa un rol de seguridad y implementa la interfaz GrantedAuthority de Spring Security.
@Entity
@Table(name="roles")
public class Rol implements GrantedAuthority {
	
	// Identificador único del rol en la base de datos.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_rol")
	private Integer roleId;
	
	// Nombre del rol (autoridad) que se utilizará en la lógica de seguridad de Spring.
	private String authority;
	
	// Constructor predeterminado requerido por JPA.
	public Rol() {
		super();
	}
	
	// Constructor que toma el nombre del rol como parámetro.
	public Rol(String authority) {
		this.authority = authority;
	}
	
	// Constructor que toma tanto el identificador como el nombre del rol como parámetros.
	public Rol(Integer roleid, String authority) {
		this.roleId = roleid;
		this.authority = authority;
	}
	
	// Método de la interfaz GrantedAuthority que devuelve el nombre del rol (autoridad).
	@Override
	public String getAuthority() {	
		return this.authority;
	}
}
