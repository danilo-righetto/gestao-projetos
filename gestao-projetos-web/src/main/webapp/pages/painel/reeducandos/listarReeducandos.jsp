<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		$("#menu-reeducandos").attr('class', 'active');
		$("#tbReeducandos").dataTable({
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
			<h4 class="title-screen">Reeducandos</h4>
			<div id="alertas"></div>
			<table class="table table-responsive" id="tbReeducandos">
				<thead>
					<tr>
						<td class="text-center"><span style="font-weight: bold;">#</span></td>
						<td class="text-center "><span style="font-weight: bold;">Matrícula</span></td>
						<td class="text-center "><span style="font-weight: bold;">Nome</span></td>
						<td class="text-center "><span style="font-weight: bold;">Sexo</span></td>
						<td class="text-center "><span style="font-weight: bold;">Data
								de Nascimento</span></td>
						<td class="text-center"><span style="font-weight: bold;">Unidade
								Prisional</span></td>
						<td class="text-center"><span style="font-weight: bold;">Ação</span></td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty reeducandos}">
							<c:forEach items="${reeducandos}" var="reeducando">
								<tr>
									<td class="text-center">${reeducando.id}</td>
									<td class="text-center">${reeducando.matricula}</td>
									<td class="text-center">${reeducando.nome}</td>
									<td class="text-center">${reeducando.sexo}</td>
									<td class="text-center"><fmt:formatDate
											value="${reeducando.dataNascimento.time}" /></td>
									<td class="text-center">${reeducando.unidadePrisional.nome}</td>
									<td class="text-center"><a href="editar/${reeducando.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
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
			<a href='<c:url value="cadastro"></c:url>'
				style="float: right; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
				class="btn btn-default">Novo Reeducando</a>
		</div>
	</div>
	<div class="section" style="margin-top: 130px"></div>
</body>
</html>