package com.socialContact.QA.socialContactQA.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.socialContact.QA.socialContactQA.entity.TbProblem;
import com.socialContact.QA.socialContactQA.entity.TbReply;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.awt.print.Pageable;

/**
 * <p>
 * 回答 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-04-25
 */
public interface TbReplyMapper extends BaseMapper<TbReply> {

}
