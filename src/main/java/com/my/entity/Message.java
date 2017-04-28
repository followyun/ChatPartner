package com.my.entity;
/**
 * 表示信息的实体类
 * @author yun
 *
 */
public class Message {
	//主键
	private String id;
	//消息描述
	private String description;
	//获取到该消息的命令
	private String command;
	//消息内容
	private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", description=" + description + ", command=" + command + ", content=" + content
				+ "]";
	}
	
}
