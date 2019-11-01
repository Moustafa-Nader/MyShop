package server;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import context.Context;
import context.IContext;
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
		IContext ctx = new Context(httpExchange);
		m_handler.getSessionManager().load(ctx);
		m_handler.handle(ctx);
	}

}
