drop database if exists CURRIERBD_LP;

create database CURRIERBD_LP;
use CURRIERBD_LP;

/*---------------------------REGION DESTINO-----------------------------*/
Create table REGION
(
	REG_CODIGO		int,
    REG_DESCRIPCION	varchar(25),
    REG_COSTO		decimal
);

Alter Table REGION
Add constraint PK_REGION primary key (REG_CODIGO);

insert into REGION values (1,'Sudamerica',50);
insert into REGION values (2,'Norte de America',80);
insert into REGION values (3,'Europa',95);
insert into REGION values (4,'Asia',120);
insert into REGION values (5,'Oceania',140);

/*---------------------------DESTINO-----------------------------*/
Create table DESTINO
(
	DES_CODIGO			char(5),
    DES_PAIS			varchar(30),
    DES_CIUDAD			varchar(30),
    DES_CODIGO_POS		char(5),
    REG_CODIGO			int
);

Alter Table DESTINO
Add constraint PK_DESTINO primary key (DES_CODIGO),
Add constraint FK_DESTINO foreign key (REG_CODIGO) references REGION (REG_CODIGO);

insert into DESTINO values ('D0001','CHILE','SANTIAGO','15487',1);
insert into DESTINO values ('D0002','RUSIA','MOSCÚ','75428',4);
insert into DESTINO values ('D0003','FRANCIA','PARIS','18547',3);
insert into DESTINO values ('D0004','ARGENTINA','BUENOS AIRES','91547',1);
insert into DESTINO values ('D0005','BRASIL','BRASILIA','13542',1);
insert into DESTINO values ('D0006','EEUU','LOS ANGELES','14365',2);
insert into DESTINO values ('D0007','CHINA','PEKIN','68735',4);

/* PROCEDURE LISTAR DESTINOS */
DELIMITER //
CREATE PROCEDURE LISTAR_DESTINOS()
BEGIN
  SELECT d.DES_CODIGO, d.DES_PAIS, d.DES_CIUDAD, d.DES_CODIGO_POS, d.REG_CODIGO, r.REG_DESCRIPCION
  FROM DESTINO d inner JOIN REGION r on d.REG_CODIGO = r.REG_CODIGO;
END //
DELIMITER ;

/* PROCEDURE GUARDAR DESTINO */
DELIMITER //
CREATE PROCEDURE GUARDAR_DESTINO(
IN
	CODIGO			char(5),
    PAIS			varchar(30),
    CIUDAD			varchar(30),
    CODIGO_POS		char(5),
    REG_CODIGO		int
)
BEGIN
  insert into DESTINO values(CODIGO,PAIS,CIUDAD,CODIGO_POS,REG_CODIGO);
END //
DELIMITER ;
drop database if exists CURRIERBD_LP;

create database CURRIERBD_LP;
use CURRIERBD_LP;

/*---------------------------REGION DESTINO-----------------------------*/
Create table REGION
(
	REG_CODIGO		int,
    REG_DESCRIPCION	varchar(25),
    REG_COSTO		decimal
);

Alter Table REGION
Add constraint PK_REGION primary key (REG_CODIGO);

insert into REGION values (1,'Sudamerica',50);
insert into REGION values (2,'Norte de America',80);
insert into REGION values (3,'Europa',95);
insert into REGION values (4,'Asia',120);
insert into REGION values (5,'Oceania',140);

/*---------------------------DESTINO-----------------------------*/
Create table DESTINO
(
	DES_CODIGO			char(5),
    DES_PAIS			varchar(30),
    DES_CIUDAD			varchar(30),
    DES_CODIGO_POS		char(5),
    REG_CODIGO			int
);

Alter Table DESTINO
Add constraint PK_DESTINO primary key (DES_CODIGO),
Add constraint FK_DESTINO foreign key (REG_CODIGO) references REGION (REG_CODIGO);

insert into DESTINO values ('D0001','CHILE','SANTIAGO','15487',1);
insert into DESTINO values ('D0002','RUSIA','MOSCÚ','75428',4);
insert into DESTINO values ('D0003','FRANCIA','PARIS','18547',3);
insert into DESTINO values ('D0004','ARGENTINA','BUENOS AIRES','91547',1);
insert into DESTINO values ('D0005','BRASIL','BRASILIA','13542',1);
insert into DESTINO values ('D0006','EEUU','LOS ANGELES','14365',2);
insert into DESTINO values ('D0007','CHINA','PEKIN','68735',4);

