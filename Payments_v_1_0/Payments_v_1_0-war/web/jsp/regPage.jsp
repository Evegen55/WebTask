<%-- 
    Document   : regisrationForm
    Created on : 18.02.2016, 17:42:20
    Author     : Lartsev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style rel="stylesheet">
            
@import "http://gabrielmedina.eti.br/codepen/font-awesome/css/font-awesome.min.css";

*, *::before, *::after{
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  -o-box-sizing: border-box;
}

.clearfix:before,
.clearfix:after {
  content: "";
  display: table;
}

.clearfix {
  *zoom: 1;
}

.clearfix:after {
  clear: both;
}

/* ---------------------- */

body {
background:url(http://hdwallpapersfit.com/wp-content/uploads/2015/05/fall-leaves-hd-wallpaper.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  font-family: 'Open Sans', sans-serif;
  font-size: 10px;
}

.grid {
  width: 300px;
}

#des {
  position: absolute;
  top: 40%;
  left: 50%;
  margin: -175px 0 0 -150px;
  background: rgba(0,0,0,0.13);
  box-shadow: 0px 1px 0px rgba(0,0,0,0.3),inset 0px 1px 0px rgba(255,255,255,0.04);
  padding: 20px 30px;
  border-radius: 5px;

}

#des header {
  color: #fff;
  font-family:comic sans ms;
  text-align: center;
  padding: 10px 13px 15px;
  background-color: skyblue;
  background: rgba(0,0,0,0.13);
  box-shadow: 0px 1px 0px rgba(0,0,0,0.6),inset 0px 1px 0px rgba(255,255,255,0.08)
}

#des header i {
  font-size: 6em;
}

#des h1 {
  font-size: 2.2em;
  margin: 10px 0 0;
}

#des form {
  padding: 14px 0;
  box-shadow: 0px 1px 0px rgba(0,0,0,0.5),inset 0px 1px 0px rgba(255,255,155,0.04)
}

#des form input {
  font-family: 'Open Sans', sans-serif;
}

.field-container,
.controls-container {
  position: relative;
  width: 90%;
  margin: 0 auto;
}

.field-container {
  margin-bottom: 10px;
}

.field-container label {
  display: none;
}

.field-container input {
  display: block;
  width: 100%;
  font:500 17px helvetica;
  color: white;
  background:transparent;
  padding: 13px;
  border: 0;
  border-radius: 6px;
  box-shadow: 0 1px 2px -1px rgba(0,0,0,.7);
  outline: none;
}

::-webkit-input-placeholder { /* WebKit, Blink, Edge */
    color:    white;
}
:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
   color:      white;
   opacity:  1;
}
::-moz-placeholder { /* Mozilla Firefox 19+ */
   color:      white;
   opacity:  1;
}
:-ms-input-placeholder { /* Internet Explorer 10-11 */
   color:    white;
}


.field-container i {
  position: absolute;
  font-size: 1.4em;
  color: #6ACAC3;
  top: 16px;
  right: 15px;
  transition: color .4s ease;
}

.field-container input:focus:invalid ~ i {
  color: #666;
}

.field-container input:focus:valid ~ i {
  color: #6ACAC3;
}

.controls-container input {
  position: relative;
  display: block;
  width: 100%;
  color: #fff;
  font-size: 1.4em;
  font-weight: 600;
  padding: 12px;
  border: 0;
  border-radius: 2px;
  background-color: #6ACAC3;
  box-shadow: 0 3px 1px -2px rgba(0, 0, 0, .3);
  transition: opacity .4s ease;
  cursor: pointer;
}

.controls-container input:hover,
.controls-container input:focus {
  opacity: .8;
}

.controls-container input:active {
  box-shadow: none;
  top: 1px;
}
</style>
    </head>
    <body>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css' />
        <section id="des" class="grid clearfix">
            <header>
                <i class="icon-rocket"></i>
                <h1>Signup here</h1>
            </header>
            
            <form action="SimpleControllerReg" method="post">
                <div class="field-container">
                    <label>First Name</label>
                    <input type="text" placeholder="First Name" pattern=".{4,}" required />
                    <i class="icon-user"></i>
                </div>
                
                <div class="field-container">
                    <label>Last Name</label>
                    <input type="text" placeholder="Last Name" pattern=".{4,}" required />
                    <i class="icon-user"></i>
                </div>
                
                <div class="field-container">
                    <label>Email:</label>
                    <input type="email" placeholder="Email" required />
                    <i class="icon-envelope-alt"></i>
                </div>
                
                <div class="field-container">
                    <label>Password:</label>
                    <input type="text" placeholder="Password" pattern=".{4,}" required />
                    <i class="icon-user"></i>
                </div>
                
                <div class="controls-container">
                    <input type="submit" value="Signup" />
                </div>
            </form>
        </section>
    </body>
</html>
