SET AUTOCOMMIT OFF;
commit;
--Enumeraciones
CREATE TABLE TIPO_USUARIO (
    TIPO_USUARIO VARCHAR2(30 CHAR),
    CONSTRAINT TIPO_USUARIO PRIMARY KEY (TIPO_USUARIO)
); 

INSERT INTO TIPO_USUARIO(TIPO_USUARIO) VALUES ('CLIENTE NATURAL');
INSERT INTO TIPO_USUARIO(TIPO_USUARIO) VALUES ('CLIENTE JURIDICO');
INSERT INTO TIPO_USUARIO(TIPO_USUARIO) VALUES ('CAJERO');
INSERT INTO TIPO_USUARIO(TIPO_USUARIO) VALUES ('GERENTE DE OFICINA');
INSERT INTO TIPO_USUARIO(TIPO_USUARIO) VALUES ('GERENTE GENERAL');



CREATE TABLE ESTADO_CUENTA (
    ESTADO_CUENTA VARCHAR2(30 CHAR),
    CONSTRAINT TIPO_USUARIO_PK PRIMARY KEY (ESTADO_CUENTA)
); 


INSERT INTO ESTADO_CUENTA(ESTADO_CUENTA) VALUES ('CERRADA');
INSERT INTO ESTADO_CUENTA(ESTADO_CUENTA) VALUES ('ACTIVA');
INSERT INTO ESTADO_CUENTA(ESTADO_CUENTA) VALUES ('DESACTIVADA');



CREATE TABLE TIPO_CUENTA (
    TIPO_CUENTA VARCHAR2(30 CHAR),
    CONSTRAINT TIPO_CUENTA_PK PRIMARY KEY (TIPO_CUENTA)
); 


INSERT INTO TIPO_CUENTA(TIPO_CUENTA) VALUES ('AHORROS');
INSERT INTO TIPO_CUENTA(TIPO_CUENTA) VALUES ('CORRIENTE');
INSERT INTO TIPO_CUENTA(TIPO_CUENTA) VALUES ('AFC');


CREATE TABLE TIPO_OPERACION_CUENTA (
    TIPO_OPERACION_CUENTA VARCHAR2(30 CHAR),
    CONSTRAINT TIPO_OPERACION_CUENTA_PK PRIMARY KEY (TIPO_OPERACION_CUENTA)
); 


INSERT INTO TIPO_OPERACION_CUENTA(TIPO_OPERACION_CUENTA) VALUES ('CONSIGNAR');
INSERT INTO TIPO_OPERACION_CUENTA(TIPO_OPERACION_CUENTA) VALUES ('RETIRAR');
INSERT INTO TIPO_OPERACION_CUENTA(TIPO_OPERACION_CUENTA) VALUES ('TRANSFERIR');


CREATE TABLE TIPO_OPERACION_PRESTAMO (
    TIPO_OPERACION_PRESTAMO VARCHAR2(30 CHAR),
    CONSTRAINT TIPO_OPERACION_PRESTAMO_PK PRIMARY KEY (TIPO_OPERACION_PRESTAMO)
); 


INSERT INTO TIPO_OPERACION_PRESTAMO(TIPO_OPERACION_PRESTAMO) VALUES ('PAGO ORDINARIO');
INSERT INTO TIPO_OPERACION_PRESTAMO(TIPO_OPERACION_PRESTAMO) VALUES ('PAGO EXTRAORDINARIO');



CREATE TABLE TIPO_PUNTO_ATENCION (
    TIPO_PUNTO_ATENCION VARCHAR2(30 CHAR),
    CONSTRAINT TIPO_PUNTO_ATENCION_PK PRIMARY KEY (TIPO_PUNTO_ATENCION)
); 


INSERT INTO TIPO_PUNTO_ATENCION(TIPO_PUNTO_ATENCION) VALUES ('PERSONALIZADA');
INSERT INTO TIPO_PUNTO_ATENCION(TIPO_PUNTO_ATENCION) VALUES ('CAJERO AUTOMATICO');
INSERT INTO TIPO_PUNTO_ATENCION(TIPO_PUNTO_ATENCION) VALUES ('AUTOSERVICIO');



CREATE TABLE ESTADO_PRESTAMO (
    ESTADO_PRESTAMO VARCHAR2(30 CHAR),
    CONSTRAINT ESTADO_PRESTAMO_PK PRIMARY KEY (ESTADO_PRESTAMO)
); 


