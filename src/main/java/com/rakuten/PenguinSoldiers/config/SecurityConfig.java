package com.rakuten.PenguinSoldiers.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import com.rakuten.PenguinSoldiers.controllers.account.UserService;

@Configuration
@EnableWebMvcSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public TokenBasedRememberMeServices rememberMeServices() {
        return new TokenBasedRememberMeServices("remember-me-key", userService());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
	}
    
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .eraseCredentials(true)
            .userDetailsService(userService())
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/favicon.ico", "/resources/**", "/signup", "/forgotPassword").permitAll()
                .anyRequest().authenticated() // All remaining URLs require that the user be successfully authenticated
                .and()
            .formLogin() //Setup form based authentication using the Java configuration defaults. Authentication is performed when a POST is submitted to the URL “/login” with the parameters “username” and “password”.
                .loginPage("/signin")	// Explicitly state the login page
                .permitAll() // allow access to any URL that formLogin() uses
                .failureUrl("/signin?error=1")
                .loginProcessingUrl("/authenticate") // Specifies the URL to validate the credentials.
                .and()
            .logout()
                .logoutUrl("/logout")
                .permitAll() // allow access to any URL that formLogin() uses
                .logoutSuccessUrl("/signin?logout")
                .and()
            .rememberMe() // input with value _spring_security_remember_me
                .rememberMeServices(rememberMeServices())
                .key("remember-me-key");
    }
}