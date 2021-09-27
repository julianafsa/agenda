/* password = 123456 */
INSERT INTO user (name, email, password) VALUES 
('Juliana','julianafsa@gmail.com','$2a$10$k8wQAkj8PDq2L/5DlUc64eUJhXXb8apvdCA/7harcxJcqR3DECWFO'); 

--INSERT INTO role VALUES
--(null,'ROLE_USUARIO'),
--(null,'ROLE_ADM');

--INSERT INTO user_roles VALUES (1,1);

INSERT INTO contato (nome, sobrenome, data_nascimento, apelido) VALUES 
('Henrique', 'Viana', '1982-06-14','Henrique'),
('Jeanne', 'Aquino', '1982-10-08','Jeanne'),
('Juliana', 'Aquino', '1981-06-01','Juliana');

INSERT INTO telefone(ddd, numero, contato_id) VALUES 
('21', '980228739', 1),
('85', '988810332', 2),
('21', '980228740', 3);

INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado, tipo,  contato_id) VALUES 
('Rua Marechal Deodoro' , 1645, 'Apto 12', 'Centro', 'São Carlos', 'SP', 'residencial',  1),
('Rua 1004' , 146, '4a etapa', 'Conjunto Ceará', 'Fortaleza', 'CE', 'residencial',  2),
('Rua Marechal Deodoro' , 1645, 'Apto 12', 'Centro', 'São Carlos', 'SP', 'residencial',  3);

INSERT INTO email (email,  contato_id) VALUES 
('henrique.viana@gmail.com',  1),
('jeannesantos26@gmail.com',  2),
('julianafsa@gmail.com',  3);