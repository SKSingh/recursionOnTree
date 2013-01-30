package worksheet1;

import static worksheet1.ListOps.append;

/**
 * @author Saurabh
 * @version 30/01/2013
 */


public class ListOperations extends List {


    public static int length(List l) {
        if (l.isEmpty())
            return 0;
        else
            return 1 + length(l.tail());
    }


    public static void countTo(int counter, int limit) {
        if (counter < limit) {
            System.out.print(counter + "\n");
            countTo(counter + 1, limit);
        }
    }


    public static List rightPart(int pivot, List l) {

        if (l.isEmpty())

            return empty();
        else if (l.head() > pivot) {
            return cons(l.head(), rightPart(pivot, l.tail()));
        } else

            return rightPart(pivot, l.tail());

    }


    public static List leftPart(int pivot, List l) {
        if (l.isEmpty())
            return empty();
        else if (l.head() <= pivot) {

            return cons(l.head(), leftPart(pivot, l.tail()));
        } else
            return leftPart(pivot, l.tail());
    }


    public static List sort(List l) {
        if (l.isEmpty())
            return empty();
        else {


            return append(sort(leftPart(l.head(), l.tail())), cons(l.head(), sort(rightPart(l.head(), l.tail()))));
        }
    }

    public static boolean equal(List a, List b) {
        if (a.isEmpty() && b.isEmpty())
            return true;
        else if (a.isEmpty() != b.isEmpty())
            return false;

        else
            return (a.head() == b.head() && equal(a.tail(), b.tail()));
    }

    public static boolean search(int a, List l) {
        if (l.isEmpty())
            return false;
        else if (l.head() == a)
            return true;
        else
            return search(a, l.tail());
    }

    public static List minhelper(List l, int pivot) {
        if (l.tail().isEmpty())
            return cons(pivot, empty());
        else if (l.tail().head() < pivot)
            return l;
        else
            return minhelper(l.tail(), pivot);
    }

    public static int min(List a) {
        if (a.tail().isEmpty())
            return a.head();
        else if (a.head() < a.tail().head()) {
            return min(minhelper(a.tail(), a.head()));
        } else
            return min(a.tail());
    }

    public static List reverse(List list) {

        if (list.isEmpty())
            return empty();
        else {

            return cons(list.head(), reverse(list.tail()));
        }
    }

    public static List findNegative(List list) {

        if (list.isEmpty())
            return empty();
        else if (list.head() < 0)
            return cons(list.head(), findNegative(list.tail()));
        else
            return findNegative(list.tail());

    }

    public static boolean isUnique(List list) {

        if (list.tail().isEmpty())
            return true;
        else if (search(list.head(), list.tail()))
            return false;
        else return isUnique(list.tail());

    }


}
