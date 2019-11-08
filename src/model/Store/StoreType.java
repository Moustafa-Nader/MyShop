package model.Store;

public enum StoreType {
    ONLINE,ONSITE;


    @Override
    public String toString() {
        switch(this) {
            case ONLINE: return "online";
            case ONSITE: return "onsite";
            default: return "invalid";
        }
    }
}
