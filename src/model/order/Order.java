package model.order;

import model.Address;

import java.util.Date;

public class Order implements IOrder {
	int m_orderId, m_itemId, m_userId;
	Date m_date;
	Address m_address;
	
	public Order(int itemId, int userId) {
		m_date = new Date();
		m_itemId = itemId;
		m_userId = userId;

	}

	public Order(int itemId, int userId, Address address) {
		m_date = new Date();
		m_itemId = itemId;
		m_userId = userId;
		m_address = address;
	}
	
	@Override
	public void setID(int orderId) {
		m_orderId = orderId;
	}

	@Override
	public void setItemID(int itemId) {
		m_itemId = itemId;
	}

	@Override
	public void setUserID(int userId) {
		m_userId = userId;
	}

	@Override
	public int getID() {
		return m_orderId;
	}

	@Override
	public int getItemID() {
		return m_itemId;
	}

	@Override
	public int getUserID() {
		return m_userId;
	}

	@Override
	public Date getDate() {
		return m_date;
	}

	@Override
	public void setAddress(Address address) {
		this.m_address = address;
	}

	@Override
	public Address getAddress() {
		return m_address;
	}
}
