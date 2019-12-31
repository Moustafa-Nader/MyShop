package requesthandler;

import java.io.IOException;
import java.util.ArrayList;

import context.IContext;
import model.Action.IAction;
import model.Store.IStore;
import service.ServiceRepo;
import service.account.IAccountService;
import service.store.IStoreService;

public class ViewStoreHistoryHandler extends RequestHandlerBase {
    IStoreService m_storeService;
    

    public ViewStoreHistoryHandler() {
        m_storeService = ServiceRepo.getStoreService();
      
    }

    @Override
    public void handle(IContext ctx) throws IOException {
        ctx.parse();
        System.out.println(ctx.getHttpExchange().getRequestURI());
        String[] uri = ctx.getHttpExchange().getRequestURI().toString().split("/");
        int storeID = -1;
        if (uri.length == 3)
            storeID = Integer.parseInt(uri[2]);
        IStore store = m_storeService.getStoreByID(storeID);
        if (store == null)
            ctx.write("invalid Id".getBytes());
        else if (ctx.getUser() == null || store.getOwnerid() != ctx.getUser().getID())
            ctx.write("Unauthorized".getBytes());
        else {
            ArrayList<IAction> historyList = this.m_storeService.getHistory(storeID);
            if (historyList.size() == 0) {
                ctx.write("There are no Actions yet!".getBytes());
            } else {
                String output = "<html><body>\n" ;
                for (IAction action : historyList) {
                    output+="\t<form  action=\"/action/" +store.getID() +"/\"method=\"get\">\n" +
                    "<input type=\"hidden\" name=\"action\" value=\"" +action.getActionName() +"\">"+
                    "<h3>" +action.getActionName()  +"</h3>"+
                    "\t\t\t<button  type=\"submit\">Undo</button>\n"+
                    "\t</form>\n" ;
                }
                output += "</body></html>";
                ctx.write(output.getBytes());
            }
        }
    }
}
