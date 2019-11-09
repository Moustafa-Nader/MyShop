package service.store;

import model.Store.IStore;

import java.util.ArrayList;

public interface IStoreService {
    public void addStore(IStore store);
    public IStore getStoreByName(String Name);
    public IStore getStoreByID(int id);
    public ArrayList<IStore> getAllStores();
}