/* PROCEDURE LISTAR DESTINOS */
DELIMITER //
CREATE PROCEDURE LISTAR_DESTINOS()
BEGIN
  SELECT d.DES_CODIGO, d.DES_PAIS, d.DES_CIUDAD, d.DES_CODIGO_POS, d.REG_CODIGO, r.REG_DESCRIPCION
  FROM DESTINO d inner JOIN REGION r on d.REG_CODIGO = r.REG_CODIGO;
END //
DELIMITER ;

/* PROCEDURE GUARDAR DESTINO */
DELIMITER //
CREATE PROCEDURE GUARDAR_DESTINO(
IN
	CODIGO			char(5),
    PAIS			varchar(30),
    CIUDAD			varchar(30),
    CODIGO_POS		char(5),
    REG_CODIGO		int
)
BEGIN
  insert into DESTINO values(CODIGO,PAIS,CIUDAD,CODIGO_POS,REG_CODIGO);
END //
DELIMITER ;

/* PROCEDURE ACTUALIZAR DESTINO */
DELIMITER //
CREATE PROCEDURE ACTUALIZAR_DESTINO(
IN
	D_CODIGO			char(5),
    PAIS			varchar(30),
    CIUDAD			varchar(30),
    CODIGO_POS		char(5),
    R_CODIGO		int
)
BEGIN
  UPDATE DESTINO set DES_CODIGO=D_CODIGO ,DES_PAIS=PAIS , DES_CIUDAD=CIUDAD , DES_CODIGO_POS=CODIGO_POS , REG_CODIGO=R_CODIGO
		WHERE DES_CODIGO=D_CODIGO;
END //
DELIMITER ;

/*---------------------------CONDUCTOR-----------------------------*/
Create table CONDUCTOR
(
	CON_CODIGO		int,
    CON_NOMBRE		varchar(40)
);

Alter table CONDUCTOR
Add constraint PK_CONDUCTOR primary key (CON_CODIGO);

insert into CONDUCTOR values (1,'Keiko Fujimori');
insert into CONDUCTOR values (2,'Pedro Castillo');
insert into CONDUCTOR values (3,'Rafael Lopez');
insert into CONDUCTOR values (4,'Cesar Acuña');
insert into CONDUCTOR values (5,'Ernando De Soto');
insert into CONDUCTOR values (6,'Julio Guzman');

/*---------------------------VEHICULO-----------------------------*/
Create table VEHICULO
(
	VEH_CODIGO		char(5),
    VEH_MATRICULA	varchar(8),
	VEH_MARCA		varchar(20),
    VEH_MODELO		varchar(20),
    VEH_FECHA_ADQ	varchar(10),
    CON_CODIGO		int
);

Alter table VEHICULO
Add constraint PK_VEHICULO primary key (VEH_CODIGO),
Add constraint FK_VEHICULO foreign key (CON_CODIGO) references CONDUCTOR (CON_CODIGO);

insert into vehiculo values('V0001','CJS-4515','CHEVROLET','Corvette','10/12/2015',1);
insert into vehiculo values('V0002','EAT-1247','AUDI','A6','15/10/2014',2);
insert into vehiculo values('V0003','DRE-7412','FERRARI','Enzo','04/05/2010',3);
insert into vehiculo values('V0004','IBS-1341','PORCHE','911 Carrera','23/09/2011',4);
insert into vehiculo values('V0005','BGT-1856','LAMBORGHINI','Hucaran','28/04/2013',5);
insert into vehiculo values('V0006','ZWE-1736','BUGATTI','Chiron','17/02/2015',6);
insert into vehiculo values('V0007','FEC-7815','FORD','Mustang GT','15/07/2012',4);

