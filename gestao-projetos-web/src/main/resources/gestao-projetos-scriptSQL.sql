INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_ADMINISTRADOR', 'ADMINISTRADOR');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_COORDENADOR', 'COORDENADOR');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_COLABORADOR', 'COLABORADOR');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_USUARIO', 'USUARIO');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_ESTAGIARIO', 'ESTAGIARIO');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_AVALIADOR_INTERNO', 'AVALIADOR_INTERNO');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_AVALIADOR_EXTERNO', 'AVALIADOR_EXTERNO');

INSERT INTO `gestao-projetos`.`tipo_pergunta` (`ID`, `DESCRICAO`) VALUES ('1', 'RESPOSTA UNICA');
INSERT INTO `gestao-projetos`.`tipo_pergunta` (`ID`, `DESCRICAO`) VALUES ('2', 'RESPOSTA MULTIPLA');
INSERT INTO `gestao-projetos`.`tipo_pergunta` (`ID`, `DESCRICAO`) VALUES ('3', 'TEXTO');
INSERT INTO `gestao-projetos`.`tipo_pergunta` (`ID`, `DESCRICAO`) VALUES ('4', 'SIM / NÃO');


INSERT INTO `gestao-projetos`.`usuario` (`dataCadastro`,`NOME`,`REALIZA_LOGIN`,`SENHA`,`USUARIO`,`PERFIL`) VALUES 
('2016-02-27 00:54:04','WELINGTON RICARDO DE ALMEIDA',1,'$2a$10$zFbgQoQCfWUMrbg/DTyvm.TLWQv1N.kXF33YLPmfH5Me1Y2oVoeG2','welington2.ralmeida@gmail.com','ROLE_COORDENADOR'),
('2016-02-27 00:54:04','DANILO RIGHETTO',1,'$2a$10$zFbgQoQCfWUMrbg/DTyvm.TLWQv1N.kXF33YLPmfH5Me1Y2oVoeG2','danilo.righetto@fornax.com.br','ROLE_COORDENADOR'),
('2016-02-27 00:54:04','LUCAS HENRIQUE',1,'$2a$10$zFbgQoQCfWUMrbg/DTyvm.TLWQv1N.kXF33YLPmfH5Me1Y2oVoeG2','lucas.henrique@fornax.com.br','ROLE_COORDENADOR');
