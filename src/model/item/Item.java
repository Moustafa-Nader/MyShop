package model.item;

public class Item implements IItem {
	private int m_id, m_productId, m_storeId;
	private double m_price;
	private int m_quantity;

	@Override
	public void setQuantity(int quantity) { this.m_quantity = quantity; }

	@Override
	public int getQuantity() { return m_quantity; }

	public Item(int productId, int storeId, double price, int quantity) {
		this.m_productId = productId;
		this.m_storeId = storeId;
		this.m_price = price;
		this.m_quantity = quantity;
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
