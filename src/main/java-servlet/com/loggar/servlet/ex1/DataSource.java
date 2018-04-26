package com.loggar.servlet.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataSource {
	private static final DataSource INSTANCE = new DataSource();
	
	private DataSource() {
		this.list = new ArrayList<>();
	}
	
	public static DataSource getInstance() {
		return INSTANCE;
	}
	
	private List<Map<String, Object>> list = null;
	
	public List<Map<String, Object>> getList() {
		return this.list;
	}
	
	public Map<String, Object> get(int id) {
		for(Map<String, Object> map : list) {
			if((Integer)map.get("id") == id) return map;
		}
		return null;
	}
	
	public int insert(int id, String value) {
		for(Map<String, Object> map : list) {
			if((Integer)map.get("id") == id) {
				return 0;
			}
		}
		return 1;
	}
	
	public int update(int id, String value) {
		for(Map<String, Object> map : list) {
			if((Integer)map.get("id") == id) {
				map.put("value", value);
				return 1;
			}
		}
		return 0;
	}
	
	public int remove(int id) {
		for(Map<String, Object> map : list) {
			if((Integer)map.get("id") == id) list.remove(map);
			return 1;
		}
		return 0;
	}
}
