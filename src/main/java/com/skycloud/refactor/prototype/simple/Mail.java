package com.skycloud.refactor.prototype.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Mail implements Cloneable{

	private String subject;
	
	private String content;
	
	private String receiver;
	
	private String tail;
	
	private String appellation;

	public Mail(String subject, String content, String tail) {
		this.subject = subject;
		this.content = content;
		this.tail = tail;
	}

	public Mail(String subject, String content, String receiver, String tail,
			String appellation) {
		this.subject = subject;
		this.content = content;
		this.receiver = receiver;
		this.tail = tail;
		this.appellation = appellation;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}
	
	public Mail clone(){
		try {
			return (Mail) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

