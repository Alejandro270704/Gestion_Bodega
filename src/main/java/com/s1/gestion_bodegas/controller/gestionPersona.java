package com.s1.gestion_bodegas.controller;



import com.s1.gestion_bodegas.dto.request.PersonaRequestDTO;
import com.s1.gestion_bodegas.dto.response.PersonaResponseDTO;
import com.s1.gestion_bodegas.service.impl.PersonaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
@RequiredArgsConstructor
@Validated
@Tag(name="persona", description = "esta api procesa toda la relacion de persona")
public class gestionPersona {
    private final PersonaServiceImpl personaService;
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "persona creado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "guardar un persona",description = "permite guardar un persona añadiendo como endpoint (POST)")
    public ResponseEntity<PersonaResponseDTO> guardar(@Valid @RequestBody PersonaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.guardarPersona(dto));
    }
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "persona actualizado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "actualizar un persona",description = "permite actualizar un persona , añadiendo como endpoint (PUT)")
    public ResponseEntity<PersonaResponseDTO> actualizar (@Valid @Parameter(description = "ID de el persona a actualizar",example = "1") @RequestBody PersonaRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(personaService.actualizarPersona(dto, id));
    }
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "persona obtenidos exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "Lista todos las persona",description = "permite listar todas las persona añadiendo como endpoint (GET)")
    @Valid
    public ResponseEntity<List<PersonaResponseDTO>> ListarTodo(){
        return ResponseEntity.ok().body(personaService.buscarTodos());
    }
    @DeleteMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "persona eliminado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "eliminar un persona",description = "permite eliminar un persona ,añadiendo como endpoint (DELETE)")
    public ResponseEntity<Void> eliminarPersona(@Valid @Parameter(description = "ID de la persona a eliminar",example = "1") @PathVariable Long id){
        personaService.eliminarPersona(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

