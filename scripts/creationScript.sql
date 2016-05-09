-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-03-30 02:04:12.631


-- tables

-- table Cliente
CREATE TABLE `coswgr5`.`Cliente` (
    `Usuario_username` varchar(30) NOT NULL,
    `cedula` int NOT NULL,
    `cuenta` int NOT NULL,
    `nombre` varchar(40) NOT NULL,
    CONSTRAINT `Cliente_pk` PRIMARY KEY (`cedula`)
)ENGINE=InnoDB;



-- Table Pedido
CREATE TABLE `coswgr5`.`Pedido` (
    `id_pedido` int  NOT NULL AUTO_INCREMENT,
    `estado` char(10)  NOT NULL,
    `fecha_aprobacion` date  NOT NULL,
    `direccion` varchar(20)  NOT NULL,
    `precio` int  NOT NULL,
    CONSTRAINT `Pedido_pk` PRIMARY KEY (`id_pedido`)
)ENGINE=InnoDB;

-- Table PedidoPostreCantidad
CREATE TABLE `coswgr5`.`PedidoPostreCantidad` (
    `Postre_codigo_postre` varchar(10)  NOT NULL,
    `Postre_Reposteria_nit` varchar(15)  NOT NULL,
    `cantidad` int  NOT NULL,
    `Pedido_id_pedido` int  NOT NULL,
    CONSTRAINT `PedidoPostreCantidad_pk` PRIMARY KEY (`Postre_codigo_postre`,`Postre_Reposteria_nit`,`Pedido_id_pedido`)
)ENGINE=InnoDB;

-- Table Postre
CREATE TABLE `coswgr5`.`Postre` (
    `codigo_postre` varchar(10)  NOT NULL,
    `Reposteria_nit` varchar(15)  NOT NULL,
    `nombre` varchar(20)  NOT NULL,
    `precio` int  NOT NULL,
    `descripcion` varchar(80)  NOT NULL,
    `imagen` blob  NULL,
    CONSTRAINT `Postre_pk` PRIMARY KEY (`codigo_postre`,`Reposteria_nit`)
)ENGINE=InnoDB;
-- Table Usuario
CREATE TABLE `coswgr5`.`Usuario` (
    `username` varchar(30)  NOT NULL,
    `password` varchar(20)  NOT NULL,
    CONSTRAINT `Usuario_pk` PRIMARY KEY (`username`)
)ENGINE=InnoDB;
-- Table Reposteria
CREATE TABLE `coswgr5`.`Reposteria` (
    `nit` varchar(15)  NOT NULL,
    `nombre` varchar(20)  NOT NULL,
    `rango_cobertura` varchar(20)  NOT NULL,
    `Usuario_username` varchar(30)  NOT NULL,
    CONSTRAINT `Reposteria_pk` PRIMARY KEY (`nit`)
)ENGINE=InnoDB;





-- foreign keys
-- Reference:  PedidoPostreCantidad_Pedido (table: PedidoPostreCantidad)





ALTER TABLE `coswgr5`.`PedidoPostreCantidad` ADD CONSTRAINT `PedidoPostreCantidad_Pedido` FOREIGN KEY `PedidoPostreCantidad_Pedido` (`Pedido_id_pedido`)
    REFERENCES `coswgr5`.`Pedido` (`id_pedido`);

--cliente usuarioo
ALTER TABLE Cliente ADD CONSTRAINT Cliente_Usuario FOREIGN KEY Cliente_Usuario (Usuario_username)
    REFERENCES Usuario (username);


--pedido cliente

-- Reference: Pedido_Cliente (table: Pedido)
ALTER TABLE Pedido ADD CONSTRAINT Pedido_Cliente FOREIGN KEY Pedido_Cliente (Cliente_cedula)
    REFERENCES Cliente (cedula);

-- Reference:  PedidoPostreCantidad_Postre (table: PedidoPostreCantidad)

ALTER TABLE `coswgr5`.`PedidoPostreCantidad` ADD CONSTRAINT `PedidoPostreCantidad_Postre` FOREIGN KEY `PedidoPostreCantidad_Postre` (`Postre_codigo_postre`,`Postre_Reposteria_nit`)
    REFERENCES `coswgr5`.`Postre` (`codigo_postre`,`Reposteria_nit`);
-- Reference:  Postre_Reposteria (table: Postre)

ALTER TABLE `coswgr5`.`Postre` ADD CONSTRAINT `Postre_Reposteria` FOREIGN KEY `Postre_Reposteria` (`Reposteria_nit`)
    REFERENCES `coswgr5`.`Reposteria` (`nit`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


-- Reference:  Reposteria_Usuario (table: Reposteria)

ALTER TABLE `coswgr5`.`Reposteria` ADD CONSTRAINT `Reposteria_Usuario` FOREIGN KEY `Reposteria_Usuario` (`Usuario_username`)
    REFERENCES `coswgr5`.`Usuario` (`username`);

-- End of file.

insert into `coswgr5`.Usuario values('r1','pass1');

insert into `coswgr5`.Reposteria values('r1','reposteria','cobertura1','r1');
