package com.fstg.bookerorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class BookerOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookerOrderServiceApplication.class, args);
    }

//	@Bean
//	public CommandLineRunner demo(OrderRepository orderRepository, OrderStatusRepository orderStatusRepository) {
//		return (args) -> {
//
//		};
//	}
}
