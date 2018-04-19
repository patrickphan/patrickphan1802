

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String message = (String) request.getAttribute("message");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello , Please Login !</h1>
        <script type="text/javascript">
            var msg = "<%=message%>";
            alert(msg);
        </script>
        <form action="btnLogin.htm" method="post">
            <div>User name</div>
            <input type="text" name="username" value=""/>
            <div>Password</div>
            <input type="password" name="password" value=""/>
            <hr>
            <input type="submit" name="btnLogin" value="Login"/>
            
        </form>
    </body>
</html>
