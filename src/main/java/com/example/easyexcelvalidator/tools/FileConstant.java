package com.example.easyexcelvalidator.tools;

/**
 * 文件常量类
 *
 * @author: Zhangmd
 * @date: 2020/7/23 16:20
 */
public @interface FileConstant {

    /**
     * 文件大小：2MB
     */
    int FILE_SIZE_2MB = 2 * 1024 * 1024;

    /**
     * 文件大小：3MB
     */
    int FILE_SIZE_3MB = 3 * 1024 * 1024;

    /**
     * 文件大小：10MB
     */
    int FILE_SIZE_10MB = 10 * 1024 * 1024;

    /**
     * 文件大小：20MB
     */
    int FILE_SIZE_20MB = 20 * 1024 * 1024;

    /**
     * 文件大小：50MB
     */
    int FILE_SIZE_50MB = 50 * 1024 * 1024;

    /**
     * 文件路径
     */
    String FILE_PATH_FILE = "/file";

    /**
     * 导入数据：日常办公--工资
     */
    String FILE_MODULE_DATA_RCBG_GZ = "/import/data/rcbg/gz";

    /**
     * 导入数据
     */
    String FILE_MODULE_DATA = "/import/data";

    /**
     * 模块路径-Excel模板
     */
    String FILE_MODULE_TEMPLATE = "/import/template";

    /**
     * ZIP文件路径
     */
    String ZIP_PATH_FILE = "/zip";

    /**
     * 公开图片路径
     */
    String FILE_PATH_PUBLIC_IMAGE = "/public/image";

    /**
     * 公开文件路径
     */
    String FILE_PATH_PUBLIC_FILE = "/public/file";

    /**
     * 私有图片路径
     */
    String FILE_PATH_PRIVATE_IMAGE = "/private/image";

    /**
     * 私有文件路径
     */
    String FILE_PATH_PRIVATE_FILE = "/private/file";

    /**
     * 模块路径-富文本
     */
    String FILE_MODULE_TEXTAREA = "/textarea";

    /**
     * 模块路径-公告照片
     */
    String FILE_MODULE_IMG_NOTICE = "/notice";

    /**
     * 审计报告编码
     */
    String FILE_SJBG_CODE = "F001";

    /**
     * 整改计划书
     */
    String FILE_ZGJHS_CODE = "F002";

    /**
     * 整改报告
     */
    String FILE_ZGBG_CODE = "F003";

    /**
     * 评价报告
     */
    String FILE_PJBG_CODE = "F004";

    /**
     * 追责报告
     */
    String FILE_ZZBG_CODE = "F005";
}
