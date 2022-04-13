package com.example.servletcrud.dao;

import com.example.servletcrud.database.DatabaseConnection;
import com.example.servletcrud.entity.Teachers;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeachersDao {

    DatabaseConnection db = new DatabaseConnection();


    public void insertData(String name, String contact, int departno) throws SQLException {

        this.db.connect();
        String sql = "INSERT INTO TEACHERS(NAME, CONTACT, DEPARTMENT_ID) VALUES(?,?,?)";
        PreparedStatement pstmt = db.con.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, contact);
        pstmt.setInt(3, departno);
        pstmt.executeUpdate();
        db.con.close();
    }

    public void updateData(int id, String name, String contact, int departno) throws SQLException {
        this.db.connect();
        String sql = "UPDATE TEACHERS SET NAME = ?, CONTACT = ?, DEPARTMENT_ID =? WHERE ID = ?";
        PreparedStatement pstmt = db.con.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, contact);
        pstmt.setInt(3, departno);
        pstmt.setInt(4, id);
        pstmt.executeUpdate();
        db.con.close();
    }

    public void deleteData(int id) throws SQLException {
        this.db.connect();
        String sql = "DELETE FROM TEACHERS WHERE ID=?";
        PreparedStatement pstmt = db.con.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        db.con.close();
    }

    public List<Teachers> getAll() throws SQLException {
        List<Teachers> teachers = new ArrayList<>();
        this.db.connect();

        String sql = "SELECT * FROM TEACHERS";

        DepartmentsDao departmentsDao = new DepartmentsDao();

        PreparedStatement pstmt = db.con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            Teachers teachers1 = new Teachers();
            teachers1.setId(rs.getInt("id"));
            teachers1.setName(rs.getString("name"));
            teachers1.setContact(rs.getString("contact"));
            teachers1.setDepartment(departmentsDao.getOne(rs.getInt("department_id")));
            teachers.add(teachers1);
        }
        this.db.con.close();

        return teachers;
    }

    public Teachers getOne(int id) throws SQLException {
        Teachers teachers = new Teachers();
        this.db.connect();

        String sql = "SELECT * FROM TEACHERS WHERE ID = ?";
        PreparedStatement pstmt = db.con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();

        DepartmentsDao departmentsDao = new DepartmentsDao();

        while(rs.next()){
            teachers.setId(rs.getInt("id"));
            teachers.setName(rs.getString("name"));
            teachers.setContact(rs.getString("contact"));
            teachers.setDepartment(departmentsDao.getOne(rs.getInt("department_id")));
        }

        return teachers;
    }
}
