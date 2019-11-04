<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kdh_2
  Date: 2019-11-02
  Time: 오후 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Href</title>
</head>
<body>
done!!!
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
        <c:forEach items="${list}" var="data">
            <td>${data}</td>
        </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
