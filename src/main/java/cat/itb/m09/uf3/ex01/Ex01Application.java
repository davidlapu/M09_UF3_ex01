package cat.itb.m09.uf3.ex01;

import cat.itb.m09.uf3.ex01.servlets.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ex01Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex01Application.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new MyServlet(), "/myServlet");
        return bean;
    }


}
