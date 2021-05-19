package com.example.easyexcelvalidator.controller;

import com.example.easyexcelvalidator.service.MyRowService;
import com.example.easyexcelvalidator.tools.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author xuezy
 * @description
 * @date 2021/5/18 17:52
 */
@Slf4j
@Controller
public class MyRowController {

	@Autowired
	private MyRowService myRowService;
	/**
	 * @describe 导入excel
	 * @param file  文件
	 * @return top.uecom.core.utils.JsonResult
	 */
	@PostMapping("/uploadExcel")
	@ResponseBody
	public JsonResult uploadFile(@RequestParam(value = "file") MultipartFile file) {
		try {
			// 获取文件类型
			String fileType = FileTypeKit.getMimeType(file.getInputStream(), file.getOriginalFilename());
			// 校验文件格式
			if (!FileTypeConstant.EXCEL.equalsIgnoreCase(fileType)
					&& !FileTypeConstant.EXCEL_03.equalsIgnoreCase(fileType)) {
				// 请上传正确格式的图片
				return JsonResult.errorResult("请上传Excel格式的文件！");
			}
			// 判断文件大小
			long size = file.getSize();
			if (size > FileConstant.FILE_SIZE_20MB) {
				return JsonResult.errorResult("文件大小不能超过20M！");
			}
			// 导入
			return myRowService.importExcel(file);
		} catch (Exception e2) {
			log.error("导入excel数据错误[{}]", e2);
			return JsonResult.errorResult();
		}
	}
}
