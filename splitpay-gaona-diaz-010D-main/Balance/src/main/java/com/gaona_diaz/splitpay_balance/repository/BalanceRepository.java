package com.gaona_diaz.splitpay_balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gaona_diaz.splitpay_balance.model.Balance;
import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, String> {
    List<Balance> findByEventoId(String eventoId);

}