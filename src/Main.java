import java.awt.geom.RectangularShape;
import java.io.IOException;

import requesthandler.*;
import server.Server;
import service.account.AccountService;
import service.product.ProductService;

public class Main {
	public static void main(String args[]) throws IOException
	{
		Server server = new Server(8080);
		AccountService accountService = new AccountService();
		server.addHandler("/hello", new HelloHandler());
		server.addHandler("/home", new HomeHandler());
		server.addHandler("/login", new LoginHandler(accountService));
		server.addHandler("/signup", new SignUpHandler());
		server.addHandler("/register", new RegisterHandler(accountService));
		server.addHandler("/addproduct", new AddProductPageHandler());
		server.addHandler("/products", new ProductHandler(new ProductService()));
		server.start();
	}
}
