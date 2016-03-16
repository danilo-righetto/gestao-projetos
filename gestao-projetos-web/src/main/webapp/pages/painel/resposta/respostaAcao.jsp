<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		$("#menu-usuarios").attr('class','active');
	});
	
	function popularCampos(){
		var respostas = $("input[name=respostas]");
		for(var i = 0; i < respostas.length; i++){
			var idHidden = respostas[i].id;
		var id = idHidden.replace('idresposta','');
			var tipoPergunta = $("input[id=tipoPergunta"+id+"]").val();
			if(tipoPergunta == 1){
				var perguntarespostas = $("input[name=respostapergunta"+id+"]");
				var p = 0;
					for(p = 0; p < perguntarespostas.length; p++){
						$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas[p].value);
					}
			}else if(tipoPergunta == 2){
				var perguntarespostas = $("input[name=respostapergunta"+id+"]:checked");
					for(var p = 0; p < perguntarespostas.length; p++){
						$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas[p].value+",");
						console.info($("#"+idHidden).val());
					}
			}else if(tipoPergunta == 3){
				var perguntarespostas = $("textarea[name=respostapergunta"+id+"]");
				var p = 0;
					for(p = 0; p < perguntarespostas.length; p++){
						$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas[p].value);
					}
			}else if(tipoPergunta == 4){
				var perguntarespostas = $("input[type=radio][name=respostapergunta"+id+"]:checked").val();
				$("#"+idHidden).val($("#"+idHidden).val()+perguntarespostas);
			}
			
			
		}
		$("#formResposta").submit();
		
	}
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 style="font-family: arial; color: #4DC1FF">Resposta Questionário Ação</h4>
			<hr />
			<div id="alertas"></div>
			<form action="salvarResposta" method="POST" role="form" id="formResposta">
			<div class="row">
							<div class="form-group col-md-offset-3 col-md-6">
								<label for="nome">Titulo do Questionário:</label> <input
									type="text" class="form-control" id="nome" name="nome"
									readonly="readonly" value="${questionario.descricao}"
									placeholder="Digite o nome" required autofocus>
							</div>
						</div>
				<div class="row">
				<input type="hidden" name="idAcao" value="${questionario.acao.id}">
				<!-- forEach -->
				<c:forEach items="${questionario.perguntas}" var="pergunta" varStatus="index">
				<c:choose>
					<c:when test="${pergunta.tipoPergunta.descricao ne null or not empty pergunta.tipoPergunta.descricao}">
					<div>
						<div class="form-group col-md-12" style="margin-top: 10px;">
								<label for="nome">${index.index+1}): ${pergunta.descricaoPerguntaAcao}</label>
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
						        <input type="checkbox" name="respostapergunta${pergunta.id}" id="multipla${pergunta.id}" aria-label="..." value="${alternativa.descricaoAlternativa}">
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
								class="form-control" id="descricao"
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
										type="radio" id="alternativa${alternativa.perguntaAcao.id}" name="respostapergunta${pergunta.id}" value="${alternativa.descricaoAlternativa}" required>${alternativa.descricaoAlternativa}</label>
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
					<a href='<c:url value="/painel/" />' style="float:left;background-color:#4DC1FF;color:#fff;border-color:#4DC1FF" class="btn btn-default">Cancelar</a>
					<button type="button" onclick="popularCampos();" style="float:right;background-color:#4DC1FF;color:#fff;border-color:#4DC1FF" class="btn btn-default">Salvar Resposta</button>
				</div>
			</form>
		</div>
	</div>
	<div class="section" style="margin-top:20px">
    </div>
</body>
</html>