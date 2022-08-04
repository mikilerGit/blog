package com.xupt.common.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xupt.common.domain.ResponseResult;
import com.xupt.common.entity.Article;

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();
}

