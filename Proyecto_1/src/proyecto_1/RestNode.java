package proyecto_1;

public class RestNode {
    
    private String restName;
    private FoodList menu;
    private RestNode next;
    
    public RestNode(String restName){
        this.restName = restName;
        this.menu = null;
        this.next = null;
    }
    
    public RestNode(String restName, FoodList menu){
        this.restName = restName;
        this.menu = menu;
        this.next = null;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public FoodList getMenu() {
        return menu;
    }

    public void setMenu(FoodList menu) {
        this.menu = menu;
    }

    public RestNode getNext() {
        return next;
    }

    public void setNext(RestNode next) {
        this.next = next;
    }
    
}
