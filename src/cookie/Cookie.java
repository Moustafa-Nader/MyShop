package cookie;

public class Cookie implements ICookie {
	String m_key, m_value;
	
	public Cookie(String key, String value)
	{
		m_key = key;
		m_value = value;
	}
	
	@Override
	public String getKey() {
		return m_key;
	}

	@Override
	public String getValue() {
		return m_value;
	}
	
	@Override
	public String toString()
	{
		return m_key + "=" + m_value;
	}

	@Override
	public void setKey(String key) {
		m_key = key;
	}

	@Override
	public void setValue(String value) {
		m_value = value;
	}
}
