import java.io.IOException;

import requesthandler.HelloHandler;
import server.Server;

public class Main {
	public static void main(String args[]) throws IOException
	{
		Server server = new Server(8080);
		server.addHandler("/hello", new HelloHandler());
		server.start();
	}
}
