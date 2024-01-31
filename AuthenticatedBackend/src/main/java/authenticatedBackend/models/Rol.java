package authenticatedBackend.models;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Rol implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_rol")
	private Integer roleId;
	
	private String authority;
	
	public Rol() {
		super();
	}
	
	public Rol(String authority) {
		this.authority = authority;
	}
	
	public Rol(Integer roleid, String authority) {
		this.roleId = roleid;
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

}
