package com.pjh.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pjh.entity.TbArticle;
import org.apache.ibatis.annotations.Update;

import javax.websocket.server.PathParam;

/**
 * <p>
 * 文章 Mapper 接口
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-04
 */
public interface TbArticleMapper extends BaseMapper<TbArticle> {
    @Update("update tb_article set state='1' where id=#{articleId} ")
    void examine(@PathParam("articleId") String articleId);
    @Update("update tb_article set thumbup=thumbup+1 where id=#{articleId}")
    void thumpub(@PathParam("articleId") String articleId);
}
