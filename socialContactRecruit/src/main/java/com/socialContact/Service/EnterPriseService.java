package com.socialContact.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.socialContact.Dao2.EnterPriseDao;
import com.socialContact.pojo.Enterprise;
import org.omg.IOP.ENCODING_CDR_ENCAPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: EnterPriseService
 * @Author: 86151
 * @Date: 2021/4/22 20:25
 * @Description: TODO
 */
@Service
public class EnterPriseService {
    @Autowired(required = false)
    private EnterPriseDao enterPriseDao;
    /*
    * 查询热门企业
    * */
    public List<Enterprise> findIsHot(){
        return enterPriseDao.findHost();
    }
   /*
   * 查询所有数据
   * */
    public List<Enterprise> findAll() {
        return enterPriseDao.selectList(null);
    }
    /*
    * 添加企业
    * */
    public void addOne(Enterprise enterprise) {
        enterPriseDao.insert(enterprise);
    }
    /*
     * 根据id查询企业
     * */
    public Enterprise findById(String id) {
        Enterprise enterprise = enterPriseDao.selectById(id);
        return enterprise;
    }

   /*
   * 根据条件查询
   *
   * */

    public List<Enterprise> findByCondition(Map<String, Object> condition) {
        EntityWrapper<Enterprise> wrapper = new EntityWrapper<>();
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            wrapper.eq(condition.get(key)!=null,key,condition.get(key));
        }
        List<Enterprise> enterprisesList = enterPriseDao.selectList(wrapper);
        return enterprisesList;

    }
   /*
   * 修改更新操作
   * */
    public void updateById(Enterprise enterprise) {
        enterPriseDao.updateById(enterprise);
    }
}
