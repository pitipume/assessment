package com.kbtg.bootcamp.posttest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

import static org.springframework.security.config.Customizer.withDefaults;


@EnableWebSecurity
@Configuration
public class SecurityConfig {
        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((requests) -> requests
                                    .requestMatchers("/admin/**").hasRole("ADMIN")
                                    .requestMatchers("/**").permitAll()
                                    .anyRequest()
                                    .authenticated())
                    .httpBasic(withDefaults());
            return http.build();
        }
        @Bean
        public UserDetailsService userDetailsService() {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            UserDetails user = User.withUsername("admin")
                    .password(passwordEncoder.encode("password"))
                    .roles("ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(user);
        }
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

}