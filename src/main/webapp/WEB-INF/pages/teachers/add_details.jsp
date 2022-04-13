<%@ page import="com.example.servletcrud.entity.Departments" %>
<%@ page import="com.example.servletcrud.dao.DepartmentsDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <style>
        input[type=text], select {
            width: fit-content;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            background-color: skyblue;
        }

        input[type=submit] {
            width: fit-content;
            background-color: steelblue;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        form{
            border: 2px solid steelblue;
            width: fit-content;
            padding: 10px 20px;
        }

    </style>

</head>
<body>
    <h1>Add Teacher details:</h1><br>
    <form action="/teachers" method="post">
        Enter Name : <input type="text" name="name"/><br>
        Enter Contact : <input type="text" name="contact"/><br>
        Department :
        <select name = "departments" id = "departments">
       <% List<Departments> departments = (List<Departments>) request.getAttribute("departments");
       for(int i =0; i < departments.size(); i++){
       %>

                       <option value="<%=departments.get(i).getId() %>"> <%= departments.get(i).getName() %> </option>


        <% } %>
        </select>
        <br>
        <input type="submit" name="operation" value="Add"/>
    </form>
</body>
</body>
</body>
</html>
