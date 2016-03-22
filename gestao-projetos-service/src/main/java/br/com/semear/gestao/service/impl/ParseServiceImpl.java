package br.com.semear.gestao.service.impl;

import org.springframework.stereotype.Service;

import br.com.semear.gestao.dao.entity.AcaoEntity;
import br.com.semear.gestao.dao.entity.AlternativaPerguntaAcaoEntity;
import br.com.semear.gestao.dao.entity.AlternativaPerguntaEntity;
import br.com.semear.gestao.dao.entity.InformacaoProjetoEntity;
import br.com.semear.gestao.dao.entity.InstituicaoEntity;
import br.com.semear.gestao.dao.entity.ParticipacaoColaboradorProjetoEntity;
import br.com.semear.gestao.dao.entity.ParticipacaoInstituicaoProjetoEntity;
import br.com.semear.gestao.dao.entity.ParticipacaoReeducandoAcaoEntity;
import br.com.semear.gestao.dao.entity.ParticipacaoReeducandoProjetoEntity;
import br.com.semear.gestao.dao.entity.PerfilEntity;
import br.com.semear.gestao.dao.entity.PerguntaAcaoEntity;
import br.com.semear.gestao.dao.entity.PerguntaEntity;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.dao.entity.QuestionarioAcaoEntity;
import br.com.semear.gestao.dao.entity.QuestionarioEntity;
import br.com.semear.gestao.dao.entity.ReeducandoEntity;
import br.com.semear.gestao.dao.entity.RespostaAcaoEntity;
import br.com.semear.gestao.dao.entity.RespostaEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;
import br.com.semear.gestao.dao.entity.UnidadePrisionalEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;
import br.com.semear.gestao.model.Acao;
import br.com.semear.gestao.model.AlternativaPergunta;
import br.com.semear.gestao.model.AlternativaPerguntaAcao;
import br.com.semear.gestao.model.InformacaoProjeto;
import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.model.ParticipacaoColaboradorProjeto;
import br.com.semear.gestao.model.ParticipacaoInstituicaoProjeto;
import br.com.semear.gestao.model.ParticipacaoReeducandoAcao;
import br.com.semear.gestao.model.ParticipacaoReeducandoProjeto;
import br.com.semear.gestao.model.Perfil;
import br.com.semear.gestao.model.Pergunta;
import br.com.semear.gestao.model.PerguntaAcao;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Questionario;
import br.com.semear.gestao.model.QuestionarioAcao;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.Resposta;
import br.com.semear.gestao.model.RespostaAcao;
import br.com.semear.gestao.model.TipoPergunta;
import br.com.semear.gestao.model.UnidadePrisional;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParseService;

@Service
public class ParseServiceImpl implements ParseService {

	@Override
	public ProjetoEntity parseToEntity(Projeto projeto) {
		ProjetoEntity projetoEn = null;
		if (projeto != null) {
			projetoEn = new ProjetoEntity();
			projetoEn.setId(projeto.getId());
			projetoEn.setNome(projeto.getNome());
			projetoEn.setDescricao(projeto.getDescricao());
			projetoEn.setDataCadastro(projeto.getDataCadastro());
			projetoEn.setDataInicio(projeto.getDataInicio());
			projetoEn.setDataTermino(projeto.getDataTermino());
			projetoEn.setStatus(projeto.getStatus());
			projetoEn.setUsuarioEntity(parseToEntity(projeto.getUsuario()));
			projetoEn.setUnidadePrisional(parseToEntity(projeto.getUnidadePrisional()));
			projetoEn.setObjetivo(projeto.getObjetivo());
			projetoEn.setResultadosEsperados(projeto.getResultadosEsperados());
		}
		return projetoEn;
	}

	// Instituicao

