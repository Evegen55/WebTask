<%-- 
    Document   : payments_history
    Created on : 24.02.2016, 13:31:54
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
</style>
    </head>
    <body>
        
        <a href="Start" class='remember'>Start page</a>
        <a href="LogOut" class='remember'>Logout</a>
        
        <br />
        <h3>My payments</h3>
        <br />
        <table border="1">
            <th>paymentID</th>
            <th>amount</th>
            <th>From(MyAccountID)</th>
            <th>To(beneficiarAccountID)</th>
            <th>Beneficiar(beneficiarClienstID)</th>
            <c:forEach items="${requestScope.list}" var="pay_hist">
            <tr>
                <td>${pay_hist.paymentID}</a></td>
                <td>${pay_hist.amount}</td>
                <td>${pay_hist.clientAccountID.accountID}</td>
                <td>${pay_hist.beneficiarAccountID.accountID}</td>
                <td>${pay_hist.beneficiarClienstID.clientID}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>