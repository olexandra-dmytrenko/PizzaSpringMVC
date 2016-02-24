<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Spring MVC</title>
<title> JSP Page
</title>
</head>
<body>
<h4> Hello World! </h4>
<%--синтаксис Expression Language (EL) - ${visitorCount} для вывода значения переменной модели, которую мы установили в контроллере --%>
Поздравляем, вы можете съесть <b>${pizzas}</b> <br/>
<% <c:forEach var pizzas %>

<form action="addNew" method = "post">
<input type = "hidden" name = "id" value="${pizza.id}">


</body>
</html>