	@Override
	public InstituicaoEntity parseToEntity(Instituicao instituicao) {
		InstituicaoEntity instituicaoEn = null;
		if (instituicao != null) {
			instituicaoEn = new InstituicaoEntity();
			instituicaoEn.setNomefantasia(instituicao.getNomefantasia() != null
					? instituicao.getNomefantasia().toUpperCase() : instituicao.getRazaosocial().toUpperCase());
			instituicaoEn.setRazaosocial(
					instituicao.getRazaosocial() != null ? instituicao.getRazaosocial().toUpperCase() : "");
			instituicaoEn
					.setDocumento(instituicao.getDocumento() != null ? instituicao.getDocumento().toUpperCase() : "");
			instituicaoEn.setTipoDocumento(
					instituicao.getTipoDocumento() != null ? instituicao.getTipoDocumento().toUpperCase() : "");
			instituicaoEn.setLogradouro(
					instituicao.getLogradouro() != null ? instituicao.getLogradouro().toUpperCase() : "");
			instituicaoEn.setNumero(instituicao.getNumero() != null ? instituicao.getNumero().toUpperCase() : "");
			instituicaoEn.setComplemento(
					instituicao.getComplemento() != null ? instituicao.getComplemento().toUpperCase() : "");
			instituicaoEn.setBairro(instituicao.getBairro() != null ? instituicao.getBairro().toUpperCase() : "");
			instituicaoEn.setCep(instituicao.getCep() != null ? instituicao.getCep().toUpperCase() : "");
			instituicaoEn.setUf(instituicao.getUf() != null ? instituicao.getUf().toUpperCase() : "");
			instituicaoEn.setCidade(instituicao.getCidade() != null ? instituicao.getCidade().toUpperCase() : "");
			instituicaoEn.setTelefone(instituicao.getTelefone() != null ? instituicao.getTelefone().toUpperCase() : "");
			instituicaoEn.setEmail(instituicao.getEmail() != null ? instituicao.getEmail().toLowerCase() : "");
			instituicaoEn.setResponsavel(
					instituicao.getResponsavel() != null ? instituicao.getResponsavel().toUpperCase() : "");
			instituicaoEn.setStatus(instituicao.getStatus());
			instituicaoEn.setDataCadastro(instituicao.getDataCadastro());
		}
		return instituicaoEn;
	}

	@Override
	public UsuarioEntity parseToEntity(Usuario usuario) {
		UsuarioEntity usuarioEn = null;
		if (usuario != null) {
			usuarioEn = new UsuarioEntity();
			usuarioEn.setId(usuario.getId());
			usuarioEn.setNome(usuario.getNome().toUpperCase());
			usuarioEn.setUsuario(usuario.getUsuario().toLowerCase());
			usuarioEn.setSenha(usuario.getSenha());
			usuarioEn.setPerfil(parseToEntity(usuario.getPerfil()));
			usuarioEn.setDataCadastro(usuario.getDataCadastro());
			usuarioEn.setRealizaLogin(usuario.getRealizaLogin());
		}

		return usuarioEn;
	}

	@Override
	public PerfilEntity parseToEntity(Perfil perfil) {
		PerfilEntity perfilEn = null;
		if (perfil != null) {
			perfilEn = new PerfilEntity();
			perfilEn.setId(perfil.getId());
			perfilEn.setDescricao(perfil.getDescricao());
		}
		return perfilEn;
	}

	@Override
	public Perfil parseToModel(PerfilEntity entity) {
		Perfil perfil = null;
		if (entity != null) {
			perfil = new Perfil();
			perfil.setId(entity.getId());
			perfil.setDescricao(entity.getDescricao());
		}

		return perfil;
	}

	@Override
	public Usuario parseToModel(UsuarioEntity entity) {
		Usuario usuario = null;
		if (entity != null) {
			usuario = new Usuario();
			usuario.setId(entity.getId());
			usuario.setDataCadastro(entity.getDataCadastro());
			usuario.setNome(entity.getNome().toUpperCase());
			usuario.setPerfil(parseToModel(entity.getPerfil()));
			usuario.setRealizaLogin(entity.getRealizaLogin());
			usuario.setSenha(entity.getSenha());
			usuario.setUsuario(entity.getUsuario().toLowerCase());
		}

		return usuario;
	}

