package model.Store;

import model.Address;

public class Store implements IStore {
    private int m_id;
    private String m_name;
    private String m_country;
    private int m_ownerid;
    private StoreType m_type;
    private Address m_address;

    @Override
    public String getM_name() {
        return m_name;
    }

    @Override
    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    @Override
    public String getM_country() {
        return m_country;
    }

    @Override
    public void setM_country(String m_country) {
        this.m_country = m_country;
    }

    @Override
    public int getM_ownerid() {
        return m_ownerid;
    }

    @Override
    public void setM_ownerid(int m_ownerid) {
        this.m_ownerid = m_ownerid;
    }

    @Override
    public StoreType getM_type() {
        return m_type;
    }

    @Override
    public void setM_type(StoreType m_type) {
        this.m_type = m_type;
    }

    @Override
    public Address getM_address() {
        return m_address;
    }

    @Override
    public void setM_address(Address m_address) {
        this.m_address = m_address;
    }

}
