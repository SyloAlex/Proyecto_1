package proyecto_1;

public class Matrix {
    
    private GraphList first;
    private GraphList last;
    private int size;
    
    public Matrix(int size, int fill){
        this.first = null;
        this.last = null;
        for (int i = 0; i < size; i++){
            GraphList newList = new GraphList(size, fill);
            if (first == null){
                first = newList;
                last = newList;
            }else{
                last.setNextList(newList);
                last = newList;
            }
        }
        this.size = size;
    }

    public GraphList getFirst() {
        return first;
    }

    public void setFirst(GraphList first) {
        this.first = first;
    }

    public GraphList getLast() {
        return last;
    }

    public void setLast(GraphList last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public GraphList getList(int position){
        GraphList aux = first;
        for (int i = 0; i < size; i++){
            if (i == position){
                return aux;
            }else{
                aux = aux.getNextList();
            }
        }
        return null;
    }
    
    public void createPath(int entrance, int exit, int num){
        GraphList aux = getFirst();
        if (exit >= size || exit < 0 || entrance >= size || entrance < 0){
            System.out.println("La lista no tiene la posicion indicada");
        }else{
            for (int i = 0; i < size; i++){
                if (i == entrance){
                    GraphNode aux2 = aux.getFirst();
                    for (int j = 0; j < aux.getSize(); j++){
                        if (j == exit){
                            aux2.setElement(num);
                        }else{
                            aux2 = aux2.getNext();
                        }
                    }
                }else{
                    aux = aux.getNextList();
                }
            }
        }
    }
    
    public void fillDiagonal(){
        GraphList aux = getFirst();
        for (int i = 0; i < size; i++){
            GraphNode aux2 = aux.getFirst();
            for (int j = 0; j < aux.getSize(); j++){
                if (j == i){
                    aux2.setElement(0);
                }else{
                    aux2 = aux2.getNext();
                }
            }
            aux = aux.getNextList();
        }
    }
    
    public void fillDiagonalRoads(){
        GraphList aux = getFirst();
        for (int i = 0; i < size; i++){
            GraphNode aux2 = aux.getFirst();
            for (int j = 0; j < aux.getSize(); j++){
                if (j == i){
                    aux2.setElement(i);
                }else{
                    aux2 = aux2.getNext();
                }
            }
            aux = aux.getNextList();
        }
    }
    
    public void printMatrix(){
        GraphList aux = getFirst();
        for (int i = 0; i < size; i++){
            aux.printList();
            System.out.println("");
            aux = aux.getNextList();
        }
    }
    
}
