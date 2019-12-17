package requesthandler;

import java.io.IOException;

import context.IContext;
import model.Store.IStore;
import model.cart.Cart;
import model.cart.CartItem;
import model.cart.ICart;
import model.item.IItem;
import model.product.IProduct;
import service.order.IOrderService;
import service.product.IProductService;
import service.statistics.IStatisticsService;
import service.store.IStoreService;

public class ViewCartHandler extends RequestHandlerBase {
    private IProductService m_productService;
    private IOrderService m_orderService;
    private IStoreService m_storeService;
    public ViewCartHandler(IProductService productService, IOrderService orderService, IStoreService storeService){
        this.m_orderService = orderService;
        this.m_productService = productService;
        this.m_storeService = storeService;
    }

	public void handle(IContext ctx) throws IOException {

        String output = "";
        if(ctx.getSession().get("cart") == null)
                ctx.getSession().set("cart",new Cart());
        ICart useCart = (ICart)ctx.getSession().get("cart");
        if(useCart.getCartItems().isEmpty()) {
            ctx.write("<html><h1>Empty Cart!</h1></html>".getBytes());
        }
        int userOrderCount = m_orderService.getOrdersCountByUserId(ctx.getUser().getID());
        output += "<!DOCTYPE html>\n" +
					"<html>\n" +
					"<head>\n" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/forms.css\">\n" +
					"\t<title>CartView</title>\n" +
					"</head>\n" +
                    "<body>\n" +
                    "\t<form  action=\"/makepurchase/" + "\"method=\"get\">\n" ;
                for(CartItem cartItem : useCart.getCartItems()){
                    System.out.println("Cart Size:" + useCart.getCartItems().size());
                    // product = m_productService.getProductByID(cartItem.getItem_id());
                    output += "\t<h1 >" +
                    m_productService.getProductByID(cartItem.getItem_id()).getName() +" "+ cartItem.getQuantity()+
                            //" " + m_storeService.getItemByID(cartItem.getItem_id()).getPrice() +
                    "</h1>\n<b>";
                }
                output+="\t\t<div class=\"form-box\">\n" +
                "\t\t\t<button id=\"makepurchase\" type=\"submit\">Purchase</button>\n" +
                "\t\t</div>\n" +
                "\t</form>\n" +
                "</body>\n" +
                "</html>";
			ctx.write(output.getBytes());
		}
	}

