package app.config;

import app.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;



@Configuration
@ComponentScan(basePackages = "app")
public class AppConfig {
    @Bean(name = "Dog")
    public Dog getDog() {
        return new Dog();

    }
}
