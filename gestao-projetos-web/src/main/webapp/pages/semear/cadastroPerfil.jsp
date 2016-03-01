<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>

<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="/gestao-projetos/bootstrap/css/index.css" rel="stylesheet" type="text/css">
  </head>
  
  <script type="text/javascript">
	$(function() {
		$('#documentoCNPJ').mask('00.000.000/0000-00');
		$('#cpf').mask('000.000.000-00');
		$('#cep').mask('00000-000');
		$('#telefoneFixo').mask('(00) 0000-0000');
		$('#telefoneCelular').mask('(00) 0000-00009');
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
	    for (i=0; i < 9; i ++)       
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
	    for (i = 0; i < 10; i ++)        
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
    <div class="navbar navbar-default navbar-static-top" style="background-color: #4DC1FF;color:#ffffff;">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-md hidden-lg" href="#"><span>Projeto Semear</span></a>
		  <a class="navbar-brand hidden-xs hidden-sm" style="color:#ffffff; height: 80px;" href="#">
		  <img src="/gestao-projetos/img/logo.jpg" class="center-block img-responsive img-rounded" height="120px" width="120px" style="margin-top: -8px;"></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href="#">Instituição</a>
            </li>
            <li>
              <a href="#">Projeto</a>
            </li>
			<li>
              <a href="#">Usuário</a>
            </li>
			<li class="active">
              <a href="#">Perfil</a>
            </li>
			<li>
              <a href="#">Pergunta</a>
            </li>
			<li>
              <a href="#">Resposta</a>
            </li>
			<li>
              <a href="#">Questionário</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center text-success">Cadastro de Perfil</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <form action="salvarPerfil" method="POST" role="form">
              <div class="form-group col-md-4">
					<label for="descricao">Descrição do Perfil:</label> <input type="text"
						class="form-control" id="descricao" name="descricao" placeholder="Digite a descrição" required autofocus>
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
