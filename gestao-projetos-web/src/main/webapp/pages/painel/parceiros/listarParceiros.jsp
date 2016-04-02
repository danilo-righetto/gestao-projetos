<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		$("#menu-parceiros").attr('class', 'active');
		$("#tbParceiros").dataTable({
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
			<h4 class="title-screen">Parceiros</h4>
			<div id="alertas"></div>
			<table id="tbParceiros" class="table table-responsive">
				<thead>
					<tr>
						<td class="text-center"><span style="font-weight: bold;">#</span></td>
						<td class="text-center hidden-xs hidden-sm"><span
							style="font-weight: bold;">Tipo de Pessoa</span></td>
						<td class="text-center"><span style="font-weight: bold;">Cidade</span></td>
						<td class="text-center hidden-xs hidden-sm"><span
							style="font-weight: bold;">E-mail</span></td>
						<td class="text-center hidden-xs hidden-sm"><span
							style="font-weight: bold;">Responsável</span></td>
						<td class="text-center"><span style="font-weight: bold;">Ação</span></td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty parceiros}">
							<c:forEach items="${parceiros}" var="parceiro">
								<tr class="text-center">
									<td>${parceiro.id}</td>
									<td class="hidden-xs hidden-sm">${(parceiro.tipoDocumento == "CNPJ" ?
									 'Pessoa Juridica' : 'Pessoa Fisica')}</td>
									<td>${parceiro.cidade}</td>
									<td class="hidden-xs hidden-sm">${parceiro.email}</td>
									<td class="hidden-xs hidden-sm">${parceiro.responsavel}</td>
									<td><a href="editar/${parceiro.id}"><span
											class="glyphicon glyphicon-pencil"></span></a> <a
										href="${parceiro.id}/colaboradores"><span
											class="glyphicon glyphicon-user"></span></a></td>
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
				class="btn btn-default btn-add">Novo Parceiro</a>
		</div>
	</div>
</body>
</html>