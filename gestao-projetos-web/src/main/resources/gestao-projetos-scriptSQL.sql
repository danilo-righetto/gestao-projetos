INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_ADMINISTRADOR', 'ADMINISTRADOR');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_COORDENADOR', 'COORDENADOR');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_COLABORADOR', 'COLABORADOR');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_USUARIO', 'USUARIO');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_REEDUCANDO', 'REEDUCANDO');

INSERT INTO `gestao-projetos`.`tipo_pergunta` (`ID`, `DESCRICAO`) VALUES ('1', 'RESPOSTA �NICA');
INSERT INTO `gestao-projetos`.`tipo_pergunta` (`ID`, `DESCRICAO`) VALUES ('2', 'RESPOSTA M�LTIPLA');
INSERT INTO `gestao-projetos`.`tipo_pergunta` (`ID`, `DESCRICAO`) VALUES ('3', 'TEXTO');


INSERT INTO `gestao-projetos`.`usuario` (`dataCadastro`,`NOME`,`REALIZA_LOGIN`,`SENHA`,`USUARIO`,`PERFIL`) VALUES 
('2016-02-27 00:54:04','WELINGTON RICARDO DE ALMEIDA',1,'$2a$10$zFbgQoQCfWUMrbg/DTyvm.TLWQv1N.kXF33YLPmfH5Me1Y2oVoeG2','welington2.ralmeida@gmail.com','ROLE_COORDENADOR'),
('2016-02-27 00:54:04','DANILO RIGHETTO',1,'$2a$10$zFbgQoQCfWUMrbg/DTyvm.TLWQv1N.kXF33YLPmfH5Me1Y2oVoeG2','danilo.righetto@fornax.com.br','ROLE_COORDENADOR'),
('2016-02-27 00:54:04','LUCAS HENRIQUE',1,'$2a$10$zFbgQoQCfWUMrbg/DTyvm.TLWQv1N.kXF33YLPmfH5Me1Y2oVoeG2','lucas.henrique@fornax.com.br','ROLE_COORDENADOR');

insert into `gestao-projetos`.unidade_prisional (NOME, STATUS_UNIDADE) VALUES ("Carandiru", 1);
insert into `gestao-projetos`.unidade_prisional (NOME, STATUS_UNIDADE) VALUES ("Brasilia", 1);
insert into `gestao-projetos`.unidade_prisional (NOME, STATUS_UNIDADE) VALUES ("PT", 1);

INSERT INTO `gestao-projetos`.`projeto`
(`DATA_CADASTRO`,`DATA_INICIO`,`DATA_TERMINO`,`DESCRICAO`,`NOME`,`STATUS`,`USUARIO`)VALUES
("2016-03-07 09:30:32","2016-03-07 00:00:00","2016-03-31 00:00:00","Projeto 01","Projeto 01","Aberto","1"),
("2016-03-07 09:30:32","2016-03-07 00:00:00","2016-03-31 00:00:00","Projeto 02","Projeto 02","Aberto","1"),
("2016-03-07 09:30:32","2016-03-07 00:00:00","2016-03-31 00:00:00","Projeto 03","Projeto 03","Aberto","1");
