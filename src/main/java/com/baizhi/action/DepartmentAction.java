package com.baizhi.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.entity.Department;
import com.baizhi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentAction {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/selectAll")
    public String selectAll(Model model) throws Exception{
        List<Department> departments = departmentService.selectAll();
        //SpringMVC只能用作用域传值
        model.addAttribute("departments",departments);
        return "departments";
    }
    @RequestMapping("/selectOne")
    public String selectOne(Department department,Model model) throws Exception{
        Department department1 = departmentService.selectOne(department.getId());
        model.addAttribute("department",department1);
        return "updateDepartment";
    }
    @RequestMapping("/update")
    public String update(Department department)throws Exception{
        departmentService.update(department);
        return "redirect:/department/selectAll.do";

    }
    @RequestMapping("/insert")
    public String insert(Department department) throws  Exception{
        departmentService.insert(department);
        return "redirect:/department/selectAll.do";
    }
    @RequestMapping("ajaxSelectAll")
    public String ajaxSelectAll(Model model, HttpServletResponse response)throws  Exception{
        List<Department> departments = departmentService.selectAll();
        System.out.println(departments);
        String jsonString = JSON.toJSONString(departments);
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.print(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
