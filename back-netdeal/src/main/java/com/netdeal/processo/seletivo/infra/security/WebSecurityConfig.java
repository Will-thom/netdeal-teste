package com.netdeal.processo.seletivo.infra.security;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Override
   public void configure(WebSecurity web) {
      web.ignoring()
         .antMatchers(
            "/*.html",
            "/favicon.ico",
            "/**/*.html",
            "/**/*.css",
            "/**/*.js",
            "/h2-console/**"
         );
   }

   @Override
   public void configure(HttpSecurity httpSecurity) throws Exception {
      httpSecurity
            .cors()
          .and()
            .csrf()
            .disable()
            .exceptionHandling()
             .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
            .authorizeRequests()
            .antMatchers("/api/authenticate").permitAll()
              .antMatchers("/offerTransactionCall").permitAll()
              //TODO: liberação de endpoints autenticados para fins de testes na aplicação.
              .mvcMatchers(HttpMethod.GET, "/usuarios/**").permitAll()
              .mvcMatchers(HttpMethod.GET, "/acesso/**").permitAll()
              .mvcMatchers(HttpMethod.DELETE, "/acesso/**").permitAll()
              .mvcMatchers(HttpMethod.PUT, "/acesso/**").permitAll()
              .mvcMatchers(HttpMethod.POST, "/acesso/**").permitAll()
              .mvcMatchers(HttpMethod.GET, "/usuarioSimples/**").permitAll()
            .anyRequest().authenticated();
   }
}