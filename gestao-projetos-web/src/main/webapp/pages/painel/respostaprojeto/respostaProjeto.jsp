<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		$("#menu-projetos").attr('class', 'active');
	});

	function popularCampos(){
		var idReeducando = $("#reeducando").val();
		var idProjeto = '<c:out value = "${questionario.projeto.id}"/>';
		var tipo = '<c:out value = "${status}"/>';
		console.info("idProjeto: "+idProjeto);
		
		var testeArray = new Array();
		var respostasArray = new Array();
		var respostaStatus = $("#respostaStatus").val();
		var respostas = $("input[name=respostas]");
		var alterarRespostas = $("input[name=respostaObjeto]");
		
		/* TESTANDO FUNCAO - POST - INICIO */
		$
				.post(
						"/gestao-projetos/painel/respostasprojeto/consultarReeducando?idReeducando="
								+ idReeducando + "&idProjeto=" + idProjeto + "&tipo=" + tipo,
								function(respostasReeducando) {	
									if (respostasReeducando.length > 0) {
										$(respostasReeducando).each(function(r){
											if(respostaStatus == "F"){
												//alert("Resposta Status é F !!!");
											}else if(respostaStatus == "S" || respostaStatus == ""){
											//for(var i = 0; i < respostas.length; i++){
												var idHidden = respostas[r].id;
												//console.info("respostas[i].id:" + respostas[r].id);
												//console.info("respostasReeducando[i].id:" + respostasReeducando[r].id);
												
												//console.info("respostas[r].id:" + respostas[r].id);
												//console.info("respostasReeducando[r].id:" + respostasReeducando[r].id);
											var id = idHidden.replace('idresposta','');
												console.info("id:" + id);
												var tipoPergunta = $("input[id=tipoPergunta"+id+"]").val();
												if(tipoPergunta == 1){
													var perguntarespostas = $("input[name=respostapergunta"+id+"]");
													var p = 0;
														for(p = 0; p < perguntarespostas.length; p++){
															$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas[p].value+"#"+respostasReeducando[r].id);
														}
												}else if(tipoPergunta == 2){
													var perguntarespostas = $("input[name=respostapergunta"+id+"]:checked");
														for(var p = 0; p < perguntarespostas.length; p++){
															$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas[p].value+"#"+respostasReeducando[r].id);
															console.info($("#"+idHidden).val());
														}
												}else if(tipoPergunta == 3){
													var perguntarespostas = $("textarea[name=respostapergunta"+id+"]");
													var p = 0;
														for(p = 0; p < perguntarespostas.length; p++){
															$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas[p].value+"#"+respostasReeducando[r].id);
														}
												}else if(tipoPergunta == 4){
													var perguntarespostas = $("input[type=radio][name=respostapergunta"+id+"]:checked").val();
													$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas+"#"+respostasReeducando[r].id);
												}
												
												
											//}
											
											$("#modalRespostaSalva").modal({
												keyboard : false,
												backdrop : 'static'
											});
										}
											
										});
									}else{
										if(respostaStatus == "F"){
											//alert("Resposta Status é F !!!");
										}else if(respostaStatus == "S" || respostaStatus == ""){
										for(var i = 0; i < respostas.length; i++){
											var idHidden = respostas[i].id;
										var id = idHidden.replace('idresposta','');
											console.info("id:" + id);
											var tipoPergunta = $("input[id=tipoPergunta"+id+"]").val();
											if(tipoPergunta == 1){
												var perguntarespostas = $("input[name=respostapergunta"+id+"]");
												var p = 0;
													for(p = 0; p < perguntarespostas.length; p++){
														$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas[p].value+"#0");
													}
											}else if(tipoPergunta == 2){
												var perguntarespostas = $("input[name=respostapergunta"+id+"]:checked");
													for(var p = 0; p < perguntarespostas.length; p++){
														$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas[p].value+"#0");
														console.info($("#"+idHidden).val());
													}
											}else if(tipoPergunta == 3){
												var perguntarespostas = $("textarea[name=respostapergunta"+id+"]");
												var p = 0;
													for(p = 0; p < perguntarespostas.length; p++){
														$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas[p].value+"#0");
													}
											}else if(tipoPergunta == 4){
												var perguntarespostas = $("input[type=radio][name=respostapergunta"+id+"]:checked").val();
												$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas+"#0");
											}
											
											
										}
										
										$("#modalRespostaSalva").modal({
											keyboard : false,
											backdrop : 'static'
										});
									}
									
									}
								});
		
		/* TESTANDO FUNCAO - POST - FIM */
		
		
	}
	
	function submitForm(){
		$("#formResposta").submit();
	}
	
	function salvarForm(){
		var msg = "S";
		$("#respostaStatus").val(msg);
		submitForm();
	}
	
	function salvarFinalizarForm(){
		var msg = "F";
		$("#respostaStatus").val("F");
		submitForm();
	}
	
	function consultarReeducando() {
		var idReeducando = $("#reeducando").val();
		var idProjeto = '<c:out value = "${questionario.projeto.id}"/>';
		$("#idProjeto").val(idProjeto);
		var tipo = '<c:out value = "${status}"/>';
		$
				.post(
						"/gestao-projetos/painel/respostasprojeto/consultarReeducando?idReeducando="
								+ idReeducando + "&idProjeto=" + idProjeto + "&tipo=" + tipo,
						function(respostasReeducando) {
							if (respostasReeducando.length > 0) {
							$(respostasReeducando).each(function(r){
								if(respostasReeducando[r].pergunta.tipoPergunta.id == 1){
									$("#respostasunica"+respostasReeducando[r].pergunta.id).val(respostasReeducando[r].descricaoResposta);
									if(respostasReeducando[r].respostaStatus == "F"){
										$("#respostasunica"+respostasReeducando[r].pergunta.id).attr('readonly', true);
										$("#respostaStatus").val("F");
									}
								}else if(respostasReeducando[r].pergunta.tipoPergunta.id == 2){
									for(var a = 0; a < respostasReeducando[r].pergunta.alternativas.length; a++){
										if(respostasReeducando[r].pergunta.alternativas[a].descricaoAlternativa == respostasReeducando[r].descricaoResposta){
									$("#multipla"+respostasReeducando[r].pergunta.alternativas[a].id).attr("checked","checked");
										}
										if(respostasReeducando[r].respostaStatus == "F"){
											$("#multipla"+respostasReeducando[r].pergunta.alternativas[a].id).attr('disabled','disabled');
											$("#respostaStatus").val("F");
										}
									}
								}else if(respostasReeducando[r].pergunta.tipoPergunta.id == 3){
									$("#texto"+respostasReeducando[r].pergunta.id).html(respostasReeducando[r].descricaoResposta);
									if(respostasReeducando[r].respostaStatus == "F"){
										$("#texto"+respostasReeducando[r].pergunta.id).attr('readonly', true);
										$("#respostaStatus").val("F");
									}
								}else if(respostasReeducando[r].pergunta.tipoPergunta.id == 4){
									for(var a = 0; a < respostasReeducando[r].pergunta.alternativas.length; a++){
										if(respostasReeducando[r].pergunta.alternativas[a].descricaoAlternativa == respostasReeducando[r].descricaoResposta){
									$("#alternativa"+respostasReeducando[r].pergunta.alternativas[a].id).attr("checked","checked");
										}
										if(respostasReeducando[r].respostaStatus == "F"){
											$("#alternativa"+respostasReeducando[r].pergunta.alternativas[a].id).attr('disabled','disabled');
											$("#respostaStatus").val("F");
										}
									}
								}
							});
							} else {
								//alert("Que pena. Não temos uma lista de Reeducandos");
							}
						});
	}
