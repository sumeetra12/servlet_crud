<%@ page import="com.example.servletcrud.dao.TeachersDao" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLOutput" %>
<%@ page import="com.example.servletcrud.entity.Teachers" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/8/2022
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>teacher details</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
        }
    </style>
</head>
<body>
<h1>Welcome to teachers details!!
</h1><br>
    <a href="/teachers?action=add">
    Add</a>
<br>
<br>
<br>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Contact</th>
        <th>Department</th>
        <th>Actions</th>
    </tr>

    <%
        List<Teachers> teachers = (List<Teachers>) request.getAttribute("teachers");
        for(int i = 0; i < teachers.size(); i++){
    %>
        <tr>
            <td> <%= teachers.get(i).getName()%> </td>
            <td> <%= teachers.get(i).getContact()%> </td>
            <td> <%= teachers.get(i).getDepartment().getName()%> </td>
            <td>
                <a href="/teachers?action=edit&id=<%= teachers.get(i).getId() %>">Edit</a>
                <a href="/teachers?action=delete&id=<%= teachers.get(i).getId() %>">Delete</a>
            </td>
        </tr>
    <% } %>
</table>
</body>
</html>
