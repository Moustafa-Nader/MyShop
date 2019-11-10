import java.awt.geom.RectangularShape;
import java.io.IOException;

import requesthandler.*;
import server.Server;
import service.account.AccountService;
import service.product.ProductService;
import service.brand.BrandService;
import service.store.StoreService;


public class Main {
	public static void main(String args[]) throws IOException
	{
		Server server = new Server(8080);
		AccountService accountService = new AccountService();
		BrandService brandService = new BrandService();
		StoreService storeService = new StoreService();

		server.addHandler("/hello", new HelloHandler());
		server.addHandler("/home", new HomeHandler());
		server.addHandler("/login", new LoginHandler(accountService));
		server.addHandler("/signup", new SignUpHandler());
		server.addHandler("/logout", new LogoutHandler());
		server.addHandler("/register", new RegisterHandler(accountService));
		server.addHandler("/addproduct", new AddProductPageHandler());
		server.addHandler("/products", new ProductHandler(new ProductService(),brandService));
		server.addHandler("/addbrand", new AddBrandPageHandler());
		server.addHandler("/brand", new BrandHandler(brandService));
		server.addHandler("/addstore", new AddStorePageHandler());
		server.addHandler("/addstoreq", new StoreHandler(storeService));
		server.addHandler("/allstores", new AllStoresHandler(storeService));
		server.addHandler("/viewstore", new ViewStoreHandler(storeService));
		server.addHandler("/pendingstores", new PendingStoresHandler(storeService));
		server.addHandler("/approvestore", new ApproveStoreHandler(storeService));
		server.start();

		
	}
}
