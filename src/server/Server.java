package server;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import requesthandler.IRequestHandler;
import session.ISessionManager;
import session.SessionManager;

public class Server {
	HttpServer m_server;
	ISessionManager m_smgr;

	public Server(int port) throws IOException
	{
		m_server = HttpServer.create(new InetSocketAddress(port), 0);
		m_smgr = new SessionManager();
	}
	
	public void addHandler(String path, IRequestHandler handler)
	{
		m_server.createContext(path, new HttpHandlerAdapter(handler));
		handler.setSessionManager(m_smgr);
	}
	
	public void start()
	{
		m_server.start();
	}
}
