
package proyecto_1;

public class StringMatrix {
    
    private StringGraphList first;
    private StringGraphList last;
    private int size;
    
    public StringMatrix(int size, String fill){
        this.first = null;
        this.last = null;
        for (int i = 0; i < size; i++){
            StringGraphList newList = new StringGraphList(size, fill);
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

    public StringGraphList getFirst() {
        return first;
    }

    public void setFirst(StringGraphList first) {
        this.first = first;
    }

    public StringGraphList getLast() {
        return last;
    }

    public void setLast(StringGraphList last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public StringGraphList getList(int position){
        StringGraphList aux = first;
        for (int i = 0; i < size; i++){
            if (i == position){
                return aux;
            }else{
                aux = aux.getNextList();
            }
        }
        return null;
    }
    
    public void createPath(int entrance, int exit, String word){
        StringGraphList aux = getFirst();
        if (exit >= size || exit < 0 || entrance >= size || entrance < 0){
            System.out.println("La lista no tiene la posicion indicada");
        }else{
            for (int i = 0; i < size; i++){
                if (i == entrance){
                    StringNode aux2 = aux.getFirst();
                    for (int j = 0; j < aux.getSize(); j++){
                        if (j == exit){
                            aux2.setNodeName(word);
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
    
    public void printMatrix(){
        StringGraphList aux = getFirst();
        for (int i = 0; i < size; i++){
            aux.printList();
            System.out.println("");
            aux = aux.getNextList();
        }
    }
    
}
