package com.socialContact.Dao2;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.socialContact.pojo.Enterprise;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: EnterPriseDao
 * @Author: 86151
 * @Date: 2021/4/22 19:48
 * @Description: TODO
 */
public interface EnterPriseDao extends BaseMapper<Enterprise> {
    @Select("select * from tb_enterprise where ishot= 1 ")
    List<Enterprise> findHost();
}
