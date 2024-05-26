--drop tables
DROP TABLE IF EXISTS ACTOR CASCADE;
DROP TABLE IF EXISTS AUDIENCE CASCADE;
DROP TABLE IF EXISTS CATEGORY CASCADE;
DROP TABLE IF EXISTS COMMENT CASCADE;
DROP TABLE IF EXISTS COUNTERPART CASCADE;
DROP TABLE IF EXISTS COURT CASCADE;
DROP TABLE IF EXISTS CRIME CASCADE;
DROP TABLE IF EXISTS DEPARTMENT CASCADE;
DROP TABLE IF EXISTS FILE CASCADE;
DROP TABLE IF EXISTS H_FILE CASCADE;
DROP TABLE IF EXISTS H_LEGAL_CASE CASCADE;
DROP TABLE IF EXISTS H_SE_USER CASCADE;
DROP TABLE IF EXISTS H_SE_USER_ROLE CASCADE;
DROP TABLE IF EXISTS INSTANCE CASCADE;
DROP TABLE IF EXISTS INSTANCE_LEGAL_CASE CASCADE;
DROP TABLE IF EXISTS LEGAL_CASE CASCADE;
DROP TABLE IF EXISTS LEGAL_FILE CASCADE;
DROP TABLE IF EXISTS LEGAL_FILE_TYPE CASCADE;
DROP TABLE IF EXISTS PERSON CASCADE;
DROP TABLE IF EXISTS PRIVILEGE CASCADE;
DROP TABLE IF EXISTS PRIVILEGE_ROLE CASCADE;
DROP TABLE IF EXISTS PROVINCE CASCADE;
DROP TABLE IF EXISTS ROLE CASCADE;
DROP TABLE IF EXISTS SE_USER CASCADE;
DROP TABLE IF EXISTS SE_USER_ROLE CASCADE;
DROP TABLE IF EXISTS SE_VERIFICATION CASCADE;
DROP TABLE IF EXISTS SUB_CATEGORY CASCADE;
DROP TABLE IF EXISTS APPLICATION_LOG CASCADE;
DROP TABLE IF EXISTS LOG_CATEGORY CASCADE;
DROP TABLE IF EXISTS LOG_LEVEL CASCADE;

-- tables
-- Table: ACTOR

CREATE TABLE IF NOT EXISTS APPLICATION_LOG (
                                 LOG_ID serial  NOT NULL,
                                 USER_LOG varchar(255)  NULL,
                                 DATE timestamp  NOT NULL,
                                 HOST varchar(100)  NOT NULL,
                                 DESCRIPTION text  NOT NULL,
                                 CATEGORY_ID int  NOT NULL,
                                 LEVEL_ID int  NOT NULL,
                                 CONSTRAINT APPLICATION_LOG_pk PRIMARY KEY (LOG_ID)
);

CREATE TABLE IF NOT EXISTS LOG_CATEGORY (
                              CATEGORY_ID serial  NOT NULL,
                              CATEGORY_NAME varchar(255)  NOT NULL,
                              CONSTRAINT LOG_CATEGORY_pk PRIMARY KEY (CATEGORY_ID)
);
CREATE TABLE IF NOT EXISTS LOG_LEVEL (
                         LEVEL_ID serial  NOT NULL,
                         LEVEL_NAME varchar(255)  NOT NULL,
                         CONSTRAINT LEVEL_pk PRIMARY KEY (LEVEL_ID)
);

CREATE TABLE IF NOT EXISTS ACTOR (
                                     ACTOR_ID serial  NOT NULL,
                                     USER_ID int  NOT NULL,
                                     LEGAL_CASE_ID int  NOT NULL,
                                     STATUS boolean  NOT NULL,
                                     CONSTRAINT ACTOR_pk PRIMARY KEY (ACTOR_ID)
    );

