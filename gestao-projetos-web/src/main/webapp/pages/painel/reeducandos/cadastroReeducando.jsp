<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<title>Cadastro de Reeducando</title>
<script type="text/javascript">
	$(function() {
		$("#menu-reeducandos").attr('class', 'active');
	});

	$(function() {
		$('#documentoCNPJ').mask('00.000.000/0000-00');
		$('#cep').mask('00000-000');
		$('#telefoneFixo').mask('(00) 0000-0000');
		$('#telefoneCelular').mask('(00) 0000-00009');
	});

	// 	function validarCPF() { 
	// 		var cpf = $('#cpf').val();
	// 	    cpf = cpf.replace(/[^\d]+/g,'');    
	// 	    if(cpf == '') return false; 
	// 	    // Elimina CPFs invalidos conhecidos    
	// 	    if (cpf.length != 11 || 
	// 	        cpf == "00000000000" || 
	// 	        cpf == "11111111111" || 
	// 	        cpf == "22222222222" || 
	// 	        cpf == "33333333333" || 
	// 	        cpf == "44444444444" || 
	// 	        cpf == "55555555555" || 
	// 	        cpf == "66666666666" || 
	// 	        cpf == "77777777777" || 
	// 	        cpf == "88888888888" || 
	// 	        cpf == "99999999999"){
	// 		    	$("#alertadocdiv").remove();
	// 				var alerta ="<div id='alertadocdiv' class='alert alert-warning'>"+
	// 				"<span style='color: #000000'><strong>Alerta!</strong>"+
	// 				"O CPF informado  é inválido.</span></div>";
	// 				$("#alertas" ).append( alerta );
	// 				$("#cpf").val("");
	// 				$("#cpf").focus();
	// 				return false;
	// 	        }
	// 	    // Valida 1o digito 
	// 	    add = 0;    
	// 	    for (i=0; i < 9; i ++)       
	// 	        add += parseInt(cpf.charAt(i)) * (10 - i);  
	// 	        rev = 11 - (add % 11);  
	// 	        if (rev == 10 || rev == 11)     
	// 	            rev = 0;    
	// 	        if (rev != parseInt(cpf.charAt(9))) {
	// 	        	$("#alertadocdiv").remove();
	// 				var alerta ="<div id='alertadocdiv' class='alert alert-warning'>"+
	// 				"<span style='color: #000000'><strong>Alerta!</strong>"+
	// 				"O CPF informado  é inválido.</span></div>";
	// 				$("#alertas" ).append( alerta );
	// 				$("#documento").val("");
	// 				$("#documento").focus();
	// 				return false;
	// 		        }    
	// 	    // Valida 2o digito 
	// 	    add = 0;    
	// 	    for (i = 0; i < 10; i ++)        
	// 	        add += parseInt(cpf.charAt(i)) * (11 - i);  
	// 	    rev = 11 - (add % 11);  
	// 	    if (rev == 10 || rev == 11) 
	// 	        rev = 0;    
	// 	    if (rev != parseInt(cpf.charAt(10))){
	// 	    	$("#alertadocdiv").remove();
	// 			var alerta ="<div id='alertadocdiv' class='alert alert-warning'>"+
	// 			"<span style='color: #000000'><strong>Alerta!</strong>"+
	// 			"O CPF informado  é inválido.</span></div>";
	// 			$("#alertas" ).append( alerta );
	// 			$("#documento").val("");
	// 			$("#documento").focus();
	// 			return false;
	// 		    }
	// 	    $("#alertadocdiv").remove();
	// 	    return true;   
	// 	}
</script>
</head>
<body>
	<!-- Formulario de Cadastro - INICIO -->
	<div class="section">
		<div class="container">
			<h3 class="title-screen">Cadastro de Reeducando</h3>
			<hr />
			<div id="alertas"></div>
			<div class="col-md-12">
				<form action="salvarReeducando" method="POST">
					<div class="row col-md-offset-2">
						<div class="form-group col-md-5">
							<label for="nome">Nome Completo:</label> <input type="text"
								class="form-control" id="nome" name="nome"
								placeholder="Digite o nome" required autofocus>
						</div>
						<div class="form-group col-md-4">
							<label for="unidadePrisional">Unidade Prisional:</label> <select
								id="unidadePrisional" name="unidadePrisional.id"
								class="form-control" required>
								<option value="" label="Selecione..." />
								<c:forEach var="unidadePrisional" items="${unidades}">
									<c:if test="${unidadePrisional.status != false}">
										<option value="${unidadePrisional.id}"
											label="${unidadePrisional.nome}" />
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row col-md-offset-2">
						<div class="form-group col-md-5">
							<label for="matricula">Número da Matrícula:</label><input
								type="text" class="form-control" id="matricula" name="matricula"
								placeholder="Digite a matrícula" required
								onblur="verificarMatricula();" />
						</div>
						<div class="form-group col-md-2">
							<label for="sexo">Sexo:</label> <select class="form-control"
								name="sexo" required>
								<option value="">Selecione ...</option>
								<option value="F">FEMININO</option>
								<option value="M">MASCULINO</option>
							</select>
						</div>
						<div class="form-group col-md-2">
							<label for="cidade">Cidade:</label> <input type="text"
									class="form-control" id="cidade" name="cidade" placeholder="Digite a cidade" required>
						  </div>
						<!-- datepicker  - INICIO -->

						<div class="form-group col-md-2">
							<label for="dataNascimento">Data de Nascimento:</label> <input
								type="text" class="form-control data" id="dataNascimento"
								name="dataNascimento" placeholder="Selecione a Data" required>
						</div>
						<!-- datepicker  - FIM -->
					</div>
					<hr />

					<div class="row">
						<div class="col-md-12">
							<a href='<c:url value="/painel/reeducandos/"></c:url>'
								class="btn btn-default btn-return">Cancelar</a>
							<button type="submit" class="btn btn-default btn-add">Salvar
								Reeducando</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Formulario de Cadastro - FIM -->
	<div class="section" style="margin-top: 60px;"></div>
</body>
<script type="text/javascript">
	$(".data").datepicker(
			{
				dateFormat : 'dd/mm/yy',
				dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta',
						'Sexta', 'Sábado' ],
				dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
				dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
						'Sáb', 'Dom' ],
				monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
						'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
						'Outubro', 'Novembro', 'Dezembro' ],
				monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun',
						'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
				nextText : 'Próximo',
				prevText : 'Anterior'
			});
</script>
<script type="text/javascript">
	function verificarMatricula() {
		var matricula = $("#matricula").val();
		$
				.post(
						"/gestao-projetos/painel/reeducandos/verificarMatricula?matricula="
								+ matricula,
						function(existe) {
							if (existe) {
								$("#alertadocdiv").remove();
								var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
										+ "<span style='color: #000000'><strong>Alerta! </strong>"
										+ "Matrícula já existe.</span></div>";
								$("#alertas").append(alerta);
								$("#matricula").val("").focus();
							} else {
								$("#alertadocdiv").remove();
							}
						})
	};
</script>
</html>