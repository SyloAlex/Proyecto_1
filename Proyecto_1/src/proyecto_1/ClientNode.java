package proyecto_1;

public class ClientNode {
    
    private String name;
    private String lastName;
    private int id;
    private String address;
    private ClientNode next;
    
    public ClientNode(String name, String lastName, int id, String address){
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientNode getNext() {
        return next;
    }

    public void setNext(ClientNode next) {
        this.next = next;
    }
    
}
