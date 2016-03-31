<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		$("#menu-acoes").attr('class', 'active');
		$("#tbAcoes").dataTable({
			"iDisplayLength" : 5,
			"bPaginate" : true,
			"bLengthChange" : false,
			"bFilter" : true,
			"bInfo" : false,
			"bAutoWidth" : true,
			"language" : {
				"emptyTable" : "Nenhuma informação cadastrada",
				"search" : "Pesquisar:",
				"paginate" : {
					"first" : "Primeira",
					"last" : "Última",
					"next" : "Próximo",
					"previous" : "Anterior"
				}
			}
		});
	})
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Ações</h4>
			<div id="alertas"></div>
			<table id="tbAcoes" class="table table-responsive">
				<thead>
					<tr>
						<td class="text-center"><span style="font-weight: bold;">#</span></td>
						<td class="text-center"><span style="font-weight: bold;">Nome
								da Ação</span></td>
						<td class="text-center"><span style="font-weight: bold;">Data
								Inicio</span></td>
						<td class="text-center"><span style="font-weight: bold;">Status</span></td>
						<td class="text-center"><span style="font-weight: bold;">Ação</span></td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty acoes}">
							<c:forEach items="${acoes}" var="acao">
								<tr>
									<td class="text-center">${acao.id}</td>
									<td class="text-center">${acao.nome}</td>
									<td class="text-center"><fmt:formatDate
											value="${acao.dataInicio.time}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
									<td class="text-center">${acao.status}</td>
									<td class="text-center"><a
										href='<c:url value="/painel/acoes/editar/${acao.id}"></c:url>'><span
											class="glyphicon glyphicon-pencil"></span></a> <a
										style="margin-left: 20px"
										href='<c:url value="/painel/questionariosacao/cadastro/${acao.id}" />'>
											<span class="glyphicon glyphicon-list-alt"></span>
									</a>
									<a
										style="margin-left: 20px"
										href='<c:url value="/painel/respostasacao/I/${acao.id}"></c:url>'
										title="Resposta Inicio"><span class="glyphicon glyphicon-copy"></span></a>
										<a
										style="margin-left: 20px"
										href='<c:url value="/painel/respostasacao/F/${acao.id}"></c:url>'
										title="Resposta Fim"><span class="
glyphicon glyphicon-paste"></span></a>
									</td>
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
			<a href='<c:url value="/painel/acoes/cadastro"></c:url>'
				class="btn btn-default btn-add">Nova Ação</a>
		</div>
	</div>
	<div class="section" style="margin-top: 20px"></div>
</body>
</html>