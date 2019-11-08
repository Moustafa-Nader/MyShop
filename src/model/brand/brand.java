package model.brand;

public class brand implements Ibrand {
String m_name;
String m_category;
    
    @Override
    public String getName() {
        return m_name;
    }
    @Override

    public void setName(String m_name) {
        this.m_name = m_name;
    }
    @Override

    public String getCategory() {
        return m_category;
    }
    @Override

    public void setCategory(String m_category) {
        this.m_category = m_category;
    }

    public brand(String m_name, String m_category) {
        this.m_name = m_name;
        this.m_category = m_category;
    }
}
