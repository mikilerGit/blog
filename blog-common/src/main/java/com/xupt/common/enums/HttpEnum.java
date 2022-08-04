package com.xupt.common.enums;
/*
*  和普通的bean一样，需要构造方法等 只不过没有set方法 原因在于 不需要set方法
*
*  和普通的bean 区别在于 实例化对象的不同 与 没有set方法
*/
public enum HttpEnum {
    SUCCESS(200,"请求服务器成功！"),
    ERROR(500,"请求服务器失败！"),
    ;


    private Integer code;
    private String msg;

    HttpEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
