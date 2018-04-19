/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Departments;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bean.*;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

/**
 *
 * @author GiaHieu
 */
public class StaffDAO {

    public StaffDAO() {
    }

    public List<Staffs> showStaffs(String staffs) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "select * from Staffs";
            if (staffs.length() > 0) {
                sql += " where StaffId like '%" + staffs + "%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Staffs> listStaffs = new ArrayList<Staffs>();
            while (rs.next()) {
                String id = rs.getString("StaffId");
                String name = rs.getString("Name");
                String gender = rs.getString("Gender");
                String birthday = rs.getString("BirthDay");
                String photo = rs.getString("Photo");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                String salary = rs.getString("Salary");
                String notes = rs.getString("Notes");
                String departid = rs.getString("DepartId");
                String level = rs.getString("Levell");
                Staffs staff = new Staffs(id, name, gender, birthday, photo, email, phone, salary, notes, departid, level);
                listStaffs.add(staff);
            }
            return listStaffs;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertStaffs(Staffs staff) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "insert into Staffs values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, staff.getId());
            stm.setString(2, staff.getName());
            stm.setString(3, staff.getGender());
            stm.setString(4, staff.getBirthday());
            stm.setString(5, staff.getPhoto());
            stm.setString(6, staff.getEmail());
            stm.setString(7, staff.getPhone());
            stm.setString(8, staff.getSalary());
            stm.setString(9, staff.getNotes());
            stm.setString(10, staff.getDepartid());
            stm.setString(11, staff.getLevel());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateStaffs(Staffs staff) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "Update Staffs set StaffId = ? , Name = ? , Gender = ? ,BirthDay = ? , Photo = ? ,"
                    + "Email = ? , Phone = ? , Salary = ? , Notes = ? , DepartId = ? , Levell = ? where StaffId = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, staff.getId());
            stm.setString(2, staff.getName());
            stm.setString(3, staff.getGender());
            stm.setString(4, staff.getBirthday());
            stm.setString(5, staff.getPhoto());
            stm.setString(6, staff.getEmail());
            stm.setString(7, staff.getPhone());
            stm.setString(8, staff.getSalary());
            stm.setString(9, staff.getNotes());
            stm.setString(10, staff.getDepartid());
            stm.setString(11, staff.getLevel());
            stm.setString(12, staff.getId());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStaffs(Staffs staff) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "delete from Staffs where StaffId = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, staff.getId());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Staffs> showStaffName(Staffs staff) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "select * from Staffs where DepartId = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, staff.getDepartid());
            ResultSet rs = stm.executeQuery();
            List<Staffs> listStaffs = new ArrayList<Staffs>();
            while (rs.next()) {
                String name = rs.getString("Name");
                Staffs stf = new Staffs(name);
                listStaffs.add(stf);
            }
            return listStaffs;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Staffs> showStaffInfo(Staffs staffs) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "select * from Staffs where Name = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, staffs.getName());
            ResultSet rs = stm.executeQuery();
            List<Staffs> listStaffs = new ArrayList<Staffs>();
            while (rs.next()) {
                String id = rs.getString("StaffId");
                String name = rs.getString("Name");
                String gender = rs.getString("Gender");
                String birthday = rs.getString("BirthDay");
                String photo = rs.getString("Photo");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                String salary = rs.getString("Salary");
                String notes = rs.getString("Notes");
                String departid = rs.getString("DepartId");
                String level = rs.getString("Levell");
                Staffs staff = new Staffs(id, name, gender, birthday, photo, email, phone, salary, notes, departid, level);
                listStaffs.add(staff);
                System.out.println(staff);
            }
            return listStaffs;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