INSERT INTO ESTADO_PRESTAMO(ESTADO_PRESTAMO) VALUES ('APROBADO');
INSERT INTO ESTADO_PRESTAMO(ESTADO_PRESTAMO) VALUES ('CERRADO');
INSERT INTO ESTADO_PRESTAMO(ESTADO_PRESTAMO) VALUES ('SOLICITADO');

CREATE TABLE TIPO_DOCUMENTO (
    TIPO_DOCUMENTO VARCHAR2(30 CHAR),
    CONSTRAINT TIPO_DOCUMENTO_PK PRIMARY KEY (TIPO_DOCUMENTO)
); 


INSERT INTO TIPO_DOCUMENTO(TIPO_DOCUMENTO) VALUES ('CC');
INSERT INTO TIPO_DOCUMENTO(TIPO_DOCUMENTO) VALUES ('CE');
INSERT INTO TIPO_DOCUMENTO(TIPO_DOCUMENTO) VALUES ('REGISTRO CIVIL');
INSERT INTO TIPO_DOCUMENTO(TIPO_DOCUMENTO) VALUES ('TI');



CREATE TABLE TIPO_PRESTAMO (
    TIPO_PRESTAMO VARCHAR2(30 CHAR),
    CONSTRAINT TIPO_PRESTAMO_PK PRIMARY KEY (TIPO_PRESTAMO)
); 


INSERT INTO TIPO_PRESTAMO(TIPO_PRESTAMO) VALUES ('VIVIENDA');
INSERT INTO TIPO_PRESTAMO(TIPO_PRESTAMO) VALUES ('ESTUDIO');
INSERT INTO TIPO_PRESTAMO(TIPO_PRESTAMO) VALUES ('AUTOMOVIL');
INSERT INTO TIPO_PRESTAMO(TIPO_PRESTAMO) VALUES ('LIBRE INVERSION');




--TABLA DATOS USUARIO

CREATE SEQUENCE datos_usuario_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE DATOS_USUARIO (
    ID_USUARIO NUMBER DEFAULT datos_usuario_seq.NEXTVAL,
    LOGIN VARCHAR2(40 CHAR) NOT NULL,
    clave VARCHAR2(40 CHAR) NOT NULL,
    CONSTRAINT datos_usuario_pk PRIMARY KEY (ID_USUARIO)
); 

INSERT INTO datos_usuario (LOGIN, clave) VALUES ('rockstar', 'guitarhero');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('codingninja', 'coder123');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('bookworm', 'readingbooks');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('travelbug', 'worldtravel');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('coffeelover', 'coffeetime');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('musicaddict', 'melodyrocks');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('beachbum', 'sandandsun');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('moviebuff', 'popcornmovies');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('gamerguru', 'gaminglife');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('naturelover', 'treehugger');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('fitnessfanatic', 'workout321');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('petparent', 'furryfriend');
INSERT INTO datos_usuario (LOGIN, clave) VALUES ('artenthusiast', 'colorpalette');

--TABLE USUARIO

CREATE TABLE USUARIO
(
    ID_USUARIO NUMBER,
    TIPO_DOCUMENTO VARCHAR2(30 CHAR) NOT NULL,
    NUMERO_DOCUMENTO NUMBER NOT NULL,
    NOMBRE VARCHAR2(100 CHAR) NOT NULL,
    NACIONALIDAD VARCHAR2(30 CHAR) NOT NULL,
    DIRECCION_FISICA VARCHAR2(100 CHAR) NOT NULL,
    DIRECCION_DIGITAL VARCHAR2(100 CHAR) NOT NULL,
    TELEFONO NUMBER NOT NULL,
    CODIGO_POSTAL NUMBER NOT NULL,
    TIPO_USUARIO VARCHAR2(30 CHAR) NOT NULL,
    
    
    CONSTRAINT USUARIO_PK PRIMARY KEY (ID_USUARIO),
    CONSTRAINT USUARIO_FK_ID FOREIGN KEY (ID_USUARIO)
    REFERENCES DATOS_USUARIO(id_usuario),
    
    CONSTRAINT TIPO_DOCUMENTO_C FOREIGN  KEY (TIPO_DOCUMENTO)
    REFERENCES TIPO_DOCUMENTO(TIPO_DOCUMENTO),
    
    CONSTRAINT TIPO_USUARIO_C FOREIGN KEY (TIPO_USUARIO)
    REFERENCES TIPO_USUARIO(TIPO_USUARIO)
    
);


INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (1, 'CC', 123456789, 'Juan Perez', 'Colombiana', 'Calle 123', 'jperez@email.com', 1234567890, 12345, 'CLIENTE NATURAL');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (2, 'CE', 987654321, 'Maria Rodriguez', 'Colombiana', 'Avenida 456', 'mrodriguez@email.com', 9876543210, 54321, 'CLIENTE JURIDICO');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (3, 'CC', 234567890, 'Luisa Martinez', 'Colombiana', 'Carrera 789', 'lmartinez@email.com', 2345678901, 67890, 'CAJERO');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (4, 'CE', 876543210, 'Carlos Gutierrez', 'Colombiana', 'Calle 012', 'cgutierrez@email.com', 8765432109, 98765, 'GERENTE DE OFICINA');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (5, 'TI', 345678901, 'Ana Lopez', 'Colombiana', 'Carrera 111', 'alopez@email.com', 3456789012, 11111, 'GERENTE GENERAL');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (6, 'CE', 345678901, 'John Smith', 'Estadounidense', '123 Main St', 'jsmith@email.com', 1234567890, 54321, 'CLIENTE NATURAL');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (7, 'CE', 678901234, 'Alice Johnson', 'Canadiense', '456 Maple Ave', 'ajohnson@email.com', 2345678901, 65432, 'CLIENTE JURIDICO');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (8, 'CE', 901234567, 'Michael Brown', 'Brit�nica', '789 Oak Blvd', 'mbrown@email.com', 3456789012, 76543, 'CAJERO');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (9, 'CE', 234567890, 'Sophie Martinez', 'Francesa', '101 Elm St', 'smartinez@email.com', 4567890123, 87654, 'GERENTE DE OFICINA');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (10, 'CE', 567890123, 'Emily Jones', 'Australiana', '202 Pine St', 'ejones@email.com', 5678901234, 98765, 'GERENTE GENERAL');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (11, 'CC', 4546546, 'Daniel Roa', 'Colombiana', '123 casita St', 'dRosa@email.com', 111111, 54321, 'GERENTE DE OFICINA');

INSERT INTO USUARIO (ID_USUARIO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE, NACIONALIDAD, DIRECCION_FISICA, DIRECCION_DIGITAL, TELEFONO, CODIGO_POSTAL, TIPO_USUARIO)
VALUES (12, 'CC', 4546546, 'Andres Mendoza ', 'Colombiana', '123 casita St2', 'AMendoza@email.com', 132134, 543421, 'GERENTE DE OFICINA');
--TABLA PRESTAMO

CREATE SEQUENCE prestamo_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE PRESTAMO (
    ID_PRESTAMO NUMBER DEFAULT prestamo_seq.NEXTVAL,
    FECHA_CREACION DATE NOT NULL,
    MONTO NUMBER(20,4) NOT NULL,
    ESTADO_PRESTAMO VARCHAR2(20 CHAR) NOT NULL,
    tipo_prestamo VARCHAR2(20 CHAR) NOT NULL,
    INTERES NUMBER(6,4) NOT NULL,
    CUOTAS NUMBER(4,0) NOT NULL,
    DIA_MES_CUOTA NUMBER(2,0) NOT NULL,
    VALOR_CUOTA NUMBER(10,4) NOT NULL,
    
    
    CONSTRAINT prestamo_pk PRIMARY KEY (id_prestamo),
    
    CONSTRAINT estado_C FOREIGN KEY (ESTADO_PRESTAMO)
    REFERENCES ESTADO_PRESTAMO(ESTADO_PRESTAMO),
    
    CONSTRAINT TIPO_PRESTAMO_C FOREIGN KEY (TIPO_PRESTAMO)
    REFERENCES TIPO_PRESTAMO(TIPO_PRESTAMO)  );

INSERT INTO PRESTAMO (FECHA_CREACION, MONTO, ESTADO_PRESTAMO, TIPO_PRESTAMO, INTERES, CUOTAS, DIA_MES_CUOTA, VALOR_CUOTA)
VALUES (DATE '2024-04-20', 10000.00, 'APROBADO', 'VIVIENDA', 0.05, 12, 15, 895.78);

