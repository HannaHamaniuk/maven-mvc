<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--для подключения библиотеки --%>
<html>
<head>
    <title>Countries</title>
</head>
<body>
<c:choose>

<c:when test="${not empty countries}">

<h2>Countries:</h2>
<c:forEach var="country" items="${countries}">
<p>Id: ${country.id}; Name: ${country.name}; Capital: ${country.capital}; President: ${country.president};
Population: ${country.population}</p>
</c:forEach>

</c:when>

<c:otherwise>
<p>${message}</p>
</c:otherwise>
</c:choose>
</body>
</html>