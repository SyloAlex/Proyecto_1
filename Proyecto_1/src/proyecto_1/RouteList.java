package proyecto_1;

/**
 * Lista de las rutas entre los restaurantes y clientes de la plataforma
 * @author Alex
 */
public class RouteList {
    
    private RouteNode first;
    private RouteNode last;
    private int size;
    
    /**
     * Constructor de la clase RouteList sin parametros
     */
    public RouteList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Getter del primer nodo de la lista
     * @return first {RouteNode} primer nodo de la lista
     */
    public RouteNode getFirst() {
        return first;
    }

    /**
     * Setter del primer nodo de la lista
     * @param first {RouteNode} primer nodo de la lista
     */
    public void setFirst(RouteNode first) {
        this.first = first;
    }

    /**
     * Getter del ultimo nodo de la lista
     * @return last {RouteNode} ultimo nodo de la lista
     */
    public RouteNode getLast() {
        return last;
    }

    /**
     * Setter del ultimo nodo de la lista
     * @param last {RouteNode} ultimo nodo de la lista
     */
    public void setLast(RouteNode last) {
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
     * Verifica si la lista tiene o no elementos
     * @return {boolean} true si la lista esta vacia, false si tiene elementos
     */
    public boolean isEmpty(){
        return first == null;
    }
    
    /**
     * Busca un nodo en la lista, segun la posicion pasada por parametro
     * @param position {int} posicion del nodo a buscar
     * @return {RouteNode} nodo en la posicion buscada
     */
    public RouteNode getNode(int position){
        RouteNode aux = first;
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
    
    /**
     * Añade un nuevo {ClientNode} a la lista vacia
     * @param newRoute {ClientNode} nodo del cliente.
     */
    public void addEmpty(RouteNode newRoute){
        first = newRoute;
        last = newRoute;
        size = size + 1;
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista en la primera posicion
     * @param newRoute {ClientNode} nodo del cliente.
     */
    public void addFirst(RouteNode newRoute){
        if (isEmpty()){
            addEmpty(newRoute);
        }else{
            newRoute.setNext(first);
            first = newRoute;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {ClientNode} a la lista en la ultima posicion
     * @param newRoute {ClientNode} nodo del cliente.
     */
    public void addLast(RouteNode newRoute){
        if (isEmpty()){
            addEmpty(newRoute);
        }else{
            last.setNext(newRoute);
            last = newRoute;
            size = size + 1;
        }
    }
    
    /**
     * Añade un nuevo {RouteNode} a la lista en la posicion indicada
     * @param newRoute {RouteNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addNode(RouteNode newRoute, int position){
        if (isEmpty()){
            addEmpty(newRoute);
        }else{
            if (position == 0){
                addFirst(newRoute);
            }else if(position == size){
                addLast(newRoute);
            }else if (position > size || position < 0){
                System.out.println("La lista no llega a esa posicion");
            }else{
                RouteNode aux = getNode(position - 1);
                newRoute.setNext(aux.getNext());
                aux.setNext(newRoute);
                size = size + 1;
            }
        }
    }
    
    /**
     * Añade un nuevo {RouteNode} a la lista en la posicion posterior a la 
     * indicada
     * @param newRoute {RouteNode} nodo del cliente.
     * @param position {int} posicion en la cual se va a añadir el nodo
     */
    public void addPostPosition(RouteNode newRoute, int position){
        addNode(newRoute, position + 1);
    }
    
    /**
     * Elimina el primer nodo de la lista
     */
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            RouteNode aux = first.getNext();
            first = aux;
            size = size - 1;            
        }
    }
    
    /**
     * Elimina el ultimo nodo de la lista
     */
    public void deleteLast(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            last = getNode(size - 1);
            last.setNext(null);
            size = size - 1;           
        }
    }
    
    /**
     * Elimina el nodo en la posicion indicada por parametro
     * @param position posicion en la cual se va a eliminar el nodo
     */
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
                RouteNode aux = getNode(position - 1);
                aux.setNext(aux.getNext().getNext());
                size = size - 1;
            }
        }
    }
    
    /**
     * Elimina el nodo una posicion antes de la indicada por parametro
     * @param position posicion en la cual se va a eliminar el nodo
     */
    public void deletePrePosition(int position){
        deleteNode(position - 1);
    }
    
    /**
     * Elimina el nodo una posicion despues de la indicada por parametro
     * @param position posicion en la cual se va a eliminar el nodo
     */
    public void deletePostPosition(int position){
        deleteNode(position + 1);
    }
    
    /**
     * Funcion que verifica si la entrada pasada por parametro es una entrada
     *  que pertenece a la lista de Rutas
     * @param entrance {String} entrada de una ruta
     * @return flag {boolean} true si exite la entrada y false si no existe
     */
    public boolean searchEntrance(String entrance){
        RouteNode aux = first;
        boolean flag = false;
        for (int i = 0; i < size; i++){
            if (entrance.equals(aux.getEntrance())){
                flag = true;
                break;
            }else{
                aux = aux.getNext();
            }
        }
        return flag;
    }
    
    /**
     * Funcion que verifica si la salida pasada por parametro es una salida
     *  que pertenece a la lista de Rutas
     * @param exit {String} salida de una ruta
     * @return flag {boolean} true si exite la salida y false si no existe
     */
    public boolean searchExit(String exit){
        RouteNode aux = first;
        boolean flag = false;
        for (int i = 0; i < size; i++){
            if (exit.equals(aux.getExit())){
                flag = true;
                break;
            }else{
                aux = aux.getNext();
            }
        }
        return flag;
    }
    
    /**
     * Funcion que verifica si la ruta ya existe en la base de datos
     * @param source {String} entrada de una ruta
     * @param destiny {String} salida de una ruta
     * @return flag {boolean} true si existe la ruta y false si no existe
     */
    public boolean checkRoute(String source, String destiny){
        boolean flag = false;
        RouteNode aux = first;
        for (int i = 0; i < this.size; i++){
            if (aux.getEntrance().equals(source)){
                if (aux.getExit().equals(destiny)){
                    flag = true;
                    break;
                }else{
                    aux = aux.getNext();
                }
            }else{
                aux = aux.getNext();
            }
        }
        return flag;
    }
    
}
