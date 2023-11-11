package es.apipharmashop.apipharmashop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
public class SecurityConfiguration {
    //Esto sirve cuando estamos empezando y no queremos ninguna seguridad.
    //@Bean
    //public WebSecurityCustomizer webSecurityCustomizer() {
    //return (web) -> web.ignoring().anyRequest();
    //}
}
