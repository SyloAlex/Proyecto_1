package proyecto_1;

public class ClientsList {
    
    private ClientNode first;
    private ClientNode last;
    private int size;
    
    public ClientsList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public ClientNode getFirst() {
        return first;
    }

    public void setFirst(ClientNode first) {
        this.first = first;
    }

    public ClientNode getLast() {
        return last;
    }

    public void setLast(ClientNode last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
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
    
    public void addEmpty(ClientNode newClient){
        first = newClient;
        last = newClient;
        size = size + 1;
    }
    
    public void addFirst(ClientNode newClient){
        if (isEmpty()){
            addEmpty(newClient);
        }else{
            newClient.setNext(first);
            first = newClient;
            size = size + 1;
        }
    }
    
    public void addLast(ClientNode newClient){
        if (isEmpty()){
            addEmpty(newClient);
        }else{
            last.setNext(newClient);
            last = newClient;
            size = size + 1;
        }
    }
    
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
    
    public void addPostPosition(ClientNode newClient, int position){
        addNode(newClient, position + 1);
    }
    
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            ClientNode aux = first.getNext();
            first = aux;
            size = size - 1;            
        }
    }
    
    public void deleteLast(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            last = getNode(size - 1);
            last.setNext(null);
            size = size - 1;           
        }
    }
    
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
    
    public void deletePrePosition(int position){
        deleteNode(position - 1);
    }
    
    public void deletePostPosition(int position){
        deleteNode(position + 1);
    }
    
    public void printClientsName(){
        if (isEmpty()){
            System.out.println("La Lista esta vacia");
        }else{
            ClientNode aux = first;
            for (int i = 0; i < size; i++){
                System.out.println(aux.getName());
                aux = aux.getNext();
            }
        }
    }
    
    public void printClientsInfo(){
        if (isEmpty()){
            System.out.println("La Lista esta vacia");
        }else{
            ClientNode aux = first;
            for (int i = 0; i < size; i++){
                System.out.println("Nombre:");
                System.out.println(aux.getName());
                System.out.println("Apellido:");
                System.out.println(aux.getLastName());
                System.out.println("ID:");
                System.out.println(aux.getId());
                System.out.println("DNI:");
                System.out.println(aux.getDni());
                System.out.println("-----------");
                aux = aux.getNext();
            }
        }
    }
    
    public ClientNode searchClient(String id){
        if (isEmpty()){
            return null;
        }else{
           ClientNode aux = first;
           for (int i = 0; i < size; i++){
               if (aux.equals(id)){
                   return aux;
               }else{
                   aux = aux.getNext();
               }
           }
        }
        return null;
    }
    
}
