package worksheet2;

import org.junit.Test;
import worksheet1.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static worksheet1.List.cons;
import static worksheet1.List.empty;
import static worksheet1.ListOps.length;
import static worksheet2.SearchTreeOps.insert;
import static worksheet2.WorkSheet2.*;

/**
 * @author Saurabh
 * @version 30/01/2013
 */
public class WorkSheet2Test {

    @Test
    public void negateTest() {
        List originalList = List.cons(-1, cons(7, cons(11, cons(13, cons(-17, cons(19, cons(21, cons(23, cons(31, cons(-37, cons(43, cons(47, empty()))))))))))));
        Tree original = listToBST(originalList, length(originalList));
        List expectedList = List.cons(1, cons(-7, cons(-11, cons(-13, cons(17, cons(-19, cons(-21, cons(-23, cons(-31, cons(37, cons(-43, cons(-47, empty()))))))))))));
        Tree expected = listToBST(expectedList, length(expectedList));

        assertTrue(expected.equals(negateTree(original)));
    }

    @Test
    public void mirrorImageTest() {

        Tree expected = new Tree(19, new Tree(31, new Tree(40, new Tree(43), new Tree(37)), new Tree(21, new Tree(23), new Tree())),
                new Tree(11, new Tree(13, new Tree(17), new Tree()), new Tree(5, new Tree(7), new Tree())));
        List list = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));
        Tree actual = mirrorImage(listToBST(list, length(list)));

        assertEquals(actual, expected);
    }

    @Test
    public void postorderTest() {

        List list = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));

        Tree tree = listToBST(list, length(list));

        List expected = cons(7, cons(5, cons(17, cons(13, cons(11, cons(23, cons(21, cons(37, cons(43, cons(40, cons(31, cons(19, empty()))))))))))));
        List actual = postorder(tree);
        assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void isPositiveTest() {

        List list1 = cons(-5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));
        Tree tree = listToBST(list1, length(list1));

        List list2 = cons(-5, cons(7, cons(11, cons(-13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(-37, cons(40, cons(43, empty()))))))))))));
        Tree tree1 = listToBST(list2, length(list2));

        List list3 = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));
        Tree tree2 = listToBST(list3, length(list3));

        assertFalse(isPositive(tree));
        assertFalse(isPositive(tree1));
        assertTrue(isPositive(tree2));

    }

    @Test
    public void isSearchTreeTest() {

        List list1 = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));
        List list2 = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(2, cons(23, cons(31, cons(37, cons(40, cons(3, empty()))))))))))));
        Tree tree1 = listToBST(list1, length(list1));
        Tree tree2 = listToBST(list2, length(list2));

        assertTrue(isSearchTree(tree1));
        assertFalse(isSearchTree(tree2));

    }

    /**
     * Since contr
     */
    @Test
    public void maxTest() {

        List list1 = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));
        Tree tree1 = listToBST(list1, length(list1));
        List list2 = cons(15, cons(17, cons(19, cons(23, cons(27, cons(29, cons(31, cons(33, cons(39, cons(47, cons(50, cons(53, empty()))))))))))));
        Tree tree2 = listToBST(list2, length(list2));

        int expected1 = 43;
        int expected2 = 53;

        assertEquals(max(tree1), expected1);
        assertEquals(max(tree2), expected2);

    }

    @Test
    public void deleteTest() {

        List list1 = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));
        Tree tree1 = listToBST(list1, length(list1));


        Tree expected = new Tree(17, new Tree(11, new Tree(5, new Tree(), new Tree(7)), new Tree(13)), new Tree(31, new Tree(21, new Tree(), new Tree(23)),
                new Tree(40, new Tree(37), new Tree(43))));
        Tree actual = delete(19, tree1);

        assertEquals(actual, expected);
    }

    @Test
    public void isHeightBalanced() {
        List list1 = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));
        Tree tree1 = listToBST(list1, length(list1));
        Tree tree2 = insert(4, tree1);
        Tree tree3 = insert(3, tree2);
        assertTrue(isHeightBalance(tree1));
        assertFalse(isHeightBalance(tree3));

    }

    @Test
    public void inerstHBTest(){
        List list1 = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));
        Tree tree1 = listToBST(list1, length(list1));
        assertTrue(isHeightBalance(tree1));

        Tree insert = insertHB(4,tree1);
        Tree insert2 = insertHB(3,insert);
        assertTrue(isHeightBalance(insert));
        assertTrue(isHeightBalance(insert2));
    }

    @Test
    public void deleteHBTest(){
        List list1 = cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));
        Tree tree1 = listToBST(list1, length(list1));
        Tree tree2 = insert(4, tree1);
        Tree tree3 = insert(3, tree2);
        assertTrue(isHeightBalance(tree1));
        assertFalse(isHeightBalance(tree3));

        Tree afterDelete = deleteHB(3,tree3);
        assertTrue(isHeightBalance(afterDelete));
    }
}
