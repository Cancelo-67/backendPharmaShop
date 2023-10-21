package es.apipharmashop.apipharmashop.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir solicitudes desde el origen de tu aplicación Vue.js
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173/")  // Cambia esto con la URL de tu aplicación Vue.js
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
