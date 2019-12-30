package requesthandler;

import context.IContext;
import model.Store.IStore;
import model.account.AccountType;
import service.ServiceRepo;
import service.store.IStoreService;
import service.store.StoreService;

import java.io.IOException;
import java.util.ArrayList;

public class PendingStoresHandler extends RequestHandlerBase {
    private IStoreService m_storeservice;

    public PendingStoresHandler(){
        this.m_storeservice = ServiceRepo.getStoreService();
    }

    @Override
    public void handle(IContext ctx) throws IOException {
    	if(ctx.getUser() == null || ctx.getUser().getType() != AccountType.ADMIN) {
    		ctx.write("<h1>Unauthorized</h1>".getBytes());
    		return;
    	}
    	String htmlPage = "<body><html> <h1>Pending Stores</h1>";
        for(IStore store : m_storeservice.getAllStores()) {
        	if(!store.isPending()) continue;
            htmlPage += "\t<div class=\"form-box1\">\n" +
            			"\t\t<a href=\"/approvestore/" + store.getID() +
            			"\"><label>Approve " + store.getName() + "</label>" +
            			"</a>\n\t</div>\n";
        }


        htmlPage += "</body>\n" +
                    "</html>";

        ctx.write(htmlPage.getBytes());

    }
}
