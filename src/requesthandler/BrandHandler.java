package requesthandler;

import java.io.IOException;

import context.IContext;
import model.account.AccountType;
import model.brand.Brand;
import service.brand.IBrandService;

public class BrandHandler extends RequestHandlerBase {
    private IBrandService m_brandservice;

    public BrandHandler(IBrandService bService) {
        this.m_brandservice = bService;

    }

    @Override
    public void handle(IContext ctx) throws IOException {
        ctx.parse();
        if (ctx.getUser().getType().equals(AccountType.ADMIN)) {
            Brand brand = new Brand(ctx.getParam("m_name"), ctx.getParam("m_category"));
            if (!m_brandservice.Contains(ctx.getParam("m_name")))
                m_brandservice.addBrand(brand);
            else{System.out.print("aka");}
            ctx.redirect("/home");
        }
        else{
            ctx.write("<html>Unauthorized</html>".getBytes());
        }
    }
}
        

    
