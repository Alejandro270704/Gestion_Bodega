package com.s1.gestion_bodegas.controller;

import com.s1.gestion_bodegas.dto.request.MovimientoRequestDTO;
import com.s1.gestion_bodegas.dto.response.MovimientoResponseDTO;
import com.s1.gestion_bodegas.service.impl.MovimientoServiceImpl;
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
@RequestMapping("/api/movimiento")
@RequiredArgsConstructor
@Validated
@Tag(name="movimiento", description = "esta api procesa toda la relacion de movimiento")
public class gestionMovimiento {
    private final MovimientoServiceImpl movimientoService;
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "movimiento creado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "guardar un movimiento",description = "permite guardar un movimiento añadiendo como endpoint (POST)")
    public ResponseEntity<MovimientoResponseDTO> guardar(@Valid @RequestBody MovimientoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(movimientoService.guardarMovimiento(dto));
    }
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "movimiento actualizado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "actualizar un movimiento",description = "permite actualizar un movimiento , añadiendo como endpoint (PUT)")
    public ResponseEntity<MovimientoResponseDTO> actualizar (@Valid @Parameter(description = "ID de el movimiento a actualizar",example = "1") @RequestBody MovimientoRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(movimientoService.actualizarMovimiento(dto, id));
    }
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "movimiento obtenidos exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "Lista todos los movimiento",description = "permite listar todos los movimiento añadiendo como endpoint (GET)")
    @Valid
    public ResponseEntity<List<MovimientoResponseDTO>> ListarTodoProducto(){
        return ResponseEntity.ok().body(movimientoService.buscarTodos());
    }
    @DeleteMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "movimiento eliminado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "eliminar un movimiento",description = "permite eliminar un movimiento ,añadiendo como endpoint (DELETE)")
    public ResponseEntity<Void> eliminar(@Valid @Parameter(description = "ID de el movimiento a eliminar",example = "1") @PathVariable Long id){
        movimientoService.eliminarMovimiento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
