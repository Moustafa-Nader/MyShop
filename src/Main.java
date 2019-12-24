import java.awt.geom.RectangularShape;
import java.io.IOException;
import java.util.HashMap;

import model.product.Product;
import requesthandler.*;
import server.Server;
import service.account.AccountService;
import service.product.ProductService;
import service.statistics.StatisticsService;
import service.brand.BrandService;
import service.order.OrderService;
import service.store.IStoreService;
import service.store.StoreService;


public class Main {
	public static void main(String args[]) throws IOException
	{
		Server server = new Server(8080);
		AccountService accountService = new AccountService();
		BrandService brandService = new BrandService();
		StoreService storeService = new StoreService();
		ProductService productService = new ProductService();
		StatisticsService statisticsService = new StatisticsService();
		OrderService orderService = new OrderService(storeService);
		server.addHandler("/static", new StaticFilesHandler());
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
		server.addHandler("/viewstore", new ViewStoreHandler(storeService,productService, statisticsService));
		server.addHandler("/viewitem", new ViewItemHandler(storeService,productService, statisticsService));
		server.addHandler("/viewcart", new ViewCartHandler(productService,orderService, storeService));
		server.addHandler("/pendingstores", new PendingStoresHandler(storeService));
		server.addHandler("/approvestore", new ApproveStoreHandler(storeService));
		server.addHandler("/additem",new AddItemPageHandler(productService,storeService));
		server.addHandler("/additemq",new AddItemHandler(productService,storeService));
		server.addHandler("/additemtocart",new AddItemToCartHandler(storeService));
		server.addHandler("/makepurchase", new MakePurchaseHandler(storeService,orderService));
		server.addHandler("/addstatistic", new AddStatisticPageHandler());
		server.addHandler("/addstatisticq", new AddStatisticHandler(
					accountService, storeService, productService, orderService, brandService));
		server.addHandler("/addcollaborator", new AddCollaboratorPageHandler(storeService));
		server.addHandler("/addcollaboratorq", new AddCollaboratorHandler(storeService));
		server.addHandler("/viewcollaborators", new ViewCollaboratorsHandler(storeService, accountService));
		server.addHandler("/viewstorehistory", new ViewStoreHistoryHandler(storeService));
		server.addHandler("/action", new ActionHandler(storeService));
		server.addHandler("/getbrandhandler", new GetBrandHandler(brandService));
		server.start();
	}
}
