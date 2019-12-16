package model.Action.storeaction;

import model.Action.IAction;
import model.Store.IStore;
import model.item.IItem;
import model.item.Item;
import service.store.IStoreService;

public class AddItemAction implements IAction {

    IStoreService m_storeService;
    IStore m_store;
    IItem m_item;
    public AddItemAction(IStoreService storeService, IStore store, IItem item) {
        m_storeService = storeService;
        this.m_store = store;
        this.m_item = item;
    }
    public void execute(){

        m_storeService.addItemToStoreDB(m_item, m_store);
      //  m_storeService.getStoreByID();
    }
    public void undo() {
        m_storeService.removeItemFromStoreDB(m_item, m_store);
    }
    public String getActionName(){
        Integer id = this.m_item.getID(); 
        return id.toString(); 
    }
}