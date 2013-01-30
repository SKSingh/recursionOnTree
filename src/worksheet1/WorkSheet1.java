package worksheet1;

import static worksheet1.List.cons;
import static worksheet1.List.empty;

/**
 * @author Saurabh
 * @version 30/01/2013
 */
public class WorkSheet1 {

    /**
     * Solution-1
     * method power(int a, int n) calculates power by reducing
     * the size of exponent by 1 and has linear running time.
     * <p/>
     * fastPower(int a, int n) reduces on average the size of exponent by constant factor of 2,
     * runs in logarithmic time O(log n).
     *
     * @param a, number being raised to
     * @param n, exponent
     * @return long, a raised to the nth power
     */

    public static long power(int a, int n) {
        if (n == 0)
            return 1;
        else
            return a * power(a, n - 1);

    }

    public static long fastPower(int a, int n) {

        if (n == 0)
            return 1;
        else if (n % 2 == 0) {
            return fastPower(a, (n / 2)) * fastPower(a, (n / 2));
        } else
            return a * fastPower(a, (n - 1) / 2) * fastPower(a, (n - 1) / 2);
    }

    /**
     * Solution-2
     * method negateAll switches sign of each element to opposite
     * and runs in linear time.
     *
     * @param list to be negated
     * @return list of all values negated
     */

    public static List negateAll(List list) {

        if (list.isEmpty())
            return empty();
        else
            return cons(-list.head(), negateAll(list.tail()));
    }

    /**
     * Solution-3
     * method find searches for the given value and returns its location in list.
     * runs in  linear time.
     *
     * @param list in which element is being searched
     * @param x    value to be searched
     * @return location of the value if exits
     */

    public static int find(List list, int x) {
        if (list.isEmpty())
            System.out.println("Value not found");

        if (list.head() == x)
            return 0;

        return 1 + find(list.tail(), x);
    }

    /**
     * Solution-4
     * allPositive verifies the positivity of all elements in the list
     * runs in linear time.
     *
     * @param list to be verified
     * @return boolean
     */

    public static boolean allPositive(List list) {

        if (list.tail().isEmpty() && list.head() >= 0)
            return true;
        else if (list.tail().isEmpty() && list.head() < 0)
            return false;
        else if (list.head() < 0)
            return false;
        else return allPositive(list.tail());
    }

    /**
     * Solution-5
     * this method collects all the positive elements in list
     * runs in linear time.
     *
     * @param list to be filtered
     * @return list of all positives
     */

    public static List findPositive(List list) {

        if (list.isEmpty())
            return empty();
        else if (list.head() >= 0)
            return cons(list.head(), findPositive(list.tail()));
        else
            return findPositive(list.tail());

    }

    /**
     * Solution-6
     * method verifies sortedness of list runs in linear time.
     *
     * @param list to be checked
     * @return boolean
     */

    public static boolean sorted(List list) {
        if (list.tail().isEmpty())
            return true;
        else if (list.head() <= list.tail().head())
            return sorted(list.tail());
        else
            return false;
    }

    /**
     * Solution-7
     * merge merges the elements of two sorted list in one sorted list all elements with keeping any duplicates
     * runs in linear time.
     *
     * @param a and b, lists to be merged together
     * @return list of all elements in sorted order
     */

    public static List merge(List a, List b) {

        if (a.isEmpty())
            return b;
        else if (b.isEmpty())
            return a;
        else {
            List list = empty();
            if (a.head() <= b.head())
                list = cons(a.head(), merge(a.tail(), b));
            else if (b.head() < a.head())
                list = cons(b.head(), merge(a, b.tail()));
            return list;
        }
    }

    /**
     * Solution-8
     * method removes any duplicate copy of elements in the sorted list
     * runs in linear time
     *
     * @param list to be removed duplicate from
     * @return list of unique elements in sorted order
     */

    public static List removeDuplicates(List list) {

        if (list.tail().isEmpty())
            return list;
        else if (list.head() != list.tail().head())
            return cons(list.head(), removeDuplicates(list.tail()));
        else return removeDuplicates(list.tail());

    }
}

