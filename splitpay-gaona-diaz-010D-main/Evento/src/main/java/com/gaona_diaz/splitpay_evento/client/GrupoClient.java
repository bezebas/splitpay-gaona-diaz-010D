package com.gaona_diaz.splitpay_evento.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "grupo-service", url = "http://localhost:8068")
public interface GrupoClient {

    @GetMapping("/grupos/{id}")
    Object obtenerGrupo(@PathVariable String id);
}