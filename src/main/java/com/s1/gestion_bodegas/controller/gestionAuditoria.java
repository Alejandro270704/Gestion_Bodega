package com.s1.gestion_bodegas.controller;



import com.s1.gestion_bodegas.dto.request.AuditoriaRequestDTO;
import com.s1.gestion_bodegas.dto.response.AuditoriaResponseDTO;
import com.s1.gestion_bodegas.service.impl.AuditoriaServiceImpl;
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
@RequestMapping("/api/auditoria")
@RequiredArgsConstructor
@Validated
@Tag(name="auditoria", description = "esta api procesa toda la relacion de auditoria")
public class gestionAuditoria {
    private final AuditoriaServiceImpl auditoriaService;
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "auditoria creado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "guardar una auditoria",description = "permite guardar una auditoria añadiendo como endpoint (POST)")
    public ResponseEntity<AuditoriaResponseDTO> guardar(@Valid @RequestBody AuditoriaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(auditoriaService.guardarAuditoria(dto));
    }
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "auditoria actualizado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "actualizar un auditoria",description = "permite actualizar una auditoria , añadiendo como endpoint (PUT)")
    public ResponseEntity<AuditoriaResponseDTO> actualizar (@Valid @Parameter(description = "ID de el auditoria a actualizar",example = "1") @RequestBody AuditoriaRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(auditoriaService.actualizarAuditoria(dto, id));
    }
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "auditoria obtenidos exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "Lista todas las auditoria",description = "permite listar todas las auditoria añadiendo como endpoint (GET)")
    @Valid
    public ResponseEntity<List<AuditoriaResponseDTO>> ListarTodo(){
        return ResponseEntity.ok().body(auditoriaService.buscarTodos());
    }
    @DeleteMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "auditoria eliminado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "eliminar una auditoria",description = "permite eliminar una auditoria ,añadiendo como endpoint (DELETE)")
    public ResponseEntity<Void> eliminarAuditoria(@Valid @Parameter(description = "ID de la auditoria a eliminar",example = "1") @PathVariable Long id){
        auditoriaService.eliminarAuditoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}



