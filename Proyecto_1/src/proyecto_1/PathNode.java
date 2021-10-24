package proyecto_1;

public class PathNode {
    
    private int distance;
    private VertexList vertexes;
    private String lastNode;
    private PathNode next;
    
    public PathNode(int distance, String lastNode){
        this.distance = distance;
        this.lastNode = lastNode;
        this.vertexes = new VertexList();
        vertexes.addLast(new StringNode(lastNode));
        this.next = null;
    }
    
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public VertexList getVertexes() {
        return vertexes;
    }

    public void setVertexes(VertexList vertexes) {
        this.vertexes = vertexes;
    }

    public String getLastNode() {
        return lastNode;
    }

    public void setLastNode(String lastNode) {
        this.lastNode = lastNode;
    }

    public PathNode getNext() {
        return next;
    }

    public void setNext(PathNode next) {
        this.next = next;
    }
    
    public void printVertexes(){
        StringNode aux = vertexes.getFirst();
        for (int i = 0; i < vertexes.getSize(); i++){
            System.out.print(aux.getNodeName());
            if (i < vertexes.getSize() - 1){
                System.out.print("-");
            }
            aux = aux.getNext();
        }
    }
    
}
