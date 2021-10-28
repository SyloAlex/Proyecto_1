package proyecto_1;

public class GraphNode {
    
    private GraphNode next;
    private int element;
    
    public GraphNode(int element){
        this.element = element;
        this.next = null;
    }
    
    public GraphNode(int element, GraphNode next){
        this.element = element;
        this.next = next;
    }
    
    public GraphNode getNext(){
        return next;
    }
    
    public void setNext(GraphNode next){
        this.next = next;
    }
    
    public int getElement(){
        return element;
    }
    
    public void setElement(int element){
        this.element = element;
    }
    
}
