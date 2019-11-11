package csokilotto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
//		ApplicationContext ct = SpringApplication.run(App.class, args);
//		
//		String[] array = ct.getBeanDefinitionNames();
//		
//		for(String name : array) {
//			System.out.println(name);
//		}
	}
}
