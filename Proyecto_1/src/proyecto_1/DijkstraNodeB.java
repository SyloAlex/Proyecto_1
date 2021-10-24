package proyecto_1;

public class DijkstraNodeB {
    
    private DijkstraNodeB next;
    private Boolean element;
    
    public DijkstraNodeB(Boolean element){
        this.element = element;
        this.next = null;
    }
    
    public DijkstraNodeB getNext(){
        return next;
    }
    
    public void setNext(DijkstraNodeB next){
        this.next = next;
    }
    
    public Boolean getElement(){
        return element;
    }
    
    public void setElement(Boolean element){
        this.element = element;
    }
    
}
