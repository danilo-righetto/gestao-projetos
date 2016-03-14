<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		$("#menu-instituicoes").attr('class', 'active');
	});
</script>
</head>
<body>
	<form
		action='<c:url value="/painel/participacao-projetos/${idProjeto}/instituicoes/cadastroParticipacaoProjeto"></c:url>'
		method="POST">
		<div class="section">
			<div class="container">
				<h4 class="title-screen">Instituições</h4>
				<div id="alertas"></div>
				<table class="table table-responsive">
					<thead>
						<tr class="text-center">
							<td></td>
							<td><span style="font-weight: bold;">#</span></td>
							<td class="hidden-xs hidden-sm"><span
								style="font-weight: bold;">Tipo de Pessoa</span></td>
							<td><span style="font-weight: bold;">Cidade</span></td>
							<td class="hidden-xs hidden-sm"><span
								style="font-weight: bold;">E-mail</span></td>
							<td class="hidden-xs hidden-sm"><span
								style="font-weight: bold;">Responsável</span></td>
							<td><span style="font-weight: bold;">Editar</span></td>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty instituicoes}">
								<c:forEach items="${instituicoes}" var="instituicao">
									<tr>
										<td class="text-center"><input value="${instituicao.id}" name="idInstituicoes"
											type="checkbox" /></td>
										<td class="text-center">${instituicao.id}</td>
										<td class="text-center hidden-xs hidden-sm">${(instituicao.tipoDocumento == "cnpj" ?
									 'Pessoa Juridica' : 'Pessoa Fisica')}</td>
										<td class="text-center">${instituicao.cidade}</td>
										<td class="text-center hidden-xs hidden-sm">${instituicao.email}</td>
										<td class="text-center hidden-xs hidden-sm">${instituicao.responsavel}</td>
										<td class="text-center"><a
											href="editar/${instituicao.id}"><span
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
				<button class="btn btn-default btn-add">Informar
					Participantes</button>
			</div>
		</div>
		<div class="section" style="margin-top: 20px"></div>
	</form>
</body>
</html>