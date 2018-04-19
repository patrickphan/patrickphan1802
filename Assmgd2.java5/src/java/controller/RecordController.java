/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.*;
import bean.Staffs;
import java.util.ArrayList;
import java.util.List;
import model.DepartmentDAO;
import model.StaffDAO;
import model.RecordDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author GiaHieu
 */
@Controller
@RequestMapping("/show2")
public class RecordController {

    @RequestMapping(params = "btnSearch")
    public String search(ModelMap model, Staffs staffs,
            @RequestParam("departid") String departid) {
        StaffDAO stf = new StaffDAO();
        List<Staffs> liststf = new ArrayList<Staffs>();
        departid = staffs.getDepartid();
        liststf = stf.showStaffName(staffs);
        model.addAttribute("listStaff", liststf);
        RecordDAO record = new RecordDAO();
        List<Records> list1 = new ArrayList<Records>();
        list1 = record.showRecords("");
        model.addAttribute("listRecord", list1);
        DepartmentDAO depart1 = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart1.showDeparts("");
        model.addAttribute("listDp", list);
        return "admin/record";
    }

    @RequestMapping(params = "btnSave")
    public String insert(ModelMap model, Records records,
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("reason") String reason,
            @RequestParam("date") String date) {
        RecordDAO rc = new RecordDAO();
        name = records.getName();
        type = records.getType();
        reason = records.getReason();
        date = records.getDate();
        rc.saveRecords(records);       
        model.addAttribute("message", "Bạn đã ghi nhân thành tích thành công ");

        RecordDAO record = new RecordDAO();
        List<Records> list1 = new ArrayList<Records>();
        list1 = record.showRecords("");
        model.addAttribute("listRecord", list1);

        DepartmentDAO depart1 = new DepartmentDAO();
        List<Departments> list = new ArrayList<Departments>();
        list = depart1.showDeparts("");
        model.addAttribute("listDp", list);

        return "admin/record";
    }
}
