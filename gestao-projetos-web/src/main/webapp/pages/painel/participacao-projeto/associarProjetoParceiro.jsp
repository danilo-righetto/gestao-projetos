<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		var msg = "<c:out value='${msg}'/>";
		if (msg == 'OK') {
			$("#modalAssociacaoAdicionado").modal({
				keyboard : false,
				backdrop : 'static'
			});
		}
		$("#menu-parceiros").attr('class', 'active');
	});
</script>
</head>
<body>
<!-- MODAL ASSOCIACAO PARCEIRO INICIO -->
	<div class="modal fade" id="modalAssociacaoAdicionado" tabindex="-1"
		role="dialog" data-backdrop="static" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Associação adicionada com sucesso!</h4>
				</div>
				<div class="modal-body">
					<p>O que deseja fazer agora?</p>
				</div>
				<div class="modal-footer">
					<a href='<c:url value="/painel/projetos/" />'
						style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
						class="btn btn-default">Ir para a lista de projetos</a> <a
						href='<c:url value="/painel/participacao-projetos/${idProjeto}/parceiros/cadastroParticipacaoProjeto" />'
						style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
						class="btn btn-default">Informar Participantes</a>
				</div>
			</div>
		</div>
	</div>
	<!-- MODAL ASSOCIACAO PARCEIRO ADICIONADO FIM -->
	<form
		action='<c:url value="/painel/participacao-projetos/${idProjeto}/parceiros/salvarParticipacaoParceiroProjeto"></c:url>'
		method="POST">
		<div class="section">
			<div class="container">
				<h4 class="title-screen">Associar Parceiros ao Projeto</h4>
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
								style="font-weight: bold;">Razão Social</span></td>
							<td class="hidden-xs hidden-sm"><span
								style="font-weight: bold;">Responsável</span></td>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty parceiros}">
								<c:forEach items="${parceiros}" var="parceiro">
									<tr>
										<c:set var="encontrou" value="false"></c:set>
										<c:set var="jaMarcado" value="false"></c:set>
										<c:forEach items="${participacoes}" var="participacao">
											<c:if test="${parceiro.id == participacao.parceiro.id}">
												<c:set var="encontrou" value="true"></c:set>
											</c:if>
										</c:forEach>
										<c:choose>
											<c:when test="${encontrou}">
												<c:forEach items="${participacoes}" var="participacao">
													<c:if
														test="${parceiro.id == participacao.parceiro.id && !jaMarcado}">
														<td class="text-center"><input
															value="${parceiro.id}" name="idParceiros"
															type="checkbox" checked="checked" disabled /></td>
														<c:set var="jaMarcado" value="true"></c:set>
													</c:if>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<td class="text-center"><input
													value="${parceiro.id}" name="idParceiros"
													type="checkbox" /></td>
											</c:otherwise>
										</c:choose>
										<td class="text-center">${parceiro.id}</td>
										<td class="text-center hidden-xs hidden-sm">${(parceiro.tipoDocumento
											== "CNPJ" ? 'Pessoa Juridica' : 'Pessoa Fisica')}</td>
										<td class="text-center">${parceiro.cidade}</td>
										<td class="text-center hidden-xs hidden-sm">${parceiro.razaosocial}</td>
										<td class="text-center hidden-xs hidden-sm">${parceiro.responsavel}</td>
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
				<a class="btn btn-default btn-return"
					href='<c:url value="/painel/projetos/" />'>Cancelar</a>
				<button class="btn btn-default btn-add">Salvar Associação</button>
			</div>
		</div>
	</form>
</body>
</html>