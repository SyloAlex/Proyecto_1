package proyecto_1;

/**
 * Nodo que contiene los datos de un plato de comida del local
 * @author Alex
 */
public class FoodNode {
    
    private String foodName;
    private int quantity;
    private FoodNode next;
    
    /**
     * Contructor de la clase FoodNode con el nombre de la comida como 
     * parametro
     * @param foodName {String} que contiene el nombre del plato o comida
     */
    public FoodNode(String foodName){
        this.foodName = foodName;
        this.quantity = 0;
        this.next = null;
    }
    
    /**
     * Contructor de la clase FoodNode con el nombre de la comida y la cantidad
     * como parametro
     * @param foodName {String} que contiene el nombre de el plato o comida
     * @param quantity {int} que contiene la cantidad (en unidades) del plato 
     * o comida
     */
    public FoodNode(String foodName, int quantity){
        this.foodName = foodName;
        this.quantity = quantity;
        this.next = null;
    }

    /**
     * Getter del nombre del plato
     * @return {String} foodName que contiene el nombre del plato o comida
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Setter del nombre del plato
     * @param foodName {String} que contiene el nombre del plato o comida
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Getter del siguiente nodo FoodNode en la lista
     * @return next {FoodNode} el siguiente nodo en la lista de comidas y platos
     */
    public FoodNode getNext() {
        return next;
    }

    /**
     * Setter del siguiente nodo FoodNode en la lista
     * @param next {FoodNode} el siguiente nodo en la lista de comidas y platos
     */
    public void setNext(FoodNode next) {
        this.next = next;
    }

    /**
     * Getter de la cantidad del plato en una orden
     * @return quantity {int} cantidad del plato o comida en una orden
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter de la cantidad del plato en una orden
     * @param quantity {int} cantidad del plato o comida en una orden
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
