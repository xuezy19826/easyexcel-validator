package com.example.easyexcelvalidator.tools;

/**
 * @author momo
 * @describe 定义常用正则表达式
 * @date 2020-4-8 19:43
 */
public @interface PatternConstant {

    /**
     * 邮箱
     */
    String EMAIL = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";

    /**
     * 手机号
     */
    String PHONE = "^1([3-9])\\d{9}$";

    /**
     * 电话号：区号+座机号码+分机号码
     */
    String TEL = "^(0[0-9]{2,3}-)?([2-9][0-9]{6,7})+(-[0-9]{1,4})?$";

    /**
     * 网址
     */
    String URL = "^((http:\\/\\/)|(https:\\/\\/))?([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}(\\/)";

    /**
     * 日期
     */
    String DATE = "^(\\d{4})[-\\/](\\d{1}|0\\d{1}|1[0-2])([-\\/](\\d{1}|0\\d{1}|[1-2][0-9]|3[0-1]))*$";

    /**
     * IP地址
     */
    String IP = "((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))";

    /**
     * 20902个常用汉字
     */
    String CHINESE = "^[\\u4e00-\\u9fa5]{0,}$";

    /**
     * 图片
     */
    String IMAGE = "image/.*";

    /**
     * 视频
     */
    String VIDEO = "video/*";


}
