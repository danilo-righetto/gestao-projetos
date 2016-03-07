package br.com.semear.gestao.service.impl;

import org.springframework.stereotype.Service;

import br.com.semear.gestao.dao.entity.AcaoEntity;
import br.com.semear.gestao.dao.entity.AlternativaPerguntaEntity;
import br.com.semear.gestao.dao.entity.InstituicaoEntity;
import br.com.semear.gestao.dao.entity.ParticipacaoAcaoEntity;
import br.com.semear.gestao.dao.entity.ParticipacaoProjetoEntity;
import br.com.semear.gestao.dao.entity.PerfilEntity;
import br.com.semear.gestao.dao.entity.PerguntaEntity;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.dao.entity.QuestionarioEntity;
import br.com.semear.gestao.dao.entity.ReeducandoEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;
import br.com.semear.gestao.dao.entity.UnidadePrisionalEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;
import br.com.semear.gestao.model.Acao;
import br.com.semear.gestao.model.AlternativaPergunta;
import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.model.ParticipacaoAcao;
import br.com.semear.gestao.model.ParticipacaoProjeto;
import br.com.semear.gestao.model.Perfil;
import br.com.semear.gestao.model.Pergunta;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Questionario;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.TipoPergunta;
import br.com.semear.gestao.model.UnidadePrisional;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParseService;

@Service
public class ParseServiceImpl implements ParseService {

	@Override
	public ProjetoEntity parseToEntity(Projeto projeto) {
		ProjetoEntity projetoEn = null;
		if(projeto != null){
			projetoEn = new ProjetoEntity();
			projetoEn.setId(projeto.getId());
			projetoEn.setNome(projeto.getNome());
			projetoEn.setDescricao(projeto.getDescricao());
			projetoEn.setDataCadastro(projeto.getDataCadastro());
			projetoEn.setDataInicio(projeto.getDataInicio());
			projetoEn.setDataTermino(projeto.getDataTermino());
			projetoEn.setStatus(projeto.getStatus());
			projetoEn.setUsuarioEntity(parseToEntity(projeto.getUsuario()));
		}
		return projetoEn;
	}
	
	//Instituicao
	
	@Override
	public InstituicaoEntity parseToEntity(Instituicao instituicao) {
		InstituicaoEntity instituicaoEn = null;
		if(instituicao != null){
			instituicaoEn = new InstituicaoEntity();
			instituicaoEn.setNomefantasia(instituicao.getNomefantasia());
			instituicaoEn.setRazaosocial(instituicao.getRazaosocial());
			instituicaoEn.setDocumento(instituicao.getDocumento());
			instituicaoEn.setTipoDocumento(instituicao.getTipoDocumento());
			instituicaoEn.setLogradouro(instituicao.getLogradouro());
			instituicaoEn.setNumero(instituicao.getNumero());
			instituicaoEn.setComplemento(instituicao.getComplemento());
			instituicaoEn.setBairro(instituicao.getBairro());
			instituicaoEn.setCep(instituicao.getCep());
			instituicaoEn.setUf(instituicao.getUf());
			instituicaoEn.setCidade(instituicao.getCidade());
			instituicaoEn.setTelefone(instituicao.getTelefone());
			instituicaoEn.setEmail(instituicao.getEmail());
			instituicaoEn.setResponsavel(instituicao.getResponsavel());
			instituicaoEn.setProjetoInstituicao(parseToEntity(instituicao.getProjetoInstituicao()));
			instituicaoEn.setStatus(instituicao.getStatus());
			instituicaoEn.setDataCadastro(instituicao.getDataCadastro());
			instituicaoEn.setUnidadePrisional(parseToEntity(instituicao.getUnidadePrisional()));
		}
		return instituicaoEn;
	}

