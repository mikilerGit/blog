package com.xupt.common.domain;

import com.xupt.common.enums.HttpEnum;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
*  1. 定义响应枚举 解耦代码  enums/ HttpEnum
*
*  2. 定义响应类
*
* */


/*
 * 1.  HttpEnum 的构造函数
 *
 * 2. 通过 HttpEnum 的构造函数 构造 okResult errorResult
 *
 * 3. 构造三个属性的链式函数
 *
 * */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {


    private Integer code;
    private String msg;
    private T data;

    public ResponseResult(HttpEnum httpEnum) {
        this.code = httpEnum.getCode();
        this.msg = httpEnum.getMsg();
    }

    public static ResponseResult okResult() {
        return new ResponseResult(HttpEnum.SUCCESS);
    }

    public static ResponseResult errorResult() {
        return new ResponseResult(HttpEnum.ERROR);
    }

    public ResponseResult data(T data) {
        this.setData(data);
        return this;
    }

    public ResponseResult msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public ResponseResult code(Integer code) {
        this.setCode(code);
        return this;
    }

}
