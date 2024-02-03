package authenticatedBackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	// Configura la cadena de filtros de seguridad para la aplicación.
	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
                // Deshabilita la protección CSRF (Cross-Site Request Forgery).
                .csrf(csrf -> csrf.disable())
                
                // Configura las reglas de autorización para las solicitudes.
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                // Permite el acceso a cualquier solicitud (puede necesitar ajustes según los requisitos).
                                .anyRequest().permitAll()
                )
                // Construye y devuelve la cadena de filtros de seguridad configurada.
                .build();				
	}
}
