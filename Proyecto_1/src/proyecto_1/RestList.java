package proyecto_1;

public class RestList {
    
    private RestNode first;
    private RestNode last;
    private int size;
    
    public RestList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public RestNode getFirst() {
        return first;
    }

    public void setFirst(RestNode first) {
        this.first = first;
    }

    public RestNode getLast() {
        return last;
    }

    public void setLast(RestNode last) {
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
    
    public RestNode getNode(int position){
        RestNode aux = first;
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
    
    public void addEmpty(RestNode newRest){
        first = newRest;
        last = newRest;
        size = size + 1;
    }
    
    public void addFirst(RestNode newRest){
        if (isEmpty()){
            addEmpty(newRest);
        }else{
            newRest.setNext(first);
            first = newRest;
            size = size + 1;
        }
    }
    
    public void addLast(RestNode newRest){
        if (isEmpty()){
            addEmpty(newRest);
        }else{
            last.setNext(newRest);
            last = newRest;
            size = size + 1;
        }
    }
    
    public void addNode(RestNode newRest, int position){
        if (isEmpty()){
            addEmpty(newRest);
        }else{
            if (position == 0){
                addFirst(newRest);
            }else if(position == size){
                addLast(newRest);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                RestNode aux = getNode(position - 1);
                newRest.setNext(aux.getNext());
                aux.setNext(newRest);
                size = size + 1;
            }
        }
    }
    
    public void addPostPosition(RestNode newRest, int position){
        addNode(newRest, position + 1);
    }
    
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            RestNode aux = first.getNext();
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
                RestNode aux = getNode(position - 1);
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
    
    public void printNames(){
        if (isEmpty()){
            System.out.println("No hay restaurantes en la base de datos");
        }else{
            RestNode aux = first;
            for (int i = 0; i < size; i++){
                System.out.println(aux.getRestName());
                aux = aux.getNext();
            }
        }
    }
    
    public boolean searchRestID(String id){
        RestNode aux = getFirst();
        boolean flag = false;
        for (int i = 0; i < size; i++){
            if (aux.getRestId().equals(id)){
                flag = true;
                break;
            }else{
                aux = aux.getNext();
            }
        }
        return flag;
    }
    
    public RestNode getRestaurant(String id){
        RestNode aux = getFirst();
        for (int i = 0; i < size; i++){
            if (!id.equals(aux.getRestId())){
                aux = aux.getNext();
            }else{
                return aux;
            }
        }
        return null;
    }
    
    public void printNamesMenu(){
        if (isEmpty()){
            System.out.println("No hay restaurantes en la base de datos");
        }else{
            RestNode aux = first;
            for (int i = 0; i < size; i++){
                System.out.println(aux.getRestName());
                System.out.println(aux.getRestId());
                System.out.println(">>>>>>>>>>>>>");
                FoodList aux2 = aux.getMenu();
                FoodNode aux3 = aux2.getFirst();
                for (int j = 0; j < aux2.getSize(); j++){
                    System.out.println(aux3.getFoodName());
                    aux3 = aux3.getNext();
                }
                System.out.println("-----------------");
                aux = aux.getNext();
            }
        }
    }
    
    public String restToString(){
        String result = "";
        RestNode aux = first;
        for (int i = 0; i < size; i++){
            result += "ID: " + aux.getRestId();
            result += " Nombre: " + aux.getRestName() + "\n";
            aux = aux.getNext();
        }
        return result;
    }
    
    public String foodToString(String restID){
        String result = "";
        RestNode aux = first;
        for (int i = 0; i < size; i++){
            FoodNode auxFood = aux.getMenu().getFirst();
            if (aux.getRestId().equals(restID)){
                for (int j = 0; j < aux.getMenu().getSize(); j++){
                    result += "ID: " + (j + 1);
                    result += " Plato: " + auxFood.getFoodName() + "\n";
                    auxFood = auxFood.getNext();
                }
                break;
            }else{
                aux = aux.getNext();
            }
        }
        return result;
    }
    
}
