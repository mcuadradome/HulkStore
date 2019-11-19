
  
  CREATE TABLE producto (
  codProducto INT NOT NULL IDENTITY PRIMARY KEY,
  nombre varchar(50) NOT NULL,
  descripcion varchar(100) null,
  precio int);

  CREATE TABLE ingresoproductos (
  cod_ingreso INT NOT NULL IDENTITY PRIMARY KEY,
  proveedor varchar(40) NOT NULL,
  producto_fk int NOT NULL,
  cantidad int NOT NULL,
  fecha datetime NOT NULL
  FOREIGN KEY (producto_fk) REFERENCES producto (codProducto)  ON DELETE CASCADE);

CREATE TABLE salidaproductos (
  codVenta INT NOT NULL IDENTITY PRIMARY KEY,
  cliente varchar(25) NOT NULL,
  producto_fk int NOT NULL,
  cantidad int NOT NULL,
  fecha datetime NOT NULL
  FOREIGN KEY (producto_fk) REFERENCES producto (codProducto)  ON DELETE CASCADE);

	INSERT INTO producto (codProducto, nombre, descripcion, precio) VALUES
(1, 'Vaso pequeño', NULL, 2500),
(2, 'camisa superman XL', NULL, 10000),
(3, 'vaso 10 OZ batman', NULL, 2000);

INSERT INTO ingresoproductos (cod_ingreso, proveedor, usuario_fk, producto_fk, cantidad, fecha) VALUES
(1, 'vasos JJ', '1233491816', 1, 30, '2019-11-08 01:03:04');

INSERT INTO salidaproductos (codVenta, cliente, productoFK, cantidad, fecha) VALUES
 (1,'marios vasquez', 1, 10, '2019-11-08 04:04:06');
