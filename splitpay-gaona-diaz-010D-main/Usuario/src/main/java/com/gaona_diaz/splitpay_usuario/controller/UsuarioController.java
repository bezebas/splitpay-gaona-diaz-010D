package com.gaona_diaz.splitpay_usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaona_diaz.splitpay_usuario.model.Usuario;
import com.gaona_diaz.splitpay_usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listaUsuarios();
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable String id) {

        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);

        if (usuario == null) {
            return ResponseEntity.notFound().build(); // 🔥 devuelve 404
        }

        return ResponseEntity.ok(usuario); // ✅ devuelve 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String id) {

        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build(); // 204
    }
}