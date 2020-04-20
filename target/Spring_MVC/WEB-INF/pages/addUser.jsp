<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 18.04.2020
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New User</title>
</head>
<body>
<center>
    <h1>
        <a href="/addUser">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/userList">Users List</a>

    </h1>
</center>
<div align="center">
    <h2>New User</h2>
    <form:form action="submit" method="post" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>SurName: </td>
                <td><form:input path="surName" /></td>
            </tr>
            <tr>
                <td>E-mail: </td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
