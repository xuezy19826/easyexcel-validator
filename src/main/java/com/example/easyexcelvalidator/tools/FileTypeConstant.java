package com.example.easyexcelvalidator.tools;

/**
 * @author momo
 * @describe 定义文件常用类型对应的MimeType
 * @date 2020-4-15 16:09
 */
public @interface FileTypeConstant {

    /**
     * word(.doc)
     */
    String WORD_03 = "application/msword";
    /**
     * word(.docx)
     */
    String WORD = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    /**
     * excel(.xls)
     */
    String EXCEL_03 = "application/vnd.ms-excel";
    /**
     * excel(.xlsx)
     */
    String EXCEL = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    /**
     * excel(.xlsm)
     */
    String EXCEL_M = "application/vnd.ms-excel.sheet.macroenabled.12";

    /**
     * powerpoint(.ppt)
     */
    String PPT_03 = "application/vnd.ms-powerpoint";
    /**
     * powerpoint(.pptx)
     */
    String PPT = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
    /**
     * pdf
     */
    String PDF = "application/pdf";
    /**
     * rar
     */
    String RAR = "application/x-rar-compressed";
    /**
     * zip
     */
    String ZIP = "application/zip";
    /**
     * 图片文件
     */
    String IMAGE = "image/*";
    /**
     * jpg 图片文件
     */
    String JPG = "image/jpeg";
    /**
     * png 图片文件
     */
    String PNG = "image/png";
    /**
     * gif 图片文件
     */
    String GIF = "image/gif";
    /**
     * PSD 文件
     */
    String PSD = "image/vnd.adobe.photoshop";
    /**
     * SVG 文件
     */
    String SVG = "image/svg+xml";
    /**
     * DWG 文件
     */
    String DWG = "image/vnd.dwg";
    /**
     * EPS文件
     */
    String EPS = "application/postscript";
    /**
     * 视频文件
     */
    String VIDEO = "video/*";
    /**
     * 音频文件
     */
    String audio = "audio/*";
    /**
     * 纯文本
     */
    String TXT = "text/plain";
    /**
     * css文件
     */
    String CSS = "text/css";
    /**
     * html文件
     */
    String HTML = "text/html";
    /**
     * java源代码
     */
    String JAVA = "text/x-java-source";
    /**
     * c源代码
     */
    String C = "text/x-csrc";
    /**
     * c++源代码
     */
    String C__ = "text/x-c++src";
    /**
     * .exe
     */
    String EXE = "application/octet-stream";
}
