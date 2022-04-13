<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/10/2022
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add - Departments</title>
</head>
<body>
<h1>Add Departments:</h1><br>
<form action="/departments" method="post">
    Enter Department Name : <input type="text" name="name"/><br>
    <input type="submit" name="operation" value="Add"/>
</form>

</body>
</html>
