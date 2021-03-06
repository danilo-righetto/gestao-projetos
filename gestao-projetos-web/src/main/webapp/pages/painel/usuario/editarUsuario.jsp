<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

<script type="text/javascript">
	$(function() {
		$("#menu-usuarios").attr('class', 'active');
		verificaPerfil();
	});

	function verificaPerfil() {
		var escolha = document.getElementById("perfil").value;
		if (escolha == "ROLE_COORDENADOR" || escolha == "ROLE_COLABORADOR") {
			document.getElementById("oculta1").style.display = "block";
			$("#parceiro").attr("required", "required");
			$("#parceiro").removeAttr("disabled");
		} else {
			document.getElementById("oculta1").style.display = "none";
			$("#parceiro").val("");
			$("#parceiro").removeAttr("required");
			$("#parceiro").attr("disabled", "disabled");
		}
	}
</script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Edi��o de Usuario</h4>
			<hr />
			<div id="alertas"></div>
			<form action='<c:url value="/painel/usuarios/editarUsuario"></c:url>'
				method="POST" role="form">
				<input type="hidden" name="id" value="${user.id}">
				<div class="row">
					<div class="form-group col-md-4">
						<label for="nome">Nome Completo:</label> <input type="text"
							class="form-control" id="nome" name="nome" value="${user.nome}"
							placeholder="Digite o nome" required autofocus>
					</div>
					<div class="form-group col-md-3">
						<label>Usuario:</label> <input type="email"
							value="${user.usuario}" readonly="readonly" class="form-control"
							id="usuario" placeholder="Digite o nome do usuario"
							name="usuario" required>
					</div>
					<div class="form-group col-md-2">
						<label for="perfil">Perfil:</label> <select id="perfil"
							class="form-control" name="perfil.id"
							onchange="verificaPerfil();" required>
							<option value="">Selecione ...</option>
							<c:forEach items="${listaperfil}" var="perfil">
								<c:choose>
									<c:when test="${user.perfil.id == perfil.id}">
										<option selected="selected" value="${perfil.id}">${perfil.descricao}</option>
									</c:when>
									<c:otherwise>
										<option value="${perfil.id}">${perfil.descricao}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<!-- Parceiro - Usuario -->
					<div class="form-group col-md-3" id="oculta1">
						<label for="parceiro">Parceiro:</label> <select id="parceiro"
							class="form-control" name="parceiro.id" required>
							<option value="">Selecione ...</option>
							<c:forEach items="${parceiros}" var="parceiro">
								<option value="${parceiro.id}"
									${(parceiro.id == user.parceiro.id ? 
								'selected' : '')}>${parceiro.razaosocial}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-3">
						<div class="radio" style="margin-top: 30px">
							<label>Realiza login no sistema?</label>
							<c:choose>
								<c:when test="${user.realizaLogin}">
									<label> <input type="radio" name="realizaLogin"
										value="true" checked="checked" required>Sim
									</label>
									<label><input type="radio" name="realizaLogin"
										value="false" required>N�o</label>
								</c:when>
								<c:otherwise>
									<label> <input type="radio" name="realizaLogin"
										value="true" required>Sim
									</label>
									<label><input type="radio" name="realizaLogin"
										value="false" checked="checked" required>N�o</label>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<hr />
				<div class="form-group col-xs-offset-0">
					<a href='<c:url value="/painel/usuarios/" />'
						class="btn btn-default btn-return">Cancelar</a>
					<button type="submit" class="btn btn-default btn-add">Salvar
						Usu�rio</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>