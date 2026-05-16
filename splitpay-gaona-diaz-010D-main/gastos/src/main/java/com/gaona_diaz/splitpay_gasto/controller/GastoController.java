package com.gaona_diaz.splitpay_gasto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaona_diaz.splitpay_gasto.model.Gasto;
import com.gaona_diaz.splitpay_gasto.service.GastoService;

import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoService service;

    @PostMapping
    public Gasto guardar(@RequestBody Gasto gasto) {
        return service.guardar(gasto);
    }

    @GetMapping
    public List<Gasto> listar() {
        return service.listar();
    }

    @GetMapping("/evento/{eventoId}")
    public List<Gasto> porEvento(@PathVariable String eventoId) {
        return service.porEvento(eventoId);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}
