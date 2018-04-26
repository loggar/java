package com.loggar.servlet.ex1;

import java.util.List;
import java.util.Map;

public class Service_1 {
	private Dao_a dao = new Dao_a();
	
	public List<Map<String, Object>> list() {
		return dao.list();
	}

	public Map<String, Object> model(int id) {
		return dao.read(id);
	}
	
	public boolean save(int id, String value) {
		if(dao.read(id) == null) return dao.insert(id, value) > 0;
		else return dao.update(id, value) > 0;
	}
	
	public boolean remove(int id) {
		return dao.delete(id) > 0;
	}
}
