<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<script type="text/javascript">
	$(function() {
		$("#menu-usuarios").attr('class','active');
	});
	</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Usuarios</h4>
			<div id="alertas"></div>
			<table class="table table-responsive">
				<thead>
					<tr>
						<td class="text-center"><span style="font-weight: bold;">#</span></td>
						<td class="text-center hidden-xs hidden-sm"><span style="font-weight: bold;">Nome</span></td>
						<td class="text-center"><span style="font-weight: bold;">Usu�rio</span></td>
						<td class="text-center hidden-xs hidden-sm"><span style="font-weight: bold;">Realiza
								Login</span></td>
						<td class="text-center hidden-xs hidden-sm"><span style="font-weight: bold;">Perfil</span></td>
						<td class="text-center"><span style="font-weight: bold;">A��o</span></td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty usuarios}">
							<c:forEach items="${usuarios}" var="usuario">
								<tr>
									<td class="text-center">${usuario.id}</td>
									<td class="text-center hidden-xs hidden-sm">${usuario.nome}</td>
									<td class="text-center">${usuario.usuario}</td>
									<td class="text-center hidden-xs hidden-sm">${(usuario.realizaLogin == true ?
										'Sim' : 'N�o')}</td>
									<td class="text-center hidden-xs hidden-sm">${usuario.perfil.descricao}</td>
									<td class="text-center"><a href="editar/${usuario.id}"><span
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
			<a href='<c:url value="cadastro"></c:url>' style="float:right;background-color:#4DC1FF;color:#fff;border-color:#4DC1FF" class="btn btn-default">Novo Usu�rio</a>
		</div>
	</div>
	<div class="section" style="margin-top: 20px"></div>
</body>
</html>