	@Override
	public Instituicao parseToModel(InstituicaoEntity entity) {
		Instituicao instituicao = null;
		if (entity != null) {
			instituicao = new Instituicao();
			instituicao.setId(entity.getId());
			instituicao.setNomefantasia((entity.getNomefantasia() != null ? entity.getNomefantasia().toUpperCase()
					: entity.getRazaosocial().toUpperCase()));
			instituicao.setRazaosocial((entity.getRazaosocial() != null ? entity.getRazaosocial().toUpperCase() : ""));
			instituicao.setDocumento((entity.getDocumento() != null ? entity.getDocumento().toUpperCase() : ""));
			instituicao.setTipoDocumento(
					(entity.getTipoDocumento() != null ? entity.getTipoDocumento().toUpperCase() : ""));
			instituicao.setLogradouro((entity.getLogradouro() != null ? entity.getLogradouro().toUpperCase() : ""));
			instituicao.setNumero((entity.getNumero() != null ? entity.getNumero().toUpperCase() : ""));
			instituicao.setComplemento((entity.getComplemento() != null ? entity.getComplemento().toUpperCase() : ""));
			instituicao.setBairro((entity.getBairro() != null ? entity.getBairro().toUpperCase() : ""));
			instituicao.setCep((entity.getCep() != null ? entity.getCep().toUpperCase() : ""));
			instituicao.setUf((entity.getUf() != null ? entity.getUf().toUpperCase() : ""));
			instituicao.setCidade((entity.getCidade() != null ? entity.getCidade().toUpperCase() : ""));
			instituicao.setTelefone((entity.getTelefone() != null ? entity.getTelefone().toUpperCase() : ""));
			instituicao.setEmail((entity.getEmail() != null ? entity.getEmail().toLowerCase() : ""));
			instituicao.setResponsavel((entity.getResponsavel() != null ? entity.getResponsavel() : ""));
			instituicao.setDataCadastro(entity.getDataCadastro());
			instituicao.setStatus(entity.getStatus());
		}

		return instituicao;
	}

	@Override
	public UnidadePrisionalEntity parseToEntity(UnidadePrisional unidade) {
		UnidadePrisionalEntity unidadePrisionalEn = null;
		if (unidade != null) {
			unidadePrisionalEn = new UnidadePrisionalEntity();
			unidadePrisionalEn.setId(unidade.getId());
			unidadePrisionalEn.setNome(unidade.getNome());
			unidadePrisionalEn.setStatus(unidade.isStatus());
		}

		return unidadePrisionalEn;
	}

	@Override
	public ReeducandoEntity parseToEntity(Reeducando reeducando) {
		ReeducandoEntity reeducandoEn = null;

		if (reeducando != null) {
			reeducandoEn = new ReeducandoEntity();
			reeducandoEn.setId(reeducando.getId());
			reeducandoEn.setMatricula(reeducando.getMatricula());
			reeducandoEn.setNome(reeducando.getNome());
			reeducandoEn.setSexo(reeducando.getSexo());
			reeducandoEn.setCidade(reeducando.getCidade());
			reeducandoEn.setDataNascimento(reeducando.getDataNascimento());
			reeducandoEn.setDataCadastro(reeducando.getDataCadastro());
			reeducandoEn.setUnidadePrisional(parseToEntity(reeducando.getUnidadePrisional()));
			reeducandoEn.setUsuario(parseToEntity(reeducando.getUsuario()));
		}

		return reeducandoEn;
	}

	@Override
	public ParticipacaoReeducandoProjetoEntity parseToEntity(ParticipacaoReeducandoProjeto participacaoProjeto) {
		ParticipacaoReeducandoProjetoEntity participacaoProjetoEn = null;
		if (participacaoProjeto != null) {
			participacaoProjetoEn = new ParticipacaoReeducandoProjetoEntity();
			participacaoProjetoEn.setId(participacaoProjeto.getId());
			participacaoProjetoEn.setProjeto(parseToEntity(participacaoProjeto.getProjeto()));
			participacaoProjetoEn.setReeducando(parseToEntity(participacaoProjeto.getReeducando()));
			participacaoProjetoEn.setDataEntrada(participacaoProjeto.getDataEntrada());
			participacaoProjetoEn.setDataSaida(participacaoProjeto.getDataSaida());
			participacaoProjetoEn.setMotivoSaida(participacaoProjeto.getMotivoSaida());
			participacaoProjetoEn.setFuncao(participacaoProjeto.getFuncao());
		}

		return participacaoProjetoEn;
	}

