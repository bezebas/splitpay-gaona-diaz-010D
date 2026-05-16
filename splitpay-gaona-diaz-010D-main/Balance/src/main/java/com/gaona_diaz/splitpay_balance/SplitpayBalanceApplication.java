package com.gaona_diaz.splitpay_balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SplitpayBalanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitpayBalanceApplication.class, args);
	}

}
