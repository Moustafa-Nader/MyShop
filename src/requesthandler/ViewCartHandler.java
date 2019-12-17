package requesthandler;

import java.io.IOException;

import context.IContext;
import model.Store.IStore;
import model.account.AccountType;
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
        boolean discounted = false;
        output += "<!DOCTYPE html>\n" +
					"<html>\n" +
					"<head>\n" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/forms.css\">\n" +
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/strike.css\">\n" +
					"\t<title>CartView</title>\n" +
					"</head>\n" +
                    "<body>\n";
                    if(ctx.getUser().getType() == AccountType.OWNER)
                        output += "<h2 color=\"red\"> GET STOREOWNER DISCOUNT NOW!</h2><b>";
                    output += "\t<form  action=\"/makepurchase/" + "\"method=\"get\">\n" ;
                for(CartItem cartItem : useCart.getCartItems()){
                    double totalprice = m_storeService.getItemByID(cartItem.getItem_id()).getPrice();
                    double discountedprice = totalprice;
                    System.out.println("Cart Size:" + useCart.getCartItems().size());
                    // product = m_productService.getProductByID(cartItem.getItem_id());
                    output += "\t<h1 >" +
                    m_productService.getProductByID(cartItem.getItem_id()).getName() +" "+ cartItem.getQuantity();
                    if (userOrderCount == 0) {
                        discountedprice = discountedprice - (totalprice * 0.05);
                        discounted = true;
                    }
                    if(ctx.getUser().getType() == AccountType.OWNER){
                        discountedprice = discountedprice - (totalprice * 0.1);
                        discounted = true;
                    }
                    if(cartItem.getQuantity() >= 2){
                        discountedprice = discountedprice - (totalprice * 0.15);
                        discounted = true;
                    }
                    if(discounted)
                        output += " Price: <s>" + totalprice + "</s> " + discountedprice;
                    else output += " Price: " + totalprice;

                    output += "</h1>\n<b>";
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

