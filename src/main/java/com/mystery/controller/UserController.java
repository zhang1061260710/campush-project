package com.mystery.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.mystery.entity.User;
import com.mystery.service.IUserService;
import com.mystery.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    public Response login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map <String,String> map= new HashMap<String,String>();
        String UserName= req.getParameter("username");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        session.setAttribute("data", UserName);
        String sessionId = session.getId();
        Object sessionname= session.getAttribute("data");
        System.out.println(sessionId);
        System.out.println(sessionname);
       try{
           int count =userServcie.getName(UserName);
          if (count ==1){
//              resp.getWriter().print(JSONUtils.toJSONString(Response.OK(null)));
              return Response.OK(null);
          }else {
//              JSONUtils.toJSONString(new Response(0,"failed",null));
//              System.out.println(new Response(0,"failed",null).toString());
//              resp.getWriter().print(new Response(0,"failed",null).toString());
              return Response.Error();
          }
//           map.put("name", (String) sessionname);
//           System.out.println(map);
//           resp.getWriter().print(JSONUtils.toJSONString(map));

       }catch(Exception e){
           String error=e.getMessage();
           resp.getWriter().print(error);
         }
       return null;
       }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String username= req.getParameter("username");
      String password=  req.getParameter("password");
      String role=  req.getParameter("role");
      System.out.println(username);
      System.out.println(password);
      System.out.println(role);
      int role2 = Integer.parseInt(role);
      User user = new User(username,password,role2);
      try {
          userServcie.save(user);
          resp.getWriter().write(JSONUtils.toJSONString(Response.OK(null)));
      }catch (Exception e){
          resp.getWriter().write(JSONUtils.toJSONString(Response.Error()));
      }
    }
    @RequestMapping(value="/hello")
    public ModelAndView Hello(){
        return new ModelAndView("/index");
    }
}
