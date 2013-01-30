package worksheet2;

import worksheet1.List;

import static worksheet1.List.cons;
import static worksheet1.List.empty;
import static worksheet1.ListOps.append;
import static worksheet1.ListOps.select;
import static worksheet2.TreeOps.height;


/**
 * @author Saurabh
 * @version 30/01/2013
 */


public class WorkSheet2 extends Tree {

    /**
     * @param tree The tree to be negated
     * @return negated tree
     */
    public static Tree negateTree(Tree tree) {
        if (tree.isEmpty())
           return tree;
        else
            return new Tree(-1 * (tree.value()), negateTree(tree.left()), negateTree(tree.right()));
    }

    /**
     * @param node The tree to be rotated
     * @return The rotated tree
     */
    public static Tree mirrorImage(Tree node) {
        if (node.isEmpty())
            return node;
        else {
            return new Tree(node.value(), mirrorImage(node.right()), mirrorImage(node.left()));
        }
    }

    /**
     * @param tree The tree to be traversed in post-order manner
     * @return The List of elements in post-order manner
     */
    public static List postorder(Tree tree) {
        if (tree.isEmpty())
            return empty();
        else
            return append((append(postorder(tree.left()), postorder(tree.right()))), cons(tree.value(), empty()));
    }

    /**
     * @param node The tree to be checked for positiveness
     * @return boolean true indicates all elements are positive
     */
    public static boolean isPositive(Tree node) {

        if (node.isEmpty())
            return true;
        if (node.value() < 0)
            return false;
        else {

            return isPositive(node.left()) && isPositive(node.right());
        }
    }

