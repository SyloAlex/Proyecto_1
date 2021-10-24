package proyecto_1;

public class DijkstraListB {
    
    private DijkstraNodeB first;
    private DijkstraNodeB last;
    private int size;
    
    public DijkstraListB(int size){
        this.first = null;
        this.last = null;
        for (int i = 0; i < size; i++){
            DijkstraNodeB newNode = new DijkstraNodeB(false);
            if (first == null){
                first = newNode;
                last = newNode;
            }else{
                last.setNext(newNode);
                last = newNode;
            }
        }
        this.size = size;
    }

    public DijkstraNodeB getFirst() {
        return first;
    }

    public void setFirst(DijkstraNodeB first) {
        this.first = first;
    }

    public DijkstraNodeB getLast() {
        return last;
    }

    public void setLast(DijkstraNodeB last) {
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
    
    public DijkstraNodeB getNode(int position){
        DijkstraNodeB aux = first;
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
    
    public void addEmpty(DijkstraNodeB newNode){
        first = newNode;
        last = newNode;
        size = size + 1;
    }
    
    public void addFirst(DijkstraNodeB newNode){
        if (isEmpty()){
            addEmpty(newNode);
        }else{
            newNode.setNext(first);
            first = newNode;
            size = size + 1;
        }
    }
    
    public void addLast(DijkstraNodeB newNode){
        if (isEmpty()){
            addEmpty(newNode);
        }else{
            last.setNext(newNode);
            last = newNode;
            size = size + 1;
        }
    }
    
    public void addNode(DijkstraNodeB newNode, int position){
        if (isEmpty()){
            addEmpty(newNode);
        }else{
            if (position == 0){
                addFirst(newNode);
            }else if(position == size){
                addLast(newNode);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                DijkstraNodeB aux = getNode(position - 1);
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
                size = size + 1;
            }
        }
    }
    
    public void addPostPosition(DijkstraNodeB newNode, int position){
        addNode(newNode, position + 1);
    }
    
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            DijkstraNodeB aux = first.getNext();
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
                DijkstraNodeB aux = getNode(position - 1);
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
    
    public void printList(){
        DijkstraNodeB aux = first;
        for (int i = 0; i < size; i++){
            System.out.print(aux.getElement());
            if (i < size - 1){
                System.out.print("-");
            }
            aux = aux.getNext();
        }
    }
    
}
