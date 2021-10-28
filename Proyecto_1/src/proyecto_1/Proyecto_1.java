package proyecto_1;

public class Proyecto_1 {

    public static void main(String[] args) {
        Functions f = new Functions();
        SamanInfo trial = f.readTXT("test\\samancito.txt");
//        f.writeTXT(trial.getRestaurants(), trial.getClients(), 
//                trial.getOrders(), trial.getRoutes(), "test\\samancito2.txt");
        DijkstraAlg dijkstra = new DijkstraAlg();
        OrderNode aux = trial.getOrders().getFirst();
        for (int i = 0; i < trial.getOrders().getSize(); i++){
            PathNode result = dijkstra.runAlgorithm(aux.getOrigin(), trial.getRoutes(), aux.getDestiny());
            System.out.println("Recorrido de la Orden #" + (i + 1));
            System.out.println(result.getDistance());
            result.printVertexes();
            System.out.println("");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>");
            aux = aux.getNext();
        }
        Matrix adjMatrix = new Matrix(trial.getRestaurants().getSize()+trial.getClients().getSize(), 
                999999999);
        Matrix roads = new Matrix(trial.getRestaurants().getSize()+trial.getClients().getSize(), 999999999);
        f.fillMatrix(adjMatrix, roads, trial.getRoutes(), trial.getClients());
        adjMatrix.fillDiagonal();
        roads.fillDiagonalRoads();
        FloydWarshall floyd = new FloydWarshall();
        OrderNode aux2 = trial.getOrders().getFirst();
        for (int i = 0; i < trial.getOrders().getSize(); i++){
            int origin = f.changeRoadStringInt(aux2.getOrigin(), trial.getClients());
            int destiny = f.changeRoadStringInt(aux2.getDestiny(), trial.getClients());
            String stringResult = floyd.runAlgorithm(adjMatrix, roads, trial.getClients(), origin, destiny);
            System.out.println("Recorrido de la Orden #" + (i + 1));
            System.out.println(stringResult);
            System.out.println("Distancia de la Orden #" + (i + 1));
            System.out.println(adjMatrix.getList(origin).getNodeOrdered(destiny).getElement());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>");
            aux2 = aux2.getNext();
        }
    }
}
