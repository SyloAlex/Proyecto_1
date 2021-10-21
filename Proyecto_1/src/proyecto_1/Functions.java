package proyecto_1;

public class Functions {
    
    public Functions(){
        
    }
    
    public void changeRoutesEntrance(RouteList routes, ClientsList clients){
        RouteNode aux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            if (aux.getEntrance() == "A"){
                aux.setEntrance(clients.getSize());
            }else if (aux.getEntrance() == "B"){
                aux.setEntrance(clients.getSize() + 1);
            }else if (aux.getEntrance() == "C"){
                aux.setEntrance(clients.getSize() + 2);
            }else if (aux.getEntrance() == "D"){
                aux.setEntrance(clients.getSize() + 3);
            }else if (aux.getEntrance() == "E"){
                aux.setEntrance(clients.getSize() + 4);
            }else if (aux.getEntrance() == "F"){
                aux.setEntrance(clients.getSize() + 5);
            }else if (aux.getEntrance() == "G"){
                aux.setEntrance(clients.getSize() + 6);
            }else if (aux.getEntrance() == "H"){
                aux.setEntrance(clients.getSize() + 7);
            }else if (aux.getEntrance() == "I"){
                aux.setEntrance(clients.getSize() + 8);
            }else if (aux.getEntrance() == "J"){
                aux.setEntrance(clients.getSize() + 9);
            }else if (aux.getEntrance() == "K"){
                aux.setEntrance(clients.getSize() + 10);
            }else if (aux.getEntrance() == "L"){
                aux.setEntrance(clients.getSize() + 11);
            }else if (aux.getEntrance() == "M"){
                aux.setEntrance(clients.getSize() + 12);
            }else if (aux.getEntrance() == "N"){
                aux.setEntrance(clients.getSize() + 13);
            }else if (aux.getEntrance() == "O"){
                aux.setEntrance(clients.getSize() + 14);
            }else if (aux.getEntrance() == "P"){
                aux.setEntrance(clients.getSize() + 15);
            }else if (aux.getEntrance() == "Q"){
                aux.setEntrance(clients.getSize() + 16);
            }else if (aux.getEntrance() == "R"){
                aux.setEntrance(clients.getSize() + 17);
            }else if (aux.getEntrance() == "S"){
                aux.setEntrance(clients.getSize() + 18);
            }else if (aux.getEntrance() == "T"){
                aux.setEntrance(clients.getSize() + 19);
            }else if (aux.getEntrance() == "U"){
                aux.setEntrance(clients.getSize() + 20);
            }else if (aux.getEntrance() == "V"){
                aux.setEntrance(clients.getSize() + 21);
            }else if (aux.getEntrance() == "W"){
                aux.setEntrance(clients.getSize() + 22);
            }else if (aux.getEntrance() == "X"){
                aux.setEntrance(clients.getSize() + 23);
            }else if (aux.getEntrance() == "Y"){
                aux.setEntrance(clients.getSize() + 24);
            }else if (aux.getEntrance() == "Z"){
                aux.setEntrance(clients.getSize() + 25);
            }else if (aux.getEntrance() == "1"){
                aux.setEntrance(0);
            }else if (aux.getEntrance() == "2"){
                aux.setEntrance(1);
            }else if (aux.getEntrance() == "3"){
                aux.setEntrance(2);
            }else if (aux.getEntrance() == "4"){
                aux.setEntrance(3);
            }else if (aux.getEntrance() == "5"){
                aux.setEntrance(4);
            }else if (aux.getEntrance() == "6"){
                aux.setEntrance(5);
            }else if (aux.getEntrance() == "7"){
                aux.setEntrance(6);
            }else if (aux.getEntrance() == "8"){
                aux.setEntrance(7);
            }else if (aux.getEntrance() == "9"){
                aux.setEntrance(8);
            }else if (aux.getEntrance() == "10"){
                aux.setEntrance(9);
            }else if (aux.getEntrance() == "11"){
                aux.setEntrance(10);
            }else if (aux.getEntrance() == "12"){
                aux.setEntrance(11);
            }else if (aux.getEntrance() == "13"){
                aux.setEntrance(12);
            }else if (aux.getEntrance() == "14"){
                aux.setEntrance(13);
            }else if (aux.getEntrance() == "15"){
                aux.setEntrance(14);
            }else if (aux.getEntrance() == "16"){
                aux.setEntrance(15);
            }else if (aux.getEntrance() == "17"){
                aux.setEntrance(16);
            }else if (aux.getEntrance() == "18"){
                aux.setEntrance(17);
            }else if (aux.getEntrance() == "19"){
                aux.setEntrance(18);
            }else if (aux.getEntrance() == "20"){
                aux.setEntrance(19);
            }
            aux = aux.getNext();
        }
    }
    
    public void changeRoutesExits(RouteList routes, ClientsList clients){
        RouteNode aux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            if (aux.getExit()== "A"){
                aux.setExit(clients.getSize());
            }else if (aux.getExit() == "B"){
                aux.setExit(clients.getSize() + 1);
            }else if (aux.getExit() == "C"){
                aux.setExit(clients.getSize() + 2);
            }else if (aux.getExit() == "D"){
                aux.setExit(clients.getSize() + 3);
            }else if (aux.getExit() == "E"){
                aux.setExit(clients.getSize() + 4);
            }else if (aux.getExit() == "F"){
                aux.setExit(clients.getSize() + 5);
            }else if (aux.getExit() == "G"){
                aux.setExit(clients.getSize() + 6);
            }else if (aux.getExit() == "H"){
                aux.setExit(clients.getSize() + 7);
            }else if (aux.getExit() == "I"){
                aux.setExit(clients.getSize() + 8);
            }else if (aux.getExit() == "J"){
                aux.setExit(clients.getSize() + 9);
            }else if (aux.getExit() == "K"){
                aux.setExit(clients.getSize() + 10);
            }else if (aux.getExit() == "L"){
                aux.setExit(clients.getSize() + 11);
            }else if (aux.getExit() == "M"){
                aux.setExit(clients.getSize() + 12);
            }else if (aux.getExit() == "N"){
                aux.setExit(clients.getSize() + 13);
            }else if (aux.getExit() == "O"){
                aux.setExit(clients.getSize() + 14);
            }else if (aux.getExit() == "P"){
                aux.setExit(clients.getSize() + 15);
            }else if (aux.getExit() == "Q"){
                aux.setExit(clients.getSize() + 16);
            }else if (aux.getExit() == "R"){
                aux.setExit(clients.getSize() + 17);
            }else if (aux.getExit() == "S"){
                aux.setExit(clients.getSize() + 18);
            }else if (aux.getExit() == "T"){
                aux.setExit(clients.getSize() + 19);
            }else if (aux.getExit() == "U"){
                aux.setExit(clients.getSize() + 20);
            }else if (aux.getExit() == "V"){
                aux.setExit(clients.getSize() + 21);
            }else if (aux.getExit() == "W"){
                aux.setExit(clients.getSize() + 22);
            }else if (aux.getExit() == "X"){
                aux.setExit(clients.getSize() + 23);
            }else if (aux.getExit() == "Y"){
                aux.setExit(clients.getSize() + 24);
            }else if (aux.getExit() == "Z"){
                aux.setExit(clients.getSize() + 25);
            }else if (aux.getExit() == "1"){
                aux.setExit(0);
            }else if (aux.getExit() == "2"){
                aux.setExit(1);
            }else if (aux.getExit() == "3"){
                aux.setExit(2);
            }else if (aux.getExit() == "4"){
                aux.setExit(3);
            }else if (aux.getExit() == "5"){
                aux.setExit(4);
            }else if (aux.getExit() == "6"){
                aux.setExit(5);
            }else if (aux.getExit() == "7"){
                aux.setExit(6);
            }else if (aux.getExit() == "8"){
                aux.setExit(7);
            }else if (aux.getExit() == "9"){
                aux.setExit(8);
            }else if (aux.getExit() == "10"){
                aux.setExit(9);
            }else if (aux.getExit() == "11"){
                aux.setExit(10);
            }else if (aux.getExit() == "12"){
                aux.setExit(11);
            }else if (aux.getExit() == "13"){
                aux.setExit(12);
            }else if (aux.getExit() == "14"){
                aux.setExit(13);
            }else if (aux.getExit() == "15"){
                aux.setExit(14);
            }else if (aux.getExit() == "16"){
                aux.setExit(15);
            }else if (aux.getExit() == "17"){
                aux.setExit(16);
            }else if (aux.getExit() == "18"){
                aux.setExit(17);
            }else if (aux.getExit() == "19"){
                aux.setExit(18);
            }else if (aux.getExit() == "20"){
                aux.setExit(19);
            }
            aux = aux.getNext();
        }
    }
    
    public void fillMatrix(Matrix graph, RouteList routes){
        RouteNode aux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            graph.createPath((int)aux.getEntrance(), (int)aux.getExit(), 
                    (int)aux.getWeight());
            aux = aux.getNext();
        }
    }
    
}
