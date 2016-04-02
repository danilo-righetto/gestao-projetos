<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		$("#menu-parceiros").attr('class', 'active');
		$("#tbColaboradores").dataTable({
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
			<h4 class="title-screen">Colaboradores</h4>
			<table id="tbColaboradores" class="table table-responsive">
				<thead>
					<tr class="text-center">
						<td>#</td>
						<td>Nome</td>
						<td>Email</td>
						<td>Editar</td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty colaboradores}">
							<c:forEach items="${colaboradores}" var="colaborador">
								<tr class="text-center">
									<td>${colaborador.id}</td>
									<td class="hidden-xs hidden-sm">${colaborador.nome}</td>
									<td class="hidden-xs hidden-sm">${colaborador.email}</td>
									<td><a
										href='<c:url value="/painel/parceiros/${idParceiro}/colaboradores/${colaborador.id}/editar"></c:url>'><span
											class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4">Não há dados a serem exibidos</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<div>
				<a class="btn btn-default btn-return"
					href='<c:url value="/painel/parceiros/"></c:url>'><span
					class="glyphicon glyphicon-arrow-left"></span></a> <a
					class="btn btn-default btn-add"
					href='<c:url value="/painel/parceiros/${idParceiro}/colaboradores/cadastro"></c:url>'>Adicionar
					Colaborador </a>
			</div>
		</div>
	</div>
</body>
</html>