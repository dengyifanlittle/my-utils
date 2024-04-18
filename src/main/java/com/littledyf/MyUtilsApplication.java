package com.littledyf;

import com.littledyf.cqs.Bus;
import com.littledyf.cqs.Registry;
import com.littledyf.cqs.SpringBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyUtilsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyUtilsApplication.class, args);
	}

	/**
	 * 注册器
	 */
	@Bean
	public Registry registry(ApplicationContext applicationContext) {
		return new Registry(applicationContext);
	}

	/**
	 * 消息总线
	 */
	@Bean
	public Bus commandBus(Registry registry) {
		return new SpringBus(registry);
	}
}
