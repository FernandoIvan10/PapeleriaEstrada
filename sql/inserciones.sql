--Ejemplos de inserciones
insert into Proveedores values
('SCR01','Scribe'),
('SHA01','Sharpie'),
('PEL01','Pelikan'),
('VIN01','Vinci'),
('PAP01','Paper Mate'),
('CAS01','Casio'),
('PRI01','Pritt'),
('MAG01','Magistral'),
('BAC01','Baco'),
('DIX01','DIXON');

insert into Vendedores values
('ESM01','Esmeralda','Rodríguez','Coronado'),
('TRI01','Trinidad','Artega','Manzano'),
('VIC01','Víctor','Ruano','Cruz'),
('AND01','Andrés','Sánchez','Torres'),
('MAR01','Marina','Asunción','Portillo'),
('CES01','César','Delgadillo','Pérez'),
('ESM02','Esmeralda','Bernal','Rivera'),
('JES01','Jesús','Ramos','Carrillo'),
('MAR02','María','Ferreira','Bermudez'),
('TAM01','Tamara','Rojas','Villanueva');

insert into Productos values
('LAP01','Lapicero','Lapicero de punta fina en colores: negro, azul y rojo','Trazos',45,3.50),
('LAP02','Lápiz','Lápiz de grafito con una pequeña goma integrada','Trazos',30,3.00),
('HOJ01','Hoja blanca','Hoja A4 color blanco','Papel',200,0.25),
('HOJ02','Hojas de colores','Hoja A4 en color: verde, amarillo, rosado, azul, negro, anaranjado o morado','Papel',150,1.00),
('CAJ01','Caja de colores','Caja que contiene 12 lápices de colores comunes','Pintura',15,30.00),
('PIN01','Pintura Vinci','Botecito de pintura Vinci color: negro, azul, rosa o verde','Pintura',50,10.00),
('GOM01','Goma','Goma blanca removedora de lápiz','Borrador',37,2.50),
('COR01','Corrector','Lápiz corrector','Borrador',15,18.00),
('COM01','Compás','Compás metalico de 12,5 cm de longitud','Trazos',10,15.00),
('CAL01','Calculadora científica','Calculadora científica Casio','Cálculos',10,280.00);

insert into Compras(id_proveedor,fecha) values
('SCR01','28/02/2022'),
('SHA01','28/02/2022'),
('PEL01','28/02/2022'),
('VIN01','28/02/2022'),
('PAP01','28/02/2022'),
('CAS01','28/02/2022'),
('PRI01','28/02/2022'),
('MAG01','28/02/2022'),
('BAC01','28/02/2022'),
('DIX01','28/02/2022');

insert into Compras(id_proveedor,fecha) values
('DIX01','02/03/2022');

insert into DetalleXCompra values
(1,'HOJ01',100,0.20,20.00),
(5,'LAP01',20,2.00,40.00),
(9,'LAP02',30,1.50,45.00),
(1,'HOJ02',50,0.25,12.50),
(5,'CAJ01',10,20.00,200.00),
(4,'PIN01',25,7.00,175),
(3,'GOM01',20,1.00,20.00),
(3,'COR01',10,15.00,150.00),
(4,'COM01',5,12.00,60.00),
(6,'CAL01',5,240.00,1200.00);

insert into Ventas(id_vendedor,fecha) values
('ESM01','27/02/2022'),
('ESM01','27/02/2022'),
('ESM01','27/02/2022'),
('TAM01','27/02/2022'),
('TAM01','27/02/2022'),
('TAM01','27/02/2022'),
('JES01','28/02/2022'),
('JES01','28/02/2022'),
('JES01','28/02/2022'),
('JES01','28/02/2022');

insert into DetalleXVenta values
(1,'HOJ01',30,7.50),
(1,'LAP01',3,10.50),
(1,'LAP02',2,6.00),
(4,'HOJ02',15,15.00),
(4,'CAJ01',1,30.00),
(4,'PIN01',20,200.00),
(7,'GOM01',2,5.00),
(7,'COR01',1,18.00),
(7,'COM01',2,30.00),
(7,'CAL01',1,280.00);