package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.service.EmailService;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(value = "pl.coderslab")
class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public EmailService emailService() {
        return new EmailService(javaMailSender(), defaultMailFrom());
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("poczta.o2.pl");
        javaMailSender.setUsername("coderslab@o2.pl");
        javaMailSender.setPassword("coderslab");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

    @Bean
    public String defaultMailFrom() {
        return "coderslab@o2.pl";
    }

}
