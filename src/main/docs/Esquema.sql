--------------------ENUMERACIONES
CREATE TABLE ESTADO_PRESTAMO
(
    ESTADO_PRESTAMO VARCHAR2(10 CHAR),
    CONSTRAINT ESTADO_PRESTAMO_PK PRIMARY KEY (ESTADO_PRESTAMO));

----------------------
CREATE TABLE TIPO_USUARIO
(
    TIPO_USUARIO VARCHAR2(15 CHAR),
    CONSTRAINT TIPO_USUARIO_PK PRIMARY KEY (TIPO_USUARIO));
--------------------------------------
CREATE TABLE TIPO_DOCUMENTO
(
    TIPO_DOCUMENTO VARCHAR2(13 CHAR),
    CONSTRAINT TIPO_DOCUMENTO_PK PRIMARY KEY (TIPO_DOCUMENTO));
-------------------------------------
CREATE TABLE TIPO_CUENTA
(
    TIPO_CUENTA VARCHAR2(15 CHAR),
    CONSTRAINT TIPO_CUENTA_PK PRIMARY KEY (TIPO_CUENTA));
-----------------------------------------
CREATE TABLE ESTADO_CUENTA
(
    ESTADO_CUENTA VARCHAR2(15 CHAR),
    CONSTRAINT ESTADO_CUENTA_PK PRIMARY KEY (ESTADO_CUENTA));
------------------------
CREATE TABLE TIPO_OPERACION
(
    TIPO_OPERACION VARCHAR2(11 CHAR),
    CONSTRAINT TIPO_OPERACION_PK PRIMARY KEY (TIPO_OPERACION));
------------------------------------    
CREATE TABLE TIPO_PRESTAMO
(
    TIPO_PRESTAMO VARCHAR2(15 CHAR),
    CONSTRAINT TIPO_PRESTAMO_PK PRIMARY KEY (TIPO_PRESTAMO));
-----------------------------------------
CREATE TABLE NACIONALIDAD
(
    NOMBRE VARCHAR2(13 CHAR),
    CONSTRAINT NACIONALIDAD_PK PRIMARY KEY (NOMBRE));