-- Table: AUDIENCE
CREATE TABLE IF NOT EXISTS AUDIENCE (
                                        AUDIENCE_ID serial  NOT NULL,
                                        AUDIENCE_DATE timestamp  NOT NULL,
                                        DESCRIPTION text  NOT NULL,
                                        LINK text  NOT NULL,
                                        ADDRESS text  NOT NULL,
                                        LEGAL_CASE_ID int  NOT NULL,
                                        CONSTRAINT AUDIENCE_pk PRIMARY KEY (AUDIENCE_ID)
    );

-- Table: CATEGORY
CREATE TABLE IF NOT EXISTS CATEGORY (
                                        CATEGORY_ID serial  NOT NULL,
                                        CATEGORY_NAME Varchar(100)  NOT NULL,
    DESCRIPTION Varchar(2000)  NOT NULL,
    CONSTRAINT CATEGORY_pk PRIMARY KEY (CATEGORY_ID)
    );

-- Table: COMMENT
CREATE TABLE IF NOT EXISTS COMMENT (
                                       COMMENT_ID serial  NOT NULL,
                                       LEGAL_CASE_ID int  NOT NULL,
                                       COMMENT_CONTENT Text  NOT NULL,
                                       SE_USER_ID int  NOT NULL,
                                       COMMENT_DATE date  NOT NULL,
                                       CONSTRAINT COMMENT_pk PRIMARY KEY (COMMENT_ID)
    );

-- Table: COUNTERPART
CREATE TABLE IF NOT EXISTS COUNTERPART (
                                           COUNTERPART_ID serial  NOT NULL,
                                           COUNTERPART_NAME Varchar(2000)  NOT NULL,
    LEGAL_CASE_ID int  NOT NULL,
    CONSTRAINT COUNTERPART_pk PRIMARY KEY (COUNTERPART_ID)
    );

-- Table: COURT
CREATE TABLE IF NOT EXISTS COURT (
                                     COURT_ID serial  NOT NULL,
                                     COURT_NAME text  NOT NULL,
                                     CONSTRAINT COURT_pk PRIMARY KEY (COURT_ID)
    );

-- Table: CRIME
CREATE TABLE IF NOT EXISTS CRIME (
                                     CRIME_ID serial  NOT NULL,
                                     NAME Varchar(1000)  NOT NULL,
    PRISON_SENTENCE Varchar(100)  NOT NULL,
    SUBCATEGORY_ID int  NOT NULL,
    CONSTRAINT CRIME_pk PRIMARY KEY (CRIME_ID)
    );

-- Table: DEPARTMENT
CREATE TABLE IF NOT EXISTS DEPARTMENT (
                                          DEPARTMENT_ID serial  NOT NULL,
                                          DEPARTMENT_NAME Varchar(100)  NOT NULL,
    CONSTRAINT DEPARTMENT_pk PRIMARY KEY (DEPARTMENT_ID)
    );

-- Table: FILE
CREATE TABLE IF NOT EXISTS FILE (
                                    FILE_ID serial  NOT NULL,
                                    URL Varchar(1000)  NOT NULL,
    MIME_TYPE Varchar(60)  NOT NULL,
    SIZE Varchar(60)  NOT NULL,
    MD5 Varchar(60)  NOT NULL,
    TX_USER varchar(100)  NOT NULL,
    TX_HOST Varchar(100)  NOT NULL,
    TX_DATE timestamp  NOT NULL,
    CONSTRAINT FILE_pk PRIMARY KEY (FILE_ID)
    );

-- Table: H_FILE
CREATE TABLE IF NOT EXISTS H_FILE (
                                      H_FILE_ID serial  NOT NULL,
                                      FILE_ID int  NOT NULL,
                                      URL Varchar(1000)  NOT NULL,
    MIME_TYPE Varchar(60)  NOT NULL,
    SIZE Varchar(60)  NOT NULL,
    MD5 Varchar(60)  NOT NULL,
    TX_USER Varchar(100)  NOT NULL,
    TX_HOST Varchar(100)  NOT NULL,
    TX_DATE date  NOT NULL,
    CONSTRAINT H_FILE_pk PRIMARY KEY (H_FILE_ID)
    );

