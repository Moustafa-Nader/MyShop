package requesthandler;

import context.IContext;
import model.cart.Cart;
import model.cart.CartItem;
import model.cart.ICart;
import model.item.IItem;
import service.ServiceRepo;
import service.store.IStoreService;
import service.store.StoreService;

import java.io.IOException;

public class AddItemToCartHandler extends RequestHandlerBase {

    IStoreService m_storeservice;

    public AddItemToCartHandler(){
        this.m_storeservice = ServiceRepo.getStoreService();
    }

    @Override
    public void handle(IContext ctx) throws IOException {
        String[] uri = ctx.getHttpExchange().getRequestURI().getPath().split("/");
        ctx.parse();
        System.out.println("Started Handling item addition to cart");
        if(uri.length == 3){
            int item_id = Integer.parseInt(uri[2]);
            IItem item = m_storeservice.getItemByID(item_id);
            ICart usercart = null;
            int quantity = Integer.parseInt(ctx.getParam("m_quantity"));

            if(ctx.getSession().get("cart") == null)
                ctx.getSession().set("cart",new Cart());        //Setting new Cart if Session Does not have a cart
            if(ctx.getSession().get("cart") instanceof ICart)
                usercart = (ICart)ctx.getSession().get("cart"); //Getting already set cart


            if(m_storeservice.getItemByID(item_id) == null) {
                ctx.write("<h1>item addition failed, invalid item id</h1>".getBytes());
                return;
            }

            if(quantity <= 0 || quantity > item.getQuantity()) {
                ctx.write("<h1>item addition failed, invalid amount</h1>".getBytes());
                return;
            }
            else {
                System.out.println("Adding item with id: " + item_id + " and quantity of: " + quantity);
                usercart.addItemByID(item_id,quantity);
                System.out.println(usercart.getCartItems().get(0).getItem_id());
                System.out.println(usercart.getCartItems().get(0).getQuantity());
                ctx.write("<h1>Item added succesfully</h1>".getBytes());
            }

        }
    }
}
