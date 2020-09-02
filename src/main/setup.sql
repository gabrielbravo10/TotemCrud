CREATE DATABASE TotemTI;
USE TotemTI;

CREATE TABLE Funcionario(
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  cpf varchar(255) NOT NULL,
  cargo varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY cpf_UNIQUE (cpf)
);

INSERT INTO Funcionario (nome, email, cpf, cargo) VALUES ('Gabriel', 'gabriel@gmail.com', '0220930484', 'Desenvolvedor');
