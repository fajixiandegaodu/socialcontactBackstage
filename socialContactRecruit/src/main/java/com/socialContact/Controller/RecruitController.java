package com.socialContact.Controller;

import com.socialContact.Service.RecruitService;
import com.socialContact.entity.Result;
import com.socialContact.entity.StatusCode;
import com.socialContact.pojo.Recruit;
import com.socialContact.util.IdWorker;
import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.sql.ClientInfoStatus;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: RecruitController
 * @Author: 86151
 * @Date: 2021/4/22 19:37
 * @Description: TODO
 */
@RestController
@RequestMapping("/recruit")
public class RecruitController {
  @Autowired
  private RecruitService recruitService;
  @Autowired
  private IdWorker idWorker;

    /*
    *
    * 增加招聘
    * */

    @RequestMapping(method = RequestMethod.POST)
    public Result addRecruit(@RequestBody Recruit recruit){
        String id = idWorker.nextId()+"";
        recruit.setId(id);
        recruitService.addRecruit(recruit);
        return new Result(true,StatusCode.OK,"添加成功");
    }




    /*
    * 查询招聘的全部列表
    * */
    @RequestMapping(method = RequestMethod.GET)
    public Result addRecruit(){
        List<Recruit> list=recruitService.findAll();
        return new Result(true, StatusCode.OK,"查询招聘列表成功",list);
    }


    /*
    * 根据Id查询招聘信息
    * */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)

    public Result findById(@PathVariable String id){
        Recruit recruit=recruitService.findById(id);
        return new Result(true,StatusCode.OK,"根据id查询消息成功",recruit);
    }

    /*
    *
    * 修改招聘
    * */

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)

    public Result updateById(@RequestBody Recruit recruit,@PathVariable String id){
        recruit.setId(id);
        recruitService.updateById(recruit);
        return  new Result(true,StatusCode.OK,"根据Id修改消息成功");
    }

    /*
    * 根据id删除招聘
    * */

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)

    public Result deleteById(@PathVariable String id,@RequestBody Recruit recruit){
        recruit.setId(id);
        recruitService.deleteById(recruit);
        return  new Result(true,StatusCode.OK,"根据id删除数据成功");
    }

    /*
    * 根据条件查询招聘列表
    * */

    @RequestMapping(value ="/search",method = RequestMethod.POST)

    public Result findByCondition(@RequestBody Map<String,Object> condition){
        List<Recruit> list=recruitService.findByCondition(condition);
        return new Result(true,StatusCode.OK,"根据信息删除",list);
    }

    /*
    *
    * 招聘分页查询
    * */

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)

    public Result findByPage(@PathVariable int size,@PathVariable int page){
        List<Recruit> list=recruitService.findByPage(page,size);
        return new Result(true,StatusCode.OK,"分页查询",list);
    }

    /*
    * 推荐职位
    * */

    @RequestMapping(value = "/search/recommend",method = RequestMethod.GET)

    public Result recruitRecommend(){
        List<Recruit> list=recruitService.findByState();
        return new Result(true,StatusCode.OK,"查询推荐企业的列表",list);
    }

    /*
    * 查询最新的职位
    * */


    @RequestMapping(value = "/search/newList",method = RequestMethod.GET)

    public Result findNewList(){
        List<Recruit> list=recruitService.findNewList();
        return new Result(true,StatusCode.OK,"查询最新的职位",list);
    }

}
