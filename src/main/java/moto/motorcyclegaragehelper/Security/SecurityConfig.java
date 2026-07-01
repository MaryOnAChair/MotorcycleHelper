package moto.motorcyclegaragehelper.Security;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/** This is a Configuration class for authentication requests
 * The class is used for getting passwords and usernames entered during login
 * This class is used for authentication requests and configuration*/

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //Injects Security Filter
    private final JwAuthFilter jwAuthFilter;
    public SecurityConfig(JwAuthFilter jwAuthFilter) {
        this.jwAuthFilter = jwAuthFilter;
    }

    //Security rules using security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        return http
                .cors(cors->{})
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth //Only authenticated requests have permissions

                        .requestMatchers("/auth/**").permitAll()

                        .anyRequest().authenticated()
                )
                .addFilterBefore(
                        jwAuthFilter,
                        UsernamePasswordAuthenticationFilter.class
                )


                .build();
    }


    //Configuration for security rules
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration =
                new CorsConfiguration();

        configuration.setAllowedOrigins(
                List.of("http://localhost:4200"));  //  Allows Front End

        configuration.setAllowedMethods(
                List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));    //  Allows these methods

        configuration.setAllowedHeaders(
                List.of("*"));  //  Allows all headers

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(
                "/**",
                configuration);
        return source;
    }

    }


