package com.socialContact.QA.socialContactQA.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.socialContact.QA.socialContactQA.entity.TbProblem;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.util.List;

/**
 * <p>
 * 问题 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-04-25
 */
public interface TbProblemMapper extends BaseMapper<TbProblem> {
    @Select("SELECT * FROM tb_problem,tb_pl WHERE id=problemid AND labelid=#{labelid} ORDER BY replytime DESC")
    List<TbProblem> findNewListByLabelId(@Param("labelid") String labelId,Page<TbProblem> page);
    @Select("SELECT * FROM tb_problem,tb_pl WHERE id=problemid AND labelid=#{labelid} ORDER BY reply DESC")
    List<TbProblem> findHotListByLabelId(@Param("labelid") String labelId,Page<TbProblem> page);
    @Select("SELECT * FROM tb_problem,tb_pl WHERE id=problemid AND reply=0 AND labelid=#{labelid} ORDER BY createtime DESC")
    List<TbProblem> findWaitListByLabelId(@Param("labelid") String labelId,Page<TbProblem> page);
    @Select("SELECT * FROM tb_problem,tb_pl WHERE id=problemid AND reply=0 AND labelid=#{labelid} ORDER BY createtime DESC")
    List<TbProblem> test(@Param("labelid") String labelId,Page<TbProblem> page);
}
