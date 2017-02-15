package com.mango.jtt.util;

import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;

import com.mango.jtt.model.ResponseResult;

public class ValidUtil {
	
	protected static final Logger LOGGER = Logger.getLogger(ValidUtil.class);
	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null)
			return true;

		if (obj instanceof CharSequence)
			return ((CharSequence) obj).length() == 0;

		if (obj instanceof Collection)
			return ((Collection) obj).isEmpty();

		if (obj instanceof Map)
			return ((Map) obj).isEmpty();

		if (obj instanceof Object[]) {
			Object[] object = (Object[]) obj;
			if (object.length == 0) {
				return true;
			}
			boolean empty = true;
			for (int i = 0; i < object.length; i++) {
				if (!isNullOrEmpty(object[i])) {
					empty = false;
					break;
				}
			}
			return empty;
		}
		return false;
	}

	public static boolean isBlank(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isLengthValid(String s, int min, int max) {
		int len = s.length();
		if ((len >= min) && (len <= max)) {
			return true;
		}
		return false;
	}

/*	public static String getFirstBindingResultError(BindingResult br) {
		List<FieldError> errs = br.getFieldErrors();
		if (errs.size() > 0) {
			FieldError err = errs.get(0);
			return String.format("%s %s", err.getField(), err.getDefaultMessage());
		}
		return br.getFieldError().getDefaultMessage();
	}*/

	public static boolean isValid(Object obj, BindingResult br, ResponseResult rr) {
		if (obj == null) {
			rr.setStatusCode(ConstUtil.RESPONSECODE_INPUTPARAMNULL);
			return false;

		} else if (br.hasErrors()) {
			rr.setStatusCode(ConstUtil.RESPONSECODE_INPUTPARAMERR);
			rr.setMsg(br.getFieldError().getDefaultMessage());
			LOGGER.fatal(String.format("field=%s, rejectValue=%s, defaultMessage=%s", 
					br.getFieldError().getField(), br.getFieldError().getRejectedValue() == null ? "null" : br.getFieldError().getRejectedValue().toString(), br.getFieldError().getDefaultMessage()));
			return false;
		}

		return true;
	}

	public static boolean isPhoneNum(String phone) {
		if(ValidUtil.isBlank(phone)) {
			return false;
		}
		return phone.matches(ConstUtil.REGEXP_PHONE);
	}
	
	public static boolean isFilter(String filter) {
		return !isBlank(filter);
	}
	
	public static boolean isFilter(int filter, int threshold) {
		return filter > threshold;
	}

}
