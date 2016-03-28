<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
</head>
<script type="text/javascript">
	$(function() {
		var msg = "<c:out value='${msg}'/>";
		if (msg == 'OK') {
			$("#modalProjetoAdicionado").modal({
				keyboard : false,
				backdrop : 'static'
			});
		}
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
	<!-- MODAL PROJETO ADICIONADO INICIO -->
	<div class="modal fade" id="modalProjetoAdicionado" tabindex="-1"
		role="dialog" data-backdrop="static" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Projeto adicionado com sucesso!</h4>
				</div>
				<div class="modal-body">
					<p>O que deseja fazer agora?</p>
				</div>
				<div class="modal-footer">
					<a href='<c:url value="/painel/projetos/" />'
						style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
						class="btn btn-default">Ir para a lista de projetos</a> <a
						href='<c:url value="/painel/questionarios/cadastro/${idProjeto}" />'
						style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
						class="btn btn-default">Cadastrar Questionario</a>
				</div>
			</div>
		</div>
	</div>
	<!-- MODAL PROJETO ADICIONADO FIM -->
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Cadastro de
				Projeto</h4>
			<hr />
			<div class="row">
				<div class="col-md-12">
					<form action="salvarProjeto" method="POST" role="form">
						<div class="row">
							<div class="form-group col-md-4">
								<label for="nome">Nome:</label> <input type="text"
									class="form-control" id="nome" name="nome"
									placeholder="Digite o nome" required autofocus>
							</div>
							<div class="form-group col-md-2">
								<label for="status">Status</label> <select class="form-control"
									name="status" required>
									<option value="">Selecione ...</option>
									<option value="Aberto">Aberto</option>
									<option value="Em andamento">Em andamento</option>
									<option value="Encerrado">Encerrado</option>
									<option value="Concluido">Concluido</option>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label for="dataInicio">Data Inicio:</label> <input type="text"
									class="form-control data" id="dataInicio" name="dataInicio"
									placeholder="Selecione a Data" required>
							</div>
							<div class="form-group col-md-2">
								<label for="dataTermino">Data Termino:</label> <input
									type="text" class="form-control data" id="dataTermino"
									name="dataTermino" placeholder="Selecione a Data" required>
							</div>
							<div class="form-group col-md-2">
								<label for="unidadePrisional">Unidade Prisional:</label><select
									class="form-control" id="unidadePrisional"
									name="unidadePrisional.id" required>
									<option value="" label="Selecione..." />
									<c:forEach var="unidade" items="${unidadesPrisionais}">
										<option value="${unidade.id}" label="${unidade.nome}">
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-12">
								<div class="row">
									<div class="col-md-2">
										<label>Dias de Evento:</label>
									</div>
									<div class="col-md-1">
										<label>Seg:</label> <input name="diaEvento" type="checkbox">
									</div>
									<div class="col-md-1">
										<label>Ter:</label> <input name="diaEvento" type="checkbox">
									</div>
									<div class="col-md-1">
										<label>Qua:</label> <input name="diaEvento" type="checkbox">
									</div>
									<div class="col-md-1">
										<label>Qui:</label> <input name="diaEvento" type="checkbox">
									</div>
									<div class="col-md-1">
										<label>Sex:</label> <input name="diaEvento" type="checkbox">
									</div>
									<div class="col-md-1">
										<label>Sáb:</label> <input name="diaEvento" type="checkbox">
									</div>
									<div class="col-md-1">
										<label>Dom:</label> <input name="diaEvento" type="checkbox">
									</div>
								</div>
							</div>
							<div class="form-group col-md-12">
								<label for="descricao">Descrição:</label>
								<textarea class="form-control" id="descricao"
									placeholder="Digite uma Descrição" cols="10" rows="5"
									name="descricao" required></textarea>
							</div>
							<div class="form-group col-md-6">
								<label for="objetivo">Objetivo do Projeto:</label>
								<textarea class="form-control" id="objetivo" name="objetivo"
									rows="4" cols="5" required></textarea>
							</div>
							<div class="form-group col-md-6">
								<label for="resultados">Resultados Esperados:</label>
								<textarea class="form-control" id="resultados"
									name="resultadosEsperados" rows="4" cols="5" required></textarea>
							</div>
						</div>
						<hr />
						<div class="form-group col-xs-offset-0">
							<a href='<c:url value="/painel/projetos/" />'
								style="float: left; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
								class="btn btn-default"><span
								class="glyphicon glyphicon-remove"></span> Cancelar</a>
							<button type="submit"
								style="float: right; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
								class="btn btn-default">
								<span class="glyphicon glyphicon-ok"></span> Salvar Projeto
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