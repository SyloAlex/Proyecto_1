package proyecto_1;

/**
 * Nodo utilizado para crear una lista de booleans.
 * @author Alex
 */
public class BooleanNode {
    
    private boolean element;
    private BooleanNode next;
    
    /**
     * Constructor de la clase booleanNode sin parametro
     */
    public BooleanNode(){
        this.element = false;
        this.next = null;
    }

    /**
     * Getter del elemento
     * @return element {boolean}
     */
    public boolean getNodeName() {
        return element;
    }

    /**
     * Setter del elemento
     * @param element {boolean}
     */
    public void setNodeName(boolean element) {
        this.element = element;
    }

    /**
     * Getter del siguiente nodo en la lista de booleans
     * @return next {booleanNode} siguiente nodo en la lista de booleans
     */
    public BooleanNode getNext() {
        return next;
    }

    /**
     * Setter del siguiente nodo en la lista de booleans
     * @param next {booleanNode} siguiente nodo en la lista de booleans
     */
    public void setNext(BooleanNode next) {
        this.next = next;
    }
    
}