-- Table: H_LEGAL_CASE
CREATE TABLE IF NOT EXISTS H_LEGAL_CASE (
                                            H_LEGAL_CASE_ID serial  NOT NULL,
                                            ID_LEGAL_CASE int  NOT NULL,
                                            TITLE Varchar(2000)  NOT NULL,
    START_DATE date  NOT NULL,
    SUMMARY text  NOT NULL,
    STATUS Varchar(100)  NOT NULL,
    FIRST_INSTANCE_COURT Varchar(100)  NOT NULL,
    SECOND_INSTANCE_COURT Varchar(100)  NOT NULL,
    THIRD_INSTANCE_COURT Varchar(100)  NOT NULL,
    USER_ID int  NOT NULL,
    TX_USER Varchar(100)  NOT NULL,
    TX_HOST Varchar(100)  NOT NULL,
    TX_DATE date  NOT NULL,
    CONSTRAINT H_LEGAL_CASE_pk PRIMARY KEY (H_LEGAL_CASE_ID)
    );

-- Table: H_SE_USER
CREATE TABLE IF NOT EXISTS H_SE_USER (
                                         H_USER_ID serial  NOT NULL,
                                         USER_ID int  NOT NULL,
                                         USERNAME Varchar(100)  NOT NULL,
    SECRET Varchar(60)  NOT NULL,
    STATUS boolean  NOT NULL,
    PERSON_ID int  NOT NULL,
    IMAGE_ID int  NOT NULL,
    TX_USER Varchar(100)  NOT NULL,
    TX_HOST Varchar(100)  NOT NULL,
    TX_DATE date  NOT NULL,
    CONSTRAINT H_SE_USER_pk PRIMARY KEY (H_USER_ID)
    );

-- Table: H_SE_USER_ROLE
CREATE TABLE IF NOT EXISTS H_SE_USER_ROLE (
                                              H_SE_USER_ROLE_ID serial  NOT NULL,
                                              USER_ROLE__ID int  NOT NULL,
                                              ROLE_ID int  NOT NULL,
                                              USER_ID int  NOT NULL,
                                              STATUS boolean  NOT NULL,
                                              TX_USER Varchar(100)  NOT NULL,
    TX_HOST Varchar(100)  NOT NULL,
    TX_DATE date  NOT NULL,
    CONSTRAINT H_SE_USER_ROLE_pk PRIMARY KEY (H_SE_USER_ROLE_ID)
    );

-- Table: INSTANCE
CREATE TABLE IF NOT EXISTS INSTANCE (
                                        INSTANCE_ID serial  NOT NULL,
                                        INSTANCE_NAME Varchar(1000)  NOT NULL,
    CONSTRAINT INSTANCE_pk PRIMARY KEY (INSTANCE_ID)
    );

-- Table: INSTANCE_LEGAL_CASE
CREATE TABLE IF NOT EXISTS INSTANCE_LEGAL_CASE (
                                                   INSTANCE_LEGAL_CASE_ID serial  NOT NULL,
                                                   INSTANCE_ID int  NOT NULL,
                                                   LEGAL_CASE_ID int  NOT NULL,
                                                   START_DATE date  NOT NULL,
                                                   END_DATE date  NOT NULL,
                                                   STATUS boolean  NOT NULL,
                                                   CONSTRAINT INSTANCE_LEGAL_CASE_pk PRIMARY KEY (INSTANCE_LEGAL_CASE_ID)
    );

-- Table: LEGAL_CASE
CREATE TABLE IF NOT EXISTS LEGAL_CASE (
                                          LEGAL_CASE_ID serial  NOT NULL,
                                          USER_ID int  NOT NULL,
                                          CRIME_ID int  NOT NULL,
                                          PROVINCE_ID int  NOT NULL,
                                          TITLE Varchar(2000)  NOT NULL,
    START_DATE date  NOT NULL,
    SUMMARY text  NOT NULL,
    COMPLAINANT boolean  NOT NULL,
    STATUS boolean  NOT NULL,
    TX_USER Varchar(100)  NOT NULL,
    TX_HOST Varchar(100)  NOT NULL,
    TX_DATE date  NOT NULL,
    CONSTRAINT LEGAL_CASE_pk PRIMARY KEY (LEGAL_CASE_ID)
    );

