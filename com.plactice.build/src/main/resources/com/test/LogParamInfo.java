package com.isoftstone.hyec.frt.enquiry.goodsenquiry.api;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.isoftstone.hyec.api.client.lecServer.pojo.GoodsEnquiry;

/**
 * 
 * @ClassName: LogParamInfo
 * @Description:TODO(��־�ռ���)
 * @author:  
 * @date: 2018��3��29�� ����3:31:31
 * @version: V1.0
 * 
 */
public class LogParamInfo {
	/**
	 * �������͡���ʼ�������С�������
	 */
	private String methodType = "";

	/**
	 * ��������
	 */
	private String methodDesc = "";

	/**
	 * ��������
	 */
	private String methodName = "";

	/**
	 * �����������
	 */
	private String methodInput = "";

	/**
	 * �����������
	 */
	private String methodOutput = "";

	/**
	 * ���ܲ������
	 */
	private String operationResult = "";

	/**
	 * �쳣��Ϣ
	 */
	private String exception = "";

	/**
	 * ��־���棬���ڼ�¼����ҵ����־
	 */
	private StringBuffer buffer = new StringBuffer();

	/**
	 * ���з���
	 */
	private static final String NEXT_LINE = System.getProperty("line.separator");

	/**
	 * ������ʼ��ʶ��
	 */
	private static final String BEGIN = "begin";
	/**
	 * ���������б�ʶ��
	 */
	private static final String PROGRESS = "progress";
	/**
	 * ����������ʶ��
	 */
	private static final String END = "end";

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(�޲ι���)
	 * @param:
	 */
	public LogParamInfo() {
		buffer.append(NEXT_LINE).append("{").append(NEXT_LINE);
	}

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(��ʼ��������������������)
	 * @param: @param
	 *             methodDesc ��������
	 * @param: @param
	 *             methodName ��������
	 */
	public LogParamInfo(String methodDesc, String methodName) {
		buffer.append(NEXT_LINE).append("{").append(NEXT_LINE);
		this.methodDesc = methodDesc;
		this.methodName = methodName;
	}

	/**
	 * 
	 * @Title: LogParamInfo
	 * @Description: TODO(������־����)
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
	 * @Description: TODO(������־����)
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
	 * @Description: TODO(������־����)
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
	 * @Description: TODO(������־����)
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
	 * @Description: TODO(������־����)
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
	 * @Description: TODO(������־����)
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
	 * @Description: TODO(������־����)
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
	 * @Description: TODO(��дtostring������������־��Ϣ���������ӵ���־����)
	 * @param: @return
	 * @return: String
	 */
	public String toString() {
		String resultStr = getParams();
		// �ж��Ƿ����Զ������
		if (!buffer.equals("{")) {
			resultStr += buffer.toString() + "}";
		}
		return resultStr;

	}

	/**
	 * @Title: LogParamInfo
	 * @Description: TODO(��װ��ӡ��־�Ķ�ά����)
	 * @param:
	 * @return ����ά����ƴװ�ַ���
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
	 * @Description:    TODO(������ʼ����,���ҷ��ر�����־��¼��ϸ��Ϣ)   
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
	 * @Description:    TODO(������ʼ����,���ҷ��ر�����־��¼��ϸ��Ϣ)  
	 * @param:  @param methodInput �������
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
	 * @Description:    TODO(�����������,���ҷ��ر�����־��¼��ϸ��Ϣ)   
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
	 * @Description:    TODO(�����������,���ҷ��ر�����־��¼��ϸ��Ϣ)   
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
	 * @Description:    TODO(����������,���ҷ��ر�����־��¼��ϸ��Ϣ)      
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
	 * @Description:    TODO(��װ��ӡ��־�Ķ�ά����)   
	 * @param:  @param appInfo ������ά����
	 * @param:  @return  ����ƴװ�õ��ַ���
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
		LogParamInfo l = new LogParamInfo("���Է���", "main");

		GoodsEnquiry g = new GoodsEnquiry();
		g.setBelong("1111");
		g.setAccountName("liuxingyu");
		l.addParam("��¼�û�Ϊ", JSONObject.toJSONString(g));

		System.err.println(l.begin(JSONObject.toJSONString(g)));

		g.setAccountName("������");
		l.addParam("��¼�û�Ϊ", JSONObject.toJSONString(g));
		System.err.println(l.end(JSONObject.toJSONString(g)));
	}
}
