package com.splitpay.pagos.Services;

import com.splitpay.pagos.model.Pagos;
import com.splitpay.pagos.repository.RepositoryPagos;
import com.splitpay.pagos.services.ServicesPagos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServicesPagosTest {

    @Mock
    private RepositoryPagos repo;

    @InjectMocks
    private ServicesPagos service;

    @Test
    void deberiaRegistrarPago() {

        Pagos pago = new Pagos();

        when(repo.save(pago)).thenReturn(pago);

        Pagos resultado = service.registrarPago(pago);

        assertNotNull(resultado);
        verify(repo).save(pago);
    }

    @Test
    void deberiaObtenerPagosPorEvento() {

        Pagos pago = new Pagos();

        List<Pagos> pagos = List.of(pago);

        when(repo.findByEventoId("evento1"))
                .thenReturn(pagos);

        List<Pagos> resultado =
                service.obtenerPorEvento("evento1");

        assertEquals(1, resultado.size());
        verify(repo).findByEventoId("evento1");
    }
}