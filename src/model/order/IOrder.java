package model.order;

import java.util.Date;

public interface IOrder {
	public void setID(int orderId);
	public void setItemID(int itemId);
	public void setUserID(int userId);
	
	public int getID();
	public int getItemID();
	public int getUserID();
	public Date getDate();
}
