package proyecto_1;

/**
 * Lista de vertices recorridos buscando el camino mas corto usando Dijkstra
 * @author Alex
 */
public class VertexList {
    
    private StringNode first;
    private StringNode last;
    private int size;
    
    /**
     * Constructor de la clase VertexList sin parametros
     */
    public VertexList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Getter del primer nodo de la lista
     * @return first {StringNode} primer nodo de la lista
     */
    public StringNode getFirst() {
        return first;
    }

    /**
     * Setter del primer nodo de la lista
     * @param first {StringNode} primer nodo de la lista
     */
    public void setFirst(StringNode first) {
        this.first = first;
    }

    /**
     * Getter del ultimo nodo de la lista
     * @return last {StringNode} ultimo nodo de la lista
     */
    public StringNode getLast() {
        return last;
    }

    /**
     * Setter del ultimo nodo de la lista
     * @param last {StringNode} ultimo nodo de la lista
     */
    public void setLast(StringNode last) {
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
     * Busca un nodo en la lista, antes de la posicion pasada por parametro
     * @param position {int} posicion del nodo a buscar
     * @return {StringNode} nodo en la posicion buscada
     */
    public StringNode getNode(int position){
        StringNode aux = first;
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
     * Añade un nuevo {StringNode} a la lista vacia
     * @param newVertex {StringNode} nuevo nodo
     */
    public void addEmpty(StringNode newVertex){
        first = newVertex;
        last = newVertex;
        size = size + 1;
    }
    
    /**
     * Añade un nuevo {StringNode} a la lista de primero
     * @param newVertex {StringNode} nuevo nodo
     */
    public void addFirst(StringNode newVertex){
        if (isEmpty()){
            addEmpty(newVertex);
        }else{
            newVertex.setNext(first);
            first = newVertex;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {StringNode} a la lista de ultimo
     * @param newVertex {StringNode} nuevo nodo
     */
    public void addLast(StringNode newVertex){
        if (isEmpty()){
            addEmpty(newVertex);
        }else{
            if (last == null){
                System.out.println("Me mori");
            }
            last.setNext(newVertex);
            last = newVertex;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {StringNode} a la lista en la posicion indicada
     * @param newVertex {StringNode} nuevo nodo
     * @param position {int} posicion en la que se agrega el nodo
     */
    public void addNode(StringNode newVertex, int position){
        if (isEmpty()){
            addEmpty(newVertex);
        }else{
            if (position == 0){
                addFirst(newVertex);
            }else if(position == size){
                addLast(newVertex);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                StringNode aux = getNode(position - 1);
                newVertex.setNext(aux.getNext());
                aux.setNext(newVertex);
                size = size + 1;
            }
        }
    }
    
    /**
     * Añade un nuevo {StringNode} a la lista antes de la posicion indicada
     * @param newVertex {StringNode} nuevo nodo
     * @param position {int} posicion en la que se agrega el nodo
     */
    public void addPostPosition(StringNode newVertex, int position){
        addNode(newVertex, position + 1);
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
                StringNode aux = getNode(position - 1);
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
