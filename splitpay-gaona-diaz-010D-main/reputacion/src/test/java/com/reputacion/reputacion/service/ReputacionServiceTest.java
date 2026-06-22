package com.reputacion.reputacion.service;

import com.reputacion.reputacion.model.Reputacion;
import com.reputacion.reputacion.repository.ReputacionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ReputacionServiceTest {

    @Mock
    private ReputacionRepository repository;

    @InjectMocks
    private ReputacionService service;

    @Test
    public void testCrearReputacion_Exitoso() {
        
        Reputacion mockRep = new Reputacion();
        mockRep.setUsuarioId("usr-100");
        mockRep.setPuntaje(95);
        mockRep.setNivel("EXCELENTE");

        Mockito.when(repository.save(any(Reputacion.class))).thenReturn(mockRep);

       
        Reputacion resultado = service.crear(mockRep);

       
        assertNotNull(resultado);
        assertEquals(95, resultado.getPuntaje());
        Mockito.verify(repository, Mockito.times(1)).save(mockRep);
    }

    @Test
    public void testBuscarPorId_NoEncontrado_LanzaExcepcion() {
        
        String idFalso = "id-inexistente";
        Mockito.when(repository.findById(idFalso)).thenReturn(Optional.empty());

        
        assertThrows(RuntimeException.class, () -> {
            service.buscarPorId(idFalso);
        });
        Mockito.verify(repository, Mockito.times(1)).findById(idFalso);
    }
}