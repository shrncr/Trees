class avlBinNode extends BinNode {
    private avlBinNode parent;
    public avlBinNode(String data, avlBinNode left, avlBinNode right, avlBinNode parent){
        super( data, left, right);
        this.parent =parent;
    }
    public avlBinNode(String data, avlBinNode left, avlBinNode right){
        super( data, left, right);
        this.parent =null;
    }
    public avlBinNode(String data){
        super(data);
    }
    public avlBinNode(){
        super();
    }
    public avlBinNode getParent(){
        return this.parent;
    }
    public void setParent(avlBinNode p){
        this.parent = p;
    }
    public boolean isRoot(){
        return this.parent != null;
    }
}
