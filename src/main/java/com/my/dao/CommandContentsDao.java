package com.my.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.my.entity.CommandContents;
@Component
public interface CommandContentsDao {
	/**
	 * ���һ����¼
	 * @param commandContents �������ݵĶ���
	 * @return �ɹ�����true�� ʧ�ܷ���false
	 */
	public boolean addOne(CommandContents commandContents);
	/**
	 * ��Ӷ�����¼
	 * @param contentList װ�ж�����Ϣ���ݶ����list����
	 * @return �ɹ�����true�� ʧ�ܷ���false
	 */
	public boolean addMany(List<CommandContents> contentList);
	/**
	 * ɾ��һ����¼
	 * @param id ��Ӧ���е�id
	 * @return �ɹ�����true�� ʧ�ܷ���false
	 */
	public boolean deleteOne(int id);
	
	/**
	 * ɾ��������¼
	 * @param ids װ�ж��id��list����
	 * @return �ɹ�����true�� ʧ�ܷ���false
	 */
	public boolean deleteMany(List<Integer> ids);
	
	public List<CommandContents> queryCommandContentsById(int id);
	
	public boolean updateOne(CommandContents commandContents);
}
