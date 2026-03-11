package com.s1.gestion_bodegas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "auditoria")
@Getter
@Setter
@NoArgsConstructor
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Timestamp fecha;
    @Column(nullable = false)
    private Long id_empleado;
    @Column(nullable = false)
    private String tabla_afectada;
    @Column(nullable = false)
    private String tabla_antigua;
    @Column(nullable = false)
    private String tabla_nueva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;
}
