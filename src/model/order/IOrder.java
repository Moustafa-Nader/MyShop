package model.order;

import model.Address;

import java.util.Date;

public interface IOrder {
	public void setID(int orderId);
	public void setItemID(int itemId);
	public void setUserID(int userId);
	public void setAddress(Address address);
	
	public int getID();
	public int getItemID();
	public int getUserID();
	public Address getAddress();
	public Date getDate();
}
