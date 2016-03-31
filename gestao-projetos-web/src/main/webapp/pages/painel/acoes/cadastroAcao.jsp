<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
</head>

<script type="text/javascript">
	$(function() {
		$("#menu-acoes").attr('class', 'active');
		$(".data").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Ter�a', 'Quarta',
							'Quinta', 'Sexta', 'S�bado' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'S�b', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Mar�o', 'Abril',
							'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
							'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
					nextText : 'Pr�ximo',
					prevText : 'Anterior'
				});
	});
</script>

<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Cadastro de A��o</h4>
			<hr />
			<div class="row">
				<div class="col-md-12">
					<form action="salvarAcao" method="POST" role="form">
						<div class="row">
							<div class="form-group col-md-4">
								<label for="nome">Nome:</label> <input type="text"
									class="form-control" id="nome" name="nome"
									placeholder="Digite o nome" required autofocus>
							</div>
							<div class="form-group col-md-2">
								<label for="status">Status:</label> <select class="form-control"
									name="status" required>
									<option value="">Selecione ...</option>
									<option value="Aberto">ABERTO</option>
									<option value="Em andamento">EM ANDAMENTO</option>
									<option value="Encerrado">ENCERRADO</option>
									<option value="Concluido">CONCLUIDO</option>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="dataInicio">Data Inicio:</label> <input type="text"
									class="form-control data" id="dataInicio" name="dataInicio"
									placeholder="Selecione a Data" required>
							</div>
							<div class="form-group col-md-3">
								<label for="dataTermino">Data Termino:</label> <input
									type="text" class="form-control data" id="dataTermino"
									name="dataTermino" placeholder="Selecione a Data" required>
							</div>
							<div class="form-group col-md-12">
								<label for="descricao">Descri��o:</label>
								<textarea class="form-control" id="descricao"
									placeholder="Digite uma Descri��o" cols="10" rows="5"
									name="descricao" required></textarea>
							</div>
						</div>
						<hr />
						<div class="form-group col-xs-offset-0">
							<a href='<c:url value="/painel/acoes/" />'
								class="btn btn-default btn-return">Cancelar</a>
							<button type="submit" class="btn btn-default btn-add">Salvar
								A��o</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="section" style="margin-top: -2px"></div>
</body>
</html>