package model.product;

public class Product implements IProduct {
    int m_id;
    String m_brand;
    String m_name;
    double m_price;
    String m_category;
    public Product(String Brand, String Name, Double Price, String Cat) {
        this.m_id = 0 ;
        this.m_brand = Brand ;
        this.m_name = Name;
        this.m_price = Price;
        this.m_category = Cat;
	}
	@Override
    public int getID() {
        return this.m_id ;
    }

    @Override
    public String getName() {
        return this.m_name ;
    }

    @Override
    public double getPrice() {
        return this.m_price ;
    }

    @Override
    public String getCategory() {
        return this.m_category ;
    }

    @Override
    public String getBrand() {
        return this.m_brand ;
    }

    @Override
    public void setID(int id) {
        this.m_id = id ;

    }

    @Override
    public void setName(String name) {
        this.m_name = name;

    }

    @Override
    public void setPrice(double price) {
        this.m_price = price;

    }

    @Override
    public void setCategory(String category) {
        this.m_category = category ;

    }

    @Override
    public void setBrand(String brand) {
        this.m_brand = brand;

    }


    
}
