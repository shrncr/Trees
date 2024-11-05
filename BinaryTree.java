
/*
 * Converted my BST class from python to java
 * Thank you chat gpt <3
 */
class BinaryTree {
    private BinNode root;
    private BinNode curr;

    public BinaryTree(BinNode r) {
        this.root = r;
        this.curr = r;
    }

    public BinaryTree() {
        this(null);
    }

    public BinNode getRoot() {
        return root;
    }

    public void setRoot(BinNode root) {
        this.root = root;
    }

    public BinNode getCurr() {
        return curr;
    }

    public void setCurr(BinNode curr) {
        this.curr = curr;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isLeaf() {
        return curr != null && curr.getLeft() == null && curr.getRight() == null;
    }

    public int height(BinNode n) {
        if (n == null) return -1; // Update height to -1 for consistency
        int lheight = height(n.getLeft());
        int rheight = height(n.getRight());
        return Math.max(lheight, rheight) + 1;
    }

    public String getMin() {
        goRoot();
        while (curr != null && curr.getLeft() != null) {
            goLeft();
        }
        return curr != null ? curr.getData() : null;
    }

    public String getMax() {
        goRoot();
        while (curr != null && curr.getRight() != null) {
            goRight();
        }
        return curr != null ? curr.getData() : null;
    }

    public void goRoot() {
        curr = root;
    }

    public void goLeft() {
        if (curr != null) curr = curr.getLeft();
    }

    public void goRight() {
        if (curr != null) curr = curr.getRight();
    }


    public BinNode insert(BinNode n) {
        if (isEmpty()) {
            root = n;
            curr = n;
            return null;  // Root has no parent
        } else {
            return insertNode(root, n, null);  // Start with root and no parent
        }
    }
    
    private BinNode insertNode(BinNode here, BinNode n, BinNode parent) {
        if (here == null) {
            n.setParent(parent);
            if (parent != null) {
                if (n.getData().compareTo(parent.getData()) < 0) {
                    parent.setLeft(n);
                } else {
                    parent.setRight(n);
                }
            }
            return parent;  // Return the parent of the inserted node
        }
    
        if (n.getData().compareTo(here.getData()) < 0) {
            return insertNode(here.getLeft(), n, here);
        } else {
            return insertNode(here.getRight(), n, here);
        }
    }

    public int getSize() {
        return count(root);
    }

    private int count(BinNode n) {
        if (n == null) return 0;
        return 1 + count(n.getLeft()) + count(n.getRight());
    }

    public BinNode search(String what) {
        curr = findIt(root, what);
        return curr;
    }

    private BinNode findIt(BinNode n, String what) {
        if (n == null) return null;
        if (n.getData().equals(what)) return n;
        return what.compareTo(n.getData()) < 0 ? findIt(n.getLeft(), what) : findIt(n.getRight(), what);
    }

    public void traverseInOrder() {
        inOrder(root);
    }

    private void inOrder(BinNode n) {
        if (n != null) {
            inOrder(n.getLeft());
            //System.out.println(n.getData());
            inOrder(n.getRight());
        }
    }

    public void traversePreOrder() {
        preOrder(root);
    }

    private void preOrder(BinNode n) {
        if (n != null) {
            //System.out.println(n.getData());
            preOrder(n.getLeft());
            preOrder(n.getRight());
        }
    }

    public void traversePostOrder() {
        postOrder(root);
    }

    private void postOrder(BinNode n) {
        if (n != null) {
            postOrder(n.getLeft());
            postOrder(n.getRight());
            //System.out.println(n.getData());
        }
    }

    public BinNode remove(String what) {
        root = deleteNode(root, what);
        //System.out.println(root);
        return root;
    }

    private BinNode deleteNode(BinNode node, String data) {
        if (node == null) return null;

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(deleteNode(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(deleteNode(node.getRight(), data));
        } else {
            // Node with only one child or no child
            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();

            // Node with two children, get the inorder successor
            node.setData(minValue(node.getRight()));
            node.setRight(deleteNode(node.getRight(), node.getData()));
        }
        return node;
    }

    private String minValue(BinNode node) {
        String minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        int h = height(root) + 1;
        int col = getCol(h);
        String[][] M = new String[h][col];
        printTree(M, root, col / 2, 0, h);
        for (String[] row : M) {
            for (String cell : row) {
                out.append(cell == null ? " " : cell).append(" ");
            }
            out.append("\n");
        }
        return out.toString();
    }

    private void printTree(String[][] M, BinNode root, int col, int row, int height) {
        if (root == null || row >= height) return;
        M[row][col] = root.toString();
        int gap = (int) Math.pow(2, height - row - 2);
        printTree(M, root.getLeft(), col - gap, row + 1, height);
        printTree(M, root.getRight(), col + gap, row + 1, height);
    }

    private int getCol(int h) {
        return (1 << h) - 1;
    }
}
