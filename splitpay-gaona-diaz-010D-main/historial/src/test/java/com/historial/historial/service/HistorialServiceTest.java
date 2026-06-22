package com.historial.historial.service;

import com.historial.historial.model.Historial;
import com.historial.historial.repository.HistorialRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class HistorialServiceTest {

    @Mock
    private HistorialRepository repository;

    @InjectMocks
    private HistorialService service;

    // 🔹 1. Test registrar (POST)
    @Test
    public void testRegistrar_Exitoso() {
        Historial historial = new Historial();
        historial.setUsuarioId("usr-1");
        historial.setAccion("CREAR_EVENTO");

        Mockito.when(repository.save(any(Historial.class))).thenReturn(historial);

        Historial resultado = service.registrar(historial);

        assertNotNull(resultado);
        assertEquals("usr-1", resultado.getUsuarioId());

        Mockito.verify(repository).save(any(Historial.class));
    }

    // 🔹 2. Test buscarPorUsuario (GET lista)
    @Test
    public void testBuscarPorUsuario_Exitoso() {
        String usuarioId = "usr-1";

        Historial h1 = new Historial();
        h1.setUsuarioId(usuarioId);

        Historial h2 = new Historial();
        h2.setUsuarioId(usuarioId);

        Mockito.when(repository.findByUsuarioId(usuarioId))
                .thenReturn(List.of(h1, h2));

        List<Historial> resultado = service.buscarPorUsuario(usuarioId);

        assertNotNull(resultado);
        assertEquals(2, resultado.size());

        Mockito.verify(repository).findByUsuarioId(usuarioId);
    }

    // 🔹 3. Test buscarPorId (caso exitoso)
    @Test
    public void testBuscarPorId_Encontrado() {
        String id = "hist-1";

        Historial historial = new Historial();
        historial.setId(id);
        historial.setUsuarioId("usr-1");

        Mockito.when(repository.findById(id))
                .thenReturn(Optional.of(historial));

        Historial resultado = service.buscarPorId(id);

        assertNotNull(resultado);
        assertEquals(id, resultado.getId());

        Mockito.verify(repository).findById(id);
    }

    // 🔹 4. Test buscarPorId (no encontrado)
    @Test
    public void testBuscarPorId_NoEncontrado() {
        String id = "no-existe";

        Mockito.when(repository.findById(id))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.buscarPorId(id);
        });

        assertTrue(exception.getMessage().contains("Registro no encontrado"));

        Mockito.verify(repository).findById(id);
    }
}