package com.s1.gestion_bodegas.service.impl;

import com.s1.gestion_bodegas.dto.request.ProductoRequestDTO;
import com.s1.gestion_bodegas.dto.response.ProductoResponseDTO;
import com.s1.gestion_bodegas.mapper.ProductoMapper;
import com.s1.gestion_bodegas.model.Producto;
import com.s1.gestion_bodegas.repository.ProductoRepository;
import com.s1.gestion_bodegas.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final  ProductoRepository ProductoRepository;
    private final  ProductoMapper   ProductoMapper;
    @Override
    public ProductoResponseDTO guardarProducto(ProductoRequestDTO dto) {
        Producto p= ProductoMapper.DTOAEntidad(dto);
        Producto p_insertada= ProductoRepository.save(p);
        return ProductoMapper.entidadADTO(p_insertada);
    }

    @Override
    public ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id) {
        Producto p=ProductoRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicho producto"));
        ProductoMapper.actualizarEntidadDesdeDTO(p,dto);
        Producto p_actualizada=ProductoRepository.save(p);
        return ProductoMapper.entidadADTO(p_actualizada);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto p=ProductoRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicho producto"));
        ProductoRepository.delete(p);
    }

    @Override
    public List<ProductoResponseDTO> buscarTodos() {
        List<Producto> productos= ProductoRepository.findAll();
        return productos.stream().map(ProductoMapper::entidadADTO).toList();
    }

    @Override
    public List<ProductoResponseDTO> buscarProductoStockBajo(Integer Stock) {
        List<Producto> productos= ProductoRepository.findByStockLessThan(Stock);
        return productos.stream().map(ProductoMapper::entidadADTO).toList();
    }
}
