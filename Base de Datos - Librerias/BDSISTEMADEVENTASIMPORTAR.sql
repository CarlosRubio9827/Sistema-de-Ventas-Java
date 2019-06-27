-- MySQL Script generated by MySQL Workbench
-- Thu Jun 27 02:41:28 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bdcontroldeventas
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bdcontroldeventas` ;

-- -----------------------------------------------------
-- Schema bdcontroldeventas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdcontroldeventas` DEFAULT CHARACTER SET utf8 ;
USE `bdcontroldeventas` ;

-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`categoria` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`categoria` (
  `nombre_categoria` VARCHAR(450) NOT NULL,
  `cod_categoria` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion_categoria` VARCHAR(450) NOT NULL,
  PRIMARY KEY (`cod_categoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`persona` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`persona` (
  `cod_persona` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_persona` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  `telefono` VARCHAR(12) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `contacto` VARCHAR(20) NULL DEFAULT NULL,
  `cel_contacto` VARCHAR(10) NULL DEFAULT NULL,
  `correo_contacto` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`cod_persona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`cliente` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`cliente` (
  `cod_cliente` INT(11) NOT NULL,
  `rut_cliente` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`cod_cliente`),
  CONSTRAINT `cliente_personaFK`
    FOREIGN KEY (`cod_cliente`)
    REFERENCES `bdcontroldeventas`.`persona` (`cod_persona`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`producto` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`producto` (
  `cod_producto` BIGINT(20) NOT NULL,
  `nombre_producto` VARCHAR(255) NOT NULL,
  `descripcion_producto` VARCHAR(255) NULL DEFAULT NULL,
  `precio_producto` BIGINT(20) NOT NULL,
  `precio_compra` BIGINT(20) NOT NULL,
  `stock_producto` INT(11) NOT NULL,
  `cod_categoriaFK` INT(11) NOT NULL,
  PRIMARY KEY (`cod_producto`, `cod_categoriaFK`),
  INDEX `cod_cat_prodFK_idx` (`cod_categoriaFK` ASC),
  CONSTRAINT `cod_cat_prodFK`
    FOREIGN KEY (`cod_categoriaFK`)
    REFERENCES `bdcontroldeventas`.`categoria` (`cod_categoria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`usuario` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`usuario` (
  `cod_usuario` INT(11) NOT NULL,
  `rut_usuario` VARCHAR(20) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(8) NOT NULL,
  `acceso` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`cod_usuario`),
  CONSTRAINT `usuario_personaFK`
    FOREIGN KEY (`cod_usuario`)
    REFERENCES `bdcontroldeventas`.`persona` (`cod_persona`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`venta` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`venta` (
  `cod_venta` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_venta` DATE NOT NULL,
  `total_venta` BIGINT(20) NOT NULL,
  `cod_usuarioFK` INT(11) NOT NULL,
  `cod_clienteFK` INT(11) NOT NULL,
  `tipo_comprobante` VARCHAR(10) NOT NULL,
  `num_factura` BIGINT(20) NULL DEFAULT NULL,
  `pago` BIGINT(20) NOT NULL,
  `descuento` INT(11) NOT NULL,
  PRIMARY KEY (`cod_venta`),
  INDEX `venta_usuarioFK_idx` (`cod_usuarioFK` ASC),
  INDEX `venta_clienteFK_idx` (`cod_clienteFK` ASC),
  CONSTRAINT `venta_clienteFK`
    FOREIGN KEY (`cod_clienteFK`)
    REFERENCES `bdcontroldeventas`.`cliente` (`cod_cliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `venta_usuarioFK`
    FOREIGN KEY (`cod_usuarioFK`)
    REFERENCES `bdcontroldeventas`.`usuario` (`cod_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`detalle_venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`detalle_venta` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`detalle_venta` (
  `cod_detalle` INT(11) NOT NULL AUTO_INCREMENT,
  `cantidad_detalle` INT(11) NOT NULL,
  `cod_productoFK` BIGINT(20) NOT NULL,
  `precio_producto` BIGINT(20) NOT NULL,
  `cod_ventaFK` INT(11) NOT NULL,
  `subtotal` BIGINT(20) NOT NULL,
  `subPrecioCompra` BIGINT(20) NOT NULL,
  `precio_compra` BIGINT(20) NOT NULL,
  PRIMARY KEY (`cod_detalle`, `cod_ventaFK`),
  INDEX `detalle_productoFK_idx` (`cod_productoFK` ASC),
  INDEX `detalle_ventaFK_idx` (`cod_ventaFK` ASC),
  CONSTRAINT `detalle_productoFK`
    FOREIGN KEY (`cod_productoFK`)
    REFERENCES `bdcontroldeventas`.`producto` (`cod_producto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `detalle_ventaFK`
    FOREIGN KEY (`cod_ventaFK`)
    REFERENCES `bdcontroldeventas`.`venta` (`cod_venta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`historial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`historial` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`historial` (
  `cod_historial` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_productoFK1` BIGINT(20) NOT NULL,
  `cod_usuarioFK1` INT(11) NOT NULL,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  `referencia` VARCHAR(100) NULL DEFAULT NULL,
  `cantidad` INT(11) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`cod_historial`),
  INDEX `historial_productoFK_idx` (`cod_productoFK1` ASC),
  INDEX `historial_usuarioFK_idx` (`cod_usuarioFK1` ASC),
  CONSTRAINT `cod_productoFK1`
    FOREIGN KEY (`cod_productoFK1`)
    REFERENCES `bdcontroldeventas`.`producto` (`cod_producto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `cod_usuarioFK1`
    FOREIGN KEY (`cod_usuarioFK1`)
    REFERENCES `bdcontroldeventas`.`usuario` (`cod_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`productoescaneado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`productoescaneado` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`productoescaneado` (
  `cod_producto` BIGINT(20) NOT NULL,
  `nombre` VARCHAR(450) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  PRIMARY KEY (`cod_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`productostock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`productostock` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`productostock` (
  `cod_producto` BIGINT(20) NOT NULL,
  `nombre_producto` VARCHAR(450) NOT NULL,
  `descripcion_producto` VARCHAR(450) NULL DEFAULT NULL,
  `unidad_producto` VARCHAR(450) NULL DEFAULT NULL,
  `precio_producto` BIGINT(20) NOT NULL,
  `precio_compra` BIGINT(20) NOT NULL,
  `stock_producto` INT(11) NOT NULL,
  PRIMARY KEY (`cod_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcontroldeventas`.`proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdcontroldeventas`.`proveedor` ;

CREATE TABLE IF NOT EXISTS `bdcontroldeventas`.`proveedor` (
  `cod_proveedor` INT(11) NOT NULL,
  `rut_proveedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cod_proveedor`),
  CONSTRAINT `cod_proveedor`
    FOREIGN KEY (`cod_proveedor`)
    REFERENCES `bdcontroldeventas`.`persona` (`cod_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
