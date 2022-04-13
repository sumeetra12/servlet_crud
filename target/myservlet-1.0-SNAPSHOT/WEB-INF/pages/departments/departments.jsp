<%@ page import="com.example.servletcrud.entity.Departments" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/8/2022
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Departments</title>
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
<h1>Welcome to Department Details!!</h1>
</h1><br>
<a href="/departments?action=add">
    Add</a>
<br>
<br>
<br>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Actions</th>
    </tr>

    <%
        List<Departments> departments = (List<Departments>) request.getAttribute("departments");
        for(int i = 0; i < departments.size(); i++) {
    %>
        <tr>
            <td><%=departments.get(i).getName()%></td>
            <td>
                <a href="/departments?action=edit&id=<%=departments.get(i).getId() %>">Edit</a>
                <a href="/departments?action=delete&id=<%=departments.get(i).getId() %>" onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
    <% } %>

</table>
</body>
</html>
