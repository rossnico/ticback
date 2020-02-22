<%--
  Created by IntelliJ IDEA.
  User: adaml
  Date: 2020/2/20
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AccountServiceTest</title>
</head>
<body>
<form action="/user/registerInfo" method="post">
    *Username:<br>
    <input type="text" name="username"><br>
    *Password:<br>
    <input type="password" name="password"><br>
    *Comfirm your password:<br>
    <input type="password" name="confirmpassword"><br>
    *Email:<br>
    <input type="text" name="email"><br><br>
    <input type="submit" value="Register" /><br />
</form>

</body>
</html>
