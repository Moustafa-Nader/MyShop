package requesthandler;

import java.io.IOException;

import context.IContext;
import model.Store.IStore;
import model.account.AccountType;
import service.ServiceRepo;
import service.store.IStoreService;

public class ApproveStoreHandler extends RequestHandlerBase {
	private IStoreService m_storeservice;

    public ApproveStoreHandler(){
        this.m_storeservice = ServiceRepo.getStoreService();
    }

    @Override
    public void handle(IContext ctx) throws IOException {
    	if(ctx.getUser() == null || ctx.getUser().getType() != AccountType.ADMIN) {
    		ctx.write("<h1>Unauthorized</h1>".getBytes());
    		return;
    	}
    	String[] uri = ctx.getHttpExchange().getRequestURI().getPath().split("/");
    	int storeID = -1;
    	if(uri.length == 3)
    		storeID = Integer.parseInt(uri[2]);
    	IStore store = m_storeservice.getStoreByID(storeID);
    	if(store == null) {
    		ctx.write("invalid ID".getBytes());
    	} else {
    		store.setPending(false);
    		ctx.redirect("/allstores");
    	}
    }
}
