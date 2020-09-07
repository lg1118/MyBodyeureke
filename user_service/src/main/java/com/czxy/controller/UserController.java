package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import com.czxy.utils.JwtUtils;
import com.czxy.utils.RasUtils;
import com.czxy.vo.BaseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final String pubKeyPath = "D:\\ras\\ras.pub";

    private static final String priKeyPath = "D:\\ras\\ras.pri";
    @Resource
    private UserService userService;
    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/registered")
    public BaseResult registered(@RequestBody User user){
//        System.out.println(user);
     Boolean b =   userService.registered(user);
   if (b){
       return BaseResult.ok("注册成功");
   }else {
       return BaseResult.ok("注册失败");
   }
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public BaseResult login(@RequestBody User user){
        System.out.println(user);
        User b =userService.login(user);
        String token =null;
        if (b!=null){
            try {
                 token = JwtUtils.generateToken(b, 300, RasUtils.getPrivateKey(priKeyPath));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return BaseResult.ok("登录成功",b).append("token",token);
        }
        return BaseResult.error("用户名或密码错误");
    }
}
