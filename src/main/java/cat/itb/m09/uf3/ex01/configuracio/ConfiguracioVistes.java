package cat.itb.m09.uf3.ex01.configuracio;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracioVistes implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/salutacio").setViewName("index.html");
        registry.addViewController("/dni").setViewName("dni.html");
        registry.addViewController("/isbn").setViewName("isbn.html");
    }
}
