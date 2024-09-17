package com.ucb.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		//for(String beanDefinitionName: beanDefinitionNames){
			//System.out.println(String.format("Name: %s", beanDefinitionName));
		//}
		System.out.printf(" Total beans: %d%n", beanDefinitionNames.length);
	}
	@Bean
	String getUCB(){
		return "Universidad Catolica Boliviana";
	}

	@Bean
	String getUMSS(){
		return "Universidad Mayor de San Simmon";
	}

	@Bean
	CommandLineRunner commandLineRunner(String getUCB, @Qualifier("getUMSS") String getUMSS){
		return args -> {
			System.out.printf("Hello Lib, %s and %s%n", getUCB, getUMSS);
		};
	}
}
