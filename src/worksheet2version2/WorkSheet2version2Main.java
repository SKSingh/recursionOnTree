package worksheet2version2;

import worksheet1.List;

import static worksheet1.List.cons;
import static worksheet1.List.empty;
import static worksheet1.ListOps.length;
import static worksheet2version2.TreeOps.printTree;
import static worksheet2version2.WorkSheet2.*;


/**
 * @author Saurabh
 * @version 30/01/2013
 */
public class WorkSheet2version2Main {

    public static void main(String[] args) {

        List list;

        list = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(41, cons(43, empty()))))))))))));


        System.out.println((list));

        Tree tree = listToBST(list, length(list));

        printTree(tree);


        System.out.println("\n" + " PostOrder Traversal: " + " " + postorder(tree));

        Tree tree1 = insertHB(2, tree);
        printTree(tree1);


        Tree tree2 = insertHB(1, tree1);
        printTree(tree2);

        Tree tree3 = insertHB(0, tree2);

        printTree(tree3);

        Tree tree4 = insertHB(-1, tree3);
        printTree(tree4);

        Tree tree5 = deleteHB(-1, tree4);
        printTree(tree5);

        Tree tree6 = deleteHB(0, tree5);
        printTree(tree6);
    }
}


