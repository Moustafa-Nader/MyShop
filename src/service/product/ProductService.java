package service.product;

import java.util.ArrayList;

import model.item.IItem;
import model.product.IProduct;

public class ProductService implements IProductService {
	ArrayList<IProduct> m_products;
	ArrayList<IItem> m_items;
	
	public ProductService()
	{
		this.m_products = new ArrayList<IProduct>();
		this.m_items = new ArrayList<IItem>();
	}
	
	@Override
	public void addProduct(IProduct prod) {
		prod.setID(m_products.size());
		m_products.add(prod);
	}

	@Override
	public void addItem(IItem item) {
		m_items.add(item);
	}
}
