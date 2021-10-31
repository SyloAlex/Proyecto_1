package proyecto_1;

public class RestNode {
    
    private String restId;
    private String restName;
    private FoodList menu;
    private RestNode next;
    
    public RestNode(){
        this.restId = null;
        this.restName = null;
        this.menu = null;
        this.next = null;
    }
    
    public RestNode(String restId, String restName){
        this.restId = restId;
        this.restName = restName;
        this.menu = null;
        this.next = null;
    }
    
    public RestNode(String restId, String restName, FoodList menu){
        this.restId = restId;
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

    public String getRestId() {
        return restId;
    }

    public void setRestId(String restId) {
        this.restId = restId;
    }
    
    public String searchFoodWithID(int id){
        String result = "";
        FoodNode aux = menu.getFirst();
        for (int i = 0; i < menu.getSize(); i++){
            if ((id - 1) == i){
                result += aux.getFoodName();
                break;
            }else{
                aux = aux.getNext();
            }
        }
        return result;
    }
    
    public String restToString(){
        String result = "";
        result += "Nombre: " + this.restName;
        result += " ID: " + this.restId + "\n";
        if (this.menu != null){
            FoodNode aux = this.menu.getFirst();
            for (int i = 0; i < this.menu.getSize(); i++){
                result += "Plato #" + (i + 1) + " " + aux.getFoodName() + "\n";
                aux = aux.getNext();
            }
        }
        return result;
    }
    
}
