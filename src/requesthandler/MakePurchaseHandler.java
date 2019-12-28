package requesthandler;

import java.io.IOException;
import context.IContext;
import model.Address;
import model.account.AccountType;
import model.cart.Cart;
import model.cart.CartItem;
import model.cart.ICart;
import model.item.IItem;
import model.order.IOrder;
import model.order.Order;
import service.ServiceRepo;
import service.order.IOrderService;
import service.order.OrderService;
import service.product.IProductService;
import service.store.IStoreService;

public class MakePurchaseHandler extends RequestHandlerBase {

	private IStoreService m_storeservice;
	private IOrderService m_orderService;

	public MakePurchaseHandler() {
		this.m_storeservice = ServiceRepo.getStoreService();
		this.m_orderService = ServiceRepo.getOrderService();
	}

	@Override
	public void handle(IContext ctx) throws IOException {
		if (ctx.getUser() == null) {
			ctx.write("<h1>Unauthorized</h1>".getBytes());
			return;
		}

		ICart useCart = (ICart) ctx.getSession().get("cart");

		for (CartItem cartItem : useCart.getCartItems()) {
			// m_productService.getProductByID(cartItem.getItem_id()).getName() ;
			IItem storeItem = m_storeservice.getItemByID(cartItem.getItem_id());
			if (cartItem.getQuantity() > storeItem.getQuantity()) {
				ctx.write("<h1>item addition failed, invalid amount</h1>".getBytes());
				return;
			}
		}

		ctx.parse();

		for (CartItem cartItem : useCart.getCartItems()) {
			IItem storeItem = m_storeservice.getItemByID(cartItem.getItem_id());
			m_storeservice.setQuantity(storeItem.getID(), storeItem.getQuantity() - cartItem.getQuantity());
			System.out.println(m_storeservice.getItemByID(cartItem.getItem_id()).getQuantity());
			IOrder order = new Order(storeItem.getID(), ctx.getUser().getID(),new Address(ctx.getParam("m_addresscity"),
					ctx.getParam("m_streetname"), Integer.valueOf(ctx.getParam("m_buildingno")),
					Integer.valueOf(ctx.getParam("m_apartmentno"))));
			m_orderService.addOrder(order);
		}
		ctx.getSession().set("cart", new Cart());
		ctx.redirect("/home");
		// String[] uri = ctx.getHttpExchange().getRequestURI().getPath().split("/");
	}
}
