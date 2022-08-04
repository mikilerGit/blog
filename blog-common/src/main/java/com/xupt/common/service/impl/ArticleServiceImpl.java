package com.xupt.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xupt.common.domain.ResponseResult;
import com.xupt.common.mapper.ArticleMapper;
import com.xupt.common.entity.Article;
import com.xupt.common.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ResponseResult hotArticleList() {
        //
        ArrayList<Article> articleList=articleMapper.hotArticleList();


        return ResponseResult.okResult().data(articleList);
    }
}


