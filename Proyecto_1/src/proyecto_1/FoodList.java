package proyecto_1;

public class FoodList {
    
    private FoodNode first;
    private FoodNode last;
    private int size;
    
    public FoodList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public FoodNode getFirst() {
        return first;
    }

    public void setFirst(FoodNode first) {
        this.first = first;
    }

    public FoodNode getLast() {
        return last;
    }

    public void setLast(FoodNode last) {
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
    
    public FoodNode getNode(int position){
        FoodNode aux = first;
            for (int i = 0; i < size; i++){
                if (i == position){
                    return aux;
                }else{
                    aux = aux.getNext();
                }
            }
        return null;
    }
    
    //Adding Nodes in various positions
    public void addFirst(FoodNode food){
        if (isEmpty()){
            addEmpty(food);
        }else{
            food.setNext(first);
            first = food;
            size = size + 1;
        }
    }
    
    public void addLast(FoodNode food){
        if (isEmpty()){
            addEmpty(food);
        }else{
            last.setNext(food);
            last = food;
            size = size + 1;
        }
    }
    
    public void addEmpty(FoodNode food){
        first = food;
        last = food;
        size = size + 1;
    }
    
    public void addNode(FoodNode food, int position){
        if (isEmpty()){
            addEmpty(food);
        }else{
            if (position == 0){
                addFirst(food);
            }else if(position == size){
                addLast(food);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                FoodNode aux = getNode(position - 1);
                food.setNext(aux.getNext());
                aux.setNext(food);
                size = size + 1;
            }
        }
    }
    
    public void addPostPosition(FoodNode food, int position){
        addNode(food, position + 1);
    }
    
    //Delete nodes in various locations
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            FoodNode aux = first.getNext();
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
                FoodNode aux = getNode(position - 1);
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
    
    //Print all nodes
    public void printList(){
        FoodNode aux = first;
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            for (int i = 0; i < size; i++){
                System.out.print(aux.getFoodName());
                aux = aux.getNext();
            }
        }
    }
}
