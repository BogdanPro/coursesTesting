<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 21.04.2015
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Cabiner</title>
</head>
<body>
  <h1>Cabinet</h1>

  <h3>Study materials</h3>
  <a href="https://dl.dropboxusercontent.com/u/28311951/Java/pdf/java-m1.pdf">Java Start</a>
  <a href="https://dl.dropboxusercontent.com/u/28311951/Java/pdf/java-m2.pdf">Java OOP</a>
  <a href="https://dl.dropboxusercontent.com/u/28311951/Java/pdf/java-m3.pdf">Java Pro</a>

  <%--<c:url value="/j_spring_security_logout" var="logoutUrl"/>--%>

  <%--<form action='${logoutUrl}'><input type="submit" class="btn btn-danger btn-mini" value="Logout"/></form>--%>

  <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>

  <sec:authorize access="hasRole('ROLE_ADMIN')">
    <table>
      <tr>
        <td><a href="/admin/clients/main">Clients</a></td>
        <td><a href="/admin/coaches/main">Coaches</a></td>
        <td><a href="/admin/groups/main"> Groups</a></td>
        <td><a href="/admin/courses/main">Courses</a></td>
        <td>Places</td>
      </tr>
    </table>
  </sec:authorize>
</body>
</html>
