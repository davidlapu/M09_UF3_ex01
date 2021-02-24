package cat.itb.m09.uf3.ex01;

import cat.itb.m09.uf3.ex01.servlets.MyServlet;
import cat.itb.m09.uf3.ex01.servlets.ServletDni;
import cat.itb.m09.uf3.ex01.servlets.ServletISBN;
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

    @Bean
    public ServletRegistrationBean servletRegistrationBeanDni() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new ServletDni(), "/dniAmbLletra");
        return bean;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBeanIsbn() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new ServletISBN(), "/isbnCalcular");
        return bean;
    }


}
