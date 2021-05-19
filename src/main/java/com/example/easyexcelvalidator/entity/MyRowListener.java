package com.example.easyexcelvalidator.entity;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author xuezy
 * @description
 * @date 2021/5/18 15:39
 */
@Slf4j
public class MyRowListener extends AnalysisEventListener<MyRow> {

	private Validator validator;

	/**
	 * 每隔100条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
	 */
	private static final int BATCH_COUNT = 100;

	private List<MyRow> myRowList = new ArrayList<>();

	/**
	 * 缓存错误信息
	 */
	private List<String> errorList = new ArrayList<>();

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	/**
	 * 由于listener不用被spring管理，所需参数可以由构造方法传入
	 */
	public MyRowListener(Validator validator){
		this.validator = validator;
	}

	@Override
	public void invoke(MyRow data, AnalysisContext analysisContext) {
		// 获取行数
		Integer rowIndex = analysisContext.readRowHolder().getRowIndex() + 1;
		// 校验
		validParams(data, rowIndex, validator);
		log.info("解析到一条数据:{}", JSON.toJSONString(data));
		myRowList.add(data);

		// 分批次导入
		//		if (list.size() >= BATCH_COUNT) {
//			saveData();
//			list.clear();
//		}
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		// 解析完成
		log.info("list size:{}", myRowList.size());
		System.out.println("list size:" + myRowList.size());
		// 所有信息解析完成后，无错误信息 写入信息到数据库  有错误信息 不写入
		if(!Objects.isNull(errorList) && errorList.size() > 0){
			//		saveData();
		}
	}

	/**
	 * @describe 校验参数
	 * @author xuezy
	 * @date 2021/5/18 15:47
	 * @param t	对象
	 * @param rowIndex 行数
	 * @param validator 校验
	 * @return void
	 */
	public void validParams(Object t, Integer rowIndex, Validator validator){
		StringBuffer sf = new StringBuffer();
		Set<ConstraintViolation<Object>> set = validator.validate(t);
		for(ConstraintViolation<Object> constraintViolation : set){
			log.error("第{}行：{}", rowIndex, constraintViolation.getMessage());
			System.out.println("第" + rowIndex + "行：" + constraintViolation.getMessage());
			sf.append("第").append(rowIndex).append("行：").append(constraintViolation.getMessage()).append(";");
		}
		String str = sf.toString();
		if(!StringUtils.isEmpty(str)){
			errorList.add(str);
		}
	}

	/**
	 * 存储数据库
	 */
	private void saveData() {
		log.info("{}条数据，开始存储数据库！", myRowList.size());
		log.info("存储数据库成功！");
	}
}
