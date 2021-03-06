package requesthandler;

import context.IContext;
import model.Store.IStore;
import model.item.IItem;
import model.item.Item;
import model.product.IProduct;
import service.ServiceRepo;
import service.product.IProductService;
import service.store.IStoreService;

import java.io.IOException;

public class AddItemHandler extends RequestHandlerBase {

    private IStoreService m_storeservice;

    public AddItemHandler() {
        m_storeservice = ServiceRepo.getStoreService();
    }

    @Override
    public void handle(IContext ctx) throws IOException {
        ctx.parse();
        System.out.println(ctx.getHttpExchange().getRequestURI());
        String[] uri = ctx.getHttpExchange().getRequestURI().getPath().split("/");
        int storeID = -1;
        if(uri.length == 3)
            storeID = Integer.parseInt(uri[2]);
        IStore store = m_storeservice.getStoreByID(storeID);
        if (store == null)
            ctx.write("invalid Id".getBytes());
        else if(store.getOwnerid() != ctx.getUser().getID()
        		&& !m_storeservice.isCollaborator(ctx.getUser().getID(), store.getID()))
            ctx.write("Unauthorized".getBytes());
        else if(store.isPending())
            ctx.write("Still pending".getBytes());
        else {
            System.out.println(ctx.getParam("m_price"));
            Integer.parseInt(ctx.getParam("m_quantity"));
            System.out.println(Float.parseFloat(ctx.getParam("m_price")));
            IItem item = new Item(Integer.parseInt(ctx.getParam("m_product")),storeID,Float.parseFloat(ctx.getParam("m_price"))
                    ,Integer.parseInt(ctx.getParam("m_quantity")));
            m_storeservice.addItemToStore(item,store);
            ctx.write("<html>ITEM ADDED</html>".getBytes());
        }

    }
}
