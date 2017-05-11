create or replace package paqueteparte is
		type tipocursor  is REF CURSOR;
--con cursor por varias filas
PROCEDURE intervalofechamasDni(introFechaIni in parte.fecha%type,
				introFechaFin in parte.fecha%type,introDni in parte.trabajador_dni%type,
					nombreInter out tipocursor
					);
PROCEDURE parteporfecha(introFechaIni in parte.fecha%type,
		nombreP out tipocursor
			);
PROCEDURE soloidParte(introFecha in parte.fecha%type,vidparte out tipocursor);
PROCEDURE intervalofecha(
			introFechaIni in parte.fecha%type,
				introFechaFin in parte.fecha%type,
					nombreC out tipocursor
					) ;
PROCEDURE solodni(Cparte out  tipocursor,introDni in parte.trabajador_dni%type);
--con variables solo una fila		
PROCEDURE parte_abierto (vdni in parte.trabajador_dni%type,
vidparte out parte.idparte%type,
            vfecha out parte.fecha%type,
			vkminicio out parte.kmInicio%type,
			vkmFinal out parte.kmfinal%type,
			vfinalizado out parte.finalizado%type,
			vavisos out parte.avisos%type,
			vgasoil out parte.gasoil%type,
			vautopista out parte.autopistas%type,
			vdietas out parte.dietas%type,
			votrosGastos out parte.otrosGastos%type,
			vincidencias out parte.incidencias%type,
			vhorasTrabajadas out parte.horasTrabajadas%type,
			vtrabajador_dni out PARTE.TRABAJADOR_DNI%type,
			vvehiculo_matricula out parte.vehiculo_matricula%type
			);
					
PROCEDURE partefeydni(introFechaIni in parte.fecha%type,introDni in parte.trabajador_dni%type, 
			vidparte out parte.idparte%type,
			vfecha out parte.fecha%type,
			vkminicio out parte.kmInicio%type,
			vkmFinal out parte.kmfinal%type,
			vfinalizado out parte.finalizado%type,
			vavisos out parte.avisos%type,
			vgasoil out parte.gasoil%type,
			vautopista out parte.autopistas%type,
			vdietas out parte.dietas%type,
			votrosGastos out parte.otrosGastos%type,
			vincidencias out parte.incidencias%type,
			vhorasTrabajadas out parte.horasTrabajadas%type,
			vtrabajador_dni out parte.trabajador_dni%type,
			vvehiculo_matricula out parte.vehiculo_matricula%type);
PROCEDURE parteporID(introId in parte.idparte%type, 
			vidparte out parte.idparte%type,
			vfecha out parte.fecha%type,
			vkminicio out parte.kmInicio%type,
			vkmFinal out parte.kmfinal%type,
			vfinalizado out parte.finalizado%type,
			vavisos out parte.avisos%type,
			vgasoil out parte.gasoil%type,
			vautopista out parte.autopistas%type,
			vdietas out parte.dietas%type,
			votrosGastos out parte.otrosGastos%type,
			vincidencias out parte.incidencias%type,
			vhorasTrabajadas out parte.horasTrabajadas%type,
			vtrabajador_dni out PARTE.TRABAJADOR_DNI%type,
			vvehiculo_matricula out parte.vehiculo_matricula%type);

--otros
PROCEDURE listaViajes(introFecha in parte.fecha%type,nombreC out tipocursor);
end paqueteparte;
---------------------------------------------------------------------------------------
create or replace package body paqueteparte is
PROCEDURE parte_abierto(vdni in parte.trabajador_dni%type,
vidparte out parte.idparte%type,
            vfecha out parte.fecha%type,
			vkminicio out parte.kmInicio%type,
			vkmFinal out parte.kmfinal%type,
			vfinalizado out parte.finalizado%type,
			vavisos out parte.avisos%type,
			vgasoil out parte.gasoil%type,
			vautopista out parte.autopistas%type,
			vdietas out parte.dietas%type,
			votrosGastos out parte.otrosGastos%type,
			vincidencias out parte.incidencias%type,
			vhorasTrabajadas out parte.horasTrabajadas%type,
			vtrabajador_dni out PARTE.TRABAJADOR_DNI%type,
			vvehiculo_matricula out parte.vehiculo_matricula%type) AS BEGIN
 
        SELECT idparte,fecha,kmInicio,kmfinal,finalizado,gasoil,autopistas,dietas,otrosGastos,incidencias,horasTrabajadas,trabajador_dni,vehiculo_matricula,avisos
        into vidparte,vfecha,vkminicio,vkmFinal,vfinalizado,vgasoil,vautopista,vdietas,votrosGastos,vincidencias,vhorasTrabajadas,vtrabajador_dni,vvehiculo_matricula,vavisos
        FROM parte WHERE  finalizado='f' and trabajador_dni=vdni;
        end;
