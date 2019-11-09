package requesthandler;

import java.io.IOException;

import context.IContext;
import model.Store.IStore;
import service.store.IStoreService;

public class ViewStoreHandler extends RequestHandlerBase {
	private IStoreService m_storeservice;

    public ViewStoreHandler(IStoreService storeService){
        this.m_storeservice = storeService;
    }
    
    public void handle(IContext ctx) throws IOException {
    	String[] uri = ctx.getHttpExchange().getRequestURI().getPath().split("/");
    	int storeID = -1;
    	if(uri.length == 3)
    		storeID = Integer.parseInt(uri[2]);
    	IStore store = m_storeservice.getStoreByID(storeID);
    	if(store == null)
    		ctx.write("invalid ID".getBytes());
    	else if(store.isPending())
    		ctx.write("Still pending".getBytes());
    	else
    		ctx.write(("<h1>" + store.getName() + "</h1>").getBytes());
    }
}
