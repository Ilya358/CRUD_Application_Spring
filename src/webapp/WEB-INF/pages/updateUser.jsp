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
    <title>Update User</title>
</head>
<body>
<a href="/logout">Logout</a>
<center>
    <h1>
        <a href="/admin/addUser">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/admin/userList">Users List</a>
    </h1>
</center>
<div align="center">
    <h2>Update User</h2>
    <form:form action="save" method="post" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <th>ID: </th>
                <td>${user.id}
                    <form:hidden path="id" />
                </td>
            </tr>
            <tr>
                <th>Name: </th>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <th>Password: </th>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <th>Surname: </th>
                <td><form:input path="surName" /></td>
            </tr>
            <tr>
                <th>E-mail: </th>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Role: </td>
                <td>
                    <input  type="checkbox" name="role" value="ROLE_ADMIN" > Admin
                    <input  type="checkbox" name="role" value="ROLE_USER"> User
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
