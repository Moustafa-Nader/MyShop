package service.product;

import java.util.ArrayList;

import model.brand.Brand;
import model.brand.IBrand;
import model.item.IItem;
import model.product.IProduct;
import model.product.Product;

public class ProductService implements IProductService {
	ArrayList<IProduct> m_products;
	//ArrayList<IItem> m_items;
	
	public ProductService()
	{
		this.m_products = new ArrayList<IProduct>();
		IBrand brand = new Brand("TestBrandName","TestBrandCategory");
		IProduct product = new Product(brand,"TestProduct",13d,"TestCategory");
		product.setID(0);
		m_products.add(product);
	}
	
	@Override
	public void addProduct(IProduct prod) {
		prod.setID(m_products.size());
		m_products.add(prod);
	}

	@Override
	public IProduct getProductByID(int productid) {
		for(IProduct product : m_products) {
			if(product.getID() == productid)
				return product;
		}
		return null;
	}

	@Override
	public ArrayList<IProduct> getAllProducts() {
		return m_products;
	}
}
