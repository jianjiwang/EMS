package com.baizhi.action;

import com.baizhi.entity.Employees;
import com.baizhi.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeesAction {
    @Autowired
    private EmployeesService employeesService;

    @RequestMapping("/insert")
    public String insert(MultipartFile upload, Employees employees, HttpSession session) throws Exception {
        //获取upload(目标文件夹)的路径
        ServletContext servletContext = session.getServletContext();
        //获取upload对应的路径
        String realPath = servletContext.getRealPath("/upload");
        //把上传的文件 输出到/upload文件夹中 文件名字
        // 在upload文件夹中创建了与上传文件同名的文件 空文件
        File file = new File(realPath + "/" + upload.getOriginalFilename());
        //把上传的文件内容转换到空文件中
        upload.transferTo(file);
        employees.setPicture(upload.getOriginalFilename());
        employeesService.insert(employees);
        return "redirect:/department/selectAll.do";
    }
    @RequestMapping("/selectAll")
    public String selectAll(Integer id , Model model, HttpSession session)throws Exception{
        if (id!=null){
            session.setAttribute("fid", id);
        }
        Integer ids= (Integer) session.getAttribute("fid");
        List<Employees> employees1 = employeesService.selectAll(ids);

        model.addAttribute("employees",employees1);
        return "emplist";
    }
    @RequestMapping("/delete")
    public String delete(Integer id) throws  Exception{
        employeesService.delete(id);
        return "redirect:/employees/selectAll.do";
    }
    @RequestMapping("/selectOne")
    public String selectOne(Integer id ,Model model)throws  Exception{
        Employees employees = employeesService.selectOne(id);
        model.addAttribute("employees",employees);
        return "updateEmp";
    }
    @RequestMapping("/update")
    public String update(MultipartFile upload, Employees employees, HttpSession session)throws  Exception{
        System.out.println("666666666666666"+upload);
        //获取upload(目标文件夹)的路径
        if(!upload.isEmpty()) {
            ServletContext servletContext = session.getServletContext();
            //获取upload对应的路径
            String realPath = servletContext.getRealPath("/upload");
            // 在upload文件夹中创建了与上传文件同名的文件 空文件
            File file = new File(realPath + "/" + upload.getOriginalFilename());
            //把上传的文件内容转换到空文件中
            upload.transferTo(file);
            employees.setPicture(upload.getOriginalFilename());
        }
        employeesService.update(employees);
        return "redirect:/employees/selectAll.do";
    }
    @RequestMapping("/a")
    public String a(Integer did)throws Exception{
        System.out.println(did+"5644444444444444444444444");
        return "redirect:/employees/selectAll.do";
    }
}
