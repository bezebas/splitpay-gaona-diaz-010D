package com.gaona_diaz.splitpay_balance.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service", url = "http://localhost:8067")
public interface UsuarioClient {

    @GetMapping("/usuarios/{id}")
    Object obtenerUsuario(@PathVariable String id);
}