package com.s1.gestion_bodegas.controller;


import com.s1.gestion_bodegas.dto.request.BodegaRequestDTO;
import com.s1.gestion_bodegas.dto.response.BodegaResponseDTO;
import com.s1.gestion_bodegas.service.impl.BodegaServiceImpl;
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
@RequestMapping("/api/bodega")
@RequiredArgsConstructor
@Validated
@Tag(name="bodega", description = "esta api procesa toda la relacion de bodega")
public class gestionBodega {
    private final BodegaServiceImpl bodegaService;
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "bodega creado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "guardar un bodega",description = "permite guardar una bodega añadiendo como endpoint (POST)")
    public ResponseEntity<BodegaResponseDTO> guardar(@Valid @RequestBody BodegaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bodegaService.guardarBodega(dto));
    }
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "bodega actualizado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "actualizar un bodega",description = "permite actualizar una bodega , añadiendo como endpoint (PUT)")
    public ResponseEntity<BodegaResponseDTO> actualizar (@Valid @Parameter(description = "ID de el bodega a actualizar",example = "1") @RequestBody BodegaRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(bodegaService.actualizarBodega(dto, id));
    }
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "bodega obtenidos exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "Lista todas las bodega",description = "permite listar todas las bodega añadiendo como endpoint (GET)")
    @Valid
    public ResponseEntity<List<BodegaResponseDTO>> ListarTodo(){
        return ResponseEntity.ok().body(bodegaService.buscarTodos());
    }
    @DeleteMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "bodega eliminado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "eliminar una bodega",description = "permite eliminar una bodega ,añadiendo como endpoint (DELETE)")
    public ResponseEntity<Void> eliminarBodega(@Valid @Parameter(description = "ID de la bodega a eliminar",example = "1") @PathVariable Long id){
        bodegaService.eliminarBodega(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}


