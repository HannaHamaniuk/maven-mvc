<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--для подключения библиотеки --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Country info: </h1>
<c:choose>
<c:when test="${not empty country}">
<p> Id: ${country.id} </p>
<p> Name: ${country.name} </p>
<p> Capital: ${country.capital} </p>
<p> President: ${country.president} </p>
<p> Population: ${country.population} </p>
</c:when>
<c:otherwise>
<p>${message}</p>
</c:otherwise>
</c:choose>
</body>
</html>