package proyecto_1;

/**
 * Clase que contiene el algoritmo para correr Floyd-Warshall y obtener la 
 * distancia y el camino mas corto
 * @author Alex
 */
public class FloydWarshall {
    
    /**
     * Constructor de la clase FloydWarshall sin parametros
     */
    public FloydWarshall(){
        
    }
    
    /**
     * Funcion que modifica la Matriz de Adyacencia de enteros para obtener 
     * la distancia mas corta entre todos los vertices. En cada iteracion se 
     * evalua si la suma de los pesos de dos rutas es menor a la de una tercera 
     * ruta. De ser asi, se sobreescribe con el valor menor en la Matriz de 
     * enteros y se coloca la nueva salida en ese nodo pero de la Matriz de 
     * caminos
     * @param graph {Matrix} Matriz de adyacencia de enteros con los pesos
     * @param roads {Matrix} Matriz de adyacencia de enteros con los caminos
     * @param clients {ClientsList} Lista de clientes de la plataforma
     * @param source {int} origen desde el cual sale el camino mas corto
     * @param destiny {int} destino al cual llega el camino mas corto
     * @return orderRoute {String} cadena que contiene la ruta mas corta
     */
    public String runAlgorithm(Matrix graph, Matrix roads, ClientsList clients, int source, int destiny){
        int vertex = graph.getSize();
        Matrix adjMatrix = graph;
        int i, j, k;
        float temp1, temp2, temp3, temp4;
        
        for (k = 0; k < vertex; k++){
            for (i = 0; i < vertex; i++){
                for (j = 0; j < vertex; j++){
                    temp1 = adjMatrix.getList(i).getNodeOrdered(j).getElement();
                    temp2 = adjMatrix.getList(i).getNodeOrdered(k).getElement();
                    temp3 = adjMatrix.getList(k).getNodeOrdered(j).getElement();
                    temp4 = temp2 + temp3;
                    if (temp1 > temp4){
                        adjMatrix.createPath(i, j, (int)temp4);
                        roads.createPath(i, j, roads.getList(i).getNodeOrdered(k).getElement());
                    }
                }
            }
        }
        
        if (roads.getList(source).getNodeOrdered(destiny).getElement() > 99999){
            return null;
        }
        Functions f = new Functions();
        String orderRoute = String.valueOf(f.changeRoadIntString(source, clients));
        while(source != destiny){
            source = roads.getList(source).getNodeOrdered(destiny).getElement();
            orderRoute += "-" + String.valueOf(f.changeRoadIntString(source, clients));
        }
        return orderRoute;
    }
}
