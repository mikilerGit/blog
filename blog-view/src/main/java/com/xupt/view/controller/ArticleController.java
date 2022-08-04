package com.xupt.view.controller;

import com.xupt.common.annotation.SystemLog;
import com.xupt.common.domain.ResponseResult;
import com.xupt.common.enums.HttpEnum;
import com.xupt.common.exeception.SystemException;
import com.xupt.common.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/article")
public class ArticleController{
    @Autowired
    private ArticleService articleService;

    // 热门文章列表
    @GetMapping("/hot")
    public ResponseResult hotArticleList(){
        return articleService.hotArticleList();
    }

}

