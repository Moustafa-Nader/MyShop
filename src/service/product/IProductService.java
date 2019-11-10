package service.product;

import model.item.IItem;
import model.product.IProduct;
import model.product.Product;

public interface IProductService {
	public void addProduct(IProduct prod);
	public IProduct getProductByID(int productid);
	//public void addItem(IItem item); //REMOVED AND ADDED TO STORE SERVICE
}
