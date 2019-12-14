package requesthandler;

import java.io.IOException;
import java.util.ArrayList;

import context.IContext;
import model.Store.IStore;
import model.item.IItem;
import model.product.IProduct;
import service.product.IProductService;
import service.statistics.IStatisticsService;
import service.store.IStoreService;

public class ViewStoreHandler extends RequestHandlerBase {
	private IStoreService m_storeservice;
	private IProductService m_productservice;
	private IStatisticsService m_statisticsservice;

    public ViewStoreHandler(IStoreService storeService, IProductService productService, IStatisticsService statisticsService){
        this.m_storeservice = storeService;
        this.m_productservice = productService;
        this.m_statisticsservice = statisticsService;
    }
    
    public void handle(IContext ctx) throws IOException {
    	String[] uri = ctx.getHttpExchange().getRequestURI().getPath().split("/");

    	int storeID = -1;
    	String htmlPage = "";
    	if(uri.length == 3)
    		storeID = Integer.parseInt(uri[2]);
    	IStore store = m_storeservice.getStoreByID(storeID);
    	if(store == null)
    		ctx.write("invalid ID".getBytes());
    	else if(store.isPending())
    		ctx.write("Still pending".getBytes());
    	else {
    		ArrayList<IItem> items = m_storeservice.getItemsByStoreID(store.getID());
    		int itemsViewCnt = 0;
    		htmlPage += "<h1>" + store.getName() + "</h1><b>";
    		for(IItem item : items) {
    			itemsViewCnt += this.m_statisticsservice.getItemVisits(item.getID());
				IProduct product = m_productservice.getProductByID(item.getProductID());
    			htmlPage += "<div><label><a href=\"/viewitem/" + item.getID() + "\">" + product.getName() + "</label>";

    			htmlPage += "</div><b>";
			}

			if(ctx.getUser() != null
				&& (store.getOwnerid() == ctx.getUser().getID()
		        	|| m_storeservice.isCollaborator(ctx.getUser().getID(), store.getID()))) {
				htmlPage += "<b><label><a href=\"/additem/"+ store.getID() +"\">Add item </label></a><br>";
				htmlPage += "<b><label><a href=\"/addcollaborator/"+ store.getID() +"\">Add collaborator</label></a><br>";
				htmlPage += "<b><label><a href=\"/viewcollaborators/"+ store.getID() +"\">View collaborators</label></a><br>";
				htmlPage += "<h3>Your items have been visited " + itemsViewCnt + "</h3>";
			}
			ctx.write(htmlPage.getBytes());
		}
    }
}
