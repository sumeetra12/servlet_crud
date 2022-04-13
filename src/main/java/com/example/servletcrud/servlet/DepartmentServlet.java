package com.example.servletcrud.servlet;

import com.example.servletcrud.dao.DepartmentsDao;
import com.example.servletcrud.database.DatabaseConnection;
import com.example.servletcrud.entity.Departments;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="Department", urlPatterns = {"/departments"})
public class DepartmentServlet extends HttpServlet {

    private DepartmentsDao departmentsDao = new DepartmentsDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "WEB-INF/pages/departments/departments.jsp" ;
        String action = request.getParameter("action");



        if(action == null){
            path = "WEB-INF/pages/departments/departments.jsp";
            List<Departments> allDepartments = departmentsDao.getAll();
            //list
            request.setAttribute("departments", allDepartments);

        }else if(action.equals("add")){
            path = "WEB-INF/pages/departments/add_details.jsp";

        }else if(action.equals("edit")){
            path = "WEB-INF/pages/departments/edit_details.jsp";
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                Departments oneDepartment = departmentsDao.getOne(id);
                request.setAttribute("oneDepartment", oneDepartment);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else if(action.equals("delete")){

            int id = Integer.parseInt(request.getParameter("id"));
            try {
                departmentsDao.deleteData(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/departments");
            return;
        }


    RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String operation = request.getParameter("operation");
        System.out.println(operation);
        if(operation.equals("Add")){
            String name = request.getParameter("name");
            try {
                departmentsDao.insertData(name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(operation.equals("Update")){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("changename");
            try {
                departmentsDao.updateData(id, name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/departments");
    }
}
