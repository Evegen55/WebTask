<%-- 
    Document   : start
    Created on : 20.02.2016, 13:21:01
    Author     : Lartsev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty pageContext.request.userPrincipal}">
                <c:redirect url="DispatherAccounts" />
            </c:when>
            <c:otherwise>
                <c:redirect url="other_errors.jsp" />
            </c:otherwise>
        </c:choose>
    </body>
</html>
