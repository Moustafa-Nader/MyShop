import java.awt.geom.RectangularShape;
import java.io.IOException;

import requesthandler.*;
import server.Server;
import service.account.AccountService;

public class Main {
	public static void main(String args[]) throws IOException
	{
		Server server = new Server(8080);
		server.addHandler("/hello", new HelloHandler());
		server.addHandler("/home", new HomeHandler());
		server.addHandler("/login", new LoginHandler(new AccountService()));
		server.addHandler("/signup", new SignUpHandler());
		server.addHandler("/register", new RegisterHandler(new AccountService()));
		server.start();
	}
}
