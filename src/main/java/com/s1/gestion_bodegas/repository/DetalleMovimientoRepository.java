package com.s1.gestion_bodegas.repository;

import com.s1.gestion_bodegas.model.Detalle_movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleMovimientoRepository extends JpaRepository<Detalle_movimiento, Long> {
    List<Detalle_movimiento> findByCantidadLessThan(Integer cantidad);
}
