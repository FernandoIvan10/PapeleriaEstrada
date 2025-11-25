--Secuencias
create sequence id_venta_seq
increment by 1
start 1
no maxvalue
minvalue 1
no cycle;

create sequence id_compra_seq
increment by 1
start 1
no maxvalue
minvalue 1
no cycle;

--Tablas
create table Proveedores(
	id_proveedor varchar primary key,
	nombre varchar(15) not null unique
);

create table Vendedores(
	id_vendedor varchar primary key,
	nombre varchar(30) not null,
	apellido_paterno varchar(15),
	apellido_materno varchar(15)
);

create table Productos(
	id_producto varchar primary key,
	nombre varchar(30) not null unique,
	descripcion varchar(100),
	categoria varchar(15),
	stock integer not null,
	precio_venta numeric(5,2) not null,
	check (stock>=0 and precio_venta>0)
);

create table Compras(
	id_compra integer primary key default nextval('id_compra_seq'),
	id_proveedor varchar references Proveedores(id_proveedor),
	fecha date default now()
);

create table DetalleXCompra(
	id_compra integer references Compras(id_compra),
	id_producto varchar references Productos(id_producto),
	cantidad integer not null,
	precio_compra numeric(7,2) not null,
	subtotal_compra numeric(7,2),
	check (cantidad>0 and precio_compra>0)
);

create table Ventas(
	id_venta integer primary key default nextval('id_venta_seq'),
	id_vendedor varchar references vendedores(id_vendedor),
	fecha date default now()
);

create table DetalleXVenta(
	id_venta integer references Ventas(id_venta),
	id_producto varchar references Productos(id_producto),
	cantidad integer not null,
	subtotal_venta numeric(7,2),
	check (cantidad>0)
);

--Usuarios
create user dueño with login;
grant all on compras, detallexcompra, detallexventa, productos,
proveedores, vendedores, ventas to dueño;

create user gerente with login;
grant select on compras, detallexcompra, detallexventa, productos,
proveedores, vendedores, ventas to gerente;

create user vendedor with login;
grant all on productos to vendedor;
grant select, insert on ventas, detallexventa to vendedor;

--Funciones y procedimientos
----------------------------------------------------------------------
Create or replace function buscarProductos(varchar)
returns setof productos as
$body$
declare
    reg record;
begin
    for reg in select * from productos where nombre like (($1||'%')::VARCHAR) loop
       return next reg;
    end loop;
    return;
end
$body$ language 'plpgsql';
------------------------------------------------------------------------------
create or replace function buscarProductoXNombre(n varchar) 
returns table(
	id_producto varchar,
	nombre varchar(30),
	descripcion varchar(100),
	categoria varchar(15),
	stock integer,
	precio_venta numeric(5,2)
) as $$
begin
return query
select * from Productos where Productos.nombre = n;
end
$$ language plpgsql;
------------------------------------------------------------------------------
create or replace procedure agregarVenta(varchar) as $$
begin
insert into ventas(id_vendedor) values($1);
end
$$ language plpgsql;
--------------------------------------------------------------------------------
create or replace function buscarVenta(date) returns setof ventas as $body$
declare
reg record;
begin
for reg in select * from ventas where fecha = $1 loop
return next reg;
end loop;
return;
end
$body$ language plpgsql;
-------------------------------------------------------------------------------
create or replace function ultimaVenta() returns integer as $$
declare
maximo integer;
begin
	 maximo := max(id_venta) from ventas;
	 return maximo;
end
$$ language plpgsql;
--------------------------------------------------------------------------
create procedure agregarDetalleVenta(id_venta integer,id_producto varchar,cantidad integer) 
as $$
begin
insert into detallexventa(id_venta,id_producto,cantidad) values(id_venta,id_producto,cantidad);
end
$$ language plpgsql;
---------------------------------------------------------------------------------
create or replace procedure agregarCompra(varchar) as $$
begin
insert into compras(id_proveedor) values($1);
end
$$ language plpgsql;
----------------------------------------------------------------------------
create or replace function ultimaCompra() returns integer as $$
declare
maximo integer;
begin
	 maximo := max(id_compra) from Compras;
	 return maximo;
