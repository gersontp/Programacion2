
DROP TABLE producto IF EXISTS;

CREATE TABLE producto (
  codigo  INTEGER IDENTITY PRIMARY KEY,
  nombre  VARCHAR(30),
  precio  DECIMAL(8,2),
  cantidad  INTEGER
);


DROP TABLE usuario IF EXISTS;

CREATE TABLE usuario (
  codigo  INTEGER IDENTITY PRIMARY KEY,
  stusuario  VARCHAR(30),
  clave  VARCHAR(30)
);


DROP TABLE persona IF EXISTS;

CREATE TABLE persona (
  codigo  INTEGER IDENTITY PRIMARY KEY,
  nombre  VARCHAR(30),
  apellido  VARCHAR(30),
  direccion VARCHAR(30),
  codigo_user INTEGER,
  FOREIGN KEY (codigo_user) REFERENCES Usuario(codigo)
);



