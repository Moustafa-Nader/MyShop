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
	
		int itemID = -1;
		if(uri.length == 3)
			itemID = Integer.parseInt(uri[2]);
		IItem item = m_storeService.getItemByID(itemID);
		if(item == null)
			ctx.write("invalid item ID".getBytes());
		else {
			IProduct product = m_productService.getProductByID(item.getProductID());
			this.m_statisticsService.recordItemVisit(itemID);
			ctx.write(("<h1> View " + product.getName() + "</h1>").getBytes());
		}
	}
}
