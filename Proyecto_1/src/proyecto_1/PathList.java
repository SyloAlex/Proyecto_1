package proyecto_1;

/**
 * Lista de caminos recorridos por el algoritmo de Dijkstra para encontrar
 *  el camino mas corto
 * @author Alex
 */
public class PathList {
    
    private PathNode first;
    private PathNode last;
    private int size;
    
    /**
     * Constructor de la clase PathList sin argumentos.
     */
    public PathList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Getter del primer nodo de la lista
     * @return first {PathNode} primer nodo de la lista
     */
    public PathNode getFirst() {
        return first;
    }

    /**
     * Setter del primer nodo de la lista
     * @param first {PathNode} primer nodo de la lista
     */
    public void setFirst(PathNode first) {
        this.first = first;
    }

    /**
     * Getter del ultimo nodo de la lista
     * @return last {PathNode} ultimo nodo de la lista
     */
    public PathNode getLast() {
        return last;
    }

    /**
     * Setter del ultimo nodo de la lista
     * @param last {PathNode} ultimo nodo de la lista
     */
    public void setLast(PathNode last) {
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
     * @return {PathNode} nodo en la posicion buscada
     */
    public PathNode getNode(int position){
        PathNode aux = first;
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
     * @param newPath {ClientNode} nodo del cliente.
     */
    public void addEmpty(PathNode newPath){
        first = newPath;
        last = newPath;
        size = size + 1;
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista en la primera posicion
     * @param newPath {ClientNode} nodo del cliente.
     */
    public void addFirst(PathNode newPath){
        if (isEmpty()){
            addEmpty(newPath);
        }else{
            newPath.setNext(first);
            first = newPath;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista en la ultima posicion
     * @param newPath {ClientNode} nodo del cliente.
     */
    public void addLast(PathNode newPath){
        if (isEmpty()){
            addEmpty(newPath);
        }else{
            last.setNext(newPath);
            last = newPath;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {PathNode} a la lista en la posicion indicada
     * @param newPath {PathNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addNode(PathNode newPath, int position){
        if (isEmpty()){
            addEmpty(newPath);
        }else{
            if (position == 0){
                addFirst(newPath);
            }else if(position == size){
                addLast(newPath);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                PathNode aux = getNode(position - 1);
                newPath.setNext(aux.getNext());
                aux.setNext(newPath);
                size = size + 1;
            }
        }
    }
    
    /**
     * Añade un nuevo {PathNode} a la lista despues de la posicion indicada
     * @param newPath {PathNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addPostPosition(PathNode newPath, int position){
        addNode(newPath, position + 1);
    }
    
    /**
     * Elimina el primer nodo de la lista
     */
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            PathNode aux = first.getNext();
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
                PathNode aux = getNode(position - 1);
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
     * Funcion que revisa la distancia de cada nodo en la lista para obtener
     *  el nodo con la distancia mas corto
     * @return position {int} posicion en la lista del nodo que tiene la menor 
     * distancia recorrida de todos los nodos.
     */
    public int minimumDistance(){
        PathNode aux = first;
        int flag = first.getDistance();
        int position = 0;
        for (int i = 0; i < size; i++){
            if (flag > aux.getDistance()){
                flag = aux.getDistance();
                aux = aux.getNext();
                position = i;
            }else{
                aux = aux.getNext();
            }
        }
        return position;
    }
    
}
