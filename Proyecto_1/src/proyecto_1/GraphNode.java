package proyecto_1;

/**
 * Nodo que contiene el elemento de la matriz de adyacencia del grafo
 * @author Alex
 */
public class GraphNode {
    
    private GraphNode next;
    private int element;
    
    /**
     * Contructor de la clase GraphNode (nodo del grafo/matriz) con parametro
     * element
     * @param element {int} numero con el cual se rellena el grafo
     */
    public GraphNode(int element){
        this.element = element;
        this.next = null;
    }
    
    /**
     * Contructor de la clase GraphNode (nodo del grafo/matriz) con parametros
     * element y el siguiente nodo al que apunta
     * @param element {int} numero con el cual se rellena el grafo
     * @param next {GraphNode} siguiente nodo al que apunta en la lista
     */
    public GraphNode(int element, GraphNode next){
        this.element = element;
        this.next = next;
    }
    
    /**
     * Getter del siguiente nodo GraphNode al que apunta en la lista
     * @return next {GraphNode} el siguiente nodo al que apunta
     */
    public GraphNode getNext(){
        return next;
    }
    
    /**
     * Setter del siguiente nodo GraphNode al que apunta en la lista
     * @param next {GraphNode} el siguiente nodo al que apunta
     */
    public void setNext(GraphNode next){
        this.next = next;
    }
    
    /**
     * Getter del elemento almacenado en el nodo
     * @return element {int} el elemento almacenado en el nodo
     */
    public int getElement(){
        return element;
    }
    
    /**
     * Setter del elemento almacenado en el nodo
     * @param element {int} el elemento ha almacenar en el nodo
     */
    public void setElement(int element){
        this.element = element;
    }
    
}