PROCEDURE parteporfecha(introFechaIni in parte.fecha%type,
		nombreP out tipocursor
			) AS
    BEGIN
    open nombreP for
        SELECT * FROM parte WHERE fecha=introFechaIni;       end;
PROCEDURE intervalofecha(
			introFechaIni in parte.fecha%type,
				introFechaFin in parte.fecha%type,
					nombreC out tipocursor
					) AS

  				  BEGIN
						 open nombreC for 
 					SELECT * FROM parte WHERE fecha between introFechaIni and introFechaFin;
			end;
PROCEDURE listaViajes(introFecha in parte.fecha%type,nombreC out tipocursor
	)as 
		begin 
			open nombreC for 
					SELECT * from viaje where idviaje like (SELECT idparte from parte where fecha=introFecha);
 				end;			
PROCEDURE soloidParte(introFecha in parte.fecha%type,vidparte out tipocursor)	 AS
    BEGIN
    open vidparte for
        SELECT idparte
        FROM parte WHERE fecha=introFecha;       
				end;
      
PROCEDURE partefeydni(introFechaIni in parte.fecha%type,introDni in parte.trabajador_dni%type,
	        vidparte out parte.idparte%type,
            vfecha out parte.fecha%type,
			vkminicio out parte.kmInicio%type,
			vkmFinal out parte.kmfinal%type,
			vfinalizado out parte.finalizado%type,
			vavisos out parte.avisos%type,
			vgasoil out parte.gasoil%type,
			vautopista out parte.autopistas%type,
			vdietas out parte.dietas%type,
			votrosGastos out parte.otrosGastos%type,
			vincidencias out parte.incidencias%type,
			vhorasTrabajadas out parte.horasTrabajadas%type,
			vtrabajador_dni out parte.trabajador_dni%type,
			vvehiculo_matricula out parte.vehiculo_matricula%type)				
      			as
            begin
  				SELECT idparte,fecha,kmInicio,kmfinal,finalizado,gasoil,autopistas,dietas,otrosGastos,incidencias,horasTrabajadas,trabajador_dni,vehiculo_matricula,avisos
        into vidparte,vfecha,vkminicio,vkmFinal,vfinalizado,vgasoil,vautopista,vdietas,votrosGastos,vincidencias,vhorasTrabajadas,vtrabajador_dni,vvehiculo_matricula,vavisos
        FROM parte WHERE fecha=introFechaIni and TRABAJADOR_DNI=introDni;
 end;
 PROCEDURE solodni(Cparte out tipocursor,introDni in parte.trabajador_dni%type)
      as 
      begin
      open Cparte for
      		select * from Parte where trabajador_dni=introDni;end;
  
PROCEDURE parteporID(introId in parte.idparte%type, 
			vidparte out parte.idparte%type,
			vfecha out parte.fecha%type,
			vkminicio out parte.kmInicio%type,
			vkmFinal out parte.kmfinal%type,
			vfinalizado out parte.finalizado%type,
			vavisos out parte.avisos%type,
			vgasoil out parte.gasoil%type,
			vautopista out parte.autopistas%type,
			vdietas out parte.dietas%type,
			votrosGastos out parte.otrosGastos%type,
			vincidencias out parte.incidencias%type,
			vhorasTrabajadas out parte.horasTrabajadas%type,
			vtrabajador_dni out parte.trabajador_dni%type,
			vvehiculo_matricula out parte.vehiculo_matricula%type)AS
           BEGIN
		SELECT idparte,fecha,kmInicio,kmfinal,finalizado,gasoil,autopistas,dietas,otrosGastos,incidencias,horasTrabajadas,trabajador_dni,vehiculo_matricula,avisos
        into vidparte,vfecha,vkminicio,vkmFinal,vfinalizado,vgasoil,vautopista,vdietas,votrosGastos,vincidencias,vhorasTrabajadas,vtrabajador_dni,vvehiculo_matricula,vavisos
        FROM parte WHERE IDPARTE=introId;
        END;
PROCEDURE intervalofechamasDni(introFechaIni in parte.fecha%type,
				introFechaFin in parte.fecha%type,introDni in parte.trabajador_dni%type,
					nombreInter out tipocursor)as
			begin 
					open nombreInter for 
					select * from parte where trabajador_dni=introDni and fecha between introFechaIni and introFechaFin;
					end;

 end;