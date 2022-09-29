CREATE DATABASE RestauranteDeOtroMundo;
USE RestauranteDeOtroMundo;

CREATE TABLE Empleado(
    CodigoEmpleado VARCHAR(5) NOT NULL,
    Nombre VARCHAR(20) NOT NULL,
    Apellido VARCHAR(20) NOT NULL,
    Salario INT NOT NULL,
    AgnoNacimiento INT NOT NULL,
    TipoEmpleo VARCHAR(15) ,
    PRIMARY KEY(CodigoEmpleado)
);

CREATE TABLE Platillo(
    CodigoPlatillo VARCHAR(5) NOT NULL,
    NombrePlatillo VARCHAR(25) NOT NULL,
    Precio DECIMAL(5,2) NOT NULL,
    TipoPlatillo VARCHAR(20),
    PRIMARY KEY(CodigoPlatillo)
);

CREATE TABLE Usuario(
    User VARCHAR(10) NOT NULL,
    CodigoEmpleado VARCHAR(5) NOT NULL,
    Pass VARCHAR(8) NOT NULL,
    TipoUsuario VARCHAR(15) NOT NULL,
    PRIMARY KEY(User),
    FOREIGN KEY(CodigoEmpleado)
REFERENCES Empleado(CodigoEmpleado)
);

CREATE TABLE Factura(
    NumeroFactura INT NOT NULL AUTO_INCREMENT,
    NombrePlatillo VARCHAR(25) NOT NULL,
    CodigoPlatillo VARCHAR(5) NOT NULL,
    Precio DECIMAL(5,2) NOT NULL,
    NombreCliente VARCHAR(25) NOT NULL,
    NITCliente VARCHAR(9) NOT NULL,
    Vendedor VARCHAR(5) NOT NULL,
    PRIMARY KEY(NumeroFactura),
    FOREIGN KEY(Vendedor)
REFERENCES Empleado(CodigoEmpleado),
    FOREIGN KEY(CodigoPlatillo)
REFERENCES Platillo(CodigoPlatillo)
);

INSERT INTO Empleado VALUES
("EA001","Amelia","Alvarez",7350,1992,"Administrador"),
("EC001","Andres Noé","Rangel Pérez",2500,2001,"Cajero"),
("EC002","Hugo Leonel","López López",2700,1999,"Cajero"),
("EC003","María Inés","Chajón Soto",2400,2002,"Cajero"),
("EC004","Alejandra","López Villacorta",3100,2000,"Cajero"),
("EM001","Ana Lucia","Reynosa Tecun",2400,2003,"Mesero"),
("EM002","Fredy Haroldo","Bernal Villalta",2700,2001,"Mesero"),
("EM003","Eva Maria","Garcia",3000,1998,"Mesero"),
("EM004","Karol","Perez Sarceño",2800,2000,"Mesero"),
("EP001","Juan Alfonso","Muños Afre",2400,2004,"Conserje"),
("EP002","Cesar Enrique","Torres Garcia",2930,2001,"Conserje");

INSERT INTO Platillo VALUES
("PD001","Omelette",50,"Desayuno"),
("PD002","Pancakes",30,"Desayuno"),
("PD003","Desayuno Típico",50,"Desayuno"),
("PD004","Croissant con Omelette",25,"Desayuno"),
("PD005","Desayuno Griego",40,"Desayuno"),
("PF001","Club Sandwich",40,"Fuertes"),
("PF002","Cheeseburger",45,"Fuertes"),
("PF003","Pizza Personal",45,"Fuertes"),
("PF004","Lasagna Bolognesa",60,"Fuertes"),
("PF005","Spaghetti Alla Bolognesa",55,"Fuertes"),
("BF001","Limonada",15,"Bebidas Frias"),
("BF002","Naranjada",15,"Bebidas Frias"),
("BF003","Gaseosa",15,"Bebidas Frias"),
("BF004","Cerveza",20,"Bebidas Frias"),
("BF005","Vino",25,"Bebidas Frias"),
("BC001","Café",10,"Bebida Caliente"),
("BC002","Té",10,"Bebida Caliente"),
("BC003","Chocolate",12,"Bebida Caliente"),
("BC004","Cappuccino",15,"Bebida Caliente"),
("BC005","Latte",20,"Bebida Caliente"),
("PP001","Crepas",30,"Postre"),
("PP002","Porción de Pastel",20,"Postre"),
("PP003","Tres Leches",35,"Postre"),
("PP004","Macarrones Dulces",25,"Postre"),
("PP005","Helado",20,"Postre");

INSERT INTO Usuario VALUES
("UserD001","EA001","cychrfks","Administrador"),
("UserC001","EC001","kxfrzpjw","Cajero"),
("UserC002","EC002","wnkctjam","Cajero"),
("UserC003","EC003","fcnedxaz","Cajero"),
("UserC004","EC004","fjkcmnmr","Cajero");

INSERT INTO Factura VALUES
(1,"Gaseosa","BF003",15,"Amanda Alvarez","325487529","EC003"),
(2,"Pizza Personal","PF003",45,"Amanda Alvarez","325487529","EC003"),
(3,"Té","BC002",10,"Ana Armira","359678547","EC003"),
(4,"Crepas","PP001",30,"Ana Armira","359678547","EC003"),
(5,"Vino","BF005",25,"Cesar Valenzuela","856974128","EC001"),
(6,"Spaghetti Alla Bolognesa","PF005",55,"Cesar Valenzuela","856974128","EC001"),
(7,"Limonada","BF001",15,"Agustin Depaz","487563297","EC004"),
(8,"Cheeseburger","PF002",45,"José Fuentes","487563297","EC004"),
(9,"Chocolate","BC003",12,"Silvia Enriquez","078523146","EC002"),
(10,"Macarrones Dulces","PP004",25,"Mariano Mox","078523146","EC002"),
(11,"Gaseosa","BF003",15,"Sheyla Garcia","569701346","EC001"),
(12,"Cheeseburger","PF002",45,"Sheyla Garcia","569701346","EC001");

DROP DATABASE RestauranteDeOtroMundo;

DROP TABLE Factura;

System cls;

Select * from Platillo;

Select * from Factura;

SELECT * FROM Factura WHERE Precio > 40 ORDER BY Precio DESC LIMIT 5;

SELECT NombrePlatillo, COUNT(NombrePlatillo) FROM Factura;

SELECT Factura.NombrePlatillo, COUNT(Factura.NombrePlatillo) FROM Factura INNER JOIN Platillo ON Factura.NombrePlatillo = Platillo.NombrePlatillo WHERE Platillo.TipoPlatillo = "Fuertes" GROUP BY NombrePlatillo ORDER BY COUNT(Factura.NombrePlatillo) DESC LIMIT 5;

DELETE FROM Factura WHERE NumeroFactura = 11;