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