	@Override
	public ParticipacaoReeducandoAcaoEntity parseToEntity(ParticipacaoReeducandoAcao participacaoAcao) {
		ParticipacaoReeducandoAcaoEntity participacaoAcaoEn = null;

		if (participacaoAcao != null) {
			participacaoAcaoEn = new ParticipacaoReeducandoAcaoEntity();
			participacaoAcaoEn.setId(participacaoAcao.getId());
			participacaoAcaoEn.setAcao(parseToEntity(participacaoAcao.getAcao()));
			participacaoAcaoEn.setReeducando(parseToEntity(participacaoAcao.getReeducando()));
			participacaoAcaoEn.setDataEntrada(participacaoAcao.getDataEntrada());
			participacaoAcaoEn.setDataSaida(participacaoAcao.getDataSaida());
			participacaoAcaoEn.setMotivoSaida(participacaoAcao.getMotivoSaida());
			participacaoAcaoEn.setFuncao(participacaoAcao.getFuncao());
		}

		return participacaoAcaoEn;
	}

	@Override
	public AcaoEntity parseToEntity(Acao acao) {
		AcaoEntity acaoEn = null;
		if (acao != null) {
			acaoEn = new AcaoEntity();
			acaoEn.setId(acao.getId());
			acaoEn.setNome(acao.getNome());
			acaoEn.setDescricao(acao.getDescricao());
			acaoEn.setDataCadastro(acao.getDataCadastro());
			acaoEn.setDataInicio(acao.getDataInicio());
			acaoEn.setDataTermino(acao.getDataTermino());
			acaoEn.setStatus(acao.getStatus());
			acaoEn.setUsuario(parseToEntity(acao.getUsuario()));
		}
		return acaoEn;
	}

	@Override
	public Projeto parseToModel(ProjetoEntity projetoEn) {
		Projeto projeto = null;

		if (projetoEn != null) {
			projeto = new Projeto();
			projeto.setId(projetoEn.getId());
			projeto.setNome(projetoEn.getNome());
			projeto.setDescricao(projetoEn.getDescricao());
			projeto.setDataCadastro(projetoEn.getDataCadastro());
			projeto.setDataInicio(projetoEn.getDataInicio());
			projeto.setDataTermino(projetoEn.getDataTermino());
			projeto.setStatus(projetoEn.getStatus());
			projeto.setUsuario(parseToModel(projetoEn.getUsuarioEntity()));
			projeto.setUnidadePrisional(parseToModel(projetoEn.getUnidadePrisional()));
			projeto.setObjetivo(projetoEn.getObjetivo());
			projeto.setResultadosEsperados(projetoEn.getResultadosEsperados());
		}
		return projeto;
	}

	@Override
	public Reeducando parseToModel(ReeducandoEntity reeducandoEn) {
		Reeducando reeducando = null;

		if (reeducandoEn != null) {
			reeducando = new Reeducando();
			reeducando.setId(reeducandoEn.getId());
			reeducando.setMatricula(reeducandoEn.getMatricula());
			reeducando.setNome(reeducandoEn.getNome());
			reeducando.setSexo(reeducandoEn.getSexo());
			reeducando.setCidade(reeducandoEn.getCidade());
			reeducando.setDataNascimento(reeducandoEn.getDataNascimento());
			reeducando.setDataCadastro(reeducandoEn.getDataCadastro());
			reeducando.setUnidadePrisional(parseToModel(reeducandoEn.getUnidadePrisional()));
			reeducando.setUsuario(parseToModel(reeducandoEn.getUsuario()));
		}

		return reeducando;
	}

	public UnidadePrisional parseToModel(UnidadePrisionalEntity entity) {
		UnidadePrisional unidadePrisional = null;
		if (entity != null) {
			unidadePrisional = new UnidadePrisional();
			unidadePrisional.setId(entity.getId());
			unidadePrisional.setNome(entity.getNome());
			unidadePrisional.setStatus(entity.isStatus());
		}

		return unidadePrisional;
	}

