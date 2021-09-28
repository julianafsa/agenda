-- password = 123456
INSERT INTO user (name, email, password) VALUES 
('Juliana','julianafsa@gmail.com','$2a$10$k8wQAkj8PDq2L/5DlUc64eUJhXXb8apvdCA/7harcxJcqR3DECWFO'); 

--INSERT INTO role VALUES
--(null,'ROLE_USUARIO'),
--(null,'ROLE_ADM');

--INSERT INTO user_roles VALUES (1,1);

INSERT INTO contato (nome, sobrenome, data_nascimento, apelido) VALUES 
('Henrique', 'Viana', '1982-06-14','Henry'),
('Jeanne', 'Aquino', '1982-10-08','Je'),
('Juliana', 'Aquino', '1981-06-01','Ju');

INSERT INTO telefone(ddd, numero, tipo, contato_id) VALUES 
('21', '980228739', '0', 1),
('85', '988810332', '1', 2),
('21', '980228740', '2', 3);

INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado, cep, tipo,  contato_id) VALUES 
('Rua Marechal Deodoro' , 1645, 'Apto 12', 'Centro', 'São Carlos', 'SP', '11111-111', '1',  1),
('Rua 1004' , 146, '4a etapa', 'Conjunto Ceará', 'Fortaleza', 'CE', '22222-222', '1',  2),
('Rua Marechal Deodoro' , 1645, 'Apto 12', 'Centro', 'São Carlos', 'SP', '33333-333', '0',  3);

INSERT INTO email (email,  contato_id) VALUES 
('henrique.viana@gmail.com',  1),
('jeannesantos26@gmail.com',  2),
('julianafsa@gmail.com',  3);