-- Table: LEGAL_FILE
CREATE TABLE IF NOT EXISTS LEGAL_FILE (
                                          LEGAL_FILE_ID serial  NOT NULL,
                                          FILE_ID int  NOT NULL,
                                          COURT_ID int  NOT NULL,
                                          LEGAL_FILE_TYPE_ID int  NOT NULL,
                                          INSTANCE_LEGAL_CASE_ID int  NOT NULL,
                                          RESOLUTION_DATE date  NOT NULL,
                                          SUMMARY text  NOT NULL,
                                          TX_USER Varchar(100)  NOT NULL,
    TX_HOST Varchar(100)  NOT NULL,
    TX_DATE date  NOT NULL,
    CONSTRAINT LEGAL_FILE_pk PRIMARY KEY (LEGAL_FILE_ID)
    );

-- Table: LEGAL_FILE_TYPE
CREATE TABLE IF NOT EXISTS LEGAL_FILE_TYPE (
                                               LEGAL_FILE_TYPE_ID serial  NOT NULL,
                                               FILE_NAME Varchar(1000)  NOT NULL,
    CONSTRAINT LEGAL_FILE_TYPE_pk PRIMARY KEY (LEGAL_FILE_TYPE_ID)
    );

-- Table: PERSON
CREATE TABLE IF NOT EXISTS PERSON (
                                      PERSON_ID serial  NOT NULL,
                                      NAME Varchar(100)  NOT NULL,
    LASTNAME Varchar(100)  NOT NULL,
    CI Varchar(60)  NOT NULL,
    COMPLEMENT varchar(60)  NULL,
    NUMBER Varchar(100)  NOT NULL,
    EMAIL Varchar(300)  NOT NULL,
    ADDRESS Varchar(1000)  NOT NULL,
    TX_USER Varchar(100)  NOT NULL,
    TX_HOST Varchar(100)  NOT NULL,
    TX_DATE date  NOT NULL,
    CONSTRAINT PERSON_pk PRIMARY KEY (PERSON_ID)
    );

-- Table: PRIVILEGE
CREATE TABLE IF NOT EXISTS PRIVILEGE (
                                         PRIVILEGE_ID serial  NOT NULL,
                                         PRIVILEGE Varchar(100)  NOT NULL,
    STATUS int  NOT NULL,
    CONSTRAINT PRIVILEGE_pk PRIMARY KEY (PRIVILEGE_ID)
    );

-- Table: PRIVILEGE_ROLE
CREATE TABLE IF NOT EXISTS PRIVILEGE_ROLE (
                                              PRIVROLE_ID serial  NOT NULL,
                                              PRIVILEGE_ID int  NOT NULL,
                                              ROLE_ID int  NOT NULL,
                                              STATUS int  NOT NULL,
                                              CONSTRAINT PRIVILEGE_ROLE_pk PRIMARY KEY (PRIVROLE_ID)
    );

-- Table: PROVINCE
CREATE TABLE IF NOT EXISTS PROVINCE (
                                        PROVINCE_ID serial  NOT NULL,
                                        DEPARTMENT_ID int  NOT NULL,
                                        PROVINCE_NAME Varchar(100)  NOT NULL,
    CONSTRAINT PROVINCE_pk PRIMARY KEY (PROVINCE_ID)
    );

-- Table: ROLE
CREATE TABLE IF NOT EXISTS ROLE (
                                    ROLE_ID serial  NOT NULL,
                                    ROLENAME Varchar(100)  NOT NULL,
    STATUS int  NOT NULL,
    CONSTRAINT ROLE_pk PRIMARY KEY (ROLE_ID)
    );

-- Table: SE_USER
CREATE TABLE IF NOT EXISTS SE_USER (
                                       USER_ID serial  NOT NULL,
                                       PERSON_ID int  NOT NULL,
                                       USERNAME Varchar(100)  NOT NULL,
    SECRET Varchar(60)  NOT NULL,
    STATUS boolean  NOT NULL,
    ISBLOCKED boolean NOT NULL,
    TX_USER Varchar(100)  NOT NULL,
    TX_HOST Varchar(100)  NOT NULL,
    TX_DATE date  NOT NULL,
    CONSTRAINT SE_USER_pk PRIMARY KEY (USER_ID)
    );

