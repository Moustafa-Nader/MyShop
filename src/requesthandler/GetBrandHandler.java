package requesthandler;

import context.IContext;
import model.Store.IStore;
import model.brand.IBrand;
import service.brand.IBrandService;
import service.store.IStoreService;
import service.store.StoreService;

import java.io.IOException;
import java.util.ArrayList;

public class GetBrandHandler extends RequestHandlerBase {
    private IBrandService m_brandservice;

    public GetBrandHandler(IBrandService bService) {
        this.m_brandservice = bService;

    }
    @Override
    public void handle(IContext ctx) throws IOException {
        String t = "";
        ArrayList<IBrand> brands = m_brandservice.getBrandList(); 
        int i = 0;
        for (IBrand iBrand : brands) {
            ++i;
            if(i != brands.size())
            t+= iBrand.getName() + " ";
            else t+= iBrand.getName();
        }
        ctx.getHttpExchange().sendResponseHeaders(200, t.getBytes().length);
        ctx.getHttpExchange().getResponseBody().write(t.getBytes());
        
    }
}