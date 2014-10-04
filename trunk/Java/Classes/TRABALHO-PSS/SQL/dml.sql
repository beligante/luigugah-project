SET 		SQL_SAFE_UPDATES = 0;

DELETE FROM `usuario`; 
INSERT INTO `usuario` (`id`, `data_cadastro`, `nome`, `email`, `telefone`, `tipo_pessoa`, `endereco`, `bairro`, `complemento`, `cidade`, `estado`, `usuario`, `senha`, `tipo_usuario`, `cep`) 
VALUES 		('1', now(), 'Luis', 'luis@saei.com', '4499999999', 'FISICA', 'Rua Blé', 'Ebenezer', 'Casa', 'Maringá', 'PR', 'luis', 'saei', 'ADMIN', '870000000'),
			('2', now(), 'Airton', 'airton@saei.com', '4499999999', 'FISICA', 'Rua Blé', 'Ebenezer', 'Casa', 'Maringá', 'PR', 'airton', 'saei', 'VENDEDOR', '8700000');
