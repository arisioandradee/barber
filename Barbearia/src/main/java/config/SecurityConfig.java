package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll() // Permite acesso ao h2-console
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable()) // Desabilita CSRF
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())); // Permite frames

        return http.build();
    }
}