package com.example.easyexcelvalidator.tools;

import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaMetadataKeys;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author momo
 * @describe 读取文件类型
 * 依赖于 apache.tika.core
 * @date 2020-4-8 19:33
 */
public class FileTypeKit {

    /**
     * 常见文件类型
     *
     * MimeType	                                                                    文件类型
     *
     * application/msword	                                                        word(.doc)
     * application/vnd.ms-powerpoint	                                            powerpoint(.ppt)
     * application/vnd.ms-excel	                                                    excel(.xls)
     * application/vnd.openxmlformats-officedocument.wordprocessingml.document	    word(.docx)
     * application/vnd.openxmlformats-officedocument.presentationml.presentation	powerpoint(.pptx)
     * application/vnd.openxmlformats-officedocument.spreadsheetml.sheet	        excel(.xlsx)
     * application/x-rar-compressed	                                                rar
     * application/zip	                                                            zip
     * application/pdf	                                                            pdf
     * video/*	                                                                    视频文件
     * image/*	                                                                    图片文件
     * text/plain	                                                                纯文本
     * text/css	                                                                    css文件
     * text/html	                                                                html文件
     * text/x-java-source	                                                        java源代码
     * text/x-csrc	                                                                c源代码
     * text/x-c++src	                                                            c++源代码
     */

    /**
     * @describe 获取文件类型
     * @author momo
     * @date 2020-4-8 19:38
     * @param file
     * @return java.lang.String
     */
    public static String getMimeType(File file) throws Exception {
        if (file.isDirectory()) {
            throw new Exception("file是目录，不是文件");
        }
        AutoDetectParser parser = new AutoDetectParser();
        parser.setParsers(new HashMap<MediaType, Parser>());

        Metadata metadata = new Metadata();
        metadata.add(TikaMetadataKeys.RESOURCE_NAME_KEY, file.getName());
        try (InputStream stream = new FileInputStream(file)) {
            parser.parse(stream, new DefaultHandler(), metadata, new ParseContext());
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return metadata.get(HttpHeaders.CONTENT_TYPE);
    }

    /**
     * @describe 获取文件类型
     * @author momo
     * @date 2020-4-13 17:38
     * @param inputStream
     * @param fileName
     * @return java.lang.String
     */
    public static String getMimeType(InputStream inputStream, String fileName) {
        AutoDetectParser parser = new AutoDetectParser();
        parser.setParsers(new HashMap<MediaType, Parser>());

        Metadata metadata = new Metadata();
        metadata.add(TikaMetadataKeys.RESOURCE_NAME_KEY, fileName);
        try {
            parser.parse(inputStream, new DefaultHandler(), metadata, new ParseContext());
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return metadata.get(HttpHeaders.CONTENT_TYPE);
    }

    /**
     * @describe 判断是否是图片
     * @author momo
     * @date 2020-4-8 19:41
     * @param file
     * @return boolean
     */
    public static boolean isImage(File file) throws Exception {
        String type = FileTypeKit.getMimeType(file);
        Pattern image = Pattern.compile(PatternConstant.IMAGE);
        Matcher m = image.matcher(type);
        return m.matches();
    }

    /**
     * @describe 判断是否是图片
     * @author momo
     * @date 2020-4-15 15:19
     * @param inputStream
     * @return boolean
     */
    public static boolean isImage(InputStream inputStream) {
        String type = FileTypeKit.getMimeType(inputStream, null);
        Pattern image = Pattern.compile(PatternConstant.IMAGE);
        Matcher m = image.matcher(type);
        return m.matches();
    }
}
