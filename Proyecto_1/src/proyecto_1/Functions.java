package proyecto_1;

public class Functions {
    
    public Functions(){
        
    }
    
    public void changeRoutesEntrance(RouteList routes, ClientsList clients){
        RouteNode aux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            try{
                String routeString = String.valueOf(aux.getEntrance());
                int routeInt = Integer.parseInt(routeString);
                aux.setEntrance(routeInt - 1);
            }catch(Exception e){
                String routeString = String.valueOf(aux.getEntrance());
                char routeChar = routeString.charAt(0);
                int routeInt = routeChar;
                aux.setEntrance(routeInt - 65 + clients.getSize());
            }
            aux = aux.getNext();
        }
    }
    
    public void changeRoutesExits(RouteList routes, ClientsList clients){
        RouteNode aux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            try{
                String routeString = String.valueOf(aux.getExit());
                int routeInt = Integer.parseInt(routeString);
                aux.setExit(routeInt - 1);
            }catch(Exception e){
                String routeString = String.valueOf(aux.getExit());
                char routeChar = routeString.charAt(0);
                int routeInt = routeChar;
                aux.setExit(routeInt - 65 + clients.getSize());
            }
            aux = aux.getNext();
        }
    }
    
    public void fillMatrix(Matrix graph, RouteList routes){
        RouteNode aux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            graph.createPath((int)aux.getEntrance(), (int)aux.getExit(), 
                    aux.getWeight());
            aux = aux.getNext();
        }
    }
    
