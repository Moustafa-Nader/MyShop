package service.store;

import model.Store.IStore;

import java.util.ArrayList;

public class StoreService implements IStoreService  {
    ArrayList<IStore> m_stores;

    public StoreService() { this.m_stores = new ArrayList<>(); }


    @Override
    public void addStore(IStore store) {
        m_stores.add(store);
    }
}
