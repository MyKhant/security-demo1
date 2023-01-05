package com.example.securitydemo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

//   @Bean
//    public UserDetailsService userDetailsService(){
//        var userDetailsService = new InMemoryUserDetailsManager();
//
//        var user1 = User.withUsername("John").password("12345").authorities("read").build();
//
//        var user2 = User.withUsername("Mary").password("12345").authorities("write").build();
//
//        userDetailsService.createUser(user1);
//        userDetailsService.createUser(user2);
//        return userDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        var userDetailsService = new InMemoryUserDetailsManager();
//
//        var user1 = User.withUsername("John").password("12345").authorities("read").build();
//
//        var user2 = User.withUsername("Mary").password("12345").authorities("write").build();
//
//        userDetailsService.createUser(user1);
//        userDetailsService.createUser(user2);
        auth.inMemoryAuthentication()
                .withUser("john")
                .password("12345")
                .authorities("read")
                .and()
                .withUser("mary")
                .password("12345")
                .authorities("read")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
