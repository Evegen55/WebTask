<%-- 
    Document   : allcards
    Created on : 20.02.2016, 15:32:17
    Author     : Lartsev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style rel="stylesheet" type="text/css">
            
body {
 background:url(http://hdwallpapersfit.com/wp-content/uploads/2015/05/fall-leaves-hd-wallpaper.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  color: #e7e7e7;
  font-family: sans-serif;
}
a {
  color: #e7e7e7;
  text-decoration: none;
  
}
.remember {
  padding-right: 30px;
  font-size: 12px;
  text-indent: 25px;
  line-height: 15px;
  text-align: right
}
</style>
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
                <td><a href="${pageContext.request.contextPath}/GetCard?cardID=${card.cardID}">${card.pan}</a></td>
                <td>${card.secureCode}</td>
                <td>${card.validDate}</td>
                <td>${card.status}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
