package com.my.entity;

import java.util.List;

/**
 * ��ʾ�����ʵ��
 * @author yun
 *
 */
public class Command {
	private int id;
	private String name;
	private String description;
	private List<CommandContents> contentList;
	public List<CommandContents> getContentList() {
		return contentList;
	}
	public void setContentList(List<CommandContents> contentList) {
		this.contentList = contentList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
