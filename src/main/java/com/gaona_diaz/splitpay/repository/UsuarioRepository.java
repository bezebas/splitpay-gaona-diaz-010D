package com.gaona_diaz.splitpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaona_diaz.splitpay.model.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, String>{

    
    //Usuario findById (String id);

    Usuario findByCorreo(String correo);
}
