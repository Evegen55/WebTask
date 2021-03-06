<%-- 
    Document   : cardinfo
    Created on : 24.02.2016, 3:12:30
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
        
        <a href="${pageContext.request.contextPath}/Start" class='remember'>Start page</a>
        <a href="${pageContext.request.contextPath}/LogOut" class='remember'>Logout</a>
        
        <br />
        <h3>Info about card</h3>
        <br />
        <table border="1">
            <th>Primary account number</th>
            <th>Card security code</th>
            <th>Valid thru</th>
            <th>Bank Account</th>
            <%--
            see how iterate ower list of cretit cards 
                on CreditCard.processRequest(...) commented lines
            
            <c:forEach items="${requestScope.list}" var="card">
            <tr>
                <td>${card.pan}</a></td>
                <td>${card.secureCode}</td>
                <td>${card.validDate}</td>
                <td>${card.accountID}</td>
            </tr>
            </c:forEach>
                Author     : Evegen
            --%>
            <tr>
                <td>${requestScope.creditCard.pan}</a></td>
                <td>${requestScope.creditCard.secureCode}</td>
                <td>${requestScope.creditCard.validDate}</td>
                <td><a href="${pageContext.request.contextPath}/GetAccount?accountID=${creditCard.accountID.accountID}">
                    ${requestScope.creditCard.accountID.accountID}
                </td> 
                <%--
                It seems like ${requestScope.creditCard.accountID.accountID} NOT 
                              ${requestScope.creditCard.accountID}
                because we've got a 
                                   @JoinColumn(name = "accountID", referencedColumnName = "accountID")
                                   @ManyToOne(optional = false)
                annotations in CreditCards class.
                --%>
            </tr>
        </table>
    </body>
</html>
<%--
TODO: create a single page about single card with bank account number 
with 1 button(?) 
with hyperlink 
to a jsp about single bank account number with 2 butons: 
to make a payment
//add funds
--%>