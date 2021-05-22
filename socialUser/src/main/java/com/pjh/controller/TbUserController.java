package com.pjh.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pjh.entity.TbUser;
import com.pjh.service.TbUserService;
import com.socialContact.entity.Result;
import com.socialContact.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import java.sql.Array;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/user")
public class TbUserController {
    @Autowired

    private TbUserService tbUserService;

    /*
    *
    * 登入功能
    * */

    @RequestMapping(value = "/login",method = RequestMethod.POST)

    public Result login(@RequestBody Map<String,Object> map){
        System.out.println("正在登入");
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        /*编写条件判断的语句*/

        EntityWrapper<TbUser> wrapper = new EntityWrapper<>();
        wrapper.eq("nickname",map.get("username"));
        wrapper.eq("password",map.get("password"));

        /*查询数据*/

        TbUser tbUser = tbUserService.selectOne(wrapper);
        System.out.println(tbUser);
        /*如果查询到用户则登入成功*/
        if (tbUser!=null){
            System.out.println("登入成功");
            HashMap<String, String> resultMap = new HashMap<>();
            resultMap.put("token",tbUser.getId());
            return new Result( true,StatusCode.OK,"登入成功",resultMap);
        }else{
            return  new Result( false,StatusCode.LOGINERROR,"登入失败");
        }

    }


    /*
    *
    * 登出功能
    * */

    @RequestMapping(value = "/logout",method = RequestMethod.POST)

    public Result logout(){
        System.out.println("正在登出");
        return new Result(true,StatusCode.OK,"登出");
    }


    /*
    *
    * 获取用户消息功能
    * */

    @RequestMapping(value = "/info",method = RequestMethod.GET)

    public Result info(@RequestHeader("X-Token") String token) {
        System.out.println("令牌为:"+token);
        System.out.println("正在获取数据");
        HashMap<String, String> resultMap = new HashMap<>();
        /*从数据库中获取数据，后期可改为使用redis获取*/
        TbUser tbUser1 = tbUserService.selectById(token);
        resultMap.put("roles","admin");
        resultMap.put("role","admin");
        resultMap.put("name",tbUser1.getNickname());
        resultMap.put("avatar",tbUser1.getAvatar());
        TbUser tbUser = new TbUser();
        return new Result(true,StatusCode.OK,"返回用户信息",resultMap);
    }

}
