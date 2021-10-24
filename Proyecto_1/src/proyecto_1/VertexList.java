package proyecto_1;

public class VertexList {
    
    private StringNode first;
    private StringNode last;
    private int size;
    
    public VertexList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public StringNode getFirst() {
        return first;
    }

    public void setFirst(StringNode first) {
        this.first = first;
    }

    public StringNode getLast() {
        return last;
    }

    public void setLast(StringNode last) {
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
    
    public StringNode getNode(int position){
        StringNode aux = first;
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
    
    public void addEmpty(StringNode newVertex){
        first = newVertex;
        last = newVertex;
        size = size + 1;
    }
    
    public void addFirst(StringNode newVertex){
        if (isEmpty()){
            addEmpty(newVertex);
        }else{
            newVertex.setNext(first);
            first = newVertex;
            size = size + 1;
        }
    }
    
    public void addLast(StringNode newVertex){
        if (isEmpty()){
            addEmpty(newVertex);
        }else{
            if (last == null){
                System.out.println("Me mori");
            }
            last.setNext(newVertex);
            last = newVertex;
            size = size + 1;
        }
    }
    
    public void addNode(StringNode newVertex, int position){
        if (isEmpty()){
            addEmpty(newVertex);
        }else{
            if (position == 0){
                addFirst(newVertex);
            }else if(position == size){
                addLast(newVertex);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                StringNode aux = getNode(position - 1);
                newVertex.setNext(aux.getNext());
                aux.setNext(newVertex);
                size = size + 1;
            }
        }
    }
    
    public void addPostPosition(StringNode newVertex, int position){
        addNode(newVertex, position + 1);
    }
    
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
                StringNode aux = getNode(position - 1);
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
    
}
