<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		$("#menu-projetos").attr('class', 'active');
		$("#tbProjetos").dataTable({
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
	});
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Projetos</h4>
			<div id="alertas"></div>
			<table class="table table-responsive" id="tbProjetos">
				<thead>
					<tr>
						<td class="text-center"><span style="font-weight: bold;">#</span></td>
						<td class="text-center"><span style="font-weight: bold;">Nome
								do Projeto</span></td>
						<td class="text-center"><span style="font-weight: bold;">Data
								Inicio</span></td>
						<td class="text-center"><span style="font-weight: bold;">Status</span></td>
						<td class="text-center"><span style="font-weight: bold;">Ação</span></td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty projetos}">
							<c:forEach items="${projetos}" var="projeto">
								<tr>
									<td class="text-center">${projeto.id}</td>
									<td class="text-center">${projeto.nome}</td>
									<td class="text-center"><fmt:formatDate
											value="${projeto.dataInicio.time}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
									<td class="text-center">${projeto.status}</td>
									<td class="text-center"><a href="editar/${projeto.id}"
										title="Editar"> <span class="glyphicon glyphicon-pencil">
										</span>
									</a> <a style="margin-left: 20px"
										href='<c:url value="/painel/questionarios/cadastro/${projeto.id}" />'
										title="Questionário"> <span
											class="glyphicon glyphicon-list-alt"></span>
									</a> <a style="margin-left: 20px"
										href='<c:url value="/painel/participacao-projetos/${projeto.id}/instituicoes" />'
										title="Instituições"> <span
											class="glyphicon glyphicon-th-list"></span>
									</a> <a style="margin-left: 20px"
										href='<c:url value="/painel/participacao-projetos/${projeto.id}/instituicoes/cadastroParticipacaoProjeto" />'
										title="Reeducandos e Colaboradores"> <span
											class="glyphicon glyphicon-user"></span></a> <a
										style="margin-left: 20px"
										href='<c:url value="/painel/projetos/${projeto.id}/exibirInformacoes"></c:url>'
										title="Informações"><span
											class="glyphicon glyphicon-info-sign"></span></a><a
										style="margin-left: 20px"
										href='<c:url value="/painel/projetos/${projeto.id}/tarefas"></c:url>'
										title="Tarefas"><span class="glyphicon glyphicon-pushpin"></span></a></td>


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
			<br /> <a href='<c:url value="cadastro"></c:url>'
				style="float: right; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
				class="btn btn-default">Novo Projeto</a>
		</div>
	</div>
	<div class="section" style="margin-top: 20px"></div>
</body>
</html>