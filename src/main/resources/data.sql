insert into curso (nombre) values ('1A');
insert into curso (nombre) values ('1B');
insert into curso (nombre) values ('2A');
insert into curso (nombre) values ('2B');
insert into curso (nombre) values ('3A');
insert into curso (nombre) values ('3B');

insert into plan (nombre) values ('P2023-2024-1A');
insert into plan (nombre) values ('P2023-2024-1B');
insert into plan (nombre) values ('P2023-2024-2A');
insert into plan (nombre) values ('P2023-2024-2B');
insert into plan (nombre,FK_CURSO) values ('P2023-2024-3A','1A');
insert into plan (nombre,FK_CURSO) values ('P2023-2024-3B','1B');

insert into tutor (nombre,email) values ('Marcos','marcos@educastur.org');
insert into tutor (nombre,email) values ('Javier','javier@educastur.org');
insert into tutor (nombre,email,plan) values ('Maria','maria@educastur.org',3);
insert into tutor (nombre,email,plan) values ('Marta','marta@educastur.org',4);
insert into tutor (nombre,email,plan) values ('Pedro','pedro@educastur.org',5);
insert into tutor (nombre,email,plan) values ('Lucia','lucia@educastur.org',6);

insert into actividad (nombre,obligatoria,descripcion) values ('Sindromín',true,'Ayudar al ciego a bajar las escaleras sin que se mate');
insert into actividad (nombre,obligatoria,descripcion) values ('Pirar',false,'Ir a comer el pinchu con Pablo y Luis');
insert into actividad (nombre,obligatoria,descripcion) values ('Tallerucu Valnalon',true,'La asistencia es obligatoria. Es vuestra obligacion venir a clase y ounto, eso no vamos a discutirlo.');

insert into enmarca (actividad_id,plan_id,fecha) values (1,1,'02/03/2024');
insert into enmarca (actividad_id,plan_id,fecha) values (2,1,'02/03/2024');
insert into enmarca (actividad_id,plan_id,fecha) values (2,3,'01/02/2024');

insert into usuario (usuario,password) values ('jandro','$2a$12$EHvekiKap.Xz2bwApHmA5uCp.AkeZ0AVsHhNr8HafGF1jNJ4jG9Aa');




