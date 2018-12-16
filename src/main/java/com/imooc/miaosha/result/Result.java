package com.imooc.miaosha.result;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-14 01:06
 * @author: 十一
 */
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;


    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<T>(codeMsg);
    }

    private Result(CodeMsg codeMsg) {
        if(codeMsg == null) return;
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
