package model.item;

public interface IItem {
	public void setID(int id);
	public void setProductID(int productId);
	public void setStoreID(int storeId);
	public void setPrice(double price);
	public int getID();
	public int getProductID();
	public int getStoreID();
	public double getPrice();
	public void setQuantity(int quantity);
	public int getQuantity();
}
