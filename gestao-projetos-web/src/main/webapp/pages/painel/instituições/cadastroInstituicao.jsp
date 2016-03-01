<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
    <script type="text/javascript" src="/gestao-projetos/bootstrap/js/jquery.mask.js"></script>
  </head>
  
  <script type="text/javascript">
	$(function() {
		$('#documentoCNPJ').mask('00.000.000/0000-00');
		//$('#cpf').mask('000.000.000-00');
		$('#cep').mask('00000-000');
		$('#telefoneFixo').mask('(00) 0000-0000');
		$('#telefone').mask('(00) 0000-00009');
	});
	
	function ocultarCNPJ(){
		var escolha = document.getElementById("tipopessoa").value;
		if(escolha == "fisica"){
			$('#tipoDocumento').append('<option value="rg" id="rg">RG</option>');
			$('#tipoDocumento').append('<option value="cpf" id="cpf">CPF</option>');
			document.getElementById("jurudico1").style.display = "none";
			document.getElementById("jurudico2").style.display = "none";
			$('#documento').mask('000.000.000-00');
			$('#cnpj').remove();
		} else if(escolha == "juridica"){
			$('#tipoDocumento').append('<option value="cnpj" id="cnpj">CNPJ</option>');
			document.getElementById("jurudico1").style.display = "block";
			document.getElementById("jurudico2").style.display = "block";
			$('#documento').mask('00.000.000/0000-00');
			$('#cpf').remove();
			$('#rg').remove();
		}
	}


	function validarCPF() { 
		var escolhapessoa = document.getElementById("tipopessoa").value;
		if(escolhapessoa == "fisica"){
		var cpf = $('#documento').val();
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
	}

</script>
  
  <body>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center text-success">Cadastro de Instituição</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <form action="salvarInstituicao" method="POST" role="form">
              <div class="form-group col-md-4">
				<label for="tipopessoa">Tipo de Pessoa:</label> <select class="form-control"
						name="tipopessoa" id=tipopessoa onchange="ocultarCNPJ();" required>
						<option value="">Selecione ...</option>
						<option value="fisica">Pessoa Fisica</option>
						<option value="juridica">Pessoa Juridica</option>
					</select>
			  </div>
			  <div class="form-group col-md-4" id="jurudico1">
				<label for="nomefantasia">Nome Fantasia:</label> 
					<input type="text" class="form-control" id="nomefantasia" name="nomefantasia" placeholder="Digite o nome" autofocus>
			  </div>
			  <div class="form-group col-md-4" id="jurudico2">
				<label for="razaosocial">Razão Social:</label> <input type="text"
						class="form-control" id="razaosocial" name="razaosocial" placeholder="Digite a razao social" autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="tipoDocumento">Tipo do Documento</label> <select class="form-control"
						name="tipoDocumento" id="tipoDocumento" required>
					</select>
			  </div>
			  <div class="form-group col-md-4">
				<label for="documento">Número do Documento:</label> 
					<input onblur="validarDocumento();" type="text" class="form-control" id="documento" name="documento" placeholder="Digite o documento">
			  </div>
			  <div class="form-group col-md-4">
				<label for="logradouro">Logradouro:</label> <input type="text"
						class="form-control" id="logradouro" name="logradouro" placeholder="Digite o logradouro" required autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="numero">Número:</label> <input type="text"
						class="form-control" id="numero" name="numero" placeholder="Digite o numero" required autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="complemento">Complemento:</label> <input type="text"
						class="form-control" id="complemento" name="complemento" placeholder="Digite o complemento" required autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="bairro">Bairro:</label> <input type="text"
						class="form-control" id="bairro" name="bairro" placeholder="Digite o bairro" required autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="cep">CEP:</label> <input type="text"
						class="form-control" id="cep" name="cep" placeholder="Digite o cep" required autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="uf">UF:</label> <input type="text"
						class="form-control" id="uf" name="uf" placeholder="Digite o uf" required autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="cidade">Cidade:</label> <input type="text"
						class="form-control" id="cidade" name="cidade" placeholder="Digite a cidade" required autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="telefone">Telefone:</label> <input type="text"
						class="form-control" id="telefone" name="telefone" placeholder="Digite o telefone" required autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="email">Email:</label> <input type="email"
						class="form-control" id="email" name="email" placeholder="Digite o E-mail" required autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="responsavel">Responsável:</label> <input type="text"
						class="form-control" id="responsavel" name="responsavel" placeholder="Digite o nome do responsavel" required autofocus>
			  </div>
			  <div class="form-group col-md-4">
				<label for="projeto">Selecione o projeto:</label> <select class="form-control" id="projeto"
						name="projetoInstituicao.id" required>
						<option value="">Selecione ...</option>
						<c:forEach items="${listaprojetos}" var="projeto">
								<option value="${projeto.id}">${projeto.nome}</option>
						</c:forEach>
					</select>
			  </div>
			  <div class="form-group">
			  </div>
			  <br /><br />
			  <div class="form-group col-md-12">
				<button type="submit" class="btn btn-default">Enviar</button>
			  </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  

</body></html>
