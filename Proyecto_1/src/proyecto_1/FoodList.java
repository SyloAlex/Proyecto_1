package proyecto_1;

/**
 * Lista de comida. Puede ser usada para almacenar la comida disponible de un 
 * local o la comida de una orden.
 * @author Alex
 */
public class FoodList {
    
    private FoodNode first;
    private FoodNode last;
    private int size;
    
    /**
     * Constructor de la lista FoodList sin parametros
     */
    public FoodList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Getter del primer nodo de la lista
     * @return first {FoodNode} primer nodo de la lista
     */
    public FoodNode getFirst() {
        return first;
    }

    /**
     * Setter del primer nodo de la lista
     * @param first {FoodNode} primer nodo de la lista
     */
    public void setFirst(FoodNode first) {
        this.first = first;
    }

    /**
     * Getter del ultimo nodo de la lista
     * @return last {FoodNode} ultimo nodo de la lista
     */
    public FoodNode getLast() {
        return last;
    }

    /**
     * Setter del ultimo nodo de la lista
     * @param last {FoodNode} ultimo nodo de la lista
     */
    public void setLast(FoodNode last) {
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
     * @return {FoodNode} nodo en la posicion buscada
     */
    public FoodNode getNode(int position){
        FoodNode aux = first;
            for (int i = 0; i < size; i++){
                if (i == position){
                    return aux;
                }else{
                    aux = aux.getNext();
                }
            }
        return null;
    }

    /**
     * Añade un nuevo {FoodNode} a la lista en la primera posicion
     * @param food {ClientNode} nodo del cliente.
     */
    public void addFirst(FoodNode food){
        if (isEmpty()){
            addEmpty(food);
        }else{
            food.setNext(first);
            first = food;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {FoodNode} a la lista en la ultima posicion
     * @param food {ClientNode} nodo del cliente.
     */
    public void addLast(FoodNode food){
        if (isEmpty()){
            addEmpty(food);
        }else{
            last.setNext(food);
            last = food;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {FoodNode} a la lista
     * @param food {ClientNode} nodo del cliente.
     */
    public void addEmpty(FoodNode food){
        first = food;
        last = food;
        size = size + 1;
    }
    
    /**
     * Añade un nuevo {FoodNode} a la lista en la posicion indicada
     * @param food {ClientNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addNode(FoodNode food, int position){
        if (isEmpty()){
            addEmpty(food);
        }else{
            if (position == 0){
                addFirst(food);
            }else if(position == size){
                addLast(food);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                FoodNode aux = getNode(position - 1);
                food.setNext(aux.getNext());
                aux.setNext(food);
                size = size + 1;
            }
        }
    }
    
    /**
     * Añade un nuevo {FoodNode} a la lista despues de la posicion indicada
     * @param food {ClientNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addPostPosition(FoodNode food, int position){
        addNode(food, position + 1);
    }
    
    //Delete nodes in various locations

    /**
     * Elimina el primer nodo de la lista
     */
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            FoodNode aux = first.getNext();
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
                FoodNode aux = getNode(position - 1);
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

}
