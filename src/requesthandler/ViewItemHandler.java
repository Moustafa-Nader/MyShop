package requesthandler;

import java.io.IOException;

import context.IContext;
import model.item.IItem;
import model.product.IProduct;
import service.product.IProductService;
import service.statistics.IStatisticsService;
import service.store.IStoreService;

public class ViewItemHandler extends RequestHandlerBase {
	private IStoreService m_storeService;
	private IProductService m_productService;
	private IStatisticsService m_statisticsService;

    public ViewItemHandler(IStoreService storeService, IProductService productService, IStatisticsService statisticsService){
        this.m_storeService = storeService;
        this.m_productService = productService;
        this.m_statisticsService = statisticsService;
    }

	public void handle(IContext ctx) throws IOException {
		String[] uri = ctx.getHttpExchange().getRequestURI().getPath().split("/");
		String output = "";
	
		int itemID = -1;
		if(uri.length == 3)
			itemID = Integer.parseInt(uri[2]);
		IItem item = m_storeService.getItemByID(itemID);
		if(item == null)
			ctx.write("invalid item ID".getBytes());
		else {
			IProduct product = m_productService.getProductByID(item.getProductID());
			this.m_statisticsService.recordItemVisit(itemID);
			output += "<!DOCTYPE html>\n" +
					"<html>\n" +
					"<head>\n" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/forms.css\">\n" +
					"\t<title>ItemView</title>\n" +
					"</head>\n" +
					"<body>\n" +
					"\t<h1>You are viewing " + product.getName() + "</h1>\n" +
					"\t<br>\n" +
					"\t<form id=\"itemtocartform\" action=\"/additemtocart/" + item.getID() + "\"method=\"get\">\n" +
					"\t\t<div class=\"form-box\">\n" +
					"\t\t\t<label for=\"m_quantity\">Quantity</label>\n" +
					"\t\t\t<input type=\"number\" name=\"m_quantity\" id=\"m_quantity\">\n" +
					"\t\t</div>\n" +
					"\t\t<div class=\"form-box\">\n" +
					"\t\t\t<button id=\"additemtocart\" type=\"submit\">Add to Cart</button>\n" +
					"\t\t</div>\n" +
					"\t</form>\n" +
					"\n" +
					"</body>\n" +
					"</html>";
			ctx.write(output.getBytes());
		}
	}
}
