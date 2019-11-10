package model.product;
import model.brand.Brand;
import model.brand.IBrand;
public interface IProduct {
	void setID(int id);
	void setBrand(IBrand brand);
	void setName(String name);
    void setPrice(double price);
    void setCategory(String category);
	
	int getID();
	IBrand getBrand();
	String getName();
    double getPrice();
    String getCategory();
}
