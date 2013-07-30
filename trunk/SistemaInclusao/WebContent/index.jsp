<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de Inclusão</title>
<script language="JavaScript" >
	function enviardados(){
	
		if(document.formcadastro.nome.value=="" || document.formcadastro.nome.value.length < 8){
			alert( "Preencha o Nome corretamente!" );
			document.formcadastro.nome.focus();
			return false;
		}
		
		if(document.formcadastro.email.value==""){
			alert( "Preencha o Email!" );
			document.formcadastro.email.focus();
			return false;
		}
		
		if(document.formcadastro.idade.value==""){
			alert( "Preencha a Idade!" );
			document.formcadastro.idade.focus();
			return false;
		}
			
		if (document.formcadastro.cidade.value==""){
			alert( "Preencha a Cidade!" );
			document.formcadastro.cidade.focus();
			return false;
		}
	
	return true;
	}
</script>
</head>
<body>
	<h3>Cadastrar Pessoa:</h3>
	
	<form action="CadastrarPessoa" method="post" name="formcadastro" onsubmit="return enviardados();">
		Nome: <input type="text" name="nome" id="nome">
		<br/><br/>
		E-Mail: <input type="text" name="email" id="email">
		<br/><br/>
		Idade: <input type="text" name="idade" id="idade">
		<br/><br/>
		Cidade: <input type="text" name="cidade" id="cidade">
		<br/><br/>
		Estado: 
		<select name="estado">
			<option value="RJ">RJ</option>
			<option value="SP">SP</option>
			<option value="MG">MG</option>
			<option value="ES">ES</option>
		</select>
		<br/><br/>
		
		<input type="submit" value="Cadastrar Pessoa"/>

		<input type="hidden" name="q" value="cadastrar"/>
	</form>
	<br/><br/>

	${msg }
  <br/><br/>
	<a href="ListarPessoa?q=listar">Listar Pessoa</a>
</body>
</html>