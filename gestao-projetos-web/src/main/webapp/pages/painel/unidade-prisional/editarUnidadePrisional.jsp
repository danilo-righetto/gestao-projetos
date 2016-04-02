<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edição de Unidade Prisional</title>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Editar Unidade Prisional</h4>
			<hr />
			<div class="row">
				<div class="col-md-12">
					<form
						action='<c:url value="/painel/unidades-prisionais/editarUnidadePrisional"></c:url>'
						method="POST">
						<div class="row">
							<div>
								<input id="idUnidadePrisional" name="id"
									value="${unidadePrisional.id}" type="hidden">
							</div>
							<div class="form-group col-md-5">
								<label for="nome">Nome:</label><input class="form-control"
									id="nome" name="nome" value="${unidadePrisional.nome}" required
									autofocus />
							</div>
							<div class="form-group col-md-3">
								<label for="status">Status:</label><select class="form-control"
									id="status" name="status" required>
									<c:choose>
										<c:when test="${unidadePrisional.status == true}">
											<option value="true" label="ATIVADA" selected />
											<option value="false" label="DESATIVADA" />
										</c:when>
										<c:when test="${unidadePrisional.status == false}">
											<option value="true" label="ATIVADA" />
											<option value="false" label="DESATIVADA" selected />
										</c:when>
									</c:choose>

								</select>
							</div>
						</div>
						<div style="margin-top: 50px;">
							<hr />
							<a class="btn btn-default btn-return"
								href="/gestao-projetos/painel/unidades-prisionais/">Cancelar</a>
							<button class="btn btn-default btn-add" type="submit">Cadastrar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>