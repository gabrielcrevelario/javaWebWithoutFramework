<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/css/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="formUser">
<form action="index" method="post">
<h2>Cadastro de Usuario</h2>
<label>Nome</label>
	<input type="text"  name="nome" id="nome" value="${user.nome}"/>
<label>Sobrenome</label>
	<input type="text"  name="sobrenome"  id="sobrenome"value="${user.sobrenome}"/>
<label>Email</label>
	<input type="text"  name="email"  id="email" value="${user.email}"/>
<label>Senha</label>
	<input type="password" name="senha" id="senha"  value="${user.senha}"/>
	<input class="buttonSubmit" type="submit" value="cadastrar">
</form>

</div>
<table style="margin-top: -21%;">
<thead>
		<td >nome</td>
		<td>sobrenome</td>
		<td>email</td>
		<td>senha</td>
			<td>Actions</td>
</thead>
<tbody>
<c:forEach items="${listUser}" var="item">
	<tr>		
		<td>${item.nome}</td>
		<td>${item.sobrenome}</td>
		<td>${item.email}</td>
		<td>${item.senha}</td>	
		<td style="background:white"><button style="background: red; border: solid 1px red;border-radius: 3px;width: 45%;"><a  href="index?action=delete&id=${item.id}">X</a></button> 
		<button style="background: orange; border: solid 1px orange;border-radius: 3px;width: 45%;"><a   href="updateUser?action=update&id=${item.id}">E</a></button>
	</tr>
	</c:forEach>
</tbody>
</table>

</body>
</html>