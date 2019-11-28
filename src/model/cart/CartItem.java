package model.cart;

public class CartItem {

    private int m_itemid;
    private int m_quantity;

    CartItem(int item_id, int quantity){
        this.m_itemid = item_id;
        this.m_quantity = quantity;
    }

    public int getItem_id() {
        return m_itemid;
    }

    public void setItem_id(int item_id) {
        this.m_itemid = item_id;
    }

    public int getQuantity() {
        return m_quantity;
    }

    public void setQuantity(int quantity) {
        this.m_quantity = quantity;
    }
}
