package proyecto_1;

/**
 * Lista de ordenes pendientes a realizar por los drivers de la plataforma
 * @author Alex
 */
public class OrderList {
    
    private OrderNode first;
    private OrderNode last;
    private int size;
    
    /**
     * Constructor de la lista OrderList sin parametros
     */
    public OrderList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Getter del primer nodo de la lista
     * @return first {OrderNode} primer nodo de la lista
     */
    public OrderNode getFirst() {
        return first;
    }

    /**
     * Setter del primer nodo de la lista
     * @param first {OrderNode} primer nodo de la lista
     */
    public void setFirst(OrderNode first) {
        this.first = first;
    }

    /**
     * Getter del ultimo nodo de la lista
     * @return last {OrderNode} ultimo nodo de la lista
     */
    public OrderNode getLast() {
        return last;
    }

    /**
     * Setter del ultimo nodo de la lista
     * @param last {OrderNode} ultimo nodo de la lista
     */
    public void setLast(OrderNode last) {
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
     * @return {OrderNode} nodo en la posicion buscada
     */
    public OrderNode getNode(int position){
        OrderNode aux = first;
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
     * Añade un nuevo {OrderNode} a la lista
     * @param newOrder {ClientNode} nodo del cliente.
     */
    public void addEmpty(OrderNode newOrder){
        first = newOrder;
        last = newOrder;
        size = size + 1;
    }
    
    /**
     * Añade un nuevo {OrderNode} a la lista en la primera posicion
     * @param newOrder {OrderNode} nodo del cliente.
     */
    public void addFirst(OrderNode newOrder){
        if (isEmpty()){
            addEmpty(newOrder);
        }else{
            newOrder.setNext(first);
            first = newOrder;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {OrderNode} a la lista en la ultima posicion
     * @param newOrder {OrderNode} nodo del cliente.
     */
    public void addLast(OrderNode newOrder){
        if (isEmpty()){
            addEmpty(newOrder);
        }else{
            last.setNext(newOrder);
            last = newOrder;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {OrderNode} a la lista en la posicion indicada
     * @param newOrder {OrderNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addNode(OrderNode newOrder, int position){
        if (isEmpty()){
            addEmpty(newOrder);
        }else{
            if (position == 0){
                addFirst(newOrder);
            }else if(position == size){
                addLast(newOrder);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                OrderNode aux = getNode(position - 1);
                newOrder.setNext(aux.getNext());
                aux.setNext(newOrder);
                size = size + 1;
            }
        }
    }
    
    /**
     * Añade un nuevo {OrderNode} a la lista despues de la posicion indicada
     * @param newOrder {OrderNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addPostPosition(OrderNode newOrder, int position){
        addNode(newOrder, position + 1);
    }
    
    /**
     * Elimina el primer nodo de la lista
     */
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            OrderNode aux = first.getNext();
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
                OrderNode aux = getNode(position - 1);
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
     * Funcion que almacena toda la informacion de las ordenes en un String. 
     * Primero itera sobre cada nodo y luego almacena el ID, nombre, destino 
     * e itera en la lista de comida para almacenar el contenido.
     * @return orderString {String} que contiene toda la informacion de las 
     * ordenes almacenadas en la lista de ordenes
     */
    public String ordersToString(){
        OrderNode aux = first;
        String orderString = "";
        for (int i = 0; i < size; i++){
            orderString += "Orden #" + (i + 1) + " ";
            orderString += "Origen: " + aux.getOrigin();
            orderString += " Destino: " + aux.getDestiny() + " Orden:";
            FoodNode menuAux = aux.getOrder().getFirst();
            for (int j = 0; j < aux.getOrder().getSize(); j++){
                orderString += " " + menuAux.getQuantity() + "- " +
                        menuAux.getFoodName();
                menuAux = menuAux.getNext();
            }
            orderString += "\n";
            aux = aux.getNext();
        }
        return orderString;
    }
    
}
