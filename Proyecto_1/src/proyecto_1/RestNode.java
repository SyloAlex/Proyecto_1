package proyecto_1;

/**
 * Nodo que contiene la informacion de un restaurante
 * @author Alex
 */
public class RestNode {
    
    private String restId;
    private String restName;
    private FoodList menu;
    private RestNode next;
    
    /**
     * Constructor de la clase RestNode sin parametros.
     */
    public RestNode(){
        this.restId = null;
        this.restName = null;
        this.menu = null;
        this.next = null;
    }
    
    /**
     * Constructor de la clase RestNode con parametros de ID del restaurant 
     * y nombre del mismo
     * @param restId {String} ID del restaurante
     * @param restName {String} Nombre del restaurante
     */
    public RestNode(String restId, String restName){
        this.restId = restId;
        this.restName = restName;
        this.menu = null;
        this.next = null;
    }
    
    /**
     * Constructor de la clase RestNode con parametros de ID del restaurant,
     *  nombre del mismo y menu.
     * @param restId {String} ID del restaurante
     * @param restName {String} Nombre del restaurante
     * @param menu {FoodList} lista de la comida disponible del restaurante
     */
    public RestNode(String restId, String restName, FoodList menu){
        this.restId = restId;
        this.restName = restName;
        this.menu = menu;
        this.next = null;
    }

    /**
     * Getter del nombre del restaurante
     * @return restName {String} Nombre del restaurante
     */
    public String getRestName() {
        return restName;
    }

    /**
     * Setter del nombre del restaurante
     * @param restName {String} Nombre del restaurante
     */
    public void setRestName(String restName) {
        this.restName = restName;
    }

    /**
     * Getter del menu del restaurante
     * @return menu {FoodList} lista de la comida disponible del restaurante
     */
    public FoodList getMenu() {
        return menu;
    }

    /**
     * Setter del menu del restaurante
     * @param menu {FoodList} lista de la comida disponible del restaurante
     */
    public void setMenu(FoodList menu) {
        this.menu = menu;
    }

    /**
     * Getter del siguiente nodo en la lista de restaurantes
     * @return next {RestNode} siguiente nodo al que apunta en la lista de 
     * restaurantes
     */
    public RestNode getNext() {
        return next;
    }

    /**
     * Setter del siguiente nodo en la lista de restaurantes
     * @param next {RestNode} siguiente nodo al que apunta en la lista de 
     * restaurantes
     */
    public void setNext(RestNode next) {
        this.next = next;
    }

    /**
     * Getter del ID del restaurante
     * @return restId {String} ID del restaurante
     */
    public String getRestId() {
        return restId;
    }

    /**
     * Setter del ID del restaurante
     * @param restId {String} ID del restaurante
     */
    public void setRestId(String restId) {
        this.restId = restId;
    }
    
    /**
     * Funcion que retorna en un string el nombre de la comida que se encuentra
     * en la posicion {int} pasada como argumento de la funcion.
     * @param id {int} posicion en la lista de comida.
     * @return result {String} que contiene la comida ubicada en la posicion 
     * que fue pasada como argumento
     */
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
    
    /**
     * Funcion que almacena en un string toda la informacion del nodo. Primero 
     * se agrega el nombre y ID del restaurante, y por ultimo se itera en 
     * la lista del menu para anexar cada plato y un ID que es la posicion
     * en la lista.
     * @return result {String} que contiene toda la informacion del restaurante
     */
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