/* PROCEDURE LISTAR VEHICULOS */
DELIMITER //
CREATE PROCEDURE LISTAR_VEHICULOS()
BEGIN
  SELECT V.VEH_CODIGO, V.VEH_MATRICULA, V.VEH_MARCA, V.VEH_MODELO, V.VEH_FECHA_ADQ, V.CON_CODIGO, C.CON_NOMBRE
  FROM VEHICULO V JOIN CONDUCTOR C ON V.CON_CODIGO=C.CON_CODIGO;
END //
DELIMITER ;

/* PROCEDURE GUARDAR VEHICULO */
DELIMITER //
CREATE PROCEDURE GUARDAR_VEHICULO(
IN
	CODIGO		char(5),
    MATRICULA	varchar(8),
	MARCA		varchar(20),
    MODELO		varchar(20),
    FECHA_ADQ	varchar(10),
    CONCODIGO		int
)
BEGIN
  insert into VEHICULO values(CODIGO,MATRICULA,MARCA,MODELO,FECHA_ADQ,CONCODIGO);
END //
DELIMITER ;

/* PROCEDURE ACTUALIZAR VEHICULO */
DELIMITER //
CREATE PROCEDURE ACTUALIZAR_VEHICULO(
IN
	CODIGO		char(5),
    MATRICULA	varchar(8),
	MARCA		varchar(20),
    MODELO		varchar(20),
    FECHA_ADQ	varchar(10),
    CONCODIGO	int
)
BEGIN
  update VEHICULO set VEH_MATRICULA=MATRICULA ,VEH_MARCA=MARCA ,VEH_MODELO=MODELO ,VEH_FECHA_ADQ=FECHA_ADQ ,CON_CODIGO=CONCODIGO
		where VEH_CODIGO=CODIGO;
END //
DELIMITER ;

/*---------------------------CARGO-----------------------------*/

CREATE TABLE CARGO(
	CAR_CODIGO 		INT primary KEY auto_increment,
    CAR_NOMCARGO    varchar(30)
);

INSERT INTO CARGO VALUES(NULL,'Administrador');
INSERT INTO CARGO VALUES(NULL,'Conductor');
INSERT INTO CARGO VALUES(NULL,'Contador');
INSERT INTO CARGO VALUES(NULL,'Administrativo');

/*---------------------------TRABAJADOR-----------------------------*/
Create table TRABAJADOR
(
	TRA_CODIGO		int auto_increment primary key,
    TRA_NOMBRE		varchar(30),
    TRA_APELLIDO	varchar(30),
    TRA_DNI			char(8),
    TRA_FECHA_NAC	date,
    TRA_CORREO		varchar(30),
    TRA_TELEFONO	varchar(15),
    CAR_CODIGO		 INT,
    TRA_CONTRASENA 	varchar(20),
    FOREIGN KEY (CAR_CODIGO) REFERENCES CARGO(CAR_CODIGO)
);

INSERT INTO TRABAJADOR VALUES (null,'Juan','Herrera','23546576','1992-05-24','juan@gmail.com','987345746',1,'12345');
INSERT INTO TRABAJADOR VALUES (null,'Carlos','Gutieres','54346576','1982-06-02','carlos@gmail.com','987362436',2,'12345');
INSERT INTO TRABAJADOR VALUES (null,'Pedro','Carmona','23765576','1994-08-12','pedro@gmail.com','987364346',1,'12345');
INSERT INTO TRABAJADOR VALUES (null,'Elizabeth','Calderon','75476576','1993-01-11','elizabeth@gmail.com','923462746',3,'12345');
INSERT INTO TRABAJADOR VALUES (null,'Alfredo','Castillo','23548576','1992-03-26','alfredo@gmail.com','987334546',4,'12345');
INSERT INTO TRABAJADOR VALUES (null,'Angello','Quispe','23587676','1991-05-27','angello@gmail.com','987354346',2,'12345');
INSERT INTO TRABAJADOR VALUES (null,'Fernando','Cueto','23594778','1990-07-28','fernando@gmail.com','987365746',3,'12345');
INSERT INTO TRABAJADOR VALUES (null,'Andres','Melva','23546956','1990-10-05','andres@gmail.com','987362586',4,'12345');

