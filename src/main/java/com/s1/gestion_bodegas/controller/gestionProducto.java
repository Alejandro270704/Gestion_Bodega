package com.s1.gestion_bodegas.controller;


import com.s1.gestion_bodegas.dto.request.ProductoRequestDTO;
import com.s1.gestion_bodegas.dto.response.ProductoResponseDTO;
import com.s1.gestion_bodegas.service.impl.ProductoServiceImpl;
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
@RequestMapping("/api/producto")
@RequiredArgsConstructor
@Validated
@Tag(name="Producto", description = "esta api procesa toda la relacion de productos")
public class gestionProducto {
    private final ProductoServiceImpl ProductoService;
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "producto creado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "guardar un producto",description = "permite guardar un producto añadiendo como endpoint (POST)")
    public ResponseEntity<ProductoResponseDTO> guardar(@Valid @RequestBody ProductoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductoService.guardarProducto(dto));
    }
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "producto actualizado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "actualizar un producto",description = "permite actualizar un producto , añadiendo como endpoint (PUT)")
    public ResponseEntity<ProductoResponseDTO> actualizar (@Valid @Parameter(description = "ID de el producto a actualizar",example = "1") @RequestBody ProductoRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(ProductoService.actualizarProducto(dto, id));
    }
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "producto obtenidos exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "Lista todos los productos",description = "permite listar todos los productos añadiendo como endpoint (GET)")
    @Valid
    public ResponseEntity<List<ProductoResponseDTO>> ListarTodoProducto(){
        return ResponseEntity.ok().body(ProductoService.buscarTodos());
    }
    @DeleteMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "producto eliminado exitosamente"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"
                    )
            }
    )
    @Operation(summary = "eliminar un producto",description = "permite eliminar un producto ,añadiendo como endpoint (DELETE)")
    public ResponseEntity<Void> eliminarProducto(@Valid @Parameter(description = "ID de el producto a eliminar",example = "1") @PathVariable Long id){
        ProductoService.eliminarProducto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