-- Table: SE_USER_ROLE
CREATE TABLE IF NOT EXISTS SE_USER_ROLE (
                                            USER_ROLE_ID serial  NOT NULL,
                                            ROLE_ID int  NOT NULL,
                                            USER_ID int  NOT NULL,
                                            STATUS boolean  NOT NULL,
                                            IS_BLOCKED boolean NOT NULL DEFAULT false,
                                            DATE_CREATED date NOT NULL DEFAULT CURRENT_DATE,
                                            DATE_BLOCKED date NULL,
                                            TX_USER Varchar(100)  NOT NULL,
    TX_HOST Varchar(100)  NOT NULL,
    TX_DATE date  NOT NULL,
    CONSTRAINT SE_USER_ROLE_pk PRIMARY KEY (USER_ROLE_ID)
    );

-- Table: SE_VERIFICATION
CREATE TABLE IF NOT EXISTS SE_VERIFICATION (
                                               VERIFICATION_ID serial  NOT NULL,
                                               UUID Varchar(100)  NOT NULL,
    EXPIRATION_DATE date  NOT NULL,
    CODE_HASH Varchar(100)  NOT NULL,
    VC_TYPE Varchar(50)  NOT NULL,
    DEVICE_ID Varchar(100)  NOT NULL,
    CONSTRAINT SE_VERIFICATION_pk PRIMARY KEY (VERIFICATION_ID)
    );

-- Table: SUB_CATEGORY
CREATE TABLE IF NOT EXISTS SUB_CATEGORY (
                                            SUBCATEGORY_ID serial  NOT NULL,
                                            CATEGORY_ID int  NOT NULL,
                                            SUB_CATEGORY_NAME Varchar(100)  NOT NULL,
    DESCRIPTION Varchar(2000)  NOT NULL,
    CONSTRAINT SUB_CATEGORY_pk PRIMARY KEY (SUBCATEGORY_ID)
    );
CREATE EXTENSION IF NOT EXISTS pg_cron;

CREATE OR REPLACE PROCEDURE update_se_user_role()
LANGUAGE plpgsql
AS $$
DECLARE
v_date_threshold DATE;

BEGIN

  v_date_threshold := CURRENT_DATE - INTERVAL '60 days';

UPDATE se_user_role
SET IS_BLOCKED = TRUE, DATE_BLOCKED = CURRENT_DATE
WHERE IS_BLOCKED = FALSE
  AND DATE_CREATED <= v_date_threshold;


END;
$$;

SELECT cron.schedule('0 0 * * *', 'CALL update_se_user_role()');
-- Truncar las tablas
TRUNCATE TABLE legal_file_type;
TRUNCATE TABLE privilege;
TRUNCATE TABLE role;
TRUNCATE TABLE category;
TRUNCATE TABLE sub_category;
TRUNCATE TABLE crime;
TRUNCATE TABLE instance;
TRUNCATE TABLE court;
TRUNCATE TABLE department;
TRUNCATE TABLE province;
TRUNCATE TABLE log_category;
TRUNCATE TABLE log_level;


-- Reiniciar los valores de las secuencias con el valor deseado
ALTER SEQUENCE legal_file_type_legal_file_type_id_seq RESTART WITH 1;
ALTER SEQUENCE privilege_privilege_id_seq RESTART WITH 1;
ALTER SEQUENCE role_role_id_seq RESTART WITH 1;
ALTER SEQUENCE category_category_id_seq RESTART WITH 1;
ALTER SEQUENCE sub_category_subcategory_id_seq RESTART WITH 1;
ALTER SEQUENCE crime_crime_id_seq RESTART WITH 1;
ALTER SEQUENCE instance_instance_id_seq RESTART WITH 1;
ALTER SEQUENCE court_court_id_seq RESTART WITH 1;
ALTER SEQUENCE department_department_id_seq RESTART WITH 1;
ALTER SEQUENCE province_province_id_seq RESTART WITH 1;
ALTER SEQUENCE log_category_category_id_seq RESTART WITH 1;
ALTER SEQUENCE log_level_level_id_seq RESTART WITH 1;

