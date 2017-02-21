package com.mango.jtt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class Validator {

	/**
	 * @Description: 是否是格式为yyyy-MM-dd的时间
	 * @param @param inputDate
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:06:11
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isDateTime(String inputDate) {
		String DATE_TIME_FORMAT = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				DATE_TIME_FORMAT, Locale.CHINA);
		simpleDateFormat.setLenient(false);
		boolean check = false;
		try {
			simpleDateFormat.parse(inputDate);
			check = true;
		} catch (Exception ex) {
			check = false;
			ex.printStackTrace();
		}

		return check;
	}

	/**
	 * @Description: 此方法判断输入字符是否为数字0到9 是返回true不是返回false
	 * @param @param c
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:10:13
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isDigit(char c) {
		return (('0' <= c) && (c <= '9'));
	}

	/**
	 * @Description: 此方法判断输入字符串是否为数字0到正无穷 是返回true不是返回false
	 * @param @param inputStr
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:12:14
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isDigit(String inputStr) {
		char tempChar;
		for (int i = 0; i < inputStr.length(); i++) {
			tempChar = inputStr.charAt(i);
			// 如果字符中有一个字符不是数字则返回false
			if (!isDigit(tempChar)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @Description: 此方法判断输入字符是否为字母a-z或A-Z 是返回true不是返回false
	 * @param @param c
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:14:16
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isAlpha(char c) {
		return ((('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z')));
	}

	/**
	 * @Description: 此方法判断输入字符串是否为字母a-z或A-Z 是返回true不是返回false
	 * @param @param inputStr
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:14:28
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isAlpha(String inputStr) {
		char tempChar;
		for (int i = 0; i < inputStr.length(); i++) {
			tempChar = inputStr.charAt(i);
			if (!isAlpha(tempChar)) { // 如果字符中有一个字符不是字母则返回false
				return false;
			}
		}
		return true;
	}

	/**
	 * @Description: 此方法用于检查密码或用户名是否合法，用户名密码只能使用英文字母、数字以及-和_，并且首字符必须为字母或数字
	 *               密码首字符必须为字母或数字
	 * @param @param inputStr
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:14:55
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean checkUserNamePassword(String inputStr) {
		for (int nIndex = 0; nIndex < inputStr.length(); nIndex++) {
			char cCheck = inputStr.charAt(nIndex);
			if (nIndex == 0 && (cCheck == '-' || cCheck == '_')) {
				return false;
			}
			if (!(isDigit(cCheck) || isAlpha(cCheck) || cCheck == '-' || cCheck == '_')) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @Description: 此方法检查email有效性 返回提示信息
	 * @param @param email
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:15:09
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean checkEmail(String email) {
		// 电子邮件
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		boolean isMatched = matcher.matches();

		return isMatched;
	}

	/**
	 * @Description: 此方法检查输入的身份证号有效性 返回提示信息 如果返回布尔类型则通过验证
	 *               同isIDCardValidate(String s) 1、号码的结构
	 *               公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成
	 *               。排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码， 三位数字顺序码和一位数字校验码。
	 * 
	 *               2、地址码(前六位数） 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。
	 * 
	 *               3、出生日期码（第七位至十四位）
	 *               表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。
	 * 
	 *               4、顺序码（第十五位至十七位）
	 *               表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配给女性。
	 * 
	 *               5、校验码（第十八位数） （1）十七位数字本体码加权求和公式 S = Sum(Ai * Wi), i = 0, ,16
	 *               ，先对前17位数字的权求和 Ai:表示第i位置上的身份证号码数字值 Wi:表示第i位置上的加权因子 Wi: 7 9
	 *               10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 （2）计算模 Y = mod(S, 11)
	 *               （3）通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6
	 *               5 4 3 2
	 * @param @param IDNumber
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:15:20
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isIDNumber(String IDNumber) {
		boolean result = IDNumber.matches("[0-9]{15}|[0-9]{17}[0-9X]");
		if (result) {
			int year, month, date;
			if (IDNumber.length() == 15) {
				year = Integer.parseInt(IDNumber.substring(6, 8));
				month = Integer.parseInt(IDNumber.substring(8, 10));
				date = Integer.parseInt(IDNumber.substring(10, 12));
			} else {
				year = Integer.parseInt(IDNumber.substring(6, 10));
				month = Integer.parseInt(IDNumber.substring(10, 12));
				date = Integer.parseInt(IDNumber.substring(12, 14));
			}
			switch (month) {
			case 2:
				result = (date >= 1)
						&& (year % 4 == 0 ? date <= 29 : date <= 28);
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				result = (date >= 1) && (date <= 31);
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				result = (date >= 1) && (date <= 31);
				break;
			default:
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * @Description: 判断手机号码是否合法
	 * @param @param handset
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:19:19
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isHandset(String handset) {
		try {
			if (!handset.substring(0, 1).equals("1")) {
				return false;
			}
			if (handset == null || handset.length() != 11) {
				return false;
			}
			// String check = "^[0123456789]+$";
			String check = "^1[3-8]\\d{9}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(handset);

			return matcher.matches();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @Description: 判断大陆地区固话及小灵通 区号：010,020,021,022,023,024,025,027,028,029
	 * @param @param tel
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:19:31
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isFixedLineTel(String tel) {
		try {
			String check = "^0(10|2[0-5789]|\\d{3})\\d{7,8}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(tel);
			return matcher.matches();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @Description: 验证是否包含中文
	 * @param @param str
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:19:43
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean containChinese(String str) {
		// String check = "^[\u4e00-\u9fa5]{1,}$";

		String check = "^[\\u4e00-\\u9fa5]+?";

		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(str);

		return matcher.find();
	}

	/**
	 * @Description: 验证是否包含空格
	 * @param @param str
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:19:53
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean containBlank(String str) {
		if (str.length() > str.replace(" ", "").length()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Description: 验证用户名是否只含中英文和数字
	 * @param @param userName
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:20:09
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isUserName(String userName) {
		String check = "^[\\u4E00-\\u9FA5A-Za-z0-9]+$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(userName);

		return matcher.matches();
	}

	/**
	 * @Description: 身份证的有效验证，无效会提示 同isIDNumber(Strings)
	 * @param @param IDStr
	 * @param @return
	 * @param @throws ParseException 设定文件
	 * @date 创建时间：2017-2-21 上午10:23:12
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isIDCardValidate(String IDStr) throws ParseException {
		String errorInfo = "";// 记录错误信息
		String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
				"3", "2" };
		String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
				"9", "10", "5", "8", "4", "2" };
		// String[] Checker = {"1","9","8","7","6","5","4","3","2","1","1"};
		String Ai = "";

		// ================ 号码的长度 15位或18位 ================
		if (IDStr.length() != 15 && IDStr.length() != 18) {
			errorInfo = "号码长度应该为15位或18位。";
			System.out.println(errorInfo);
			return false;
		}
		// ================ 数字 除最后以为都为数字 ================
		if (IDStr.length() == 18) {
			Ai = IDStr.substring(0, 17);
		} else if (IDStr.length() == 15) {
			Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
		}
		if (isDigit(Ai) == false) {
			errorInfo = "15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
			System.out.println(errorInfo);
			return false;
		}
		// ================ 出生年月是否有效 ================
		String strYear = Ai.substring(6, 10);// 年份
		String strMonth = Ai.substring(10, 12);// 月份
		String strDay = Ai.substring(12, 14);// 月份

		if (isDateTime(strYear + "-" + strMonth + "-" + strDay) == false) {
			errorInfo = "生日无效。";
			System.out.println(errorInfo);
			return false;
		}

		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
				|| (gc.getTime().getTime() - s.parse(
						strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
			errorInfo = "生日不在有效范围。";
			System.out.println(errorInfo);
			return false;
		}
		if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
			errorInfo = "月份无效";
			System.out.println(errorInfo);
			return false;
		}
		if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
			errorInfo = "日期无效";
			System.out.println(errorInfo);
			return false;
		}
		// ================ 地区码时候有效 ================
		Hashtable<String, String> h = GetAreaCode();
		if (h.get(Ai.substring(0, 2)) == null) {
			errorInfo = "地区编码错误。";
			System.out.println(errorInfo);
			return false;
		}
		// ================ 判断最后一位的值 ================
		int TotalmulAiWi = 0;
		for (int i = 0; i < 17; i++) {
			TotalmulAiWi = TotalmulAiWi
					+ Integer.parseInt(String.valueOf(Ai.charAt(i)))
					* Integer.parseInt(Wi[i]);
		}
		int modValue = TotalmulAiWi % 11;
		String strVerifyCode = ValCodeArr[modValue];
		Ai = Ai + strVerifyCode;

		if (IDStr.length() == 18) {
			if (Ai.equals(IDStr) == false) {
				errorInfo = "身份证无效，最后一位字母错误";
				System.out.println(errorInfo);
				return false;
			}
		} else {
			System.out.println("所在地区:" + h.get(Ai.substring(0, 2).toString()));
			System.out.println("新身份证号:" + Ai);
			return true;
		}
		System.out.println("所在地区:" + h.get(Ai.substring(0, 2).toString()));
		return true;
	}

	/**
	 * @Description: 功能：设置地区编码
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:23:57
	 * @version 1.0
	 * @return Hashtable<String,String> 返回类型
	 */
	public static Hashtable<String, String> GetAreaCode() {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("11", "北京");
		hashtable.put("12", "天津");
		hashtable.put("13", "河北");
		hashtable.put("14", "山西");
		hashtable.put("15", "内蒙古");
		hashtable.put("21", "辽宁");
		hashtable.put("22", "吉林");
		hashtable.put("23", "黑龙江");
		hashtable.put("31", "上海");
		hashtable.put("32", "江苏");
		hashtable.put("33", "浙江");
		hashtable.put("34", "安徽");
		hashtable.put("35", "福建");
		hashtable.put("36", "江西");
		hashtable.put("37", "山东");
		hashtable.put("41", "河南");
		hashtable.put("42", "湖北");
		hashtable.put("43", "湖南");
		hashtable.put("44", "广东");
		hashtable.put("45", "广西");
		hashtable.put("46", "海南");
		hashtable.put("50", "重庆");
		hashtable.put("51", "四川");
		hashtable.put("52", "贵州");
		hashtable.put("53", "云南");
		hashtable.put("54", "西藏");
		hashtable.put("61", "陕西");
		hashtable.put("62", "甘肃");
		hashtable.put("63", "青海");
		hashtable.put("64", "宁夏");
		hashtable.put("65", "新疆");
		hashtable.put("71", "台湾");
		hashtable.put("81", "香港");
		hashtable.put("82", "澳门");
		hashtable.put("91", "国外");
		return hashtable;
	}

	/**
	 * ======================================================================
	 * 功能：判断字符串是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (isNum.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Description: 功能：判断字符串是否为日期格式 同 isDateTime(String s)
	 * @param @param strDate
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:28:15
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isDate(String strDate) {
		Pattern pattern = Pattern
				.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher m = pattern.matcher(strDate);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @Description: 功能:在判定已经是正确的身份证号码之后,查找出身份证所在地区名称
	 * @param @param idCard
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:28:49
	 * @version 1.0
	 * @return String 返回类型
	 */
	public static String GetAreaName(String idCard) {
		Hashtable<String, String> ht = GetAreaCode();
		String area = ht.get(idCard.substring(0, 2));
		return area;
	}

	/**
	 * @Description: 功能:在判定已经是正确的身份证号码之后,查找出此人性别
	 * @param @param idCard
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:33:34
	 * @version 1.0
	 * @return String 返回类型
	 */
	public String GetSex(String idCard) {
		String sex = "";
		if (idCard.length() == 15)
			sex = idCard.substring(idCard.length() - 3, idCard.length());

		if (idCard.length() == 18)
			sex = idCard.substring(idCard.length() - 4, idCard.length() - 1);

		System.out.println(sex);
		int sexNum = Integer.parseInt(sex) % 2;
		if (sexNum == 0) {
			return "女";
		}
		return "男";
	}

	/**
	 * @Description: 功能:在判定已经是正确的身份证号码之后,查找出此人出生日期
	 * @param @param idCard
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:33:47
	 * @version 1.0
	 * @return String 返回类型
	 */
	public String GetBirthday(String idCard) {
		String Ain = "";
		if (idCard.length() == 18) {
			Ain = idCard.substring(0, 17);
		} else if (idCard.length() == 15) {
			Ain = idCard.substring(0, 6) + "19" + idCard.substring(6, 15);
		}

		// ================ 出生年月是否有效 ================
		String strYear = Ain.substring(6, 10);// 年份
		String strMonth = Ain.substring(10, 12);// 月份
		String strDay = Ain.substring(12, 14);// 日期
		return strYear + "-" + strMonth + "-" + strDay;
	}

	/**
	 * @Description: 是否为空
	 * @param @param objs
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:36:41
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isNull(Object[] objs) {
		if (objs == null || objs.length == 0)
			return true;
		return false;
	}

	/**
	 * @Description: 是否为空
	 * @param @param integer
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:36:54
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isNull(Integer integer) {
		if (integer == null || integer == 0)
			return true;
		return false;
	}

	/**
	 * @Description: 是否为空
	 * @param @param collection
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:37:08
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	@SuppressWarnings("rawtypes")
	public final static boolean isNull(Collection collection) {
		if (collection == null || collection.size() == 0)
			return true;
		return false;
	}

	/**
	 * @Description: 是否为空
	 * @param @param map
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:37:46
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	@SuppressWarnings("rawtypes")
	public final static boolean isNull(Map map) {
		if (map == null || map.size() == 0)
			return true;
		return false;
	}

	/**
	 * @Description: 是否为空
	 * @param @param str
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:37:52
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isNull(String str) {
		return str == null || "".equals(str.trim())
				|| "null".equals(str.toLowerCase());
	}

	/**
	 * @Description: 是否为空
	 * @param @param longs
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:38:02
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isNull(Long longs) {
		if (longs == null || longs == 0)
			return true;
		return false;
	}

	/**
	 * @Description: 是否为空
	 * @param @param longs
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:38:08
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isNotNull(Long longs) {
		return !isNull(longs);
	}

	/**
	 * @Description: 是否为非空
	 * @param @param str
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:38:14
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isNotNull(String str) {
		return !isNull(str);
	}

	/**
	 * @Description: 是否为非空
	 * @param @param collection
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:38:38
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	@SuppressWarnings("rawtypes")
	public final static boolean isNotNull(Collection collection) {
		return !isNull(collection);
	}

	/**
	 * @Description: 是否为非空
	 * @param @param map
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:38:46
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	@SuppressWarnings("rawtypes")
	public final static boolean isNotNull(Map map) {
		return !isNull(map);
	}

	/**
	 * @Description: 是否为非空
	 * @param @param integer
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:38:52
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isNotNull(Integer integer) {
		return !isNull(integer);
	}

	/**
	 * @Description: 是否为非空
	 * @param @param objs
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:38:58
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isNotNull(Object[] objs) {
		return !isNull(objs);
	}

	/**
	 * @Description: 匹配URL地址
	 * @param @param str
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:39:07
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isUrl(String str) {
		return match(str, "^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$");
	}

	/**
	 * @Description: 匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。
	 * @param @param str
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:39:45
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isPwd(String str) {
		return match(str, "^[a-zA-Z]\\w{6,12}$");
	}

	/**
	 * @Description: 验证字符，只能包含中文、英文、数字、下划线等字符。
	 * @param @param str
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:39:57
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean stringCheck(String str) {
		return match(str, "^[a-zA-Z0-9\u4e00-\u9fa5-_]+$");
	}

	/**
	 * @Description: 匹配Email地址
	 * @param @param str
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:41:05
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isEmail(String str) {
		return match(str,
				"^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
	}

	/**
	 * @Description: 匹配非负整数（正整数+0）
	 * @param @param str
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:41:13
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isInteger(String str) {
		return match(str, "^[+]?\\d+$");
	}

	/**
	 * 判断数值类型，包括整数和浮点数
	 * 
	 * @param str
	 * @return
	 * @author jiqinlin
	 */
	/*
	 * public final static boolean isNumeric(String str) { if (isFloat(str) ||
	 * isInteger(str)) return true; return false; }
	 */

	/**
	 * 只能输入数字
	 * 
	 * @param str
	 * @return
	 * @author jiqinlin
	 */
	/*
	 * public final static boolean isDigits(String str) { return match(str,
	 * "^[0-9]*$"); }
	 */

	/**
	 * @Description: 匹配正浮点数
	 * @param @param str
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:42:29
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isFloat(String str) {
		return match(str, "^[-\\+]?\\d+(\\.\\d+)?$");
	}

	/**
	 * @Description: 联系电话(手机/电话皆可)验证
	 * @param @param text
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:42:43
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isTel(String text) {
		if (isMobile(text) || isPhone(text))
			return true;
		return false;
	}

	/**
	 * @Description: 电话号码验证(固定电话)
	 * @param @param text
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:44:23
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isPhone(String text) {
		return match(text, "^(\\d{3,4}-?)?\\d{7,9}$");
	}

	/**
	 * @Description: 手机号码验证
	 * @param @param text
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:44:40
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isMobile(String text) {
		if (text.length() != 11)
			return false;
		return match(text,
				"^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
	}

	/**
	 * 身份证号码验证
	 * 
	 * @param text
	 * @return
	 * @author jiqinlin
	 */
	/*
	 * public final static boolean isIdCardNo(String text) { return match(text,
	 * "^(\\d{6})()?(\\d{4})(\\d{2})(\\d{2})(\\d{3})(\\w)$"); }
	 */

	/**
	 * @Description: 邮政编码验证
	 * @param @param text
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:45:00
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isZipCode(String text) {
		return match(text, "^[0-9]{6}$");
	}

	/**
	 * @Description: 判断整数num是否等于0
	 * @param @param num
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:45:12
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isIntEqZero(int num) {
		return num == 0;
	}

	/**
	 * @Description: 判断是否为合法字符串(a-z A-Z 0-9)
	 * @param @param text
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:46:31
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isRightfulString(String text) {
		return match(text, "^[A-Za-z0-9_-]+$");
	}

	/**
	 * @Description: 判断英文字符(a-z A-Z) 同 isAlpha(String s)
	 * @param @param text
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:47:01
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isEnglish(String text) {
		return match(text, "^[A-Za-z]+$");
	}

	/**
	 * @Description: 判断中文字符(包括汉字和符号)
	 * @param @param text
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:47:20
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isChineseChar(String text) {
		return match(text, "^[\u0391-\uFFE5]+$");
	}

	/**
	 * @Description: 匹配汉字
	 * @param @param text
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:47:30
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public final static boolean isChinese(String text) {
		return match(text, "^[\u4e00-\u9fa5]+$");
	}

	/**
	 * @Description: 是否包含中英文特殊字符，除英文"-_"字符外
	 * @param @param text
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:47:59
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	public static boolean isContainsSpecialChar(String text) {
		if (StringUtils.isBlank(text))
			return false;
		String[] chars = { "[", "`", "~", "!", "@", "#", "$", "%", "^", "&",
				"*", "(", ")", "+", "=", "|", "{", "}", "'", ":", ";", "'",
				",", "[", "]", ".", "<", ">", "/", "?", "~", "！", "@", "#",
				"￥", "%", "…", "&", "*", "（", "）", "—", "+", "|", "{", "}",
				"【", "】", "‘", "；", "：", "”", "“", "’", "。", "，", "、", "？", "]" };
		for (String ch : chars) {
			if (text.contains(ch))
				return true;
		}
		return false;
	}

	/**
	 * @Description: 过滤中英文特殊字符，除英文"-_"字符外
	 * @param @param text
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:48:19
	 * @version 1.0
	 * @return String 返回类型
	 */
	public static String stringFilter(String text) {
		String regExpr = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regExpr);
		Matcher m = p.matcher(text);
		return m.replaceAll("").trim();
	}

	/**
	 * @Description: 过滤html代码
	 * @param @param inputString
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:48:29
	 * @version 1.0
	 * @return String 返回类型
	 */
	public static String htmlFilter(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		java.util.regex.Pattern p_ba;
		java.util.regex.Matcher m_ba;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			String patternStr = "\\s+";

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			p_ba = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
			m_ba = p_ba.matcher(htmlStr);
			htmlStr = m_ba.replaceAll(""); // 过滤空格

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;// 返回文本字符串
	}

	/**
	 * @Description: 正则表达式匹配
	 * @param @param text
	 * @param @param reg
	 * @param @return 设定文件
	 * @date 创建时间：2017-2-21 上午10:48:43
	 * @version 1.0
	 * @return boolean 返回类型
	 */
	private final static boolean match(String text, String reg) {
		if (StringUtils.isBlank(text) || StringUtils.isBlank(reg))
			return false;
		return Pattern.compile(reg).matcher(text).matches();
	}
}
