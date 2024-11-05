public class AVLTree extends BinaryTree {
    public AVLTree(avlBinNode n) {
        super(n);
    }
    public AVLTree() {
        super();
    }

    public avlBinNode rotateLeft(avlBinNode theIssue) {
        //System.out.println("jo");
        avlBinNode newRoot = (avlBinNode) theIssue.getRight();
        theIssue.setRight(newRoot.getLeft());
        newRoot.setLeft(theIssue);

        if (theIssue.getParent() != null) {
            if (theIssue == theIssue.getParent().getLeft()) {
                theIssue.getParent().setLeft(newRoot);
            } else {
                theIssue.getParent().setRight(newRoot);
            }
        }else{
            this.setRoot(newRoot);
        }
        newRoot.setParent(theIssue.getParent());
        theIssue.setParent(newRoot);

        return newRoot;
    }

    private avlBinNode rotateRight(avlBinNode theIssue){
        avlBinNode newRoot = (avlBinNode) theIssue.getLeft(); 
        
        theIssue.setLeft(newRoot.getRight());
        
        newRoot.setRight(theIssue);
    
        if (theIssue.getParent() != null) {
            if (theIssue == theIssue.getParent().getLeft()) {
                theIssue.getParent().setLeft(newRoot);
            } else {
                theIssue.getParent().setRight(newRoot);
            }
        } else {
            this.setRoot(newRoot);
        }
    
        newRoot.setParent(theIssue.getParent());
        theIssue.setParent(newRoot);
    
        return newRoot; 
    }
    
    

    private void rotateRL(avlBinNode theIssue) {
        theIssue.setRight(rotateRight((avlBinNode) theIssue.getRight()));
        rotateLeft(theIssue);
    }

    private void rotateLR(avlBinNode theIssue) {
        theIssue.setLeft(rotateLeft((avlBinNode) theIssue.getLeft()));
        rotateRight(theIssue);
    }

    private int balance(avlBinNode root) {
        if (root == null){
            return 0;
        }
        //System.out.println(root.getData());
        avlBinNode n1 = (avlBinNode) root.getLeft();
        avlBinNode n2 = (avlBinNode) root.getRight();
        int h1 = height(n1);
        int h2 = height(n2);
        //System.out.println(h1);
        //System.out.println(h2);
        return h1 - h2;
    }
    public avlBinNode remove(String what){
        avlBinNode n = (avlBinNode)(super.remove(what));
        while (n != null) {
            int balanceFactor = balance(n);

            if (balanceFactor > 1) {
                if (balance((avlBinNode) n.getLeft()) < 0) { 
                    rotateLR(n);
                } else {
                    rotateRight(n);
                    
                }
            }
            else if (balanceFactor < -1) {
                if (balance((avlBinNode) n.getRight()) > 0) {
                    rotateRL(n);
                } else {
                    rotateLeft(n);
                }
            }
            if (n.getParent() == null){
                return null;
            }
            n = n.getParent();
        }
    
        return null;

    }

    public void insert(avlBinNode n) {
        avlBinNode p = (avlBinNode) super.insert(n);  
        n.setParent(p);
        n = n.getParent();

        while (n != null) {
            int balanceFactor = balance(n);

            if (balanceFactor > 1) {
                if (balance((avlBinNode) n.getLeft()) < 0) { 
                    rotateLR(n);
                } else {
                    rotateRight(n);
                    
                }
            }
            else if (balanceFactor < -1) {
                if (balance((avlBinNode) n.getRight()) > 0) {
                    rotateRL(n);
                } else {
                    rotateLeft(n);
                }
            }
            if (n.getParent() == null){
                return;
            }
            n = n.getParent();
        }
    }
}
