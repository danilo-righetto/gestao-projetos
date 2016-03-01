<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="/gestao-projetos/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="/gestao-projetos/bootstrap/css/jquery-ui.min.css" />
<title>Cadastro de Participação Projeto</title>
<style type="text/css">
#main {
	margin-top: 60px;
}
</style>
<script type="text/javascript"
	src="/gestao-projetos/bootstrap/js/jquery-ui.min.js"></script>
<script>
	$(function() {
		var teste;
		var avaliableTags = [];
		$.post("/gestao-projetos/listarProjetos", function(resultados) {
			$.each(resultados, function(i, r) {
				  avaliableTags.push(r.nome);
				});
		});
// 		avaliableTags = [ "ActionScript", "AppleScript", "Asp", "BASIC",
// 				"C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang",
// 				"Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp",
// 				"Perl", "PHP", "Python", "Ruby", "Scala", "Scheme" ];
		$("#buscaProjeto").autocomplete({
			source : avaliableTags
		});
	});
</script>
</head>
<body>
	<!-- Formulario de Cadastro - INICIO -->
	<div id="main" class="container-fluid">

		<h3 class="page-header">Cadastro de Participação Projeto</h3>

		<form action="salvarParticipacaoProjeto" method="POST">
			<div>
				<input id="reeducando" name="reeducando.id" type="hidden" value="1"/>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="buscarProjeto">Projeto:</label> <input
						class="form-control" id="buscaProjeto" name="projeto.nome"
						type="search" placeholder="Buscar..." />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="dataEntrada">Data de Entrada:</label> <input
						class="form-control" id="dataEntrada" name="dataEntrada" required />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="funcao">Função:</label> <select class="form-control"
						id="funcao" name="funcao" required>
						<option value="Reeducando Monitor" label="Reeducando Monitor" />
						<option value="Reeducando Participante"
							label="Reeducando Participante" />
					</select>
				</div>
			</div>
			<hr />

			<div class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="#" class="btn btn-default">Cancelar</a>
				</div>
			</div>

		</form>
	</div>

	<!-- Formulario de Cadastro - FIM -->

</body>
</html>