package com.mango.jtt.util;

public class ConstUtil {
	
	//Controller返回值Key
	public static final String RESPONSE_RESULT = "responseresult";
	
	//responseresult.statusCode
	public static final int RESPONSECODE_SUCCESS = 200;
	public static final int RESPONSECODE_FAIL = 301;
	public static final int RESPONSECODE_PRIVILEDGEDENIED = 302;	//权限不足
	public static final int RESPONSECODE_CONSTRAINT = 303;			//违反外键或索引限制
	public static final int RESPONSEOCODE_NODATA = 304;				//未查询到数据
	public static final int RESPONSECODE_TARGETNOTEXIST = 396;		//目标对象不存在
	public static final int RESPONSECODE_NOTLOGIN = 397;			//未登录
	public static final int RESPONSECODE_INPUTPARAMERR = 398;		//入参错误
	public static final int RESPONSECODE_INPUTPARAMNULL = 399;		//入参为空
	public static final int RESPONSECODE_FILENOTEXIST = 395;		//下载文件不存在
	
	public static final String RESPONSEMSG_ADDSUCCESS = "添加成功";
	public static final String RESPONSEMSG_DELETESUCCESS = "删除成功";
	public static final String RESPONSEMSG_EDITSUCCESS = "修改成功";
	public static final String RESPONSEMSG_TARGETEXISTED = "目标对象已存在";
	public static final String RESPONSEMSG_TARGETNOTEXIST = "目标对象不存在";
	public static final String RESPONSEMSG_CONSTRAINT = "存在关联数据";
	public static final String RESPONSEMSG_ACCESSDENIED = "您没有权限访问该数据";
	public static final String RESPONSEMSG_UNHANDLEDEXCEPTION = "未处理的异常，请联系管理员";
	public static final String RESPONSEMSG_KDDMBLANK = "考点代码不能为空";
	public static final String RESPONSEMSG_CANTDELETESELF = "您不能删除自己";
	public static final String RESPONSEMSG_CANTEDITSELF = "您不能编辑自己";
	public static final String RESPONSEMSG_REQUIREAUTHORIZE = "您录入的结果与原结果不一致，请使用有效的监督员凭据来保存";
	
	//Session Key
	public static final String SESSION_LOGINUSER = "loginuser";
	public static final String SESSION_KAPTCHA = "captcha";
	
	//Action
	public static final int ACTION_ADD 		= 1;
	public static final int ACTION_DELETE 	= 2;
	public static final int ACTION_MODIFY 	= 3;
	public static final int ACTION_LOGIN 	= 4;
	public static final int ACTION_LOGOUT 	= 5;
	
	//Action target
	public static final int ACTIONTARGET_USER 			= 1;
	public static final int ACTIONTARGET_KAODIAN 		= 2;
	public static final int ACTIONTARGET_KELEI 			= 3;
	public static final int ACTIONTARGET_MOKUAI 		= 4;
	public static final int ACTIONTARGET_EXAMTIME		= 5;
	public static final int ACTIONTARGET_EXAMPLACE		= 6;
	public static final int ACTIONTARGET_CHOUQIAN		= 7;
	public static final int ACTIONTARGET_KAOSHENG		= 8;
	public static final int ACTIONTARGET_CHENGJI		= 9;
	public static final int ACTIONTARGET_FUCHAZHUANGTAI	= 10;
	public static final int ACTIONTARGET_REASON			= 11;
	public static final int ACTIONTARGET_KAIKAOGUANXI	= 12;/*开考关系*/
	public static final int ACTIONTARGET_PAIKAO	= 13;/*排考*/
	
	//User status code
	public static final int USERSTATUS_ENABLE = 9;
	public static final int USERSTATUS_DISABLE = 1;
	public static final int USERSTATUS_ALL = 0;
	
	//Role code
	public static final int ROLECODE_ALL 		= 0;	//所有
	public static final int ROLECODE_SA			= 1;	//考试院管理员
	public static final int ROLECODE_ADMIN		= 2;	//考点管理员
	public static final int ROLECODE_INPUTER	= 3;	//录分员
	public static final int ROLECODE_SUPERVISOR = 4;	//监督员
	
	
	//考点代码
	public static final String KDDM_KSY = "00000";
	
	//默认值
	public static final int PAGE_DEFAULTNUM = 1;
	public static final int PAGE_DEFAULTSIZE = 20;
	
	//request.param
	public static final String REQPARAM_PAGENUM = "pageNum";
	public static final String REQPARAM_PAGESIZE = "pageSize";
	public static final String REQPARAM_ROLECODE = "roleCode";
	public static final String REQPARAM_KDDM = "kddm";
	
