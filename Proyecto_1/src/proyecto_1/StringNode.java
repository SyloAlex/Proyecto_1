package proyecto_1;

public class StringNode {
    
    private String nodeName;
    private StringNode next;
    
    public StringNode(String nodeName){
        this.nodeName = nodeName;
        this.next = null;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public StringNode getNext() {
        return next;
    }

    public void setNext(StringNode next) {
        this.next = next;
    }
    
}
