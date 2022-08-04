package com.xupt.view.controller;

import com.xupt.common.annotation.SystemLog;
import com.xupt.common.domain.ResponseResult;
import com.xupt.common.entity.Article;
import com.xupt.common.enums.HttpEnum;
import com.xupt.common.exeception.SystemException;
import com.xupt.common.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags="test")
@RestController
public class TestController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/log")
    @SystemLog(businessName="测试日志功能")
    @ApiOperation(value="测试")
    public ResponseResult testHello(){
        return ResponseResult.okResult().msg("Hello world");
    }

    @SystemLog(businessName="测试异常")
    @ApiOperation(value="测试异常")
    @GetMapping("/exce")
    public ResponseResult testExe(){
        throw new SystemException(HttpEnum.SUCCESS);
    }

    @SystemLog(businessName="测试Mp")
    @ApiOperation(value="测试Mp")
    @GetMapping("/mp")
    public ResponseResult testMp(){
        List<Article> list = articleService.list(null);
        return ResponseResult.okResult().data(list);
    }

}
