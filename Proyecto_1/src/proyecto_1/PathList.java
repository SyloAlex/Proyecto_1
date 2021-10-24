package proyecto_1;

public class PathList {
    
    private PathNode first;
    private PathNode last;
    private int size;
    
    public PathList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public PathNode getFirst() {
        return first;
    }

    public void setFirst(PathNode first) {
        this.first = first;
    }

    public PathNode getLast() {
        return last;
    }

    public void setLast(PathNode last) {
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
    
    public PathNode getNode(int position){
        PathNode aux = first;
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
    
    public void addEmpty(PathNode newPath){
        first = newPath;
        last = newPath;
        size = size + 1;
    }
    
    public void addFirst(PathNode newPath){
        if (isEmpty()){
            addEmpty(newPath);
        }else{
            newPath.setNext(first);
            first = newPath;
            size = size + 1;
        }
    }
    
    public void addLast(PathNode newPath){
        if (isEmpty()){
            addEmpty(newPath);
        }else{
            last.setNext(newPath);
            last = newPath;
            size = size + 1;
        }
    }
    
    public void addNode(PathNode newPath, int position){
        if (isEmpty()){
            addEmpty(newPath);
        }else{
            if (position == 0){
                addFirst(newPath);
            }else if(position == size){
                addLast(newPath);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                PathNode aux = getNode(position - 1);
                newPath.setNext(aux.getNext());
                aux.setNext(newPath);
                size = size + 1;
            }
        }
    }
    
    public void addPostPosition(PathNode newPath, int position){
        addNode(newPath, position + 1);
    }
    
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            PathNode aux = first.getNext();
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
                PathNode aux = getNode(position - 1);
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
    
    public int minimumDistance(){
        PathNode aux = first;
        int flag = first.getDistance();
        int position = 0;
        for (int i = 0; i < size; i++){
            if (flag > aux.getDistance()){
                flag = aux.getDistance();
                aux = aux.getNext();
                position = i;
            }else{
                aux = aux.getNext();
            }
        }
        return position;
    }
    
}
