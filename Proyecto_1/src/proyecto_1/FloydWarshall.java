package proyecto_1;

public class FloydWarshall {
    
    public FloydWarshall(){
        
    }
    
    public Matrix duplicateMatrix(Matrix graph){
        Matrix floydWarshall = new Matrix(graph.getSize(), 0);
        int i, j;
        for (i = 0; i < graph.getSize(); i++){
            for (j = 0; j < graph.getSize(); j++){
                floydWarshall.getList(i).getNodeOrdered(j).setElement(
                        graph.getList(i).getNodeOrdered(j).getElement());
            }
        }
        return floydWarshall;
    }
    
    public void runFloydWarshall(Matrix graph){
        Matrix floyd = duplicateMatrix(graph);
        int i, j, k;
        for (k = 0; k < floyd.getSize(); k++){
            for (j = 0; j < floyd.getSize(); j++){
                for (i = 0; i < floyd.getSize(); i++){
                    if (floyd.getList(i).getNodeOrdered(k).getElement() + 
                            floyd.getList(k).getNodeOrdered(j).getElement() < 
                            floyd.getList(i).getNodeOrdered(j).getElement()){
                        
                        floyd.getList(i).getNode(j).setElement(
                            floyd.getList(i).getNodeOrdered(k).getElement() + 
                            floyd.getList(k).getNodeOrdered(j).getElement());
                    }
                }
            }
        }
        floyd.printMatrix();
    }
    
    public String mentalHealthKiller(Matrix graph, Matrix roads, int source, int destiny){
        int vertex = graph.getSize();
        Matrix adjMatrix = graph;
        int i, j, k;
        float temp1, temp2, temp3, temp4, minimun;
        
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
        String painKillers = String.valueOf(source);
        while(source != destiny){
            source = roads.getList(source).getNodeOrdered(destiny).getElement();
            painKillers += " - " + source;
        }
        return painKillers;
    }
    
    public String roadsR(int i, int k, StringMatrix auxRoads, 
            String traveledRoad){
        if (auxRoads.getList(i).getNode(k).getNodeName().equals("")){
            return "";
        }else{
            traveledRoad += roadsR(i, 
                    Integer.parseInt(auxRoads.getList(i).getNode(k).getNodeName()) + 1, 
                    auxRoads, traveledRoad) + 
                    (Integer.parseInt(auxRoads.getList(i).getNode(k).getNodeName()) + 1)
                    + ", ";
        }
        return traveledRoad;
    }
}