/*Listar trabajador*/
DELIMITER //
CREATE PROCEDURE LISTAR_TRABAJADORES()
BEGIN
  SELECT TRA_CODIGO,TRA_NOMBRE,TRA_APELLIDO,TRA_DNI,TRA_FECHA_NAC,TRA_CORREO,TRA_TELEFONO, C.CAR_NOMCARGO, TRA_CONTRASENA
  FROM TRABAJADOR T JOIN CARGO C ON T.CAR_CODIGO=C.CAR_CODIGO;
END //
DELIMITER ;

/*Eliminar trabajador*/
DELIMITER //
CREATE PROCEDURE ELIMINAR_TRABAJADORES(in cod int)
BEGIN
  delete from TRABAJADOR where TRA_CODIGO=cod;
END //
DELIMITER ;

/*Agregar trabajador*/
DELIMITER //
CREATE PROCEDURE AGREGAR_TRABAJADORES(
in 	cod int,
	nombre varchar(30),
    apellido varchar(30),
    dni char(8),
    nacimiento	date,
    correo varchar(30),
    telefono varchar(15),
    codcargo int,
    contrasena varchar(20)
    
)
BEGIN
  INSERT INTO TRABAJADOR VALUES(cod,nombre,apellido,dni,nacimiento,correo,telefono,codcargo,contrasena);
END //
DELIMITER ;

/*Editar trabajador*/
DELIMITER //
CREATE PROCEDURE EDITAR_TRABAJADORES(
in 	cod int,
	nombre varchar(30),
    apellido varchar(30),
    dni char(8),
    nacimiento	date,
    correo varchar(30),
    telefono varchar(15),
    codcargo int,
    contrasena varchar(20)
    
)
BEGIN 
  UPDATE TRABAJADOR 
  SET TRA_NOMBRE=nombre, TRA_APELLIDO=apellido,TRA_DNI=dni, TRA_FECHA_NAC=nacimiento, TRA_CORREO=correo, TRA_TELEFONO= telefono, CAR_CODIGO=codcargo,TRA_CONTRASENA=contrasena
  WHERE TRA_CODIGO=cod;
END //
DELIMITER ;


/*---------------------------MENU-----------------------------*/
Create table MENU(
COD_MENU 	INT auto_increment primary KEY,
DESC_MENU	VARCHAR(100),
URL_MENU	VARCHAR(120)
);	

INSERT INTO MENU values(null,'Mantenimiento Trabajador','/trabajador/cargar');
INSERT INTO MENU values(null,'Mantenimiento Vehiculo','/vehiculo/cargar');
INSERT INTO MENU values(null,'Mantenimiento Destino','/destino/cargar');
INSERT INTO MENU values(null,'Mantenimiento Cliente','/cliente/cargar');
INSERT INTO MENU values(null,'Reporte tipo','/cargarReporteTipo');
INSERT INTO MENU values(null,'Reporte fecha','/cargarReporteFecha');

/*---------------------------ACCESO-----------------------------*/

CREATE TABLE ACCESO(
COD_MENU 	INT,
TRA_CODIGO  INT,
FOREIGN KEY (TRA_CODIGO) REFERENCES TRABAJADOR(TRA_CODIGO),
FOREIGN KEY (COD_MENU) REFERENCES MENU(COD_MENU)
);

INSERT INTO ACCESO VALUES(1,1);
INSERT INTO ACCESO VALUES(2,1);
INSERT INTO ACCESO VALUES(3,1);
INSERT INTO ACCESO VALUES(4,1);
INSERT INTO ACCESO VALUES(5,1);
INSERT INTO ACCESO VALUES(6,1);
INSERT INTO ACCESO VALUES(4,5);
INSERT INTO ACCESO VALUES(5,5);
INSERT INTO ACCESO VALUES(6,5);


/*-------------------CLIENTE----------------------*/
CREATE TABLE CLIENTE
(
	CLI_CODIGO 		int primary key auto_increment,
    CLI_NOMBRE 		varchar(30),
    CLI_APELLIDO	varchar(30),
    CLI_DNI			varchar(8),
    CLI_TELEFONO	varchar(15),
    CLI_CORREO		varchar(50)
);

