package com.socialContact.Controller;

import com.socialContact.Service.EnterPriseService;
import com.socialContact.entity.Result;
import com.socialContact.entity.StatusCode;
import com.socialContact.pojo.Enterprise;
import com.socialContact.util.IdWorker;
import org.omg.IOP.ENCODING_CDR_ENCAPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: Enterprise
 * @Author: 86151
 * @Date: 2021/4/22 19:43
 * @Description: TODO
 */
@RestController
@RequestMapping("/enterprise")
/*跨域请求注解*/
@CrossOrigin
public class EnterpriseController {
    @Autowired
    private EnterPriseService enterPriseService;
     @Autowired
     private IdWorker idWorker;
    /*
    * 查询所有企业企业
    *
    * */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Enterprise> resultList=enterPriseService.findAll();
        return new Result(true,StatusCode.OK,"查询数据成功",resultList);
    }

   /*
   * 增加企业
   * */

    @RequestMapping(method = RequestMethod.POST)

    public Result addEnterprise(@RequestBody Enterprise enterprise){
        String id = idWorker.nextId()+"";
        enterprise.setId(id);
        enterPriseService.addOne(enterprise);
        return  new Result(true,StatusCode.OK,"添加企业成功");
    }

    /*
    * 根据企业id查询企业
    * */

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)

    public Result getByID(@PathVariable String id){
        Enterprise result=enterPriseService.findById(id);
        return  new Result(true,StatusCode.OK,"根据id查询数据",result);
    }

    /*
    * 查询热门企业列表
    * */
   @RequestMapping("/search/hotList")
    public Result findHotlist(){
       /*正在查询热门企业列表*/
       List<Enterprise> hotList = enterPriseService.findIsHot();
       return new Result(true, StatusCode.OK,"查询热门企业列表",hotList);
    }

    /*
    *
    * 修改企业
    * */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@RequestBody Enterprise enterprise,@PathVariable String id){
        System.out.println("正在修改");
        enterprise.setId(id);
        enterPriseService.updateById(enterprise);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /*根据条件查询企业列表*/
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findEnterpriseByCondition(@RequestBody Map<String,Object> condition){
      List<Enterprise> resultList= enterPriseService.findByCondition(condition);
      return new Result(true,StatusCode.OK,"根据 id查询企业列表",resultList);
    }
}
