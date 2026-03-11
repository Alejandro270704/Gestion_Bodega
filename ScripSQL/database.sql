CREATE Database gestion_bodega ;
USE gestion_bodega;
CREATE TABLE producto (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    stock INTEGER NOT NULL,
    categoria varchar(255) not null,
    precio DOUBLE NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE persona (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    identificacion VARCHAR(255) UNIQUE NOT NULL,
    PRIMARY KEY (id)

)
CREATE TABLE cliente(
    id BIGINT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES persona(id)
)
CREATE TABLE empleado(
    id BIGINT NOT NULL AUTO_INCREMENT,
    rol enum('empleado','administrador'),
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES persona(id)
)
CREATE TABLE bodega(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    ubicacion VARCHAR(255) NOT NULL,
    capacidad BIGINT NOT NULL ,
    id_empleado BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_empleado) REFERENCES empleado(id),
)
CREATE TABLE movimiento(
    id BIGINT NOT NULL AUTO_INCREMENT,
    fecha TIMESTAMP,
    tipo_de_movimiento enum('ENTRADA','SALIDA','TRANSFERENCIA'),
    id_empleado BIGINT NOT NULL,
    id_bodega_origen BIGINT NOT NULL,
    id_bodega_destino BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_empleado) REFERENCES empleado(id),
    FOREIGN KEY (id_bodega_origen) REFERENCES bodega(id),
    FOREIGN KEY (id_bodega_destino)REFERENCES bodega(id)
    

)
Create TABLE detalle_movimiento(
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_movimiento BIGINT NOT NULL ,
    id_producto BIGINT NOT NULL,
    cantidad int ,
    PRIMARY KEY (id),
    FOREIGN KEY (id_producto) REFERENCES producto(id),
    FOREIGN KEY (id_movimiento) REFERENCES movimiento(id)



)
CREATE TABLE auditoria(
    id BIGINT NOT NULL AUTO_INCREMENT,
    tipo_de_operacion enum('INSERT','UPDATE','DELETE'),
    fecha TIMESTAMP,
    id_empleado BIGINT NOT NULL,
    tabla_afectada varchar(255) NOT NULL,
    tabla_antigua varchar(255) NOT NULL,
    tabla_nueva varchar(255) NOT NULL
    PRIMARY KEY (id),
    FOREIGN KEY (id_empleado) REFERENCES empleado(id)

)