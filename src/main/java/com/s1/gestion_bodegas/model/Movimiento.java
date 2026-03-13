package com.s1.gestion_bodegas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "movimiento")
@Getter
@Setter
@NoArgsConstructor
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Timestamp fecha;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimiento tipomovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bodega_origen", nullable = false)
    private  Bodega bodegaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bodega_destino", nullable = false)
    private  Bodega bodegaDestino;



    public enum TipoMovimiento {
        ENTRADA,
        SALIDA,
        TRANSFERENCIA
    }
}
