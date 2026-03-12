package com.s1.gestion_bodegas.mapper;

import com.s1.gestion_bodegas.dto.request.EmpleadoRequestDTO;
import com.s1.gestion_bodegas.dto.response.EmpleadoResponseDTO;
import com.s1.gestion_bodegas.dto.response.PersonaResponseDTO;
import com.s1.gestion_bodegas.model.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {
    public EmpleadoResponseDTO entidadADTO(PersonaResponseDTO personaDTO,Empleado empleado) {
        if (personaDTO == null || empleado==null) return null;
        return new EmpleadoResponseDTO(
                personaDTO,
                empleado.getRol().name()
        );
    }

    public Empleado DTOAEntidad(EmpleadoRequestDTO dto) {
        if (dto == null) return null;
        Empleado e = new Empleado() ;
        e.setId(dto.id());
        e.setRol(dto.rol());
        return e;
    }

    public void actualizarEntidadDesdeDTO(Empleado empleado ,EmpleadoRequestDTO dto) {
        if (empleado == null || dto==null ) return;
        empleado.setRol(dto.rol());

    }
}
