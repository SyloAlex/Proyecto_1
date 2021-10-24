package proyecto_1;

public class DijkstraAlg {
    
    public DijkstraAlg(){
        
    }
    
    public PathNode runAlgorithm(String source, RouteList routes, String destiny){
        PathList pathRoutes = new PathList();
        PathNode firstNode = new PathNode(0, source);
        pathRoutes.addLast(firstNode);
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
