package com.imooc.miaosha.result;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-14 01:12
 * @author: 十一
 */
public class CodeMsg {

    private String msg;

    private Integer code;

    public static CodeMsg SUCCESS = new CodeMsg(0,"success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务端异常");



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CodeMsg(Integer code,String msg) {
        this.msg = msg;
        this.code = code;
    }


}
