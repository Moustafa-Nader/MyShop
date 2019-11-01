package context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

import cookie.Cookie;
import cookie.ICookie;
import model.account.IAccount;
import session.ISession;

public class Context implements IContext {
	HttpExchange m_httpExchange;
	Map<String,String> m_parameters = new HashMap<String,String>();
	Map<String,ICookie> m_cookies = new HashMap<String, ICookie>();
	ISession m_session;
	
	public Context(HttpExchange httpExchange)
	{
		this.m_httpExchange = httpExchange;
		parseCookies();
	}

	@Override
	public void write(byte[] data) throws IOException
	{
		m_httpExchange.sendResponseHeaders(200, data.length);
		m_httpExchange.getResponseBody().write(data);
		m_httpExchange.getResponseBody().close();
	}

	@Override
	public String getParam(String key) {
		return m_parameters.get(key);
	}

	@Override
	public void parse() throws IOException
	{
		String query = m_httpExchange.getRequestURI().getRawQuery();
		if(query != null) {
			String[] parameters = query.split("[&]");
			for (String pair : parameters) {
				String pairs[] = pair.split("[=]");
				String key = pairs[0];
				String value = pairs[1];
				m_parameters.put(key,value);
			}
		}

	}
	
	@Override
	public List<String> getHeader(String headerName)
	{
		return m_httpExchange.getRequestHeaders().get(headerName);
	}
	
	@Override
	public void addHeader(String headerName, String value)
	{
		m_httpExchange.getResponseHeaders().add(headerName, value);
	}
	
	private void parseCookies()
	{
		if(getHeader("Cookie") == null)
			return;
		String[] cookiesStr = getHeader("Cookie").get(0).split(";\\s");
		for(String cookieData : cookiesStr)
		{
			String[] data = cookieData.split("=");
			m_cookies.put(data[0], new Cookie(data[0], data[1]));
		}
	}
	
	@Override
	public ICookie getCookie(String key)
	{
		return m_cookies.get(key);
	}
	
	@Override
	public void setCookie(ICookie cookie)
	{
		addHeader("Set-Cookie", cookie.toString());
	}
	
	@Override
	public void redirect(String location) throws IOException
	{
		addHeader("Location", location);
		m_httpExchange.sendResponseHeaders(302, 0);
	}

	@Override
	public ISession getSession() {
		return m_session;
	}

	@Override
	public void setSession(ISession session) {
		m_session = session;
	}

	@Override
	public IAccount getUser() {
    	IAccount account = null;
    	if(getSession().get("user") instanceof IAccount)
    		account = (IAccount) getSession().get("user");
    	return account;
	}

}
