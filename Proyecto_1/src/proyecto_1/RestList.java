package proyecto_1;

/**
 * Lista de Restaurantes agregados a la plataforma Samancito Delivery
 * @author Alex
 */
public class RestList {
    
    private RestNode first;
    private RestNode last;
    private int size;
    
    /**
     * Constructor de la clase RestList sin parametros
     */
    public RestList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Getter del primer nodo de la lista
     * @return first {RestNode} primer nodo de la lista
     */
    public RestNode getFirst() {
        return first;
    }

    /**
     * Setter del primer nodo de la lista
     * @param first {RestNode} primer nodo de la lista
     */
    public void setFirst(RestNode first) {
        this.first = first;
    }

    /**
     * Getter del ultimo nodo de la lista
     * @return last {RestNode} ultimo nodo de la lista
     */
    public RestNode getLast() {
        return last;
    }

    /**
     * Setter del ultimo nodo de la lista
     * @param last {RestNode} ultimo nodo de la lista
     */
    public void setLast(RestNode last) {
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
     * @return {RestNode} nodo en la posicion buscada
     */
    public RestNode getNode(int position){
        RestNode aux = first;
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
     * @param newRest {ClientNode} nodo del cliente.
     */
    public void addEmpty(RestNode newRest){
        first = newRest;
        last = newRest;
        size = size + 1;
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista en la primera posicion
     * @param newRest {ClientNode} nodo del cliente.
     */
    public void addFirst(RestNode newRest){
        if (isEmpty()){
            addEmpty(newRest);
        }else{
            newRest.setNext(first);
            first = newRest;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista en la ultima posicion
     * @param newRest {ClientNode} nodo del cliente.
     */
    public void addLast(RestNode newRest){
        if (isEmpty()){
            addEmpty(newRest);
        }else{
            last.setNext(newRest);
            last = newRest;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {RestNode} a la lista en la posicion indicada
     * @param newRest {RestNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addNode(RestNode newRest, int position){
        if (isEmpty()){
            addEmpty(newRest);
        }else{
            if (position == 0){
                addFirst(newRest);
            }else if(position == size){
                addLast(newRest);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                RestNode aux = getNode(position - 1);
                newRest.setNext(aux.getNext());
                aux.setNext(newRest);
                size = size + 1;
            }
        }
    }
    
    /**
     * Añade un nuevo {RestNode} a la lista despues de la posicion indicada
     * @param newRest {RestNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addPostPosition(RestNode newRest, int position){
        addNode(newRest, position + 1);
    }
    
    /**
     * Elimina el primer nodo de la lista
     */
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            RestNode aux = first.getNext();
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
                RestNode aux = getNode(position - 1);
                aux.setNext(aux.getNext().getNext());
                size = size - 1;
            }
        }
    }
    
    /**
     * Elimina el nodo antes de la posicion indicada por parametro
     * @param position posicion en la cual se va a eliminar el nodo
     */
    public void deletePrePosition(int position){
        deleteNode(position - 1);
    }
    
    /**
     * Elimina el nodo despues de la posicion indicada por parametro
     * @param position posicion en la cual se va a eliminar el nodo
     */
    public void deletePostPosition(int position){
        deleteNode(position + 1);
    }
    
    /**
     * Funcion que recorre la lista RestList, revisando si el nodo con un ID 
     * igual al pasado por parametros se encuentra en la lista
     * @param id {String} ID del restaurante a revisar
     * @return flag {boolean} true si el restaurante esta en la lista y false 
     * si no esta en la lista
     */
    public boolean searchRestID(String id){
        RestNode aux = getFirst();
        boolean flag = false;
        for (int i = 0; i < size; i++){
            if (aux.getRestId().equals(id)){
                flag = true;
                break;
            }else{
                aux = aux.getNext();
            }
        }
        return flag;
    }
    
    /**
     * Funcion que revisa si un RestNode de la lista tiene ID igual al pasado 
     * por parametro y retornar el nodo (en caso de existir)
     * @param id {String} ID del restaurante a revisar
     * @return aux {RestNode} nodo del restaurante con el mismo ID o null si 
     * no existe ese restaurante en la base de datos.
     */
    public RestNode getRestaurant(String id){
        RestNode aux = getFirst();
        for (int i = 0; i < size; i++){
            if (!id.equals(aux.getRestId())){
                aux = aux.getNext();
            }else{
                return aux;
            }
        }
        return null;
    }
    
    /**
     * Funcion que almacena toda la informacion de todos los restaurantes 
     * registrados en la plataforma. Itera en la lista almacenando ID, nombre, 
     * y luego itera sobre el menu para almacenar el nombre de los platos
     * @return result {String} que contiene toda la informacion de los 
     * restaurantes almacenados en la lista
     */
    public String restToString(){
        String result = "";
        RestNode aux = first;
        for (int i = 0; i < size; i++){
            result += "ID: " + aux.getRestId();
            result += " Nombre: " + aux.getRestName() + "\n";
            aux = aux.getNext();
        }
        return result;
    }
    
    /**
     * Funcion que almacena toda la informacion de todos los platos 
     * registrados en un restaurante. Itera en la lista almacenando ID y nombre, 
     * @param restID {String} ID del restaurante del cual se desea almacenar 
     * los platos
     * @return result {String} que contiene todos los platos del restaurante 
     * pasado por parametro.
     */
    public String foodToString(String restID){
        String result = "";
        RestNode aux = first;
        for (int i = 0; i < size; i++){
            FoodNode auxFood = aux.getMenu().getFirst();
            if (aux.getRestId().equals(restID)){
                for (int j = 0; j < aux.getMenu().getSize(); j++){
                    result += "ID: " + (j + 1);
                    result += " Plato: " + auxFood.getFoodName() + "\n";
                    auxFood = auxFood.getNext();
                }
                break;
            }else{
                aux = aux.getNext();
            }
        }
        return result;
    }
    
}
