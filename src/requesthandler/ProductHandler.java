package requesthandler;
import context.IContext;
import model.product.*;
import service.product.IProductService;
import java.io.IOException;

public class ProductHandler implements IRequestHandler {
    IProductService m_service;

    public ProductHandler(IProductService service) {
        this.m_service = service;
    }

    @Override
    public void handle(IContext ctx) throws IOException {
        ctx.parse();
        System.out.println(ctx.getParam(""));
        IProduct product = new Product(ctx.getParam("m_name"), ctx.getParam("m_brand"),
                Double.valueOf(ctx.getParam("m_price")), ctx.getParam("m_category"));
        m_service.addProduct(product);
        ctx.write("<html>Product Added</html>".getBytes());

    }
}
