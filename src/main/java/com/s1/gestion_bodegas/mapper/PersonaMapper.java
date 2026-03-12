package com.s1.gestion_bodegas.mapper;

import com.s1.gestion_bodegas.dto.request.PersonaRequestDTO;
import com.s1.gestion_bodegas.dto.response.PersonaResponseDTO;
import com.s1.gestion_bodegas.model.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {
    public PersonaResponseDTO entidadADTO(Persona persona) {
        if (persona == null) return null;
        return new PersonaResponseDTO(
                persona.getId(),
                persona.getNombre(),
                persona.getIdentificacion()
        );
    }

    public Persona DTOAEntidad(PersonaRequestDTO dto) {
        if (dto == null) return null;
        Persona p = new Persona();
        p.setNombre(dto.nombre());
        p.setIdentificacion(dto.identificacion());
        return p;
    }

    public void actualizarEntidadDesdeDTO(Persona persona, PersonaRequestDTO dto) {
        if (persona == null || dto == null) return;
        persona.setNombre(dto.nombre());
        persona.setIdentificacion(dto.identificacion());

    }
}
