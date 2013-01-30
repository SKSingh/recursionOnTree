package worksheet2version2;

import org.junit.Test;
import worksheet1.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static worksheet1.List.cons;
import static worksheet1.List.empty;
import static worksheet1.ListOps.length;
import static worksheet1.ListOps.reverse;
import static worksheet2version2.TreeOps.inorder;
import static worksheet2version2.WorkSheet2.listToBST;
import static worksheet2version2.WorkSheet2.mirrorImage;
import static worksheet2version2.WorkSheet2.negateTree;


/**
 * @author Saurabh
 * @version 30/01/2013
 */
public class WorkSheet2version2Test {



        @Test
        public void negateTest(){
            List originalList = cons(-1, cons(7, cons(11, cons(13, cons(-17, cons(19, cons(21, cons(23, cons(31, cons(-37, cons(43, cons(47, empty()))))))))))));
            Tree original = listToBST(originalList,length(originalList));
            List expectedList = cons(1, cons(-7, cons(-11, cons(-13, cons(17, cons(-19, cons(-21, cons(-23, cons(-31, cons(37, cons(-43, cons(-47, empty()))))))))))));
            Tree expected = listToBST(expectedList,length(expectedList));

            assertTrue(expected.equals(negateTree(original)));
        }

        @Test
        public void mirrorImageTest(){
            List data =  cons(5, cons(7, cons(11, cons(13, cons(17, cons(19, cons(21, cons(23, cons(31, cons(37, cons(40, cons(43, empty()))))))))))));
            Tree actual  = mirrorImage(listToBST(data, length(data)));
            List mirrored = reverse(inorder(mirrorImage(actual)));
            Tree expected = listToBST(mirrored,length(mirrored));






            assertEquals(actual,expected);
        }
    }

