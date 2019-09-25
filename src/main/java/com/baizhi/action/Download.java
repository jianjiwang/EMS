package com.baizhi.action;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/down")
public class Download {
    @RequestMapping("load")
    public ResponseEntity<byte []> download(String loadname, HttpSession session) throws Exception{
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/upload");
        File file = new File(realPath+"/"+loadname);
        //将目标文件转为字节数组
        byte[] bytes = FileUtils.readFileToByteArray(file);
        //设置http协议请求头
        HttpHeaders httpHeaders=new HttpHeaders();
        //解决文件名字乱码问题
        String s = new String(loadname.getBytes("UTF-8"), "ISO-8859-1");
        //下载文件以附件形式打开
        httpHeaders.setContentDispositionFormData("attachment",s);
        //下载格式以二进制流的形式打开
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //目标文件转换为字节数组            //告知SpringMVC框架 文件下载已经创建 可以进行下载
        return  new ResponseEntity<byte[]>(bytes,httpHeaders, HttpStatus.CREATED);
    }
}
