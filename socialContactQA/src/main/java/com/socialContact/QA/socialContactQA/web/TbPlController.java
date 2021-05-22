package com.socialContact.QA.socialContactQA.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.socialContact.QA.socialContactQA.entity.TbProblem;
import com.socialContact.QA.socialContactQA.service.impl.TbProblemServiceImpl;
import com.socialContact.entity.Result;
import com.socialContact.entity.StatusCode;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-04-25
 */
@RestController
@RequestMapping("/problem")
public class TbPlController {


    @Autowired
    private TbProblemServiceImpl problemService;

    /*
    增加问题
    */



    @RequestMapping(method = RequestMethod.POST)

    public Result addProblem(@RequestBody TbProblem tbProblem){
        problemService.insert(tbProblem);
        return  new Result(true, StatusCode.OK,"插入问题成功");
    }

    /*
    查询全部问题
    */

    @RequestMapping(method = RequestMethod.GET)

    public Result findAll(){
        List<TbProblem> tbProblems = problemService.selectList(null);
        return  new Result(true,StatusCode.OK,"查询全部问题",tbProblems);
    }

    /*
    *
    * 根据id查询问题
    * */
    @RequestMapping(value = "/{problemId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String problemId){
        TbProblem tbProblem = problemService.selectById(problemId);
        return new Result(true,StatusCode.OK,"根据id查询问题",tbProblem);
    }

    /*
    * 根据id删除问题
    * */

    @RequestMapping(value = "/{problemId}",method = RequestMethod.DELETE)

    public Result DeleteById(@PathVariable String problemId){
         problemService.deleteById(problemId);
        return new Result(true,StatusCode.OK,"根据id删除问题");
    }

    /*
    * 根据查询条件查询问题
    * */

    @RequestMapping(value = "/search",method = RequestMethod.POST)

    public Result DeleteById(@RequestBody Map<String,Object> map){
        List<TbProblem> list= problemService.selectByCondition(map);
        return new Result(true,StatusCode.OK,"根据条件查询问题",list);
    }

    /*
    * 查询问题分页
    * */

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)

    public Result DeleteByIdPage(@RequestBody Map<String,Object> map,
                                 @PathVariable int page,
                                 @PathVariable int size){
        List<TbProblem> list= problemService.selectByCondition(map,page,size);
        return new Result(true,StatusCode.OK,"根据条件查询问题",list);
    }

    /*
    *
    * 最新最新回答列表列表
    *
    * */
    @RequestMapping(value = "/newlist/{label}/{page}/{size}",method = RequestMethod.GET)

    public Result findNewList(
                                 @PathVariable String label,
                                 @PathVariable int page,
                                 @PathVariable int size){
       List<TbProblem> list=problemService.findNewList(label,page,size);

       return  new Result(true,StatusCode.OK,"查询最新问题列表",list);
    }

  /*
  * 返回等待回答的列表
  * */

    @RequestMapping(value ="/waitlist/{label}/{page}/{size}",method = RequestMethod.GET)

    public Result findWaitList(@PathVariable String label,@PathVariable int page,@PathVariable int size){

      List<TbProblem> list= problemService.findWaitList(label,page,size);

        return  new Result(true,StatusCode.OK,"查询最新问题列表",list);
    }

   /*
   *
   * 返回热门回答列表
   * */

    @RequestMapping(value = "/hotlist/{label}/{page}/{size}",method = RequestMethod.GET)
    public Result findHotList(@PathVariable String label,@PathVariable int page,@PathVariable int size){

        List<TbProblem> list= problemService.findHotList(label,page,size);

        return  new Result(true,StatusCode.OK,"查询最新问题列表",list);
    }

    /*
    * 返回全部问题分页
    * */

     @RequestMapping(value = "/all/{label}/{page}/{size}",method = RequestMethod.POST)

    public Result PageFind(@PathVariable String label,
                                @PathVariable int page,@PathVariable int size){
         Page<TbProblem> pageData= new Page<>(page, size);
         Page<TbProblem> list = problemService.selectPage(pageData, null);

         return  new Result(true,StatusCode.OK,"查询全部问题列表",list);
     }

     /*
     * 测试分页查询是否有效
     * */

    @RequestMapping(value = "/test/{label}/{page}/{size}",method = RequestMethod.POST)

    public Result PageFindTest(@PathVariable String label,
                           @PathVariable int page,@PathVariable int size){
        List<TbProblem> list = problemService.test(label, page, size);

        return  new Result(true,StatusCode.OK,"查询全部问题列表",list);
    }


}
