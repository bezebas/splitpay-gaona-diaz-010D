package com.gaona_diaz.splitpay_grupo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaona_diaz.splitpay_grupo.model.MiembroGrupo;
import com.gaona_diaz.splitpay_grupo.repository.MiembroGrupoRepository;




@Service

public class MiembroGrupoService {



    @Autowired

    private MiembroGrupoRepository miembroGrupoRepository;



    public List<MiembroGrupo> listarMiembros() {

        return miembroGrupoRepository.findAll();

    }



    public MiembroGrupo guardarMiembro(MiembroGrupo miembroGrupo) {

        return miembroGrupoRepository.save(miembroGrupo);

    }



    public List<MiembroGrupo> obtenerMiembrosPorGrupo(String grupoId) {

        return miembroGrupoRepository.findByGrupoId(grupoId);

    }



    public List<MiembroGrupo> obtenerGruposPorUsuario(String usuarioId) {

        return miembroGrupoRepository.findByUsuarioId(usuarioId);

    }



    public void eliminarMiembro(String id) {

        miembroGrupoRepository.deleteById(id);

    }
}