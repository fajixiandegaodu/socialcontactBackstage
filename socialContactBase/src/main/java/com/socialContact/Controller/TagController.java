package com.socialContact.Controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.socialContact.entity.PageResult;
import com.socialContact.entity.Result;
import com.socialContact.entity.StatusCode;
import com.socialContact.pojo.Label;
import com.socialContact.service.TagService;
import com.socialContact.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TagController
 * @Author: 86151
 * @Date: 2021/4/21 19:47
 * @Description: TODO
 */
@RestController
@RequestMapping("/tag")
/*解决跨域问题*/
@CrossOrigin
public class TagController {
    @Autowired(required = false)
    private TagService tagService;
    @Autowired
    private IdWorker idWorker;
    /*查询全部列表*/
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        System.out.println("findall");
        return new Result(true, StatusCode.OK,"查询全部列表成功",
               tagService.selectList());
    }

    /*
    * 根据Id查询标签
    * */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        System.out.println("根据id查询数据");
        tagService.selectById(id);
        return new Result(true,StatusCode.OK,"查询成功",
                tagService.selectById(id));
    }
    /*
    * 增加标签
    * */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label){
        tagService.add(label);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    /*
    *
    * 修改标签
    *  */
    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public Result update(@RequestBody Label label ,@PathVariable String id){
      label.setId(id);
      tagService.update(label);
      return new Result(true,StatusCode.OK,"修改成功");
    }

    /*
    *
    * 删除标签
    * */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id){
        tagService.deleteById(id);
        return  new Result(true,StatusCode.OK,"删除成功");
    }

   /*
   *
   * 带条件的不分页查询
   * */
   @RequestMapping(value = "/serarchBypage",method = RequestMethod.POST)
   public Result findByPage(
           @RequestBody Map<String,Object> map){
       List<Label> result= tagService.findByCondtion(map);
       /*返回数据*/
       return new Result(true,StatusCode.OK,"分页查询成功",result);

   }

    /*
    * 带条件的分页查询
    * */
    @RequestMapping(value = "/serarchBypage/{page}/{size}",method = RequestMethod.POST)
    public Result findByPage(@PathVariable int size,
                                  @PathVariable int page,
                                  @RequestBody Map<String,Object> map){
        Page<Label> pageData = tagService.findByPage(map, page, size);
        /*封装返回分页对象*/
      PageResult<Label> pageResult= new PageResult<Label>(pageData.getTotal(), pageData.getRecords());
      /*返回数据*/
        return new Result(true,StatusCode.OK,"分页查询成功",pageResult);

    }


}
