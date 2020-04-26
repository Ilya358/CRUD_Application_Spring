<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 23.04.2020
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User</title>
</head>
<body>
<a href="/logout">Logout</a>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Name</th>
            <th>Password</th>
            <th>Surname</th>
            <th>E-mail</th>
            <th>Role</th>
        </tr>
            <tr>
                <td><sec:authentication property="principal.name" /></td>
                <td><sec:authentication property="principal.password" /></td>
                <td><sec:authentication property="principal.surName" /></td>
                <td><sec:authentication property="principal.email" /></td>
                <td><sec:authentication property="principal.authorities" var="authorities" />
                    <c:forEach items="${authorities}" var="authority" varStatus="vs">
                        ${authority.authority}
                    </c:forEach></td>
            </tr>
    </table>
</div>
</body>
</html>
