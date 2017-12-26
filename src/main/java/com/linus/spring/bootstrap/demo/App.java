package com.linus.spring.bootstrap.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.linus.spring.bootdemo.demo.security.DemoWebSecurityConfigurerAdapter;

/**
 * <h2>Features: </h2>
 * <ul>
 * <li>Spring security is used.</li>
 * <li>Spring session is used.</li>
 * </ul>
 * @author lyan2
 */
@EnableAutoConfiguration
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App.class, args);
	}
	
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
	
	@Bean
	public WebSecurityConfigurerAdapter demoWebSecurityConfigurerAdapter() {
		return new DemoWebSecurityConfigurerAdapter();
	}

}
