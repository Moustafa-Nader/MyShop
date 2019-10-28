package context;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;

public class Context implements IContext {
	HttpExchange m_httpExchange;

	public Context(HttpExchange httpExchange)
	{
		this.m_httpExchange = httpExchange;
	}
	
	public void write(byte[] data) throws IOException
	{
		m_httpExchange.sendResponseHeaders(200, data.length);
		m_httpExchange.getResponseBody().write(data);
		m_httpExchange.getResponseBody().close();
	}
}
