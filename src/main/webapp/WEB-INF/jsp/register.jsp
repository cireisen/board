<%--
  Created by IntelliJ IDEA.
  User: kdh_2
  Date: 2019-11-03
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>회원가입</h2>
    <form method="post" action="/create">
        <br>
        이름:<input type="text" name="name"/><br>
        아이디:<input type="text" name="id" /><br>
        비밀번호:<input type="password" name="password"/><br>
        이메일:<input type="email" name="email"/><br>
    <input type="submit" value="확인"/><br>
    <input type="reset" value="취소"/><br>
    </form>
</body>
</html>
