package proyecto_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class Functions {
    
    public Functions(){
        
    }
    
    public void changeRoutesEntrance(RouteList routes, ClientsList clients){
        RouteNode clientAux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            String routeString = String.valueOf(clientAux.getEntrance());
            if (Character.isDigit(routeString.charAt(0))){
                int routeInt = Integer.parseInt(routeString);
                clientAux.setEntrance(routeInt - 1);
            }else{
                char routeChar = routeString.charAt(0);
                int routeInt = routeChar;
                clientAux.setEntrance(routeInt - 65 + clients.getSize());
            }
            clientAux = clientAux.getNext();
        }
    }
    
    public void changeRoutesExits(RouteList routes, ClientsList clients){
        RouteNode clientAux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            String routeString = String.valueOf(clientAux.getExit());
            if (Character.isDigit(routeString.charAt(0))){
                int routeInt = Integer.parseInt(routeString);
                clientAux.setExit(routeInt - 1);
            }else{
                char routeChar = routeString.charAt(0);
                int routeInt = routeChar;
                clientAux.setExit(routeInt - 65 + clients.getSize());
            }
            clientAux = clientAux.getNext();
        }
    }
    
    public RouteList copyRoutes(RouteList original){
        RouteNode clientAux = original.getFirst();
        RouteList copy = new RouteList();
        for (int i = 0; i < original.getSize(); i++){
            RouteNode newRoute = new RouteNode(clientAux.getEntrance(), clientAux.getExit(),
            clientAux.getWeight());
            copy.addLast(newRoute);
            clientAux = clientAux.getNext();
        }
        return copy;
    }
    
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
    
    public String changeRoadIntString(int road, ClientsList clients){
        String result;
        if (road < clients.getSize()){
            result = String.valueOf(road + 1);
        }else{
            result = String.valueOf((char)(road + 65 - clients.getSize()));
        }
        return result;
    }
    
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
    
    public SamanInfo readTXT(String TXTpath){
        String samancitoTXT = "";
        String line;
        SamanInfo infoSaman = new SamanInfo();
        TXTpath = "test\\samancito.txt";
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
            }
            return infoSaman;
        }catch (Exception e){
            System.out.println("Me mori");
            return null;
        }
    }
    
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
            System.out.println("No me mori");
        }catch (Exception e){
            System.out.println("Me mori");
        }
    }
}
