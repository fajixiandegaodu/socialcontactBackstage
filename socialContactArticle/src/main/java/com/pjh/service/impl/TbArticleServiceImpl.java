package com.pjh.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pjh.entity.TbArticle;
import com.pjh.mapper.TbArticleMapper;
import com.pjh.service.TbArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-04
 */
@Service
public class TbArticleServiceImpl extends ServiceImpl<TbArticleMapper, TbArticle> implements TbArticleService {
   @Autowired(required = false)

   private TbArticleMapper tbArticleMapper;

    public void examine(String articleId) {

        tbArticleMapper.examine(articleId);
    }

    public void thumpub(String articleId) {
        tbArticleMapper.thumpub(articleId);
    }
}
