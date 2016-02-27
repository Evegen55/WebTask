<%-- 
    Document   : account_info
    Created on : 24.02.2016, 17:34:40
    Author     : Evegen
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
input[type="submit"] {
  background: #16aa56;
  border: 10;
  width: 150px;
  height: 30px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.4s linear;
}
.login {
  width: 150px;
  position: absolute;
  top: 40%;
  left: 50%;
  margin: -184px 0px 0px -155px;
  background: rgba(0,0,0,0.2);
  padding: 30px 30px;
  border-radius: 5px;
  box-shadow: 0px 1px 0px rgba(0,0,0,0.3),inset 0px 1px 0px rgba(255,255,255,0.07)
}
</style>
    </head>
        <body>
        
        <a href="start.jsp" class='remember'>Start page</a>
        <a href="LogOut" class='remember'>Logout</a>
        
        <br />
        <h3>Info about bank account</h3>
        <br />
        
        <%-- Just as example using JSTL--%>
        <c:set var="accountID" value="${requestScope.bankAccount.accountID}" />
        <c:set var="currentBalance" value="${requestScope.bankAccount.currentBalance}" />
        <c:set var="status" value="${requestScope.bankAccount.status}" />
        <c:if test="${status == '1'}">
            <c:set var="statusBL" value="unblocked"></c:set>
        </c:if>
        <c:if test="${status == '2'}">
            <c:set var="statusBL" value="blocked"></c:set>
        </c:if>
                   
        <%--  --%>
        
        <table border="1">
            <th>accountID</th>
            <th>currentBalance</th>
            <th>Status</th>
            <tr>
                <td>${accountID}</a</td>
                <td>${currentBalance}</td>
                <td>${statusBL}</td>
            </tr>
        </table>
            <form action="./DispatcherServlet?accountID=${accountID}" method="POST">
                <input type="submit" name="operation" value="add funds" />
                <input type="submit" name="operation" value="make payment"/>
                <input type="submit" name="operation" value="block account"/>
            </form>
    </body>
</html>
