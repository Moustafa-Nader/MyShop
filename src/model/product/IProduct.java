package model.product;

public interface IProduct {
	void setID(int id);
	void setBrand(String brand);
	void setName(String name);
    void setPrice(double price);
    void setCategory(String category);
	
	int getID();
	String getBrand();
	String getName();
    double getPrice();
    String getCategory();
}
