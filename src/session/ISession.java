package session;

public interface ISession {
	public String ID();
	public void set(String key, Object value);
	public Object get(String key);
}
