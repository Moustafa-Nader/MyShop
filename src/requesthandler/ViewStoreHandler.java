package requesthandler;

import java.io.IOException;
import java.util.ArrayList;

import context.IContext;
import model.Store.IStore;
import model.item.IItem;
import model.product.IProduct;
import service.product.IProductService;
import service.store.IStoreService;

public class ViewStoreHandler extends RequestHandlerBase {
	private IStoreService m_storeservice;
	private IProductService m_productservice;

    public ViewStoreHandler(IStoreService storeService, IProductService productService){
        this.m_storeservice = storeService;
        this.m_productservice = productService;
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
    		htmlPage += "<h1>" + store.getName() + "</h1><b>";
    		for(IItem item : items) {
				IProduct product = m_productservice.getProductByID(item.getProductID());
    			htmlPage += "<div><label>" + product.getName() + "</label>";

    			htmlPage += "</div><b>";
			}

			//if(ctx.getUser() != null && ctx.getUser().getID() == store.getOwnerid())
				htmlPage += "<b><label><a href=\"/additem/"+ store.getID() +"\">Add item </label></a>";

			ctx.write(htmlPage.getBytes());
		}
    }
}
