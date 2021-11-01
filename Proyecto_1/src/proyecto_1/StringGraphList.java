package proyecto_1;

/**
 * Lista de Strings para poder obtener la matriz de caminos mas cortos
 * @author Alex
 */
public class StringGraphList {
    
    private StringNode first;
    private StringNode last;
    private StringGraphList nextList;
    private int size;
    
    /**
     * Constructor de la clase StringGraphList con parametros del tamaño de la 
     * lista y el string que rellena cada nodo.
     * @param size {int} tamaño de la lista
     * @param fill {String} elemento almacenado en el nodo
     */
    public  StringGraphList(int size, String fill){
        this.first = null;
        this.last = null;
        this.nextList = null;
        for (int i = 0; i < size; i++){
            StringNode newNode = new StringNode(fill);
            if (first == null){
                first = newNode;
                last = newNode;
            }else{
                last.setNext(newNode);
                last = newNode;
            }
        }
        this.size = size;
    }
    
    /**
     * Getter del primer nodo de la lista
     * @return first {StringNode} primer nodo de la lista
     */
    public StringNode getFirst(){
        return first;
    }
    
    /**
     * Setter del primer nodo de la lista
     * @param newFirst {StringNode} primer nodo de la lista
     */
    public void setFirst(StringNode newFirst){
        this.first = newFirst;
    }
    
    /**
     * Getter del ultimo nodo de la lista
     * @return last {StringNode} ultimo nodo de la lista
     */
    public StringNode getLast(){
        return last;
    }
    
    /**
     * Setter del ultimo nodo de la lista
     * @param newLast {StringNode} ultimo nodo de la lista
     */
    public void setLast(StringNode newLast){
        this.first = newLast;
    }
    
    /**
     * Getter de la siguiente lista de la matriz
     * @return {StringGraphList} siguiente lista de la matriz
     */
    public StringGraphList getNextList(){
        return nextList;
    }
    
    /**
     * Getter de la siguiente lista de la matriz
     * @param newNextList siguiente lista de la matriz
     */
    public void setNextList(StringGraphList newNextList){
        this.nextList = newNextList;
    }
    
    /**
     * Getter del tamaño de la lista
     * @return size {int} tamaño de la lista
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Verifica si la lista tiene o no elementos
     * @return {boolean} true si la lista esta vacia, false si tiene elementos
     */
    public boolean isEmpty(){
        return first == null;
    }
    
    /**
     * Deconstructor de la clase
     */
    public void emptyList(){
        while (isEmpty() == false){
            deleteFirst();
            if (first == last){
                first = null;
                last = null;
            }
        }
    }
    
    /**
     * Busca un nodo en la lista, antes de la posicion pasada por parametro
     * @param position {int} posicion del nodo a buscar
     * @return {StringNode} nodo en la posicion buscada
     */
    public StringNode getNode(int position){
        StringNode aux = first;
        if (position == 0){
            return aux;
        }else{
            for (int i = 0; i < size; i++){
                if (i == position - 1){
                    return aux;
                }else{
                    aux = aux.getNext();
                }
            }
        }
        return null;
    }
    
    /**
     * Busca un nodo en la lista, segun la posicion pasada por parametro
     * @param position {int} posicion del nodo a buscar
     * @return {StringNode} nodo en la posicion buscada
     */
    public StringNode getNodeOrdered(int position){
        StringNode aux = first;
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
     * Añade un nuevo {StringNode} a la lista de primero
     * @param element {String} elemento almacenado en el nuevo nodo
     */
    public void addFirst(String element){
        StringNode newNode = new StringNode(element);
        if (isEmpty()){
            addEmpty(element);
        }else{
            newNode.setNext(first);
            first = newNode;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {StringNode} a la lista de ultimo
     * @param element {String} elemento almacenado en el nuevo nodo
     */
    public void addLast(String element){
        StringNode newNode = new StringNode(element);
        if (isEmpty()){
            addEmpty(element);
        }else{
            last.setNext(newNode);
            last = newNode;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {StringNode} a la lista vacia
     * @param element {String} elemento almacenado en el nuevo nodo
     */
    public void addEmpty(String element){
        StringNode newNode = new StringNode(element);
        first = newNode;
        last = newNode;
        size = size + 1;
    }
    
    /**
     * Añade un nuevo {StringNode} a la lista en la posicion indicada
     * @param element {String} elemento almacenado en el nuevo nodo
     * @param position {int} posicion en la que se agrega el nodo
     */
    public void addNode(String element, int position){
        StringNode newNode = new StringNode(element);
        if (isEmpty()){
            addEmpty(element);
        }else{
            if (position == 0){
                addFirst(element);
            }else if(position == size){
                addLast(element);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                StringNode aux = getNodeOrdered(position - 1);
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
                size = size + 1;
            }
        }
    }
    
    /**
     * Añade un nuevo {StringNode} a la lista antes de la posicion indicada
     * @param element {String} elemento almacenado en el nuevo nodo
     * @param position {int} posicion en la que se agrega el nodo
     */
    public void addPostPosition(String element, int position){
        addNode(element, position + 1);
    }

    /**
     * Elimina el primer nodo de la lista
     */
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            StringNode aux = first.getNext();
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
                StringNode aux = getNodeOrdered(position - 1);
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
     * Imprime la lista en la consola
     */
    public void printList(){
        StringNode aux = first;
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            for (int i = 0; i < size; i++){
                System.out.print(aux.getNodeName());
                if (i < size - 1){
                    System.out.print("-");
                }
                aux = aux.getNext();
            }
        }
    }
    
}