	@Override
	public Questionario parseToModel(QuestionarioEntity entity) {
		Questionario model = null;
		if (entity != null) {
			model = new Questionario();
			model.setDataCadastro(entity.getDataCadastro());
			model.setProjeto(parseToModel(entity.getProjeto()));
			model.setDescricao(entity.getDescricao());
			model.setId(entity.getId());
		}

		return model;
	}

	@Override
	public QuestionarioAcao parseToModel(QuestionarioAcaoEntity entity) {
		QuestionarioAcao model = null;
		if (entity != null) {
			model = new QuestionarioAcao();
			model.setDataCadastro(entity.getDataCadastro());
			model.setAcao(parseToModel(entity.getAcao()));
			model.setDescricao(entity.getDescricao());
			model.setId(entity.getId());
		}
		return model;

	}

	@Override
	public TipoPergunta parseToModel(TipoPerguntaEntity entity) {
		TipoPergunta model = null;
		if (entity != null) {
			model = new TipoPergunta();
			model.setDescricao(entity.getDescricao());
			model.setId(entity.getId());
		}
		return model;
	}

	@Override
	public TipoPerguntaEntity parseToEntity(TipoPergunta model) {
		TipoPerguntaEntity entity = null;
		if (model != null) {
			entity = new TipoPerguntaEntity();
			entity.setDescricao(model.getDescricao());
			entity.setId(model.getId());
		}
		return entity;
	}

	@Override
	public Acao parseToModel(AcaoEntity a) {
		Acao acao = new Acao();
		acao.setId(a.getId());
		acao.setNome(a.getNome());
		acao.setDescricao(a.getDescricao());
		acao.setDataCadastro(a.getDataCadastro());
		acao.setDataInicio(a.getDataInicio());
		acao.setDataTermino(a.getDataTermino());
		acao.setStatus(a.getStatus());
		acao.setUsuario(parseToModel(a.getUsuario()));
		return acao;
	}

	@Override
	public QuestionarioEntity parseToEntity(Questionario model) {
		QuestionarioEntity entity = null;
		if (model != null) {
			entity = new QuestionarioEntity();
			entity.setDataCadastro(model.getDataCadastro());
			entity.setProjeto(parseToEntity(model.getProjeto()));
			entity.setDescricao(model.getDescricao());
			entity.setId(model.getId());
		}
		return entity;
	}

	@Override
	public QuestionarioAcaoEntity parseToEntity(QuestionarioAcao model) {
		QuestionarioAcaoEntity entity = null;
		if (model != null) {
			entity = new QuestionarioAcaoEntity();
			entity.setDataCadastro(model.getDataCadastro());
			entity.setAcao(parseToEntity(model.getAcao()));
			entity.setDescricao(model.getDescricao());
			entity.setId(model.getId());

		}
		return entity;
	}

	@Override
	public PerguntaEntity parseToEntity(Pergunta model) {
		PerguntaEntity entity = null;
		if (model != null) {
			entity = new PerguntaEntity();
			entity.setDataCadastro(model.getDataCadastro());
			entity.setDescricaoPergunta(model.getDescricaoPergunta());
			entity.setId(model.getId());
			entity.setQuestionarioEntity(parseToEntity(model.getQuestionario()));
			entity.setTipoPerguntaentity(parseToEntity(model.getTipoPergunta()));
			entity.setUsuarioEntity(parseToEntity(model.getUsuario()));
		}
		return entity;
	}

	@Override
	public PerguntaAcaoEntity parseToEntity(PerguntaAcao model) {
		PerguntaAcaoEntity entity = null;
		if (model != null) {
			entity = new PerguntaAcaoEntity();
			entity.setDataCadastro(model.getDataCadastro());
			entity.setDescricaoPerguntaAcao(model.getDescricaoPerguntaAcao());
			entity.setId(model.getId());
			entity.setQuestionarioAcaoEntity(parseToEntity(model.getQuestionarioAcao()));
			entity.setTipoPerguntaentity(parseToEntity(model.getTipoPergunta()));
			entity.setUsuarioEntity(parseToEntity(model.getUsuario()));
		}
		return entity;
	}

