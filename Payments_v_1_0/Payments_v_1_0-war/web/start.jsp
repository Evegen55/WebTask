<%-- 
    Document   : start
    Created on : 18.02.2016, 11:25:31
    Author     : Lartsev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
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
  width: 250px;
  position: absolute;
  top: 40%;
  left: 50%;
  margin: -184px 0px 0px -155px;
  background: rgba(0,0,0,0.2);
  padding: 20px 30px;
  border-radius: 5px;
  box-shadow: 0px 1px 0px rgba(0,0,0,0.3),inset 0px 1px 0px rgba(255,255,255,0.07)
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
  width: 250px;
  height: 40px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.4s linear;
}
input[type="submit"]:hover {

  background: #16bb59;
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
  padding: 30px 0px;
  font-size: 12px;
  text-indent: 25px;
  line-height: 15px;
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
        <a href="GetLogPage">Logout</a>
        
        <table border="1">
            <td><a href="start.jsp">Client info</a></td>
            <td><a href="./ALLCards">Client info</a></td>
        </table>
        <br />
        
        <form action="./ClientServlet" method="POST">
            <table>
                <tr>
                    <td>Primary account number:</td>
                    <td><input type="text" name="id" value="${creditCards.pan}"</td>
                </tr>
                <tr>
                    <td>Card security code:</td>
                    <td><input type="text" name="id" value="${creditCards.card_sec_code}"</td>
                </tr>
                <tr>
                    <td>Valid thru:</td>
                    <td><input type="text" name="id" value="${creditCards.valid_date}"</td>
                </tr>
                <tr>
                    <td>Status:</td>
                    <td><input type="text" name="id" value="${creditCards.status}"</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="operation" value="Add" />
                        <input type="submit" name="operation" value="Edit" />
                        <input type="submit" name="operation" value="Delete" />
                        <input type="submit" name="operation" value="Search" />
                </tr>
            </table>
        </form>
    </body>
</html>
