<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Participação Projeto</title>
<script type="text/javascript">
	$(document).ready(function() {
		var idCoodernador = "<c:out value='${coordernadorProjeto}'/>";
		if (idCoodernador == null || idCoodernador == '') {
			$("#coordenadores").hide();
		}

		$("input[name=idReeducandos]").on("click", function() {
			var idReeducando = this.id;
			var idFuncao = this.id.replace("idReeducandos", "funcao");
			if ($("#" + idReeducando + ":checked").length > 0) {
				$("#" + idFuncao).removeAttr("disabled");
				$("#" + idFuncao).attr("required", "required");
			} else {
				$("#" + idFuncao).removeAttr("required");
				$("#" + idFuncao).attr("disabled", "disabled");
			}
		});

	});
</script>
<script type="text/javascript">
	function listarCoordenadores() {
		var idParceiro = $("#parceiro").val();
		if (idParceiro != "") {
			$("#coordenadores").show();
			$
					.post(
							"/gestao-projetos/painel/participacao-projetos/listarCoordenadores/"
									+ idParceiro + "/ROLE_COORDENADOR",
							function(listaCoordenadores) {
								$("#coordenador option").remove();
								var coordenador = "<option value='' label='Selecione...' />";
								$(listaCoordenadores)
										.each(
												function(i) {
													coordenador += "<option value='"+ listaCoordenadores[i].id +"' label='"+ listaCoordenadores[i].nome +"' />";
												});
								$("#coordenador").append(coordenador);
							})
		}
		;
	};
</script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<form
		action='<c:url value="/painel/participacao-projetos/salvarParticipacaoProjeto"></c:url>'
		method="POST">
		<!-- Formulario de Cadastro - INICIO -->
		<div class="section">
			<div class="container">
				<h3 class="title-screen">Cadastro de Participação Projeto</h3>
				<hr />
				<div class="col-md-12">
					<div class="col-md-offset-3">
						<div>
							<input id="idProjeto" name="idProjeto" value="${idProjeto}"
								type="hidden" />
						</div>
						<div class="form-group col-md-4">
							<label for="parceiro">Parceiro:</label> <select
								id="parceiro" name="parceiro" class="form-control"
								required autofocus onchange="listarCoordenadores();">
								<option value="" label="Selecione..." />
								<c:forEach var="associada" items="${parceirosAssociadas}">
									<option
										${coordernadorProjeto.parceiro.id == associada.parceiro.id ? "selected='selected'" : ""}
										value="${associada.parceiro.id}"
										label="${associada.parceiro.razaosocial}" />

								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-4" id="coordenadores">
							<label for="coordenador">Coordenador:</label> <select
								id="coordenador" name="idCoordenador" class="form-control"
								required>
								<c:if test="${coordernadorProjeto ne null}">
									<option value="${coordernadorProjeto.id}"
										label="${coordernadorProjeto.nome}" />
								</c:if>
							</select>
						</div>
					</div>
				</div>
				<!-- Formulario de Cadastro - FIM -->
				<br />
				<h4 class="title-screen" id="titleReeducandos">Reeducandos</h4>
				<table class="table table-responsive" id="reeducandos">
					<thead>
						<tr class="text-center">
							<td></td>
							<td><span style="font-weight: bold;">#</span></td>
							<td><span style="font-weight: bold;">Matrícula</span></td>
							<td><span style="font-weight: bold;">Nome</span></td>
							<td><span style="font-weight: bold;">Sexo</span></td>
							<td><span style="font-weight: bold;">Função</span></td>
						</tr>
					</thead>
					<tbody id="tbody-reeducandos">
						<c:forEach var="reeducando" items="${reeducandos}">
							<tr class="text-center">
								<c:set var="encontrou" value="false"></c:set>
								<c:set var="jaMarcado" value="false"></c:set>
								<c:set var="funcao" value=""></c:set>
								<c:forEach items="${reeducandosAssociados}" var="participacao">
									<c:if test="${reeducando.id == participacao.reeducando.id}">
										<c:set var="encontrou" value="true"></c:set>
										<c:set var="funcao" value="${participacao.funcao}"></c:set>
									</c:if>
								</c:forEach>
								<c:choose>
									<c:when test="${encontrou}">
										<c:forEach items="${reeducandosAssociados}" var="participacao">
											<c:if
												test="${reeducando.id == participacao.reeducando.id && !jaMarcado}">
												<td class="text-center"><input value="${reeducando.id}"
													id="idReeducandos${reeducando.id}" name="idReeducandos"
													type="checkbox" checked="checked" disabled /></td>
												<c:set var="jaMarcado" value="true"></c:set>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td class="text-center"><input value="${reeducando.id}"
											id="idReeducandos${reeducando.id}" name="idReeducandos"
											type="checkbox" /></td>
									</c:otherwise>
								</c:choose>
								<td>${reeducando.id}</td>
								<td>${reeducando.matricula}</td>
								<td>${reeducando.nome}</td>
								<td>${reeducando.sexo}</td>
								<td class="col-md-3"><select class='form-control'
									id="funcao${reeducando.id}" name='funcoes' disabled>
										<option value='' label='Selecione...' />
										<option
											${funcao  ne null && funcao eq 'Reeducando Participante' ? "selected":""}
											value='Reeducando Participante'
											label='REEDUCANDO PARTICIPANTE' />
										<option
											${funcao  ne null && funcao eq 'Reeducando Monitor' ? "selected":""}
											value='Reeducando Monitor' label='REEDUCANDO MONITOR'></option>
								</select></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
				<h4 class="title-screen" id="titleColaboradores">Colaboradores</h4>
				<table class="table table-responsive" id="colaboradores">
					<thead>
						<tr class="text-center">
							<td></td>
							<td><span style="font-weight: bold;">#</span></td>
							<td><span style="font-weight: bold;">Nome</span></td>
							<td><span style="font-weight: bold;">Usuário</span></td>
						</tr>
					</thead>
					<tbody id="tbody-colaboradores">
						<c:forEach var="colaborador" items="${colaboradores}">
							<tr class="text-center">
								<c:set var="encontrou" value="false"></c:set>
								<c:set var="jaMarcado" value="false"></c:set>
								<c:forEach items="${colaboradoresAssociados}" var="participacao">
									<c:if test="${colaborador.id == participacao.colaborador.id}">
										<c:set var="encontrou" value="true"></c:set>
									</c:if>
								</c:forEach>
								<c:choose>
									<c:when test="${encontrou}">
										<c:forEach items="${colaboradoresAssociados}"
											var="participacao">
											<c:if
												test="${colaborador.id == participacao.colaborador.id && !jaMarcado}">
												<td class="text-center"><input
													value="${colaborador.id}" name="idColaboradores"
													type="checkbox" checked="checked" disabled /></td>
												<c:set var="jaMarcado" value="true"></c:set>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td><input value="${colaborador.id}"
											name="idColaboradores" type="checkbox" /></td>
									</c:otherwise>
								</c:choose>
								<td>${colaborador.id}</td>
								<td>${colaborador.nome}</td>
								<td>${colaborador.usuario}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-default btn-add">Salvar</button>
						<a href='<c:url value="/painel/projetos/"></c:url>'
							class="btn btn-default btn-return">Cancelar</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>