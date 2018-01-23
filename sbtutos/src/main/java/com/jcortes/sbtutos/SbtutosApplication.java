package com.jcortes.sbtutos;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.abc.foo.User;

@ComponentScan({ "com.abc.foo", "com.jcortes.sbtutos" })
@SpringBootApplication
public class SbtutosApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SbtutosApplication.class, args);

		String[] beans = context.getBeanDefinitionNames();
		Arrays.sort(beans);
		System.out.println("----------beans created ----------------" + beans.length);
		for (String bean : beans) {
			System.out.println(bean);
		}
		System.out.println("----------beans created ----------------");
		
		System.out.println(context.getBean("user").toString());
	}

	@Bean
	public User user() {
		return new User("John", "Derss", "john@tt.com");
	}
}
