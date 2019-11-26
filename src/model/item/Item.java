package model.item;

public class Item implements IItem {
	private int m_id, m_productId, m_storeId;
	private double m_price;
	
	public Item(int productId, int storeId, double price) {
		m_productId = productId;
		m_storeId = storeId;
		m_price = price;
	}
	
	@Override
	public void setID(int id) {
		m_id = id;
	}
	
	@Override
	public void setProductID(int productId) {
		m_productId = productId;
	}

	@Override
	public void setStoreID(int storeId) {
		m_storeId = storeId;
	}

	@Override
	public void setPrice(double price) {
		m_price = price;
	}
	
	@Override
	public int getID() {
		return m_id;
	}

	@Override
	public int getProductID() {
		return m_productId;
	}

	@Override
	public int getStoreID() {
		return m_storeId;
	}

	@Override
	public double getPrice() {
		return m_price;
	}
}