-- Ahora los inserts comenzarán con el ID 1



INSERT INTO legal_file_type (FILE_NAME)
VALUES
    ('Memorial'),
    ('Prueba'),
    ('Dictamen'),
    ('Escrito'),
    ('Apelación'),
    ('Contrato'),
    ('Sentencia');

INSERT INTO privilege (privilege,STATUS)
values ('DELETE_USER',1),('BLOCK_USER',1),('UNLOCK_USER',1), ('CREATE_ROLE',1), ('EDIT_USER',1),('CREATE_PRIVILEGE',1),('VIEW_CASE',1),('EDIT_CASE',1),('DELETE_CASE',1),('CREATE_CASE',1),('REGISTER_AUDIENCE',1),('VIEW_APPLICATION_LOGS',1),('VIEW_SECURITY_LOGS',1);

INSERT INTO ROLE(rolename,STATUS)
values ('ADMIN',1),('LAWYER',1),('CUSTOMER',1);

INSERT INTO privilege_role(privilege_id,role_id,status)
values(1,1,1),(2,1,1),(3,1,1),(4,1,1),(5,1,1),(6,1,1),(7,2,1),(8,2,1),(9,2,1),(10,2,1),(11,2,1),(7,3,1),(12,1,1),(13,1,1);

INSERT INTO category (category_name, description) VALUES
                                                      ('Derecho Penal', 'Incluye las normas legales y principios que regulan los delitos, las penas y el sistema de justicia penal.'),
                                                      ('Derecho Civil', 'Incluye las normas legales y principios que regulan las relaciones entre personas, como contratos, propiedad, matrimonio y responsabilidad civil.'),
                                                      ('Derecho Laboral', 'Incluye las normas legales y principios que regulan las relaciones laborales entre empleadores y empleados, incluyendo condiciones de trabajo, salarios y derechos laborales.'),
                                                      ('Derecho Administrativo', 'Incluye las normas legales y principios que regulan la organización y funcionamiento de la administración pública, así como los derechos y deberes de los ciudadanos frente a la administración.'),
                                                      ('Derecho Constitucional', 'Incluye las normas legales y principios que regulan la organización y funcionamiento del Estado, así como los derechos y libertades fundamentales de los ciudadanos.');

INSERT INTO sub_category (category_id, sub_category_name, description) VALUES
                                                                           (1, 'Lesiones', 'Delitos que causan daño físico o lesiones a otra persona.'),
                                                                           (1, 'Violencia de Género', 'Delitos cometidos contra personas por razones de género.'),
                                                                           (1, 'Secuestro', 'Delitos relacionados con la privación ilegal de libertad de una persona.'),
                                                                           (2, 'Derecho de Familia', 'Normas legales que regulan las relaciones familiares y los derechos de los miembros de una familia.'),
                                                                           (2, 'Herencia y Sucesiones', 'Normas legales que regulan la distribución de bienes y propiedades tras el fallecimiento de una persona.'),
                                                                           (2, 'Derecho de Propiedad Intelectual', 'Normas legales que protegen los derechos de propiedad sobre creaciones intelectuales.'),
                                                                           (3, 'Derecho Laboral', 'Normas legales que regulan las relaciones laborales y los derechos de los trabajadores.'),
                                                                           (3, 'Derecho Tributario', 'Normas legales que regulan los impuestos y las obligaciones fiscales.'),
                                                                           (3, 'Derecho de la Seguridad Social', 'Normas legales que garantizan la protección social y los derechos de los trabajadores en materia de seguridad social.'),
                                                                           (4, 'Derecho Administrativo', 'Normas legales que regulan la organización y funcionamiento de la administración pública.'),
                                                                           (4, 'Contratación Estatal', 'Normas legales que regulan los procesos de contratación del sector público.'),
                                                                           (4, 'Responsabilidad Patrimonial del Estado', 'Normas legales que establecen la responsabilidad del Estado por daños causados en el ejercicio de sus funciones.'),
                                                                           (5, 'Derecho Internacional Público', 'Normas legales que regulan las relaciones entre Estados y organizaciones internacionales.'),
                                                                           (5, 'Derecho Internacional Humanitario', 'Normas legales que protegen a las personas y los bienes en tiempos de conflicto armado.'),
                                                                           (5, 'Derecho del Mar', 'Normas legales que regulan los derechos y obligaciones de los Estados en el uso y conservación de los océanos y sus recursos.');

