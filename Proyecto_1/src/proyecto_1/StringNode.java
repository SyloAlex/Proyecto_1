package proyecto_1;

/**
 * Nodo utilizado para crear una matriz para obtener la ruta mas corta de un 
 * punto a otro.
 * @author Alex
 */
public class StringNode {
    
    private String nodeName;
    private StringNode next;
    
    /**
     * Constructor de la clase StringNode con parametro del nombre del nodo
     * @param nodeName {String} nombre del nodo
     */
    public StringNode(String nodeName){
        this.nodeName = nodeName;
        this.next = null;
    }

    /**
     * Getter del nombre del nodo
     * @return nodeName {String} nombre del nodo
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * Setter del nombre del nodo
     * @param nodeName {String} nombre del nodo
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * Getter del siguiente nodo en la lista de Strings
     * @return next {StringNode} siguiente nodo en la lista de Strings
     */
    public StringNode getNext() {
        return next;
    }

    /**
     * Setter del siguiente nodo en la lista de Strings
     * @param next {StringNode} siguiente nodo en la lista de Strings
     */
    public void setNext(StringNode next) {
        this.next = next;
    }
    
}
