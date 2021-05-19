package com.example.easyexcelvalidator.tools;


/**
 * @author momo
 * @describe 业务异常的枚举
 * @date 2018-3-27 14:06
 */
public enum HttpStatusEnum {

    OK(200, "操作成功"),

    /**
     * 错误的请求
     */
    PARAM_NLLL(400, "参数为空"),
    UNAUTHORIZED(401, "没有操作权限"),
    GONE(410, "资源不存在或已删除"),
    SERVER_ERROR(500, "服务器异常"),
    FTP_ERROR(500, "FTP服务器异常"),
    DOWNLOAD_ERROR(500, "文件下载异常"),

    /**
     * token异常
     */
    TOKEN_EXPIRED(700, "Token过期"),
    TOKEN_ERROR(701, "Token验证失败"),
    TOKEN_EMPTY(702, "Token为空"),
    SESSION_EXPIRED(703, "Session过期"),

    /**
     * 签名异常
     */
    SIGN_ERROR(704, "签名验证失败"),

    /**
     * 登录异常
     */
    LOGIN_ERROR(800, "登录异常"),
    UNKNOWN_ACCOUNT_ERROR(801, "账号不存在"),
    DISABLED_ACCOUNT_ERROR(802, "账号被禁用"),
    UNSUPPORTED_TOKEN_ERROR(803, "账号密码非法加密"),
    CREDENTIALS_ERROR(804, "账号或密码错误"),
    AUTHENTICATION_ERROR(805, "登录认证失败"),
    TOO_MANY_LOGIN(806, "短时间内登录次数过多"),
    ACCOUNT_REGISTERED(806, "账号已注册"),
    FIRST_LOGIN(810, "首次登录")
    ;

    private Integer code;
    private String message;

    HttpStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return this.getI18nMsg();
    }

    private String getI18nMsg() {
        try {
            return MessageUtils.message(name());
        } catch (Exception e) {
            return message;
        }
    }
}
