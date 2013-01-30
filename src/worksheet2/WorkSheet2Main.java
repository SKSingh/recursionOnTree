package worksheet2;

import worksheet1.List;

import static worksheet1.List.cons;
import static worksheet1.List.empty;
import static worksheet1.ListOps.length;
import static worksheet2.TreeOps.printTree;
import static worksheet2.WorkSheet2.*;


/**
 * @author Saurabh
 * @version 30/01/2013
 */
public class WorkSheet2Main {

    public static void main(String[] args) {

        List list;

        list = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));


        Tree manual = new Tree(17, new Tree(11, new Tree(5, new Tree(), new Tree(7)), new Tree(13)), new Tree(31, new Tree(21, new Tree(), new Tree(23)),
                new Tree(40, new Tree(37), new Tree(43, new Tree(42, new Tree(41), new Tree()), new Tree(44, new Tree(), new Tree(54, new Tree(), new Tree(65)))))));

        Tree tree = listToBST(list, length(list));


        System.out.println("\n" + "Tree " + "\n");
        printTree(tree);
        System.out.println("\n" + "Tree Negated" + "\n");
        printTree(negateTree(tree));
        System.out.println("\n" + "Mirror Image" + "\n");
        printTree(mirrorImage(tree));

        System.out.println("\n" + "Maximum of first tree - " + max(tree));


        System.out.println("\n" + "isHeightBalanced firsst tree - " + isHeightBalance(tree) + "\n");

        System.out.println("\n" + "PostOrder Traversal of first tree - : " + " " + postorder(tree) + "\n");
        System.out.println("\n" + "inserted 2 into Tree ");
        Tree tree1 = insertHB(2, tree);
        printTree(tree1);

        System.out.println("\n" + "inserted 1 into previous tree ");
        Tree tree2 = insertHB(1, tree1);
        printTree(tree2);
        System.out.println("\n" + "inserted 3 into previous tree ");
        Tree tree3 = insertHB(3, tree2);

        printTree(tree3);
        System.out.println("\n" + "deleted 19 from previous tree ");
        Tree tree4 = deleteHB(19, tree3);
        printTree(tree4);
        System.out.println("\n" + "deleted 17 from previous tree ");
        Tree tree5 = deleteHB(17, tree4);
        printTree(tree5);


    }
}


