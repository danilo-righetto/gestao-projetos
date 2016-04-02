<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Unidade Prisional</title>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Cadastrar Unidade Prisional</h4>
			<hr />
			<div class="row">
				<div class="col-md-12">
					<form action="salvarUnidadePrisional" method="POST">
						<div class="row">
							<div class="form-group col-md-5">
								<label for="nome">Nome:</label><input class="form-control"
									id="nome" name="nome" placeholder="Nome do Parceiro"
									required autofocus />
							</div>
							<div class="form-group col-md-3">
								<label for="status">Status:</label><select class="form-control"
									id="status" name="status" required>
									<option value="" label="Selecione..." />
									<option value="1" label="ATIVADA" />
									<option value="0" label="DESATIVADA" />
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