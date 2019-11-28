package model.cart;

import model.item.IItem;

import java.util.ArrayList;

public interface ICart {

    public void setID(int id);
    public int getID();
    public void addItemByID(int item_id, int quantity);
    public int getItemID(int item_id);
    public ArrayList<CartItem> getCartItems();
    public void deleteCartItems();
}
