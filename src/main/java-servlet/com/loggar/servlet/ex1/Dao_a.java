package com.loggar.servlet.ex1;

import java.util.List;
import java.util.Map;

public class Dao_a {
	DataSource data = DataSource.getInstance();
	
	public Map<String, Object> read(int id) {
		return DataSource.getInstance().get(id);
	}
	
	public List<Map<String, Object>> list() {
		return data.getList();
	}
	
	public int insert(int id, String value) {
		return data.insert(id, value);
	}
	
	public int update(int id, String value) {
		return data.update(id, value);
	}
	
	public int delete(int id) {
		return data.remove(id);
	}
}
