-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cuadrangular
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cuadrangular
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cuadrangular` DEFAULT CHARACTER SET utf8 ;
USE `cuadrangular` ;

-- -----------------------------------------------------
-- Table `cuadrangular`.`equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cuadrangular`.`equipo` (
  `idequipo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NULL,
  `dirTecnico` VARCHAR(40) NULL,
  `jugadores` INT NULL,
  PRIMARY KEY (`idequipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cuadrangular`.`partido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cuadrangular`.`partido` (
  `idpartidos` INT NOT NULL,
  `golesFavor` INT NULL,
  `golesContra` INT NULL,
  `ronda` INT NULL,
  `idequipo` INT NULL,
  PRIMARY KEY (`idpartidos`),
  INDEX `idequipo_idx` (`idequipo` ASC) VISIBLE,
  CONSTRAINT `idequipo`
    FOREIGN KEY (`idequipo`)
    REFERENCES `cuadrangular`.`equipo` (`idequipo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
