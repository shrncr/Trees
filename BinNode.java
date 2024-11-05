
/*
 * Converted my BinNode class from python to java
 * Thank you chat gpt <3
 */
class BinNode {
    private String data;
    private BinNode left;
    private BinNode right;
    private BinNode parent;

    // Constructor
    public BinNode(String data, BinNode left, BinNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = null;
    }
    public BinNode(String data) {
        this(data, null, null);
    }
    public BinNode(){
        
    }
    public String getData() {
        return data;
    }
    public void setParent(BinNode p){
        this.parent = p;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BinNode getLeft() {
        return left;
    }
    public BinNode getParent(){
        return parent;
    }

    public void setLeft(BinNode left) {
        this.left = left;
    }

    // Getter and setter for right child
    public BinNode getRight() {
        return right;
    }

    public void setRight(BinNode right) {
        this.right = right;
    }

    // toString method for easy prStringing of the node
    @Override
    public String toString() {
        return String.valueOf(data);
    }

    public void setParent(avlBinNode theIssue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setParent'");
    }
}
