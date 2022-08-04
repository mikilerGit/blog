package com.xupt.common.mapper;

import com.xupt.common.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ArticleMapper extends BaseMapper<Article>{

    ArrayList<Article> hotArticleList();
}