INSERT INTO PRESTAMO (FECHA_CREACION, MONTO, ESTADO_PRESTAMO, TIPO_PRESTAMO, INTERES, CUOTAS, DIA_MES_CUOTA, VALOR_CUOTA)
VALUES (DATE '2024-04-21', 15000.00, 'CERRADO', 'ESTUDIO', 0.06, 24, 10, 725.36);

INSERT INTO PRESTAMO (FECHA_CREACION, MONTO, ESTADO_PRESTAMO, TIPO_PRESTAMO, INTERES, CUOTAS, DIA_MES_CUOTA, VALOR_CUOTA)
VALUES (DATE '2024-04-22', 20000.00, 'APROBADO', 'VIVIENDA', 0.07, 18, 5, 1221.45);

INSERT INTO PRESTAMO (FECHA_CREACION, MONTO, ESTADO_PRESTAMO, TIPO_PRESTAMO, INTERES, CUOTAS, DIA_MES_CUOTA, VALOR_CUOTA)
VALUES (DATE '2024-04-23', 25000.00, 'APROBADO', 'AUTOMOVIL', 0.08, 36, 20, 1023.89);

INSERT INTO PRESTAMO (FECHA_CREACION, MONTO, ESTADO_PRESTAMO, TIPO_PRESTAMO, INTERES, CUOTAS, DIA_MES_CUOTA, VALOR_CUOTA)
VALUES (DATE '2024-04-24', 30000.00, 'CERRADO', 'LIBRE INVERSION', 0.09, 48, 25, 658.21);

INSERT INTO PRESTAMO (FECHA_CREACION, MONTO, ESTADO_PRESTAMO, TIPO_PRESTAMO, INTERES, CUOTAS, DIA_MES_CUOTA, VALOR_CUOTA)
VALUES (DATE '2024-04-25', 35000.00, 'APROBADO', 'ESTUDIO', 0.1, 6, 5, 6012.45);

INSERT INTO PRESTAMO (FECHA_CREACION, MONTO, ESTADO_PRESTAMO, TIPO_PRESTAMO, INTERES, CUOTAS, DIA_MES_CUOTA, VALOR_CUOTA)
VALUES (DATE '2024-04-26', 40000.00, 'APROBADO', 'VIVIENDA', 0.11, 12, 15, 3200.78);

INSERT INTO PRESTAMO (FECHA_CREACION, MONTO, ESTADO_PRESTAMO, TIPO_PRESTAMO, INTERES, CUOTAS, DIA_MES_CUOTA, VALOR_CUOTA)
VALUES (DATE '2024-04-27', 45000.00, 'CERRADO', 'AUTOMOVIL', 0.12, 24, 10, 4150.36);

INSERT INTO PRESTAMO (FECHA_CREACION, MONTO, ESTADO_PRESTAMO, TIPO_PRESTAMO, INTERES, CUOTAS, DIA_MES_CUOTA, VALOR_CUOTA)
VALUES (DATE '2024-04-28', 50000.00, 'APROBADO', 'VIVIENDA', 0.13, 18, 5, 9121.45);

INSERT INTO PRESTAMO (FECHA_CREACION, MONTO, ESTADO_PRESTAMO, TIPO_PRESTAMO, INTERES, CUOTAS, DIA_MES_CUOTA, VALOR_CUOTA)
VALUES (DATE '2024-04-29', 55000.00, 'APROBADO', 'LIBRE INVERSION', 0.14, 36, 20, 8223.89);

-- TABLA CREDENCIALES PRESTAMO

CREATE TABLE CREDENCIALES_PRESTAMO (
    ID_CLIENTE NUMBER,
    ID_PRESTAMO NUMBER,
    ID_GERENTE NUMBER,
    
    
    CONSTRAINT CREDENCIALES_PRESTAMO_pk PRIMARY KEY (ID_CLIENTE, ID_PRESTAMO),
    CONSTRAINT USUARIO_CREDENCIALES_USUARIO_C FOREIGN KEY (ID_CLIENTE)
    REFERENCES USUARIO(id_usuario),
    CONSTRAINT USUARIO_CREDENCIALES_GERENTE_C FOREIGN KEY (ID_GERENTE)
    REFERENCES USUARIO(id_usuario),
    CONSTRAINT USUARIO_CREDENCIALES_PRESTAMO_C FOREIGN KEY (ID_PRESTAMO)
    REFERENCES PRESTAMO(ID_PRESTAMO)
   
); 


