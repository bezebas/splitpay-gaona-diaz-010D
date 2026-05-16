package com.gaona_diaz.splitpay_grupo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gaona_diaz.splitpay_grupo.model.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, String> {

}
