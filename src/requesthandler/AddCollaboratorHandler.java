package requesthandler;

import java.io.IOException;

import context.IContext;
import model.Store.IStore;
import service.store.IStoreService;

public class AddCollaboratorHandler extends RequestHandlerBase {
	IStoreService m_storeService;
	
	public AddCollaboratorHandler(IStoreService storeService) {
		m_storeService = storeService;
	}
	
	@Override
    public void handle(IContext ctx) throws IOException {
		ctx.parse();
		System.out.println(ctx.getHttpExchange().getRequestURI().getPath());
        String[] uri = ctx.getHttpExchange().getRequestURI().getPath().toString().split("/");
        int storeID = -1;
        if(uri.length == 3)
            storeID = Integer.parseInt(uri[2]);
        IStore store = m_storeService.getStoreByID(storeID);
        if (store == null)
            ctx.write("invalid Id".getBytes());
        else if(ctx.getUser() == null || store.getOwnerid() != ctx.getUser().getID())
            ctx.write("Unauthorized".getBytes());
        else {
        	System.out.println(ctx.getParam("m_collab_id"));
	        int collabID = Integer.parseInt(ctx.getParam("m_collab_id"));
	        System.out.println(collabID);
	        m_storeService.addCollaborator(collabID, storeID);
	        ctx.write("Added Collaborator".getBytes());
        }
    }
}
