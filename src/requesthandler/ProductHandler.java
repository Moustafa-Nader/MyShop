package requesthandler;

import context.IContext;
import model.account.AccountType;
import model.brand.Brand;
import model.brand.IBrand;
import model.product.*;
import service.brand.IBrandService;
import service.product.IProductService;
import java.io.IOException;

public class ProductHandler extends RequestHandlerBase {
    IProductService m_service;
    private IBrandService m_brandservice;

    public ProductHandler(IProductService service,IBrandService bService) {
        this.m_service = service;
        this.m_brandservice = bService;
    }

    @Override
    public void handle(IContext ctx) throws IOException {
    	if(ctx.getUser() == null || ctx.getUser().getType() != AccountType.ADMIN) {
    		ctx.redirect("/home");
    		return;
    	}
        ctx.parse();
        if(m_brandservice.Contains(ctx.getParam("m_bname")))
        {
            IBrand brand = m_brandservice.getBrandByName(ctx.getParam("m_bname"));
            IProduct product = new Product(brand , ctx.getParam("m_name"),
            Double.valueOf(ctx.getParam("m_price")), ctx.getParam("m_category"));
                 m_service.addProduct(product);
                 ctx.write("<html>Product Added</html>".getBytes());
        }

        ctx.write("<html>Brand Not Found</html>".getBytes());

       

    }
}
