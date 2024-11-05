public class RBNode extends BinNode{
    private RBNode parent;
    private boolean isRed = true;
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
    public void setParent(RBNode n){
        this.parent = n;
    }
    public void setColor(boolean isR){
        this.isRed = isR;
    }
    public boolean getColor(){
        return(this.isRed);
    }
    public boolean isOnLeft(){
        return this.parent.getLeft() == this;
    }
    public boolean isOnRight(){
        return this.parent.getRight() == this;
    }
    boolean hasRedChild() {
        return (this.getLeft() != null && ((RBNode)this.getLeft()).getColor()) ||
                (this.getRight() != null && ((RBNode)this.getRight()).getColor());
    }
    public RBNode getSibling(){
        if (this.parent.getLeft() != null && this.parent.getRight() != null){
            if (this.parent.getLeft() == this){
                return (RBNode)this.parent.getRight();
            }else{
                return (RBNode)this.parent.getLeft();
            }
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + this.getColor();
    }

}
