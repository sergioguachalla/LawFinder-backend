-- Truncar las tablas
/*
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
values ('DELETE_USER',1),('VIEW_CASE',1),('EDIT_CASE',1),('DELETE_CASE',1),('CREATE_CASE',1);

INSERT INTO ROLE(rolename,STATUS)
values ('ADMIN',1),('LAWYER',1),('CUSTOMER',1),('LAWYER_INVITED',1);

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
*/