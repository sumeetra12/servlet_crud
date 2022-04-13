<%@ page import="com.example.servletcrud.entity.Teachers" %>
<%@ page import="com.example.servletcrud.entity.Departments" %>
<%@ page import="java.util.List" %><%--
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

    <form action="/teachers" method="post">
        <%
            Teachers teachers = (Teachers) request.getAttribute("teachers");
        %>
        <input type="hidden" name="id" value="<%= teachers.getId() %>"/><br>
        Enter Teachers Name : <input type="text" name="changename" value="<%= teachers.getName()%>"/> <br>
        Enter Contact :<input type="text" name="changeContact" value="<%= teachers.getContact() %>"/><br>
        Select Department :
        <select name="changeDepartment" id="changeDepartment">
            <% List<Departments> departments = (List<Departments>) request.getAttribute("departments");
                for(int i =0; i < departments.size(); i++){
            %>

            <option value="<%=departments.get(i).getId() %>" <% if(departments.get(i).getId() == teachers.getDepartment().getId()) { %> selected <% } %>> <%= departments.get(i).getName() %> </option>


            <% } %>
        </select>

        <input type="submit" name="operation" value="Update"/>
    </form>

</body>
</html>
