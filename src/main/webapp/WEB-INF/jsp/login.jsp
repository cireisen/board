<%--
  Created by IntelliJ IDEA.
  User: kdh_2
  Date: 2019-11-04
  Time: 오후 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="/user">
    <br>
    아이디:<input type="text" name="id"/><br>
    비밀번호:<input type="password" name="password" /><br>
    <input type="submit" value="확인"/><br>
    <input type="reset" value="취소"/><br>
</form>
</body>
</html>
