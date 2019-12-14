package requesthandler;

import java.io.IOException;
import java.util.ArrayList;

import context.IContext;
import model.Store.IStore;
import service.account.IAccountService;
import service.store.IStoreService;

public class ViewCollaboratorsHandler extends RequestHandlerBase {
	IStoreService m_storeService;
	IAccountService m_accountService;
	
	public ViewCollaboratorsHandler(IStoreService storeService, IAccountService accountService) {
		m_storeService = storeService;
		m_accountService = accountService;
	}
	
	@Override
    public void handle(IContext ctx) throws IOException {
		ctx.parse();
		System.out.println(ctx.getHttpExchange().getRequestURI());
        String[] uri = ctx.getHttpExchange().getRequestURI().toString().split("/");
        int storeID = -1;
        if(uri.length == 3)
            storeID = Integer.parseInt(uri[2]);
        IStore store = m_storeService.getStoreByID(storeID);
        if (store == null)
            ctx.write("invalid Id".getBytes());
        else if(ctx.getUser() == null || store.getOwnerid() != ctx.getUser().getID())
            ctx.write("Unauthorized".getBytes());
        else {
	        ArrayList<Integer> collabList = this.m_storeService.getCollaborators(storeID);
	        if(collabList == null) {
	        	ctx.write("There are no collaborators yet!".getBytes());
	        } else {
	        	String output = "<html><body>";
	        	for(Integer collabID : collabList) {
	        		output += "<h3>" + m_accountService.getByID(collabID).getEmail() + "</h3>";
	        	}
	        	output += "</body></html>";
	        	ctx.write(output.getBytes());
	        }
        }
    }
}
