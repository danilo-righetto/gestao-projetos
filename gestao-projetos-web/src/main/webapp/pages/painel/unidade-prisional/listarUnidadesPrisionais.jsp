<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<script type="text/javascript">
	$(function() {
		$("#menu-configuracoes").attr('class','active');
		$("#menu-unidades").attr('class','active');
	});
	</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Unidades
				Prisionais</h4>
			<div id="alertas"></div>
			<table class="table table-responsive">
				<thead>
					<tr>
						<td class="text-center"><span style="font-weight: bold;">#</span></td>
						<td class="text-center"><span style="font-weight: bold;">Unidade Prisional</span></td>
						<td class="text-center"><span style="font-weight: bold;">Status</span></td>
						<td class="text-center"><span style="font-weight: bold;">Ação</span></td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty unidades}">
							<c:forEach items="${unidades}" var="unidade">
								<tr>
									<td class="text-center">${unidade.id}</td>
									<td class="text-center">${unidade.nome}</td>
									<c:if test="${unidade.status == true}">
										<td class="text-center">Ativada</td>
									</c:if>
									<c:if test="${unidade.status == false}">
										<td class="text-center">Desativada</td>
									</c:if>
									<td class="text-center"><a href="editar/${unidade.id}"><span
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
			<a href="cadastrar" class="btn btn-default btn-add">Adicionar
				Unidade Prisional</a>
		</div>
	</div>
	<div class="section" style="margin-top: 20px"></div>
</body>
</html>