INSERT INTO CREDENCIALES_PRESTAMO (ID_CLIENTE, ID_PRESTAMO, ID_GERENTE)
VALUES (1, 1, 4);

INSERT INTO CREDENCIALES_PRESTAMO (ID_CLIENTE, ID_PRESTAMO, ID_GERENTE)
VALUES (2, 2, 9);

INSERT INTO CREDENCIALES_PRESTAMO (ID_CLIENTE, ID_PRESTAMO, ID_GERENTE)
VALUES (1, 3, 4);

--CREAR OFICINA

CREATE SEQUENCE OFICINA_SEQ START WITH 1;

CREATE TABLE OFICINA
(
    ID_OFICINA NUMBER DEFAULT OFICINA_SEQ.NEXTVAL,
    NOMBRE VARCHAR2(20 CHAR) NOT NULL,
    DIRECCION VARCHAR2(30 CHAR) NOT NULL,
    NUMERO_PUNTOS_DISPONIBLES NUMBER NOT NULL,
    
    CONSTRAINT OFICINA_PK PRIMARY KEY (ID_OFICINA)

);


INSERT INTO OFICINA (NOMBRE, DIRECCION, NUMERO_PUNTOS_DISPONIBLES)
VALUES ('Oficina Central', 'Calle Principal 123', 5);

INSERT INTO OFICINA (NOMBRE, DIRECCION, NUMERO_PUNTOS_DISPONIBLES)
VALUES ('Oficina Norte', 'Avenida Norte 456', 3);

INSERT INTO OFICINA (NOMBRE, DIRECCION, NUMERO_PUNTOS_DISPONIBLES)
VALUES ('Oficina Sur', 'Carrera Sur 789', 4);

-- TABLA CREDENCIALES EMPLEADO OFICINA

CREATE TABLE CREDENCIALES_GERENTE_OFICINA (
    ID_GERENTE NUMBER,
    ID_OFICINA NUMBER,
    CONSTRAINT CREDENCIALES_EMPLEADO_OFICINA_pk PRIMARY KEY (ID_GERENTE, ID_OFICINA),
    CONSTRAINT USUARIO_CREDENCIALES_USUARIO_CC FOREIGN KEY (ID_GERENTE)
    REFERENCES USUARIO(id_usuario),
    CONSTRAINT USUARIO_CREDENCIALES_OFICINA_CC FOREIGN KEY (ID_OFICINA)
    REFERENCES OFICINA(ID_OFICINA)
); 

INSERT INTO CREDENCIALES_GERENTE_OFICINA (ID_GERENTE, ID_OFICINA)
VALUES (4, 1);

INSERT INTO CREDENCIALES_GERENTE_OFICINA (ID_GERENTE, ID_OFICINA)
VALUES (9, 2);

--TABLA CUENTA

CREATE SEQUENCE cuenta_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE CUENTA (

    ID_CUENTA NUMBER DEFAULT cuenta_seq.NEXTVAL,
    TIPO_CUENTA VARCHAR2(20 CHAR)NOT NULL,
    ESTADO_CUENTA VARCHAR2(20 CHAR)NOT NULL,
    SALDO NUMBER(20,4) NOT NULL,
    FECHA_ULTIMA_TRANSACCION DATE,
    
    CONSTRAINT CUENTA_PK PRIMARY KEY (ID_CUENTA),
    
    CONSTRAINT TIPO_CUENTA_C FOREIGN KEY (TIPO_CUENTA)
    REFERENCES TIPO_CUENTA(TIPO_CUENTA),
    
    CONSTRAINT ESTADO_CUENTA_C FOREIGN KEY (ESTADO_CUENTA)
    REFERENCES ESTADO_CUENTA(ESTADO_CUENTA)
);

INSERT INTO CUENTA (TIPO_CUENTA, ESTADO_CUENTA, SALDO, FECHA_ULTIMA_TRANSACCION)
VALUES ('AHORROS', 'ACTIVA', 5000.00, DATE '2024-04-18');

INSERT INTO CUENTA (TIPO_CUENTA, ESTADO_CUENTA, SALDO, FECHA_ULTIMA_TRANSACCION)
VALUES ('CORRIENTE', 'ACTIVA', 10000.00, DATE '2024-04-18');

