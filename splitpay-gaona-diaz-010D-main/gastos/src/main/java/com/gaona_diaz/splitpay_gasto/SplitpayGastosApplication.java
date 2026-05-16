package com.gaona_diaz.splitpay_gasto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SplitpayGastosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitpayGastosApplication.class, args);
	}

}
