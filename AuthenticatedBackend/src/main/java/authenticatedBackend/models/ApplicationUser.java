package authenticatedBackend.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//Indica que esta clase es una entidad JPA y se mapeará a la tabla "users" en la base de datos.
@Entity
@Table(name = "users")
public class ApplicationUser implements UserDetails {

 // La anotación @Id indica que este campo es la clave primaria en la base de datos.
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "user_id")
 private Integer userid;

 // Almacena el nombre de usuario.
 private String username;

 // Almacena la contraseña del usuario.
 private String password;

 // La relación ManyToMany se utiliza para establecer una relación muchos a muchos entre usuarios y roles.
 // FetchType.EAGER indica que los roles se cargarán de inmediato cuando se cargue el usuario.
 @ManyToMany(fetch = FetchType.EAGER)
 @JoinTable(name = "user_role_junction",
         joinColumns = { @JoinColumn(name = "user_id") },
         inverseJoinColumns = { @JoinColumn(name = "id_rol") })
 private Set<Rol> authorities;

 // Constructor por defecto
 public ApplicationUser() {
     super();
     this.authorities = new HashSet<Rol>();
 }

 // Constructor con parámetros
 public ApplicationUser(Integer userid, String username, String password, Set<Rol> authorities) {
     super();
     this.userid = userid;
     this.username = username;
     this.password = password;
     this.authorities = authorities;
 }

 // Métodos getter y setter para userid
 public Integer getUserid() {
     return userid;
 }

 public void setUserid(Integer userid) {
     this.userid = userid;
 }

 // Método de la interfaz UserDetails que devuelve la colección de roles del usuario.
 @Override
 public Collection<? extends GrantedAuthority> getAuthorities() {
     return this.authorities;
 }

 // Método setter para authorities
 public void setAuthorities(Set<Rol> authorities) {
     this.authorities = authorities;
 }

 // Método de la interfaz UserDetails que devuelve la contraseña del usuario.
 @Override
 public String getPassword() {
     return this.password;
 }

 // Método setter para password
 public void setPassword(String password) {
     this.password = password;
 }

 // Método de la interfaz UserDetails que devuelve el nombre de usuario.
 @Override
 public String getUsername() {
     return this.username;
 }

 // Método setter para username
 public void setUsername(String username) {
     this.username = username;
 }

 // Métodos de la interfaz UserDetails que indican que la cuenta no expira, no está bloqueada,
 // las credenciales no expiran y la cuenta está habilitada.
 @Override
 public boolean isAccountNonExpired() {
     return true;
 }

 @Override
 public boolean isAccountNonLocked() {
     return true;
 }

 @Override
 public boolean isCredentialsNonExpired() {
     return true;
 }

 @Override
 public boolean isEnabled() {
     return true;
 }
}