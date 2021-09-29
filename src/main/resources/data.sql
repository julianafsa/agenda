-- password = 123456
INSERT INTO user (name, email, password) VALUES 
('Juliana','juliana@email.com','$2a$10$k8wQAkj8PDq2L/5DlUc64eUJhXXb8apvdCA/7harcxJcqR3DECWFO'); 

INSERT INTO role (authority) VALUES
('ROLE_USUARIO'),
('ROLE_ADM');

INSERT INTO user_roles VALUES (1,1);

INSERT INTO contato (nome, sobrenome, data_nascimento, apelido) VALUES 
('Henrique', 'Viana', '1982-06-14','Henry'),
('Jeanne', 'Aquino', '1982-10-08','Je'),
('Juliana', 'Aquino', '1981-06-01','Ju');

INSERT INTO telefone(ddd, numero, tipo, contato_id) VALUES 
('21', '980228799', '0', 1),
('85', '988810399', '1', 2),
('21', '980228799', '2', 3);

INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado, cep, tipo,  contato_id) VALUES 
('Rua Fictícia 1' , 1, 'Apto 10', 'Centro', 'São Carlos', 'SP', '11111-111', '1',  1),
('Rua Fictícia 2' , 2, 'Bloco 2, Apto 2', 'Nova Fortaleza', 'Fortaleza', 'CE', '22222-222', '1',  2),
('Rua Fictícia 3' , 3, 'Apto 13', 'Centro', 'São Carlos', 'SP', '33333-333', '0',  3);

INSERT INTO email (email,  contato_id) VALUES 
('henrique@email.com',  1),
('jeanne@email.com',  2),
('juliana@email.com',  3);