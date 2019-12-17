package service.store;

import model.Action.IAction;
import model.Store.IStore;
import model.item.IItem;

import java.util.ArrayList;

public interface IStoreService {
    public void addStore(IStore store);
    public IStore getStoreByName(String Name);
    public IStore getStoreByID(int id);
    public ArrayList<IStore> getAllStores();
    public void addCollaborator(int userID, int storeID);
    public void addAction(int storeID,IAction action);
    public boolean isCollaborator(int userID, int storeID);
    public IAction isAction(int storeID,String aname);
    public ArrayList<Integer> getCollaborators(int storeID);
    public ArrayList<IAction> getHistory(int storeID);
    public void addItemToStore(IItem item,IStore store);
    public void addItemToStoreDB(IItem item, IStore store);
    public void removeItemFromStore(IItem item,IStore store);
    public void removeItemFromStoreDB(IItem item,IStore store);
    public ArrayList<IItem> getItemsByStoreID(int storeID);
    public IItem getItemByID(int itemID);
    public void setQuantity(int itemID , int Quantity);
    public void removeAction(int storeId, IAction action);
}
