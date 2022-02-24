package com.mystery.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mystery.entity.User;
import com.mystery.service.IUserService;
import com.mystery.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.UUID;

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
    //用户登入
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
              return Response.OK(count);
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
       //用户注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String username= req.getParameter("username");
      String password=  req.getParameter("password");
      String role=  req.getParameter("role");
      HttpSession session = req.getSession();
      session.setAttribute("data", username);
      int role2 = Integer.parseInt(role);
      User user = new User(username,password,role2);
      try {
         userServcie.save(user);
         return Response.OK(null);
      }catch (Exception e){
          return Response.Error();
      }
    }
    //检测用户是否登入
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public  Response checkUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //编码规范
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        Object user = session.getAttribute("data");
        String Username=String.valueOf(user);
        int count =userServcie.getName(Username);
        if (user != null && count!=0){
            return Response.OK(Username);
        }else{
            return Response.Error();
        }
    }
    /*获取个人信息*/

    @RequestMapping(value="/getuserlist")
    public Response GetUserList(HttpServletRequest req, HttpServletResponse resp){
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        Object user =session.getAttribute("data");
        if (user==null){
            return Response.Error();
        }else {
           //查询用户
            String Username=String.valueOf(user);
            User userlist= userServcie.GetUserList(Username);
            SerializeFilter scriptArrayFilter = null;
            String jsonStr = JSONObject.toJSONString(userlist,new SerializeFilter[]{scriptArrayFilter}, SerializerFeature.WriteMapNullValue);
            System.out.println(jsonStr);
            return Response.OK(JSON.parseObject(jsonStr));
        }
    }

    //学生管理，获取所有用户信息（注册用户完善个人信息后保存到同一张数据库，简化版没写太复杂）
    @RequestMapping(value="/AllUserList", method = RequestMethod.GET)
    public String AllUserList(){
        List <User> Alluser= userServcie.AllUserList();
        SerializeFilter scriptArrayFilter = null;
        String jsonStr = JSONObject.toJSONString(Alluser,new SerializeFilter[]{scriptArrayFilter}, SerializerFeature.WriteMapNullValue);
        System.out.println(jsonStr);
       /* 这种是转换乱码为utf8，仅供参考，没啥软用。一般使用框架的响应方式，没必要写成这种。也可以使用（HttpServletRequest req, HttpServletResponse resp）来进行响应
        获取前端传入都值方式有很多，可以用注解实体类接受json，也可以使/用getParameter，或者前端ajax 对应的转进json或者xxx=1 这些都能得到前端输入都内容。方式不要太多
        这里这么简单怎么来！*/
        /*String newjson = new String(jsonStr.getBytes(StandardCharsets.UTF_8));*/
        return jsonStr;
    }
    //疫情接口
    @RequestMapping(value="/Ncoronavirus")
    public void coronavirus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        BufferedReader br = null;
        String result = "";
        try {
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
            /*return Response.OK(result);*/

            resp.getWriter().print(JSON.parseObject(result));

        } catch (Exception e) {
            e.printStackTrace();
        }
     /*   return null;*/
    }
    /*  这个上传也能用。
    @RequestMapping(value="/uploadFile",method = RequestMethod.POST)
    public String uploadFileHandler(@RequestParam("file") MultipartFile file){if (!file.isEmpty()) {
        try {
            // 文件存放服务端的位置
            String rootPath = "/Users/kevin/project/campush-project/tmp";
            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists())
                dir.mkdirs();
            // 写文件到服务器
            File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
            file.transferTo(serverFile);
            return "You successfully uploaded file=" +  file.getOriginalFilename();
             } catch (Exception e) {
                return "You failed to upload " +  file.getOriginalFilename() + " => " + e.getMessage();
             }
            } else {
                 return "You failed to upload " +  file.getOriginalFilename() + " because the file was empty.";
        }

    }*/
    //文件上传接口
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file")MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json=new JSONObject();
        response.setCharacterEncoding("utf-8");
        String msg = "success";
        String img = "";
        try{
            String name = file.getOriginalFilename();
            int lastIndexOf = name.lastIndexOf(".");    //为获取用户上传文件的后缀，截取最后一个. 的位置下标
            String suffix =name.substring(lastIndexOf); //根据下标去拿文件后面的后缀
            String path = this.getClass().getClassLoader().getResource("/").getPath(); //获取打包启动后的项目路径，classes
            int index = path.indexOf("campush-project");//截取路径中项目的下标
            /*
            从0开始到获取到项目路径加项目名字,可以拼接自定义目录，如果使用yaml 配置文件，来指定目录可以动态获取配置文件中配置的路径，
            此次项目简单的写一下路径使用为项目路径，表明一下之后可以优化的方向。
            */
            String uuid = UUID.randomUUID().toString(); //创建uuid 随机文件名
            String newuuid =uuid.replaceAll("-", ""); //去除uuid中自带的-
            String newfilename=newuuid+suffix;  //使用uuid拼接后缀形成最后的图片名字
            path = path.substring(0, index + "campush-project".length()) + "/src/main/webapp/tmpFiles";  //拼接上传文件路径
            String pathxx = path + File.separator + newfilename;   //用于正式上传文件
            img=newfilename;
            String pathxx2= path + File.separator;          //用于判断文件路径是否存在
            File uploadFile = new File(pathxx);
            File uploadFile2 = new File(pathxx2);
            //判断文件夹是否存在，不存在就创建
            if (!uploadFile2.exists() && !uploadFile2.isDirectory()){
                uploadFile2.mkdirs(); //创建文件夹，mkdirs可以创建多个父目录不存在的文件夹，mkdir只能创建一层，如果多层目录不存在会报错
                file.transferTo(uploadFile); //开始创建文件流写入文件，完成上传
            }else {
                file.transferTo(uploadFile);
            }
          }catch(Exception e){
            msg="error";
        }
        json.put("msg", msg);
        json.put("img",img);
        return  JSONObject.toJSONString(json);
    }
    @RequestMapping(value = "/preservation",method = RequestMethod.POST)
    public String preservation(@RequestBody User user,HttpServletRequest req){
        HttpSession session = req.getSession();
        Object kv = session.getAttribute("data");
        String kvname=String.valueOf(kv);
        user.setUsername(kvname);
        userServcie.PersonalUpdate(user);
        System.out.println(user);
        JSONObject json=new JSONObject();
        json.put("message","ok");
        return JSONObject.toJSONString(json);
    }

    @RequestMapping(value="/hello")
    public ModelAndView Hello(){
        return new ModelAndView("/index");
    }
}
