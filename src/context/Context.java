package context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

public class Context implements IContext {
	HttpExchange m_httpExchange;
	Map<String,String> m_parameters = new HashMap<String,String>();

	public Context(HttpExchange httpExchange)
	{
		this.m_httpExchange = httpExchange;
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
}
