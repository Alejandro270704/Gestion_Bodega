package com.s1.gestion_bodegas.controller;

import com.s1.gestion_bodegas.dto.request.DetalleMovimientoRequestDTO;
import com.s1.gestion_bodegas.dto.response.DetalleMovimientoResponseDTO;
import com.s1.gestion_bodegas.service.impl.DetalleMovimientoServiceImpl;
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
@RequestMapping("/api/DetalleMovimiento")
@RequiredArgsConstructor
@Validated
@Tag(name="DetalleMovimiento", description = "esta api procesa toda la relacion de DetalleMovimiento")
public class gestionDetalleMovimiento {
    private final DetalleMovimientoServiceImpl detalleMovimientoService;
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "DetalleMovimiento creado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "guardar un DetalleMovimiento",description = "permite guardar un DetalleMovimiento añadiendo como endpoint (POST)")
    public ResponseEntity<DetalleMovimientoResponseDTO> guardar(@Valid @RequestBody DetalleMovimientoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleMovimientoService.guardarDetalleMovimiento(dto));
    }
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "DetalleMovimiento actualizado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "actualizar un DetalleMovimiento",description = "permite actualizar un DetalleMovimiento , añadiendo como endpoint (PUT)")
    public ResponseEntity<DetalleMovimientoResponseDTO> actualizar (@Valid @Parameter(description = "ID de el movimiento a actualizar",example = "1") @RequestBody DetalleMovimientoRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(detalleMovimientoService.actualizarDetalleMovimiento(dto, id));
    }
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "DetalleMovimiento obtenidos exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "Lista todos los DetalleMovimiento",description = "permite listar todos los DetalleMovimiento añadiendo como endpoint (GET)")
    @Valid
    public ResponseEntity<List<DetalleMovimientoResponseDTO>> ListarTodoProducto(){
        return ResponseEntity.ok().body(detalleMovimientoService.buscarTodos());
    }
    @DeleteMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "DetalleMovimiento eliminado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "eliminar un DetalleMovimiento",description = "permite eliminar un DetalleMovimiento ,añadiendo como endpoint (DELETE)")
    public ResponseEntity<Void> eliminar(@Valid @Parameter(description = "ID de el DetalleMovimiento a eliminar",example = "1") @PathVariable Long id){
        detalleMovimientoService.eliminarDetalleMovimiento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
