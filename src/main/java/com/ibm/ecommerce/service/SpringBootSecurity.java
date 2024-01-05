package com.ibm.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringBootSecurity extends WebSecurityConfigurerAdapter {

  @Autowired
  private ApplicationContext context;

  //Codificador de contraseñas
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    UserDetailsService userDetailsService = context.getBean(UserDetailsService.class);
    auth.userDetailsService(userDetailsService).passwordEncoder(getEncoder());
  }

  //Restringir Vistas de Acuerdo al Usuario
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //Para evitar la inyección de código malicioso a la app
    //En la línea /admin/ es para darle permisos de accesos a los templates de admin y su contenido
    //al igual que en /products/
    //y se especifica que el formulario donde se va a loguear el usuario responde a la ruta
    // /user/login
    http.csrf().disable().authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/products/**").hasRole("ADMIN")
        .and().formLogin().loginPage("/user/login")
        .permitAll().defaultSuccessUrl("/user/signIn");
  }

  @Bean
  public BCryptPasswordEncoder getEncoder(){
    return new BCryptPasswordEncoder();
  }
}
