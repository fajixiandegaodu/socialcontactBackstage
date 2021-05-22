package com.pjh.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pjh.entity.TbGathering;
import com.pjh.service.impl.TbGatheringServiceImpl;
import com.socialContact.entity.Result;
import com.socialContact.entity.StatusCode;
import com.socialContact.util.IdWorker;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * <p>
 * 活动 前端控制器
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/gathering")
public class TbGatheringController {

    @Autowired

    private TbGatheringServiceImpl tbGatheringService;

    @Autowired

    private IdWorker idWorker;

    /*
    *获取所有活动列表
    * */

    @RequestMapping(method = RequestMethod.GET)

    public Result getAllList(){
        System.out.println("正在查询数据");
        List<TbGathering> list = tbGatheringService.selectList(null);
        return new Result(true, StatusCode.OK,"查询所有数据",list);
    }

    /*
    * 增加活动
    * */

    @RequestMapping(method = RequestMethod.POST)

    public Result addGathering(@RequestBody TbGathering tbGathering){
        String id = idWorker.nextId() + "";
        tbGathering.setId(id);
        tbGatheringService.insert(tbGathering);
        return  new Result(true,StatusCode.OK,"插入数据成功");
    }

    /*
    * 根据id查询活动
    * */

    @RequestMapping(value = "/{gatheringId}",method = RequestMethod.GET)

    public  Result getById(@PathVariable String gatheringId){
        TbGathering tbGathering = tbGatheringService.selectById(gatheringId);
        return new Result(true,StatusCode.OK,"根据id查询数据",tbGathering);
    }


    /*
     * 根据id删除活动
     * */

    @RequestMapping(value = "/{gatheringId}",method = RequestMethod.DELETE)

    public  Result DeleteById(@PathVariable String gatheringId){
       tbGatheringService.deleteById(gatheringId);
        return new Result(true,StatusCode.OK,"根据id删除数据");
    }

    /*
    * 修改活动
    * */

    @RequestMapping(method =RequestMethod.PUT,value = "/{gatheringId}")

    public Result updateById(@RequestBody TbGathering tbGathering,@PathVariable String gatheringId){
        tbGathering.setId(gatheringId);
        tbGatheringService.updateById(tbGathering);
        return  new Result(true,StatusCode.OK,"修改数据成功");
    }


    /*
    * 根据条件查询活动
    * */

    @RequestMapping(value = "/search",method = RequestMethod.POST)

    public Result search(@RequestBody Map<String,Object> map){
        Set<String> keySet = map.keySet();
        EntityWrapper<TbGathering> wrapper = new EntityWrapper<>();
        for (String key : keySet) {
            wrapper.eq(map.get(key)!=null,key,map.get(key));
        }
        List<TbGathering> list = tbGatheringService.selectList(wrapper);
        return new Result(true,StatusCode.OK,"根据条件查询数据",list);
    }


    /*
    * 活动分页
    * */

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)

    public Result PagingQuery(@PathVariable int page,
                              @PathVariable int size, @RequestBody  Map<String, Object> map){
        //这里要使用keySet获取数据
        Set<String> keySet = map.keySet();
        EntityWrapper<TbGathering> wrapper = new EntityWrapper<>();
        for (String key : keySet) {
            System.out.println(key+":"+map.get(key));
            wrapper.eq(map.get(key)!=null,key,map.get(key));
        }
        System.out.println("正在分页查询数据");
        System.out.println("page:"+page);
        System.out.println("size:"+size);
        Page<TbGathering> pageData = new Page<>(page, size);
        Page<TbGathering> list = tbGatheringService.selectPage(pageData, wrapper);
        list.setTotal(tbGatheringService.selectCount(null));
        return new Result(true,StatusCode.OK,"分页查询数据",list);
    }


    /*
    * 根据城市显示分页内容
    * */

    @RequestMapping(value = "/city/{city}/{page}/{size}")

    public Result PagingQuery(@PathVariable int page,
                              @PathVariable int size,
                              @PathVariable String city){
        Page<TbGathering> pageData = new Page<>(page, size);
        EntityWrapper<TbGathering> tbGatheringEntityWrapper = new EntityWrapper<>();
        if (city!=null){
            tbGatheringEntityWrapper.eq("city",city);
        }
        Page<TbGathering> list = tbGatheringService.selectPage(pageData, tbGatheringEntityWrapper);
        return new Result(true,StatusCode.OK,"分页查询数据",list);
    }
}
