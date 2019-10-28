package server;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import context.Context;
import requesthandler.IRequestHandler;

public class HttpHandlerAdapter implements HttpHandler {
	IRequestHandler m_handler;
	
	public HttpHandlerAdapter(IRequestHandler handler)
	{
		this.m_handler = handler;
	}
	
	@Override
	public void handle(HttpExchange httpExchange) throws IOException
	{
		m_handler.handle(new Context(httpExchange));
	}

}
