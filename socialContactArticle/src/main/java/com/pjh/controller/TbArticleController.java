package com.pjh.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pjh.entity.TbArticle;
import com.pjh.service.impl.TbArticleServiceImpl;
import com.socialContact.entity.Result;
import com.socialContact.entity.StatusCode;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/article")
public class TbArticleController {
    @Autowired

    private TbArticleServiceImpl tbArticleService;

    /*
    *
    * 文章全部列表
    * */

    @RequestMapping(method = RequestMethod.GET)

    public Result getAllList(){
        List<TbArticle> tbArticles = tbArticleService.selectList(null);
        return new Result(true, StatusCode.OK,"查询所有信息",tbArticles);
    }

    /*
    * 根据id查询文章
    * */

    @RequestMapping(value = "/{articleId}",method = RequestMethod.GET)

    public Result getArticleById(@PathVariable String articleId){
        TbArticle tbArticles = tbArticleService.selectById(articleId);
        return new Result(true, StatusCode.OK,"查询所有信息",tbArticles);
    }

    /*
     * 根据id修改文章
     * */

    @RequestMapping(value = "/{articleId}",method = RequestMethod.PUT)

    public Result UpdateArticleById(@PathVariable String articleId,
                                 @RequestBody TbArticle tbArticle){

        tbArticle.setId(articleId);
        tbArticleService.updateById(tbArticle);
        return new Result(true, StatusCode.OK,"查询所有信息");
    }

    /*
     * 根据id删除文章
     * */

    @RequestMapping(value = "/{articleId}",method = RequestMethod.DELETE)

    public Result DeleteArticleById(@PathVariable String articleId){
        tbArticleService.deleteById(articleId);
        return new Result(true, StatusCode.OK,"查询所有信息");
    }


    /*
    * 根据条件查询文章列表
    * */

    @RequestMapping(value = "/search",method = RequestMethod.POST)

    public Result SearchArticle(@RequestBody Map<String,Object> map){
        Set<String> keySet = map.keySet();
        EntityWrapper<TbArticle> wrapper = new EntityWrapper<>();
        for (String key : keySet) {
            wrapper.eq(map.get(key)!=null,key,map.get(key));
        }
        List<TbArticle> list = tbArticleService.selectList(wrapper);
        return new Result(true, StatusCode.OK,"根据条件查询文章列表",list);
    }

    /*
     * 根据条件查询文章列表
     * */

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)

    public Result SearchArticleByPage(@PathVariable int page,
                                      @PathVariable int size){
        Page<TbArticle> tbArticlePage = new Page<>(page, size);
        Page<TbArticle> pageList = tbArticleService.selectPage(tbArticlePage);
        return new Result(true, StatusCode.OK,"根据条件查询文章列表",pageList);
    }


    /*
    * 点赞
    * */

    @RequestMapping(value = "/thumbup/{articleId}",method = RequestMethod.PUT)

    public Result ArticleThumpub(@PathVariable String articleId){
        tbArticleService.thumpub(articleId);
        return new Result(true,StatusCode.OK,"点赞成功");
    }

    /*
    * 根据专栏ID获取文章列表
    * */

    @RequestMapping(method = RequestMethod.POST,
    value = "/column/{columnId}/{page}/{size}")

    public  Result findArticleBycolumnId(@PathVariable String columnId,
                                         @PathVariable int page,
                                         @PathVariable int size){
        EntityWrapper<TbArticle> wrapper = new EntityWrapper<>();
        wrapper.eq("columnid",columnId);
        Page<TbArticle> tbArticlePage = new Page<TbArticle>(page,size);
        Page<TbArticle> pageList = tbArticleService.selectPage(tbArticlePage, wrapper);
        return new Result(true,StatusCode.OK,"根据专栏ID获取文章列表",pageList);
    }

    /*
     * 根据专栏ID获取文章列表
     * */

    @RequestMapping(method = RequestMethod.POST,
            value = "/channel/{channelId}/{page}/{size}")

    public  Result findArticleBychannelId(@PathVariable String channelId,
                                         @PathVariable int page,
                                         @PathVariable int size){
        EntityWrapper<TbArticle> wrapper = new EntityWrapper<>();
        wrapper.eq("channelid",channelId);
        Page<TbArticle> tbArticlePage = new Page<TbArticle>(page,size);
        Page<TbArticle> pageList = tbArticleService.selectPage(tbArticlePage, wrapper);
        return new Result(true,StatusCode.OK,"根据专栏ID获取文章列表",pageList);
    }

    /*
    * 文章审核
    * */

    @RequestMapping(value = "/examine/{articleId}",method = RequestMethod.PUT)

    public Result ArticleExamine(@PathVariable String articleId){
        tbArticleService.examine(articleId);
        return new Result(true,StatusCode.OK,"文章审核通过");
    }

    /*
    * 头条文章
    * */

    @RequestMapping(value = "/top",method = RequestMethod.GET)

    public Result TopArticle(){
        EntityWrapper<TbArticle> wrapper = new EntityWrapper<>();
        wrapper.eq("istop",true);
        TbArticle tbArticle = tbArticleService.selectOne(wrapper);
        return  new Result(true,StatusCode.OK,"查询头条文章",tbArticle);
    }
}
