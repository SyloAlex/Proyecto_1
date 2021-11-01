package proyecto_1;

/**
 * Clase que contiene la funcion para correr el algoritmo de Dijkstra
 * @author Alex
 */
public class DijkstraAlg {
    
    /**
     * Constructor de la clase Dijkstra sin parametros
     */
    public DijkstraAlg(){
        
    }
    
    /**
     * Algoritmo de Dijkstra que permite calcular el camino mas corto. Similar 
     * a una busqueda por amplitud, el algoritmo evalua todas las rutas que 
     * tienen como entrada (origen) la salida de la ruta evaluada previamente.
     * En cada iteracion se evalua cual de las rutas recorridas tiene la menor 
     * distancia acumulada y esa se evalua en la siguiente iteracion.
     * @param source {String} Vertice inicial desde el cual se quiere calcular 
     * el camino mas corto
     * @param routes {RouteList} Lista de rutas de la plataforma.
     * @param destiny {String} Vertice final desde el cual se quiere calcular el 
     * camino mas corto
     * @return {PathNode} Nodo que contiene el camino con la distancia mas corta
     */
    public PathNode runAlgorithm(String source, RouteList routes, String destiny){
        PathList pathRoutes = new PathList();
        PathNode firstPath = new PathNode(0, source);
        pathRoutes.addLast(firstPath);
        int nodePosition = 0;
        while (!pathRoutes.getNode(nodePosition).getLastNode().equals(destiny)){
            //Distancia acumulada de la ruta revisada
            int distanceNode = pathRoutes.getNode(nodePosition).getDistance();
            //Vertices visitados
            VertexList vertexes = pathRoutes.getNode(nodePosition).getVertexes();
            //Ultimo vertice visitado
            String lastNode = pathRoutes.getNode(nodePosition).getLastNode();
            RouteList newRoutes = new RouteList();
            RouteNode aux = routes.getFirst();
            //Llenar la lista de Rutas con Entrada = ultimo nodo de la 
            //ruta revisada
            for (int i = 0; i < routes.getSize(); i++){
                if (aux.getEntrance().equals(lastNode)){
                    RouteNode newRoute= new RouteNode(aux.getEntrance(), 
                            aux.getExit(), aux.getWeight());
                    newRoutes.addLast(newRoute);
                }
                aux = aux.getNext();
            }
            //Llena la lista de rutas, a partir de la ruta padre, anhadiendo las
            //nuevas distancias y ultimo nodo
            for (int i = 0; i < newRoutes.getSize(); i++){
                PathNode newPathNode = new PathNode(
                        distanceNode + newRoutes.getNode(i).getWeight(), 
                        (String)newRoutes.getNode(i).getExit(), vertexes);
                pathRoutes.addLast(newPathNode);
            }
            pathRoutes.deleteNode(nodePosition);
            nodePosition = pathRoutes.minimumDistance();
        }
        return pathRoutes.getNode(nodePosition);
    }
}
