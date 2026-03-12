package com.s1.gestion_bodegas.mapper;

import com.s1.gestion_bodegas.dto.request.ProductoRequestDTO;
import com.s1.gestion_bodegas.dto.response.ProductoResponseDTO;
import com.s1.gestion_bodegas.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public ProductoResponseDTO entidadADTO(Producto producto) {
        if (producto == null) return null;
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getStock(),
                producto.getCategoria(),
                producto.getPrecio()
        );
    }

    public Producto DTOAEntidad(ProductoRequestDTO dto) {
        if (dto == null) return null;
        Producto p = new Producto();
        p.setNombre(dto.nombre());
        p.setStock(dto.stock());
        p.setCategoria(dto.categoria());
        p.setPrecio(dto.precio());
        return p;
    }

    public void actualizarEntidadDesdeDTO(Producto producto, ProductoRequestDTO dto) {
        if (producto == null || dto == null) return;
        producto.setNombre(dto.nombre());
        producto.setStock(dto.stock());
        producto.setCategoria(dto.categoria());
        producto.setPrecio(dto.precio());

    }
}
