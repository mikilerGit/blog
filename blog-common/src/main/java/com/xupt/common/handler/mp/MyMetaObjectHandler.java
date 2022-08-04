package com.xupt.common.handler.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import java.util.Date;

/*
         用注解标识哪些字段在什么情况下需要自动填充

        // 创建人的用户id
        @TableField(fill = FieldFill.INSERT)
        private Long createBy;

        // 创建时间
        @TableField(fill = FieldFill.INSERT)
        private Date createTime;

        // 更新人
        @TableField(fill = FieldFill.INSERT_UPDATE)
        private Long updateBy;

         // 更新时间
        @TableField(fill = FieldFill.INSERT_UPDATE)
        private Date updateTime;

*/

public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
