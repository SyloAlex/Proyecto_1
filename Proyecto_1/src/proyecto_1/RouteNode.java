package proyecto_1;

/**
 * Nodo que contiene la informacion de una ruta
 * @author Alex
 */
public class RouteNode {
    
    private RouteNode next;
    private Object entrance;
    private Object exit;
    private int weight;
    
    /**
     * Contructor de la clase RouteNode sin argumentos
     */
    public RouteNode(){
        this.entrance = null;
        this.exit = null;
        this.weight = 0;
        this.next = null;
    }
    
    /**
     * Constructor de la clase RouteNode con argumentos de ruta de entrada, 
     * ruta de salida y el peso de la ruta.
     * @param entrance {Object} vertice de entrada a la ruta. Por lo general 
     * tiene forma de String o int.
     * @param exit {Object} vertice de salida a la ruta. Por lo general 
     * tiene forma de String o int.
     * @param weight {int} peso de la ruta. Equivale a lo que toma en tomar 
     * el camino designado.
     */
    public RouteNode(Object entrance, Object exit, int weight){
        this.entrance = entrance;
        this.exit = exit;
        this.weight = weight;
        this.next = null;
    }

    /**
     * Getter del siguiente nodo en la lista de rutas.
     * @return next {RouteNode} siguiente nodo en la lista de rutas
     */
    public RouteNode getNext() {
        return next;
    }

    /**
     * Setter del siguiente nodo en la lista de rutas.
     * @param next {RouteNode} siguiente nodo en la lista de rutas
     */
    public void setNext(RouteNode next) {
        this.next = next;
    }

    /**
     * Getter de la entrada a la ruta
     * @return entrance {Object} vertice de entrada a la ruta. Por lo general 
     * tiene forma de String o int.
     */
    public Object getEntrance() {
        return entrance;
    }

    /**
     * Setter de la entrada a la ruta
     * @param entrance {Object} vertice de entrada a la ruta. Por lo general 
     * tiene forma de String o int.
     */
    public void setEntrance(Object entrance) {
        this.entrance = entrance;
    }

    /**
     * Getter de la salida a la ruta
     * @return exit {Object} vertice de salida a la ruta. Por lo general 
     * tiene forma de String o int.
     */
    public Object getExit() {
        return exit;
    }

    /**
     * Setter de la salida a la ruta
     * @param exit {Object} vertice de salida a la ruta. Por lo general 
     * tiene forma de String o int.
     */
    public void setExit(Object exit) {
        this.exit = exit;
    }

    /**
     * Getter del peso de la ruta
     * @return weight {int} peso de la ruta. Equivale a lo que toma en tomar 
     * el camino designado.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Setter del peso de la ruta
     * @param weight {int} peso de la ruta. Equivale a lo que toma en tomar 
     * el camino designado.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
