<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<script type="text/javascript">
	$(function() {
		$("#menu-projetos").attr('class','active');
	});
	</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Projetos</h4>
			<div id="alertas"></div>
			<table class="table table-responsive">
				<thead>
					<tr>
						<td class="text-center"><span style="font-weight: bold;">#</span></td>
						<td class="text-center"><span style="font-weight: bold;">Nome do Projeto</span></td>
						<td class="text-center"><span style="font-weight: bold;">Data Inicio</span></td>
						<td class="text-center"><span style="font-weight: bold;">Status</span></td>
						<td class="text-center"><span style="font-weight: bold;">A��o</span></td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty projetos}">
							<c:forEach items="${projetos}" var="projeto">
								<tr>
									<td class="text-center">${projeto.id}</td>
									<td class="text-center">${projeto.nome}</td>
									<td class="text-center"><fmt:formatDate value="${projeto.dataInicio.time}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
									<td class="text-center">${projeto.status}</td>
									<td class="text-center"><a href="editar/${projeto.id}"><span
										class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6">N�o h� dados a serem exibidos</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<a href='<c:url value="cadastro"></c:url>' style="float:right;background-color:#4DC1FF;color:#fff;border-color:#4DC1FF" class="btn btn-default">Novo Projeto</a>
		</div>
	</div>
	<div class="section" style="margin-top: 20px"></div>
</body>
</html>