package com.example.foyerrouamnissi.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration


public class CorsConfig {


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/chambre/**")
                        .allowedOrigins("http://localhost:4200") // Replace with the appropriate frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");

                registry.addMapping("/reservation/**") // Update the mapping to include "/reservation/**" to match "/reservations/{idChambre}"
                        .allowedOrigins("http://localhost:4200") // Replace with the appropriate frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
                registry.addMapping("/bloc") // Update the mapping to include "/reservation/**" to match "/reservations/{idChambre}"
                        .allowedOrigins("http://localhost:4200") // Replace with the appropriate frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
                registry.addMapping("/foyer") // Update the mapping to include "/reservation/**" to match "/reservations/{idChambre}"
                        .allowedOrigins("http://localhost:4200") // Replace with the appropriate frontend URL


     
  
       
            }
        };
    }
}


