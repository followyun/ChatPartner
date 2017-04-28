package com.my.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.my.entity.Command;
@Component
public interface CommandDao {
	public List<Command> getCommandList(String name, String description);
	public List<Command> getCommandListByPage(Map<String, Object> paramterMap);
	public int getCommandCounts();
	public boolean addOne(Command command);
	public boolean deleteOneById(int id);
	public boolean deleteMany(List<Integer> idlist);
}
