package proyecto_1;

public class DijkstraNodeI {
    
    private DijkstraNodeI next;
    private int element;
    
    public DijkstraNodeI(int element){
        this.element = element;
        this.next = null;
    }
    
    public DijkstraNodeI getNext(){
        return next;
    }
    
    public void setNext(DijkstraNodeI next){
        this.next = next;
    }
    
    public int getElement(){
        return element;
    }
    
    public void setElement(int element){
        this.element = element;
    }
    
}
