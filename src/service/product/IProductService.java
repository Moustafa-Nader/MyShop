package service.product;

import model.item.IItem;
import model.product.IProduct;

public interface IProductService {
	public void addProduct(IProduct prod);
	public void addItem(IItem item);
}
