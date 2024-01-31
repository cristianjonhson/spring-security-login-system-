package authenticatedBackend.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import authenticatedBackend.models.ApplicationUser;
import authenticatedBackend.models.Rol;

public class UserService implements UserDetailsService {
    
    // Inyección de PasswordEncoder para codificar contraseñas
    @Autowired
    private PasswordEncoder encoder;

    // Implementación del método de la interfaz UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // Verificar si el nombre de usuario es "Cristian"
        if (!username.equals("Cristian")) {
            // Lanzar excepción si el nombre de usuario no es válido
            throw new UsernameNotFoundException("No es Cristian");
        }
        
        // Crear un conjunto de roles (en este caso, solo un rol "USER")
        Set<Rol> roles = new HashSet<>();
        roles.add(new Rol(1, "USER"));
        
        // Crear y devolver un objeto ApplicationUser que implementa UserDetails
        return new ApplicationUser(1, "Cristian", encoder.encode("password"), roles);
    }
}