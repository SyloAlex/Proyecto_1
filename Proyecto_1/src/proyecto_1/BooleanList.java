package proyecto_1;

/**
 * Lista de Booleans para poder saber cuales vertices fueron recorridos
 * @author Alex
 */
public class BooleanList {
    
    private BooleanNode first;
    private BooleanNode last;
    private int size;
    
    /**
     * Constructor de la clase BooleanList con parametros del tamaño de la 
     * lista
     * @param size {int} tamaño de la lista
     */
    public  BooleanList(int size){
        this.first = null;
        this.last = null;
        for (int i = 0; i < size; i++){
            BooleanNode newNode = new BooleanNode();
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
     * @return first {BooleanNode} primer nodo de la lista
     */
    public BooleanNode getFirst(){
        return first;
    }
    
    /**
     * Setter del primer nodo de la lista
     * @param newFirst {BooleanNode} primer nodo de la lista
     */
    public void setFirst(BooleanNode newFirst){
        this.first = newFirst;
    }
    
    /**
     * Getter del ultimo nodo de la lista
     * @return last {BooleanNode} ultimo nodo de la lista
     */
    public BooleanNode getLast(){
        return last;
    }
    
    /**
     * Setter del ultimo nodo de la lista
     * @param newLast {BooleanNode} ultimo nodo de la lista
     */
    public void setLast(BooleanNode newLast){
        this.first = newLast;
    }
    
    /**
     * Getter del tamaño de la lista
     * @return size {int} tamaño de la lista
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Busca un nodo en la lista, segun la posicion pasada por parametro
     * @param position {int} posicion del nodo a buscar
     * @return {BooleanNode} nodo en la posicion buscada
     */
    public BooleanNode getNodeOrdered(int position){
        BooleanNode aux = first;
            for (int i = 0; i < size; i++){
                if (i == position){
                    return aux;
                }else{
                    aux = aux.getNext();
                }
            }
        return null;
    }
    
}
