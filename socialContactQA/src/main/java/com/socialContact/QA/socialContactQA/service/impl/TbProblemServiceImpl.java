package com.socialContact.QA.socialContactQA.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.socialContact.QA.socialContactQA.entity.TbProblem;
import com.socialContact.QA.socialContactQA.mapper.TbProblemMapper;
import com.socialContact.QA.socialContactQA.service.ITbProblemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 问题 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-04-25
 */
@Service
public class TbProblemServiceImpl extends ServiceImpl<TbProblemMapper, TbProblem> implements ITbProblemService {
    @Autowired(required = false)
    private TbProblemMapper tbProblemMapper;
    /*
    * 根据条件查询
    * */
    public List<TbProblem> selectByCondition(Map<String, Object> map) {
        Set<String> keySet = map.keySet();
        EntityWrapper<TbProblem> wrapper = new EntityWrapper<>();
        for (String key : keySet) {
            wrapper.eq(map.get(key)!=null,key,map.get(key));
        }
        List<TbProblem> tbProblems = tbProblemMapper.selectList(wrapper);
        return tbProblems;
    }
    /*
    * 根据条件分页查询
    * */

    public List<TbProblem> selectByCondition(Map<String, Object> map, int page, int size) {
        Set<String> keySet = map.keySet();
        EntityWrapper<TbProblem> wrapper = new EntityWrapper<>();
        for (String key : keySet) {
            wrapper.eq(map.get(key)!=null,key,map.get(key));
        }
        Page<TbProblem> pageData = new Page<>(page, size);
        List<TbProblem> tbProblems = tbProblemMapper.selectPage(pageData, wrapper);
        return tbProblems;
    }

    /*
    * 查询最新回答问题列表
    * */

    public List<TbProblem> findNewList(String label, int page, int size) {
        Page<TbProblem> pageData = new Page<>(page, size);
        List<TbProblem> list = tbProblemMapper.findNewListByLabelId(label,pageData);

        return list;
    }
   /*
   * 查询正在等待回答的问题列表
   * */

    public List<TbProblem> findWaitList(String label, int page, int size) {
        Page<TbProblem> pageData = new Page<>(page, size);
        List<TbProblem> list=tbProblemMapper.findWaitListByLabelId(label,pageData);
        return list;
    }

    /*
    * 查询热门回答问题列表
    * */

    public List<TbProblem> findHotList(String label, int page, int size) {
        Page<TbProblem> pageData = new Page<>(page, size);
        List<TbProblem> hotListByLabelId = tbProblemMapper.findHotListByLabelId(label,pageData);
        return hotListByLabelId;
    }


    /*
     * 查询热门回答问题列表
     * */

    public List<TbProblem> test(String label, int page, int size) {
        Page<TbProblem> pageData = new Page<>(page, size);
        List<TbProblem> list= tbProblemMapper.test(label, pageData);
        return list;
    }



}
