package service.store;

import model.Address;
import model.Store.IStore;
import model.Store.Store;
import model.Store.StoreType;

import java.util.ArrayList;

public class StoreService implements IStoreService  {
    ArrayList<IStore> m_stores;

    public StoreService() { this.m_stores = new ArrayList<>();
                            m_stores.add(new Store(0,"TESTSTORE","TESTCOUNTRY", StoreType.ONSITE,
                                    new Address("a","a",1,1)));
    }


    @Override
    public void addStore(IStore store) {
        m_stores.add(store);
    }

    @Override
    public IStore getStoreByName(String Name) {
        for(int i = 0; i < m_stores.size(); i++)
            if(m_stores.get(i).getName().equals(Name))
                return m_stores.get(i);

        return null;
    }

    @Override
    public IStore[] getAllStores(){
        IStore[] dummy = null;
        m_stores.toArray(dummy);
        return dummy;
    }

    @Override
    public ArrayList<IStore> getAllStoresArrayList() {
        return m_stores;
    }
}
