package com.example.JWT_RestAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/username/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/admin/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/manager/products").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.POST, "/seller/orders").hasRole("VENDEDOR")
                        .requestMatchers(HttpMethod.GET, "/customer/products").hasRole("CLIENTE")
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("Lucas")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("Jean")
                .password(passwordEncoder().encode("4545"))
                .roles("ADMIN")
                .build();
        UserDetails gerente = User.builder()
                .username("Bruna")
                .password(passwordEncoder().encode("1425"))
                .roles("GERENTE")
                .build();
        UserDetails cliente = User.builder()
                .username("Carlos")
                .password(passwordEncoder().encode("9999"))
                .roles("CLIENTE")
                .build();
        UserDetails vendedor = User.builder()
                .username("Maria")
                .password(passwordEncoder().encode("1111"))
                .roles("VENDEDOR")
                .build();
        return new InMemoryUserDetailsManager(user, admin, gerente, cliente, vendedor);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