	//复查状态代码
	public static final int FUCHA_NONE 		= 0;	//未申请复查
	public static final int FUCHA_RAISED 	= 1;	//已申请复查
	public static final int FUCHA_OK		= 2;	//复查无误
	public static final int FUCHA_MODIFIED 	= 3;	//复查有误已更正
	//复查状态文本
	public static final String FUCHATXT_NONE		= "未申请复查";
	public static final String FUCHATXT_RAISED 		= "已申请复查";
	public static final String FUCHATXT_OK			= "复查无误";
	public static final String FUCHATXT_MODIFIED 	= "复查有误已更正";
	
	//复查原因代码
	public static final int FCYY_NONE			= 0; //未申请复查
	public static final int FCYY_FROMSTUDENT 	= 1; //考生申请复查
	public static final int FCYY_SCOREDISTANCE 	= 2; //多评委分差过大自查
	
	//复查原因文本
	public static final String FCYYTXT_NONE			= "未申请复核";
	public static final String FCYYTXT_FROMSTUDENT 	= "考生申请复核";
	public static final String FCYYTXT_SCOREDISTANCE 	= "多评委分差过大自查";
	
	//抽检方式代码
	public static final int CJFSCODE_UNLIMITED	= 0;	//不限
	public static final int CJFSCODE_NONE		= 1;	//不抽检（用于非人工录分的科类）
	public static final int CJFSCODE_COUNT 		= 2;	//按数量抽检
	public static final int CJFSCODE_PERCENT	= 3;	//按百分比抽检
	
	//抽检方式名称
	public static final String CJFSTEXT_NONE	= "不抽检";
	public static final String CJFSTEXT_COUNT	= "按数量抽检";
	public static final String CJFSTEXT_PERCENT	= "按百分比抽检";
	
	//抽检状态代码
	public static final int CJZT_UNDO 			= 0;	//未抽
	public static final int CJZT_TOCHECK 		= 1;	//已抽未检
	public static final int CJZT_CHECKEDOK 		= 2;	//抽检无误
	public static final int CJZT_CHECKEDERROR 	= 3;	//抽检有误已修改
	//抽检状态（文本）
	public static final String CJZTTXT_UNDO 		= "未抽";
	public static final String CJZTTXT_TOCHECK 		= "待抽检";	
	public static final String CJZTTXT_CHECKEDOK 	= "无误";	
	public static final String CJZTTXT_CHECKEDERROR = "已更正";
	
	
	//正则
	//public static final String REGEXP_PHONE = "^(13[0-9]|15[01]|153|15[6-9]|180|18[23]|18[5-9])\\d{8}$";
	//public static final String REGEXP_PHONE = "^1[3|4|5|7|8][0-9]\\d{8}$";
	public static final String REGEXP_PHONE = "^1\\d{10}$";
	
	//hibernate.validator校验错误信息
	public static final String HBVALIDMSG_EXAMTIMEBLANK = "考试时间不能为空";
	public static final String HBVALIDMSG_EXAMTIMEOVERLENGTH = "考试时间文字超长";
	public static final String HBVALIDMSG_EXAMPLACEBLANK = "考试地点不能为空";
	public static final String HBVALIDMSG_EXAMPLACEOVERLENGTH = "考试地点文字超长";
	public static final String HBVALIDMSG_KLDMBLANK = "科类代码不能为空";
	public static final String HBVALIDMSG_MKMCBLANK = "模块名称不能为空";
	public static final String HBVALIDMSG_MKLXERROR = "模块类型错误";
	public static final String HBVALIDMSG_PWSERROR = "评委总数错误";
	public static final String HBVALIDMSG_XSPWERROR = "评委显示方式错误"; 
	public static final String HBVALIDMSG_XSZKZHERROR = "准考证号显示方式错误";
	public static final String HBVALIDMSG_XSPXERROR = "排序方式错误";
	public static final String HBVALIDMSG_SCOREERROR = "总分错误";
	public static final String HBVALIDMSG_REASONBLANK = "修改原因不能为空";
	public static final String HBVALIDMSG_REASONOVERLENGTH = "修改原因文字超长";
	public static final String HBVALIDMSG_LOGINNAMEBLANK = "用户名不能为空";
	public static final String HBVALIDMSG_LOGINNAMELENGTHERROR = "用户名长度错误(6-32)";
	public static final String HBVALIDMSG_LOGINPWDBLANK = "登录密码不能为空";
	public static final String HBVALIDMSG_LOGINPWDLENGTHERROR = "登录密码长度错误(6-32)";
	public static final String HBVALIDMSG_ROLECODEERROR = "角色代码错误";
	public static final String HBVALIDMSG_KDDMBLANK = "考点代码不能为空";
	public static final String HBVALIDMSG_KDDMERROR = "考点代码必须为5位国标代码";
	public static final String HBVALIDMSG_KDMCBLANK = "考点名称不能为空";
	public static final String HBVALIDMSG_KDMCERROR = "考点名称超长";
	public static final String HBVALIDMSG_USERSTATUSERROR = "用户状态错误";
	public static final String HBVALIDMSG_KLDMERROR = "科类代码必须为2位标准代码";
	public static final String HBVALIDMSG_KLMCBLANK = "科类名称不能为空";
	public static final String HBVALIDMSG_KLMCERROR = "科类名称超长";
	public static final String HBVALIDMSG_CJLERROR = "抽检量不在合法范围内（1-100）";
	public static final String HBVALIDMSG_CJFSERROR = "抽检方式不在合法范围内";
	public static final String HBVALIDMSG_KSHBLANK = "考生号不能为空";
	
	
	//模块类型代码
	public static final int MKLX_UNLIMITED	= 0;	//不限
	public static final int MKLX_BIKAO 		= 1;	//必考
	public static final int MKLX_CHOUKAO 	= 2;	//抽考
	//模块类型名称
	public static final String MKLXTXT_UNLIMITED 	= "不限";
	public static final String MKLXTXT_BIKAO  		= "必考";
	public static final String MKLXTXT_CHOUKAO 		= "抽考";
	
	
	//评委显示方式代码
	public static final int XSPW_UNLIMITED	= 0;	//不限
	public static final int XSPW_ALL 		= 1;	//显示所有
	public static final int XSPW_SINGLE 	= 2;	//显示单个
	//评委显示方式名称
	public static final String XSPWTXT_UNLIMITED 	= "不限";
	public static final String XSPWTXT_ALL 			= "显示所有";
	public static final String XSPWTXT_SINGLE 		= "显示单个";

