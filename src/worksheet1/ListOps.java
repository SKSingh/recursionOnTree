package worksheet1;

/**
 * The class Listops defines a number of static methods to work with
 * lists using the List class.
 */
public class ListOps extends List {

    public static int length(List list) {
        if(list.isEmpty())
            return 0;
        else
            return 1+length(list.tail);

    }

    /**
     * Select and return the nth element of a list a.  Assume that the
     * nth element exists.
     */

    public static int select(int n, List a) {
	if (a.isEmpty())
	    throw new IllegalStateException(
		      "select - list does not have enough elements.");
	else if (n == 0)
	    return a.head();
	else
	    return select(n-1, a.tail());
    }

    /**
     * Return the last element of list a.  Assume that theres is an element.
     */

    public static int last(List a) {
	if (a.isEmpty())
	    throw new IllegalStateException("list does not have any elements.");
	else if (a.tail().isEmpty())
	    return a.head();
	else
	    return last(a.tail());
    }

    /**
     * Add an element x to the end of a list a.
     * Return the extended list.
     */

    public static List addtoend(List a, int x) {
        if (a.isEmpty()) {
            return cons(x, empty());
        } else {
            return cons(a.head(), addtoend(a.tail(), x));
        }
    }

    /**
     * Creates a List which is the result of List b appended to the
     * end of List a
     */
    public static List append(List a, List b) {
        if (a.isEmpty()) {
            return b;
        } else {
            return cons(a.head(), append(a.tail(), b));
        }
    }

    /**
     * addtoend can also be defined using append without any further recursion.

    public static List addtoend(List a, int x) {
        return append(a, cons(x, empty()));
    }

    */

    /**
     * A naive implementation of reversing a List. Can take quite long
     * on large lists
     */
    public static List naiveReverse(List a) {
        if (a.isEmpty()) {
            return empty();
        } else {
            return addtoend(naiveReverse(a.tail()), a.head());
        }
    }
    
    /**
     * An efficient implmentation to reverse a List that uses a helper
     * method and an accumulator
     */
    public static List reverse(List list) {
        return reverseAccumulate(list, empty());
    }
    
    private static List reverseAccumulate(List original, List reversed) {
        if (original.isEmpty()) {
            return reversed;
        } 
	else {
            return reverseAccumulate(original.tail(), 
				     cons(original.head(), reversed));
        }
    }
}
