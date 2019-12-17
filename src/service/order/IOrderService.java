package service.order;

import java.util.ArrayList;

import model.order.IOrder;

public interface IOrderService {
	public void addOrder(IOrder order);
	public ArrayList<IOrder> getAllOrders(int orderId);
	public IOrder getOrderById(int orderId);
	public ArrayList<IOrder> getOrdersByItemId(int itemId);
	public ArrayList<IOrder> getOrdersByUserId(int userId);
	public int getOrdersCountByUserId(int userId);
	public ArrayList<IOrder> getOrdersByStoreId(int storeId);
}
