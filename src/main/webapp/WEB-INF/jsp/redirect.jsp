<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kdh_2
  Date: 2019-11-03
  Time: 오후 9:19
  To change this template use File | Settings | File Templatesㅇㅁ if문 어캐쓰지
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<script type="text/javascript">
    function goBack()
    {
        window.history.go(-2);
    }
</script>
<c:if test="${done == true}">
<%
    String user = (String)session.getAttribute("user");
    Cookie login = new Cookie("user",user);
    login.setPath("/");
    String data = (String)session.getAttribute("data");
    if(data == "회원가입" || data == "로그인") {

        response.addCookie(login);
    }
    response.sendRedirect("main");

%>
</c:if>
<c:if test="${done == false}">

    <script>
        alert('${data}에 실패하였습니다!');
        goBack();
    </script>
</c:if>
</body>
</html>