	@Override
	public Pergunta parseToModel(PerguntaEntity entity) {
		Pergunta model = null;
		if (entity != null) {
			model = new Pergunta();
			model.setDataCadastro(entity.getDataCadastro());
			model.setDescricaoPergunta(entity.getDescricaoPergunta());
			model.setId(entity.getId());
			model.setQuestionario(parseToModel(entity.getQuestionarioEntity()));
			model.setTipoPergunta(parseToModel(entity.getTipoPerguntaentity()));
			model.setUsuario(parseToModel(entity.getUsuarioEntity()));
		}
		return model;
	}

	@Override
	public PerguntaAcao parseToModel(PerguntaAcaoEntity entity) {
		PerguntaAcao model = null;
		if (entity != null) {
			model = new PerguntaAcao();
			model.setDataCadastro(entity.getDataCadastro());
			model.setDescricaoPerguntaAcao(entity.getDescricaoPerguntaAcao());
			model.setId(entity.getId());
			model.setQuestionarioAcao(parseToModel(entity.getQuestionarioAcaoEntity()));
			model.setTipoPergunta(parseToModel(entity.getTipoPerguntaentity()));
			model.setUsuario(parseToModel(entity.getUsuarioEntity()));
		}
		return model;
	}

	@Override
	public AlternativaPerguntaEntity parseToEntity(AlternativaPergunta model) {
		AlternativaPerguntaEntity entity = null;
		if (model != null) {
			entity = new AlternativaPerguntaEntity();
			entity.setDataCadastro(model.getDataCadastro());
			entity.setDescricaoAlternativa(model.getDescricaoAlternativa());
			entity.setId(model.getId());
			entity.setPerguntaEntity(parseToEntity(model.getPergunta()));
		}

		return entity;
	}

	@Override
	public AlternativaPerguntaAcaoEntity parseToEntity(AlternativaPerguntaAcao model) {
		AlternativaPerguntaAcaoEntity entity = null;
		if (model != null) {
			entity = new AlternativaPerguntaAcaoEntity();
			entity.setDataCadastro(model.getDataCadastro());
			entity.setDescricaoAlternativaAcao(model.getDescricaoAlternativa());
			entity.setId(model.getId());
			entity.setPerguntaAcaoEntity(parseToEntity(model.getPerguntaAcao()));
		}

		return entity;
	}

	@Override
	public AlternativaPerguntaAcao parseToModel(AlternativaPerguntaAcaoEntity entity) {
		AlternativaPerguntaAcao model = null;
		if (entity != null) {
			model = new AlternativaPerguntaAcao();
			model.setDataCadastro(entity.getDataCadastro());
			model.setDescricaoAlternativa(entity.getDescricaoAlternativaAcao());
			model.setId(entity.getId());
			model.setPerguntaAcao(parseToModel(entity.getPerguntaAcaoEntity()));
		}

		return model;
	}

	public ParticipacaoColaboradorProjetoEntity parseToEntity(ParticipacaoColaboradorProjeto model) {
		ParticipacaoColaboradorProjetoEntity entity = null;
		if (model != null) {
			entity = new ParticipacaoColaboradorProjetoEntity();
			entity.setId(model.getId());
			entity.setProjeto(parseToEntity(model.getProjeto()));
			entity.setColaborador(parseToEntity(model.getColaborador()));
			entity.setDataEntrada(model.getDataEntrada());
			entity.setDataSaida(model.getDataSaida());
			entity.setMotivoSaida(model.getMotivoSaida());
		}
		return entity;
	}

	@Override
	public ParticipacaoInstituicaoProjetoEntity parseToEntity(ParticipacaoInstituicaoProjeto model) {
		ParticipacaoInstituicaoProjetoEntity entity = null;
		if (model != null) {
			entity = new ParticipacaoInstituicaoProjetoEntity();
			entity.setId(model.getId());
			entity.setProjeto(parseToEntity(model.getProjeto()));
			entity.setInstituicao(parseToEntity(model.getInstituicao()));
			entity.setDataEntrada(model.getDataEntrada());
		}
		return entity;
	}