end
$$ language plpgsql;
------------------------------------------------------------------------------
create or replace function buscarCompra(date) returns setof compras as $body$
declare
reg record;
begin
for reg in select * from compras where fecha = $1 loop
return next reg;
end loop;
return;
end
$body$ language plpgsql;
-------------------------------------------------------------------------------
create or replace procedure agregarDetalleCompra(id_compra integer,id_producto varchar,cantidad integer,
												 precio_compra numeric) as $$
begin
insert into detallexcompra(id_compra,id_producto,cantidad,precio_compra) 
values(id_compra,id_producto,cantidad,precio_compra);
end
$$ language plpgsql;
------------------------------------------------------------------------
create or replace function mostrarID(nom varchar, ap varchar, am varchar) returns varchar as $$
declare
idv varchar;
begin
idv = id_vendedor from Vendedores where nombre = nom and apellido_paterno = ap and apellido_materno = am;
return idv;
end
$$ language plpgsql;
-------------------------------------------------------------------------
create or replace function obtenerIDProveedor(varchar) returns varchar as $$
declare
idp varchar;
begin
idp = id_proveedor from Proveedores where nombre = $1;
return idp;
end
$$ language plpgsql;
------------------------------------------------------------------------------
create or replace function buscarProveedor(varchar) returns setof Proveedores as $BODY$
declare
reg record;
begin
for reg in select * from Proveedores where nombre like ($1||'%')::varchar loop
return next reg;
end loop;
return;
end
$BODY$ language plpgsql;
------------------------------------------------------------------------
create or replace procedure actualizarProveedor(varchar, varchar) as $$
begin
update Proveedores set nombre = $2 where id_proveedor = $1;
end
$$ language plpgsql;
-----------------------------------------------------------------------
create or replace procedure registrarDueño() as $$
begin
Insert into Vendedores Values('PRUEBA123','Super','administrador','Prueba');
end
$$ language plpgsql;
-----------------------------------------------------------------------
create or replace function buscarDueño() returns setof Vendedores as $BODY$
declare
reg record;
begin
for reg in select * from Vendedores where id_vendedor = 'PRUEBA123' loop
return next reg;
end loop;
return;
end
$BODY$ language plpgsql;
---------------------------------------------------------------------



--Triggers
create or replace function eliminarDetalleVenta() returns trigger as $$
begin
delete from detallexventa where id_venta=old.id_venta;
return old;
end
$$ language plpgsql;

create trigger eliminarDetalleVenta before delete on ventas
for each row execute procedure eliminarDetalleVenta();
-----------------------------------------------------------------------------
create or replace function eliminarDetalleCompra() returns trigger as $$
begin
delete from detallexcompra where id_compra=old.id_compra;
return old;
end
$$ language plpgsql;

create trigger eliminarDetalleCompra before delete on compras
for each row execute procedure eliminarDetalleCompra();
----------------------------------------------------------------------------------
create or replace function rellenarVenta() returns trigger as $$
begin
new.subtotal_venta=new.cantidad*(select precio_venta from productos 
									 where new.id_producto = Productos.id_producto);
return new;
end
$$ language plpgsql;

create trigger rellenarVenta before insert on detallexventa
for each row execute procedure rellenarVenta();
------------------------------------------------------------------------------------
create or replace function rellenarCompra() returns trigger as $$
begin
new.subtotal_compra = new.cantidad*new.precio_compra;
return new;
end
$$ language plpgsql;

create trigger rellenarCompra before insert on detallexcompra
for each row execute procedure rellenarCompra();
-------------------------------------------------------------------------------
create or replace function aumentarStock() returns trigger as $$
begin
update Productos set stock = stock+new.cantidad where id_producto = new.id_producto;
return new;
end
$$ language plpgsql;

create trigger aumentarStock after insert on detallexcompra
for each row execute procedure aumentarStock();
-----------------------------------------------------------------------------------
create or replace function disminuirStock() returns trigger as $$
begin
update productos set stock = stock-new.cantidad where id_producto = new.id_producto;
return new;
end
$$ language plpgsql;

create trigger disminuirStock after insert on detallexventa
for each row execute procedure disminuirStock();
---------------------------------------------------------------------------------------

--Funciones para los reportes

