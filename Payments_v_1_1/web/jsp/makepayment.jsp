<%-- 
    Document   : makepayment
    Created on : 25.02.2016, 17:37:24
    Author     : Evegen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pay to somebody</title>
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
input[type="text"] {
  width: 200px;
  padding: 5px 0px;
  background:  transparent;
  border: 1;
  border-bottom: 1px solid rgba(255,255,255,0.04);
  border-radius: 3px;
  outline: none;
  color: #e7e7e7;
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
        <a href="${pageContext.request.contextPath}/PaymentsHist" class='remember'>Payment History</a>
        
        <br />
        <h3>Make Payment</h3>
        <br />
        <form action="${pageContext.request.contextPath}/MakePayment" method="POST">
            <table>
                <tr>
                    <td>MyAccountID:</td>
                    <td><input type="text" name="clientAccountID"/></td>
                </tr>
                <tr>
                    <td>Amount:</td>
                    <td><input type="text" name="payment"/></td>
                </tr>
                <tr>
                    <td>To other AccountID:</td>
                    <td><input type="text" name="beneficiarAccountID"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                    <input type="Submit" name="operation" value="Make a pay" />
                    </td>
                </tr>                
            </table>
        </form>
    </body>
</html>