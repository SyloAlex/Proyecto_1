package proyecto_1;

public class Dijkstra {
    
    private final int vertex;
    
    public Dijkstra(Matrix graph){
        this.vertex = graph.getSize();
    }
    
    public int minimumDistance(DijkstraListI distance, DijkstraListB shortPath){
        
        int min = Integer.MAX_VALUE; 
        int min_index = -1;
        
        for (int i = 0; i < vertex; i++){
            if (shortPath.getNode(i).getElement() == false && 
                    distance.getNode(i).getElement() <= min){
                min = distance.getNode(i).getElement();
                min_index = i;
            }
        }
        return min_index;
    }
    
    public void printSolution(DijkstraListI distance, int n){
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < vertex; i++)
            System.out.println(i + " to " + distance.getNode(i).getElement());
    }
    
    public void dijkstraAlgorithm(Matrix graph, int source){
        DijkstraListI distance = new DijkstraListI(vertex);
        DijkstraListB shortPath = new DijkstraListB(vertex);
        for (int i = 0; i < vertex; i++){
            distance.getNode(i).setElement(Integer.MAX_VALUE);
            shortPath.getNode(i).setElement(false);
        }
        distance.getNode(source).setElement(0);
        for (int count = 0; count < vertex - 1; count++){
            int u = minimumDistance(distance, shortPath);
            shortPath.getNode(u).setElement(true);
            for (int v = 0; v < vertex; v++){
                if (!shortPath.getNode(v).getElement() && 
                        graph.getList(u).getNodeOrdered(v).getElement() != 0 &&
                        distance.getNode(u).getElement() != Integer.MAX_VALUE &&
                        distance.getNode(u).getElement() + graph.getList(u).getNodeOrdered(v).getElement() < distance.getNode(v).getElement()){
                    
                    distance.getNode(v).setElement(distance.getNode(u).getElement() + graph.getList(u).getNodeOrdered(v).getElement());
                }
            }
        }
        printSolution(distance, vertex);
    }
}
