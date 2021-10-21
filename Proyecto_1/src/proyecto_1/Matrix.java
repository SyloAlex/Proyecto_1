package proyecto_1;

public class Matrix {
    
    private GraphList first;
    private GraphList last;
    private int size;
    
    public Matrix(int size){
        this.first = null;
        this.last = null;
        for (int i = 0; i < size; i++){
            GraphList newList = new GraphList(size);
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
    
    public void createPath(int posX, int posY, double num){
        GraphList aux = getFirst();
        if (posY >= size || posY < 0 || posX >= size || posX < 0){
            System.out.println("La lista no tiene la posicion indicada");
        }else{
            for (int i = 0; i < size; i++){
                if (i == posX){
                    GraphNode aux2 = aux.getFirst();
                    for (int j = 0; j < aux.getSize(); j++){
                        if (j == posY){
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
    
    public void printMatrix(){
        GraphList aux = getFirst();
        for (int i = 0; i < size; i++){
            aux.printList();
            System.out.println("");
            aux = aux.getNextList();
        }
    }
    
}
