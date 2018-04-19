/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import bean.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author GiaHieu
 */
public class RecordDAO {

    public RecordDAO() {
    }
    
    public List<Records> showRecords(String records) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "select * from Records";
            if (records.length() > 0) {
                sql += " where Name like '%" + records + "%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Records> listRecords = new ArrayList<Records>();
            while (rs.next()) {
                String name = rs.getString("Name");
                String type = rs.getString("Type");
                String reason = rs.getString("Reason");
                String date = rs.getString("Date");
                Records record = new Records(name, type, reason, date);
                listRecords.add(record);
            }
            return listRecords;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public static void saveRecords(Records record) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://Personel-dientoan.mssql.somee.com;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "patrickphan18_SQLLogin_2", "dmkkev3zhi");
            String sql = "insert into Records values(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, record.getName());
            stm.setString(2, record.getType());
            stm.setString(3, record.getReason());
            stm.setString(4, record.getDate());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