//    public void changeRoutesEntrance(RouteList routes, ClientsList clients){
//        RouteNode aux = routes.getFirst();
//        for (int i = 0; i < routes.getSize(); i++){
//            if (aux.getEntrance() == "A"){
//                aux.setEntrance(clients.getSize());
//            }else if (aux.getEntrance() == "B"){
//                aux.setEntrance(clients.getSize() + 1);
//            }else if (aux.getEntrance() == "C"){
//                aux.setEntrance(clients.getSize() + 2);
//            }else if (aux.getEntrance() == "D"){
//                aux.setEntrance(clients.getSize() + 3);
//            }else if (aux.getEntrance() == "E"){
//                aux.setEntrance(clients.getSize() + 4);
//            }else if (aux.getEntrance() == "F"){
//                aux.setEntrance(clients.getSize() + 5);
//            }else if (aux.getEntrance() == "G"){
//                aux.setEntrance(clients.getSize() + 6);
//            }else if (aux.getEntrance() == "H"){
//                aux.setEntrance(clients.getSize() + 7);
//            }else if (aux.getEntrance() == "I"){
//                aux.setEntrance(clients.getSize() + 8);
//            }else if (aux.getEntrance() == "J"){
//                aux.setEntrance(clients.getSize() + 9);
//            }else if (aux.getEntrance() == "K"){
//                aux.setEntrance(clients.getSize() + 10);
//            }else if (aux.getEntrance() == "L"){
//                aux.setEntrance(clients.getSize() + 11);
//            }else if (aux.getEntrance() == "M"){
//                aux.setEntrance(clients.getSize() + 12);
//            }else if (aux.getEntrance() == "N"){
//                aux.setEntrance(clients.getSize() + 13);
//            }else if (aux.getEntrance() == "O"){
//                aux.setEntrance(clients.getSize() + 14);
//            }else if (aux.getEntrance() == "P"){
//                aux.setEntrance(clients.getSize() + 15);
//            }else if (aux.getEntrance() == "Q"){
//                aux.setEntrance(clients.getSize() + 16);
//            }else if (aux.getEntrance() == "R"){
//                aux.setEntrance(clients.getSize() + 17);
//            }else if (aux.getEntrance() == "S"){
//                aux.setEntrance(clients.getSize() + 18);
//            }else if (aux.getEntrance() == "T"){
//                aux.setEntrance(clients.getSize() + 19);
//            }else if (aux.getEntrance() == "U"){
//                aux.setEntrance(clients.getSize() + 20);
//            }else if (aux.getEntrance() == "V"){
//                aux.setEntrance(clients.getSize() + 21);
//            }else if (aux.getEntrance() == "W"){
//                aux.setEntrance(clients.getSize() + 22);
//            }else if (aux.getEntrance() == "X"){
//                aux.setEntrance(clients.getSize() + 23);
//            }else if (aux.getEntrance() == "Y"){
//                aux.setEntrance(clients.getSize() + 24);
//            }else if (aux.getEntrance() == "Z"){
//                aux.setEntrance(clients.getSize() + 25);
//            }else{
//                String routeString = String.valueOf(aux.getEntrance());
//                int routeInt = Integer.parseInt(routeString);
//                aux.setEntrance(routeInt - 1);
//            }
//            aux = aux.getNext();
//        }
//    }
//    
//    public void changeRoutesExits(RouteList routes, ClientsList clients){
//        RouteNode aux = routes.getFirst();
//        for (int i = 0; i < routes.getSize(); i++){
//            if (aux.getExit()== "A"){
//                aux.setExit(clients.getSize());
//            }else if (aux.getExit() == "B"){
//                aux.setExit(clients.getSize() + 1);
//            }else if (aux.getExit() == "C"){
//                aux.setExit(clients.getSize() + 2);
//            }else if (aux.getExit() == "D"){
//                aux.setExit(clients.getSize() + 3);
//            }else if (aux.getExit() == "E"){
//                aux.setExit(clients.getSize() + 4);
//            }else if (aux.getExit() == "F"){
//                aux.setExit(clients.getSize() + 5);
//            }else if (aux.getExit() == "G"){
//                aux.setExit(clients.getSize() + 6);
//            }else if (aux.getExit() == "H"){
//                aux.setExit(clients.getSize() + 7);
//            }else if (aux.getExit() == "I"){
//                aux.setExit(clients.getSize() + 8);
//            }else if (aux.getExit() == "J"){
//                aux.setExit(clients.getSize() + 9);
//            }else if (aux.getExit() == "K"){
//                aux.setExit(clients.getSize() + 10);
//            }else if (aux.getExit() == "L"){
//                aux.setExit(clients.getSize() + 11);
//            }else if (aux.getExit() == "M"){
//                aux.setExit(clients.getSize() + 12);
//            }else if (aux.getExit() == "N"){
//                aux.setExit(clients.getSize() + 13);
//            }else if (aux.getExit() == "O"){
//                aux.setExit(clients.getSize() + 14);
//            }else if (aux.getExit() == "P"){
//                aux.setExit(clients.getSize() + 15);
//            }else if (aux.getExit() == "Q"){
//                aux.setExit(clients.getSize() + 16);
//            }else if (aux.getExit() == "R"){
//                aux.setExit(clients.getSize() + 17);
//            }else if (aux.getExit() == "S"){
//                aux.setExit(clients.getSize() + 18);
//            }else if (aux.getExit() == "T"){
//                aux.setExit(clients.getSize() + 19);
//            }else if (aux.getExit() == "U"){
//                aux.setExit(clients.getSize() + 20);
//            }else if (aux.getExit() == "V"){
//                aux.setExit(clients.getSize() + 21);
//            }else if (aux.getExit() == "W"){
//                aux.setExit(clients.getSize() + 22);
//            }else if (aux.getExit() == "X"){
//                aux.setExit(clients.getSize() + 23);
//            }else if (aux.getExit() == "Y"){
//                aux.setExit(clients.getSize() + 24);
//            }else if (aux.getExit() == "Z"){
//                aux.setExit(clients.getSize() + 25);
//            }else{
//                String routeString = String.valueOf(aux.getExit());
//                int routeInt = Integer.parseInt(routeString);
//                aux.setExit(routeInt - 1);
//            }
//            aux = aux.getNext();
//        }
//    }
    
}
