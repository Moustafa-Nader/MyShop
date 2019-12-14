package service.store;

import model.Store.IStore;
import model.item.IItem;

import java.util.ArrayList;

public interface IStoreService {
    public void addStore(IStore store);
    public IStore getStoreByName(String Name);
    public IStore getStoreByID(int id);
    public ArrayList<IStore> getAllStores();
    public void addCollaborator(int userID, int storeID);
    public boolean isCollaborator(int userID, int storeID);
    public ArrayList<Integer> getCollaborators(int storeID);
    public void addItemToStore(IItem item,IStore store);
    public ArrayList<IItem> getItemsByStoreID(int storeID);
    public IItem getItemByID(int itemID);
    public void setQuantity(int itemID , int Quantity);
}
