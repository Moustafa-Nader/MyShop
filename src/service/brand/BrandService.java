package service.brand;

import java.util.ArrayList;

import model.brand.IBrand;

public class BrandService implements IBrandService {
    ArrayList<IBrand> m_brands;

    public BrandService() {
        this.m_brands = new ArrayList<>();
    }

    public void addBrand(IBrand brand) {
        brand.setID(m_brands.size());
        m_brands.add(brand);
        
    }

    public IBrand getBrandByName(String Name) {
        for (int i = 0; i < m_brands.size(); i++)
            if (m_brands.get(i).getName().equals(Name))
                return m_brands.get(i);
        return null;

    }
    public boolean Contains(String Name){
        IBrand brand = getBrandByName(Name);
        if(brand != null) return true;
        return false;
        
    } 
}