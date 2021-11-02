package proyecto_1;

/**
 * Clase que almacena toda la informacion de la plataforma
 * @author Alex
 */
public class SamanInfo {
    
    private RestList restaurants;
    private ClientsList clients;
    private OrderList orders;
    private RouteList routes;
    private String pathTXT;
    
    /**
     * Constructor de la clase SamanInfo sin parametros
     */
    public SamanInfo(){
        this.restaurants = null;
        this.clients = null;
        this.orders = null;
        this.routes = null;
        this.pathTXT = "";
    }

    /**
     * Getter de la lista de restaurantes
     * @return
     */
    public RestList getRestaurants() {
        return restaurants;
    }

    /**
     * Setter de la lista de restaurantes
     * @param restaurants
     */
    public void setRestaurants(RestList restaurants) {
        this.restaurants = restaurants;
    }

    /**
     * Getter de la lista de clientes
     * @return
     */
    public ClientsList getClients() {
        return clients;
    }

    /**
     * Setter de la lista de clientes
     * @param clients
     */
    public void setClients(ClientsList clients) {
        this.clients = clients;
    }

    /**
     * Getter de la lista de ordenes
     * @return
     */
    public OrderList getOrders() {
        return orders;
    }

    /**
     * Setter de la lista de ordenes
     * @param orders
     */
    public void setOrders(OrderList orders) {
        this.orders = orders;
    }

    /**
     * Getter de la lista de rutas
     * @return
     */
    public RouteList getRoutes() {
        return routes;
    }

    /**
     * Setter de la lista de rutas
     * @param routes
     */
    public void setRoutes(RouteList routes) {
        this.routes = routes;
    }

    /**
     * Getter de la ruta del archivo TXT
     * @return pathTXT {String} ruta del archivo TXT
     */
    public String getPathTXT() {
        return pathTXT;
    }

    /**
     * Setter de la ruta del archivo TXT
     * @param pathTXT {String} ruta del archivo TXT
     */
    public void setPathTXT(String pathTXT) {
        this.pathTXT = pathTXT;
    }
    
    /**
     * Funcion que transforma el nombre y id de locales y clientes a un String
     *  para hecer display.
     * @return result {String} que contiene nombre y ID de restaurantes y 
     * clientes
     */
    public String infoToString(){
        String result = "Restaurants:\n";
        RestNode aux = this.restaurants.getFirst();
        for (int i = 0;  i < this.restaurants.getSize(); i++){
            result += "ID: " + aux.getRestId() + " Nombre: " + 
                    aux.getRestName() + "\n";
            aux = aux.getNext();
        }
        result += "Clientes:\n";
        ClientNode auxClient = this.clients.getFirst();
        for (int j = 0; j < this.clients.getSize(); j++){
            result += "ID: " + auxClient.getId() + " Nombre: " +
                    auxClient.getName() + "\n";
            auxClient = auxClient.getNext();
        }
        
        return result;
    }
    
}
