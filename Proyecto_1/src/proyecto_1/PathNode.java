package proyecto_1;

/**
 * Nodo que contiene la informacion de una ruta recorrida por el algoritmo de 
 * Dijkstra
 * @author Alex
 */
public class PathNode {
    
    private int distance;
    private VertexList vertexes;
    private String lastNode;
    private PathNode next;
    
    /**
     * Constructor de la clase PathNode con parametros distancia acumulada y 
     * ultimo vertice visitado en el recorrido.
     * @param distance {int} distancia acumulada en el recorrido
     * @param lastNode {String} nombre del ultimo vertice visitado en el 
     * recorrido.
     */
    public PathNode(int distance, String lastNode){
        this.distance = distance;
        this.lastNode = lastNode;
        this.vertexes = new VertexList();
        vertexes.addLast(new StringNode(lastNode));
        this.next = null;
    }
    
    /**
     * Constructor de la clase PathNode con parametros distancia acumulada, 
     * ultimo vertice visitado en el recorrido y vertices recorridos.
     * @param distance {int} distancia acumulada en el recorrido
     * @param lastNode {String} nombre del ultimo vertice visitado en el 
     * recorrido.
     * @param vertexes {VertexList} lista de vertices recorridos en el camino.
     */
    public PathNode(int distance, String lastNode, VertexList vertexes){
        this.distance = distance;
        this.lastNode = lastNode;
        this.vertexes = new VertexList();
        for (int i = 0; i < vertexes.getSize(); i++){
            this.vertexes.addLast(new StringNode(vertexes.getNode(i).getNodeName()));
        }
        this.vertexes.addLast(new StringNode(lastNode));
        this.next = null;
    }

    /**
     * Getter de la distancia acumulada en el recorrido
     * @return distance {int} distancia acumulada en el recorrido
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Setter de la distancia acumulada en el recorrido
     * @param distance {int} distancia acumulada en el recorrido
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Getter de la lista de vertices recorridos en el camino
     * @return vertexes {VertexList} lista de vertices recorridos en el camino
     */
    public VertexList getVertexes() {
        return vertexes;
    }

    /**
     * Setter de la lista de vertices recorridos en el camino
     * @param vertexes {VertexList} lista de vertices recorridos en el camino
     */
    public void setVertexes(VertexList vertexes) {
        this.vertexes = vertexes;
    }

    /**
     * Getter del ultimo vertice visitado en el camino
     * @return lastNode {String} ultimo nodo visitado en el camino
     */
    public String getLastNode() {
        return lastNode;
    }

    /**
     * Setter del ultimo vertice visitado en el camino
     * @param lastNode {String} ultimo nodo visitado en el camino
     */
    public void setLastNode(String lastNode) {
        this.lastNode = lastNode;
    }

    /**
     * Getter del siguiente nodo {PathNode} en la lista de caminos
     * @return next {PathNode} siguiente nodo en la lista de caminos
     */
    public PathNode getNext() {
        return next;
    }

    /**
     * Setter del siguiente nodo {PathNode} en la lista de caminos
     * @param next {PathNode} siguiente nodo en la lista de caminos
     */
    public void setNext(PathNode next) {
        this.next = next;
    }
    
    /**
     * Funcion que retorna toda la informacion almacenada en el nodo en forma 
     * de un string. La funcion itera sobre los vertices almacenados en
     *  {VertexList} y los guarda en el string.
     * @return resultString {String} que contiene todos los vertices recorridos
     * en el camino recorrido.
     */
    public String vertexesToString(){
        StringNode aux = vertexes.getFirst();
        String resultString = "";
        for (int i = 0; i < vertexes.getSize(); i++){
            resultString += aux.getNodeName();
            if (i < vertexes.getSize() - 1){
                resultString += "-";
            }
            aux = aux.getNext();
        }
        return resultString;
    }
    
}
