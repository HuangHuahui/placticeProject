package com.isoftstone.hyec.frt.enquiry.goodsenquiry.api;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.isoftstone.hyec.api.client.lecServer.pojo.GoodsEnquiry;

/**
 * 
 * @ClassName: LogParamInfo
 * @Description:TODO(日志收集类)
 * @author:  
 * @date: 2018年3月29日 下午3:31:31
 * @version: V1.0
 * 
 */
public class LogParamInfo {
	/**
	 * 方法类型【开始、处理中、结束】
	 */
	private String methodType = "";

	/**
	 * 方法描述
	 */
	private String methodDesc = "";

	/**
	 * 方法名称
	 */
	private String methodName = "";

	/**
	 * 方法输入参数
	 */
	private String methodInput = "";

	/**
	 * 方法输出参数
	 */
	private String methodOutput = "";

	/**
	 * 功能操作结果
	 */
	private String operationResult = "";

	/**
	 * 异常信息
	 */
	private String exception = "";

	/**
	 * 日志缓存，用于记录具体业务日志
	 */
	private StringBuffer buffer = new StringBuffer();

	/**
	 * 换行符号
	 */
	private static final String NEXT_LINE = System.getProperty("line.separator");

	/**
	 * 方法开始标识符
	 */
	private static final String BEGIN = "begin";
	/**
	 * 方法处理中标识符
	 */
	private static final String PROGRESS = "progress";
	/**
	 * 方法结束标识符
	 */
	private static final String END = "end";

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(无参构造)
	 * @param:
	 */
	public LogParamInfo() {
		buffer.append(NEXT_LINE).append("{").append(NEXT_LINE);
	}

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(初始化方法描述，方法名称)
	 * @param: @param
	 *             methodDesc 方法描述
	 * @param: @param
	 *             methodName 方法名称
	 */
	public LogParamInfo(String methodDesc, String methodName) {
		buffer.append(NEXT_LINE).append("{").append(NEXT_LINE);
		this.methodDesc = methodDesc;
		this.methodName = methodName;
	}

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(增加日志参数)
	 * @param: @param
	 *             name
	 * @param: @param
	 *             value
	 * @return: void
	 */
	public void addParam(String name, String value) {
		buffer.append("    ").append(name).append(" = ").append(value).append(NEXT_LINE);
	}

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(增加日志参数)
	 * @param: @param
	 *             name
	 * @param: @param
	 *             value
	 * @return: void
	 */
	public void addParam(String name, int value) {
		buffer.append("    ").append(name).append(" = ").append(value).append(NEXT_LINE);
	}

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(增加日志参数)
	 * @param: @param
	 *             name
	 * @param: @param
	 *             value
	 * @return: void
	 */
	public void addParam(String name, Object value) {
		if (value == null) {
			buffer.append("    ").append(name).append(" = null").append(NEXT_LINE);
		} else {
			buffer.append("    ").append(name).append(" = ").append(value.toString()).append(NEXT_LINE);
		}
	}

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(增加日志参数)
	 * @param: @param
	 *             name
	 * @param: @param
	 *             value
	 * @return: void
	 */
	public void addParam(String name, char[] value) {
		buffer.append("    ").append(name).append(" = ").append(value).append(NEXT_LINE);
	}

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(增加日志参数)
	 * @param: @param
	 *             name
	 * @param: @param
	 *             value
	 * @return: void
	 */
	public void addParam(String name, boolean value) {
		buffer.append("    ").append(name).append(" = ").append(value).append(NEXT_LINE);
	}

	/**
	 * @Title: LogParamInfo
	 * @Description: TODO(增加日志参数)
	 * @param: @param
	 *             name
	 * @param: @param
	 *             values
	 * @return: void
	 */
	public void addParam(String name, String[] values) {
		buffer.append("    ").append(name).append(" = ");
		if (values == null) {
			buffer.append("null");
		} else {
			for (int i = 0; i < values.length; i++) {
				buffer.append(values[i]).append("#");
			}
		}
		buffer.append(NEXT_LINE);
	}

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(增加日志参数)
	 * @param: @param
	 *             name
	 * @param: @param
	 *             list
	 * @return: void
	 */
	public void addParam(String name, @SuppressWarnings("rawtypes") List list) {
		if (list == null) {
			buffer.append("    ").append(name).append(" = null");
		} else {
			buffer.append("    ").append(name).append("(size) = ").append(list.size());
		}
		buffer.append(NEXT_LINE);
	}

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(重写tostring方法，返回日志消息，包括增加的日志参数)
	 * @param: @return
	 * @return: String
	 */
	public String toString() {
		String resultStr = getParams();
		// 判断是否有自定义参数
		if (!buffer.equals("{")) {
			resultStr += buffer.toString() + "}";
		}
		return resultStr;

	}

