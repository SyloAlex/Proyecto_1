package proyecto_1;

public class OrderList {
    
    private OrderNode first;
    private OrderNode last;
    private int size;
    
    public OrderList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public OrderNode getFirst() {
        return first;
    }

    public void setFirst(OrderNode first) {
        this.first = first;
    }

    public OrderNode getLast() {
        return last;
    }

    public void setLast(OrderNode last) {
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
    
    public OrderNode getNode(int position){
        OrderNode aux = first;
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
    
    public void addEmpty(OrderNode newOrder){
        first = newOrder;
        last = newOrder;
        size = size + 1;
    }
    
    public void addFirst(OrderNode newOrder){
        if (isEmpty()){
            addEmpty(newOrder);
        }else{
            newOrder.setNext(first);
            first = newOrder;
            size = size + 1;
        }
    }
    
    public void addLast(OrderNode newOrder){
        if (isEmpty()){
            addEmpty(newOrder);
        }else{
            last.setNext(newOrder);
            last = newOrder;
            size = size + 1;
        }
    }
    
    public void addNode(OrderNode newOrder, int position){
        if (isEmpty()){
            addEmpty(newOrder);
        }else{
            if (position == 0){
                addFirst(newOrder);
            }else if(position == size){
                addLast(newOrder);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                OrderNode aux = getNode(position - 1);
                newOrder.setNext(aux.getNext());
                aux.setNext(newOrder);
                size = size + 1;
            }
        }
    }
    
    public void addPostPosition(OrderNode newOrder, int position){
        addNode(newOrder, position + 1);
    }
    
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            OrderNode aux = first.getNext();
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
                OrderNode aux = getNode(position - 1);
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
    
    public void printOrders(){
        OrderNode aux = first;
        for (int i = 0; i < size; i++){
            System.out.println("Orden #" + (i + 1));
            System.out.println("Restaurant:");
            System.out.println(aux.getOrigin());
            System.out.println("Cliente:");
            System.out.println(aux.getDestiny());
            System.out.println("Orden:");
            FoodNode aux2 = aux.getOrder().getFirst();
            for (int j = 0; j < aux.getOrder().getSize(); j++){
                System.out.println(aux2.getQuantity() + "- " + aux2.getFoodName());
                aux2 = aux2.getNext();
            }
            aux = aux.getNext();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        }
    }
    
}
