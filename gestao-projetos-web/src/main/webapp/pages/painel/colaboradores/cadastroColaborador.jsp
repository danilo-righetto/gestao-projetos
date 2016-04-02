<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		$("#btnsalvar").click(
				function() {
					if ($("#nome").val() != "" && $("#email").val() != ""
							&& $("#perfil").val() != "") {
						abrirLoading("Salvando Colaborador...");
					}
				});
	});

	function validarEmail(){
		var email = $("#email").val();
		abrirLoading("Verificando e-mail...");
		$.post("/gestao-projetos/painel/usuarios/consultarUsuario?login="+email, function(existe) {
			if(existe){
				$("#alertadocdiv").remove();
				var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
						+ "<span style='color: #000000'><strong>Alerta!</strong>"
						+ "O e-mail informado já está sendo utilizado.</span></div>";
				$("#alertas").append(alerta);
				$("#email").val("").focus();
			}else{
				$("#alertadocdiv").remove();
			}
			fecharLoading();
		});
	}
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Cadastrar Colaborador</h4>
			<hr />
			<div id="alertas"></div>
			<form
				action='<c:url value="/painel/parceiros/${idParceiro}/salvarColaborador"></c:url>'
				method="POST">
				<input id="parceiro" name="parceiro.id" value="${idParceiro}"
					type="hidden" />
				<div class="col-md-12">
					<div class="row">
						<div class="form-group col-md-4 col-md-offset-1">
							<label for="nome">Nome:</label><input class="form-control"
								id="nome" name="nome" placeholder="Digite um nome" required
								autofocus />
						</div>
						<div class="form-group col-md-4">
							<label for="email">Email:</label><input class="form-control" onblur="validarEmail();"
								id="email" name="email" placeholder="Digite um email" required type="email" />
						</div>
						<div class="row">
							<div class="form-group col-md-2">
								<label for="perfil">Perfil:</label><select class="form-control"
									id="perfil" name="usuario.perfil.id" required>
									<option value="" label="Selecione..." />
									<option value="ROLE_COLABORADOR" label="COLABORADOR" />
									<option value="ROLE_COORDENADOR" label="COORDENADOR" />
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<a class="btn btn-default btn-return"
							href='<c:url value="/painel/parceiros/${idParceiro}/colaboradores"></c:url>'>Cancelar</a>
						<button id="btnsalvar" class="btn btn-default btn-add"
							type="submit">Salvar Colaborador</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>