package com.my.entity;
/**
 * ��ʾ�����Ӧ�Ļظ����ݵ�ʵ��
 * @author yun
 *
 */
public class CommandContents {
	private int id;
	private int commandId;
	private String name;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommandId() {
		return commandId;
	}
	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
