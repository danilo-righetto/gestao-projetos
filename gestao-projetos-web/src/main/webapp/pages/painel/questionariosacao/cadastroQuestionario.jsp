<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
</head>

<script type="text/javascript">
	$(function() {
		$("#menu-questionarios").attr('class', 'active');
		$("#tbPerguntas").dataTable({
			"iDisplayLength" : 5,
			"bPaginate" : true,
			"bLengthChange" : false,
			"bFilter" : false,
			"bInfo" : false,
			"bAutoWidth" : true,
			"language" : {
				"emptyTable" : "Nenhuma informação cadastrada"
			}

		});
		$(".previous").text('Anterior');
		$(".next").text('Próximo');

		$('#form-add-pergunta').on('keyup keypress', function(e) {
			  var keyCode = e.keyCode || e.which;
			  if (keyCode === 13) { 
			    e.preventDefault();
			    return false;
			  }
			});
		
	});

	function validarTipoPergunta() {
		if ($("#tipoPergunta").val() == 1) {

			$("#inputQtdAlternativasMultipla").val("");
			$("#inputQtdAlternativasMultipla").removeAttr('required');
			validarQtdAlternativasMultipla();

			$("#divRespostaUnica").removeAttr('style');
			$("#divRespostaUnica").attr('style', 'display:block');
			$("#inputRespostaUnica").attr('required', 'required');

			$("#divRespostaMultipla").removeAttr('style');
			$("#divRespostaMultipla").attr('style', 'display:none');

		} else if ($("#tipoPergunta").val() == 2) {

			$("#inputRespostaUnica").val("");

			$("#divRespostaMultipla").removeAttr('style');
			$("#divRespostaMultipla").attr('style', 'display:block');
			$("#inputQtdAlternativasMultipla").attr('required', 'required');

			$("#divRespostaUnica").removeAttr('style');
			$("#divRespostaUnica").attr('style', 'display:none');
			$("#inputRespostaUnica").removeAttr('required');

		} else if ($("#tipoPergunta").val() == 3) {
			$("#inputRespostaUnica").val("");

			$("#inputQtdAlternativasMultipla").val("");
			validarQtdAlternativasMultipla();

			$("#divRespostaUnica").removeAttr('style');
			$("#divRespostaUnica").attr('style', 'display:none');
			$("#inputRespostaUnica").removeAttr('required');
			$("#divRespostaMultipla").removeAttr('style');
			$("#divRespostaMultipla").attr('style', 'display:none');
			$("#inputQtdAlternativasMultipla").removeAttr('required');
		} else {
			$("#inputRespostaUnica").val("");

			$("#inputQtdAlternativasMultipla").val("");
			validarQtdAlternativasMultipla();

			escondeTodasAsDivsDeResposta();
		}

	}
	function escondeTodasAsDivsDeResposta() {
		$("#divRespostaUnica").removeAttr('style');
		$("#divRespostaUnica").attr('style', 'display:none');
		$("#inputRespostaUnica").removeAttr('required');
		$("#divRespostaMultipla").removeAttr('style');
		$("#divRespostaMultipla").attr('style', 'display:none');
		$("#inputQtdAlternativasMultipla").removeAttr('required');
	}

	function validarQtdAlternativasMultipla() {
		if ($("#inputQtdAlternativasMultipla").val() != ""
				&& $("#inputQtdAlternativasMultipla").val() > 1
				&& $("#inputQtdAlternativasMultipla").val() <= 5) {
			var qtd = $("#inputQtdAlternativasMultipla").val();
			$("#divAlternativasRespostaMultipla label").remove();
			$("#divAlternativasRespostaMultipla input").remove();
			for ( var i = 1; i <= qtd; i++) {
				$("#divAlternativasRespostaMultipla")
						.append(
								"<label>Alternativa:</label><input type='text' class='form-control' name='alternativaRespostaMultipla' "+
								"placeholder='Digite a alternativa' required autofocus>");
			}

			$("#divAlternativasRespostaMultipla").removeAttr('style');
			$("#divAlternativasRespostaMultipla")
					.attr('style', 'display:block');
		} else {
			$("#divAlternativasRespostaMultipla label").remove();
			$("#divAlternativasRespostaMultipla input").remove();
			$("#divAlternativasRespostaMultipla").removeAttr('style');
			$("#divAlternativasRespostaMultipla").attr('style', 'display:none');
		}
	}
</script>

