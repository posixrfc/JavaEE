package com.atguigu.validation.vliadator;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class IDCardValidator extends FieldValidatorSupport{

	@Override
	public void validate(Object object) throws ValidationException {
		
		//目标：验证用户输入的身份证号是否格式正确
		//1.获取待验证的数据，也就是用户输入的身份证号字符串
		Object obj = getFieldValue(getFieldName(), object);
		
		//如果身份证字符串为空，则停止验证
		if(obj == null) {
			return ;
		}
		
		//2.判断当前用户输入的身份证号是否是合法的
		String idCard = (String) obj;
		IDCard idCardValidator = new IDCard();
		
		//3.如果身份证号格式不正确，则添加一个fieldError
		if(!idCardValidator.Verify(idCard)) {
			addFieldError(getFieldName(), object);
		}
		
	}

}
