package proyecto_1;

/**
 * Lista de Clientes de la plataforma Samancito Delivery
 * @author Alex
 */
public class ClientsList {
    
    private ClientNode first;
    private ClientNode last;
    private int size;
    
    /**
     * Constructor de la clase ClientList sin parametros.
     */
    public ClientsList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Getter del primer nodo de la lista
     * @return first {ClientNode} primer nodo de la lista
     */
    public ClientNode getFirst() {
        return first;
    }

    /**
     * Setter del primer nodo de la lista
     * @param first {ClientNode} primer nodo de la lista
     */
    public void setFirst(ClientNode first) {
        this.first = first;
    }

    /**
     * Getter del ultimo nodo de la lista
     * @return last {ClientNode} ultimo nodo de la lista
     */
    public ClientNode getLast() {
        return last;
    }

    /**
     * Setter del ultimo nodo de la lista
     * @param last {ClientNode} ultimo nodo de la lista
     */
    public void setLast(ClientNode last) {
        this.last = last;
    }

    /**
     * Getter del tamaño de la lista
     * @return size {int} tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Setter del tamaño de la lista
     * @param size {int} tamaño de la lista
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Verifica si la lista tiene o no elementos
     * @return {boolean} true si la lista esta vacia, false si tiene elementos
     */
    public boolean isEmpty(){
        return first == null;
    }
    
    /**
     * Busca un nodo en la lista, segun la posicion pasada por parametro
     * @param position {int} posicion del nodo a buscar
     * @return {ClientNode} nodo en la posicion buscada
     */
    public ClientNode getNode(int position){
        ClientNode aux = first;
        if (position >= size || position < 0){
            return null;
        }else{
            for (int i = 0; i < size; i++){
                if (i == position){
                    return aux;
                }else{
                    aux = aux.getNext();
                }
            }
        }
        return null;
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista vacia
     * @param newClient {ClientNode} nodo del cliente.
     */
    public void addEmpty(ClientNode newClient){
        first = newClient;
        last = newClient;
        size = size + 1;
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista en la primera posicion
     * @param newClient {ClientNode} nodo del cliente.
     */
    public void addFirst(ClientNode newClient){
        if (isEmpty()){
            addEmpty(newClient);
        }else{
            newClient.setNext(first);
            first = newClient;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista en la ultima posicion
     * @param newClient {ClientNode} nodo del cliente.
     */
    public void addLast(ClientNode newClient){
        if (isEmpty()){
            addEmpty(newClient);
        }else{
            last.setNext(newClient);
            last = newClient;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista en la posicion indicada
     * @param newClient {ClientNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addNode(ClientNode newClient, int position){
        if (isEmpty()){
            addEmpty(newClient);
        }else{
            if (position == 0){
                addFirst(newClient);
            }else if(position == size){
                addLast(newClient);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                ClientNode aux = getNode(position - 1);
                newClient.setNext(aux.getNext());
                aux.setNext(newClient);
                size = size + 1;
            }
        }
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista despues de la posicion indicada
     * @param newClient {ClientNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addPostPosition(ClientNode newClient, int position){
        addNode(newClient, position + 1);
    }
    
    /**
     * Elimina el primer nodo de la lista
     */
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            ClientNode aux = first.getNext();
            first = aux;
            size = size - 1;            
        }
    }
    
    /**
     * Elimina el ultimo nodo de la lista
     */
    public void deleteLast(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            last = getNode(size - 1);
            last.setNext(null);
            size = size - 1;           
        }
    }
    
    /**
     * Elimina el nodo en la posicion indicada por parametro
     * @param position posicion en la cual se va a eliminar el nodo
     */
    public void deleteNode(int position){
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            if (position == 0){
                deleteFirst();
            }else if (position == size - 1){
                deleteLast();
            }else if (position >= size){
                System.out.println("La lista no tiene esa posicion");
            }else{
                ClientNode aux = getNode(position - 1);
                aux.setNext(aux.getNext().getNext());
                size = size - 1;
            }
        }
    }
    
    /**
     * Elimina el nodo una posicion antes de la indicada por parametro
     * @param position posicion en la cual se va a eliminar el nodo
     */
    public void deletePrePosition(int position){
        deleteNode(position - 1);
    }
    
    /**
     * Elimina el nodo una posicion despues de la indicada por parametro
     * @param position posicion en la cual se va a eliminar el nodo
     */
    public void deletePostPosition(int position){
        deleteNode(position + 1);
    }
    
    /**
     * Funcion que almacena toda la informacion de todos los clientes 
     * registrados en la plataforma. Itera en la lista almacenando nombre, 
     * apellido, ID y cedula de cada cliente.
     * @return result {String} que contiene toda la informacion de los clientes
     * registrados en la plataforma
     */
    public String clientsToString(){
        if (isEmpty()){
            return "No hay clientes registrados";
        }else{
            String result = "";
            ClientNode aux = first;
            for (int i = 0; i < size; i++){
                result += "ID: " + (i+1) + " ";
                result += "Nombre: " + aux.getName() + " ";
                result += "Apellido: " + aux.getLastName() + " ";
                result += "DNI: " + aux.getDni() + "\n";
                aux = aux.getNext();
            }
            return result;
        }
    }
    
    /**
     * Funcion que itera sobre la lista de clientes para verificar si el 
     * cliente con el ID pasado por parametro se encuentra en la base de datos.
     * @param id {String} id del cliente a buscar.
     * @return flag {boolean} true si el cliente existe en la plataforma y 
     * false si no existe.
     */
    public boolean searchClientID(String id){
        boolean flag = false;
        if (isEmpty()){
            return flag;
        }else{
           ClientNode aux = first;
           for (int i = 0; i < size; i++){
               if (aux.getId().equals(id)){
                   flag = true;
                   break;
               }else{
                   aux = aux.getNext();
               }
           }
        }
        return flag;
    }
}
