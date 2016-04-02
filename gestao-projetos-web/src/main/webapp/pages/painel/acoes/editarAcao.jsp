<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script type="text/javascript">
	$("#menu-acoes").attr('class', 'active');
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Edição de Ação</h4>
			<hr />
			<div class="row">
				<div class="col-md-12">
					<form action='<c:url value="/painel/acoes/editarAcao"></c:url>'
						method="POST" role="form">
						<input type="hidden" name="id" value="${acao.id}">
						<div class="row">
							<div class="form-group col-md-4">
								<label for="nome">Nome:</label> <input type="text"
									class="form-control" id="nome" name="nome" value="${acao.nome}"
									placeholder="Digite o nome" required autofocus>
							</div>
							<div class="form-group col-md-2">
								<label for="status">Status</label> <select class="form-control"
									name="status" required>
									<c:choose>
										<c:when test="${acao.status == 'Aberto'}">
											<option selected="selected" value="Aberto">ABERTO</option>
											<option value="Em andamento">EM ANDAMENTO</option>
											<option value="Encerrado">ENCERRADO</option>
											<option value="Concluido">CONCLUIDO</option>
										</c:when>
										<c:when test="${acao.status == 'Em andamento'}">
											<option selected="selected" value="Em andamento">EM
												ANDAMENTO</option>
											<option value="Aberto">ABERTO</option>
											<option value="Encerrado">ENCERRADO</option>
											<option value="Concluido">CONCLUIDO</option>
										</c:when>
										<c:when test="${acao.status == 'Encerrado'}">
											<option selected="selected" value="Encerrado">ENCERRADO</option>
											<option value="Aberto">ABERTO</option>
											<option value="Em andamento">EM ANDAMENTO</option>
											<option value="Concluido">CONCLUIDO</option>
										</c:when>
										<c:when test="${acao.status == 'Concluido'}">
											<option selected="selected" value="Concluido">CONCLUIDO</option>
											<option value="Aberto">ABERTO</option>
											<option value="Em andamento">EM ANDAMENTO</option>
											<option value="Encerrado">ENCERRADO</option>
										</c:when>
										<c:otherwise>
											<option value="Aberto">ABERTO</option>
											<option value="Em andamento">EM ANDAMENTO</option>
											<option value="Encerrado">ENCERRADO</option>
											<option value="Concluido">CONCLUIDO</option>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="dataInicio">Data Inicio:</label> <input type="text"
									class="form-control data" id="dataInicio" name="dataInicio"
									value="<fmt:formatDate value="${acao.dataInicio.time}" pattern="dd/MM/yyyy"></fmt:formatDate>"
									placeholder="Selecione a Data" required>
							</div>
							<div class="form-group col-md-3">
								<label for="dataTermino">Data Termino:</label> <input
									type="text"
									value="<fmt:formatDate value="${acao.dataTermino.time}" pattern="dd/MM/yyyy"></fmt:formatDate>"
									class="form-control data" id="dataTermino" name="dataTermino"
									placeholder="Selecione a Data">
							</div>
							<div class="form-group col-md-12">
								<label for="descricao">Descrição</label>
								<textarea class="form-control" cols="10" rows="5" id="descricao"
									placeholder="Digite uma Descrição" name="descricao" required>${acao.descricao}</textarea>
							</div>
						</div>
						<hr />
						<div class="form-group col-xs-offset-0">
							<a href='<c:url value="/painel/acoes/" />'
								class="btn btn-default btn-return">Cancelar</a>
							<button type="submit" class="btn btn-default btn-add">Salvar
								Ação</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
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
	</script>
</body>
</html>