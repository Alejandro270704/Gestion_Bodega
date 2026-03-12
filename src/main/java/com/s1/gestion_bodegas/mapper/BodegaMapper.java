package com.s1.gestion_bodegas.mapper;

import com.s1.gestion_bodegas.dto.request.BodegaRequestDTO;
import com.s1.gestion_bodegas.dto.response.BodegaResponseDTO;
import com.s1.gestion_bodegas.dto.response.EmpleadoResponseDTO;
import com.s1.gestion_bodegas.model.Bodega;
import com.s1.gestion_bodegas.model.Empleado;
import org.springframework.stereotype.Component;

@Component
public class BodegaMapper {
    public BodegaResponseDTO entidadADTO(Bodega bodega,EmpleadoResponseDTO dto) {
        if (bodega == null  || dto==null) return null;
        return new BodegaResponseDTO(
                bodega.getId(),
                bodega.getNombre(),
                bodega.getUbicacion(),
                bodega.getCapacidad(),
                dto
        );
    }

    public Bodega DTOAEntidad(BodegaRequestDTO dto ,Empleado empleado) {
        if (dto == null) return null;
        Bodega b = new Bodega() ;
        b.setNombre(dto.nombre());
        b.setUbicacion(dto.ubicacion());
        b.setCapacidad(dto.capacidad());
        b.setEmpleado(empleado);

        return b;
    }

    public void actualizarEntidadDesdeDTO(Bodega bodega ,BodegaRequestDTO dto ,Empleado empleado) {
        if (bodega == null || dto==null ) return;
        bodega.setNombre(dto.nombre());
        bodega.setUbicacion(dto.ubicacion());
        bodega.setCapacidad(dto.capacidad());
        bodega.setEmpleado(empleado);

    }
}
