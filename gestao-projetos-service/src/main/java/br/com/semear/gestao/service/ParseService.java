package br.com.semear.gestao.service;

import br.com.semear.gestao.dao.entity.AcaoEntity;
import br.com.semear.gestao.dao.entity.InstituicaoEntity;
import br.com.semear.gestao.dao.entity.ParticipacaoAcaoEntity;
import br.com.semear.gestao.dao.entity.ParticipacaoProjetoEntity;
import br.com.semear.gestao.dao.entity.PerfilEntity;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.dao.entity.QuestionarioEntity;
import br.com.semear.gestao.dao.entity.ReeducandoEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;
import br.com.semear.gestao.dao.entity.UnidadePrisionalEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;
import br.com.semear.gestao.model.Acao;
import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.model.ParticipacaoAcao;
import br.com.semear.gestao.model.ParticipacaoProjeto;
import br.com.semear.gestao.model.Perfil;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Questionario;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.TipoPergunta;
import br.com.semear.gestao.model.UnidadePrisional;
import br.com.semear.gestao.model.Usuario;


public interface ParseService {
	ProjetoEntity parseToEntity(Projeto projeto);
	
	InstituicaoEntity parseToEntity(Instituicao instituicao);
	
	UsuarioEntity parseToEntity(Usuario usuario);
	
	PerfilEntity parseToEntity(Perfil perfil);

	Usuario parseToModel(UsuarioEntity entity);
	
	Instituicao parseToModel(InstituicaoEntity entity);

	Perfil parseToModel(PerfilEntity entity);

	UnidadePrisionalEntity parseToEntity(UnidadePrisional unidade);

	ReeducandoEntity parseToEntity(Reeducando reeducando);

	ParticipacaoProjetoEntity parseToEntity(ParticipacaoProjeto participacaoProjeto);

	ParticipacaoAcaoEntity parseToEntity(ParticipacaoAcao participacaoAcao);

	AcaoEntity parseToEntity(Acao acao);

	Projeto parseToModel(ProjetoEntity entity);

	Reeducando parseToModel(ReeducandoEntity entity);

	UnidadePrisional parseToModel(UnidadePrisionalEntity entity);

	Questionario parseToModel(QuestionarioEntity entity);

	TipoPergunta parseToModel(TipoPerguntaEntity entity);
	
	Acao parseToModel(AcaoEntity a);
}