<%-- 
    Document   : allcards
    Created on : 20.02.2016, 15:32:17
    Author     : Lartsev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <a href="start.jsp" class='remember'>Start page</a>
        <a href="LogOut" class='remember'>Logout</a>
        
        <br />
        <h3>List of cards</h3>
        <br />
        <table border="1">
            <th>Primary account number</th>
            <th>Card security code</th>
            <th>Valid thru</th>
            <th>Status</th>
            <c:forEach items="${requestScope.list}" var="card">
            <tr>
                <td><a href="./GetCard?pan=${creditCards.pan}">${creditCards.pan}</a></td>
                <td>${creditCards.card_sec_code}</td>
                <td>${creditCards.valid_date}</td>
                <td>${creditCards.status}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
