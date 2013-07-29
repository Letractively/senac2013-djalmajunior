DROP DATABASE IF EXISTS aula7;

CREATE DATABASE aula7;

USE aula7;

CREATE TABLE pessoa(
	idPessoa INTEGER AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	idade INTEGER,
	PRIMARY KEY(idPessoa)
);

#FK com o campo UNIQUE - Relacionamento 1 - 1
#FK com o campo sem UNIQUE - Relacionamento 1 - N
# ON DELETE CASCADE -- Deletar em cascata, quando deletar a pessoa o seu endereco e deletado tb
CREATE TABLE endereco(
	idEndereco INTEGER AUTO_INCREMENT,
	cidade VARCHAR(50) NOT NULL,
	estado ENUM('RJ','SP','MG','ES'),
	id_pessoa INTEGER UNIQUE,
	PRIMARY KEY(idEndereco),
	FOREIGN KEY(id_pessoa) REFERENCES pessoa(idPessoa)
		ON DELETE CASCADE
);

DESC pessoa;
DESC endereco;