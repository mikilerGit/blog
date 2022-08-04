package com.xupt.common.exeception;

import com.xupt.common.enums.HttpEnum;

/*
*       1. 实际我们在开发过程中可能需要做很多的判断校验，如果出现了非法情况,我们是期望响应对应的提示的。但是如果我们每次都自己手动去处理就会非常麻烦。
*
*       2. 我们可以选择直接抛出异常的方式，然后对异常进行统一处理。把异常中的信息封装成ResponseResult响应给前端。
*
*       3. 例如 根据前端传的用户名查找 用户，未查找到用户, 抛出异常，一个自定义的异常，然后处理异常 返回 ResponseResult
* */

/*
*       1.创建异常包  自定义系统异常  通过枚举 快速赋值异常信息
*
*       2.创建handler/exeception 包 创建全局异常处理类 统一异常处理
* */
public class SystemException extends RuntimeException{
    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public SystemException(HttpEnum httpEnum) {
        super(httpEnum.getMsg());
        this.code = httpEnum.getCode();
        this.msg = httpEnum.getMsg();
    }
}
