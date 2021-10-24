package proyecto_1;

public class GraphList {
    
    private GraphNode first;
    private GraphNode last;
    private GraphList nextList;
    private int size;
    
    public  GraphList(int size, int fill){
        this.first = null;
        this.last = null;
        this.nextList = null;
        for (int i = 0; i < size; i++){
            GraphNode newNode = new GraphNode(fill);
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
    
    public GraphNode getFirst(){
        return first;
    }
    
    public void setFirst(GraphNode newFirst){
        this.first = newFirst;
    }
    
    public GraphNode getLast(){
        return last;
    }
    
    public void setLast(GraphNode newLast){
        this.first = newLast;
    }
    
    public GraphList getNextList(){
        return nextList;
    }
    
    public void setNextList(GraphList newNextList){
        this.nextList = newNextList;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void emptyList(){
        while (isEmpty() == false){
            deleteFirst();
            if (first == last){
                first = null;
                last = null;
            }
        }
    }
    
    //Search Nodes and Indez
    public GraphNode getNode(int position){
        GraphNode aux = first;
        if (position == 0){
            return aux;
        }else{
            for (int i = 0; i < size; i++){
                if (i == position - 1){
                    return aux;
                }else{
                    aux = aux.getNext();
                }
            }
        }
        return null;
    }
    
    public GraphNode getNodeOrdered(int position){
        GraphNode aux = first;
            for (int i = 0; i < size; i++){
                if (i == position){
                    return aux;
                }else{
                    aux = aux.getNext();
                }
            }
        return null;
    }
    
    public Object getIndex(int element){
        GraphNode aux = first;
        for (int i = 0; i < size; i++){
            if (aux.getElement() == element){
                return i;
            }else{
                aux = aux.getNext();
            }
        }
        return null;
    }
    
    public boolean searchElement(int element){
        GraphNode aux = first;
        for (int i = 0; i < size; i++){
            if (aux.getElement() == element){
                return true;
            }else{
                aux = aux.getNext();
            }
        }
        return false;
    }
    
    //Adding Nodes in various positions
    public void addFirst(int element){
        GraphNode newNode = new GraphNode(element);
        if (isEmpty()){
            addEmpty(element);
        }else{
            newNode.setNext(first);
            first = newNode;
            size = size + 1;
        }
    }
    
    public void addLast(int element){
        GraphNode newNode = new GraphNode(element);
        if (isEmpty()){
            addEmpty(element);
        }else{
            last.setNext(newNode);
            last = newNode;
            size = size + 1;
        }
    }
    
    public void addEmpty(int element){
        GraphNode newNode = new GraphNode(element);
        first = newNode;
        last = newNode;
        size = size + 1;
    }
    
    public void addNode(int element, int position){
        GraphNode newNode = new GraphNode(element);
        if (isEmpty()){
            addEmpty(element);
        }else{
            if (position == 0){
                addFirst(element);
            }else if(position == size){
                addLast(element);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                GraphNode aux = getNodeOrdered(position - 1);
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
                size = size + 1;
            }
        }
    }
    
    public void addPostPosition(int element, int position){
        addNode(element, position + 1);
    }
    
    public void addOrdered(int element){
        GraphNode aux = first;
        boolean flag = false;
        if (isEmpty()){
            addFirst(element);
        }else{
            for (int i = 0; i < size; i++){
                if (aux.getElement() < element){
                    addNode(element, i);
                    flag = true;
                    break;
                }else{
                    aux = aux.getNext();
                }
            }
            if (!flag){
                addLast(element);
            }
        }
    }

    //Delete nodes in various locations
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            GraphNode aux = first.getNext();
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
                GraphNode aux = getNodeOrdered(position - 1);
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
        GraphNode aux = first;
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            for (int i = 0; i < size; i++){
                System.out.print(aux.getElement());
                if (i < size - 1){
                    System.out.print("-");
                }
                aux = aux.getNext();
            }
        }
    }
    
}
