package model.Store;

import model.Address;

public interface IStore {

    public String getM_name();

    public void setName(String m_name);

    public String getCountry();

    public void setCountry(String m_country);

    public int getOwnerid();

    public void setOwnerid(int m_ownerid);

    public StoreType getType();

    public void setType(StoreType m_type);

    public Address getAddress();

    public void setAddress(Address m_address);
}
