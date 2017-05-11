create or replace trigger horasExtras
 before insert ON PARTE for each row
 DECLARE
 HORAS PARTE.HORASTRABAJADAS%TYPE;
begin  
 select horastrabajadas into horas from PARTE;
 if horas>8 then
    insert into parte(avisos) values('tiene horas extras');
end if;
end;