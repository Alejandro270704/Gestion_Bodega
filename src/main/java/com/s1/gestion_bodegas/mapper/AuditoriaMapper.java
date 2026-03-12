package com.s1.gestion_bodegas.mapper;

import com.s1.gestion_bodegas.dto.request.AuditoriaRequestDTO;
import com.s1.gestion_bodegas.dto.request.DetalleMovimientoRequestDTO;
import com.s1.gestion_bodegas.dto.response.*;
import com.s1.gestion_bodegas.model.*;
import org.springframework.stereotype.Component;

@Component
public class AuditoriaMapper {
    public AuditoriaResponseDTO entidadADTO(Auditoria auditoria, EmpleadoResponseDTO empleadodto) {
        if (auditoria == null  || empleadodto==null) return null;
        return new AuditoriaResponseDTO(
                auditoria.getId(),
                auditoria.getFecha().toString(),
                empleadodto,
                auditoria.getTabla_afectada(),
                auditoria.getTabla_antigua(),
                auditoria.getTabla_nueva()

        );
    }

    public Auditoria DTOAEntidad(AuditoriaRequestDTO dto , Empleado empleado) {
        if (dto == null|| empleado== null) return null;
        Auditoria m= new Auditoria() ;
        m.setFecha(dto.fecha());
        m.setEmpleado(empleado);
        m.setTabla_afectada(dto.tabla_antigua());
        m.setTabla_antigua(dto.tabla_antigua());
        m.setTabla_nueva(dto.tabla_nueva());
        return m;
    }

    public void actualizarEntidadDesdeDTO(Auditoria auditoria ,AuditoriaRequestDTO dto ,Empleado empleado) {
        if (auditoria == null || dto== null||empleado== null) return;
        auditoria.setFecha(dto.fecha());
        auditoria.setEmpleado(empleado);
        auditoria.setTabla_afectada(dto.tabla_afectada());
        auditoria.setTabla_antigua(dto.tabla_antigua());
        auditoria.setTabla_nueva(dto.tabla_nueva());
    }
}
