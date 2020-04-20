<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 18.04.2020
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Users</title>
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
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>E-mail</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surName}</td>
                <td>${user.email}</td>
                <td>
                    <a href="/updateUser?id=${user.id}">Update</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/deleteUser?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