--Producto más vendido--
create or replace function productoMasVendido() returns 
table(
	producto varchar, 
	"Cantidad de ventas" bigint, 
	"Total ventas" numeric)
as $$
begin
return query
select nombre, "Veces que se vendió", "Total de ventas" 
from (select id_producto, count(*) as "Veces que se vendió", sum(subtotal_venta) as "Total de ventas"
 from detallexventa group by id_producto
 order by "Veces que se vendió" desc limit 3
) as A,(select id_producto, nombre from Productos)as B
where A.id_producto = B.id_producto;
end;
$$ language plpgsql;
---------------------------------------------------------------------------------------------------
--Total de ventas--
create or replace function totalVentas() returns
table(
	"Mes vendido" numeric,
	"Total Ventas" bigint,
	venta numeric
) 
as $$
begin
return query
select B.mes, "Total de ventas", ventas
from (select mes, count(*) "Total de ventas" 
from (select id_venta, extract(month from fecha) as mes from ventas) as A 
group by mes) as B, 
(select mes, sum(total) as ventas 
from (select id_venta, sum(cantidad*subtotal_venta) as total from DetalleXVenta group by id_venta) as C, 
(select id_venta, extract(month from fecha) as mes from ventas) as D
where C.id_venta = D.id_venta
group by mes) as E
where B.mes = E.mes;
end;
$$ language plpgsql;
--------------------------------------------------------------------------------------------
--Mejor vendedor--
create or replace function mejorVendedor() returns
table(
	nombre varchar,
	apellido_p varchar,
	apellido_m varchar,
	cantidad_ventas bigint
)
as $$
begin
return query
select Vendedores.nombre, apellido_paterno, apellido_materno, ventas 
from Vendedores,(select count(id_venta) as ventas, id_vendedor 
				 from Ventas group by id_vendedor order by ventas desc limit 1) as A
where Vendedores.id_vendedor = A.id_vendedor;
end;
$$ language plpgsql;
-------------------------------------------------------------------------------------
--Mejor Proveedor--
create or replace function mejorProveedor() returns 
table(
	nombre varchar,
	cantidad_compras bigint
)
as $$
begin
return query
select Proveedores.nombre, compras 
from Proveedores, (select count(*) as compras, id_proveedor 
				   from Compras group by id_proveedor order by compras desc limit 3) as A
where Proveedores.id_proveedor = A.id_proveedor order by compras desc;
end;
$$ language plpgsql;
-------------------------------------------------------------------------------------------
--Ventas---
create or replace function detallesVenta() returns 
table(
	Venta integer,
	fechaVentas date,
	Vendedor text,
	Producto varchar,
	descripcionProducto varchar,
	subtotal numeric
) as $$
begin
return query
select id_venta, fecha, "Nombre del vendedor", C.nombre, descripcion, subtotal_venta 
from (select DetalleXVenta.id_venta, fecha, "Nombre del vendedor", id_producto, subtotal_venta 
from (select id_venta, fecha, nombre||' '||apellido_paterno||' '||apellido_materno as "Nombre del vendedor" 
 from Vendedores,Ventas 
where Vendedores.id_vendedor = ventas.id_vendedor) as A, DetalleXVenta 
where A.id_venta = DetalleXVenta.id_venta) as B,
(select id_producto, nombre, descripcion from Productos) as C
where B.id_producto = C.id_producto;
end
$$ language plpgsql;
------------------------------------------------------------------------------------------
--COMPRAS--
create or replace function detalleCompra() returns 
table (
Compra integer,
subtotal numeric,
FechaCompra date,
NombreProducto varchar,
proovedor varchar
)
as $$ 
begin
return query
select C.id_compra,C.subtotal_compra, C.fecha, C.nombre as Producto, proveedores.nombre as Proveedores from proveedores,(select B.id_compra,B.subtotal_compra,B.id_proveedor, B.fecha, productos.nombre from 
productos,(select A.id_compra,A.id_producto,A.subtotal_compra,id_proveedor, fecha from compras,
(select id_compra,id_producto,subtotal_compra from detallexcompra) as A where compras.id_compra = A.id_compra) as B 
where B.id_producto = productos.id_producto) as C 
where proveedores.id_proveedor = C.id_proveedor;
end
$$ language plpgsql;