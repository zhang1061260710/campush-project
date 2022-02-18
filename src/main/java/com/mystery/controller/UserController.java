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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
        String UserName= req.getParameter("username");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        session.setAttribute("data", UserName);

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
       @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
       public  Response checkUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
           //编码规范
           resp.setContentType("text/html;charset=utf-8");
           resp.setCharacterEncoding("utf-8");
           HttpSession session = req.getSession();
           Object user = session.getAttribute("data");
           if (user != null){
               return Response.OK(user);
           }else{
               return Response.Error();
           }
       }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
         return Response.OK(null);
      }catch (Exception e){
          return Response.Error();
      }
    }
    @RequestMapping(value="/Ncoronavirus")
    public Response coronavirus() throws IOException {
        BufferedReader br = null;
        String result = "";
        URL url = new URL("https://c.m.163.com/ug/api/wuhan/app/data/list-total");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        InputStream is = conn.getInputStream();
        br = new BufferedReader(new InputStreamReader(is));
        String str = "";
        while ((str = br.readLine()) != null){
            result += str;
        }
        is.close();
        conn.disconnect();
        return Response.OK(result);
    }
    @RequestMapping(value="/hello")
    public ModelAndView Hello(){
        return new ModelAndView("/index");
    }
}
