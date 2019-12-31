package requesthandler;

import java.io.IOException;

import context.IContext;
import model.Store.IStore;
import model.account.AccountType;
import service.ServiceRepo;
import service.store.IStoreService;

public class AddCollaboratorPageHandler extends RequestHandlerBase {
	IStoreService m_storeService;
	
	public AddCollaboratorPageHandler() {
		m_storeService = ServiceRepo.getStoreService();
	}
	
	@Override
    public void handle(IContext ctx) throws IOException {
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
	        String output = m_resources.htmlRead("/src/Components/add_collaborator.html");
	        output = output.replaceAll("\\{storeID\\}", String.valueOf(storeID));
	        ctx.write(output.getBytes());
        }
    }
}
