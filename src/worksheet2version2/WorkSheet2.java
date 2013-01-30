package worksheet2version2;

import worksheet1.List;

import static worksheet1.List.cons;
import static worksheet1.List.empty;
import static worksheet1.ListOps.append;
import static worksheet1.ListOps.select;
import static worksheet2version2.TreeOps.height;


/**
 * @author Saurabh
 * @version 30/01/2013
 */


public class WorkSheet2 extends Tree {

    public static Tree negateTree(Tree tree) {
        if (tree == null)
            return null;
        else
            return new Tree(-1 * (tree.value()), negateTree(tree.left()), negateTree(tree.right()));
    }


    public static Tree mirrorImage(Tree node) {
        if (node == null)
            return null;
        else {
            return new Tree(node.value(), mirrorImage(node.right()), mirrorImage(node.left()));
        }
    }


    public static List postorder(Tree tree) {
        if (tree==null)
            return empty();
        else
            return append((append(postorder(tree.left()), postorder(tree.right()))), cons(tree.value(), empty()));
    }

    public static boolean isPositive(Tree node) {

        if (node==null)
            return true;
        else if (node.value() < 0)
            return false;
        else {
            boolean a = isPositive(node.left());
            boolean b = isPositive(node.right());

            if ((a == false || b == false))
                return false;
            else return true;
        }
    }

    public static boolean isSearchTree(Tree node) {
        return isSearchTreeWorker(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isSearchTreeWorker(Tree node, int min, int max) {
        if (node==null)
            return true;
        else if (min < node.value && node.value < max)
            return isSearchTreeWorker(node.left, min, node.value) && isSearchTreeWorker(node.right, node.value, max);
        else return false;
    }


    public static int max(Tree node) {
        assert (node!=null);
        Tree right = node.right;
        if (right == null) {
            return node.value;
        } else {
            return max(right);
        }
    }

    public static void printDescending(Tree tree) {
        if (tree==null)
            return;
        else

            printDescending(tree.right());
        System.out.print(tree.value() + " ");
        printDescending(tree.left());
    }


    public static boolean isHeightBalance(Tree node) {
        if (node==null)
            return true;
        else if (height(node.left()) - height(node.right()) <= 1
                && isHeightBalance(node.left()) && isHeightBalance(node.right()))
            return true;
        else return false;

    }


    private static Tree rotateRight(Tree root) {

        Tree newRoot = root.left;
        Tree c = root.right;
        Tree a = newRoot.left;
        Tree b = newRoot.right;
        root = new Tree(root.value, b, c);
        newRoot = new Tree(newRoot.value, a, root);
        return newRoot;
    }


    private static Tree rotateLeft(Tree root) {

        Tree newRoot = root.right();
        Tree c = root.left();
        Tree a = newRoot.left();
        Tree b = newRoot.right();

        root = new Tree(root.value(), c, a);
        newRoot = new Tree(newRoot.value(), root, b);

        return newRoot;
    }

    public static Tree rotateLeftAtChildRightAtRoot(Tree node) {

        Tree oldParentRoot = node;

        Tree oldChileRoot = oldParentRoot.left();

        oldParentRoot = new Tree(oldParentRoot.value(), rotateLeft(oldChileRoot), oldParentRoot.right());


        return rotateRight(oldParentRoot);
    }

    public static Tree rotateRightAtChildLeftAtRoot(Tree node) {
        Tree oldParentRoot = node;
        Tree oldChileRoot = oldParentRoot.right();
        oldParentRoot = new Tree(oldParentRoot.value(), oldParentRoot.left(), rotateRight(oldChileRoot));
        return rotateLeft(oldParentRoot);
    }


    public static Tree insertHB(int key, Tree tree) {

        if (tree==null)
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

    public static Tree deleteHB(int key, Tree tree) {

        if (tree==null)
            return tree;

        else if (key < tree.value()) {

            tree = new Tree(tree.value(), deleteHB(key, tree.left()), tree.right());

        } else if (key > tree.value()) {

            tree = new Tree(tree.value(), tree.left(), deleteHB(key, tree.right()));

        } else if (tree.left() != null && tree.right() != null) {

            tree = new Tree(max(tree.left), deleteHB(max(tree.left), tree.left), tree.right);

        } else {

            tree = (tree.left() != null) ? tree.left() : tree.right();
        }
        return balance(tree);
    }


    public static Tree delete(int key, Tree tree) {

        if (tree==null)
            return tree;

        else if (key < tree.value()) {

            tree = new Tree(tree.value(), delete(key, tree.left()), tree.right());

        } else if (key > tree.value()) {

            tree = new Tree(tree.value(), tree.left(), delete(key, tree.right()));

        } else if (tree.left() != null && tree.right() != null) {

            tree = new Tree(max(tree.left), delete(max(tree.left), tree.left), tree.right);

        } else {

            tree = (tree.left() != null) ? tree.left() : tree.right();
        }
        return tree;
    }


    public static Tree balance(Tree tree) {

        if (tree==null)
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


    public static Tree listToBST(List list, int x) {
        return listToBstHelper(list, 0, x - 1);
    }

    public static Tree listToBstHelper(List list, int start, int end) {

        if (start > end)
            return null;


        int mid = (end + start) / 2;

        return new Tree(select(mid, list), listToBstHelper(list, start, mid - 1), listToBstHelper(list, mid + 1, end));
    }
}

