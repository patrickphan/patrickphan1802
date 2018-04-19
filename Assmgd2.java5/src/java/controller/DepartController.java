/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import bean.*;
import java.sql.DriverManager;
import model.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author GiaHieu
 */
@Controller
@RequestMapping("/show")
public class DepartController {

    @RequestMapping()
    public String showStaff1(Model model) {
        StaffDAO staff = new StaffDAO();
        List<Staffs> list1 = new ArrayList<Staffs>();
        list1 = staff.showStaffs("");
        model.addAttribute("listStaff", list1);
        return "admin/managerstaff";
    }

    @RequestMapping(params = "btnInsert")
    public String insert(ModelMap model, Departments departs,
            @RequestParam("id") String id,
            @RequestParam("name") String name) {
        DepartmentDAO dp = new DepartmentDAO();
        id = departs.getId();
        name = departs.getName();
        dp.insertDeparts(departs);
        model.addAttribute("message", "Bạn đã thêm phòng ban thành công ");
        List<Departments> list = new ArrayList<Departments>();
        list = dp.showDeparts("");
        model.addAttribute("listDepart", list);
        return "admin/department";
    }

    @RequestMapping(params = "btnDelete")
    public String delete(ModelMap model, Departments departs,
            @RequestParam("id") String id) {
        DepartmentDAO dp = new DepartmentDAO();
        id = departs.getId();
        dp.deleteDeparts(departs);
        model.addAttribute("message", "Bạn đã xóa phòng ban thành công ");
        List<Departments> list = new ArrayList<Departments>();
        list = dp.showDeparts("");
        model.addAttribute("listDepart", list);
        return "admin/department";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(ModelMap model, Departments departs,
            @RequestParam("id") String id,
            @RequestParam("name") String name) {
        DepartmentDAO dp = new DepartmentDAO();
        id = departs.getId();
        name = departs.getName();
        dp.updateDeparts(departs);
        model.addAttribute("message", "Bạn đã cập nhập phòng ban thành công ");
        List<Departments> list = new ArrayList<Departments>();
        list = dp.showDeparts("");
        model.addAttribute("listDepart", list);
        return "admin/department";
    }

}