INSERT INTO crime (name, prison_sentence, subcategory_id) VALUES
-- Subcategoría 1: Derecho Penal
('Lesión Grave', '10', 1),
('Violencia de Género', '8', 1),
('Secuestro Simple', '12', 1),

-- Subcategoría 2: Derecho Civil
('Divorcio por Mutuo Acuerdo', 'N/A', 2),
('Herencia Testada', 'N/A', 2),
('Registro de Derechos de Autor', 'N/A', 2),

-- Subcategoría 3: Derecho Laboral
('Despido Injustificado', '2', 3),
('Evasión de Impuestos', '5', 3),
('Fraude en la Seguridad Social', '4', 3),

-- Subcategoría 4: Derecho Administrativo
('Procedimiento Administrativo Irregular', '3', 4),
('Soborno en la Contratación Pública', '6', 4),
('Responsabilidad Patrimonial del Estado', 'N/A', 4),

-- Subcategoría 5: Derecho Internacional
('Violación de Soberanía Nacional', '10', 5),
('Crímenes de Guerra', 'N/A', 5),
('Contaminación del Mar', '8', 5);

INSERT INTO instance (instance_name) VALUES
                                         ('Instancia Preliminar' ),
                                         ('Instancia de Investigación' ),
                                         ('Instancia de Sentencia');


INSERT INTO court (court_name)
VALUES
    ('Juzgado de Instrucción en lo Penal'),
    ('Juzgado de Familia'),
    ('Juzgado de Trabajo'),
    ('Juzgado de Paz'),
    ('Juzgado de Ejecución Penal'),
    ('Juzgado de lo Contencioso Administrativo'),
    ('Juzgado de lo Civil'),
    ('Juzgado de lo Mercantil'),
    ('Juzgado de lo Social'),
    ('Juzgado de lo Penal'),
    ('Juzgado de lo Contencioso Tributario'),
    ('Juzgado de lo Administrativo'),
    ('Juzgado de lo Constitucional'),
    ('Juzgado de lo Internacional'),
    ('Juzgado de lo Marítimo');

INSERT INTO DEPARTMENT (DEPARTMENT_NAME) VALUES
                                             ('La Paz'),
                                             ('Santa Cruz'),
                                             ('Cochabamba'),
                                             ('Beni'),
                                             ('Oruro'),
                                             ('Potosí'),
                                             ('Tarija'),
                                             ('Chuquisaca'),
                                             ('Pando');


