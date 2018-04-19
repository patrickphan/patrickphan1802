/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author GiaHieu
 */
@Controller

public class LoginController {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstm;
    private String full;

    @RequestMapping("login")
    public String index() {
        return "login";
    }

    @RequestMapping(params = "btnLogin")
    public String Login(ModelMap model, @RequestParam("username") String username,
            @RequestParam("password") String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Personel";
            con = DriverManager.getConnection(url, "sa", "patrickphan18");
            String sql = "select * from Users where Username=? and Password=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if (rs.next()) {
                full = rs.getString(3);
                model.addAttribute("message", "Bạn đã đăng nhập thành công");
                model.addAttribute("fullname", full);
                return "admin/index";
            } else {
                model.addAttribute("message", "Bạn đã đăng nhập thất bại");
            }
            con.close();
            pstm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping("staff1")
    public String staff1(ModelMap model) {
        DepartmentDAO depart = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart.showDeparts("");
        model.addAttribute("listDp", list);

        StaffDAO staff = new StaffDAO();
        List<Staffs> list1 = new ArrayList<Staffs>();
        list1 = staff.showStaffs("");
        model.addAttribute("listStaff", list1);

        return "admin/managerstaff";
    }

    @RequestMapping("staff2")
    public String staff2(ModelMap model) {
        DepartmentDAO depart = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart.showDeparts("");
        model.addAttribute("listDp", list);
        return "admin/infostaff";
    }

    @RequestMapping("achive1")
    public String achie1(ModelMap model) {
        RecordDAO record = new RecordDAO();
        List<Records> list1 = new ArrayList<Records>();
        list1 = record.showRecords("");
        model.addAttribute("listRecord", list1);
        DepartmentDAO depart = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart.showDeparts("");
        model.addAttribute("listDp", list);
        return "admin/record";
    }

    @RequestMapping("achive2")
    public String achie2() {
        return "admin/achivestaff";
    }

    @RequestMapping("depart")
    public String depart(ModelMap model) {
        DepartmentDAO depart = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart.showDeparts("");
        model.addAttribute("listDepart", list);
        return "admin/department";

    }

    @RequestMapping("back")
    public String back(ModelMap model) {
        model.addAttribute("message", "Bạn đã đăng nhập thành công");
        model.addAttribute("fullname", full);
        return "admin/index";
    }

}
