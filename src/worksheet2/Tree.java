package worksheet2;


/**
 * Tree class defines a recursive type called Tree, and provides
 * constructor and accessor methods.
 */
public class Tree {

    protected final boolean empty;
    protected final int value;
    protected final Tree left, right;




    /**
     * Creates an empty tree
     */
    public Tree() {

        empty = true;
        value =0;
        left=null;
        right=null;
    }

    /**
     * Creates a new Tree whose root value is x and left and right
     * subtrees are r and l 
     */
    public Tree(int x, Tree l, Tree r) {

        empty = false; value = x; left = l; right = r;
    }
    

    
    public Tree(int x) {

        empty = false; value = x; left = new Tree(); right = new Tree();
    }
    
    /**
     * returns true if this tree is empty (eg nil)
     */
    public boolean isEmpty() {
        return empty;
    }
    
    /**
     * gets the root value of this tree
     */
    public int value() {
        if (isEmpty()) {
            throw new IllegalStateException(
                          "Trying to access root of an empty tree");
        }
        return value;
    }
    
    /**
     * gets the left subtree of this node
     */
    public Tree left() {
        if (isEmpty()) {
            throw new IllegalStateException(
                          "Trying to access subtree of an empty tree");
        }
        return left;
    }
    
    /**
     * gets the right subtree of this node
     */
    public Tree right() {
        if (isEmpty()) {
            throw new IllegalStateException(
                         "Trying to access subtree of an empty tree");
        }
        return right;
    }
    
    /**
     * Creates a multi-line String that represents this Tree. The
     * format looks like this  
<code>
10
   |
   |- 14
   |   |
   |   |- 17
   |   |
   |   |- 13
   |       |
   |       | - [nil]
   |       |
   |       |- 12
   |
   |- 6
</code>
     * Where the bottom child is the left sub tree and the top child
     * is the right sub tree.  If both children are nil or the empty
     * tree then they will not be printed. If only one child is nil
     * then both children are printed to so it can be known which was
     * the right child and which was the left child.
     *
     * @return A string containing the formatted tree
     */
    @Override public String toString() {
        return TreeOps.toString(this);
    }

    @Override public boolean equals(Object o) {
	Tree t = (Tree) o;
	if (empty)
	    return t.empty;
	else
	    return !t.empty && value == t.value &&
		   left.equals(t.left) && right.equals(t.right);
    }
}
