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

    public int getM_apartmentno() {
        return m_apartmentno;
    }

    public void setM_apartmentno(int m_apartmentno) {
        this.m_apartmentno = m_apartmentno;
    }

    public int getM_buildingno() {
        return m_buildingno;
    }

    public void setM_buildingno(int m_buildingno) {
        this.m_buildingno = m_buildingno;
    }

    public String getM_streetname() {
        return m_streetname;
    }

    public void setM_streetname(String m_streetname) {
        this.m_streetname = m_streetname;
    }

    public String getM_city() {
        return m_city;
    }

    public void setM_city(String m_city) {
        this.m_city = m_city;
    }
}
