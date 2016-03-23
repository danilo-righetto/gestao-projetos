<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		// 		$("#menu-projetos").attr('class', 'active');
		$("#tbTarefas").dataTable({
			"iDisplayLength" : 5,
			"bPaginate" : true,
			"bLengthChange" : false,
			"bFilter" : true,
			"bInfo" : false,
			"bAutoWidth" : true,
			"language" : {
				"emptyTable" : "Nenhuma informação cadastrada"
			}

		});
		$(".previous").text('Anterior');
		$(".next").text('Próximo');
	});
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Tarefas</h4>
			<div id="alertas"></div>
			<table class="table table-responsive" id="tbTarefas">
				<thead>
					<tr class="text-center">
						<td><span style="font-weight: bold;">#</span></td>
						<td><span style="font-weight: bold;">Descrição Tarefa</span></td>
						<td><span style="font-weight: bold;">Responsável</span></td>
						<td><span style="font-weight: bold;">Data Início</span></td>
						<td><span style="font-weight: bold;">Previsão Término</span></td>
						<td><span style="font-weight: bold;">Status</span></td>
						<td><span style="font-weight: bold;">Ação</span></td>
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
									<td><fmt:formatDate value="${tarefa.previsaoTermino.time}"
											pattern="dd/MM/yyyy"></fmt:formatDate></td>
									<td>${tarefa.status}</td>
									<td><a
										href='<c:url value="/painel/projetos/${tarefa.projeto.id}/tarefas/${tarefa.id}/editar"></c:url>'
										title="Editar"> <span class="glyphicon glyphicon-pencil">
										</span></a>
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
			<br /> <a
				href='<c:url value="/painel/projetos/${idProjeto}/tarefas/cadastro"></c:url>'
				style="float: right; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
				class="btn btn-default">Nova Tarefa</a>
		</div>
	</div>
	<div class="section" style="margin-top: 20px"></div>
</body>
</html>