package proyecto_1;

public class FloydWarshall {
    
    public FloydWarshall(){
        
    }
    
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
