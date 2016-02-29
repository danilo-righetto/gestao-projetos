<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
</head>

<script type="text/javascript">
	$(function() {
		$("#menu-projetos").attr('class', 'active');
	});
</script>

<body>
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Cadastro de
				Projeto</h4>
			<hr />
			<div class="row">
				<div class="col-md-12">
					<form action="salvarProjeto" method="POST" role="form">
						<div class="row">
							<div class="form-group col-md-4">
								<label for="nome">Nome:</label> <input type="text"
									class="form-control" id="nome" name="nome"
									placeholder="Digite o nome" required autofocus>
							</div>
							<div class="form-group col-md-2">
								<label for="status">Status</label> <select class="form-control"
									name="status" required>
									<option value="">Selecione ...</option>
									<option value="Aberto">Aberto</option>
									<option value="Em andamento">Em andamento</option>
									<option value="Encerrado">Encerrado</option>
									<option value="Concluido">Concluido</option>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="dataInicio">Data Inicio:</label> <input type="text"
									class="form-control" id="dataInicio" name="dataInicio"
									placeholder="Selecione a Data" required autofocus>
							</div>
							<div class="form-group col-md-3">
								<label for="dataTermino">Data Termino:</label> <input
									type="text" class="form-control" id="dataTermino"
									name="dataTermino" placeholder="Selecione a Data" autofocus>
							</div>
							<div class="form-group col-md-12">
							<label for="descricao">Descrição</label> <textarea
								class="form-control" id="descricao"
								placeholder="Digite uma Descrição" cols="10" rows="5" name="descricao" required></textarea>
						</div>
						</div>
						<hr />
						<div class="form-group col-xs-offset-0">
							<a href='<c:url value="/painel/projetos/" />'
								style="float: left; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
								class="btn btn-default">Cancelar</a>
							<button type="submit"
								style="float: right; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
								class="btn btn-default">Salvar Projeto</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="section" style="margin-top:-2px">
    </div>
</body>
</html>