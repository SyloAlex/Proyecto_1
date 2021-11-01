package proyecto_1;

/**
 * Nodo que contiene los datos de un cliente
 * @author Alex
 */
public class ClientNode {
    
    private String id;
    private String name;
    private String lastName;
    private int dni;
    private ClientNode next;
    
    /**
     * Contructor de la clase ClientNode sin parametros.
     */
    public ClientNode(){
        this.id = null;
        this.name = null;
        this.lastName = null;
        this.dni = 0;
        this.next = null;
    }
    
    /**
     * Constructor de la clase ClientNode con parametros del ID, nombre, 
     * apellido y cedula de identidad
     * @param id {String} que indica el ID del cliente para ser buscado
     * @param name {String} que contiene el nombre del cliente
     * @param lastName {String} que contiene el apellido del cliente
     * @param dni {int} que contiene la cedula o dni del cliente
     */
    public ClientNode(String id, String name, String lastName, int dni){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.next = null;
    }

    /**
     * Getter del nombre del cliente
     * @return name {String} nombre del cliente
     */
    public String getName() {
        return name;
    }

    /**
     * Setter del nombre del cliente
     * @param name {String} nombre del cliente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter del apellido del cliente
     * @return lastName {String} apellido del cliente
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter del apellido del cliente
     * @param lastName {String} apellido del cliente
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter de la cedula del cliente
     * @return dni {int} cedula del cliente
     */
    public int getDni() {
        return dni;
    }

    /**
     * Setter de la cedula del cliente
     * @param dni {int} cedula del cliente
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * Getter del siguiente nodo al que apunta en la lista
     * @return {ClientNode} next el nodo siguiente al que apunta este 
     * nodo en la lista
     */
    public ClientNode getNext() {
        return next;
    }

    /**
     * Setter del siguiente nodo al que apunta en la lista
     * @param next {ClientNode} el nodo siguiente al que apunta este 
     * nodo en la lista
     */
    public void setNext(ClientNode next) {
        this.next = next;
    }

    /**
     * Getter del id del cliente
     * @return id {String} el ID del cliente
     */
    public String getId() {
        return id;
    }

    /**
     * Setter del id del cliente
     * @param id {String} el ID del cliente
     */
    public void setId(String id) {
        this.id = id;
    }
    
}
