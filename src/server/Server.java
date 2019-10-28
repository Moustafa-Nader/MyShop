package server;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import requesthandler.IRequestHandler;

public class Server {
	HttpServer m_server;
	public Server(int port) throws IOException
	{
		m_server = HttpServer.create(new InetSocketAddress(port), 0);
	}
	
	public void addHandler(String path, IRequestHandler handler)
	{
		m_server.createContext(path, new HttpHandlerAdapter(handler));
	}
	
	public void start()
	{
		m_server.start();
	}
}
