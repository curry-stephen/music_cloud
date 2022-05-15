package com.yy.controller;


import com.alibaba.fastjson.JSONObject;
import com.yy.service.impl.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@RestController
@RequestMapping
public class AdminController {
    
@Autowired
    private AdminServiceImp adminService;
     @ResponseBody
    @RequestMapping("/admin/login/status")
            //(value = "/admin/login/status",method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session){
    JSONObject object = new JSONObject();
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    boolean b = adminService.veritypasswd(name, password);
    
    if (b){
        object.put("code", 1);
        object.put("msg","登陆成功！");
        session.setAttribute("name",name);
        return object;
    }else {
        object.put("code",0);
        object.put("msg","用户名或密码错误！");
        return object;
    }

}
}