</script>
</head>
<body>
<!-- MODAL RESPOSTA SALVA INICIO -->
	<div class="modal fade" id="modalRespostaSalva" tabindex="-1"
		role="dialog" data-backdrop="static" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">O que deseja fazer?</h4>
				</div>
				<div class="modal-body">
					<p>Escolha uma opção:</p>
				</div>
				<div class="modal-footer">
					<a onclick="salvarForm();"
						style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
						class="btn btn-default">Salvar Resposta</a> <a
						onclick="salvarFinalizarForm();"
						style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
						class="btn btn-default">Salvar e Finalizar Resposta</a>
				</div>
			</div>
		</div>
	</div>
	<!-- MODAL RESPOSTA SALVA FIM -->
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Resposta - Questionário Projeto:
				${questionario.projeto.nome}</h4>
			<hr />
			<div id="alertas"></div>
			<form
				action="/gestao-projetos/painel/respostasprojeto/salvarResposta"
				method="POST" role="form" id="formResposta">
				<div class="row">
					<div class="form-group col-md-offset-3 col-md-6">
						<label for="nome">Titulo do Questionário:</label> <input
							type="text" class="form-control" id="nome" name="nome"
							readonly="readonly" value="${questionario.descricao}"
							placeholder="Digite o nome" required autofocus>
					</div>
				</div>
				<div class="row">
					<input type="hidden" name="idProjeto" value="${questionario.projeto.id}">
					<input type="hidden" id="idResposta" name="idResposta" value="">
					<!-- Reeducando - Resposta - INICIO -->
						<div class="form-group col-md-4">
							<label for="reeducando">Reeducando:</label> <select
								id="reeducando" name="reeducando"
								class="form-control" onchange="consultarReeducando();" required>
								<option value="" label="Selecione..." />
								<c:if test="${not empty reeducandos}">
								<c:forEach var="reeducando" items="${reeducandos}">
										<option value="${reeducando.id}"
											label="${reeducando.nome}" />
								</c:forEach>
								</c:if>
							</select>
						</div>
				<!-- Reeducando - Resposta - FIM -->
					<input type="hidden" name="tipo" value="${status}">
					<input type="hidden" name="respostaObjeto" id="respostaObjeto" value="${respostas}">
					<input type="hidden" id="respostaStatus" name="respostaStatus" value="">
					<!-- forEach -->
					<c:forEach items="${questionario.perguntas}" var="pergunta" varStatus="index">
				<c:choose>
					<c:when test="${pergunta.tipoPergunta.descricao ne null or not empty pergunta.tipoPergunta.descricao}">
					<div>
						<div class="form-group col-md-12" style="margin-top: 10px;">
								<label for="nome">${index.index+1}): ${pergunta.descricaoPergunta}</label>
						</div>
						<c:if test="${pergunta.tipoPergunta.id eq 1}">
							<div class="form-group col-md-12">
								<label for="nome">RESPOSTA:</label> <input type="text"
							class="form-control" id="respostasunica${pergunta.id}" name="respostapergunta${pergunta.id}"
							placeholder="Digite a resposta" required autofocus>
							
							<input type="hidden" id="idresposta${pergunta.id}" name="respostas" value="${pergunta.id}#">
							<input type="hidden" name="tipoPergunta" id="tipoPergunta${pergunta.id}" value="${pergunta.tipoPergunta.id}">
							</div>
						</c:if>
						<c:if test="${pergunta.tipoPergunta.id eq 2}">
							<div class="col-md-12">
						  <label>RESPOSTA:</label>
						  <c:forEach items="${pergunta.alternativas}" var="alternativa">
						    <div class="input-group">
						      <span class="input-group-addon">
						        <input type="radio" name="respostapergunta${pergunta.id}" id="multipla${alternativa.id}" aria-label="..." value="${alternativa.descricaoAlternativa}" required>
						      </span>
						        <input type="text" class="form-control" id="" aria-label="..." value="${alternativa.descricaoAlternativa}" disabled>
						        
						    
						    </div><!-- /input-group -->
						  </c:forEach>
						    	<input type="hidden" name="respostas" id="idresposta${pergunta.id}" value="${pergunta.id}#">
						    	<input type="hidden" name="tipoPergunta" id="tipoPergunta${pergunta.id}" value="${pergunta.tipoPergunta.id}">
						  </div><!-- /.col-lg-6 -->
						</c:if>
						
						<c:if test="${pergunta.tipoPergunta.id eq 3}">
							<div class="form-group col-md-12">
								<label>RESPOSTA:</label> <textarea
								class="form-control"
								placeholder="Digite uma Resposta" cols="10" rows="5" id="texto${pergunta.id}" name="respostapergunta${pergunta.id}" required></textarea>
								<input type="hidden" name="respostas" id="idresposta${pergunta.id}" value="${pergunta.id}#">
								<input type="hidden" name="tipoPergunta" id="tipoPergunta${pergunta.id}" value="${pergunta.tipoPergunta.id}">
							</div>
						</c:if>
						<c:if test="${pergunta.tipoPergunta.id eq 4}">
							<div class="form-group col-md-12">
									 <div class="radio">
									<label>Responda: </label> 
									<c:forEach items="${pergunta.alternativas}" var="alternativa">
										<label><input
										type="radio" id="alternativa${alternativa.id}" name="respostapergunta${pergunta.id}" value="${alternativa.descricaoAlternativa}" required>${alternativa.descricaoAlternativa}</label>
									</c:forEach>
										<input type="hidden" name="respostas" id="idresposta${pergunta.id}" value="${pergunta.id}#">
										<input type="hidden" name="tipoPergunta" id="tipoPergunta${pergunta.id}" value="${pergunta.tipoPergunta.id}">
								</div>
							</div>
						</c:if>
							</div>				
					</c:when>
					<c:otherwise>
						<h1>TEMOS UM PROBLEMA</h1>
					</c:otherwise>
				</c:choose>
						
					</c:forEach>
					<!-- forEach - FIM -->
				</div>
				<hr />
				<div class="form-group col-xs-offset-0">
					<a href='<c:url value="/painel/" />'
						style="float: left; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
						class="btn btn-default">Cancelar</a>
					<button type="button" onclick="popularCampos();"
						style="float: right; background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
						class="btn btn-default">Salvar Resposta</button>
				</div>
			</form>
		</div>
	</div>
	</div>
	<div class="section" style="margin-top:20px">
    </div>
</body>
</html>