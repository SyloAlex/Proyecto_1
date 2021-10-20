package proyecto_1;

public class FoodNode {
    
    private String foodName;
    private FoodNode next;
    
    public FoodNode(String foodName){
        this.foodName = foodName;
        this.next = null;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public FoodNode getNext() {
        return next;
    }

    public void setNext(FoodNode next) {
        this.next = next;
    }
    
}
