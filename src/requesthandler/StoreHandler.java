package requesthandler;

import context.IContext;
import model.Address;
import model.Store.Store;
import model.Store.StoreType;
import model.account.AccountType;
import service.ServiceRepo;
import service.store.IStoreService;
import service.store.StoreService;

import java.io.IOException;

public class StoreHandler extends RequestHandlerBase {

    private IStoreService m_storeservice;
    public StoreHandler() {
        this.m_storeservice = ServiceRepo.getStoreService();
    }

    @Override
    public void handle(IContext ctx) throws IOException {
        ctx.parse();
        if(ctx.getUser().getType().equals(AccountType.OWNER)) {
            System.out.println("Started Handling");
            StoreType input_type = StoreType.valueOf(ctx.getParam("m_type"));
            Address input_address = null;
            if (input_type.equals(StoreType.ONSITE)) {
                input_address = new Address(ctx.getParam("m_addresscity"), ctx.getParam("m_streetname"),
                        Integer.valueOf(ctx.getParam("m_buildingno")), Integer.valueOf(ctx.getParam("m_apartmentno")));
            }
            this.m_storeservice.addStore(new Store(ctx.getUser().getID(), ctx.getParam("m_name"),
                    ctx.getParam("m_country"), input_type, input_address));
            ctx.redirect("/home");
        } else {
            ctx.write("<html>Unauthorized</html>".getBytes());
        }
    }
}
