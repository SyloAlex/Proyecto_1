package proyecto_1;

/**
 * Lista de nodos para la construccion de la MAtrix Adyacente del grafo.
 * @author Alex
 */
public class GraphList {
    
    private GraphNode first;
    private GraphNode last;
    private GraphList nextList;
    private int size;
    
    /**
     * Constructor de la lista GraphList con parametros de tamaño y entero 
     * con el cual se llena la matriz.
     * @param size {int} tamaño de la lista
     * @param fill {int} entero con el cual se llena la matriz
     */
    public  GraphList(int size, int fill){
        this.first = null;
        this.last = null;
        this.nextList = null;
        for (int i = 0; i < size; i++){
            GraphNode newNode = new GraphNode(fill);
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
     * @return first {GraphNode} primer nodo de la lista
     */
    public GraphNode getFirst(){
        return first;
    }
    
    /**
     * Setter del primer nodo de la lista
     * @param newFirst {GraphNode} primer nodo de la lista
     */
    public void setFirst(GraphNode newFirst){
        this.first = newFirst;
    }
    
    /**
     * Getter del ultimo nodo de la lista
     * @return last {GraphNode} primer nodo de la lista
     */
    public GraphNode getLast(){
        return last;
    }
    
    /**
     * Setter del ultimo nodo de la lista
     * @param newLast {GraphNode} ultimo nodo de la lista
     */
    public void setLast(GraphNode newLast){
        this.first = newLast;
    }
    
    /**
     * Getter de la siguiente lista de la matriz
     * @return nextList {GraphList} siguiente lista de la matriz
     */
    public GraphList getNextList(){
        return nextList;
    }
    
    /**
     * Getter de la siguiente lista de la matriz
     * @param newNextList {GraphList} siguiente lista de la matriz
     */
    public void setNextList(GraphList newNextList){
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
     * Deconstructor de la lista
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
     * Busca el siguiente nodo en la lista, segun la posicion 
     * pasada por parametro
     * @param position {int} posicion del nodo a buscar
     * @return {GraphNode} nodo en la posicion buscada
     */
    public GraphNode getNode(int position){
        GraphNode aux = first;
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
     * @return {GraphNode} nodo en la posicion buscada
     */
    public GraphNode getNodeOrdered(int position){
        GraphNode aux = first;
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
     * Añade un nuevo {GraphNode} a la lista en la primera posicion
     * @param element {int} entero que se almacenara en el nodo para luego 
     * anexar a la lista
     */
    public void addFirst(int element){
        GraphNode newNode = new GraphNode(element);
        if (isEmpty()){
            addEmpty(element);
        }else{
            newNode.setNext(first);
            first = newNode;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {GraphNode} a la lista en la ultima posicion
     * @param element {int} entero que se almacenara en el nodo para luego 
     * anexar a la lista
     */
    public void addLast(int element){
        GraphNode newNode = new GraphNode(element);
        if (isEmpty()){
            addEmpty(element);
        }else{
            last.setNext(newNode);
            last = newNode;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {GraphNode} a la lista si esta vacia
     * @param element {int} entero que se almacenara en el nodo para luego 
     * anexar a la lista
     */
    public void addEmpty(int element){
        GraphNode newNode = new GraphNode(element);
        first = newNode;
        last = newNode;
        size = size + 1;
    }
    
    /**
     * Añade un nuevo {GraphNode} a la lista en la posicion indicada
     * @param element {int} entero que se almacenara en el nodo para luego 
     * anexar a la lista
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addNode(int element, int position){
        GraphNode newNode = new GraphNode(element);
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
                GraphNode aux = getNodeOrdered(position - 1);
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
                size = size + 1;
            }
        }
    }
    
    /**
     * Añade un nuevo {GraphNode} a la lista despues de la posicion indicada
     * @param element {int} entero que se almacenara en el nodo para luego 
     * anexar a la lista
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addPostPosition(int element, int position){
        addNode(element, position + 1);
    }
    
    /**
     * Añade un nuevo {GraphNode} a la lista en orden ascendente
     * @param element {int} entero que se almacenara en el nodo para luego 
     * anexar a la lista
     */
    public void addOrdered(int element){
        GraphNode aux = first;
        boolean flag = false;
        if (isEmpty()){
            addFirst(element);
        }else{
            for (int i = 0; i < size; i++){
                if (aux.getElement() < element){
                    addNode(element, i);
                    flag = true;
                    break;
                }else{
                    aux = aux.getNext();
                }
            }
            if (!flag){
                addLast(element);
            }
        }
    }

    /**
     * Elimina el primer nodo de la lista
     */
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            GraphNode aux = first.getNext();
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
                GraphNode aux = getNodeOrdered(position - 1);
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
     * Imprime en consola los elementos de los nodos almacenados en la lista.
     */
    public void printList(){
        GraphNode aux = first;
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            for (int i = 0; i < size; i++){
                if (aux.getElement() < 1000){
                    System.out.print(aux.getElement());
                }else{
                    System.out.print("INF");
                }
                if (i < size - 1){
                    System.out.print("-");
                }
                aux = aux.getNext();
            }
        }
    }
    
}