INSERT INTO CLIENTE VALUES (null,'Aldo','Perez','78456284','950185684','aldo@gmail.com');
INSERT INTO CLIENTE VALUES (null,'Jimena','Zegarra','29630279','85214759','jimena@gmail.com');
INSERT INTO CLIENTE VALUES (null,'Andrea','Matos','83617594','963748156','andrea@gmail.com');
INSERT INTO CLIENTE VALUES (null,'Diana','Flores','88246355','994258761','diana@gmail.com');

/*Listar CLIENTE*/
DELIMITER //
CREATE PROCEDURE LISTAR_CLIENTE()
BEGIN
		SELECT CLI_CODIGO, CLI_NOMBRE, CLI_APELLIDO, CLI_DNI, CLI_TELEFONO, CLI_CORREO
        FROM CLIENTE;
END //
DELIMITER ;

/*Eliminar CLIENTE*/
DELIMITER //
CREATE PROCEDURE ELIMINAR_CLIENTE(in cod int)
BEGIN
  delete from CLIENTE where CLI_CODIGO=cod;
END //
DELIMITER ;

/*Agregar CLIENTE*/
DELIMITER //
CREATE PROCEDURE AGREGAR_CLIENTE(
in 	cod int,
	nombre varchar(30),
    apellido varchar(30),
    dni varchar(8),
    telefono varchar(15),
	correo varchar(50)
    
)
BEGIN
  INSERT INTO CLIENTE VALUES(cod,nombre,apellido,dni,telefono,correo);
END //
DELIMITER ;

/*Editar cliente*/
DELIMITER //
CREATE PROCEDURE EDITAR_CLIENTE(
in 	cod int,
	nombre varchar(30),
    apellido varchar(30),
    dni varchar(8),
    telefono varchar(15),
	correo varchar(50)
    
)
BEGIN
  UPDATE CLIENTE set CLI_NOMBRE=nombre,CLI_APELLIDO=apellido,CLI_DNI=dni,CLI_TELEFONO=telefono,CLI_CORREO=correo
  WHERE CLI_CODIGO=cod;
END //
DELIMITER ;

/*---------------------------ENVIO-----------------------------*/
Create table ENVIO
(
	ENV_CODIGO			varchar(6),
    ENV_NOM_DEST		varchar(30),
    ENV_DNI_DEST		varchar(11),
    ENV_TELE_DEST   	varchar(15),
    ENV_FECHA			date,
    CLI_CODIGO			int,
    DES_CODIGO			char(5)
);

Alter Table ENVIO
Add constraint PK_ENVIO primary key (ENV_CODIGO),
Add constraint FK_ENVIO1 foreign key (CLI_CODIGO) references CLIENTE (CLI_CODIGO),
Add constraint FK_ENVIO2 foreign key (DES_CODIGO) references DESTINO (DES_CODIGO);

INSERT INTO ENVIO VALUES ('E00001','Jaime Cardenas','85442657','995214425','2021-05-10',1,'D0002');
INSERT INTO ENVIO VALUES ('E00002','Alexa Lagos','74512584','996351248','2021-05-18',2,'D0004');
INSERT INTO ENVIO VALUES ('E00003','Juan Casas','85124578','963214785','2021-05-22',3,'D0005');

/*Listar ENVIO*/
DELIMITER //
CREATE PROCEDURE LISTAR_ENVIO()
BEGIN
		SELECT e.ENV_CODIGO, e.ENV_NOM_DEST, e.ENV_DNI_DEST, e.ENV_TELE_DEST, e.ENV_FECHA, concat(c.CLI_NOMBRE," ", c.CLI_APELLIDO), d.DES_CIUDAD
					FROM ENVIO e inner join CLIENTE c on e.CLI_CODIGO = c.CLI_CODIGO 
					inner join DESTINO d on d.DES_CODIGO = e.DES_CODIGO
                    order by ENV_CODIGO asc;
END //
DELIMITER ;

/*---------------------------TIPO SERVICIO-----------------------------*/
Create table TIPO_SERVICIO
(
	TIP_SER_CODIGO		int,
    TIP_SER_DESCRIPCION	varchar(25)
);

Alter Table TIPO_SERVICIO
Add constraint PK_TIPO_SERVICIO primary key (TIP_SER_CODIGO);