	//准考证号显示方式代码
	public static final int XSZKZH_UNLIMITED 	= 0;	//不限
	public static final int XSZKZH_VISABLE 		= 1;	//可见
	public static final int XSZKZH_INVISABLE 	= 2;	//不可见
	//准考证号显示方式名称
	public static final String XSZKZHTXT_UNLIMITED 	= "不限";
	public static final String XSZKZHTXT_VISIBLE 	= "显示";
	public static final String XSZKZHTXT_INVISIBLE 	= "不显示";
	
	//登分列表排序方式代码
	public static final int XSPX_UNLIMITED	= 0;	//不限
	public static final int XSPX_CQHASC 	= 1;	//抽签号升序
	public static final int XSPX_ZKZHASC	= 2;	//准考证号升序
	//登分列表排序方式名称
	public static final String XSPXTXT_UNLIMITED 	= "不限";
	public static final String XSPXTXT_CQHASC 		= "抽签号升序";
	public static final String XSPXTXT_ZKZHASC 		= "准考证号升序";
	
	public static final int LOGINNAME_MAXLENGTH = 16;
	public static final int LOGINPWD_MINLENGTH = 6;
	public static final int LOGINPWD_MAXLENGTH = 32;
	public static final int ROLECODE_MIN = 1;
	public static final int ROLECODE_MAX= 4;
	public static final int USERSTATUS_MIN = 0;
	public static final int USERSTATUS_MAX = 9;
	public static final int KDDM_LENGTH = 5;
	public static final int KDMC_LENGTH_MIN = 1;
	public static final int KDMC_LENGTH_MAX = 255;
	public static final int KLDM_LENGTH = 2;
	public static final int KLMC_LENGTH_MIN = 1;
	public static final int KLMC_LENGTH_MAX = 255;
	
	public static final float PWCJ_NOTINPUTED = -1;	//评委打分表的初始成绩（未录入时）
	public static final float CJ_DEFAULT = 0;		//其他表的成绩
	
	//排考表中的考生状态
	public static final int PKSTATE_NONE 	= -1;	//未知（未登分）
	public static final int PKSTATE_NORMAL 	= 0;	//正常
	public static final int PKSTATE_ABSENT 	= 1;	//缺考
	//排考表中的考生状态（文本）
	public static final String PKSTATETXT_NORMAL = "正常";	//正常
	public static final String PKSTATETXT_ABSENT = "缺考";	//缺考
	
	//必须录分次数
	public static final int NECESSARY_INPUTTIMENUMBER = 2; 
	//项目年份
	public static final String PROJECT_YEAR = DateUtil.getProjectYear();
	
	//阶段状态
	public static final int STAGE_NOPK = 0; //0=未导入排考
	public static final int STAGE_READYDENGFEN = 1; //1=可以开始登分

	//成绩来源
	public static final int CHENGJILAIYUAN_LR = 0;	// 人工录入
	public static final int CHENGJILAIYUAN_JK = 1; 	// 机考导入成绩
	
}
