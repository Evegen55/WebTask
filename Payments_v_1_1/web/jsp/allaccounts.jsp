<%-- 
    Document   : allaccounts
    Created on : 24.02.2016, 3:31:07
    Author     : Evegen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All uccounts</title>
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
        <h3>My bank accounts</h3>
        <br />
        
        <table border="1">
            <th>Account number (id)</th>
            <th>Balance</th>
            <th>Status</th>
            <c:forEach items="${requestScope.list}" var="account">
                <c:set var="accountID" value="${account.accountID}" />
                <c:set var="currentBalance" value="${account.currentBalance}" />
                <c:set var="status" value="${account.status}" />
                <c:if test="${status == '1'}">
                    <c:set var="statusBL" value="unblocked"></c:set>
                </c:if>
                <c:if test="${status == '2'}">
                    <c:set var="statusBL" value="blocked"></c:set>
                </c:if>
            <tr>
                <td><a href="${pageContext.request.contextPath}/GetAccount?accountID=${accountID}">
                    ${accountID}</a>
                </td>
                <td>${currentBalance}</td>
                <td>${statusBL}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
