package proyecto_1;

public class GraphNode {
    
    private GraphNode next;
    private double element;
    
    public GraphNode(double element){
        this.element = element;
        this.next = null;
    }
    
    public GraphNode(double element, GraphNode next){
        this.element = element;
        this.next = next;
    }
    
    public GraphNode getNext(){
        return next;
    }
    
    public void setNext(GraphNode next){
        this.next = next;
    }
    
    public double getElement(){
        return element;
    }
    
    public void setElement(double element){
        this.element = element;
    }
    
}
