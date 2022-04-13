<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/8/2022
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    <form action="/crud-operation" method="post">
        Enter Teachers Id : <input type="text" name="id"/><br>
        Enter Name : <input type="text" name="changename"/> <br>
        <input type="submit" name="operation" value="update"/>
    </form>

</body>
</html>
