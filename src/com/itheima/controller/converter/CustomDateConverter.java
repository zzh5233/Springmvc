package com.itheima.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomDateConverter implements Converter<String,Date>{

	@Override
	public Date convert(String source) {
		
		//实现将日期字符串转换成日期类型（格式是yyyy-MM-dd HH:mm:ss）
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			//转换成功直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//转换失败返回null
		return null;
	}

}
