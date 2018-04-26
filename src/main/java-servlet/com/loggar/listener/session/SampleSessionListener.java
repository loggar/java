package com.loggar.listener.session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class SampleSessionListener implements HttpSessionListener {
	private static Map<String, HttpSession> sessions = new HashMap<>();
	
	@Override
	public void sessionCreated(HttpSessionEvent evt) {
		HttpSession s = evt.getSession();
		String sid = s.getId();
		sessions.put(sid, s);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evt) {
		HttpSession s = evt.getSession();
		String sid = s.getId();
		sessions.remove(sid);
	}
	
	public static Map<String,HttpSession> getMap() {
		return sessions;
	}
}
