package com.socialContact.QA.socialContactQA.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.socialContact.QA.socialContactQA.entity.TbReply;
import com.socialContact.QA.socialContactQA.mapper.TbReplyMapper;
import com.socialContact.QA.socialContactQA.service.ITbReplyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 回答 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-04-25
 */
@Service
public class TbReplyServiceImpl extends ServiceImpl<TbReplyMapper, TbReply> implements ITbReplyService {
     @Autowired(required = false)
     private TbReplyMapper tbReplyMapper;
     /*
     * 增加回答
     * */

    public void addReply(TbReply tbReply) {
        tbReplyMapper.insert(tbReply);
    }

    /*
    * 查询全部回答
    * */

    public List<TbReply> findAll() {
        List<TbReply> list = tbReplyMapper.selectList(null);
        return list;
    }

    /*
    * 根据id查询数据
    * */

    public TbReply findById(String id) {
        TbReply reply = tbReplyMapper.selectById(id);
        return reply;
    }

    /*
     *修改评论
     * */

    public void update(TbReply tbReply) {

        tbReplyMapper.updateById(tbReply);
    }

   /*
   * 根据信息查找对应的回复信息
   * */

    public List<TbReply> findByPage(Map<String,Object> map, int size, int page) {
        Set<String> keySet = map.keySet();
        EntityWrapper<TbReply> wrapper = new EntityWrapper<>();
        for (String key : keySet) {
            wrapper.eq(map.get(key)!=null,key,map.get(key));
        }
        Page<TbReply> pageData = new Page<>(page, size);
        List<TbReply> list = tbReplyMapper.selectPage(pageData, wrapper);
        return list;
    }

    /*
    * 根据问题id查询数据
    * */

    public List<TbReply> findByProblemId(String problemId) {
        EntityWrapper<TbReply> wrapper = new EntityWrapper<>();
        wrapper.eq("problemid",problemId);
        List<TbReply> list = tbReplyMapper.selectList(wrapper);
        return list;
    }

    /*
    * 根据用户id查询回复
    * */

    public List<TbReply> findByUserId(String userid, int page, int size) {
        EntityWrapper<TbReply> tbReplyEntityWrapper = new EntityWrapper<>();
        tbReplyEntityWrapper.eq("userid",userid);
        Page<TbReply> tbReplyPage = new Page<>(page,size);
        List<TbReply> list = tbReplyMapper.selectPage(tbReplyPage, tbReplyEntityWrapper);
        return list;

    }


}