INSERT INTO CUENTA (TIPO_CUENTA, ESTADO_CUENTA, SALDO, FECHA_ULTIMA_TRANSACCION)
VALUES ('AFC', 'ACTIVA', 20000.00, DATE '2024-04-18');

INSERT INTO CUENTA (TIPO_CUENTA, ESTADO_CUENTA, SALDO, FECHA_ULTIMA_TRANSACCION)
VALUES ('AHORROS', 'DESACTIVADA', 15000.00, DATE '2024-04-18');

INSERT INTO CUENTA (TIPO_CUENTA, ESTADO_CUENTA, SALDO, FECHA_ULTIMA_TRANSACCION)
VALUES ('CORRIENTE', 'CERRADA', 30000.00, DATE '2024-04-18');

--TABLA CREDENCIALES CUENTA
CREATE TABLE CREDENCIALES_CUENTA (
    ID_USUARIO NUMBER,
    ID_GERENTE NUMBER,
    ID_CUENTA NUMBER,
    CONSTRAINT CREDENCIALES_CUENTA_pk PRIMARY KEY (ID_USUARIO, ID_CUENTA),

    CONSTRAINT CUENTA_CREDENCIALES_USUARIO_CC FOREIGN KEY (ID_USUARIO)
    REFERENCES USUARIO(id_usuario),

    CONSTRAINT CUENTA_CREDENCIALES_GERENTE_CC FOREIGN KEY (ID_GERENTE)
    REFERENCES USUARIO(id_usuario),
    
    CONSTRAINT CUENTA_CREDENCIALES_CUENTA_CC FOREIGN KEY (ID_CUENTA)
    REFERENCES CUENTA(ID_CUENTA)
); 

INSERT INTO CREDENCIALES_CUENTA (ID_USUARIO, ID_GERENTE, ID_CUENTA)
VALUES (1,4,1);

INSERT INTO CREDENCIALES_CUENTA (ID_USUARIO, ID_GERENTE, ID_CUENTA)
VALUES (1,9,2);

INSERT INTO CREDENCIALES_CUENTA (ID_USUARIO, ID_GERENTE, ID_CUENTA)
VALUES (2,4,3);

--TABLA PUNTO ATENCION
CREATE SEQUENCE PUNTO_ATENCION_seq  START WITH 1
    INCREMENT BY 1;

CREATE TABLE PUNTO_ATENCION
(
    ID_PUNTO_ATENCION NUMBER DEFAULT PUNTO_ATENCION_seq.NEXTVAL,
    NOMBRE VARCHAR2(20 CHAR) NOT NULL,
    TIPO_PUNTO_ATENCION VARCHAR2(20 CHAR),
    LOCACION VARCHAR2(30 CHAR),
    HORARIO_APRETURA VARCHAR2(30 CHAR) NOT NULL,
    HORARIO_CIERRE VARCHAR2(30 CHAR) NOT NULL,
    ID_OFICINA NUMBER,

    CONSTRAINT PUNTO_ATENCION_PK PRIMARY KEY (ID_PUNTO_ATENCION),
    CONSTRAINT FK_TIPOS_ATENCION FOREIGN KEY (TIPO_PUNTO_ATENCION)
    REFERENCES TIPO_PUNTO_ATENCION(TIPO_PUNTO_ATENCION),
    CONSTRAINT FK_OFICINA_PUNTO_ATENCION FOREIGN KEY (ID_OFICINA)
    REFERENCES OFICINA(ID_OFICINA)

);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('Cajero A', 'PERSONALIZADA', 'Calle Principal 123', '09:00', '17:00', 1);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('Cajero B', 'PERSONALIZADA', 'Calle Principal 123', '09:00', '17:00', 1);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('Cajero C', 'PERSONALIZADA', 'Calle Principal 123', '09:00', '17:00', 1);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('Cajero D', 'PERSONALIZADA', 'Calle Principal 123', '09:00', '17:00', 1);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('Cajero E', 'PERSONALIZADA', 'Calle Principal 123', '09:00', '17:00', 1);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('Cajero A', 'PERSONALIZADA', 'Calle Principal 123', '09:00', '17:00', 2);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('Cajero B', 'PERSONALIZADA', 'Calle Principal 123', '09:00', '17:00', 2);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('Cajero C', 'PERSONALIZADA', 'Calle Principal 123', '09:00', '17:00', 2);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('Cajero automatico A', 'CAJERO AUTOMATICO', 'Avenida Oeste 345', '00:00', '23:59', 2);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('Cajero automatico A', 'CAJERO AUTOMATICO', 'Avenida Oeste 345', '00:00', '23:59', 1);

