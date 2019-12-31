package service.brand;

import java.util.ArrayList;

import model.brand.IBrand;

public interface IBrandService {
    public void addBrand(IBrand brand);
    public IBrand getBrandByName(String Name);
    public boolean Contains(String Name);
    public ArrayList<IBrand> getBrandList();
}