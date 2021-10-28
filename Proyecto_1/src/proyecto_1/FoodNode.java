package proyecto_1;

public class FoodNode {
    
    private String foodName;
    private int quantity;
    private FoodNode next;
    
    public FoodNode(String foodName){
        this.foodName = foodName;
        this.quantity = 0;
        this.next = null;
    }
    
    public FoodNode(String foodName, int quantity){
        this.foodName = foodName;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
