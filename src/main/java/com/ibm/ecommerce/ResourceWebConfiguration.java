package com.ibm.ecommerce;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* CLASE PARA CARGAR LAS IMAGENES DE LOS PRODUCTOS CREADOS EN LA INTERFAZ HOME*/

@Configuration
public class ResourceWebConfiguration implements WebMvcConfigurer {

  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
  }

}
