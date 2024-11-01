public class RBNode extends BinNode{
    private RBNode parent;
    public RBNode(String data, RBNode left, RBNode right, RBNode parent){
        super( data, left, right);
        this.parent =parent;
    }
    public RBNode(String data, RBNode left, RBNode right){
        super( data, left, right);
        this.parent =null;
    }
    public RBNode(String data){
        super(data);
    }
    public RBNode getParent(){
        return this.parent;
    }
}
