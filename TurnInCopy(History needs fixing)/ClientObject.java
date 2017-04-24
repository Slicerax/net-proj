
public class ClientObject {
    public String ID;
    public int port;
    public boolean available;
    public String partner;
    public int sessionID;

    ClientObject(String id, int p, boolean a){
        ID = id;
        port = p;
        this.available = a;
    }

    String getID(){
        return ID;
    }

    void setID(String id){
        ID = id;
    }

    public boolean isAvailable() {
        return available;
    }

}