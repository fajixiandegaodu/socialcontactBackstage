package com.socialContact.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.socialContact.Dao2.TagDao;
import com.socialContact.pojo.Label;
import com.socialContact.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: TagService
 * @Author: 86151
 * @Date: 2021/4/21 19:40
 * @Description: TODO
 */
/*
* 标签业务逻类
* */
@Service
public class TagService {
    @Autowired(required = false)
    private TagDao tagDao;
    @Autowired
    private IdWorker idWorker;
    /*
    * 查询全部标签
    * */
    public List<Label> selectList() {
        return tagDao.selectList(null);
    }
   /*
   * 根据id查询标签
   * */
    public Label selectById(String id) {
        return tagDao.selectById(id);
    }
    /*
    * 增加标签
    * */
    public void add(Label label){
        label.setId(idWorker.nextId()+"");
        tagDao.insert(label);
    }
    /*
    * 修改标签
    * */
    public void update(Label label){
        tagDao.updateById(label);
    }
    /*
    * 删除标签
    * */
    public void deleteById(String id){
        tagDao.deleteById(id);
    }
    /*
    * 根据条件分页查询
    *
    * */
    public Page<Label> findByPage(Map<String,Object> map,Integer page, Integer size){
        EntityWrapper<Label> wrapper = new EntityWrapper<>();
        Set<String> strings = map.keySet();
        for (String key : strings) {
            wrapper.eq(map.get(key)!=null,key,map.get(key));
        }
        /*设置分页参数*/
        Page<Label> pageData = new Page<>(page, size);
        /*执行查询，
        第一个是分页参数
        第二个是查询条件*/
        List<Label> labels = tagDao.selectPage(pageData, wrapper);

        /*加入查询到的数据*/
        pageData.setRecords(labels);
        return pageData;
    }
    /*
    带条件的不分页查询
    */
    public List<Label> findByCondtion(Map<String,Object> map){
        EntityWrapper<Label> wrapper = new EntityWrapper<>();
        Set<String> strings = map.keySet();
        for (String key : strings) {
            wrapper.eq(map.get(key)!=null,key,map.get(key));
        }

        List<Label> labels = tagDao.selectList(wrapper);

        return labels;
    }
}
