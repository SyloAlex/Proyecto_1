package proyecto_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Clase de metodos y procedimientos de la aplicacion
 * @author Alex
 */
public class Functions {
    
    /**
     * Constructor de la clase Functions sin parametros
     */
    public Functions(){
        
    }
    
    /**
     * Funcion que transforma el ID de un vertice ingresado en String a ASCII 
     * para luego transformarlo en el formato necesario. Si es un cliente le 
     * resta 1 y lo anexa, si es un Restaurant le resta 65 (llevandolo a 
     * un entero) y suma el tamaño de la lista de clientes.
     * @param road {Object} ID del vertice a cambiar
     * @param clients {ClientsList} lista de clientes de la plataforma
     * @return result {int} ID transpolado para la Matriz de Adyacencia
     */
    public int changeRoadStringInt(Object road, ClientsList clients){
        String roadString = String.valueOf(road);
        if (Character.isDigit(roadString.charAt(0))){
            int roadInt = Integer.parseInt(roadString);
            return roadInt - 1;
        }else{
            char roadChar = roadString.charAt(0);
            int roadInt = roadChar;
            return roadInt - 65 + clients.getSize();
        }
    }
    
    /**
     * Funcion que recibe un ID previamente transformado a int y lo devuelve 
     * a ser un String con el valor que previamente tenia. Si es un cliente le 
     * suma 1 y lo anexa, si es un Restaurant le suma 65 (llevandolo a 
     * un entero) y resta el tamaño de la lista de clientes.
     * @param road {int} ID del vertice transpolado para la matriz de 
     * adyacencia
     * @param clients {ClientsList} lista de clientes de la plataforma
     * @return result {String} ID del vertice a cambiar
     */
    public String changeRoadIntString(int road, ClientsList clients){
        String result;
        if (road < clients.getSize()){
            result = String.valueOf(road + 1);
        }else{
            result = String.valueOf((char)(road + 65 - clients.getSize()));
        }
        return result;
    }
    
