package com.s1.gestion_bodegas.repository;

import com.s1.gestion_bodegas.model.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    List<Auditoria> findByFechaBetween(Timestamp fechaInicio, Timestamp fechaFin);
}
