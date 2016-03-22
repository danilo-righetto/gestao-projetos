<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<script src="/gestao-projetos/bootstrap/tinymce/js/tinymce.js"></script>
<script>
	tinymce.init({
		selector : '#informacoes',
		language : 'pt_BR',
		menubar : false,
		resize : false,
		statusbar : false,
	});
</script>
<body>
	<div class="section" style="padding-top: 0;">
		<div class="container">
			<form
				action="<c:url value="/painel/projetos/salvarInformacoes"></c:url>"
				method="POST" novalidate>
				<div class="header text-center">
					<h3 class="title-screen">Informações do Projeto</h3>
				</div>
				<div>
					<input id="idProjeto" name="projeto.id" value="${idProjeto}"
						type="hidden" required />
				</div>
				<div>
					<input id="idInfo" name="id" value="${info.id}" type="hidden" />
				</div>
				<div class="form-group">
					<textarea id="informacoes" class="form-control" name="informacoes"
						rows="14" cols="10" required>${info.informacoes}</textarea>
				</div>
				<hr />
				<div>
					<a class="btn btn-default btn-return"
						href='<c:url value="/painel/projetos/"></c:url>' type="button"><span
						class="glyphicon glyphicon-remove"></span>Cancelar</a>
					<button class="btn btn-default btn-add" type="submit">
						<span class="glyphicon glyphicon-ok"></span>Salvar
					</button>
				</div>
			</form>
		</div>
	</div>
	<div class="section" style="margin-top: -23px; padding-top: 0;"></div>
</body>
</html>