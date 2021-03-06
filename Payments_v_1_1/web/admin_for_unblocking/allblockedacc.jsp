<%-- 
    Document   : allblockedacc
    Created on : 01.03.2016, 21:06:46
    Author     : Evegen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accounts that have been blocked</title>
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

h2 {
  color: #e7e7e7;
  font-size: 24px;
  font-weight: 640;
  text-align: center;
  margin-bottom: 10px;
}

a {
  color: #e7e7e7;
  text-decoration: none;
  
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

.logout {
  position: absolute;
  top: 40%;
  right: 50%;
}

input[type="text"], input[type="password"] {
  width: 255px;
  padding: 25px 0px;
  background: transparent;
  border: 0;
  border-bottom: 1px solid rgba(255,255,255,0.04);
  outline: none;
  color: #e7e7e7;
}
input[type=checkbox] {
  display: none;
}

label {color:white;
  margin-top: 2px;
  width: 4px;
  height: 4px;
  border-radius: 50%;
  background: #46485c;
  content: "";
  display: block;
  position: absolute;
  transition: all 0.5s linear;
  cursor: pointer;
  border: 3px solid #252730;
  box-shadow: 0px 0px 0px 2px #46485c;
}

#remember:checked ~ label[for=remember] {
  background: #b5cd60;
  border: 3px solid #252730;
  box-shadow: 0px 0px 0px 2px #b5cd60;
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
input[type="green_button"] {
  background: #16aa56;
  border: 10;
  width: 150px;
  height: 30px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.4s linear;
}

.forgot {
  margin-top: 30px;
  display: block;
  font-size: 11px;
  text-align: center;
  font-weight: bold;
}
.forgot:hover {
  margin-top: 30px;
  display: block;
  font-size: 11px;
  text-align: center;
  font-weight: bold;
  color: #6d7781;
}

.remember {
  padding-right: 30px;
  font-size: 12px;
  text-indent: 25px;
  line-height: 15px;
  text-align: right
}

::-webkit-input-placeholder {
  color: #e7e7e7;
}

[placeholder]:focus::-webkit-input-placeholder {
  transition: all 0.3s linear;
  transform: translate(12px, 0);
  opacity: 0;
}

.createAcc {
  margin-top: 30px;
  display: block;
  font-size: 11px;
  text-align: center;
  font-weight: bold;
}
.createAcc:hover {
  margin-top: 30px;
  display: block;
  font-size: 11px;
  text-align: center;
  font-weight: bold;
  color: #6d7781;
}

</style>

    </head>
    <body>
        <a href="${pageContext.request.contextPath}/LogOut" class='remember'>Logout</a>
        
        <br />
        <h3>Blocked accounts</h3>
        <br />
        
        <table border="1">
            <th>Account number (id)</th>
            <th>Status</th>
            <c:forEach items="${requestScope.list}" var="account">
                <c:set var="accountID" value="${account.accountID}" />
                <c:set var="status" value="${account.status}" />
                <c:if test="${status == '2'}">
                    <c:set var="statusBL" value="blocked"></c:set>
                </c:if>
            <tr>
                <td>${accountID}</a>
                </td>
                <td><a href="${pageContext.request.contextPath}/UnblockAcc?accountID=${accountID}">
                        ${statusBL}</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
