<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
</head>
  
  <script type="text/javascript">
	$(function() {
		$('#documentoCNPJ').mask('00.000.000/0000-00');
		$('#cpf').mask('000.000.000-00');
		$('#cep').mask('00000-000');
		$('#telefoneFixo').mask('(00) 0000-0000');
		$('#telefoneCelular').mask('(00) 0000-00009');
		$("#menu-projetos").attr('class','active');
	});


	function validarCPF() { 
		var cpf = $('#cpf').val();
	    cpf = cpf.replace(/[^\d]+/g,'');    
	    if(cpf == '') return false; 
	    // Elimina CPFs invalidos conhecidos    
	    if (cpf.length != 11 || 
	        cpf == "00000000000" || 
	        cpf == "11111111111" || 
	        cpf == "22222222222" || 
	        cpf == "33333333333" || 
	        cpf == "44444444444" || 
	        cpf == "55555555555" || 
	        cpf == "66666666666" || 
	        cpf == "77777777777" || 
	        cpf == "88888888888" || 
	        cpf == "99999999999"){
		    	$("#alertadocdiv").remove();
				var alerta ="<div id='alertadocdiv' class='alert alert-warning'>"+
				"<span style='color: #000000'><strong>Alerta!</strong>"+
				"O CPF informado  é inválido.</span></div>";
				$("#alertas" ).append( alerta );
				$("#cpf").val("");
				$("#cpf").focus();
				return false;
	        }
	    // Valida 1o digito 
	    add = 0;    
	    for (var i=0; i < 9; i ++)       
	        add += parseInt(cpf.charAt(i)) * (10 - i);  
	        rev = 11 - (add % 11);  
	        if (rev == 10 || rev == 11)     
	            rev = 0;    
	        if (rev != parseInt(cpf.charAt(9))) {
	        	$("#alertadocdiv").remove();
				var alerta ="<div id='alertadocdiv' class='alert alert-warning'>"+
				"<span style='color: #000000'><strong>Alerta!</strong>"+
				"O CPF informado  é inválido.</span></div>";
				$("#alertas" ).append( alerta );
				$("#documento").val("");
				$("#documento").focus();
				return false;
		}    
	    // Valida 2o digito 
	    add = 0;    
	    for (var i = 0; i < 10; i ++)        
	        add += parseInt(cpf.charAt(i)) * (11 - i);  
	    rev = 11 - (add % 11);  
	    if (rev == 10 || rev == 11) 
	        rev = 0;    
	    if (rev != parseInt(cpf.charAt(10))){
	    	$("#alertadocdiv").remove();
			var alerta ="<div id='alertadocdiv' class='alert alert-warning'>"+
			"<span style='color: #000000'><strong>Alerta!</strong>"+
			"O CPF informado  é inválido.</span></div>";
			$("#alertas" ).append( alerta );
			$("#documento").val("");
			$("#documento").focus();
			return false;
		    }
	    $("#alertadocdiv").remove();
	    return true;   
	}

</script>
  
  <body>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center text-success">Cadastro de Projetos</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <form action="salvarProjeto" method="POST" role="form">
              <div class="form-group col-md-4">
					<label for="nome">Nome:</label> <input type="text"
						class="form-control" id="nome" name="nome" placeholder="Digite o nome" required autofocus>
				</div>
				<div class="form-group col-md-4">
					<label for="descricao">Descrição</label> <input type="text"
						class="form-control" id="descricao"
						placeholder="Digite uma Descrição" name="descricao" required>
				</div>
				<div class="form-group col-md-4">
					<label for="dataInicio">Data Inicio:</label> <input type="text"
						class="form-control" id="dataInicio" name="dataInicio"
						placeholder="Selecione a Data" required autofocus>
				</div>
				<div class="form-group col-md-4">
					<label for="dataTermino">Data Termino:</label> <input type="text"
						class="form-control" id="dataTermino" name="dataTermino"
						placeholder="Selecione a Data" required autofocus>
				</div>
				<div class="form-group col-md-4">
					<label for="status">Status</label> <select class="form-control"
						name="status" required>
						<option value="0">Selecione ...</option>
						<option value="aberto">Aberto</option>
						<option value="andamento">Em andamento</option>
						<option value="encerrado">Encerrado</option>
						<option value="concluido">Concluido</option>
					</select>
				</div>
			  <div class="form-group">
			  </div>
			  <br /><br />
			  <div class="form-group col-md-12">
				<button type="submit" class="btn btn-default">Salvar</button>
			  </div>
			  <div class="form-group col-md-12">
				<button type="button" class="btn btn-default">Cancelar</button>
			  </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  

</body></html>