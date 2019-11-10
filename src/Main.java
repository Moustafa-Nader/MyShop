import java.awt.geom.RectangularShape;
import java.io.IOException;

import model.product.Product;
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
		ProductService productService = new ProductService();
		server.addHandler("/hello", new HelloHandler());
		server.addHandler("/home", new HomeHandler());
		server.addHandler("/login", new LoginHandler(accountService));
		server.addHandler("/signup", new SignUpHandler());
		server.addHandler("/logout", new LogoutHandler());
		server.addHandler("/register", new RegisterHandler(accountService));
		server.addHandler("/addproduct", new AddProductPageHandler());
		server.addHandler("/products", new ProductHandler(productService,brandService));
		server.addHandler("/addbrand", new AddBrandPageHandler());
		server.addHandler("/brand", new BrandHandler(brandService));
		server.addHandler("/addstore", new AddStorePageHandler());
		server.addHandler("/addstoreq", new StoreHandler(storeService));
		server.addHandler("/allstores", new AllStoresHandler(storeService));
		server.addHandler("/viewstore", new ViewStoreHandler(storeService,productService));
		server.addHandler("/pendingstores", new PendingStoresHandler(storeService));
		server.addHandler("/approvestore", new ApproveStoreHandler(storeService));
		server.addHandler("/additem",new AddItemPageHandler(productService,storeService));
		server.addHandler("/additemq",new AddItemHandler(productService,storeService));
		server.start();

		
	}
}
