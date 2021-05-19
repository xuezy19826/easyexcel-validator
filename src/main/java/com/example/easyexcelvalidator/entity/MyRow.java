package com.example.easyexcelvalidator.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class MyRow{

    @ExcelProperty(value = "序号")
    @NotBlank(message = "序号不能为空")
    private String xh;

    @ExcelProperty(value = "所在单位")
    private String unit;

    @Length(max = 10, message = "姓名长度不能超过10")
    @ExcelProperty(value = "姓名")
    private String name;

}
