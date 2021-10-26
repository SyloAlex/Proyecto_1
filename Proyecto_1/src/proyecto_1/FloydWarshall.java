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
    
}