	@Override
	public UsuarioEntity parseToEntity(Usuario usuario) {
		UsuarioEntity usuarioEn = null;
		if(usuario != null){
			usuarioEn = new UsuarioEntity();
			usuarioEn.setId(usuario.getId());
			usuarioEn.setNome(usuario.getNome());
			usuarioEn.setUsuario(usuario.getUsuario());
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
		if(perfil != null){
			perfilEn = new PerfilEntity();
			perfilEn.setId(perfil.getId());
			perfilEn.setDescricao(perfil.getDescricao());	
		}
		return perfilEn;
	}

	@Override
	public Perfil parseToModel(PerfilEntity entity) {
		Perfil perfil = null;
		if(entity != null){
			perfil = new Perfil();
			perfil.setId(entity.getId());
			perfil.setDescricao(entity.getDescricao());
		}

		return perfil;
	}

	@Override
	public Usuario parseToModel(UsuarioEntity entity) {
		Usuario usuario = null;
		if(entity != null){
			usuario = new Usuario();
			usuario.setId(entity.getId());
			usuario.setDataCadastro(entity.getDataCadastro());
			usuario.setNome(entity.getNome());
			usuario.setPerfil(parseToModel(entity.getPerfil()));
			usuario.setRealizaLogin(entity.getRealizaLogin());
			//usuario.setInstituicao(parseToModel(entity.getInstituicao()));
			usuario.setSenha(entity.getSenha());
			usuario.setUsuario(entity.getUsuario());
		}
		
		return usuario;
	}
	
	@Override
	public Instituicao parseToModel(InstituicaoEntity entity) {
		Instituicao instituicao = null;
		if(entity != null){
			instituicao = new Instituicao();
			instituicao.setId(entity.getId());
			instituicao.setNomefantasia(entity.getNomefantasia());
			instituicao.setRazaosocial(entity.getRazaosocial());
			instituicao.setDocumento(entity.getDocumento());
			instituicao.setTipoDocumento(entity.getTipoDocumento());
			instituicao.setLogradouro(entity.getLogradouro());
			instituicao.setNumero(entity.getNumero());
			instituicao.setComplemento(entity.getComplemento());
			instituicao.setBairro(entity.getBairro());
			instituicao.setCep(entity.getCep());
			instituicao.setUf(entity.getUf());
			instituicao.setCidade(entity.getCidade());
			instituicao.setTelefone(entity.getTelefone());
			instituicao.setEmail(entity.getEmail());
			instituicao.setResponsavel(entity.getResponsavel());
			instituicao.setProjetoInstituicao(parseToModel(entity.getProjetoInstituicao()));
			instituicao.setDataCadastro(entity.getDataCadastro());
			instituicao.setStatus(entity.getStatus());
			instituicao.setUnidadePrisional(parseToModel(entity.getUnidadePrisional()));
			
		}
		
		return instituicao;
	}

	@Override
	public UnidadePrisionalEntity parseToEntity(UnidadePrisional unidade) {
		UnidadePrisionalEntity unidadePrisionalEn = null;
		if(unidade != null){
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
		
		if(reeducando != null){
			reeducandoEn = new ReeducandoEntity();
			reeducandoEn.setId(reeducando.getId());
			reeducandoEn.setMatricula(reeducando.getMatricula());
			reeducandoEn.setNome(reeducando.getNome());
			reeducandoEn.setSexo(reeducando.getSexo());
			reeducandoEn.setDataNascimento(reeducando.getDataNascimento());
			reeducandoEn.setDataCadastro(reeducando.getDataCadastro());
			reeducandoEn.setUnidadePrisional(parseToEntity(reeducando.getUnidadePrisional()));
		}

		return reeducandoEn;
	}

	@Override
	public ParticipacaoProjetoEntity parseToEntity(ParticipacaoProjeto participacaoProjeto) {
		ParticipacaoProjetoEntity participacaoProjetoEn = null;
		if(participacaoProjeto != null){
			participacaoProjetoEn = new ParticipacaoProjetoEntity();
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
	public ParticipacaoAcaoEntity parseToEntity(ParticipacaoAcao participacaoAcao) {
		ParticipacaoAcaoEntity participacaoAcaoEn = null;
		
		if(participacaoAcao != null){
			participacaoAcaoEn = new ParticipacaoAcaoEntity();
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
		if(acao != null){
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
		
		if(projetoEn != null){
			projeto = new Projeto();
			projeto.setId(projetoEn.getId());
			projeto.setNome(projetoEn.getNome());
			projeto.setDescricao(projetoEn.getDescricao());
			projeto.setDataCadastro(projetoEn.getDataCadastro());
			projeto.setDataInicio(projetoEn.getDataInicio());
			projeto.setDataTermino(projetoEn.getDataTermino());
			projeto.setStatus(projetoEn.getStatus());
			projeto.setUsuario(parseToModel(projetoEn.getUsuarioEntity()));
		}
		

		return projeto;
	}

	@Override
	public Reeducando parseToModel(ReeducandoEntity reeducandoEn) {
		Reeducando reeducando = null;
		
		if(reeducandoEn != null){
			reeducando = new Reeducando();
			reeducando.setId(reeducandoEn.getId());
			reeducando.setMatricula(reeducandoEn.getMatricula());
			reeducando.setNome(reeducandoEn.getNome());
			reeducando.setSexo(reeducandoEn.getSexo());
			reeducando.setDataNascimento(reeducandoEn.getDataNascimento());
			reeducando.setDataCadastro(reeducandoEn.getDataCadastro());
			reeducando.setUnidadePrisional(parseToModel(reeducandoEn.getUnidadePrisional()));
		}

		
		return reeducando;
	}

	public UnidadePrisional parseToModel(UnidadePrisionalEntity entity) {
		UnidadePrisional unidadePrisional = null;
		if(entity != null){
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
		if(entity != null){
			model = new Questionario();
			model.setDataCadastro(entity.getDataCadastro());
			model.setProjeto(parseToModel(entity.getProjeto()));
			model.setDescricao(entity.getDescricao());
			model.setId(entity.getId());
		}
		
		return model;
	}

	@Override
	public TipoPergunta parseToModel(TipoPerguntaEntity entity) {
		TipoPergunta model = null;
		if(entity != null){
			model = new TipoPergunta();
			model.setDescricao(entity.getDescricao());
			model.setId(entity.getId());
		}
		return model;
	}
	
	@Override
	public TipoPerguntaEntity parseToEntity(TipoPergunta model) {
		TipoPerguntaEntity entity = null;
		if(model != null){
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
		if(model != null){
			entity = new QuestionarioEntity();
			entity.setDataCadastro(model.getDataCadastro());
			entity.setProjeto(parseToEntity(model.getProjeto()));
			entity.setDescricao(model.getDescricao());
			entity.setId(model.getId());
		}
		return entity;
	}

	@Override
	public PerguntaEntity parseToEntity(Pergunta model) {
		PerguntaEntity entity = null;
		if(model != null){
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
	public Pergunta parseToModel(PerguntaEntity entity) {
		Pergunta model = null;
		if(entity != null){
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
	public AlternativaPerguntaEntity parseToEntity(AlternativaPergunta model) {
		AlternativaPerguntaEntity entity = null;
		if(model != null){
			entity = new AlternativaPerguntaEntity();
			entity.setDataCadastro(model.getDataCadastro());
			entity.setDescricaoAlternativa(model.getDescricaoAlternativa());
			entity.setId(model.getId());
			entity.setPerguntaEntity(parseToEntity(model.getPergunta()));
		}
		
		return entity;
	}
}