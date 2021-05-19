package com.example.easyexcelvalidator.service;

import com.alibaba.excel.EasyExcel;
import com.example.easyexcelvalidator.entity.MyRow;
import com.example.easyexcelvalidator.entity.MyRowListener;
import com.example.easyexcelvalidator.tools.JsonResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Objects;

/**
 * @author xuezy
 * @description
 * @date 2021/5/18 18:09
 */
@Service
public class MyRowService {

	// 获取校验器
	private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	private final Validator validator = factory.getValidator();

	// 使用easyExcel
	public JsonResult importExcel(MultipartFile multFile) throws Exception{
		/*********************************** 导入数据 ***************************************/
		MyRowListener myRowListener = new MyRowListener(validator);
		// 这里默认读取第一个sheet
		EasyExcel.read(multFile.getInputStream(), MyRow.class, myRowListener)
				.sheet()
				// 从第几行开始读
				.headRowNumber(3)
				.doRead();
		// 获取校验得到的错误信息 有值直接返回错误信息
		List<String> errorList = myRowListener.getErrorList();
		if (!Objects.isNull(errorList) && errorList.size() > 0) {
			return JsonResult.errorResult(String.join("<br>", errorList));
		}
		// 写入数据成功后 返回正确信息
		return JsonResult.successResult();
	}
}
