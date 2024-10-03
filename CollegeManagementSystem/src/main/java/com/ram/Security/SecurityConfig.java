 package com.ram.Security;

 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Bean;
 import org.springframework.security.authentication.AuthenticationManager;
 import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
 import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.config.http.SessionCreationPolicy;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.security.web.SecurityFilterChain;
 import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

 @EnableWebSecurity
 public class SecurityConfig {

     @Autowired
     private JwtAuthenticationFilter jwtAuthenticationFilter;

     @Autowired
     private UserDetailsService customUserDetailsService;

     // Configure PasswordEncoder bean
     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }

     // AuthenticationManager bean
     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
         return authenticationConfiguration.getAuthenticationManager();
     }

     // Configure the authentication
     @Autowired
     public void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
     }

     // Configure the SecurityFilterChain
     @SuppressWarnings("removal")
	@Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
             .csrf().disable()
             .authorizeHttpRequests()
             .requestMatchers("/api/auth/**").permitAll() // Allow requests to the authentication endpoints
             .anyRequest().authenticated() // All other requests require authentication
             .and()
             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Set stateless session management

         // Add JWT filter before the UsernamePasswordAuthenticationFilter
         http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

         return http.build();
     }
 }
