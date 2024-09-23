package com.example.front_buhg.config;

import com.example.front_buhg.model.RoleEnum;
import com.example.front_buhg.model.UserModel;
import com.example.front_buhg.repository.JpaUserRepository;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
private final JpaUserRepository userRepository;
private final PasswordEncoder passwordEncoder;

public WebSecurityConfig(JpaUserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
}

@PostConstruct
public void createDefaultUser() {
    if (!userRepository.existsByUsername("ADMIN")) {
        UserModel user = new UserModel();
        user.setUsername("ADMIN");
        user.setPassword(passwordEncoder.encode("123"));
        user.setRole(Collections.singleton(RoleEnum.ADMIN));
        userRepository.save(user);
    }
}

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(username -> {
                UserModel user = userRepository.findByUsername(username);
                if (user == null) {
                    throw new UsernameNotFoundException("Такой пользователь не существует!");
                }
                return new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        true,
                        true,
                        true,
                        true,
                        user.getRole()
                );
            }
    ).passwordEncoder(passwordEncoder);
}

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(authorize ->
                    authorize.requestMatchers("/login", "/registration").permitAll()
                            .anyRequest().authenticated())
            .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/").permitAll())
            .logout(logout -> logout.permitAll())
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable());

    return http.build();

}
}