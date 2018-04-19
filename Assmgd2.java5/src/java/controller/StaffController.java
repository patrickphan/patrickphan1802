/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Departments;
import bean.Staffs;
import java.util.ArrayList;
import java.util.List;
import model.DepartmentDAO;
import model.StaffDAO;
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
@RequestMapping("/show1")
public class StaffController {

    @RequestMapping()
    public String showDepart(Model model) {
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

    @RequestMapping(params = "btnInsert")
    public String insert(ModelMap model, Staffs staffs,
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("photo") String photo,
            @RequestParam("birthday") String birthday,
            @RequestParam("salary") String salary,
            @RequestParam("departid") String depart,
            @RequestParam("level") String level,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("notes") String notes) {
        StaffDAO stf = new StaffDAO();
        id = staffs.getId();
        name = staffs.getName();
        gender = staffs.getGender();
        photo = staffs.getPhoto();
        birthday = staffs.getBirthday();
        salary = staffs.getSalary();
        depart = staffs.getDepartid();
        level = staffs.getLevel();
        email = staffs.getEmail();
        phone = staffs.getPhone();
        notes = staffs.getNotes();
        stf.insertStaffs(staffs);
        model.addAttribute("message", "Bạn đã thêm nhân viên thành công ");
        DepartmentDAO depart1 = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart1.showDeparts("");
        model.addAttribute("listDp", list);
        StaffDAO staff = new StaffDAO();
        List<Staffs> list1 = new ArrayList<Staffs>();
        list1 = staff.showStaffs("");
        model.addAttribute("listStaff", list1);

        return "admin/managerstaff";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(ModelMap model, Staffs staffs,
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("photo") String photo,
            @RequestParam("birthday") String birthday,
            @RequestParam("salary") String salary,
            @RequestParam("departid") String depart,
            @RequestParam("level") String level,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("notes") String notes) {
        StaffDAO stf = new StaffDAO();
        id = staffs.getId();
        name = staffs.getName();
        gender = staffs.getGender();
        photo = staffs.getPhoto();
        birthday = staffs.getBirthday();
        salary = staffs.getSalary();
        depart = staffs.getDepartid();
        level = staffs.getLevel();
        email = staffs.getEmail();
        phone = staffs.getPhone();
        notes = staffs.getNotes();
        stf.updateStaffs(staffs);
        model.addAttribute("message", "Bạn đã cập nhập nhân viên thành công ");
        DepartmentDAO depart1 = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart1.showDeparts("");
        model.addAttribute("listDp", list);
        StaffDAO staff = new StaffDAO();
        List<Staffs> list1 = new ArrayList<Staffs>();
        list1 = staff.showStaffs("");
        model.addAttribute("listStaff", list1);
        return "admin/managerstaff";
    }

    @RequestMapping(params = "btnDelete")
    public String delete(ModelMap model, Staffs staffs,
            @RequestParam("id") String id) {
        StaffDAO stf = new StaffDAO();
        id = staffs.getId();
        stf.deleteStaffs(staffs);
        model.addAttribute("message", "Bạn đã xóa nhân viên thành công ");
        DepartmentDAO depart1 = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart1.showDeparts("");
        model.addAttribute("listDp", list);
        StaffDAO staff = new StaffDAO();
        List<Staffs> list1 = new ArrayList<Staffs>();
        list1 = staff.showStaffs("");
        model.addAttribute("listStaff", list1);
        return "admin/managerstaff";
    }

    @RequestMapping(params = "btnChoose")
    public String choose(ModelMap model, Staffs staffs,
            @RequestParam("departid") String departid) {
        
        StaffDAO stf = new StaffDAO();
        List<Staffs> liststf = new ArrayList<Staffs>();
        departid = staffs.getDepartid();
        liststf = stf.showStaffName(staffs);
        model.addAttribute("listStaff", liststf);
        
        DepartmentDAO depart1 = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart1.showDeparts("");
        model.addAttribute("listDp", list);
        return "admin/infostaff";
    }
    
    @RequestMapping(params = "btnSearch")
    public String search(ModelMap model, Staffs staffs,
            @RequestParam("name") String name) {
        
        StaffDAO stf = new StaffDAO();
        List<Staffs> listst = new ArrayList<Staffs>();
        name = staffs.getName();
        listst = stf.showStaffInfo(staffs);
        model.addAttribute("listStaffinfo", listst);
        
        
        DepartmentDAO depart1 = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart1.showDeparts("");
        model.addAttribute("listDp", list);
        return "admin/infostaff";
    }

}
