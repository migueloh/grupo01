
CREATE or replace package paquetecentros is
		type tipocursor  is SYS_REFCURSOR;
PROCEDURE consulta_Centro (vnombre in Centro.nombre%type,v_nombre in Centro.nombre%type,
vnombre out CENTRO.NOMBRE%type,
vcalle out CENTRO.CALLE%type,
vnumero out CENTRO.NUMERO%type,
vcodpostal out CENTRO.CODPOSTAL%type,
vciudad out CENTRO.CIUDAD%type,
vprovincia out CENTRO.PROVINCIA%type,
vtelefono out CENTRO.TELEFONO%type);
		PROCEDURE listacentros(nombreC out tipocursor);
	end gest_centros;
/*-------------------------------------------------------------------*/

create or replace package body paquetecentros is
 PROCEDURE listacentros(nombreC out tipocursor) IS
        BEGIN
        OPEN nombreC FOR
        SELECT * from centro;
    
    END;
PROCEDURE consulta_Centro (v_nombre in Centro.nombre%type,
vnombre out CENTRO.NOMBRE%type,
vcalle out CENTRO.CALLE%type,
vnumero out CENTRO.NUMERO%type,
vcodpostal out CENTRO.CODPOSTAL%type,
vciudad out CENTRO.CIUDAD%type,
vprovincia out CENTRO.PROVINCIA%type,
vtelefono out CENTRO.TELEFONO%type
) AS
    BEGIN
    
        SELECT nombre,calle,numero,CODPOSTAL,CIUDAD,PROVINCIA,TELEFONO
        into vnombre ,vcalle ,vnumero ,vcodpostal,vciudad ,vprovincia ,vtelefono 
        FROM centro WHERE nombre=v_nombre;
 
    END;

end;

