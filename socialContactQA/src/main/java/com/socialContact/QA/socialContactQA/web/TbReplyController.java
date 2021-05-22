package com.socialContact.QA.socialContactQA.web;


import com.socialContact.QA.socialContactQA.entity.TbReply;
import com.socialContact.QA.socialContactQA.service.impl.TbReplyServiceImpl;
import com.socialContact.entity.Result;
import com.socialContact.entity.StatusCode;
import com.socialContact.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sun.dc.pr.PRError;

import java.time.chrono.ThaiBuddhistChronology;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * <p>
 * 回答 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-04-25
 */
/*
* 问题回答模块
* */
@RestController
@RequestMapping("/reply")
public class TbReplyController {
   @Autowired
   private TbReplyServiceImpl tbReplyService;
  @Autowired(required = false)
  private IdWorker idWorker;
   /*
   *增加回答
   * */

   @RequestMapping(method = RequestMethod.POST)

    public Result addReply(@RequestBody TbReply tbReply){
       String id = idWorker.nextId()+"";
       tbReply.setId(id);
       tbReplyService.addReply(tbReply);
       return new Result(true, StatusCode.OK,"增加回答成功");
   }

   /*
   *回答全部列表
   * */

   @RequestMapping(method = RequestMethod.GET)

   public Result findAll(){
       List<TbReply> list=tbReplyService.findAll();
       return new Result(true,StatusCode.OK,"查询全部列表成功",list);
   }

   /*
   * 根据id查询回答
   * */

   @RequestMapping(value = "/{id}",method = RequestMethod.GET)

   public Result findById(@PathVariable String id){
       TbReply reply=tbReplyService.findById(id);
       return new Result(true,StatusCode.OK,"根据id查询回答",reply);
   }

   /*
   * 根据id修改回答
   * */

   @RequestMapping(value = "/{id}",method = RequestMethod.PUT)

   public Result updateId(@RequestBody  TbReply tbReply, @PathVariable  String id){
       tbReply.setId(id);
       tbReplyService.update(tbReply);
       return new Result(true,StatusCode.OK,"修改数据成功");
   }

   /*
   * 根据id删除评论
   * */

   @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)

   public Result deleteByID(@PathVariable String id){
       tbReplyService.deleteById(id);
       return new Result(true,StatusCode.OK,"删除成功");
   }


   /*
   *回答分页
   * */
  @RequestMapping(method = RequestMethod.POST,value = "/search/{page}/{size}")

  public Result findByPage(@RequestBody Map<String,Object> map,
                           @PathVariable int size,
                           @PathVariable int page){
      List<TbReply> list=tbReplyService.findByPage(map,size,page);
      return  new Result(true,StatusCode.OK,"分页查询数据",list);
  }

  /*
  * 根据问题id查询数据
  * */

    @RequestMapping(method = RequestMethod.GET,value = "/problem/{problemId}")

    public Result findByProblemId(@PathVariable String problemId){

        List<TbReply> tbReply=tbReplyService.findByProblemId(problemId);

        return  new Result(true,StatusCode.OK,"根据问题id查询数据",tbReply);

    }

    /*
    * 回答问题
    * */

    @RequestMapping(value = "/save",method = RequestMethod.POST)

    public Result saveBy(@RequestBody TbReply tbReply){
        String id= idWorker.nextId()+"";
        tbReply.setId(id);
        tbReplyService.insert(tbReply);
        return new Result(true,StatusCode.OK,"插入成功");

    }

    /*
    * 我的回答列表
    * */

    @RequestMapping(value = "/list/{page}/{size}/{userid}",method = RequestMethod.GET)

    public Result getUserReply(@PathVariable int page,
                               @PathVariable int size,
                               @PathVariable String userid){
        List<TbReply> list=tbReplyService.findByUserId(userid,page,size);

        return new Result(true,StatusCode.OK,"根据用户id查询数据",list);
    }




}
