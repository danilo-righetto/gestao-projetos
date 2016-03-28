<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<style type="text/css">
textarea {
	resize: none;
}
</style>
</head>

<script type="text/javascript">
	$(function() {
		$("#menu-projetos").attr('class', 'active');
		$(".data").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta',
							'Quinta', 'Sexta', 'Sábado' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'Sáb', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
							'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
							'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
					nextText : 'Próximo',
					prevText : 'Anterior'
				});
	});
</script>

<body>
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Detalhar Projeto</h4>
			<hr />
			<div class="row">
				<div class="col-md-12">
					<input type="hidden" name="id" value="${projeto.id}">
					<div class="row">
						<div class="form-group col-md-3">
							<label for="nome">Nome:</label> <input type="text"
								class="form-control" id="nome" name="nome"
								value="${projeto.nome}" placeholder="Digite o nome" required
								readOnly="readOnly" autofocus>
						</div>
						<div class="form-group col-md-2">
							<label for="status">Status</label> <select class="form-control"
								name="status" required readOnly="readOnly">
								<c:choose>
									<c:when test="${projeto.status == 'Aberto'}">
										<option selected="selected" value="Aberto">Aberto</option>
									</c:when>
									<c:when test="${projeto.status == 'Em andamento'}">
										<option selected="selected" value="Em andamento">Em
											andamento</option>
									</c:when>
									<c:when test="${projeto.status == 'Encerrado'}">
										<option selected="selected" value="Encerrado">Encerrado</option>
									</c:when>
									<c:when test="${projeto.status == 'Concluido'}">
										<option selected="selected" value="Concluido">Concluido</option>
									</c:when>
									<c:otherwise>
										<option value="Aberto">Aberto</option>
										<option value="Em andamento">Em andamento</option>
										<option value="Encerrado">Encerrado</option>
										<option value="Concluido">Concluido</option>
									</c:otherwise>
								</c:choose>
							</select>
						</div>
						<div class="form-group col-md-2">
							<label for="dataInicio">Data Inicio:</label> <input type="text"
								class="form-control data" id="dataInicio" name="dataInicio"
								value="<fmt:formatDate value="${projeto.dataInicio.time}" pattern="dd/MM/yyyy"></fmt:formatDate>"
								placeholder="Selecione a Data" required autofocus
								disabled="disabled">
						</div>
						<div class="form-group col-md-2">
							<label for="dataTermino">Data Termino:</label> <input type="text"
								value="<fmt:formatDate value="${projeto.dataTermino.time}" pattern="dd/MM/yyyy"></fmt:formatDate>"
								class="form-control data" id="dataTermino" name="dataTermino"
								placeholder="Selecione a Data" required autofocus
								disabled="disabled">
						</div>
						<div class="form-group col-md-3">
							<label for="unidadePrisional">Unidade Prisional:</label> <input
								class="form-control" id="unidadePrisional"
								name="unidadePrisional.nome"
								value="${projeto.unidadePrisional.nome}" readOnly="readOnly" />
						</div>
						<div class="form-group col-md-12">
							<label for="descricao">Descrição</label>
							<textarea readOnly="readOnly" class="form-control" cols="10"
								rows="5" id="descricao" name="descricao" required>${projeto.descricao}</textarea>
						</div>
						<div class="form-group col-md-6">
							<label for="objetivo">Objetivo do Projeto:</label>
							<textarea readOnly="readOnly" class="form-control" id="objetivo"
								name="objetivo" rows="4" cols="5" required>${projeto.objetivo}</textarea>
						</div>
						<div class="form-group col-md-6">
							<label for="resultados">Resultados Esperados:</label>
							<textarea readOnly="readOnly" class="form-control"
								id="resultados" name="resultadosEsperados" rows="4" cols="5"
								required>${projeto.resultadosEsperados}</textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<h4 style="font-family: arial; color: #4DC1FF">Perguntas</h4>
				<table class="table table-responsive" id="tbPerguntas">
					<thead>
						<tr>
							<td class="text-center"><span style="font-weight: bold;">Tipo
									de Pergunta</span></td>
							<td class="text-center"><span style="font-weight: bold;">Pergunta</span></td>
							<td class="text-center"><span style="font-weight: bold;">Data
									de Cadastro</span></td>
						</tr>
					</thead>
					<tbody id="tbBodyPerguntas">
						<c:forEach items="${questionario.perguntas}" var="pergunta">
							<tr>
								<c:choose>
									<c:when
										test="${pergunta.tipoPergunta.descricao ne null or not empty pergunta.tipoPergunta.descricao}">
										<td class="text-center">${pergunta.tipoPergunta.descricao}</td>
									</c:when>
									<c:otherwise>
										<c:if test="${pergunta.tipoPergunta.id eq 1}">
											<td class="text-center">RESPOSTA ÚNICA</td>
										</c:if>
										<c:if test="${pergunta.tipoPergunta.id eq 2}">
											<td class="text-center">RESPOSTA MÚLTIPLA</td>
										</c:if>
										<c:if test="${pergunta.tipoPergunta.id eq 3}">
											<td class="text-center">TEXTO</td>
										</c:if>
										<c:if test="${pergunta.tipoPergunta.id eq 4}">
											<td class="text-center">SIM/NÃO</td>
										</c:if>
									</c:otherwise>
								</c:choose>
								<td class="text-center">${pergunta.descricaoPergunta}</td>
								<td class="text-center"><fmt:formatDate
										value="${pergunta.dataCadastro.time}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
			</div>
			<div class="row">
				<h4 class="title-screen">Instituições Associadas</h4>
				<div id="alertas"></div>
				<table class="table table-responsive">
					<thead>
						<tr class="text-center">
							<td><span style="font-weight: bold;">#</span></td>
							<td class="hidden-xs hidden-sm"><span
								style="font-weight: bold;">Tipo de Pessoa</span></td>
							<td><span style="font-weight: bold;">Cidade</span></td>
							<td class="hidden-xs hidden-sm"><span
								style="font-weight: bold;">Razão Social</span></td>
							<td class="hidden-xs hidden-sm"><span
								style="font-weight: bold;">Responsável</span></td>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty instituicoes}">
								<c:forEach items="${instituicoes}" var="instituicao">
									<tr>
										<td class="text-center">${instituicao.id}</td>
										<td class="text-center hidden-xs hidden-sm">${(instituicao.instituicao.tipoDocumento
											== "CNPJ" ? 'Pessoa Juridica' : 'Pessoa Fisica')}</td>
										<td class="text-center">${instituicao.instituicao.cidade}</td>
										<td class="text-center hidden-xs hidden-sm">${instituicao.instituicao.razaosocial}</td>
										<td class="text-center hidden-xs hidden-sm">${instituicao.instituicao.responsavel}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6">Não há dados a serem exibidos</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h4 class="title-screen">Coodernador e Participantes do
						Projeto</h4>
					<div class="col-md-offset-3">
						<div class="form-group col-md-4">
							<label for="instituicao">Instituição:</label> <select
								disabled="disabled" id="instituicao" name="instituicao"
								class="form-control" required autofocus
								onchange="listarCoordenadores();">
								<option value="" label="Selecione..." />
								<c:forEach var="associada" items="${instituicoesAssociadas}">
									<option
										${coordernadorProjeto.instituicao.id == associada.instituicao.id ? "selected='selected'" : ""}
										value="${associada.instituicao.id}"
										label="${associada.instituicao.razaosocial}" />

								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-4" id="coordenadores">
							<label for="coordenador">Coordenador:</label> <select
								id="coordenador" name="idCoordenador" class="form-control"
								disabled="disabled" required>
								<c:if test="${coordernadorProjeto ne null}">
									<option value="${coordernadorProjeto.id}"
										label="${coordernadorProjeto.nome}" />
								</c:if>
							</select>
						</div>
					</div>
				</div>
				<br />
				<h4 class="title-screen" id="titleReeducandos">Reeducandos</h4>
				<table class="table table-responsive" id="reeducandos">
					<thead>
						<tr class="text-center">
							<td><span style="font-weight: bold;">#</span></td>
							<td><span style="font-weight: bold;">Matrícula</span></td>
							<td><span style="font-weight: bold;">Nome</span></td>
							<td><span style="font-weight: bold;">Sexo</span></td>
							<td><span style="font-weight: bold;">Função</span></td>
						</tr>
					</thead>
					<tbody id="tbody-reeducandos">
						<c:forEach var="reeducando" items="${reeducandosAssociados}">
							<tr class="text-center">
								<td>${reeducando.reeducando.id}</td>
								<td>${reeducando.reeducando.matricula}</td>
								<td>${reeducando.reeducando.nome}</td>
								<td>${reeducando.reeducando.sexo}</td>
								<td class="col-md-3"><select class='form-control'
									id="funcao${reeducando.reeducando.id}" name='funcoes' disabled>
										<option value='' label='Selecione...' />
										<option
											${reeducando.funcao  ne null && reeducando.funcao eq 'Reeducando Participante' ? "selected":""}
											value='Reeducando Participante'
											label='REEDUCANDO PARTICIPANTE' />
										<option
											${reeducando.funcao  ne null && reeducando.funcao eq 'Reeducando Monitor' ? "selected":""}
											value='Reeducando Monitor' label='REEDUCANDO MONITOR'></option>
								</select></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
				<h4 class="title-screen" id="titleColaboradores">Colaboradores</h4>
				<table class="table table-responsive" id="colaboradores">
					<thead>
						<tr class="text-center">
							<td><span style="font-weight: bold;">#</span></td>
							<td><span style="font-weight: bold;">Nome</span></td>
							<td><span style="font-weight: bold;">Usuário</span></td>
						</tr>
					</thead>
					<tbody id="tbody-colaboradores">
						<c:forEach var="colaborador" items="${colaboradoresAssociados}">
							<tr class="text-center">
								<td>${colaborador.colaborador.id}</td>
								<td>${colaborador.colaborador.nome}</td>
								<td>${colaborador.colaborador.usuario}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="row">
				<h4 class="title-screen">Tarefas do Projeto</h4>
				<table class="table table-responsive" id="tbTarefas">
					<thead>
						<tr class="text-center">
							<td><span style="font-weight: bold;">#</span></td>
							<td><span style="font-weight: bold;">Descrição Tarefa</span></td>
							<td><span style="font-weight: bold;">Responsável</span></td>
							<td><span style="font-weight: bold;">Data Início</span></td>
							<td><span style="font-weight: bold;">Previsão Término</span></td>
							<td><span style="font-weight: bold;">Status</span></td>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty tarefas}">
								<c:forEach items="${tarefas}" var="tarefa">
									<tr class="text-center">
										<td>${tarefa.id}</td>
										<td>${tarefa.descricao}</td>
										<td>${tarefa.responsavel.nome}</td>
										<td><fmt:formatDate value="${tarefa.dataInicio.time}"
												pattern="dd/MM/yyyy"></fmt:formatDate></td>
										<td><fmt:formatDate
												value="${tarefa.previsaoTermino.time}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
										<td>${tarefa.status}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6">Não há dados a serem exibidos</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<div class="row">
				<div class="form-group col-xs-offset-0">
					<a href='<c:url value="/painel/" />'
						style="float: left; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
						class="btn btn-default">Voltar</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>