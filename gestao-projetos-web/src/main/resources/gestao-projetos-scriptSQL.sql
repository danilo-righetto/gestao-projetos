INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_ADMINISTRADOR', 'ADMINISTRADOR');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_COORDENADOR', 'COORDENADOR');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_COLABORADOR', 'COLABORADOR');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_USUARIO', 'USUARIO');
INSERT INTO `gestao-projetos`.`perfil` (`id`, `descricao`) VALUES ('ROLE_REEDUCANDO', 'REEDUCANDO');

INSERT INTO `gestao-projetos`.`usuario` (`dataCadastro`,`NOME`,`REALIZA_LOGIN`,`SENHA`,`USUARIO`,`PERFIL`)
VALUES ('2016-02-27 00:54:04','WELINGTON RICARDO DE ALMEIDA',1,'$2a$10$zFbgQoQCfWUMrbg/DTyvm.TLWQv1N.kXF33YLPmfH5Me1Y2oVoeG2','welington2.ralmeida@gmail.com','ROLE_COORDENADOR');