package worksheet2;

/* This class provides sample static methods for binary search trees.
 */
public class SearchTreeOps  {
    /* Search for n in a tree t, and return the subtree whose root is n
     * If n does not occur in the tree, throw an exception.
     */
    static Tree find(int n, Tree t) {
	if (t.isEmpty())
	    throw new IllegalStateException("Value not present in search tree");
	else if (n == (Integer)t.value())
	    return t;
	else if (n < (Integer)t.value())
	    return find(n, t.left());
	else
	    return find(n, t.right());
    }

    /* Insert n into a tree t, and return the resulting tree.
     */
    static Tree insert(int n, Tree t) {
	if (t.isEmpty())
	    return new Tree(n, new Tree(0), new Tree(0));
	else if (n <=(Integer) t.value())
	    return new Tree((Integer)t.value(), insert(n, t.left()), t.right());
	else
	    return new Tree((Integer)t.value(), t.left(), insert(n, t.right()));
    }


}
