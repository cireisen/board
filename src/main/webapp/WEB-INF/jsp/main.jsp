<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kdh_2
  Date: 2019-11-02
  Time: 오후 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/upload"> 글쓰기 </a>

<%
    /*
    String user;
    Cookie[] cookies = request.getCookies();
    if(cookies.length == 0)
    {
        response.sendRedirect("login");
    }
    for(int i =0;i<cookies.length;i++)
    {
        if(cookies[i].getName()=="user")
        {
            user = cookies[i].getValue();
        }
    }*/
%>
<script type="text/javascript">
    function goPage(data)
    {
        var form = document.createElement("form");
        form.action = "/display";
        form.id = data;
        form.method = "post";
        form.submit();
    }
</script>
<br>
<table border="1">
    <thead>
    <tr>
        <th>번호</th>
        <th width="300">제목</th>
        <th>작성자</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${value}" var="list">
        <tr>

            <c:forEach items="${list}" var="data" varStatus="status">

                <c:if test="${status.count==2}">
                        <td><a href="/boards/${list[0]}" > ${data} </a></td>
                </c:if>

                <c:if test="${status.count!=2}">
                    <td>${data}</td>
                </c:if>

            </c:forEach>

        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/hreftest"> hyperlink </a>
</body>
</html>
