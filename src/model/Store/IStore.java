package model.Store;

import model.Address;

public interface IStore {

    public String getM_name();

    public void setM_name(String m_name);

    public String getM_country();

    public void setM_country(String m_country);

    public int getM_ownerid();

    public void setM_ownerid(int m_ownerid);

    public StoreType getM_type();

    public void setM_type(StoreType m_type);

    public Address getM_address();

    public void setM_address(Address m_address);
}
