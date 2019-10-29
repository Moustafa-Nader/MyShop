package service.product;

import java.util.ArrayList;

import model.product.IProduct;

public class ProductService implements IProductService {
	ArrayList<IProduct> m_products;
	@Override
	public void addProduct(IProduct prod) {
		m_products.add(prod);
	}

}
