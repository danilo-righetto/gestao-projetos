<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		$("#menu-instituicoes").attr('class', 'active');
	});
</script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="/gestao-projetos/bootstrap/css/index.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="/gestao-projetos/bootstrap/js/jquery.mask.js"></script>
</head>

<script type="text/javascript">
	$(function() {
		$("#menu-instituicoes").attr('class', 'active');
		$('#documentoCNPJ').mask('00.000.000/0000-00');
		$('#cep').mask('00000-000');
		$('#telefoneFixo').mask('(00) 0000-0000');
		$('#telefone').mask('(00) 0000-00009');
	});

	function escolheValidacao() {
		var escolha = document.getElementById("tipopessoa").value;
		if (escolha == "fisica") {
			var rg = document.getElementById("tipoDocumento").value;
			if (rg == "rg") {
				validarDocumentoInst();
			} else if (rg == "cpf") {
				if (validarCPF()) {
					validarDocumentoInst();
				}
			}
		} else if (escolha == "juridica") {
			if (validaCNPJ()) {
				validarDocumentoInst();
			}
		}
	}

	function mascaraRG() {
		var rg = document.getElementById("tipoDocumento").value;
		if (rg == "rg") {
			$('#documento').mask('00000000000000');
		} else {
			$('#documento').mask('000.000.000-00');

		}
	}

	function ocultarCNPJ() {
		var escolha = document.getElementById("tipopessoa").value;
		if (escolha == "fisica") {
			$('#tipoDocumento').append(
					'<option value="cpf" id="cpf">CPF</option>');
			$('#tipoDocumento')
					.append('<option value="rg" id="rg">RG</option>');
			document.getElementById("jurudico1").style.display = "none";
			document.getElementById("jurudico2").style.display = "none";
			document.getElementById("fisica1").style.display = "block";
			$('#documento').mask('000.000.000-00');
			$('#nomecompleto').val("");
			$('#cnpj').remove();
			$('#razaosocial').removeAttr('required');
			$('#nomefantasia').removeAttr('required');
		} else if (escolha == "juridica") {
			$('#tipoDocumento').append(
					'<option value="cnpj" id="cnpj">CNPJ</option>');
			document.getElementById("jurudico1").style.display = "block";
			document.getElementById("jurudico2").style.display = "block";
			document.getElementById("fisica1").style.display = "none";
			$('#documento').mask('00.000.000/0000-00');
			$('#razaosocial').val("");
			$('#cpf').remove();
			$('#rg').remove();
			$('#razaosocial').attr('required', 'required');
			$('#nomefantasia').attr('required', 'required');
		}
	}

	function validarCPF() {
		var escolhapessoa = document.getElementById("tipopessoa").value;
		if (escolhapessoa == "fisica") {
			var cpf = $('#documento').val();
			cpf = cpf.replace(/[^\d]+/g, '');
			if (cpf == '')
				return false;
			// Elimina CPFs invalidos conhecidos    
			if (cpf.length != 11 || cpf == "00000000000"
					|| cpf == "11111111111" || cpf == "22222222222"
					|| cpf == "33333333333" || cpf == "44444444444"
					|| cpf == "55555555555" || cpf == "66666666666"
					|| cpf == "77777777777" || cpf == "88888888888"
					|| cpf == "99999999999") {
				$("#alertadocdiv").remove();
				var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
						+ "<span style='color: #000000'><strong>Alerta!</strong>"
						+ "O CPF informado  é inválido.</span></div>";
				$("#alertas").append(alerta);
				$("#documento").val("");
				$("#documento").focus();
				return false;
			}
			// Valida 1o digito 
			add = 0;
			for ( var i = 0; i < 9; i++)
				add += parseInt(cpf.charAt(i)) * (10 - i);
			rev = 11 - (add % 11);
			if (rev == 10 || rev == 11)
				rev = 0;
			if (rev != parseInt(cpf.charAt(9))) {
				$("#alertadocdiv").remove();
				var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
						+ "<span style='color: #000000'><strong>Alerta!</strong>"
						+ "O CPF informado  é inválido.</span></div>";
				$("#alertas").append(alerta);
				$("#documento").val("");
				$("#documento").focus();
				return false;
			}
			// Valida 2o digito 
			add = 0;
			for (i = 0; i < 10; i++)
				add += parseInt(cpf.charAt(i)) * (11 - i);
			rev = 11 - (add % 11);
			if (rev == 10 || rev == 11)
				rev = 0;
			if (rev != parseInt(cpf.charAt(10))) {
				$("#alertadocdiv").remove();
				var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
						+ "<span style='color: #000000'><strong>Alerta!</strong>"
						+ "O CPF informado  é inválido.</span></div>";
				$("#alertas").append(alerta);
				$("#documento").val("");
				$("#documento").focus();
				return false;
			}
			$("#alertadocdiv").remove();
			return true;
		}
	}

	function validaCNPJ() {
		var cnpj = document.getElementById("documento").value;
		cnpj = cnpj.replace(/[^\d]+/g, '');

		if (cnpj == '')
			return false;

		if (cnpj.length != 14) {
			$("#alertadocdiv").remove();
			var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
					+ "<span style='color: #000000'><strong>Alerta!</strong>"
					+ "O CNPJ informado  é inválido.</span></div>";
			$("#alertas").append(alerta);
			//$("#documento").val("");
			$("#documento").focus();
			return false;
		}

		// Elimina CNPJs invalidos conhecidos
		if (cnpj == "00000000000000" || cnpj == "11111111111111"
				|| cnpj == "22222222222222" || cnpj == "33333333333333"
				|| cnpj == "44444444444444" || cnpj == "55555555555555"
				|| cnpj == "66666666666666" || cnpj == "77777777777777"
				|| cnpj == "88888888888888" || cnpj == "99999999999999") {
			$("#alertadocdiv").remove();
			var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
					+ "<span style='color: #000000'><strong>Alerta!</strong>"
					+ "O CNPJ informado  é inválido.</span></div>";
			$("#alertas").append(alerta);
			$("#documento").val("");
			$("#documento").focus();
			return false;
		}

		// Valida DVs
		tamanho = cnpj.length - 2;
		numeros = cnpj.substring(0, tamanho);
		digitos = cnpj.substring(tamanho);
		soma = 0;
		pos = tamanho - 7;
		for ( var i = tamanho; i >= 1; i--) {
			soma += numeros.charAt(tamanho - i) * pos--;
			if (pos < 2)
				pos = 9;
		}
		resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		if (resultado != digitos.charAt(0)) {
			$("#alertadocdiv").remove();
			var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
					+ "<span style='color: #000000'><strong>Alerta!</strong>"
					+ "O CNPJ informado  é inválido.</span></div>";
			$("#alertas").append(alerta);
			$("#documento").val("");
			$("#documento").focus();
			return false;
		}
		tamanho = tamanho + 1;
		numeros = cnpj.substring(0, tamanho);
		soma = 0;
		pos = tamanho - 7;
		for (i = tamanho; i >= 1; i--) {
			soma += numeros.charAt(tamanho - i) * pos--;
			if (pos < 2)
				pos = 9;
		}
		resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		if (resultado != digitos.charAt(1)) {
			$("#alertadocdiv").remove();
			var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
					+ "<span style='color: #000000'><strong>Alerta!</strong>"
					+ "O CNPJ informado  é inválido.</span></div>";
			$("#alertas").append(alerta);
			//$("#documento").val("");
			$("#documento").focus();
			return false;
		}
		$("#alertadocdiv").remove();
		return true;

	}

	function validarDocumentoInst() {
		var documento = $("#documento").val();
		$
				.post(
						"/gestao-projetos/painel/instituicoes/consultarInstituicao?documento="
								+ documento,
						function(existe) {
							if (existe) {
								$("#alertadocdiv").remove();
								var alerta = "<div id='alertadocdiv' class='alert alert-warning'>"
										+ "<span style='color: #000000'><strong>Alerta!</strong>"
										+ "O Documento informado já está sendo utilizado.</span></div>";
								$("#alertas").append(alerta);
								$("#documento").val("").focus();
							} else {
								$("#alertadocdiv").remove();
							}
						});
	}
