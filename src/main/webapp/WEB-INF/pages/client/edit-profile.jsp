<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 21.05.2015
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit profile</title>
</head>
<body>
  <h2>Edit profile</h2>
  <%
    String username = (String)request.getAttribute("username");
    String phone = (String)request.getAttribute("phone");
  %>
  <h5><%=username%></h5>
  <h5><%=phone%></h5>
</body>
</html>
