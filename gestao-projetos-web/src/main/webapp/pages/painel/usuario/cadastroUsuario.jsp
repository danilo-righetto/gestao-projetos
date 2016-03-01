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
	function validarUsuario(){
		var usuario = $("#usuario").val();
		$.post("/gestao-projetos/painel/usuarios/consultarUsuario?login="+usuario, function(existe) {
			if(existe){
				$("#alertadocdiv").remove();
				var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
						+ "<span style='color: #000000'><strong>Alerta!</strong>"
						+ "O e-mail informado já está sendo utilizado.</span></div>";
				$("#alertas").append(alerta);
				$("#usuario").val("").focus();
			}else{
				$("#alertadocdiv").remove();
			}
		});
	}
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Cadastro de
					Usuario</h4>
			<hr />
			<div id="alertas"></div>
			<form action="salvarUsuario" method="POST" role="form">
				<div class="row">
					<div class="form-group col-md-offset-2 col-md-4">
						<label for="nome">Nome Completo:</label> <input type="text"
							class="form-control" id="nome" name="nome"
							placeholder="Digite o nome" required autofocus>
					</div>
					<div class="form-group col-md-4">
						<label>Usuario:</label> <input onblur="validarUsuario();" type="email"
							class="form-control" id="usuario"
							placeholder="Digite o nome do usuario" name="usuario" required>
					</div>
					<div class="form-group col-md-offset-2 col-md-4">
						<label>Senha:</label> <input type="password"
							class="form-control" id="senha" placeholder="Digite a senha"
							name="senha" required>
					</div>
					<div class="form-group col-md-4">
						<label for="perfil">Perfil:</label> <select id="perfil"
							class="form-control" name="perfil.id" required>
							<option value="">Selecione ...</option>
							<c:forEach items="${listaperfil}" var="perfil">
								<option value="${perfil.id}">${perfil.descricao}</option>
							</c:forEach>
						</select>
					</div>
					<div style="clear: both;"
						class="form-group col-md-offset-2 col-md-4">
						<div class="radio">
							<label>Realiza login no sistema?</label> <label><input
								type="radio" name="realizaLogin" value="true" required>Sim</label>
							<label><input type="radio" name="realizaLogin"
								value="false" required>Não</label>
						</div>
					</div>
				</div>
				<hr />
				<div class="form-group col-xs-offset-0">
					<a href='<c:url value="/painel/usuarios/" />' style="float:left;background-color:#4DC1FF;color:#fff;border-color:#4DC1FF" class="btn btn-default">Cancelar</a>
					<button type="submit" style="float:right;background-color:#4DC1FF;color:#fff;border-color:#4DC1FF" class="btn btn-default">Salvar Usuário</button>
				</div>
			</form>
		</div>
	</div>
	<div class="section" style="margin-top:20px">
    </div>
</body>
</html>