INSERT INTO PUNTO_ATENCION (NOMBRE, TIPO_PUNTO_ATENCION, LOCACION, HORARIO_APRETURA, HORARIO_CIERRE, ID_OFICINA)
VALUES ('WEB', 'AUTOSERVICIO', Null, '00:00', '23:59',Null);

--TABLA TRANSACCION CUENTA
CREATE SEQUENCE TRANS_CUENTA_seq  START WITH 1
    INCREMENT BY 1;


CREATE TABLE TRANSACCION_CUENTA
(
    ID_TRANSACCION_CUENTA NUMBER DEFAULT TRANS_CUENTA_seq.NEXTVAL,
    MONTO NUMBER(10,4) NOT NULL,
    FECHA_HORA DATE NOT NULL,
    ID_CAJERO NUMBER,
    ID_PUNTO_ATENCION NUMBER,
    TIPO_OPERACION_CUENTA VARCHAR2(20 CHAR),
    ID_CUENTA_ORIGINAL NUMBER NOT NULL,
    ID_CUENTA_DESTINO NUMBER, 

    CONSTRAINT TRANSACCION_CUENTA_PK PRIMARY KEY (ID_TRANSACCION_CUENTA),
    
    CONSTRAINT FK_ID_CAJERO_TRANSACCION_CUENTAT FOREIGN KEY (ID_CAJERO)
    REFERENCES USUARIO(ID_USUARIO),
    
    CONSTRAINT FK_OFICINA_PUNTO_ATENCIONT FOREIGN KEY (ID_PUNTO_ATENCION)
    REFERENCES PUNTO_ATENCION(ID_PUNTO_ATENCION),
    
    CONSTRAINT FK_TIPO_OPERACION_CUENTAT FOREIGN KEY (TIPO_OPERACION_CUENTA)
    REFERENCES TIPO_OPERACION_CUENTA(TIPO_OPERACION_CUENTA),
    
    CONSTRAINT FK_CUENTA_ORIGINAL_TRANSACCIONT FOREIGN KEY (ID_CUENTA_ORIGINAL)
    REFERENCES CUENTA(ID_CUENTA),
    
    CONSTRAINT FK_CUENTA_DESTINO_TRANSACCIONT FOREIGN KEY (ID_CUENTA_DESTINO)
    REFERENCES CUENTA(ID_CUENTA));


INSERT INTO TRANSACCION_CUENTA (MONTO, FECHA_HORA, ID_CAJERO, ID_PUNTO_ATENCION, TIPO_OPERACION_CUENTA, ID_CUENTA_ORIGINAL, ID_CUENTA_DESTINO)
VALUES (1000.00, TIMESTAMP '2024-04-25 12:00:00', 8, 1, 'CONSIGNAR', 1, NULL);

INSERT INTO TRANSACCION_CUENTA (MONTO, FECHA_HORA, ID_CAJERO, ID_PUNTO_ATENCION, TIPO_OPERACION_CUENTA, ID_CUENTA_ORIGINAL, ID_CUENTA_DESTINO)
VALUES (500.50, TIMESTAMP '2024-04-26 09:30:00', NULL, 12, 'CONSIGNAR', 2, NULL);

--TABLA TRANSACCION PRESTAMO
CREATE SEQUENCE TRANS_PRESTAMO_seq  START WITH 1
    INCREMENT BY 1;


