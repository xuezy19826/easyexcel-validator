package com.example.easyexcelvalidator.tools;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author momo
 * @describe 获取国际化i18n资源内容
 * @date 2020-3-31 17:19
 */
public class MessageUtils {

    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return 获取国际化翻译值
     */
    public static String message(String code, Object... args) {
        MessageSource messageSource = ApplicationContextHolder.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