    /**
     * @param tree The tree to be verified whether it is search tree
     * @return boolean
     */
    public static boolean isSearchTree(Tree tree) {
        return isSearchTreeWorker(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Java int: int is 32 bit signed type ranges from –2,147,483,648 to 2,147,483,647.
     *
     * @param tree The tree to be checked
     * @param min  minimum integer value
     * @param max  maximum integer value
     * @return
     */
    public static boolean isSearchTreeWorker(Tree tree, int min, int max) {
        if (tree.isEmpty())
            return true;
        else if (min < tree.value && tree.value < max)
            return isSearchTreeWorker(tree.left, min, tree.value) && isSearchTreeWorker(tree.right, tree.value, max);
        else return false;
    }

    /**
     * Method print all the elements in the tree in descending order
     *
     * @param tree The tree to be printed
     */
    public static void printDescending(Tree tree) {
        if (tree.isEmpty())
            return;
        else

            printDescending(tree.right());
        System.out.print(tree.value() + " ");
        printDescending(tree.left());
    }

    /**
     * Method to find the largest value in search tree
     * which is right most element in the tree
     *
     * @param node The tree to be search
     * @return maximum value
     */
    public static int max(Tree node) {

        Tree right = node.right;
        if (right.isEmpty()) {
            return node.value;
        } else {
            return max(right);
        }
    }

    /**
     * Removes the specified data element from search tree, if the element is
     * present.
     *
     * @param key  The element to be removed.
     * @param tree The tree key to be removed from.
     * @return Tree after removal is performed.
     */
    public static Tree delete(int key, Tree tree) {

        if (tree.isEmpty())
            return tree;

        else if (key < tree.value()) {

            tree = new Tree(tree.value(), delete(key, tree.left()), tree.right());

        } else if (key > tree.value()) {

            tree = new Tree(tree.value(), tree.left(), delete(key, tree.right()));

        } else if (!tree.left().isEmpty() && !tree.right().isEmpty()) {

            tree = new Tree(max(tree.left), delete(max(tree.left), tree.left), tree.right);

        } else {

            tree = (!tree.left().isEmpty()) ? tree.left() : tree.right();
        }
        return tree;
    }

    /**
     * Recursive method to perform height balance check
     *
     * @param node The node to tested
     * @return boolean
     */
    public static boolean isHeightBalance(Tree node) {
        if (node.isEmpty())
            return true;
        else if (height(node.left()) - height(node.right()) <= 1
                && isHeightBalance(node.left()) && isHeightBalance(node.right()))
            return true;
        else return false;

    }

    /**
     * Rotates a node with its left child.
     *
     * @param root The root of the subtree with which to rotate the node's left
     *             child.
     * @return The node that is the new root of the specified root's subtree.
     */
    private static Tree rotateRight(Tree root) {

        Tree newRoot = root.left;
        Tree c = root.right;
        Tree a = newRoot.left;
        Tree b = newRoot.right;
        root = new Tree(root.value, b, c);
        newRoot = new Tree(newRoot.value, a, root);
        return newRoot;
    }

    /**
     * Rotates a node with its right child.
     *
     * @param root The root of the subtree with which to rotate the node's right
     *             child.
     * @return The node that is the new root of the specified root's subtree.
     */
    private static Tree rotateLeft(Tree root) {

        Tree newRoot = root.right();
        Tree c = root.left();
        Tree a = newRoot.left();
        Tree b = newRoot.right();

        root = new Tree(root.value(), c, a);
        newRoot = new Tree(newRoot.value(), root, b);

        return newRoot;
    }

    /**
     * Double rotates a node with its left child.
     *
     * @param root The root of the subtree with which to double rotate the node's
     *             left child.
     * @return The node that is the new root of the specified root's subtree.
     */
    public static Tree rotateLeftAtChildRightAtRoot(Tree root) {

        Tree parentRoot = root;

        Tree chileRoot = parentRoot.left();

        parentRoot = new Tree(parentRoot.value(), rotateLeft(chileRoot), parentRoot.right());


        return rotateRight(parentRoot);
    }

    /**
     * Double rotates a node with its right child.
     *
     * @param root The root of the subtree with which to double rotate the node's
     *             right child.
     * @return The node that is the new root of the specified root's subtree.
     */

    public static Tree rotateRightAtChildLeftAtRoot(Tree root) {
        Tree parentRoot = root;
        Tree chileRoot = parentRoot.right();
        parentRoot = new Tree(parentRoot.value(), parentRoot.left(), rotateRight(chileRoot));
        return rotateLeft(parentRoot);
    }

    /**
     * Recursive method for inserting the specified data element into the
     * AVL tree, if the element is not already present.
     *
     * @param tree The AVL tree in  which to insert the element.
     * @param key  The element to be inserted.
     * @return The new AVL tree.
     */
    public static Tree insertHB(int key, Tree tree) {

        if (tree.isEmpty())
            tree = new Tree(key);

        else if (key < tree.value()) {

            tree = new Tree(tree.value(), insertHB(key, tree.left()), tree.right());


        } else if (key > tree.value()) {

            tree = new Tree(tree.value(), tree.left(), insertHB(key, tree.right()));


        } else {
            throw new IllegalStateException("Key already present in tree");
        }
        return balance(tree);
    }

    /**
     * Recursive method for removing the specified data element from the
     * AVL tree, if the element is present.
     *
     * @param tree The AVL tree from which to remove the element.
     * @param key  The element to be removed.
     * @return The new AVL tree.
     */
    public static Tree deleteHB(int key, Tree tree) {

        if (tree.isEmpty())
            return tree;

        else if (key < tree.value()) {

            tree = new Tree(tree.value(), deleteHB(key, tree.left()), tree.right());

        } else if (key > tree.value()) {

            tree = new Tree(tree.value(), tree.left(), deleteHB(key, tree.right()));

        } else if (!tree.left().isEmpty() && !tree.right().isEmpty()) {

            tree = new Tree(max(tree.left), deleteHB(max(tree.left), tree.left), tree.right);

        } else {

            tree = (!tree.left().isEmpty()) ? tree.left() : tree.right();
        }
        return balance(tree);
    }

    /**
     * @param tree The unbalance tree
     * @return The height balanced tree
     */
    public static Tree balance(Tree tree) {

        if (tree.isEmpty())
            return tree;

        if (height(tree.left()) - height(tree.right()) == 2) {

            if (height(tree.left().left()) >= height(tree.left().right())) {

                tree = rotateRight(tree);

            } else {

                tree = rotateLeftAtChildRightAtRoot(tree);
            }
        }

        if (height(tree.right()) - height(tree.left()) == 2) {

            if (height(tree.right().right()) >= height(tree.right().left())) {

                tree = rotateLeft(tree);

            } else {

                tree = rotateRightAtChildLeftAtRoot(tree);
            }
        }

        return tree;
    }

    /**
     * Utility  to convert sorted list into binary search tree
     *
     * @param list sorted list
     * @param x    length of list
     * @return Search tree
     */
    public static Tree listToBST(List list, int x) {
        return listToBstHelper(list, 0, x - 1);
    }

    /**
     * Helper method for listToBST it takes start and end position in the list which one wants to convert
     * into binary search tree
     *
     * @param list  sorted list
     * @param start start position
     * @param end   end position
     * @return The binary search tree
     */
    public static Tree listToBstHelper(List list, int start, int end) {

        if (start > end)
            return new Tree();


        int mid = (end + start) / 2;

        return new Tree(select(mid, list), listToBstHelper(list, start, mid - 1), listToBstHelper(list, mid + 1, end));
    }
}