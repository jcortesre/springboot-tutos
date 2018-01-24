package com.jcortes.sbtutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.abc.foo.User;
import com.jcortes.sbtutos.vo.EmailConfig;

@ComponentScan({ "com.abc.foo", "com.jcortes.sbtutos" })
@SpringBootApplication
@EnableConfigurationProperties
public class SbtutosApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SbtutosApplication.class, args);

		EmailConfig emailConfig = (EmailConfig) context.getBean("emailConfig");
		System.out.println(emailConfig.toString());
	}

	@Bean
	public User user() {
		return new User("John", "Derss", "john@tt.com");
	}
}