    /**
     * Funcion que llena la Matriz de Adyacencia de Floyd-Warshall y la Matriz 
     * de caminos con los valores requeridos. La Matriz de Floyd-Warshall la 
     * llena con los pesos de las rutas, y la Matriz de rutas la llena con la 
     * salida de la ruta.
     * @param graph {Matrix} Matriz de Adyacencia de Floyd-Warshall
     * @param roads {Matrix} Matriz de Adyacencia de caminos
     * @param routes {RouteList} Lista de rutas de la plataforma
     * @param clients {ClientsList} Lista de clientes de la plataforma
     */
    public void fillMatrix(Matrix graph, Matrix roads, RouteList routes, ClientsList clients){
        RouteNode clientAux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            int entrance = changeRoadStringInt(clientAux.getEntrance(), clients);
            int exit = changeRoadStringInt(clientAux.getExit(), clients);
            graph.createPath(entrance, exit, 
                    clientAux.getWeight());
            roads.createPath(entrance, exit, 
                    exit);
            clientAux = clientAux.getNext();
        }
    }
    
    /**
     * Lee el archivo TXT contenido en el path proporcionado como argumento. 
     * Al culminar la lectura, crea el objeto SamanInfo en el cual se almacenan
     *  las rutas, clientes, restaurantes y ordenes contenidas en el TXT.
     * @param TXTpath {String} Path del archivo que contiene la informacion de 
     * la plataforma
     * @return {SamanInfo} Objeto que contiene toda la informacion de la 
     * plataforma.
     */
    public SamanInfo readTXT(String TXTpath){
        String samancitoTXT = "";
        String line;
        SamanInfo infoSaman = new SamanInfo();
        File file = new File(TXTpath);
        try{
            if (!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null){
                    if (!line.isEmpty()){
                        samancitoTXT += line + "\n";
                    }
                }
                String[] samanInfo = samancitoTXT.split("\n");
                String flag = "Restaurantes";
                RestList restaurants = new RestList();
                ClientsList clients = new ClientsList();
                OrderList orders = new OrderList();
                RouteList routes = new RouteList();
                for (int i = 0; i < samanInfo.length; i++){
                    if (flag.equals("Restaurantes")){
                        if (!samanInfo[i].equals("Clientes")){
                            if (samanInfo[i].equals("Restaurantes")){
                                continue;
                            }else{
                                String[] restInfo = samanInfo[i].split(",");
                                RestNode newRest = new RestNode();
                                newRest.setRestId(restInfo[0]);
                                newRest.setRestName(restInfo[1]);
                                FoodList menu = new FoodList();
                                String[] menuInfo = restInfo[2].split("/");
                                for (int j = 0; j < menuInfo.length; j++){
                                    FoodNode food = new FoodNode(menuInfo[j]);
                                    menu.addLast(food);
                                }
                                newRest.setMenu(menu);
                                restaurants.addLast(newRest);
                            }
                        }else{
                            flag = "Clientes";
                        }
                    }else if (flag.equals("Clientes")){
                        if (!samanInfo[i].equals("Pedidos")){
                            String[] clientInfo = samanInfo[i].split(",");
                            ClientNode newClient = new ClientNode();
                            newClient.setId(clientInfo[0]);
                            newClient.setName(clientInfo[1]);
                            newClient.setLastName(clientInfo[2]);
                            newClient.setDni(Integer.valueOf(clientInfo[3]));
                            clients.addLast(newClient);
                        }else{
                            flag = "Pedidos";
                        }
                    }else if (flag.equals("Pedidos")){
                        if (!samanInfo[i].equals("Rutas")){
                            String[] orderInfo = samanInfo[i].split(",");
                            OrderNode newOrder = new OrderNode();
                            newOrder.setOrigin(orderInfo[1]);
                            newOrder.setDestiny(orderInfo[0]);
                            FoodList orderFood = new FoodList();
                            String[] orderMenu = orderInfo[2].split("/");
                            for (int k = 0; k < orderMenu.length; k++){
                                String[] foodSplit = orderMenu[k].split("-");
                                FoodNode foodOrder = new FoodNode(foodSplit[1],
                                    Integer.valueOf(foodSplit[0]));
                                orderFood.addLast(foodOrder);
                            }
                            newOrder.setOrder(orderFood);
                            orders.addLast(newOrder);
                        }else{
                            flag = "Rutas";
                        }
                    }else if (flag.equals("Rutas")){
                        if (!samanInfo[i].equals("Rutas")){
                            String[] routeInfo = samanInfo[i].split(",");
                            RouteNode newRoute = new RouteNode();
                            newRoute.setEntrance(routeInfo[0]);
                            newRoute.setExit(routeInfo[1]);
                            newRoute.setWeight(Integer.valueOf(routeInfo[2]));
                            routes.addLast(newRoute);
                        }
                    }
                }
                if (restaurants.isEmpty() || clients.isEmpty() || orders.isEmpty() || routes.isEmpty()){
                    System.out.println("Me mori");
                    return null;
                }
                infoSaman.setRestaurants(restaurants);
                infoSaman.setClients(clients);
                infoSaman.setOrders(orders);
                infoSaman.setRoutes(routes);
                infoSaman.setPathTXT(TXTpath);
            }
            return infoSaman;
        }catch (Exception e){
            return null;
        }
    }
    
    /**
     * Funcion que recibe todas las listas que contienen la informacion de la 
     * plataforma y escribe un TXT con dicha informacion de forma organizada
     *  para luego poder ser leida.
     * @param restaurants {RestList} Lista de restaurantes de la plataforma
     * @param clients {ClientsList} Lista de restaurantes de la plataforma
     * @param orders {OrderList} Lista de restaurantes de la plataforma
     * @param routes {RouteList} Lista de restaurantes de la plataforma
     * @param txtPath {String} Path del archivo que contiene la informacion de 
     * la plataforma
     */
    public void writeTXT(RestList restaurants, ClientsList clients, 
            OrderList orders, RouteList routes, String txtPath){
        String txtString = "";
        txtString += "Restaurantes" + "\n";
        RestNode restAux = restaurants.getFirst();
        for (int i = 0; i < restaurants.getSize(); i++){
            String rest = "";
            rest += restAux.getRestId() + ",";
            rest += restAux.getRestName()+ ",";
            String foodString = "";
            FoodNode food = restAux.getMenu().getFirst();
            for (int j = 0; j < restAux.getMenu().getSize(); j++){
                foodString += food.getFoodName() + "/";
                food = food.getNext();
            }
            foodString = foodString.substring(0, foodString.length() - 1);
            rest += foodString + "\n";
            txtString += rest;
            restAux = restAux.getNext();
        }
        txtString += "Clientes" + "\n";
        ClientNode clientAux = clients.getFirst();
        for (int i = 0; i < clients.getSize(); i++){
            String client = "";
            client += clientAux.getId() + ",";
            client += clientAux.getName() + ",";
            client += clientAux.getLastName() + ",";
            client += clientAux.getDni() + "\n";
            txtString += client;
            clientAux = clientAux.getNext();
        }
        txtString += "Pedidos" + "\n";
        OrderNode orderAux = orders.getFirst();
        for (int i = 0; i < orders.getSize(); i++){
            String order = "";
            order += orderAux.getDestiny() + ",";
            order += orderAux.getOrigin() + ",";
            String menuString = "";
            FoodNode menu = orderAux.getOrder().getFirst();
            for (int j = 0; j < orderAux.getOrder().getSize(); j++){
                menuString += menu.getQuantity() + "-";
                menuString += menu.getFoodName() + "/";
                menu = menu.getNext();
            }
            menuString = menuString.substring(0, menuString.length() - 1);
            order += menuString + "\n";
            txtString += order;
            orderAux = orderAux.getNext();
        }
        txtString += "Rutas" + "\n";
        RouteNode routeAux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            String route = "";
            route += routeAux.getEntrance() + ",";
            route += routeAux.getExit() + ",";
            route += routeAux.getWeight() + "\n";
            txtString += route;
            routeAux = routeAux.getNext();
        }
        txtString = txtString.substring(0, txtString.length() - 1);
        try{
            PrintWriter pw = new PrintWriter(txtPath);
            pw.write(txtString);
            pw.close();
        }catch (Exception e){
            System.out.println("Me mori");
        }
    }
    
    /**
     * Funcion que recorre el grafo por anchura. 
     * @param info
     * @return
     */
    public String graphBFS(SamanInfo info){
        int n = 0;
        int a;
        String result = "";
        RouteList routes = info.getRoutes();
        ClientsList clients = info.getClients();
        RestList restaurants = info.getRestaurants();
        int vertex = clients.getSize() + restaurants.getSize();
        StringMatrix adjList = new StringMatrix(vertex, "");
        BooleanList bools = new BooleanList(vertex);
        StringGraphList queue = new StringGraphList(0, "");
        adjList = this.fillAdjList(adjList, routes, clients);
        bools.getNodeOrdered(n).setNodeName(true);
        queue.addLast(this.changeRoadIntString(n, clients));
        
        while (!queue.isEmpty()){
            String test = queue.deleteLastReturn().getNodeName();
            n = this.changeRoadStringInt(test, clients);
            result += test + "-";
            for (int i = 0; i < adjList.getList(n).getSize(); i++){
                a = this.changeRoadStringInt(
                        adjList.getList(n).getNodeOrdered(i).getNodeName(), clients);
                if (!bools.getNodeOrdered(a).getNodeName()){
                    bools.getNodeOrdered(a).setNodeName(true);
                    queue.addLast(this.changeRoadIntString(a, clients));
                }
            }
        }

        return result.substring(0, result.length() - 1);
    }
    
    /**
     *
     * @param adjList
     * @param routes
     * @param clients
     * @return
     */
    public StringMatrix fillAdjList(StringMatrix adjList, RouteList routes, 
            ClientsList clients){
        RouteNode aux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            int source = this.changeRoadStringInt(aux.getEntrance(), clients);
            StringGraphList auxList = adjList.getFirst();
            for (int j = 0; j < adjList.getSize(); j++){
                if (j == source){
                    adjList.getList(j).addLast(String.valueOf(aux.getExit()));
                    break;
                }else{
                    auxList = auxList.getNextList();
                }
            }
            aux = aux.getNext();
        }
        StringGraphList aux2 = adjList.getFirst();
        for (int i = 0; i < adjList.getSize(); i++){
            aux2.deleteFirst();
            aux2 = aux2.getNextList();
        }
        
        return adjList;
    }
}
