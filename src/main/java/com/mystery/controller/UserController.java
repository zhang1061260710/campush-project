package com.mystery.controller;

import com.mchange.io.IOSequentialByteArrayMap;
import com.mystery.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userServcie;
    /*获取用户名*/
    @RequestMapping(value="/getUsername",produces = "text/plain;charset=utf-8")
    public String getUserName(Integer id){
        System.out.println(userServcie.getUserName(1));
        return userServcie.getUserName(1);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String UserName= req.getParameter("username");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int count =userServcie.getName(UserName);
           resp.getWriter().print(count);
       }


    @RequestMapping(value="/hello")
    public ModelAndView Hello(){
        return new ModelAndView("/index");
    }
}
