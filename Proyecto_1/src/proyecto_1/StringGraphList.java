package proyecto_1;

public class StringGraphList {
    
    private StringNode first;
    private StringNode last;
    private StringGraphList nextList;
    private int size;
    
    public  StringGraphList(int size, String fill){
        this.first = null;
        this.last = null;
        this.nextList = null;
        for (int i = 0; i < size; i++){
            StringNode newNode = new StringNode(fill);
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
    
    public StringNode getFirst(){
        return first;
    }
    
    public void setFirst(StringNode newFirst){
        this.first = newFirst;
    }
    
    public StringNode getLast(){
        return last;
    }
    
    public void setLast(StringNode newLast){
        this.first = newLast;
    }
    
    public StringGraphList getNextList(){
        return nextList;
    }
    
    public void setNextList(StringGraphList newNextList){
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
    public StringNode getNode(int position){
        StringNode aux = first;
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
    
    public StringNode getNodeOrdered(int position){
        StringNode aux = first;
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
    public void addFirst(String element){
        StringNode newNode = new StringNode(element);
        if (isEmpty()){
            addEmpty(element);
        }else{
            newNode.setNext(first);
            first = newNode;
            size = size + 1;
        }
    }
    
    public void addLast(String element){
        StringNode newNode = new StringNode(element);
        if (isEmpty()){
            addEmpty(element);
        }else{
            last.setNext(newNode);
            last = newNode;
            size = size + 1;
        }
    }
    
    public void addEmpty(String element){
        StringNode newNode = new StringNode(element);
        first = newNode;
        last = newNode;
        size = size + 1;
    }
    
    public void addNode(String element, int position){
        StringNode newNode = new StringNode(element);
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
                StringNode aux = getNodeOrdered(position - 1);
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
                size = size + 1;
            }
        }
    }
    
    public void addPostPosition(String element, int position){
        addNode(element, position + 1);
    }

    //Delete nodes in various locations
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            StringNode aux = first.getNext();
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
                StringNode aux = getNodeOrdered(position - 1);
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
        StringNode aux = first;
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            for (int i = 0; i < size; i++){
                System.out.print(aux.getNodeName());
                if (i < size - 1){
                    System.out.print("-");
                }
                aux = aux.getNext();
            }
        }
    }
    
}
