package proyecto_1;

public class ClientNode {
    
    private String id;
    private String name;
    private String lastName;
    private int dni;
    private ClientNode next;
    
    public ClientNode(){
        this.id = null;
        this.name = null;
        this.lastName = null;
        this.dni = 0;
        this.next = null;
    }
    
    public ClientNode(String id, String name, String lastName, int dni){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public ClientNode getNext() {
        return next;
    }

    public void setNext(ClientNode next) {
        this.next = next;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