	/**
	 * @Title: LogParamInfo
	 * @Description: TODO(组装打印日志的二维数组)
	 * @param:
	 * @return 将二维数组拼装字符串
	 */
	public String getParams() {
		return formAppendInfo(new String[][] { { getMethodType() }, { "methodname", getMethodName() },
				{ "methodDesc", getMethodDesc() }, { "methodinput", "[" + getMethodInput() + "]" },
				{ "methodoutput", "[" + getMethodOutput() + "]" }, { "operationresult", getOperationResult() },
				{ "exceptioninfo", getException() } });
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public void setMethodDesc(String methodDesc) {
		this.methodDesc = methodDesc;
	}

	public void setMethodInput(String methodInput) {
		this.methodInput = methodInput;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setMethodOutput(String methodOutput) {
		this.methodOutput = methodOutput;
	}

	public String getException() {
		return exception;
	}

	public String getMethodType() {
		if (methodType.equals(BEGIN)) {
			methodType = "method begin";
		} else if (methodType.equals(END)) {
			methodType = "method end";
		} else {
			methodType = "method in progress";
		}
		return methodType;
	}

	public String getMethodDesc() {
		return methodDesc;
	}

	public String getMethodInput() {
		return methodInput;
	}

	public String getMethodName() {
		return methodName;
	}

	public String getMethodOutput() {
		return methodOutput;
	}

	public String getOperationResult() {
		return operationResult;
	}

	public void setOperationResult(String operationResult) {
		this.operationResult = operationResult;
	}

	/**
	 * 
	 * @Title:  LogParamInfo   
	 * @Description:    TODO(方法开始处理,并且返回本次日志记录详细信息)   
	 * @param:  @return  
	 * @return: String
	 */
	public String begin() {
		this.methodType = BEGIN;
		return this.toString();
	}

	
	/**
	 * 
	 * @Title:  LogParamInfo   
	 * @Description:    TODO(方法开始处理,并且返回本次日志记录详细信息)  
	 * @param:  @param methodInput 方法入参
	 * @param:  @return  
	 * @return: String
	 */
	public String begin(String methodInput) {
		this.methodType = BEGIN;
		this.methodInput = methodInput;
		return this.toString();
	}

	
	/**
	 * 
	 * @Title:  LogParamInfo   
	 * @Description:    TODO(方法处理结束,并且返回本次日志记录详细信息)   
	 * @param:  @return  
	 * @return: String
	 */
	public String end() {
		this.methodType = END;
		return this.toString();
	}

	
	/**
	 * 
	 * @Title:  LogParamInfo   
	 * @Description:    TODO(方法处理结束,并且返回本次日志记录详细信息)   
	 * @param:  @param methodOutput
	 * @param:  @return  
	 * @return: String
	 */
	public String end(String methodOutput) {
		this.methodType = END;
		this.methodOutput = methodOutput;
		return this.toString();
	}

	
	/**
	 * 
	 * @Title:  LogParamInfo   
	 * @Description:    TODO(方法处理中,并且返回本次日志记录详细信息)      
	 * @param:  @return  
	 * @return: String
	 */
	public String progress() {
		this.methodType = PROGRESS;
		return this.toString();
	}

	/**
	 * 
	 * @Title:  LogParamInfo   
	 * @Description:    TODO(组装打印日志的二维数组)   
	 * @param:  @param appInfo 参数二维数组
	 * @param:  @return  返回拼装好的字符串
	 * @return: String
	 */
	public static String formAppendInfo(Object[][] appInfo) {
		if (null == appInfo) {
			return "";
		}
		String appendInfo = "";
		StringBuffer sb = new StringBuffer(2 * appInfo.length);

		for (int i = 0; i < appInfo.length; i++) {
			int tempSize = appInfo[i].length;

			if ((tempSize >= 2) && (appInfo[i][0] != null)) {
				sb.append(appInfo[i][0].toString());
				sb.append("=");

				if (appInfo[i][1] != null) {
					sb.append(appInfo[i][1].toString()).append(",");
				} else {
					sb.append("").append(",");
				}
			} else {
				if ((tempSize != 1) || (appInfo[i][0] == null))
					continue;
				sb.append(appInfo[i][0].toString()).append(",");
			}
		}
		appendInfo = sb.toString();

		if (0 == appendInfo.length()) {
			return "";
		}
		appendInfo = appendInfo.substring(0, appendInfo.length() - 1);

		return appendInfo;
	}

	public static void main(String[] args) {
		LogParamInfo l = new LogParamInfo("测试方法", "main");

		GoodsEnquiry g = new GoodsEnquiry();
		g.setBelong("1111");
		g.setAccountName("liuxingyu");
		l.addParam("登录用户为", JSONObject.toJSONString(g));

		System.err.println(l.begin(JSONObject.toJSONString(g)));

		g.setAccountName("刘星雨");
		l.addParam("登录用户为", JSONObject.toJSONString(g));
		System.err.println(l.end(JSONObject.toJSONString(g)));
	}
}
