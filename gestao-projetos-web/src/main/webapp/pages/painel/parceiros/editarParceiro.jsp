<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		$("#menu-parceiros").attr('class', 'active');
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#menu-parceiros").attr('class', 'active');
		$('#documentoCNPJ').mask('00.000.000/0000-00');
		$('#cep').mask('00000-000');
		$('#telefoneFixo').mask('(00) 0000-0000');
		$('#telefone').mask('(00) 0000-00009');
	});

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
</script>
<body>
	<!-- MODAL ADICIONAR UNIDADE PRISIONAL INICIO -->
	<div class="modal fade" id="modalUnidadePrisional" tabindex="-1"
		role="dialog" data-backdrop="static" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form id="form-add-pergunta" method="POST"
				action='<c:url value="/painel/parceiros/adicionarUnidade" />'>
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">Adicionar Unidade Prisional</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" name="idParceiro" value="${parceiro.id}" />
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
				Parceiro</h4>
			<hr />
			<div id="alertas"></div>
			<form
				action='<c:url value="/painel/parceiros/editarParceiro"></c:url>'
				method="POST" role="form">
				<input type="hidden" name="id" value="${parceiro.id}">
				<div class="row">
					<div class="form-group col-md-2">
						<label for="tipopessoa">Tipo de Pessoa:</label> <select
							class="form-control" name="tipopessoa" id=tipopessoa
							onchange="ocultarCNPJ();" disabled="disabled">
							<option value="">Selecione ...</option>
							<option value="fisica"
								${(parceiro.tipoDocumento == "CPF" ? 
								'selected' : '')}>Pessoa
								Fisica</option>
							<option value="juridica"
								${(parceiro.tipoDocumento == "CNPJ" ? 
								'selected' : '')}>Pessoa
								Juridica</option>
						</select>
					</div>
					<c:choose>
						<c:when test="${(parceiro.tipoDocumento == 'CPF')}">
							<div class="form-group col-md-5" id="fisica1"
								${(parceiro.tipoDocumento == "CPF" ? 
								'style="display: block;' : '')}>
								<label for="razaosocial">Nome Completo:</label> <input
									type="text" class="form-control" id="nomecompleto"
									value="${parceiro.razaosocial}" name="razaosocial"
									placeholder="Digite o nome" autofocus>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group col-md-5" id="jurudico2"
								${(parceiro.tipoDocumento == "CNPJ" ? 
								'' : 'style="display: none;"')}>
								<label for="razaosocial">Razão Social:</label> <input
									type="text" class="form-control" id="razaosocial"
									value="${parceiro.razaosocial}" name="razaosocial"
									placeholder="Digite a razao social" autofocus>
							</div>
							<div class="form-group col-md-5" id="jurudico1"
								${(parceiro.tipoDocumento == "CNPJ" ? 
								'' : 'style="display: none;"')}>
								<label for="nomefantasia">Nome Fantasia:</label> <input
									type="text" class="form-control" id="nomefantasia"
									value="${parceiro.nomefantasia}" name="nomefantasia"
									placeholder="Digite o nome" autofocus>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="form-group col-md-2">
						<label for="tipoDocumento">Tipo do Documento</label> <select
							class="form-control" name="tipoDocumento" id="tipoDocumento"
							onchange="mascaraRG();" disabled="disabled">
							<option value="${parceiro.tipoDocumento}" id="${parceiro.tipoDocumento}">${parceiro.tipoDocumento}</option>
						</select>
					</div>
					<div class="form-group col-md-3">
						<label for="documento">Número do Documento:</label> <input
							type="text" class="form-control" id="documento"
							value="${parceiro.documento}" name="documento" readonly="readonly"
							placeholder="Digite o documento">
					</div>
					<div class="form-group col-md-2">
						<label for="cep">CEP:</label> <input type="text"
							class="form-control" id="cep" name="cep" value="${parceiro.cep}"
							placeholder="Digite o cep" required autofocus>
					</div>
					<div class="form-group col-md-5">
						<label for="logradouro">Logradouro:</label> <input type="text"
							class="form-control" id="logradouro" value="${parceiro.logradouro}"
							name="logradouro" placeholder="Digite o logradouro" required
							autofocus>
					</div>
					<div class="form-group col-md-2">
						<label for="numero">Número:</label> <input type="text"
							class="form-control" id="numero" name="numero"
							value="${parceiro.numero}" placeholder="Digite o numero" required
							autofocus>
					</div>
					<div class="form-group col-md-4">
						<label for="complemento">Complemento:</label> <input type="text"
							class="form-control" id="complemento" name="complemento"
							value="${parceiro.complemento}" placeholder="Digite o complemento"
							autofocus>
					</div>
					<div class="form-group col-md-3">
						<label for="bairro">Bairro:</label> <input type="text"
							class="form-control" id="bairro" name="bairro"
							value="${parceiro.bairro}" placeholder="Digite o bairro" required
							autofocus>
					</div>

					<div class="form-group col-md-1">
						<label for="uf">UF:</label> <input type="text"
							class="form-control" id="uf" name="uf" value="${parceiro.uf}"
							placeholder="Digite o uf" required autofocus>
					</div>
					<div class="form-group col-md-2">
						<label for="cidade">Cidade:</label> <input type="text"
							class="form-control" id="cidade" name="cidade"
							value="${parceiro.cidade}" placeholder="Digite a cidade" required
							autofocus>
					</div>
					<div class="form-group col-md-2">
						<label for="telefone">Telefone:</label> <input type="text"
							class="form-control" id="telefone" name="telefone"
							value="${parceiro.telefone}" placeholder="Digite o telefone" required
							autofocus>
					</div>
					<div class="form-group col-md-4">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" name="email"
							value="${parceiro.email}" placeholder="Digite o E-mail" required
							autofocus>
					</div>
					<div class="form-group col-md-3">
						<label for="responsavel">Responsável:</label> <input type="text"
							class="form-control" id="responsavel" name="responsavel"
							value="${parceiro.responsavel}"
							placeholder="Digite o nome do responsavel" required autofocus>
					</div>
					<div class="form-group col-md-2">
						<label for="status">Status:</label> <select class="form-control"
							name="status" id=status required>
							<option value="">Selecione ...</option>
							<option value="INATIVO"
								${(parceiro.status == "INATIVO" ? 
								'selected' : '')}>Inativo</option>
							<option value="ATIVO"
								${(parceiro.status == "ATIVO" ? 
								'selected' : '')}>Ativo</option>
						</select>
					</div>
				</div>
				<!-- INICIO - Listagem dos USUARIOS VINCULADOS A PARCEIRO -->
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
				<!-- FIM - Listagem dos USUARIOS VINCULADOS A PARCEIRO -->
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
						<a href='<c:url value="/painel/parceiros/" />'
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