package service.storehistory;

import java.util.ArrayList;

import model.Action.IAction;

interface IStoreHistoryService {
    public void addAction(IAction action);
    ArrayList<IAction> getActionByStoreID(int storeID);
} 

