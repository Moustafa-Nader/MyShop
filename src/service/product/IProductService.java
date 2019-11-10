package service.product;

import model.item.IItem;
import model.product.IProduct;
import model.product.Product;

import java.util.ArrayList;

public interface IProductService {
	public void addProduct(IProduct prod);
	public IProduct getProductByID(int productid);
	public ArrayList<IProduct> getAllProducts();
	//public void addItem(IItem item); //REMOVED AND ADDED TO STORE SERVICE
}