</script>

<body>
	<!-- MODAL ADICIONAR UNIDADE PRISIONAL INICIO -->
	<div class="modal fade" id="modalUnidadePrisional" tabindex="-1"
		role="dialog" data-backdrop="static" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form id="form-add-pergunta" method="POST"
				action='<c:url value="/painel/instituicoes/adicionarUnidade" />'>
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">Adicionar Unidade Prisional</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" name="idInstituicao" value="${inst.id}" />
						<div class="row">
							<div class="form-group col-md-12">
								<label>Selecione a Unidade Prisional:</label> <select
									class="form-control" name="idUnidadePrisional"
									id="idUnidadePrisional" required>
									<option value="">Selecione ...</option>
									<c:forEach items="${unidadesPrisionais}" var="unidade">
										<tr>
											<c:set var="encontrou" value="false"></c:set>
											<c:set var="jaMarcado" value="false"></c:set>
											<c:forEach items="${unidades}" var="u">
												<c:if test="${unidade.id == u.id}">
													<c:set var="encontrou" value="true"></c:set>
												</c:if>
											</c:forEach>
											<c:if test="${!encontrou}">
												<option value="${unidade.id}">${unidade.nome}</option>
											</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button"
							style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
							class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<input type="submit"
							style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
							class="btn btn-default" value="Adicionar">
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- MODAL ADICIONAR UNIDADE PRISIONAL FIM -->
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Edição de
				Instituição</h4>
			<hr />
			<div id="alertas"></div>
			<form
				action='<c:url value="/painel/instituicoes/editarInstituicao"></c:url>'
				method="POST" role="form">
				<input type="hidden" name="id" value="${inst.id}">
				<div class="row">
					<div class="form-group col-md-2">
						<label for="tipopessoa">Tipo de Pessoa:</label> <select
							class="form-control" name="tipopessoa" id=tipopessoa
							onchange="ocultarCNPJ();" disabled="disabled">
							<option value="">Selecione ...</option>
							<option value="fisica"
								${(inst.tipoDocumento == "CPF" ? 
								'selected' : '')}>Pessoa
								Fisica</option>
							<option value="juridica"
								${(inst.tipoDocumento == "CNPJ" ? 
								'selected' : '')}>Pessoa
								Juridica</option>
						</select>
					</div>
					<c:choose>
						<c:when test="${(inst.tipoDocumento == 'CPF')}">
							<div class="form-group col-md-5" id="fisica1"
								${(inst.tipoDocumento == "CPF" ? 
								'style="display: block;' : '')}>
								<label for="razaosocial">Nome Completo:</label> <input
									type="text" class="form-control" id="nomecompleto"
									value="${inst.razaosocial}" name="razaosocial"
									placeholder="Digite o nome" autofocus>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group col-md-5" id="jurudico2"
								${(inst.tipoDocumento == "CNPJ" ? 
								'' : 'style="display: none;"')}>
								<label for="razaosocial">Razão Social:</label> <input
									type="text" class="form-control" id="razaosocial"
									value="${inst.razaosocial}" name="razaosocial"
									placeholder="Digite a razao social" autofocus>
							</div>
							<div class="form-group col-md-5" id="jurudico1"
								${(inst.tipoDocumento == "CNPJ" ? 
								'' : 'style="display: none;"')}>
								<label for="nomefantasia">Nome Fantasia:</label> <input
									type="text" class="form-control" id="nomefantasia"
									value="${inst.nomefantasia}" name="nomefantasia"
									placeholder="Digite o nome" autofocus>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="form-group col-md-2">
						<label for="tipoDocumento">Tipo do Documento</label> <select
							class="form-control" name="tipoDocumento" id="tipoDocumento"
							onchange="mascaraRG();" disabled="disabled">
							<option value="${inst.tipoDocumento}" id="${inst.tipoDocumento}">${inst.tipoDocumento}</option>
						</select>
					</div>
					<div class="form-group col-md-3">
						<label for="documento">Número do Documento:</label> <input
							onblur="escolheValidacao();" type="text" class="form-control"
							id="documento" value="${inst.documento}" name="documento"
							readonly="readonly" placeholder="Digite o documento">
					</div>
					<div class="form-group col-md-2">
						<label for="cep">CEP:</label> <input type="text"
							class="form-control" id="cep" name="cep" value="${inst.cep}"
							placeholder="Digite o cep" required autofocus>
					</div>
					<div class="form-group col-md-5">
						<label for="logradouro">Logradouro:</label> <input type="text"
							class="form-control" id="logradouro" value="${inst.logradouro}"
							name="logradouro" placeholder="Digite o logradouro" required
							autofocus>
					</div>
					<div class="form-group col-md-2">
						<label for="numero">Número:</label> <input type="text"
							class="form-control" id="numero" name="numero"
							value="${inst.numero}" placeholder="Digite o numero" required
							autofocus>
					</div>
					<div class="form-group col-md-4">
						<label for="complemento">Complemento:</label> <input type="text"
							class="form-control" id="complemento" name="complemento"
							value="${inst.complemento}" placeholder="Digite o complemento"
							autofocus>
					</div>
					<div class="form-group col-md-3">
						<label for="bairro">Bairro:</label> <input type="text"
							class="form-control" id="bairro" name="bairro"
							value="${inst.bairro}" placeholder="Digite o bairro" required
							autofocus>
					</div>

					<div class="form-group col-md-1">
						<label for="uf">UF:</label> <input type="text"
							class="form-control" id="uf" name="uf" value="${inst.uf}"
							placeholder="Digite o uf" required autofocus>
					</div>
					<div class="form-group col-md-2">
						<label for="cidade">Cidade:</label> <input type="text"
							class="form-control" id="cidade" name="cidade"
							value="${inst.cidade}" placeholder="Digite a cidade" required
							autofocus>
					</div>
					<div class="form-group col-md-2">
						<label for="telefone">Telefone:</label> <input type="text"
							class="form-control" id="telefone" name="telefone"
							value="${inst.telefone}" placeholder="Digite o telefone" required
							autofocus>
					</div>
					<div class="form-group col-md-4">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" name="email"
							value="${inst.email}" placeholder="Digite o E-mail" required
							autofocus>
					</div>
					<div class="form-group col-md-3">
						<label for="responsavel">Responsável:</label> <input type="text"
							class="form-control" id="responsavel" name="responsavel"
							value="${inst.responsavel}"
							placeholder="Digite o nome do responsavel" required autofocus>
					</div>
					<div class="form-group col-md-2">
						<label for="status">Status:</label> <select class="form-control"
							name="status" id=status required>
							<option value="">Selecione ...</option>
							<option value="INATIVO"
								${(inst.status == "INATIVO" ? 
								'selected' : '')}>Inativo</option>
							<option value="ATIVO"
								${(inst.status == "ATIVO" ? 
								'selected' : '')}>Ativo</option>
						</select>
					</div>
				</div>
				<!-- INICIO - Listagem dos USUARIOS VINCULADOS A INSTITUICAO -->
				<div class="section">
					<div class="container">
						<h4 style="font-family: arial; color: #4DC1FF">Usuários da
							Instituição</h4>
						<table class="table table-responsive">
							<thead>
								<tr>
									<td class="text-center"><span style="font-weight: bold;">#</span></td>
									<td class="text-center hidden-xs hidden-sm"><span
										style="font-weight: bold;">Nome</span></td>
									<td class="text-center"><span style="font-weight: bold;">Usuário</span></td>
									<td class="text-center hidden-xs hidden-sm"><span
										style="font-weight: bold;">Realiza Login</span></td>
									<td class="text-center hidden-xs hidden-sm"><span
										style="font-weight: bold;">Perfil</span></td>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty users}">
										<c:forEach items="${users}" var="user">
											<tr>
												<td class="text-center">${user.id}</td>
												<td class="text-center hidden-xs hidden-sm">${user.nome}</td>
												<td class="text-center">${user.usuario}</td>
												<td class="text-center hidden-xs hidden-sm">${(user.realizaLogin
													== true ? 'Sim' : 'Não')}</td>
												<td class="text-center hidden-xs hidden-sm">${user.perfil.descricao}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="6">Não há dados a serem exibidos</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				</div>
				<!-- FIM - Listagem dos USUARIOS VINCULADOS A INSTITUICAO -->
				<!-- INICIO - Listagem de unidades-->
				<div class="section">
					<div class="container">
						<h4 class="title-screen">Unidades Prisionais</h4>
						<table class="table table-responsive">
							<thead>
								<tr>
									<td class="text-center"><span style="font-weight: bold;">#</span></td>
									<td class="text-center"><span style="font-weight: bold;">Unidade
											Prisional</span></td>
									<td class="text-center"><span style="font-weight: bold;">Status</span></td>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty unidades}">
										<c:forEach items="${unidades}" var="unidade">
											<tr>
												<td class="text-center">${unidade.id}</td>
												<td class="text-center">${unidade.nome}</td>
												<c:if test="${unidade.status == true}">
													<td class="text-center">Ativada</td>
												</c:if>
												<c:if test="${unidade.status == false}">
													<td class="text-center">Desativada</td>
												</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="6">Não há dados a serem exibidos</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<br />
						<button type="button"
							style="float: right; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
							class="btn btn-default" data-toggle="modal"
							data-target="#modalUnidadePrisional">
							<span class="glyphicon glyphicon-plus"></span> Adicionar Unidade
							Prisional
						</button>
					</div>
				</div>
				<!-- FIM - Listagem de unidades-->
				<hr />
				<div class="form-group col-md-12">
					<div class="form-group col-xs-offset-0">
						<a href='<c:url value="/painel/instituicoes/" />'
							style="float: left; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
							class="btn btn-default"><span
							class="glyphicon glyphicon-remove"></span> Cancelar</a>
						<button type="submit"
							style="float: right; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
							class="btn btn-default">
							<span class="glyphicon glyphicon-ok"></span> Salvar Instituição
						</button>
					</div>
				</div>
				<br />
			</form>
		</div>
	</div>
</body>
</html>