insert into TIPO_SERVICIO values (1,'Regular');
insert into TIPO_SERVICIO values (2,'Express');
insert into TIPO_SERVICIO values (3,'Premium');

/*----------------------------TIPO OBJETO-------------------------*/
Create table TIPO_OBJETO
(
	TIP_OBJ_CODIGO		int,
    TIP_OBJ_DESCRIPCION	varchar(25)
);
Alter Table TIPO_OBJETO
Add constraint PK_TIPO_OBJETO primary key (TIP_OBJ_CODIGO);

insert into TIPO_OBJETO values (1,'Documento');
insert into TIPO_OBJETO values (2,'Paquete');
insert into TIPO_OBJETO values (3,'Carta');
INSERT INTO TIPO_OBJETO VALUES (4,'Fragil');

/*---------------------------DETALLE ENVIO-----------------------------*/
CREATE TABLE DETALLE_ENVIO
(
	ENV_CODIGO		varchar(6),
    DET_CODIGO		int,
    DET_NOMBRE		varchar(30),
    TIP_OBJ_CODIGO	int,
    TIP_SER_CODIGO	int
);

Alter table DETALLE_ENVIO 
Add constraint FK_DETALLE_ENVIO1 foreign key (ENV_CODIGO) references ENVIO (ENV_CODIGO),
Add constraint FK_DETALLE_ENVIO2 foreign key (TIP_OBJ_CODIGO) references TIPO_OBJETO (TIP_OBJ_CODIGO),
Add constraint FK_DETALLE_ENVIO3 foreign key (TIP_SER_CODIGO) references TIPO_SERVICIO (TIP_SER_CODIGO);

INSERT INTO DETALLE_ENVIO VALUES ('E00001',1,'Jarron',4,3);
INSERT INTO DETALLE_ENVIO VALUES ('E00001',2,'Certificado',1,1);
INSERT INTO DETALLE_ENVIO VALUES ('E00002',1,'Carta Saludo',3,1);
INSERT INTO DETALLE_ENVIO VALUES ('E00002',2,'Celular',2,2);
INSERT INTO DETALLE_ENVIO VALUES ('E00003',1,'Partida Nacimiento',1,2);
INSERT INTO DETALLE_ENVIO VALUES ('E00003',2,'Reloj',2,3);

/*-------------------------------------------------------------------*/


DELIMITER //
Create procedure REPORTEXFECHA(In fec1 date, fec2 date)
BEGIN
	select e.ENV_CODIGO, e.ENV_NOM_DEST, e.ENV_FECHA, CONCAT(c.CLI_NOMBRE," ",c.CLI_APELLIDO) as NOM_CLIENTE, de.DET_CODIGO, de.DET_NOMBRE, tio.TIP_OBJ_DESCRIPCION
	from ENVIO e 
	inner join DETALLE_ENVIO de on e.ENV_CODIGO  = de.ENV_CODIGO 
    inner join CLIENTE c on e.CLI_CODIGO = c.CLI_CODIGO
    inner join TIPO_OBJETO tio on de.TIP_OBJ_CODIGO = tio.TIP_OBJ_CODIGO
    where e.ENV_FECHA between fec1 and fec2;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE REPORTEXTIPO(In tipo int)
-- CREATE PROCEDURE REPORTEXTIPO(In tipo varchar(25))
BEGIN
	select e.ENV_CODIGO, e.ENV_NOM_DEST, e.ENV_FECHA, CONCAT(c.CLI_NOMBRE," ",c.CLI_APELLIDO) as NOM_CLIENTE, de.DET_CODIGO, de.DET_NOMBRE, tio.TIP_OBJ_DESCRIPCION
	from ENVIO e 
	inner join DETALLE_ENVIO de on e.ENV_CODIGO  = de.ENV_CODIGO 
    inner join CLIENTE c on e.CLI_CODIGO = c.CLI_CODIGO
    inner join TIPO_OBJETO tio on de.TIP_OBJ_CODIGO = tio.TIP_OBJ_CODIGO
    where tio.TIP_OBJ_CODIGO = tipo;
    -- where tio.TIP_OBJ_DESCRIPCION = tipo;
END //
DELIMITER ;

