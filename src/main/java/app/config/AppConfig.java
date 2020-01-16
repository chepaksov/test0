package app.config;

import app.model.Dog;
import app.model.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan(basePackages = "app")
public class AppConfig {
    @Bean(name = "dog")
    public Dog getDog() {
        return new Dog();

    }

    @Bean(name = "time")
    public Timer getTimer() {
        return new Timer();

    }


}
