create or replace PROCEDURE consulta_trabajador 
(v_Dni in trabajador.dni%type,
vdni out trabajador.dni%type
,vnombre out trabajador.nombre%type
,vapellido out trabajador.apellido1%type,
vapellido2 out trabajador.apellido2%type,
vcalle out trabajador.calle%type,
vnumeroPortal out trabajador.numeroPortal%type,
vpiso out trabajador.piso%type,
vmano out trabajador.mano%type,
vtelEmpresa out trabajador.telfEmpresa%type,
vtelPersonal out TRABAJADOR.TELFPERSONAL%type,
vfechaNacimiento out TRABAJADOR.FECHANACIMIENTO%type,
vsalario out TRABAJADOR.SALARIO%type,
vcategoria out TRABAJADOR.CATEGORIA%type
) AS
BEGIN

 SELECT dni,nombre,APELLIDO1,APELLIDO2,CALLE,NUMEROPORTAL,PISO,MANO,TELFEMPRESA,TELFPERSONAL,FECHANACIMIENTO,SALARIO,categoria
      into vdni,vnombre,vapellido,vapellido2,vcalle,vnumeroPortal,vpiso,vmano,vtelEmpresa,vtelPersonal,vfechaNacimiento,vsalario,vcategoria 
   FROM TRABAJADOR
     WHERE 
         dni=v_Dni;

END;
---------------------------------------------------------------------------------
create or replace procedure listadni(dniV out sys_refcursor)as

 BEGIN
        OPEN dniV FOR
        SELECT dni from trabajador;
    
    END;
    ------------------------------------------------------------------------
    create or replace procedure listavehiculos(nombreV out sys_refcursor)as

 BEGIN
        OPEN nombreV FOR
        SELECT matricula from vehiculo;
    
    END;
    ----------------------------------------------------------------------
    create or replace procedure partePorFecha(vfecha in PARTE.FECHA%type,nombreF out sys_refcursor)as

 BEGIN
        OPEN nombreF FOR
        SELECT * from parte where fecha=vfecha ;
    
    END;
    ----------------------------------------------------------------------
    create or replace procedure vehiculoobjetovacio(v out sys_refcursor)as

 BEGIN
        OPEN v FOR
        SELECT * from vehiculo where matricula='sin rellenar';
    
    END;
    -------------------------------------------------------------
    create or replace PROCEDURE vista_parte_ABIERTO
(v_estado in parte.finalizado%type,
VFECHA out PARTE.FECHA%type
,VKMINICIO out PARTE.KMINICIO%type
,VKMFINAL out PARTE.KMFINAL%type,
VINCIDENCIAS out PARTE.INCIDENCIAS%type,
VAVISOS OUT PARTE.AVISOS%TYPE,
vFINALIZADO out PARTE.FINALIZADO%type,
VGASOIL out PARTE.GASOIL%type,
VAUTOPISTAS out PARTE.AUTOPISTAS%type,
VDIETAS out PARTE.AUTOPISTAS%type,
VOTROSGASTOS out PARTE.OTROSGASTOS%type,
VHORASTRABAJADAS OUT PARTE.HORASTRABAJADAS%TYPE,
VTRABVAJADOR OUT PARTE.TRABAJADOR_DNI%type,
VMATRICULA out PARTE.VEHICULO_MATRICULA%type

) AS
BEGIN

 SELECT FECHA,KMINICIO,KMFINAL,INCIDENCIAS,AVISOS,FINALIZADO,GASOIL,AUTOPISTAS,DIETAS,OTROSGASTOS,HORASTRABAJADAS,TRABAJADOR_DNI,VEHICULO_MATRICULA
      into VFECHA  ,VKMINICIO  ,VKMFINAL  ,VINCIDENCIAS  ,VAVISOS   ,vFINALIZADO  ,VGASOIL  ,VAUTOPISTAS  ,VDIETAS ,VOTROSGASTOS,VHORASTRABAJADAS  ,VTRABVAJADOR  ,VMATRICULA  
   FROM PARTE
     WHERE 
         FINALIZADO=V_ESTADO;

END;