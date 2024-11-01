public class AVLTree extends BinaryTree {
    // Constructor
    public AVLTree(avlBinNode n) {
        super(n);
    }
    public AVLTree() {
        super();
    }

    private avlBinNode rotateLeft(avlBinNode theIssue) {
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

    private avlBinNode rotateRight(avlBinNode theIssue) {
        //System.out.println("Performing right rotation...");
        avlBinNode newRoot = (avlBinNode) theIssue.getLeft();  // `newRoot` becomes the current left child of `theIssue`
        
        // Update the left child of `theIssue` to the right child of `newRoot`
        theIssue.setLeft(newRoot.getRight());
        
        // Set `theIssue` as the right child of `newRoot`
        newRoot.setRight(theIssue);
    
        // Adjust the parent references
        if (theIssue.getParent() != null) {
            if (theIssue == theIssue.getParent().getLeft()) {
                theIssue.getParent().setLeft(newRoot);
            } else {
                theIssue.getParent().setRight(newRoot);
            }
        } else {
            // If `theIssue` has no parent, `newRoot` becomes the new root of the AVL tree
            this.setRoot(newRoot);
        }
    
        // Update the parent pointers
        newRoot.setParent(theIssue.getParent());
        theIssue.setParent(newRoot);
    
        return newRoot;  // Return the new root after rotation
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
        avlBinNode n = (avlBinNode) super.remove(what);
        while (n != null) {
            int balanceFactor = balance(n);
            //System.out.println("balance factor currently" + balanceFactor);
            

            if (balanceFactor > 1) {
                //System.out.println(balance((avlBinNode) n.getRight()));
                if (balance((avlBinNode) n.getLeft()) < 0) { 
                    //System.out.println("we are rotating left right");
                    rotateLR(n);
                } else {
                    //System.out.println("we are rotating right");
                    rotateRight(n);
                    
                }
            }
            else if (balanceFactor < -1) {
                if (balance((avlBinNode) n.getRight()) > 0) {
                    //System.out.println("we are rotating right left");
                    rotateRL(n);
                } else {
                    //System.out.println("we are rotating left");
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
        //System.out.println("inserting: " + n);
        avlBinNode p = (avlBinNode) super.insert(n);  
        //System.out.println("node parent is: " + p);
        n.setParent(p);
        n = n.getParent();

        while (n != null) {
            int balanceFactor = balance(n);
            //System.out.println("balance factor currently" + balanceFactor);
            

            if (balanceFactor > 1) {
                //System.out.println(balance((avlBinNode) n.getRight()));
                if (balance((avlBinNode) n.getLeft()) < 0) { 
                    //System.out.println("we are rotating left right");
                    rotateLR(n);
                } else {
                    //System.out.println("we are rotating right");
                    rotateRight(n);
                    
                }
            }
            else if (balanceFactor < -1) {
                if (balance((avlBinNode) n.getRight()) > 0) {
                    //System.out.println("we are rotating right left");
                    rotateRL(n);
                } else {
                    //System.out.println("we are rotating left");
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
