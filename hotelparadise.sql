CREATE DATABASE IF NOT exists hotel;
USE hotel;

CREATE TABLE Reservas (
id_reserva int auto_increment not null primary key,
fecha_entrada date not null,
fecha_salida date,
valor decimal(10,2),
formaPago varchar(50)
);


-- Creamos los nuevos triggers para calcular el valor automáticamente
DELIMITER //

-- Trigger para el evento INSERT
CREATE TRIGGER calcular_valor_reserva_insert BEFORE INSERT ON Reservas
FOR EACH ROW
BEGIN
  SET NEW.valor = 100 * DATEDIFF(NEW.fecha_salida, NEW.fecha_entrada);
END;

-- Trigger para el evento UPDATE
CREATE TRIGGER calcular_valor_reserva_update BEFORE UPDATE ON Reservas
FOR EACH ROW
BEGIN
  SET NEW.valor = 100 * DATEDIFF(NEW.fecha_salida, NEW.fecha_entrada);
END;
//
DELIMITER ;


CREATE TABLE Huespedes(
id_huesped int auto_increment not null primary key,
nombre varchar(100) not null,
apellido varchar(100) not null,
fecha_nacimiento date not null,
nacionalidad varchar(100) not null,
telefono varchar(20) not null unique,
codigo_pais varchar(5) null,
id_reserva int NULL,
FOREIGN KEY (id_reserva) REFERENCES Reservas(id_reserva) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Huespedes (nombre, apellido, fecha_nacimiento, nacionalidad, telefono)
VALUES ('Jessica', 'Gaytán Cruz' , '2003-08-08', 'México','5524234233'),
		('José Luis', 'Garza Espinoza' , '2003-04-26', 'México','5522423132'),
        ('Concepcion', 'Cruz Tapia' , '1974-09-15', 'México','5599873423');

INSERT INTO Reservas (fecha_entrada, fecha_salida, formaPago)
VALUES ('2023-08-05', '2023-08-08', 'Tarjeta de Débito'),
		('2024-02-02', '2024-02-11', 'Tarjeta de Crédito'),
        ('2023-04-26', '2023-05-01', 'Pago en Efectivo');

Select * from Reservas;
Select * from Huespedes;

