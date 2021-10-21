package proyecto_1;

public class Functions {
    
    public Functions(){
        
    }
    
    public void changeRoutesEntrance(RouteList routes){
        RouteNode aux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            if (aux.getEntrance() == "A"){
                aux.setEntrance(7);
            }else if (aux.getEntrance() == "B"){
                aux.setEntrance(8);
            }else if (aux.getEntrance() == "C"){
                aux.setEntrance(9);
            }else if (aux.getEntrance() == "D"){
                aux.setEntrance(10);
            }else if (aux.getEntrance() == "E"){
                aux.setEntrance(11);
            }else if (aux.getEntrance() == "F"){
                aux.setEntrance(12);
            }else if (aux.getEntrance() == "G"){
                aux.setEntrance(13);
            }else if (aux.getEntrance() == "H"){
                aux.setEntrance(14);
            }else if (aux.getEntrance() == "I"){
                aux.setEntrance(15);
            }else if (aux.getEntrance() == "J"){
                aux.setEntrance(16);
            }else if (aux.getEntrance() == "K"){
                aux.setEntrance(17);
            }else if (aux.getEntrance() == "L"){
                aux.setEntrance(18);
            }else if (aux.getEntrance() == "M"){
                aux.setEntrance(19);
            }else if (aux.getEntrance() == "N"){
                aux.setEntrance(20);
            }else if (aux.getEntrance() == "O"){
                aux.setEntrance(21);
            }else if (aux.getEntrance() == "P"){
                aux.setEntrance(22);
            }else if (aux.getEntrance() == "Q"){
                aux.setEntrance(23);
            }else if (aux.getEntrance() == "R"){
                aux.setEntrance(24);
            }else if (aux.getEntrance() == "S"){
                aux.setEntrance(25);
            }else if (aux.getEntrance() == "T"){
                aux.setEntrance(26);
            }else if (aux.getEntrance() == "U"){
                aux.setEntrance(27);
            }else if (aux.getEntrance() == "V"){
                aux.setEntrance(28);
            }else if (aux.getEntrance() == "W"){
                aux.setEntrance(29);
            }else if (aux.getEntrance() == "X"){
                aux.setEntrance(30);
            }else if (aux.getEntrance() == "Y"){
                aux.setEntrance(31);
            }else if (aux.getEntrance() == "Z"){
                aux.setEntrance(32);
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
            }
            aux = aux.getNext();
        }
    }
    
    public void changeRoutesExits(RouteList routes){
        RouteNode aux = routes.getFirst();
        for (int i = 0; i < routes.getSize(); i++){
            if (aux.getExit()== "A"){
                aux.setExit(7);
            }else if (aux.getExit() == "B"){
                aux.setExit(8);
            }else if (aux.getExit() == "C"){
                aux.setExit(9);
            }else if (aux.getExit() == "D"){
                aux.setExit(10);
            }else if (aux.getExit() == "E"){
                aux.setExit(11);
            }else if (aux.getExit() == "F"){
                aux.setExit(12);
            }else if (aux.getExit() == "G"){
                aux.setExit(13);
            }else if (aux.getExit() == "H"){
                aux.setExit(14);
            }else if (aux.getExit() == "I"){
                aux.setExit(15);
            }else if (aux.getExit() == "J"){
                aux.setExit(16);
            }else if (aux.getExit() == "K"){
                aux.setExit(17);
            }else if (aux.getExit() == "L"){
                aux.setExit(18);
            }else if (aux.getExit() == "M"){
                aux.setExit(19);
            }else if (aux.getExit() == "N"){
                aux.setExit(20);
            }else if (aux.getExit() == "O"){
                aux.setExit(21);
            }else if (aux.getExit() == "P"){
                aux.setExit(22);
            }else if (aux.getExit() == "Q"){
                aux.setExit(23);
            }else if (aux.getExit() == "R"){
                aux.setExit(24);
            }else if (aux.getExit() == "S"){
                aux.setExit(25);
            }else if (aux.getExit() == "T"){
                aux.setExit(26);
            }else if (aux.getExit() == "U"){
                aux.setExit(27);
            }else if (aux.getExit() == "V"){
                aux.setExit(28);
            }else if (aux.getExit() == "W"){
                aux.setExit(29);
            }else if (aux.getExit() == "X"){
                aux.setExit(30);
            }else if (aux.getExit() == "Y"){
                aux.setExit(31);
            }else if (aux.getExit() == "Z"){
                aux.setExit(32);
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