INSERT INTO PROVINCE (DEPARTMENT_ID, PROVINCE_NAME) VALUES
-- Departamento: La Paz
(1, 'Aroma'),
(1, 'Bautista Saavedra'),
(1, 'Caranavi'),
(1, 'Eliodoro Camacho'),
(1, 'Franz Tamayo'),
(1, 'Gualberto Villarroel'),
(1, 'Ingavi'),
(1, 'Inquisivi'),
(1, 'José Manuel Pando'),
(1, 'Larecaja'),
(1, 'Loayza'),
(1, 'Los Andes'),
(1, 'Manco Kapac'),
(1, 'Muñecas'),
(1, 'Nor Yungas'),
(1, 'Omasuyos'),
(1, 'Pacajes'),
(1, 'Pedro Domingo Murillo'),
(1, 'Sud Yungas'),
-- Departamento: Cochabamba
(2, 'Arani'),
(2, 'Arque'),
(2, 'Ayopaya'),
(2, 'Bolívar'),
(2, 'Carrasco'),
(2, 'Cercado'),
(2, 'Chapare'),
(2, 'Esteban Arce'),
(2, 'Germán Jordán'),
(2, 'Mizque'),
(2, 'Narciso Campero'),
(2, 'Punata'),
(2, 'Quillacollo'),
(2, 'Tapacarí'),
(2, 'Tiraque'),
-- Departamento: Santa Cruz
(3, 'Andrés Ibáñez'),
(3, 'Ángel Sandoval'),
(3, 'Chiquitos'),
(3, 'Cordillera'),
(3, 'Florida'),
(3, 'Germán Busch'),
(3, 'Guarayos'),
(3, 'Ichilo'),
(3, 'Ignacio Warnes'),
(3, 'José Miguel de Velasco'),
(3, 'Ñuflo de Chávez'),
(3, 'Obispo Santistevan'),
(3, 'Sara'),
(3, 'Vallegrande'),
-- Departamento: Beni
(4, 'Cercado'),
(4, 'Iténez'),
(4, 'José Ballivián'),
-- Departamento: Pando
(5, 'Abuná'),
(5, 'Federico Román'),
(5, 'Madre de Dios'),
(5, 'Manuripi'),
(5, 'Nicolás Suárez'),
-- Departamento: Oruro
(6, 'Cercado'),
(6, 'Eduardo Avaroa'),
(6, 'Ladislao Cabrera'),
(6, 'Litoral'),
(6, 'Pantaleón Dalence'),
(6, 'Poopó'),
(6, 'Sabaya'),
(6, 'Sajama'),
(6, 'San Pedro de Totora'),
(6, 'Saucarí'),
(6, 'Sebastián Pagador'),
-- Departamento: Potosí
(7, 'Alonso de Ibáñez'),
(7, 'Antonio Quijarro'),
(7, 'Bernardino Bilbao'),
(7, 'Charcas'),
(7, 'Chayanta'),
(7, 'Cornelio Saavedra'),
(7, 'Daniel Campos'),
(7, 'Enrique Baldivieso'),
(7, 'José María Linares'),
(7, 'Modesto Omiste'),
(7, 'Nor Chichas'),
(7, 'Rafael Bustillo'),
(7, 'Sur Chichas'),
(7, 'Tomás Frías'),
-- Departamento: Tarija
(8, 'Aniceto Arce'),
(8, 'Burnet O''Connor'),
(8, 'Cercado'),
(8, 'Eustaquio Méndez'),
(8, 'Gran Chaco'),
(8, 'José María Avilés'),
-- Departamento: Chuquisaca
(9, 'Azurduy'),
(9, 'Belisario Boeto'),
(9, 'Hernando Siles'),
(9, 'Jaime Zudáñez'),
(9, 'Luis Calvo'),
(9, 'Nor Cinti'),
(9, 'Oropeza'),
(9, 'Sud Cinti'),
(9, 'Tomina'),
(9, 'Yamparáez'),
(9, 'Zuñac');


-- Admin insert
INSERT INTO person (name, lastname, ci, complement, number, email, address, tx_user, tx_host, tx_date)
values ('admin', 'sudo', '1234567', 'N/A', '1234567', 'admin@gmail.com', 'N/A', 'admin', 'localhost', CURRENT_DATE);

--password : Admin12_
INSERT INTO se_user (person_id, username, secret, status, isblocked, tx_user, tx_host, tx_date)
values (1, 'admin_sudo', '$2a$12$qnrJ8yFM8EfuqKzGJR32eOqgDITFqDXx5jSQEqF6iF7LAAUC0/nNi',
        TRUE, FALSE, 'admin', 'localhost', CURRENT_DATE);

INSERT INTO se_user_role (role_id, user_id, status, is_blocked, date_created, date_blocked, tx_user, tx_host, tx_date)
values (1, 1, TRUE, FALSE, CURRENT_DATE, CURRENT_DATE, 'admin', 'localhost', CURRENT_DATE);

INSERT into log_category (category_name) values ('INSERT'), ('UPDATE'), ('DELETE');
INSERT into log_level (level_name) values ('INFO'), ('WARNING'), ('ERROR');