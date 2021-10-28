package proyecto_1;

public class SamanInfo {
    
    private RestList restaurants;
    private ClientsList clients;
    private OrderList orders;
    private RouteList routes;
    
    public SamanInfo(){
        this.restaurants = null;
        this.clients = null;
        this.orders = null;
        this.routes = null;
    }

    public RestList getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(RestList restaurants) {
        this.restaurants = restaurants;
    }

    public ClientsList getClients() {
        return clients;
    }

    public void setClients(ClientsList clients) {
        this.clients = clients;
    }

    public OrderList getOrders() {
        return orders;
    }

    public void setOrders(OrderList orders) {
        this.orders = orders;
    }

    public RouteList getRoutes() {
        return routes;
    }

    public void setRoutes(RouteList routes) {
        this.routes = routes;
    }
    
}
