create database examenFinal;
use examenFinal;
CREATE TABLE IF NOT EXISTS Cliente (
  Pkid varchar(15),
  nombre varchar(30),
  idTipo Varchar(15),
  apellido varchar(30),
  nit varchar (15),
  telefonon varchar(15),
  direccion varchar(50),
  correo varchar(50),
  estatus varchar(1),
  primary key(Pkid))
  ENGINE = InnoDB CHARACTER SET = latin1;
  
CREATE TABLE IF NOT EXISTS usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(60) NOT NULL,
  password VARCHAR(25)NOT NULL,
  PRIMARY KEY (id_usuario) )
ENGINE = InnoDB CHARACTER SET = latin1;
  