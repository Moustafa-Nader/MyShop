package model.brand;

public class Brand implements IBrand {
String m_name;
String m_category;
int m_id;
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
    @Override
    public int getID(){
        return this.m_id;

    }
    @Override
    public void setID(int m_id)
    {
        this.m_id = m_id;
    }
    public Brand(String m_name, String m_category) {
        this.m_name = m_name;
        this.m_category = m_category;
    }


}
