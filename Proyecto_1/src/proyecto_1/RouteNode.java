package proyecto_1;

public class RouteNode {
    
    private RouteNode next;
    private Object entrance;
    private Object exit;
    private int weight;
    
    public RouteNode(){
        this.entrance = null;
        this.exit = null;
        this.weight = 0;
        this.next = null;
    }
    
    public RouteNode(Object entrance, Object exit, int weight){
        this.entrance = entrance;
        this.exit = exit;
        this.weight = weight;
        this.next = null;
    }

    public RouteNode getNext() {
        return next;
    }

    public void setNext(RouteNode next) {
        this.next = next;
    }

    public Object getEntrance() {
        return entrance;
    }

    public void setEntrance(Object entrance) {
        this.entrance = entrance;
    }

    public Object getExit() {
        return exit;
    }

    public void setExit(Object exit) {
        this.exit = exit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
