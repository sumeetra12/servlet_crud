package com.example.servletcrud.dao;


import com.example.servletcrud.database.DatabaseConnection;
import com.example.servletcrud.entity.Departments;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDao {

    DatabaseConnection db = new DatabaseConnection();

    public void insertData(String name) throws SQLException {
        this.db.connect();
        String sql = "INSERT INTO DEPARTMENTS(NAME) VALUES(?)";
        PreparedStatement pstmt = db.con.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.executeUpdate();
        db.con.close();
    }

    public void updateData(int id, String name) throws SQLException {
        this.db.connect();;
        String sql = "UPDATE DEPARTMENTS SET NAME = ? WHERE ID = ?";
        PreparedStatement pstmt = db.con.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
    }

    public void deleteData(int id) throws SQLException {
        this.db.connect();
        String query = "DELETE FROM TEACHERS WHERE DEPARTMENT_ID = ?";
        PreparedStatement stmt = db.con.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        String sql = "DELETE FROM DEPARTMENTS WHERE ID = ?";
        PreparedStatement pstmt = db.con.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();

    }

    public Departments getOne(int id) throws SQLException {
        Departments departments = new Departments();
        this.db.connect();

        String sql = "SELECT * FROM DEPARTMENTS WHERE ID=?";
        PreparedStatement pstmt = db.con.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            departments.setId(rs.getInt("id"));
            departments.setName(rs.getString("name"));
        }

        return departments;
    }

    public List<Departments> getAll() {
        List<Departments> departments = new ArrayList<>();
        this.db.connect();

        String sql = "SELECT * FROM DEPARTMENTS";
        try {
            PreparedStatement stmt = db.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Departments departments1 = new Departments();
                departments1.setId(rs.getInt("id"));
                departments1.setName(rs.getString("name"));
                departments.add(departments1);
            }

            this.db.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }
}
