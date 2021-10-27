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
    
    public String mentalHealthKiller(Matrix graph){
        int vertex = graph.getSize();
        Matrix adjMatrix = graph;
        StringMatrix roads = new StringMatrix(vertex, "");
        StringMatrix auxRoads = new StringMatrix(vertex, "");
        String traveledRoad = "", chain = "", anotherRoad = "";
        int i, j, k;
        float temp1, temp2, temp3, temp4, minimun;
        
        for (k = 0; k < vertex; k++){
            for (j = 0; j < vertex; j++){
                for (i = 0; i < vertex; i++){
                    temp1 = adjMatrix.getList(i).getNodeOrdered(j).getElement();
                    temp2 = adjMatrix.getList(i).getNodeOrdered(5).getElement();
                    temp3 = adjMatrix.getList(k).getNodeOrdered(j).getElement();
                    temp4 = temp2 + temp3;
                    minimun = Math.min(temp1, temp4);
//                    if (temp1 != temp4){
//                        if (minimun == temp4){
//                            auxRoads.getList(i).getNodeOrdered(j).setNodeName(k + "");
//                            String aux = roadsR(i, k, auxRoads, traveledRoad);
//                            roads.getList(i).getNodeOrdered(j).setNodeName(aux  + (k + 1));
//                        }
//                    }
                    adjMatrix.createPath(i, j, (int)minimun);
                }
            }
        }
        for (i = 0; i < vertex; i++){
            for (j = 0; j < vertex; j++){
                chain = chain + "[" + 
                        adjMatrix.getList(i).getNodeOrdered(j).getElement() + "]";
            }
            chain = chain + "\n";
        }
        
        for (i = 0; i < vertex; i++){
            for (j = 0; j < vertex; j++){
                if (adjMatrix.getList(i).getNodeOrdered(j).getElement() != 9999){
                    if (i != j){
                        if (roads.getList(i).getNode(j).getNodeName().equals("")){
                            anotherRoad += "De [" + (i+1) + "--->" + (j+1) + 
                                    "] irse por [" + (i+1) + ", " + (j+1) + 
                                    "]\n";
                        }else{
                            anotherRoad += "De [" + (i+1) + "--->" + (j+1) + 
                                    "] irse por [" + (i+1) + ", " + 
                                    roads.getList(i).getNode(j).getNodeName()+ 
                                    ", " + (j+1) + "]\n";
                        }
                    }
                }
            }
        }
        adjMatrix.printMatrix();
        return "La matriz es " + chain + ". Los diferentes caminos entre vertices son " 
                + anotherRoad;
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
