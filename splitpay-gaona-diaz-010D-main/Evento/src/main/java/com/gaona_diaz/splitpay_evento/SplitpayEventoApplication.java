package com.gaona_diaz.splitpay_evento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SplitpayEventoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitpayEventoApplication.class, args);
	}

}
