CREATE OR PROCEDURE vehiculoObjetoVacio(
CURSOR V IS SYS_REFCURSOR
            ) AS
    BEGIN
 OPEN CURSORV FOR 
        SELECT *
        
        FROM VEHICULO WHERE MATRICULA='SIN RELLENAR';       
end;