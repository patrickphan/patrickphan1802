/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import bean.*;
import java.sql.Statement;

/**
 *
 * @author GiaHieu
 */
public class DepartmentDAO {

    public DepartmentDAO() {
    }

    public List<Departments> showDeparts(String departs) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "select * from Departs";
            if (departs.length() > 0) {
                sql += " where Id like '%" + departs + "%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Departments> listDeparts = new ArrayList<Departments>();
            while (rs.next()) {
                String id = rs.getString("Id");
                String name = rs.getString("Name");
                Departments depart = new Departments(id , name);
                listDeparts.add(depart);
            }
            return listDeparts;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertDeparts(Departments depart) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "insert into Departs values(?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, depart.getId());
            stm.setString(2, depart.getName());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteDeparts(Departments depart) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "delete from Departs where Id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, depart.getId());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateDeparts(Departments depart) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "Update Departs set Id = ? , Name = ? where Id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, depart.getId());
            stm.setString(2, depart.getName());
            stm.setString(3, depart.getId());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
