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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzas List</title>
    </head>
    <body>
${name}
        <table border="1">
            <thead><tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                </tr></thead>

            <c:forEach var="pizza" items="${pizzas}">
                <tr>
                    <td>${pizza.id}</td>
                    <td>${pizza.name}</td>
                    <td>${pizza.pizzaType}</td>
                    <td>
                        <form method="get" action="edit" >
                            <input type="hidden" name="pizzaid" value="${pizza.id}" />
                            <input type="submit" value="Edit" />
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="create"> Create new pizza </a> <br/>
</body>
</html>
