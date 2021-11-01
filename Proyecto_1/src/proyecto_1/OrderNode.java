package proyecto_1;

/**
 * Nodo que contiene la informacion de una orden o pedido
 * @author Alex
 */
public class OrderNode {
    
    private String origin;
    private String destiny;
    private FoodList order;
    private OrderNode next;
    
    /**
     * Contructor de la clase OrderNode sin parametros
     */
    public OrderNode(){
        this.origin = null;
        this.destiny = null;
        this.order = null;
        this.next = null;
    }
    
    /**
     * Contructor de la clase OrderNode con parametros del origen del pedido y 
     * el destino del pedido.
     * @param origin {String} origen del pedido
     * @param destiny {String} destino del pedido
     */
    public OrderNode(String origin, String destiny){
        this.origin = origin;
        this.destiny = destiny;
        this.order = null;
        this.next = null;
    }
    
    /**
     * Contructor de la clase OrderNode con parametros del origen y destino del
     * pedido y los platos del mismo
     * @param origin {String} origen del pedido
     * @param destiny {String} destino del pedido
     * @param order {FoodList} lista con los platos de la orden
     */
    public OrderNode(String origin, String destiny, FoodList order){
        this.origin = origin;
        this.destiny = destiny;
        this.order = order;
        this.next = null;
    }

    /**
     * Getter del origen o salida del pedido
     * @return origin {String} origen del pedido
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Setter del origen o salida del pedido
     * @param origin {String} origen del pedido
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Getter del destino o llegada del pedido
     * @return destiny {String} destino del pedido
     */
    public String getDestiny() {
        return destiny;
    }

    /**
     * Setter del destino o llegada del pedido
     * @param destiny {String} destino del pedido
     */
    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    /**
     * Getter de la lista con los platos o comidas
     * @return order {FoodList} lista con los platos de la orden
     */
    public FoodList getOrder() {
        return order;
    }

    /**
     * Setter de la lista con los platos o comidas
     * @param order {FoodList} lista con los platos de la orden
     */
    public void setOrder(FoodList order) {
        this.order = order;
    }

    /**
     * Getter del siguiente nodo en la lista de ordenes pendientes
     * @return next {OrderNode} siguiente nodo en la lista de ordenes
     */
    public OrderNode getNext() {
        return next;
    }

    /**
     * Setter del siguiente nodo en la lista de ordenes pendientes
     * @param next {OrderNode} siguiente nodo en la lista de ordenes
     */
    public void setNext(OrderNode next) {
        this.next = next;
    }
    
    /**
     * Funcion que retorna toda la informacion almacenada en el nodo en forma 
     * de un string. Primero guarda en el string el origen y destino del 
     * pedido, y luego itera en la lista de comida para almacenar cada 
     * comida con la cantidad ordenada.
     * @return result {String} que contiene toda la informacion almacenada en 
     * el nodo.
     */
    public String displayOrder(){
        String result = "ID Origen: " + this.origin + " ID Destino: " 
                + this.destiny + "\n";
        if (this.order != null){
            FoodNode aux = this.order.getFirst();
            for (int i = 0; i < this.order.getSize(); i++){
                result += "Plato: " + aux.getFoodName();
                result += " Cantidad: " + aux.getQuantity() + "\n";
                aux = aux.getNext();
            }
        }
        return result;
    }
    
}
