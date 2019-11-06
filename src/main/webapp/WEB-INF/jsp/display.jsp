<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kdh_2
  Date: 2019-11-04
  Time: 오후 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%

    String username = null;

    Cookie[] cookies = request.getCookies();
    for(int i = 0;i<cookies.length;i++)
    {
        if(cookies[i].getName().equals("user"))
        {
           username = cookies[i].getValue();
        }
    }
    if(username==null)
    {
        response.sendRedirect("login");
    }


%>
<head>
    <title>${board.getTitle()}</title>
</head>
<body>
<a href="/delete/<%=username%>&${board.getId()}")>글 삭제</a><br>
글쓴이 : ${board.getAuthor()}<br>
제목 : ${board.getTitle()}<br>
내용 : ${board.getMain()}<br>

</body>
</html>
