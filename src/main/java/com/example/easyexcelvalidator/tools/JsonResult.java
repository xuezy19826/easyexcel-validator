package com.example.easyexcelvalidator.tools;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author momo
 * @describe 封装ajax请求返回json对象
 * @date 2017-9-14 10:51
 * <p>
 * JsonResult 采用建造者（Builder）模式，通过流式API调用，仅限类内部调用
 * </p>
 */
@Data
public class JsonResult implements Serializable {

    /**
     * 成功 true 失败 false
     */
    private final boolean success;

    /**
     * 返回代码（成功：200：失败：非200）
     */
    private final Integer code;

    /**
     * 返回消息
     */
    private final String msg;

    /**
     * 返回数据对象
     */
    private final Object data;

    /**
     * 扩展属性
     */
    private final Object extend;

    /**
     * 总记录数
     */
    private final Integer count;

    /**
     * 时间戳
     */
    private final long time;


    /**
     * 私有静态成员类
     * 用来构造JsonResult中的参数成员
     */
    private static class Result {
        // 必传参数
        private final boolean success;
        private final Integer code;
        private final String msg;

        //可选参数
        private Object data;
        private Object extend;
        private Integer count;

        /**
         * 必选参数调用此构造器
         */
        private Result(boolean success, Integer code, String msg) {
            this.success = success;
            this.code = code;
            this.msg = msg;
        }

        /**
         * 设置data值
         */
        public Result data(Object data) {
            this.data = data;
            return this;
        }

        /**
         * 设置extend值
         */
        public Result extend(Object extend) {
            this.extend = extend;
            return this;
        }

        /**
         * 设置count值
         */
        public Result count(Integer count) {
            this.count = count;
            return this;
        }

        /**
         * 构造JsonResult对象
         */
        private JsonResult build() {
            return new JsonResult(this);
        }
    }

    /**
     * 禁止外部new创建对象
     * 通过构造Result来传递参数
     */
    private JsonResult(Result result) {
        this.success = result.success;
        this.code = result.code;
        this.msg = result.msg;
        this.data = result.data;
        this.extend = result.extend;
        this.count = result.count;
        this.time = System.currentTimeMillis();
    }

    /***
     * @describe 执行成功返回对象（默认）
     * @author momo
     * @date 2018-10-31 19:02
     * @params []
     * @return cn.momo.core.utils.JsonResult
     */
    public static JsonResult successResult() {
        return new Result(true, HttpStatusEnum.OK.getCode(), HttpStatusEnum.OK.getMessage()).build();
    }

    /**
     * @return cn.momo.core.utils.JsonResult
     * @describe 执行失败返回对象（默认500异常）
     * @author momo
     * @date 2018-3-27 12:25
     * @params [data]
     */
    public static JsonResult errorResult() {
        return errorResult(HttpStatusEnum.SERVER_ERROR);
    }

    /**
     * @return cn.momo.core.utils.JsonResult
     * @describe 执行失败返回对象（自定义返回状态）
     * @author momo
     * @date 2018-3-27 12:25
     * @params [data]
     */
    public static JsonResult errorResult(HttpStatusEnum httpStatusEnum) {
        return errorResult(httpStatusEnum, httpStatusEnum.getMessage());
    }

    /**
     * @return cn.momo.core.utils.JsonResult
     * @describe 执行失败返回对象（默认500异常，自定义消息）
     * @author momo
     * @date 2018-6-21 23:25
     * @params [msg]
     */
    public static JsonResult errorResult(String msg) {
        return errorResult(HttpStatusEnum.SERVER_ERROR, msg);
    }

    /***
     * @describe 执行失败返回对象（自定义代码，自定义消息）
     * @author momo
     * @date 2018-10-31 19:13
     * @params [httpStatusEnum, msg]
     * @return cn.momo.core.utils.JsonResult
     */
    public static JsonResult errorResult(HttpStatusEnum httpStatusEnum, String msg) {
        return new Result(false, httpStatusEnum.getCode(), msg).build();
    }

    /**
     * @describe 执行失败返回对象（自定义代码，自定义消息，自定义扩展消息）
     * @author momo
     * @date 2019-12-23 17:04
     * @param httpStatusEnum
     * @param msg
     * @param extend
     * @return top.uecom.core.utils.JsonResult
     */
    public static JsonResult errorResult(HttpStatusEnum httpStatusEnum, String msg, String extend) {
        return new Result(false, httpStatusEnum.getCode(), msg).extend(extend).build();
    }

    @Override
    public String toString() {
        //返回json字符串
        return JSONObject.toJSONString(this);
    }
}
