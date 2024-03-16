package ru.SpringControlWork.SpringControlWork.configuration;

import ru.SpringControlWork.SpringControlWork.aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ProjectConfig {
    @Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}