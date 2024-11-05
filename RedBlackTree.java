public class RedBlackTree extends BinaryTree {
    public RedBlackTree(RBNode n) {
        super(n);
    }
    
    public RedBlackTree() {
        super();
    }

    public RBNode rotateLeft(RBNode theIssue) {
        RBNode newRoot = (RBNode) theIssue.getRight();
        theIssue.setRight(newRoot.getLeft());
        if (newRoot.getLeft() != null) {
            newRoot.getLeft().setParent(theIssue);
        }

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
        newRoot.setLeft(theIssue);
        theIssue.setParent(newRoot);

        return newRoot;
    }

    private RBNode rotateRight(RBNode theIssue) {
        RBNode newRoot = (RBNode) theIssue.getLeft();
        theIssue.setLeft(newRoot.getRight());
        if (newRoot.getRight() != null) {
            newRoot.getRight().setParent(theIssue);
        }

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
        newRoot.setRight(theIssue);
        theIssue.setParent(newRoot);

        return newRoot;
    }

    public void fix(RBNode n) {
        while (n.getParent() != null && n.getParent().getColor()) {
            RBNode p = n.getParent();
            RBNode grandparent = p.getParent();
            
            if (grandparent != null) {
                if (p == grandparent.getLeft()) {
                    RBNode u = (RBNode)grandparent.getRight();
                    if (u != null && u.getColor()) { 
                        p.setColor(false); 
                        u.setColor(false);
                        grandparent.setColor(true); 
                        n = grandparent; 
                    } else {
                        if (n == p.getRight()) { 
                            n = p;
                            rotateLeft(n);
                        }
                        p.setColor(false); 
                        grandparent.setColor(true); 
                        rotateRight(grandparent);
                    }
                } else { 
                    RBNode u = (RBNode)grandparent.getLeft(); 
                    if (u != null && u.getColor()) { 
                        p.setColor(false); 
                        u.setColor(false); 
                        grandparent.setColor(true);
                        n = grandparent; 
                    } else {
                        if (n == p.getLeft()) { 
                            n = p; 
                            rotateRight(n);
                        }
                        p.setColor(false);
                        grandparent.setColor(true); 
                        rotateLeft(grandparent); 
                    }
                }
            } else {
                break;
            }
        }
        ((RBNode) super.getRoot()).setColor(false);
    }

    void swapValues(RBNode u, RBNode v) {
        String temp = u.getData();
        u.setData(v.getData());
        v.setData(temp);
    }
       void deleteNode(RBNode v) {
        RBNode u = (RBNode)super.remove(v.getData());
        boolean uvBlack = ((u == null || !u.getColor()) && (!v.getColor()));
        RBNode parent = v.getParent();
 
        if (u == null) {
            if (v.getParent() == null)
                super.setRoot(null);
            else {
                if (uvBlack)
                    fixDoubleBlack(v);
                     
                else if (v.getSibling() != null)
                    v.getSibling().setColor(true);
                if (v.isOnLeft())
                    parent.setLeft(null);
                else
                    parent.setRight(null);
            }
            return;
        }
 
        if (v.getLeft() == null || v.getRight() == null) {
            if (v.getParent() == null) {
                v.setData(u.getData());
                v.setRight(null);
                v.setLeft(null);
            } else {
                if (v.isOnLeft())
                    parent.setLeft(u);
                else
                    parent.setRight(u);
 
                u.setParent(parent);
 
                if (uvBlack)
                    fixDoubleBlack(u);
                else
                    u.setColor(false); 
            }
            return;
        }
        swapValues(u, v);
        deleteNode(u);
    }
 
    void fixDoubleBlack(RBNode x) {
        if (x == super.getRoot())
            return;
 
        RBNode sibling = x.getSibling(), parent = x.getParent();
 
        if (sibling == null)
            fixDoubleBlack(parent);
        else {
            if (sibling.getColor()) {
                parent.setColor(true);
                sibling.setColor(false);
 
                if (sibling.isOnLeft())
                    rotateRight(parent);
                else
                    rotateRight(parent);
 
                fixDoubleBlack(x);
            } else {
                if (sibling.hasRedChild()) {
                    if (sibling.getLeft() != null && ((RBNode)sibling.getLeft()).getColor()) {
                        if (sibling.isOnLeft()) {
                            ((RBNode)sibling.getLeft()).setColor(sibling.getColor());
                            sibling.setColor(parent.getColor());
                            rotateRight(parent);
                        } else {
                            ((RBNode)sibling.getLeft()).setColor(parent.getColor());
                            rotateRight(sibling);
                            rotateLeft(parent);
                        }
                    } else {
                        if (sibling.isOnLeft()) {
                            ((RBNode)sibling.getRight()).setColor(parent.getColor());
                            rotateLeft(sibling);
                            rotateRight(parent);
                        } else {
                            ((RBNode)sibling.getRight()).setColor(sibling.getColor());
                            sibling.setColor(parent.getColor());
                            rotateLeft(parent);
                        }
                    }
                    parent.setColor(false);
                } else {
                    sibling.setColor(true);
                    if (!parent.getColor())
                        fixDoubleBlack(parent);
                    else
                        parent.setColor(false);
                }
            }
        }
    }

    public void insert(RBNode n) {
        RBNode p = (RBNode) super.insert(n);  
        n.setParent(p); 
        n.setColor(true); 
        fix(n); 
    }
}
