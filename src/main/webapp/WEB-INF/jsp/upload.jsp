<%--
  Created by IntelliJ IDEA.
  User: kdh_2
  Date: 2019-11-04
  Time: 오후 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>글쓰기</h2>
<form method="post" action="/upload">
    <br>
    제목:<input type="text" name="name"/><br>
    내용:<input type="text" name="id" /><br>
    <input type="submit" value="확인"/><br>
    <input type="reset" value="취소"/><br>
</form>
</body>
</html>
