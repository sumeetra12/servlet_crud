<%@ page import="com.example.servletcrud.entity.Departments" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/11/2022
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit - Departments</title>
</head>
<body>


    <form action="/departments" method="post">
        <%
            Departments departments = (Departments) request.getAttribute("oneDepartment");
        %>
        <input type="hidden" name="id" value= "<%=departments.getId() %>"/><br>
        Enter Department Name : <input type="text" name="changename" value="<%= departments.getName() %>"/> <br>
        <input type="submit" name="operation" value="Update"/>
    </form>
</body>
</html>
