package com.example.easyexcelvalidator;

import com.alibaba.excel.EasyExcel;
import com.example.easyexcelvalidator.entity.MyRow;
import com.example.easyexcelvalidator.entity.MyRowListener;

import javax.validation.Validation;
import javax.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author xuezy
 * @description
 * @date 2021/5/18 15:35
 */
public class main {

	public static Validator validator;

	public static void main(String[] args) throws Exception{

		File file = new File("G:\\1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		// 导入
		EasyExcel.read(fileInputStream, MyRow.class,
				new MyRowListener(validator));

	}

}
