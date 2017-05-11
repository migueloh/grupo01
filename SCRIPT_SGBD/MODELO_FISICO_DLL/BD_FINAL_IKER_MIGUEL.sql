DROP TABLE Viaje CASCADE CONSTRAINTS ;

DROP TABLE Parte CASCADE CONSTRAINTS ;

DROP TABLE Vehiculo CASCADE CONSTRAINTS ;

DROP TABLE Acceso CASCADE CONSTRAINTS ;

DROP TABLE Trabajador CASCADE CONSTRAINTS ;

DROP TABLE Centro CASCADE CONSTRAINTS ;

---------------------------------------------------------------
CREATE TABLE Centro
  (
    idCentro	NUMBER (3)
		GENERATED ALWAYS AS IDENTITY 
                        MINVALUE 1 
                        MAXVALUE 999
                        INCREMENT BY 1 
                        START WITH 1  
                        NOORDER  
                        NOCYCLE  NOT NULL ENABLE
		CONSTRAINT Centro_PK PRIMARY KEY ,
    nombre    VARCHAR2 (15) NOT NULL ,
    calle     VARCHAR2 (20) NOT NULL ,
    numero    NUMBER   (15) NOT NULL ,
    codPostal NUMBER   (15) NOT NULL ,
    ciudad    VARCHAR2 (20) NOT NULL ,
    provincia VARCHAR2 (15) NOT NULL ,
    telefono  NUMBER   (15) NOT NULL 
  ) ;


CREATE TABLE Trabajador
  (
    dni               VARCHAR2 (9) NOT NULL ,
    nombre            VARCHAR2 (15) NOT NULL ,
    apellido1         VARCHAR2 (15) NOT NULL ,
    apellido2         VARCHAR2 (15) ,
    calle             VARCHAR2 (20) NOT NULL ,
    numeroPortal      NUMBER   (15) NOT NULL ,
    piso              NUMBER   (15) NOT NULL ,
    mano              VARCHAR2 (8)  NOT NULL ,
    telfEmpresa       NUMBER   (15) NOT NULL ,
    telfPersonal      NUMBER   (15) ,
    fechaNacimiento   DATE ,
    salario           NUMBER   (15),
    categoria         VARCHAR2 (1) NOT NULL ,
    Centro_idCentro   NUMBER   (3)  NOT NULL ,
    CONSTRAINT Trabajador_PK PRIMARY KEY ( dni ),
    CONSTRAINT Trabajador_Centro_FK FOREIGN KEY ( Centro_idCentro ) REFERENCES Centro ( idCentro ),
    CONSTRAINT CHK_Cat CHECK ((categoria = 'a') or (categoria = 'l'))
  ) ;


CREATE TABLE Acceso
  (
    usuario        VARCHAR2 (9)  NOT NULL ,
    contrasena     VARCHAR2 (10) NOT NULL ,
    Trabajador_dni VARCHAR2 (9)  NOT NULL ,
    CONSTRAINT Acceso_PK PRIMARY KEY ( usuario, contrasena ) ,
    CONSTRAINT Acceso_Trabajador_FK FOREIGN KEY ( Trabajador_dni ) REFERENCES Trabajador ( dni )
  ) ;

CREATE TABLE Vehiculo
  (
    matricula     VARCHAR2 (7)  NOT NULL ,
    tipo          VARCHAR2 (15) NOT NULL ,
    km            NUMBER   (15) NOT NULL ,
    CONSTRAINT Vehiculo_PK PRIMARY KEY ( matricula )
  ) ;

CREATE TABLE Parte
  (
    idParte   NUMBER (6)
		GENERATED ALWAYS AS IDENTITY 
                        MINVALUE 1 
                        MAXVALUE 999999
                        INCREMENT BY 1 
                        START WITH 1  
                        NOORDER  
                        NOCYCLE  NOT NULL ENABLE
		CONSTRAINT Parte_PK PRIMARY KEY ,
    fecha              DATE          NOT NULL ,
    kmInicio           NUMBER   (15) NOT NULL ,
    kmFinal            NUMBER   (15) NOT NULL ,
    incidencias        VARCHAR2 (70) ,
    avisos             VARCHAR2 (70) NOT NULL ,
    finalizado         VARCHAR2 (1)  NOT NULL ,
    gasoil             NUMBER   (15),
    autopistas         NUMBER   (15),
    dietas             NUMBER   (15),
    otrosGastos        NUMBER   (15),
    horasTrabajadas    NUMBER   (15)NOT NULL ,
    Trabajador_dni     VARCHAR2 (9) NOT NULL ,
    Vehiculo_matricula VARCHAR2 (7) NOT NULL,
    CONSTRAINT Parte_Trabajador_FK FOREIGN KEY ( Trabajador_dni ) REFERENCES Trabajador ( dni ) , 
    CONSTRAINT Parte_Vehiculo_FK FOREIGN KEY ( Vehiculo_matricula ) REFERENCES Vehiculo ( matricula ) ,
    CONSTRAINT CHK_Fin CHECK ((finalizado = 't') or (finalizado = 'f'))
  ) ;

CREATE TABLE Viaje
  (
    idViaje   NUMBER (6)
		GENERATED ALWAYS AS IDENTITY 
                        MINVALUE 1 
                        MAXVALUE 999999
                        INCREMENT BY 1 
                        START WITH 1  
                        NOORDER  
                        NOCYCLE  NOT NULL ENABLE
		CONSTRAINT idViaje PRIMARY KEY ,
    albaran         VARCHAR2 (9) NOT NULL ,
    horaInicio      DATE NOT NULL ,
    horaFin         DATE NOT NULL ,
    Parte_idParte 	NUMBER (6) NOT NULL , 
    CONSTRAINT Viaje_Parte_FK FOREIGN KEY ( Parte_idParte ) REFERENCES Parte ( idParte )
  ) ;

-- INSERTAR DATOS DE PRUEBA:

insert into centro values(DEFAULT, 'Informatica', 'D.Arriaga', 1, 01002, 'Vitoria', 'Alava', 945202122);

insert into trabajador values('33333333C', 'Admin', 'Ok3', 'Hola3','Palomas', 1, 2, 'Centr', 945202122, 902202122, '19/07/1988', 288, 'a', 1);
insert into trabajador values('22222222B', 'Iker', 'Ok2', 'Hola2','Palomas', 1, 2, 'Izq', 945202122, 902202122, '19/07/1988', 288, 'a', 1);
insert into trabajador values('11111111A', 'Miguel', 'Ok1', 'Hola1','Palomas', 1, 2, 'Der', 945202122, 902202122, '19/07/1988', 288, 'l', 1);


insert into acceso values ('Admin','12345', '33333333C');
insert into acceso values ('Iker','12345', '22222222B');
insert into acceso values ('Miguel','12345', '11111111A');
insert into vehiculo values ('sin rellenar', '', 0); 
insert into vehiculo values ('1111111', 'Furgoneta', 100); 
insert into partes values();
insert into partes values(04-04-2017,10.0,12.0,'nada','abierto','f',20,1,11,11,8,'123456789p','2222222');
/*
CENTRO

desc centro


select *
from centro;
*/

/*
TRABAJADROR

desc trabajador


select *
from trabajador;
*/

/*
ACCESO

desc acceso

select *
from acceso;
*/

/*
VEHICULO

desc vehiculo

select *
from vehiculo;
*/

/*
CONSULTA DE LA CATEGORIA DEL TRABAJADOR
.+3

SELECT t.Categoria FROM Trabajador t, Acceso a WHERE t.dni = a.trabajador_dni AND a.usuario = 'Admin' AND a.contrasena = '12345';

*/