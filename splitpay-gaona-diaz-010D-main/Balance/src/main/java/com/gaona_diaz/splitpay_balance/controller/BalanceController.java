package com.gaona_diaz.splitpay_balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaona_diaz.splitpay_balance.model.Balance;
import com.gaona_diaz.splitpay_balance.sevice.BalanceService;

import java.util.List;

@RestController
@RequestMapping("/balances")
public class BalanceController {

    @Autowired
    private BalanceService service;

    @PostMapping
    public Balance guardar(@RequestBody Balance b) {
        return service.guardar(b);
    }

    @GetMapping("/evento/{eventoId}")
    public List<Balance> listar(@PathVariable String eventoId) {
        return service.porEvento(eventoId);
    }

    @PutMapping("/{id}/pagar")
    public Balance pagar(@PathVariable String id) {
        return service.marcarPagado(id);
    }
}