<body>
	<!-- MODAL ADICIONAR PERGUNTA INICIO -->
	<div class="modal fade" id="modalPergunta" tabindex="-1" role="dialog"
		data-backdrop="static" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
		<form id="form-add-pergunta" method="POST" action='<c:url value="/painel/questionariosacao/adicionarPerguntaAcao" />'>
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">Adicionar Pergunta</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" name="questionarioAcao.id" value="${questionario.id}"/>
						<input type="hidden" name="questionarioAcao.acao.id" value="${questionario.acao.id}"/>
						<div class="row">
							<div class="form-group col-md-8">
								<label for="nome">Pergunta:</label> <input type="text"
									class="form-control" id="descricaoPerguntaAcao"
									name="descricaoPerguntaAcao" placeholder="Digite a Pergunta"
									required autofocus>
							</div>
							<div class="form-group col-md-4">
								<label for="tipopessoa">Tipo de Pergunta:</label> <select
									class="form-control" name="tipoPergunta.id" id=tipoPergunta
									onchange="validarTipoPergunta();" required>
									<option value="">Selecione ...</option>
									<c:forEach items="${tiposPerguntas}" var="tipoPergunta">
										<option value="${tipoPergunta.id}">${tipoPergunta.descricao}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12" id="divRespostaUnica"
								style="display: none">
								<label for="nome">Resposta:</label> <input type="text"
									class="form-control" id="inputRespostaUnica"
									name="inputRespostaUnica"
									placeholder="Informe a resposta correta">
							</div>
							<div class="form-group col-md-12" id="divRespostaMultipla"
								style="display: none">
								<div class="row col-md-4">
									<label for="nome">Número de Alternativas:</label> <input
										type="text" class="form-control"
										id="inputQtdAlternativasMultipla"
										name="inputQtdAlternativasMultipla"
										onblur="validarQtdAlternativasMultipla()"
										placeholder="Quantidade de alternativas">
								</div>
								<div class="row col-md-12" id="divAlternativasRespostaMultipla"
									style="display: none">
									<br />
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button"
							style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
							class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<input type="submit" style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
							class="btn btn-default" value="Adicionar">
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- MODAL ADICIONAR PERGUNTA FIM -->
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Cadastro de
				Questionário</h4>
			<hr />
			<c:if test="${mensagem != null && mensagem ne ''}">
				<c:if test="${mensagem eq 'ADD'}">
					<div class="alert alert-success">
					 	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<span style="color: #000000"><strong>Sucesso!</strong> Pergunta adicionada com sucesso.</span>
					</div>
				</c:if>
				<c:if test="${mensagem eq 'REMOVE'}">
					<div class="alert alert-success">
					 	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<span style="color: #000000"><strong>Sucesso!</strong> Pergunta removida com sucesso.</span>
					</div>
				</c:if>
				<c:if test="${mensagem eq 'ERRO_EXISTENTE'}">
					<div class="alert alert-warning">
						 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<span style="color: #000000"><strong>Alerta!</strong>Esta pergunta já foi adicionada ao questionário.</span>
					</div>
				</c:if>
				<c:if test="${mensagem eq 'ERRO'}">
					<div class="alert alert-danger">
						 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<span style="color: #000000"><strong>Erro!</strong>Não foi possível executar a ação, tente novamente mais tarde!</span>
					</div>
				</c:if>
			</c:if>
			<div class="row">
				<div class="col-md-12">
					<form action='<c:url value="/painel/questionariosacao/salvarQuestionario" />' method="POST" role="form">
						<div class="row">
							<div class="form-group col-md-offset-3 col-md-6">
								<label for="nome">Titulo do Questionário:</label> <input
									type="text" class="form-control" id="nome" name="nome"
									readonly="readonly" value="${questionario.descricao}"
									placeholder="Digite o nome" required autofocus>
							</div>
						</div>
						<h4 style="font-family: arial; color: #4DC1FF">Perguntas</h4>
						<div class="row">

							<table class="table table-responsive" id="tbPerguntas">
								<thead>
									<tr>
										<td class="text-center"><span style="font-weight: bold;">Tipo
												de Pergunta</span></td>
										<td class="text-center"><span style="font-weight: bold;">Pergunta</span></td>
										<td class="text-center"><span style="font-weight: bold;">Data
												de Cadastro</span></td>
										<td class="text-center"><span style="font-weight: bold;">Ação</span></td>
									</tr>
								</thead>
								<tbody id="tbBodyPerguntas">
									<c:forEach items="${questionario.perguntas}" var="pergunta">
										<tr>
										<c:choose>
											<c:when test="${pergunta.tipoPergunta.descricao ne null or not empty pergunta.tipoPergunta.descricao}">
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
										<td class="text-center">${pergunta.descricaoPerguntaAcao}</td>
										<td class="text-center"><fmt:formatDate value="${pergunta.dataCadastro.time}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
										<td class="text-center">
											<a href='<c:url value="/painel/questionariosacao/removerPergunta?idPergunta=${pergunta.id}&&descricaoPerguntaAcao=${pergunta.descricaoPerguntaAcao}" />'>
												<span class="glyphicon glyphicon-remove-circle"></span>
											</a>
										</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<br />
							<button type="button"
								style="float: right; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
								class="btn btn-default" data-toggle="modal"
								data-target="#modalPergunta">
								<span class="glyphicon glyphicon-plus"></span> Adicionar
								Pergunta
							</button>
						</div>
						<hr />
						<div class="form-group col-xs-offset-0">
							<a href='<c:url value="/painel/acoes/" />'
								style="float: left; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
								class="btn btn-default"><span
								class="glyphicon glyphicon-remove" style="margin-top: 1px"></span>
								Cancelar</a>
							<button type="submit"
								style="float: right; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
								class="btn btn-default"><span class="glyphicon glyphicon-ok"
									style="margin-top: 1px"> </span>
								Salvar Questionário 
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="section" style="margin-top: -2px"></div>
</body>
</html>