package com.gaona_diaz.splitpay_gasto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "evento-service", url = "http://localhost:8082")
public interface EventoClient {

    @GetMapping("/eventos/{id}")
    Object obtenerEvento(@PathVariable String id);

}