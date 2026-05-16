package com.gaona_diaz.splitpay_gasto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaona_diaz.splitpay_gasto.model.DivisionGasto;
import com.gaona_diaz.splitpay_gasto.service.DivisionGastoService;

import java.util.List;

@RestController
@RequestMapping("/divisiones")
public class DivisionGastoController {

    @Autowired
    private DivisionGastoService service;

    @PostMapping
    public DivisionGasto guardar(@RequestBody DivisionGasto d) {
        return service.guardar(d);
    }

    @GetMapping("/gasto/{gastoId}")
    public List<DivisionGasto> porGasto(@PathVariable String gastoId) {
        return service.porGasto(gastoId);
    }
}