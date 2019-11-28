package service.order;

import java.util.ArrayList;

import model.item.IItem;
import model.order.IOrder;
import service.IAggregate;
import service.store.IStoreService;

public class OrderService implements IOrderService, IAggregate {
	ArrayList<IOrder> m_orders;
	IStoreService m_storeService;
	
	public OrderService(IStoreService storeService) {
		m_orders = new ArrayList<IOrder>();
		m_storeService = storeService;
	}
	
	@Override
	public void addOrder(IOrder order) {
		order.setID(m_orders.size());
		m_orders.add(order);
	}

	@Override
	public ArrayList<IOrder> getAllOrders(int orderId) {
		return m_orders;
	}

	@Override
	public IOrder getOrderById(int orderId) {
		for(IOrder order : m_orders) {
			if(order.getID() == orderId)
				return order;
		}
		return null;
	}

	@Override
	public ArrayList<IOrder> getOrdersByItemId(int itemId) {
		ArrayList<IOrder> result = new ArrayList<IOrder>();
		for(IOrder order : m_orders) {
			if(order.getItemID() == itemId)
				result.add(order);
		}
		return result;
	}

	@Override
	public ArrayList<IOrder> getOrdersByUserId(int userId) {
		ArrayList<IOrder> result = new ArrayList<IOrder>();
		for(IOrder order : m_orders) {
			if(order.getUserID() == userId)
				result.add(order);
		}
		return result;
	}

	@Override
	public ArrayList<IOrder> getOrdersByStoreId(int storeId) {
		ArrayList<IOrder> result = new ArrayList<IOrder>();
		for(IOrder order : m_orders) {
			IItem item = m_storeService.getItemByID(order.getItemID());
			if(item.getStoreID() == storeId)
				result.add(order);
		}
		return result;
	}

	@Override
	public int count() {
		return m_orders.size();
	}

}
