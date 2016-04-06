<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<style type="text/css">
footer div {
	position: relative !important;
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
			<h4 class="title-screen">Edição de Projeto</h4>
			<hr />
			<div class="row">
				<div class="col-md-12">
					<form
						action='<c:url value="/painel/projetos/editarProjeto"></c:url>'
						method="POST" role="form">
						<input type="hidden" name="id" value="${projeto.id}">
						<div class="row">
							<div class="form-group col-md-4">
								<label for="nome">Nome:</label> <input type="text"
									class="form-control" id="nome" name="nome"
									value="${projeto.nome}" placeholder="Digite o nome" required
									autofocus>
							</div>
							<div class="form-group col-md-2">
								<label for="status">Status</label> <select class="form-control"
									name="status" required>
									<c:choose>
										<c:when test="${projeto.status == 'Aberto'}">
											<option selected="selected" value="Aberto">Aberto</option>
											<option value="Em andamento">Em andamento</option>
											<option value="Encerrado">Encerrado</option>
											<option value="Concluido">Concluido</option>
										</c:when>
										<c:when test="${projeto.status == 'Em andamento'}">
											<option selected="selected" value="Em andamento">Em
												andamento</option>
											<option value="Aberto">Aberto</option>
											<option value="Encerrado">Encerrado</option>
											<option value="Concluido">Concluido</option>
										</c:when>
										<c:when test="${projeto.status == 'Encerrado'}">
											<option selected="selected" value="Encerrado">Encerrado</option>
											<option value="Aberto">Aberto</option>
											<option value="Em andamento">Em andamento</option>
											<option value="Concluido">Concluido</option>
										</c:when>
										<c:when test="${projeto.status == 'Concluido'}">
											<option selected="selected" value="Concluido">Concluido</option>
											<option value="Aberto">Aberto</option>
											<option value="Em andamento">Em andamento</option>
											<option value="Encerrado">Encerrado</option>
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
									placeholder="Selecione a Data" required autofocus>
							</div>
							<div class="form-group col-md-2">
								<label for="dataTermino">Data Termino:</label> <input
									type="text"
									value="<fmt:formatDate value="${projeto.dataTermino.time}" pattern="dd/MM/yyyy"></fmt:formatDate>"
									class="form-control data" id="dataTermino" name="dataTermino"
									placeholder="Selecione a Data" required autofocus>
							</div>
							<div class="form-group col-md-2">
								<label for="unidadePrisional">Unidade Prisional:</label> <input
									class="form-control" id="unidadePrisional"
									name="unidadePrisional.nome"
									value="${projeto.unidadePrisional.nome}" readonly />
							</div>
							<div class="form-group col-md-12">
								<label for="descricao">Descrição</label>
								<textarea class="form-control" cols="10" rows="5" id="descricao"
									name="descricao" required>${projeto.descricao}</textarea>
							</div>
							<div class="form-group col-md-6">
								<label for="objetivo">Objetivo do Projeto:</label>
								<textarea class="form-control" id="objetivo" name="objetivo"
									rows="4" cols="5" required>${projeto.objetivo}</textarea>
							</div>
							<div class="form-group col-md-6">
								<label for="resultados">Resultados Esperados:</label>
								<textarea class="form-control" id="resultados"
									name="resultadosEsperados" rows="4" cols="5" required>${projeto.resultadosEsperados}</textarea>
							</div>
						</div>
						<hr />
						<div class="form-group col-xs-offset-0">
							<a href='<c:url value="/painel/projetos/" />'
								class="btn btn-default btn-return">Cancelar</a>
							<button type="submit" class="btn btn-default btn-add">Salvar
								Projeto</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>