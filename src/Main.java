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

		server.addHandler("/static", 			new StaticFilesHandler());
		server.addHandler("/hello", 			new HelloHandler());
		server.addHandler("/home", 				new HomeHandler());
		server.addHandler("/login", 			new LoginHandler());
		server.addHandler("/signup", 			new SignUpHandler());
		server.addHandler("/logout", 			new LogoutHandler());
		server.addHandler("/register", 			new RegisterHandler());
		server.addHandler("/addproduct", 		new AddProductPageHandler());
		server.addHandler("/products", 			new ProductHandler());
		server.addHandler("/addbrand", 			new AddBrandPageHandler());
		server.addHandler("/brand", 			new BrandHandler());
		server.addHandler("/addstore", 			new AddStorePageHandler());
		server.addHandler("/addstoreq", 		new StoreHandler());
		server.addHandler("/allstores", 		new AllStoresHandler());
		server.addHandler("/viewstore", 		new ViewStoreHandler());
		server.addHandler("/viewitem", 			new ViewItemHandler());
		server.addHandler("/viewcart", 			new ViewCartHandler());
		server.addHandler("/pendingstores", 	new PendingStoresHandler());
		server.addHandler("/approvestore", 		new ApproveStoreHandler());
		server.addHandler("/additem",			new AddItemPageHandler());
		server.addHandler("/additemq",			new AddItemHandler());
		server.addHandler("/additemtocart",		new AddItemToCartHandler());
		server.addHandler("/makepurchase", 		new MakePurchaseHandler());
		server.addHandler("/addstatistic", 		new AddStatisticPageHandler());
		server.addHandler("/addstatisticq", 	new AddStatisticHandler());
		server.addHandler("/addcollaborator", 	new AddCollaboratorPageHandler());
		server.addHandler("/addcollaboratorq",	new AddCollaboratorHandler());
		server.addHandler("/viewcollaborators", new ViewCollaboratorsHandler());
		server.addHandler("/viewstorehistory", 	new ViewStoreHistoryHandler());
		server.addHandler("/action", 			new ActionHandler());
		server.addHandler("/getbrandhandler", 	new GetBrandHandler());
		server.start();
	}
}
