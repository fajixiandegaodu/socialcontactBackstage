package com.socialContact.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.socialContact.Dao2.RecruitDao;
import com.socialContact.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: RecruitService
 * @Author: 86151
 * @Date: 2021/4/23 19:38
 * @Description: TODO
 */
@Service
public class RecruitService {
    @Autowired(required = false)
    private RecruitDao recruitDao;
    public void addRecruit(Recruit recruit) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        recruit.setCreatetime(format);
        recruitDao.insert(recruit);
    }

    public List<Recruit> findAll() {
        List<Recruit> recruits = recruitDao.selectList(null);
        return recruits;
    }

    /*
    * 根据id 查询信息
    * */


    public Recruit findById(String id) {
        Recruit recruit = recruitDao.selectById(id);
        return recruit;
    }

    /*
    * 根据id更新信息
    * */


    public void updateById(Recruit recruit) {
        recruitDao.updateById(recruit);
    }

    /*
    * 根据id删除招聘信息
    * */

    public void deleteById(Recruit recruit) {
        recruitDao.deleteById(recruit);
    }

    public List<Recruit> findByCondition(Map<String,Object> map) {
        EntityWrapper<Recruit> wrapper = new EntityWrapper<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            wrapper.eq(map.get(key)!=null,key,map.get(key));
        }
        List<Recruit> list = recruitDao.selectList(wrapper);
        return list;
    }

    /*
    * 招聘企业分页查询
    * */

    public List<Recruit> findByPage(int page, int size) {
        Page<Recruit> pageDate = new Page<>(page, size);
        List<Recruit> list = recruitDao.selectPage(pageDate, null);
        return list;
    }

    /*
    * 查询推荐的职位
    * */

    public List<Recruit> findByState() {
        EntityWrapper<Recruit> wrapper = new EntityWrapper<>();
        wrapper.eq("state","2");
        List<Recruit> list = recruitDao.selectList(wrapper);
        return list;
    }

    /*
    * 返回最新的职位
    * */

    public List<Recruit> findNewList() {
        EntityWrapper<Recruit> wrapper = new EntityWrapper<>();
        wrapper.orderDesc(Arrays.asList(new String[] {"createtime"}));
        Page<Recruit> PageDate = new Page<>(1, 2);
        List<Recruit> list = recruitDao.selectPage(PageDate,wrapper);

        return list;
    }
}
