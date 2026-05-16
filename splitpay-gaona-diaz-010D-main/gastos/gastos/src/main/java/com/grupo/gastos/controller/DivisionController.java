package com.grupo.gastos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.gastos.model.DivisionGasto;
import com.grupo.gastos.service.DivisionService;

import java.util.List;

@RestController
@RequestMapping("/divisiones")
public class DivisionController {

    @Autowired
    private DivisionService service;

    @PostMapping
    public DivisionGasto guardar(@RequestBody DivisionGasto d) {
        return service.guardar(d);
    }

    @GetMapping("/gasto/{gastoId}")
    public List<DivisionGasto> porGasto(@PathVariable String gastoId) {
        return service.porGasto(gastoId);
    }
}