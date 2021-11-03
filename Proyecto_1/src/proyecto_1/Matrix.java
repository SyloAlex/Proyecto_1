package proyecto_1;

/**
 * Lista de Listas de enteros. Clase para crear la MAtriz de Adyacencia de 
 * Floyd-Warshall
 * @author Alex
 */
public class Matrix {
    
    private GraphList first;
    private GraphList last;
    private int size;
    
    /**
     * Contructor de la clase Matrix con parametros del tamaño de la lista y el
     *  entero a rellenar los nodos.
     * @param size {int} tamaño de la lista
     * @param fill {int} entero contenido en cada nodo de las listas
     */
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

    /**
     * Getter de la primer lista del objeto
     * @return first {GraphList} primera lista del objeto
     */
    public GraphList getFirst() {
        return first;
    }

    /**
     * Setter de la primer lista del objeto
     * @param first {GraphList} primera lista del objeto
     */
    public void setFirst(GraphList first) {
        this.first = first;
    }

    /**
     * Getter de la ultima lista del objeto
     * @return last {GraphList} ultima lista del objeto
     */
    public GraphList getLast() {
        return last;
    }

    /**
     * Setter de la ultima lista del objeto
     * @param last {GraphList} ultima lista del objeto
     */
    public void setLast(GraphList last) {
        this.last = last;
    }

    /**
     * Getter del tamaño de la lista
     * @return size {int} tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Setter del tamaño de la lista
     * @param size {int} tamaño de la lista
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Metodo que permite buscar una lista en la posicion pasada por parametro
     * @param position {int} posicion en la cual se desea obtener la lista
     * @return {GraphList} lista en la posicion pasada por parametro
     */
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
    
    /**
     * Funcion que permite cambiar el elemento de un nodo de la lista, pasando 
     * como parametros la entrada y salida de una ruta, y el peso de la ruta
     * @param entrance {int} entrada de la ruta
     * @param exit {int} salida de la ruta
     * @param num {int} peso de la ruta
     */
    public void createPath(int entrance, int exit, int num){
        GraphList aux = getFirst();
        if (exit >= size || exit < 0 || entrance >= size || entrance < 0){
            aux = aux;
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
    
    /**
     * Rellena la diagonal de la matriz con el valor 0.
     */
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
    
    /**
     * Rellena la diagonal de la matriz con los valores de i/j la iteracion
     */
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
    
}
