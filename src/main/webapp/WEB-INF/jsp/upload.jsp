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
    <title>글쓰기</title>
    <%
        String user = null;
        Cookie[] cookies = request.getCookies();
        for(int i =0;i<cookies.length;i++)
        {
            if(cookies[i].getName().equals("user"))
            {
                user = cookies[i].getValue();
            }
        }

        if(user == null)
        {

            response.sendRedirect("login");
        }
    %>
</head>
<body>
<h2>글쓰기</h2>
<form method="post" action="/update">
    <br>
    작성자:<input type="text" name ="author" readonly="readonly" value=<%=user%> /><br>
    제목:<input type= name="title" size = 10/><br>
    내용:<input type="text" name="main" /><br>

    <input type="submit" value="확인"/><br>
    <input type="reset" value="취소"/><br>
</form>
</body>
</html>
