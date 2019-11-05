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
    <meta charset="UTF-8"/>
</head>
<body>
<script type="text/javascript">
    function goBack()
    {
        window.history.go(-1);
    }
</script>
${user}
${data}
<c:if test="${done == true}">
    <c:set var="user" value="${user}"></c:set>
        <c:set var="data" value="${data}"></c:set>
        <%
            request.setCharacterEncoding("UTF-8");
            String user = (String)pageContext.getAttribute("user");
            System.out.println(user);
            Cookie login = new Cookie("user",user);
            String data = (String)pageContext.getAttribute("data");

            System.out.println(data);
            if(data == "회원가입" || data == "로그인") {
                response.addCookie(login);
            }
            response.sendRedirect("boards");

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
