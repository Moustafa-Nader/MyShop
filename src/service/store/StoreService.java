package service.store;

import model.Address;
import model.Action.IAction;
import model.Action.storeaction.AddItemAction;
import model.Action.storeaction.RemoveItemAction;
import model.Store.IStore;
import model.Store.Store;
import model.Store.StoreType;
import model.item.IItem;
import model.item.Item;
import service.IAggregate;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreService implements IStoreService, IAggregate  {
    ArrayList<IStore> m_stores;
    ArrayList<IItem> m_items;
    HashMap<Integer, ArrayList<Integer>> m_collaboratorMap;
    HashMap<Integer,ArrayList<IAction>> m_storeHistoryMap;
    public StoreService() { 
    	this.m_stores = new ArrayList<>();
        this.m_items = new ArrayList<>();
        this.m_collaboratorMap = new HashMap<Integer, ArrayList<Integer>>();
        this.m_storeHistoryMap = new HashMap<Integer,ArrayList<IAction>>();
        IStore store = new Store(0,"TESTSTORE","TESTCOUNTRY", StoreType.ONSITE,
                                    new Address("a","a",1,1));
        
                                    store.setPending(false);
        
                                    m_stores.add(store);
       // m_items.add(new Item(0,0,69d, 4));
        this.addCollaborator(1, 0);
        this.m_storeHistoryMap.put(0, new ArrayList<IAction>());
        addItemToStore(new Item(0,0,69d, 4), store);
    }
    @Override
    public void setQuantity(int itemID , int Quantity){
        for(IItem item : m_items){
            if(item.getStoreID() == itemID)
                item.setQuantity(Quantity);
        }

    }
    @Override
    public void addStore(IStore store) {
    	store.setID(m_stores.size());
        m_stores.add(store);
        if(this.m_storeHistoryMap.get(store.getID()) == null)
        this.m_storeHistoryMap.put(store.getID(), new ArrayList<IAction>());
    }

    @Override
    public IStore getStoreByName(String Name) {
        for(int i = 0; i < m_stores.size(); i++)
            if(m_stores.get(i).getName().equals(Name))
                return m_stores.get(i);

        return null;
    }
    
    public IStore getStoreByID(int id) {
        for(int i = 0; i < m_stores.size(); i++)
            if(m_stores.get(i).getID() == id)
                return m_stores.get(i);
        return null;
    }

    @Override
    public ArrayList<IStore> getAllStores() {
        return m_stores;
    }

    @Override
    public void addItemToStore(IItem item, IStore store) {
        IAction action = new AddItemAction(this, store, item);
        action.execute();
        System.out.println(store.getID());
        addAction(store.getID(),action);
        
    }
    @Override
    public void addItemToStoreDB(IItem item, IStore store) {
        item.setID(m_items.size());
        item.setStoreID(store.getID());
        m_items.add(item);
    }
    @Override
    public void removeItemFromStore(IItem item,IStore store)
    {
        IAction action = new RemoveItemAction(this, store, item);
        action.execute();
        addAction(store.getID(),action);
    }
    @Override
    public void removeItemFromStoreDB(IItem item,IStore store){
        m_items.remove(item);
    }
    @Override
    public ArrayList<IItem> getItemsByStoreID(int storeID) {
        ArrayList<IItem> ret_items = new ArrayList<>();
        for(IItem item : m_items){
            if(item.getStoreID() == storeID)
                ret_items.add(item);
        }
        return ret_items;
    }

	@Override
	public IItem getItemByID(int itemID) {
		for(IItem item : m_items) {
			if(item.getID() == itemID)
				return item;
		}
		return null;
	}
	@Override
	public int count() {
		return m_stores.size();
    }
    @Override
    public void addAction(int storeID,IAction action){
        this.m_storeHistoryMap.get(storeID).add(action);
    }
	@Override
	public void addCollaborator(int userID, int storeID) {
		if(this.m_collaboratorMap.get(storeID) == null)
			this.m_collaboratorMap.put(storeID, new ArrayList<Integer>());
		this.m_collaboratorMap.get(storeID).add(userID);
	}
	@Override
	public boolean isCollaborator(int userID, int storeID) {
		if(this.m_collaboratorMap.get(storeID) == null)
			return false;
		for(Integer id : this.m_collaboratorMap.get(storeID)) {
			if(id.equals(userID))
				return true;
		}
		return false;
	}
	@Override
	public ArrayList<Integer> getCollaborators(int storeID) {
		return this.m_collaboratorMap.get(storeID);
    }
    @Override
	public ArrayList<IAction> getHistory(int storeID) {
		return this.m_storeHistoryMap.get(storeID);
    }
    
}