	@Override
	public ParticipacaoInstituicaoProjeto parseToModel(ParticipacaoInstituicaoProjetoEntity entity) {
		ParticipacaoInstituicaoProjeto model = null;
		if (entity != null) {
			model = new ParticipacaoInstituicaoProjeto();
			model.setId(entity.getId());
			model.setProjeto(parseToModel(entity.getProjeto()));
			model.setInstituicao(parseToModel(entity.getInstituicao()));
			model.setDataEntrada(entity.getDataEntrada());
		}
		return model;
	}

	@Override
	public ParticipacaoReeducandoProjeto parseToModel(ParticipacaoReeducandoProjetoEntity entity) {
		ParticipacaoReeducandoProjeto model = null;
		if (entity != null) {
			model = new ParticipacaoReeducandoProjeto();
			model.setId(entity.getId());
			model.setProjeto(parseToModel(entity.getProjeto()));
			model.setReeducando(parseToModel(entity.getReeducando()));
			model.setDataEntrada(entity.getDataEntrada());
			model.setDataSaida(entity.getDataSaida());
			model.setMotivoSaida(entity.getMotivoSaida());
			model.setFuncao(entity.getFuncao());
		}

		return model;
	}

	@Override
	public ParticipacaoColaboradorProjeto parseToModel(ParticipacaoColaboradorProjetoEntity entity) {
		ParticipacaoColaboradorProjeto model = null;
		if (entity != null) {
			model = new ParticipacaoColaboradorProjeto();
			model.setId(entity.getId());
			model.setProjeto(parseToModel(entity.getProjeto()));
			model.setColaborador(parseToModel(entity.getColaborador()));
			model.setDataEntrada(entity.getDataEntrada());
			model.setDataSaida(entity.getDataSaida());
			model.setMotivoSaida(entity.getMotivoSaida());
		}
		return model;
	}

	@Override
	public InformacaoProjetoEntity parseToEntity(InformacaoProjeto model) {
		InformacaoProjetoEntity entity = null;
		if(model != null){
			entity = new InformacaoProjetoEntity();
			entity.setId(model.getId());
			entity.setProjeto(parseToEntity(model.getProjeto()));
			entity.setInformacoes(model.getInformacoes());
			entity.setDataCadastro(model.getDataCadastro());
			entity.setDataEdicao(model.getDataEdicao());
			entity.setUsuario(parseToEntity(model.getUsuario()));
		}
		return entity;
	}

	@Override
	public InformacaoProjeto parseToModel(InformacaoProjetoEntity entity) {
		InformacaoProjeto model = null;
		if(entity != null){
			model = new InformacaoProjeto();
			model.setId(entity.getId());
			model.setProjeto(parseToModel(entity.getProjeto()));
			model.setInformacoes(entity.getInformacoes());
			model.setDataCadastro(entity.getDataCadastro());
			model.setDataEdicao(entity.getDataEdicao());
			model.setUsuario(parseToModel(entity.getUsuario()));
		}
		return model;
	}
	
	@Override
	public RespostaAcao parseToModel(RespostaAcaoEntity entity) {
		RespostaAcao model = null;
		if (entity != null) {
			model = new RespostaAcao();
			model.setDataCadastro(entity.getDataCadastro());
			model.setDescricaoRespostaAcao(entity.getDescricaoRespostaAcao());
			model.setPerguntaAcao(parseToModel(entity.getPerguntaAcaoEntity()));
			model.setDataAlteracao(entity.getDataAlteracao());
			model.setUsuario(parseToModel(entity.getUsuarioEntity()));
			model.setId(entity.getId());
		}
		return model;
	}

	@Override
	public Resposta parseToModel(RespostaEntity entity) {
		Resposta model = null;
		if (entity != null) {
			model = new Resposta();
			model.setDataCadastro(entity.getDataCadastro());
			model.setDescricaoResposta(entity.getDescricaoResposta());
			model.setPergunta(parseToModel(entity.getPerguntaEntity()));
			model.setDataAlteracao(entity.getDataAlteracao());
			model.setUsuario(parseToModel(entity.getUsuarioEntity()));
			model.setId(entity.getId());
		}
		return model;
	}
}