CREATE TABLE TRANSACCION_PRESTAMO
(
    ID_TRANSACCION_PRESTAMO NUMBER DEFAULT TRANS_PRESTAMO_seq.NEXTVAL,
    MONTO NUMBER(10,4) NOT NULL,
    FECHA_HORA DATE NOT NULL,
    ID_CAJERO NUMBER NOT NULL,
    ID_PUNTO_ATENCION NUMBER NOT NULL,
    TIPO_OPERACION_PRESTAMO VARCHAR2(20 CHAR),
    ID_PRESTAMO NUMBER NOT NULL,


    CONSTRAINT TRANSACCION_PRESTAMO_PK PRIMARY KEY (ID_TRANSACCION_PRESTAMO),
    
    CONSTRAINT FK_ID_CAJERO_TRANSACCION_PRESTAMO FOREIGN KEY (ID_CAJERO)
    REFERENCES USUARIO(ID_USUARIO),
    
    CONSTRAINT FK_OFICINA_PUNTO_ATENCIONTPRESTAMO FOREIGN KEY (ID_PUNTO_ATENCION)
    REFERENCES PUNTO_ATENCION(ID_PUNTO_ATENCION),
    
    CONSTRAINT FK_TIPO_OPERACION_PRESTAMOT FOREIGN KEY (TIPO_OPERACION_PRESTAMO)
    REFERENCES TIPO_OPERACION_PRESTAMO(TIPO_OPERACION_PRESTAMO),
    
    CONSTRAINT FK_PRESTMO_TRANSACCIONP FOREIGN KEY (ID_PRESTAMO)
    REFERENCES PRESTAMO(ID_PRESTAMO)
);


INSERT INTO TRANSACCION_PRESTAMO (MONTO, FECHA_HORA, ID_CAJERO, ID_PUNTO_ATENCION, TIPO_OPERACION_PRESTAMO, ID_PRESTAMO)
VALUES (1500.00, TIMESTAMP '2024-04-25 12:00:00', 8, 1, 'PAGO ORDINARIO', 1);

INSERT INTO TRANSACCION_PRESTAMO (MONTO, FECHA_HORA, ID_CAJERO, ID_PUNTO_ATENCION, TIPO_OPERACION_PRESTAMO, ID_PRESTAMO)
VALUES (800.50, TIMESTAMP '2024-04-26 09:30:00', 3, 2, 'PAGO EXTRAORDINARIO', 2);

CREATE TABLE CUENTA_ORIGEN_TRANSACCION_CUENTA (
    ID_CUENTA_ORIGEN_TRANSACCION_CUENTA NUMBER DEFAULT cuenta_origen_transaccion_cuenta_seq.NEXTVAL,
    ID_CUENTA NUMBER,
    
    CONSTRAINT CUENTA_ORIGEN_TRANSACCION_CUENTA_PK PRIMARY KEY (ID_CUENTA_ORIGEN_TRANSACCION_CUENTA),
    
    CONSTRAINT ID_CUENTA_C FOREIGN KEY (ID_CUENTA)
    REFERENCES CUENTA(ID_CUENTA)
);

INSERT INTO CUENTA_ORIGEN_TRANSACCION_CUENTA (ID_CUENTA)
VALUES (1);

INSERT INTO CUENTA_ORIGEN_TRANSACCION_CUENTA (ID_CUENTA)
VALUES (3);

INSERT INTO CUENTA_ORIGEN_TRANSACCION_CUENTA (ID_CUENTA)
VALUES (5);

INSERT INTO CUENTA_ORIGEN_TRANSACCION_CUENTA (ID_CUENTA)
VALUES (2);

INSERT INTO CUENTA_ORIGEN_TRANSACCION_CUENTA (ID_CUENTA)
VALUES (4);


CREATE TABLE CUENTA_DESTINO_TRANSACCION_CUENTA (

    ID_CUENTA_DESTINO_TRANSACCION_CUENTA NUMBER DEFAULT cuenta_origen_transaccion_cuenta_seq.NEXTVAL,
    ID_CUENTA NUMBER,
    
    CONSTRAINT CUENTA_DESTINO_TRANSACCION_CUENTA_PK PRIMARY KEY (ID_CUENTA_DESTINO_TRANSACCION_CUENTA),
    
    CONSTRAINT ID_CUENTA_CD FOREIGN KEY (ID_CUENTA)
    REFERENCES CUENTA(ID_CUENTA)
);

INSERT INTO CUENTA_DESTINO_TRANSACCION_CUENTA (ID_CUENTA)
VALUES (2);

INSERT INTO CUENTA_DESTINO_TRANSACCION_CUENTA (ID_CUENTA)
VALUES (4);

INSERT INTO CUENTA_DESTINO_TRANSACCION_CUENTA (ID_CUENTA)
VALUES (1);

INSERT INTO CUENTA_DESTINO_TRANSACCION_CUENTA (ID_CUENTA)
VALUES (3);

INSERT INTO CUENTA_DESTINO_TRANSACCION_CUENTA (ID_CUENTA)
VALUES (5);

COMMIT;