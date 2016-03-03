package br.com.semear.gestao.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "INSTITUICAO")
public class InstituicaoEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NOME_FANTASIA")
	private String nomefantasia;

	@Column(name = "RAZAO_SOCIAL")
	private String razaosocial;

	@Column(name = "DOCUMENTO", unique = true)
	private String documento;

	@Column(name = "TIPO_DOCUMENTO")
	private String tipoDocumento;

	@Column(name = "LOGRADOURO")
	private String logradouro;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "CEP")
	private String cep;

	@Column(name = "UF")
	private String uf;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "EMAIL", unique = true)
	private String email;

	@Column(name = "RESPONSAVEL")
	private String responsavel;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJETO_INSTITUICAO", nullable = false)
	private ProjetoEntity projetoInstituicao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UNIDADE_PRISIONAL", nullable = false)
	private UnidadePrisionalEntity unidadePrisional;
	
	public UnidadePrisionalEntity getUnidadePrisional() {
		return unidadePrisional;
	}

	public void setUnidadePrisional(UnidadePrisionalEntity unidadePrisional) {
		this.unidadePrisional = unidadePrisional;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS")
	private String status;

	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public long getId() {
		return id;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public ProjetoEntity getProjetoInstituicao() {
		return projetoInstituicao;
	}

	public void setProjetoInstituicao(ProjetoEntity projetoInstituicao) {
		this.projetoInstituicao = projetoInstituicao;
	}

}
