package com.versionamiento.version.security;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import io.jsonwebtoken.security.Keys;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${jwt.secret}")
    private String secretString;

    private SecretKey getSigningKey() {
        // Convierte el texto plano de la variable de entorno en una llave criptográfica
        // segura para HS256
        return Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withSecretKey(getSigningKey()).build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para APIs REST
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/saludo/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.decoder(jwtDecoder())) // Usamos el decodificador personalizado con nuestra
                                                               // clave secreta
                );

        return http.build();
    }

}