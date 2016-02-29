<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" type="text/css"
	href="/gestao-projetos/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<link href="/gestao-projetos/bootstrap/datepicker/dist/css/bootstrap-datepicker.css"
	rel="stylesheet" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script src="/gestao-projetos/bootstrap/js/jquery.mask.min.js"></script>
<script
	src="/gestao-projetos/bootstrap/datepicker/js/bootstrap-datepicker.js"></script>
<script
	src="/gestao-projetos/bootstrap/datepicker/dist/locales/bootstrap-datepicker.pt-BR.min.js"></script>
<title>Cadastro de Reeducando</title>
<style type="text/css">
#main {
	margin-top: 60px;
}
</style>

<script type="text/javascript">
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
	<div id="main" class="container-fluid">

		<h3 class="page-header">Cadastro de Reeducando</h3>
		<div id="alertas"></div>
		<form action="salvarReeducando" method="POST">
			<div class="row">
				<div class="form-group col-md-4">
					<label for="matricula">Número da Matrícula:</label><input
						type="text" class="form-control" id="matricula" name="matricula"
						placeholder="Digite a matrícula" required autofocus />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label for="nome">Nome Completo:</label> <input type="text"
						class="form-control" id="nome" name="nome"
						placeholder="Digite o nome" required autofocus>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label for="sexo">Sexo</label> <select class="form-control"
						name="sexo" required>
						<option value="0">Selecione ...</option>
						<option value="F">Feminino</option>
						<option value="M">Masculino</option>
					</select>
				</div>
			</div>
			<!-- datepicker  - INICIO -->

			<div class="row">
				<div class="form-group col-md-4">
					<label for="dataNascimento">Data de Nascimento:</label> <input
						type="text" class="form-control" id="dataNascimento"
						name="dataNascimento" placeholder="Selecione a Data" required
						autofocus>
				</div>
			</div>

			<!-- datepicker  - FIM -->


			<div class="row">
				<div class="form-group col-md-4">
					<label for="unidadePrisional">Unidade Prisional</label> <select
						id="unidadePrisional" name="unidadePrisional.id"
						class="form-control" required>
						<option value="" label="Selecione..." />
						<c:forEach var="unidadePrisional" items="${unidades}">
							<option value="${unidadePrisional.id}"
								label="${unidadePrisional.nome}" />
						</c:forEach>
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
<script>
	$('#dataNascimento').datepicker({
		language : 'pt-BR'
	});
</script>
</html>