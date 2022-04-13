<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/8/2022
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
    <h1>Add Teacher details:</h1><br>
    <form action="/crud-operation" method="post">
        Enter Name : <input type="text" name="name"/><br>
        Enter Contact : <input type="text" name="contact"/><br>
        Enter Department Id : <input type="text" name="department_id"/><br>
        <input type="submit" name="operation" value="add"/>
    </form>
</body>
</body>
</body>
</html>
