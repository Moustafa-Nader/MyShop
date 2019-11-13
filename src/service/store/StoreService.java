package service.store;

import model.Address;
import model.Store.IStore;
import model.Store.Store;
import model.Store.StoreType;
import model.item.IItem;
import model.item.Item;

import java.util.ArrayList;

public class StoreService implements IStoreService  {
    ArrayList<IStore> m_stores;
    ArrayList<IItem> m_items;

    public StoreService() { this.m_stores = new ArrayList<>();
                            this.m_items = new ArrayList<>();
                            IStore store = new Store(0,"TESTSTORE","TESTCOUNTRY", StoreType.ONSITE,
                                    new Address("a","a",1,1));
                            store.setPending(false);
                            m_stores.add(store);
                            m_items.add(new Item(0,0,69d));


    }

    @Override
    public void addStore(IStore store) {
    	store.setID(m_stores.size());
        m_stores.add(store);
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
        item.setID(m_items.size());
        item.setStoreID(store.getID());
        m_items.add(item);
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
}
