package model.cart;


import java.util.ArrayList;

public class Cart implements ICart{
    private int m_id;
    private ArrayList<CartItem> m_cartitemslist;

    public Cart(){
        m_cartitemslist = new ArrayList<>();
    }

    @Override
    public void setID(int id) {
        this.m_id = id;
    }

    @Override
    public int getID() {
        return m_id;
    }

    @Override
    public void addItemByID(int item_id, int quantity) {
        CartItem temp_cartitem = new CartItem(item_id,quantity);
        for(CartItem cartItem : m_cartitemslist)
        {
            if(cartItem.getItem_id()==temp_cartitem.getItem_id()) {
                cartItem.setQuantity(cartItem.getQuantity()+quantity);
                return;
            }
        }
        m_cartitemslist.add(temp_cartitem);
    }

    @Override
    public int getItemID(int item_id) {
        for(CartItem cartItem : m_cartitemslist) {
            if(item_id == cartItem.getItem_id())
                return cartItem.getItem_id();
        }
        return -1;
    }

    @Override
    public ArrayList<CartItem> getCartItems() {
        return m_cartitemslist;
    }
    @Override 
    public void deleteCartItems(){
    this.m_cartitemslist = new ArrayList<>();
    }
}
