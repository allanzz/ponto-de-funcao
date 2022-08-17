package br.com.allan.pontodefuncao.util.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	 http
         .authorizeRequests()
         .anyRequest().permitAll()
         .and()
         .formLogin(form -> form
                 .loginPage("/login")
                 .defaultSuccessUrl("/home", true)
                 .permitAll()
         ).logout(logout -> logout.logoutUrl("/logout")
 ).csrf().disable();
    	 return http.build();
    }

}