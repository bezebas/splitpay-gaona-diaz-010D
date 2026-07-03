package com.splitpay.notificaciones.service;

import com.splitpay.notificaciones.model.Notificaciones;
import com.splitpay.notificaciones.repository.RepositoryNotificaciones;
import com.splitpay.notificaciones.services.ServicesNotificaciones;

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
public class ServicesNotificacionesTest {

    @Mock
    private RepositoryNotificaciones repository;

    @InjectMocks
    private ServicesNotificaciones service;

    // 🔹 1. Test guardar
    @Test
    public void testGuardar_Exitoso() {
        Notificaciones notif = new Notificaciones();
        notif.setUsuarioId("usr-1");
        notif.setLeida(false);

        Mockito.when(repository.save(any(Notificaciones.class))).thenReturn(notif);

        Notificaciones resultado = service.guardar(notif);

        assertNotNull(resultado);
        assertEquals("usr-1", resultado.getUsuarioId());

        Mockito.verify(repository).save(any(Notificaciones.class));
    }

    // 🔹 2. Test listarPorUsuario
    @Test
    public void testListarPorUsuario_Exitoso() {
        String uid = "usr-1";

        Notificaciones n1 = new Notificaciones();
        n1.setUsuarioId(uid);

        Notificaciones n2 = new Notificaciones();
        n2.setUsuarioId(uid);

        Mockito.when(repository.findByUsuarioIdOrderByCreadoEnDesc(uid))
                .thenReturn(List.of(n1, n2));

        List<Notificaciones> resultado = service.listarPorUsuario(uid);

        assertNotNull(resultado);
        assertEquals(2, resultado.size());

        Mockito.verify(repository).findByUsuarioIdOrderByCreadoEnDesc(uid);
    }

    // 🔹 3. Test marcarLeida (exitoso)
    @Test
    public void testMarcarLeida_Exitoso() {
        String id = "notif-1";

        Notificaciones notif = new Notificaciones();
        notif.setId(id);
        notif.setLeida(false);

        Mockito.when(repository.findById(id))
                .thenReturn(Optional.of(notif));

        Mockito.when(repository.save(any(Notificaciones.class)))
                .thenReturn(notif);

        Notificaciones resultado = service.marcarLeida(id);

        assertNotNull(resultado);
        assertTrue(resultado.getLeida());

        Mockito.verify(repository).findById(id);
        Mockito.verify(repository).save(any(Notificaciones.class));
    }

    // 🔹 4. Test marcarLeida (no encontrado)
    @Test
    public void testMarcarLeida_NoEncontrado() {
        String id = "no-existe";

        Mockito.when(repository.findById(id))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.marcarLeida(id);
        });

        assertTrue(exception.getMessage().contains("No encontrada"));

        Mockito.verify(repository).findById(id);
    }
}