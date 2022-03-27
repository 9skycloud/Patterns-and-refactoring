package com.skycloud.refactor.adapter.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class CableProgram {

	private String programNo;
	
	private String programName;
	
	private byte[] programValue;
	
	public CableProgram(String programNo, String programName,
			byte[] programValue) {
		this.programNo = programNo;
		this.programName = programName;
		this.programValue = programValue;
	}

	public String getProgramNo() {
		return programNo;
	}

	public void setProgramNo(String programNo) {
		this.programNo = programNo;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public byte[] getProgramValue() {
		return programValue;
	}

	public void setProgramValue(byte[] programValue) {
		this.programValue = programValue;
	}
	
	
}

