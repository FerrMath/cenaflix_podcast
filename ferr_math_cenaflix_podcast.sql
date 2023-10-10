##########################################################
################### DB SETUP #############################
##########################################################

CREATE DATABASE IF NOT EXISTS ferr_math_cenaflix_podcast;
USE ferr_math_cenaflix_podcast;

CREATE TABLE cnf_usuarios(
	id INT PRIMARY KEY auto_increment,
    nome VARCHAR(255) NOT NULL,
    u_login VARCHAR(255) NOT NULL,
    u_pswd VARCHAR(500) NOT NULL,
    u_type INT NOT NULL
);

CREATE TABLE cnf_podcasts(
	id INT PRIMARY KEY auto_increment,
    produtor VARCHAR(255),
    nome_ep VARCHAR(255),
    num_ep INT,
    duracao INT,
    rep_url VARCHAR(255)
);

##########################################################
################### LOGINS SETUP #########################
##########################################################

INSERT INTO cnf_usuarios (nome, u_login, u_pswd, u_type) VALUES
('usuario','usuario','$2a$10$txAydB2wDxjJNyNdpHwHluwyj6sK8aCLS9dYTss5qO0uBIw3iAosW',1),
('admin','admin','$2a$10$txAydB2wDxjJNyNdpHwHluwyj6sK8aCLS9dYTss5qO0uBIw3iAosW',1),
('operador','operador','$2a$10$txAydB2wDxjJNyNdpHwHluwyj6sK8aCLS9dYTss5qO0uBIw3iAosW',1);
