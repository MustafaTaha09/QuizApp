package com.example.quizapp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){ // DataSource is auto Configured by spring which allows us to access the rows in the db schema we created

        return new JdbcUserDetailsManager(dataSource); // spring will use JDBC Authentication with our DataSource
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "/springDataRest/questions").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/springDataRest/questions/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/springDataRest/questions").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/springDataRest/questions/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/springDataRest/questions/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/springDataRest/quizzes").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/springDataRest/quizzes/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE, "/springDataRest/quizzes/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/quiz/createQuiz/**").hasRole("ADMIN")





        );
        // use http basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


    //    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() { //this way, we re hard coding our roles in the memory not in our db.
//        UserDetails mustafa = User.builder().
//                username("mustafa").
//                password("{noop}mt123").
//                roles("EMPLOYEE", "MANAGER", "ADMIN").build();
//
//        UserDetails mariam = User.builder().
//                username("mariam").
//                password("{noop}mr123").
//                roles("EMPLOYEE", "MANAGER").build();
//
//        UserDetails john = User.builder().
//                username("john").
//                password("{noop}js123").
//                roles("EMPLOYEE").build();
//
//        return new InMemoryUserDetailsManager(mustafa, mariam, john);
//
//    }

}
