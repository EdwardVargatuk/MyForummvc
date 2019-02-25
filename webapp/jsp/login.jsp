
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>

</head>
<body>

<div class="form-style-9">
    <h1><br/>Welcome! </h1>
    <ul>
        <form name="loginForm" method="POST" action="/login">
            <input type="hidden" name="command" value="login"/>
            <li>
                <label for="nameL">
                    <span>User name:  <br/></span>
                    <input class="field-style field-split align-left" placeholder="Name" type="text" id="nameL"
                           name="userName" value= ""/>
                </label>
            </li>
            <li>
                <label for="passwordL">
                    <span>   <br/>Password:<br/></span>
                    <input class="field-style field-split align-left" placeholder="Password" type="password"
                           id="passwordL" name="password" value= ""/>
                </label>
            </li>
            <br><br/>
            <%--<p style="color: red;">${errorString}</p>--%>
            <li style="color: red;">${errorLoginPassMessage}<br/></li>
            <li style="color: red;">${wrongAction}</li>
            <br/>
            <li style="color: red;">${nullPage}</li>
            <br/>
            <li>
                <input type="submit" value="Log in"/>
            </li>
        </form>
    </ul>
</div>



</body>
</html>
