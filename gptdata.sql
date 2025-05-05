INSERT INTO `gestionempleados`.`banco` (`BancoId`, `BancoNombre`) VALUES
(1, 'Banco Pichincha'),
(2, 'Banco de Guayaquil'),
(3, 'Banco del Austro'),
(4, 'Produbanco'),
(5, 'Banco Internacional');

INSERT INTO `gestionempleados`.`empleado`
(`EmpId`, `EmpActivo`, `EmpApMaterno`, `EmpApPaterno`, `EmpCod`, `EmpDni`, `EmpFechaNac`, `EmpFoto`, `EmpGenero`, `EmpNombre`, `EmpEstadoCivil`)
VALUES
(1, 1, 'Vargas', 'Pérez', 'E0001', '1710001', '1990-05-15', 'E0001.png', 0, 'Juan', 1), -- Soltero
(2, 1, 'López', 'García', 'E0002', '1720002', '1985-12-01', 'E0002.png', 1, 'María', 2), -- Casado
(3, 0, 'Torres', 'Ruiz', 'E0003', '1730003', '1992-08-22', 'E0003.jpg', 0, 'Carlos', 3), -- Divorciado (inactivo)
(4, 1, 'Castro', 'Díaz', 'E0004', '1740004', '1988-03-10', 'E0004.png', 1, 'Ana', 4), -- Viudo
(5, 1, 'Guerrero', 'Sanchez', 'E0005', '1750005', '1995-07-04', 'E0005.png', 0, 'Luis', 1);

INSERT INTO `gestionempleados`.`contrato`
(`ContId`, `fechaEmision`, `fechaFin`, `fechaInicio`, `ContArea`, `ContEmpleado`, `ContJLaboral`, `ContModalidadCont`)
VALUES
(1, '2023-01-15', '2023-12-31', '2023-01-15', 1, 1, 1, 1), -- Area 1, Empleado 1, Jornada 1, Modalidad 1
(2, '2023-03-01', '2023-12-31', '2023-03-01', 2, 2, 2, 2), -- Area 2, Empleado 2, Jornada 2, Modalidad 2
(3, '2023-05-10', '2023-12-31', '2023-05-10', 3, 4, 1, 2), -- Area 3, Empleado 4, Jornada 1, Modalidad 2
(4, '2023-07-01', '2023-12-31', '2023-07-01', 4, 5, 2, 1), -- Area 4, Empleado 5, Jornada 2, Modalidad 1
(5, '2023-09-15', '2023-12-31', '2023-09-15', 1, 3, 1, 1); -- Area 1, Empleado 3, Jornada 1, Modalidad 1

INSERT INTO `gestionempleados`.`cuentabancaria`
(`CuentaId`, `CuentaCci`, `CuentaBanco`, `CuentaEmpleado`)
VALUES
(1, '00112233445566778899', 1, 1), -- Banco 1, Empleado 1
(2, '99887766554433221100', 2, 2), -- Banco 2, Empleado 2
(3, '11223344556677880099', 3, 3), -- Banco 3, Empleado 3
(4, '00998877665544332211', 4, 4), -- Banco 4, Empleado 4
(5, '22334455667788990011', 5, 5); -- Banco 5, Empleado 5

INSERT INTO `gestionempleados`.`login`
(`IdLogin`,`Contrasena`,`Estado`,`Horas`,`Usuario`,`IdEmpleado`)
VALUES
(0,123,false,null,'sa',3);

