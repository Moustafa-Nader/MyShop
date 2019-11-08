package model.Store;

import model.Address;

public class Store implements IStore {
    private int m_id;
    private int m_ownerid;
    private String m_name;
    private String m_country;
    private StoreType m_type;
    private Address m_address;

    @Override
    public String getName() {
        return m_name;
    }

    @Override
    public void setName(String m_name) {
        this.m_name = m_name;
    }

    @Override
    public String getCountry() {
        return m_country;
    }

    @Override
    public void setCountry(String m_country) {
        this.m_country = m_country;
    }

    @Override
    public int getOwnerid() {
        return m_ownerid;
    }

    @Override
    public void setOwnerid(int m_ownerid) {
        this.m_ownerid = m_ownerid;
    }

    @Override
    public StoreType getType() {
        return m_type;
    }

    @Override
    public void setType(StoreType m_type) {
        this.m_type = m_type;
    }

    @Override
    public Address getAddress() {
        return m_address;
    }

    @Override
    public void setAddress(Address m_address) {
        this.m_address = m_address;
    }

}
