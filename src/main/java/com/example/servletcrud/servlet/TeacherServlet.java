package com.example.servletcrud.servlet;

import com.example.servletcrud.dao.DepartmentsDao;
import com.example.servletcrud.dao.TeachersDao;
import com.example.servletcrud.entity.Departments;
import com.example.servletcrud.entity.Teachers;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="TeacherServlet", urlPatterns = { "/teachers" })
public class TeacherServlet extends HttpServlet {

    private TeachersDao teachersDao = new TeachersDao();

    private DepartmentsDao departmentsDao = new DepartmentsDao();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String path = "WEB-INF/pages/teachers/teachers.jsp";

        if(action == null){
            path = "WEB-INF/pages/teachers/teachers.jsp";
            try {
                List<Teachers> allTeachers = teachersDao.getAll();
                //list
                request.setAttribute("teachers", allTeachers);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }else if(action.equals("add")){
            path = "WEB-INF/pages/teachers/add_details.jsp";
            try{
                List<Departments> allDepartments = departmentsDao.getAll();
                request.setAttribute("departments", allDepartments);

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(action.equals("edit")){
            path = "WEB-INF/pages/teachers/edit_details.jsp";
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                List<Departments> allDepartments = departmentsDao.getAll();
                request.setAttribute("departments", allDepartments);
                Teachers oneTeacher = teachersDao.getOne(id);
                request.setAttribute("teachers", oneTeacher);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else if(action.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                teachersDao.deleteData(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/teachers");
            return;
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");

        if(operation.equals("Add")){
            String name = request.getParameter("name");
            String contact = request.getParameter("contact");
            int departno = Integer.parseInt(request.getParameter("departments"));
            try {
                teachersDao.insertData(name, contact, departno);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(operation.equals("Update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("changename");
            String contact = request.getParameter("changeContact");
            int departno = Integer.parseInt(request.getParameter("changeDepartment"));
            try {
                teachersDao.updateData(id, name, contact, departno);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/teachers");
    }

}
