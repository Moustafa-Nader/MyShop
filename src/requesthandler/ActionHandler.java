package requesthandler;

import java.io.IOException;
import java.util.ArrayList;

import context.IContext;
import model.Action.IAction;
import model.Store.IStore;
import service.ServiceRepo;
import service.store.IStoreService;

public class ActionHandler extends RequestHandlerBase {
    IStoreService m_storeService;

    public ActionHandler() {
        m_storeService = ServiceRepo.getStoreService();
    }

    @Override
    public void handle(IContext ctx) throws IOException {
        ctx.parse();
        //System.out.println(ctx.getHttpExchange().getRequestURI());
        System.out.println("----------------");
        
        String[] uri = ctx.getHttpExchange().getRequestURI().toString().split("/");
        System.out.println(uri.length);
        int storeID = -1;
        
        if (uri.length == 4){
            storeID = Integer.parseInt(uri[2]);
            //aname=uri[3].replaceAll("\\s+","");
        }
        String aname = ctx.getParam("action"); 
        aname = aname.replaceAll("\\+"," ");
        System.out.println(aname);
        IStore store = m_storeService.getStoreByID(storeID);
        if (store == null)
            ctx.write("invalid Store Id".getBytes());
        IAction currAction = m_storeService.isAction(store.getID(), aname);
        if (currAction == null)
            ctx.write("invalid Action".getBytes());
        else if (ctx.getUser() == null || store.getOwnerid() != ctx.getUser().getID())
            ctx.write("Unauthorized".getBytes());

        else {
            currAction.undo();
            m_storeService.removeAction(storeID, currAction);
            ctx.write("Removed Item".getBytes());
        }
    }

}