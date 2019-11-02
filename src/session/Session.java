package session;

import java.util.HashMap;

public class Session implements ISession {
	String m_sessionID;
	HashMap<String, Object> m_sessionMap;
	
	public Session(String id)
	{
		m_sessionID = id;
		m_sessionMap = new HashMap<String, Object>();
	}
	
	@Override
	public String ID() {
		return m_sessionID;
	}

	@Override
	public void set(String key, Object value) {
		m_sessionMap.put(key, value);
	}

	@Override
	public Object get(String key) {
		return m_sessionMap.get(key);
	}

}
