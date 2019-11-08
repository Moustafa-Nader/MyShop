package model;

public class Address {
    private int m_apartmentno;
    private int m_buildingno;
    private String m_streetname;
    private String m_city;

    public Address(String city, String streetname, int buildingno, int apartmentno) {
        this.m_city = city;
        this.m_streetname = streetname;
        this.m_buildingno = buildingno;
        this.m_apartmentno = apartmentno;
    }

    public int getApartmentno() {
        return m_apartmentno;
    }

    public void setApartmentno(int m_apartmentno) {
        this.m_apartmentno = m_apartmentno;
    }

    public int getBuildingno() {
        return m_buildingno;
    }

    public void setBuildingno(int m_buildingno) {
        this.m_buildingno = m_buildingno;
    }

    public String getStreetname() {
        return m_streetname;
    }

    public void setStreetname(String m_streetname) {
        this.m_streetname = m_streetname;
    }

    public String getCity() {
        return m_city;
    }

    public void setCity(String m_city) {
        this.m_city = m_city;
    }
}
