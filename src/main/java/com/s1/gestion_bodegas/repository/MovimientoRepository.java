package com.s1.gestion_bodegas.repository;

import com.s1.gestion_bodegas.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByFechaBetween(String fechaInicio, String fechaFin);
}
