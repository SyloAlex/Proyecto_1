package proyecto_1;

public class RouteList {
    
    private RouteNode first;
    private RouteNode last;
    private int size;
    
    public RouteList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public RouteNode getFirst() {
        return first;
    }

    public void setFirst(RouteNode first) {
        this.first = first;
    }

    public RouteNode getLast() {
        return last;
    }

    public void setLast(RouteNode last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public RouteNode getNode(int position){
        RouteNode aux = first;
        if (position >= size || position < 0){
            return null;
        }else{
            for (int i = 0; i < size; i++){
                if (i == position){
                    return aux;
                }else{
                    aux = aux.getNext();
                }
            }
        }
        return null;
    }
    
    public void addEmpty(RouteNode newRoute){
        first = newRoute;
        last = newRoute;
        size = size + 1;
    }
    
    public void addFirst(RouteNode newRoute){
        if (isEmpty()){
            addEmpty(newRoute);
        }else{
            newRoute.setNext(first);
            first = newRoute;
            size = size + 1;
        }
    }
    
    public void addLast(RouteNode newRoute){
        if (isEmpty()){
            addEmpty(newRoute);
        }else{
            last.setNext(newRoute);
            last = newRoute;
            size = size + 1;
        }
    }
    
    public void addNode(RouteNode newRoute, int position){
        if (isEmpty()){
            addEmpty(newRoute);
        }else{
            if (position == 0){
                addFirst(newRoute);
            }else if(position == size){
                addLast(newRoute);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                RouteNode aux = getNode(position - 1);
                newRoute.setNext(aux.getNext());
                aux.setNext(newRoute);
                size = size + 1;
            }
        }
    }
    
    public void addPostPosition(RouteNode newRoute, int position){
        addNode(newRoute, position + 1);
    }
    
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            RouteNode aux = first.getNext();
            first = aux;
            size = size - 1;            
        }
    }
    
    public void deleteLast(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            last = getNode(size - 1);
            last.setNext(null);
            size = size - 1;           
        }
    }
    
    public void deleteNode(int position){
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            if (position == 0){
                deleteFirst();
            }else if (position == size - 1){
                deleteLast();
            }else if (position >= size){
                System.out.println("La lista no tiene esa posicion");
            }else{
                RouteNode aux = getNode(position - 1);
                aux.setNext(aux.getNext().getNext());
                size = size - 1;
            }
        }
    }
    
    public void deletePrePosition(int position){
        deleteNode(position - 1);
    }
    
    public void deletePostPosition(int position){
        deleteNode(position + 1);
    }
    
    public boolean searchEntrance(String entrance){
        RouteNode aux = first;
        boolean flag = false;
        for (int i = 0; i < size; i++){
            if (entrance.equals(aux.getEntrance())){
                flag = true;
                break;
            }else{
                aux = aux.getNext();
            }
        }
        return flag;
    }
    
    public boolean searchExit(String exit){
        RouteNode aux = first;
        boolean flag = false;
        for (int i = 0; i < size; i++){
            if (exit.equals(aux.getExit())){
                flag = true;
                break;
            }else{
                aux = aux.getNext();
            }
        }
        return flag;
    }
    
    public void printRoutes(){
        RouteNode aux = first;
        for (int i = 0; i < size; i++){
            System.out.println("Entrada:");
            System.out.println(aux.getEntrance());
            System.out.println("Salida:");
            System.out.println(aux.getExit());
            System.out.println("Peso:");
            System.out.println(aux.getWeight());
            System.out.println("----------------------");
            aux = aux.getNext();
        }
    }
    
}
