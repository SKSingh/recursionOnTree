package worksheet2;


import worksheet1.List;
import worksheet1.ListOps;

import java.util.*;


/**
 * provides a few utility methods and examples of how to manipulate
 * trees, including a useful print method.
 */
class TreeOps extends Tree {

    public TreeOps(int x, Tree l, Tree r) {
        super(x, l, r);
    }

    /**
     * This was done in the Lecture
     *
     * @return the height of the tree
     */
    public static int height(Tree t) {
        if (t.isEmpty())
            return 0;
        else {
            int leftHeight = height(t.left());
            int rightHeight = height(t.right());

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * Returns an entirely new tree whose elements are triple that of
     * the input Tree
     */
    public static Tree triple(Tree t) {
        if (t.isEmpty())
            return new Tree(0);
        else
            return new Tree(3 * t.value(), triple(t.left()), triple(t.right()));
    }

    /**
     * Returns a List of values obtained by visiting the Tree in in-order.
     * eg. left branch, then current root, then right branch.
     */
    public static List inorder(Tree t) {
        if (t.isEmpty())
            return List.empty();
        else {
            List leftelems = inorder(t.left());
            List rightelems = inorder(t.right());
            return ListOps.append(leftelems, List.cons(t.value(), rightelems));
        }
    }

    /**
     * source (with modifications) http://www.connorgarvey.com/blog/?p=82
     * Print a formatted representation of the given tree. The format
     * looks like this
     * <code>
     * 10
     * |
     * |- 14
     * |   |
     * |   |- 17
     * |   |
     * |   |- 13
     * |       |
     * |       | - [nil]
     * |       |
     * |       |- 12
     * |
     * |- 6
     * </code>
     * <p/>
     * Where the bottom child is the left sub tree and the top child
     * is the right sub tree.  If both the children are empty then
     * they will not be printed.  If only one child is empty then both
     * the children are printed so that it is known which is the right
     * child and which is the left child.
     *
     * @param tree The tree, which may not be null
     */
    public static void printer(Tree tree) {
        System.out.print(TreeOps.toString(tree));
    }

    public static String toString(Tree tree) {
        final StringBuilder buffer = new StringBuilder();
        return toStringTreeHelper(tree, buffer,
                new LinkedList<Iterator<Tree>>()).toString();
    }

    private static String toStringTreeDrawLines(
            java.util.List<Iterator<Tree>> parentIterators,
            boolean amLast) {
        StringBuilder result = new StringBuilder();
        Iterator<Iterator<Tree>> it = parentIterators.iterator();
        while (it.hasNext()) {
            Iterator<Tree> anIt = it.next();
            if (anIt.hasNext() || (!it.hasNext() && amLast)) {
                result.append("   |");
            } else {
                result.append("    ");
            }
        }
        return result.toString();
    }

    private static StringBuilder toStringTreeHelper(
            Tree t, StringBuilder buffer,
            java.util.List<Iterator<Tree>> parentIterators) {

        if (!parentIterators.isEmpty()) {
            boolean amLast =
                    !parentIterators.get(parentIterators.size() - 1).hasNext();
            String lines = toStringTreeDrawLines(parentIterators, amLast);
            buffer.append("\n").append(lines).append("\n").
                    append(lines).append("- ");
        }

        if (t.isEmpty()) {
            buffer.append("empty");
            return buffer;
        } else
            buffer.append(t.value());

        if (!(t.left().isEmpty() && t.right.isEmpty())) {
            Iterator<Tree> it = getChildrenIterator(t);
            parentIterators.add(it);
            while (it.hasNext()) {
                Tree child = it.next();
                toStringTreeHelper(child, buffer, parentIterators);
            }
            parentIterators.remove(it);
        }
        return buffer;
    }

    private static Iterator<Tree> getChildrenIterator(Tree t) {
        if (t.isEmpty())
            return Collections.<Tree>emptyList().iterator();
        else
            return Arrays.asList(new Tree[]{
                    t.right(),
                    t.left()}).iterator();
    }


    public static void printTree(Tree root) {

        Stack globalStack = new Stack();

        globalStack.push(root);

        int nBlanks = 32;

        boolean isRowEmpty = false;

        System.out.println("\n");

        while (isRowEmpty == false) {

            Stack localStack = new Stack();

            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {

                Tree temp = (Tree) globalStack.pop();

                if (temp != null) {

                    System.out.print(temp.value);
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if (temp.left != null || temp.right != null)

                        isRowEmpty = false;

                } else {

                    System.out.print("- -");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }

            System.out.println("");
            nBlanks /= 2;

            while (localStack.isEmpty() == false)

                globalStack.push(localStack.pop());
        }
    }


}
