package com.projettic.entity;

/**
 * 功能：输出的json字段的值是StatusCode类决定
 * 就是说返回状态的值是成功200还是失败400还是错误404，这些值
 * 是StatusCode这个类定义的。
 */
public enum StatusCode {
    /**
     * 成功
     */
    SUCCESS(200, "Require successfully"),

    /**
     * 没有登录
     */
    NOT_LOGIN(400, "You have not logged in yet!"),

    /**
     * 发生异常
     */
    UNAUTHORIZED(401, "Wrong user name or password!"),

    /**
     * 系统错误
     */
    USER_EXIST(402, "Username or email have already been used"),

    /**
     * 参数错误
     */
    PARAMS_ERROR(403, "Wrong parameter! "),

    /**
     * 不支持或已经废弃
     */
    UNSUCCESS(410, "Error occured! Require unsuccessfully!"),

    /**
     * AuthCode错误
     */
    INVALID_AUTHCODE(444, "无效的AuthCode"),

    /**
     * 太频繁的调用
     */
    TOO_FREQUENT(445, "太频繁的调用"),

    /**
     * 未知的错误
     */
    UNKNOWN_ERROR(499, "未知错误");

    private int code;
    private String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
