package com.gaona_diaz.splitpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaona_diaz.splitpay.model.Usuario;
import com.gaona_diaz.splitpay.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    
    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }
}
