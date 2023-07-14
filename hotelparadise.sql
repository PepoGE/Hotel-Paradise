CREATE DATABASE IF NOT exists hotel;
USE hotel;

CREATE TABLE Reservas (
id_reserva int auto_increment not null primary key,
fecha_entrada date not null,
fecha_salida date,
valor decimal(10,2),
formaPago varchar(50)
);

CREATE TABLE Huespedes(
id_huespeded int auto_increment not null primary key,
nombre varchar(100) not null,
apellido varchar(100) not null,
fecha_nacimiento date not null,
nacionalidad varchar(100) not null,
telefono varchar(10) not null,
id_reserva int NULL,
FOREIGN KEY (id_reserva) REFERENCES Reservas(id_reserva) ON UPDATE CASCADE ON DELETE CASCADE
);

Select * from Reservas;
Select * from Huespedes;

