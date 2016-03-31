<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Editar Colaborador</h4>
			<hr />
			<form
				action='<c:url value="/painel/instituicoes/${idParceiro}/editarColaborador"></c:url>'
				method="POST">
				<div>
					<input id="parceiro" name="parceiro.id" value="${idParceiro}"
						type="hidden" />
				</div>
				<div>
					<input id="colaborador" name="id" value="${idColaborador}"
						type="hidden" />
				</div>
				<div>
					<input id="usuario" name="usuario.id"
						value="${colaborador.usuario.id}" type="hidden" />
				</div>

				<div class="col-md-12">
					<div class="row">
						<div class="form-group col-md-4 col-md-offset-1">
							<label for="nome">Nome:</label><input class="form-control"
								id="nome" name="nome" value="${colaborador.nome}" required
								autofocus />
						</div>
						<div class="form-group col-md-4">
							<label for="email">Email:</label><input class="form-control"
								id="email" name="email" value="${colaborador.email}" required />
						</div>
						<div class="row">
							<div class="form-group col-md-2">
								<label for="perfil">Perfil:</label><select class="form-control"
									id="perfil" name="usuario.perfil.id" required>
									<c:choose>
										<c:when
											test="${colaborador.usuario.perfil.id == 'ROLE_COLABORADOR' }">
											<option value="ROLE_COLABORADOR" label="COLABORADOR" selected />
											<option value="ROLE_COORDENADOR" label="COORDENADOR" />
										</c:when>
										<c:otherwise>
											<option value="ROLE_COLABORADOR" label="COLABORADOR" />
											<option value="ROLE_COORDENADOR" label="COORDENADOR" selected />
										</c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<a class="btn btn-default btn-return"
							href='<c:url value="/painel/instituicoes/${idParceiro}/colaboradores"></c:url>'>Cancelar</a>
						<button class="btn btn-default btn-add" type="submit">Salvar
							Colaborador</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>