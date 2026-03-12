package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.ProductoRequestDTO;
import com.s1.gestion_bodegas.dto.response.ProductoResponseDTO;

import java.util.List;
public interface ProductoService {
    ProductoResponseDTO guardarProducto(ProductoRequestDTO dto);

    ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id);
    void eliminarProducto(Long id);
    List<ProductoResponseDTO> buscarTodos();
    List<ProductoResponseDTO> buscarProductoStockBajo(Integer Stock);
}
