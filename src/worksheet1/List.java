package worksheet1;

/**
 * List class defines a recursive type called List, and provides
 * constructor and accessor methods. 
 */
public class List {

    protected boolean empty;
    protected int head;
    protected List tail;

    public List(int x, List t) {
        empty = false; 
        head = x;
        tail = t;
    }
    
    public List() {
        empty = true;
    }
    
    /**
     * Creates a new list from a given head element and a tail List
     */
    public static List cons(int x, List t) {
        return new List(x,t);
    }
    
    /**
     * Creates a new empty List
     */
    public static List empty() {
        return new List();
    }
    
    /**
     * returns true if this list is empty
     */
    public boolean isEmpty() {
        return empty;
    }
    
    /**
     * returns the head of this list or throws an exception if the
     * list is empty
     * @throws IllegalStateException if the list is empty
     */
    public int head() {
        if (isEmpty()) {
            throw new IllegalStateException(
		          "Trying to access head of an empty list");
        }
        return head;
    }
    
    /**
     * returns the tail of this list or throws an exception if the
     * list is empty
     * @throws IllegalStateException if the list is empty
     */    
    public List tail() {
        if (isEmpty()) {
            throw new IllegalStateException(
			  "Trying to access tail of an empty list");
        }
        return tail;
    }
    
    /**
     * Returns a String representation of this List. eg "[1, 2, 3]"
     */
    @Override
    public String toString() {
        return toStringHelper(this, new java.util.ArrayList<Integer>());
    }
    
    private String toStringHelper(List list, 
				  java.util.List<Integer> accumulator) {
        if (list == null) {
            throw new IllegalStateException(
                         "next element of list was null. " +
			 "Should either be another list or nil. " +
			 "List till now: " + accumulator);
        } else if (list.isEmpty()) {
            return accumulator.toString();
        } else {
            accumulator.add(list.head());
            return toStringHelper(list.tail(), accumulator);
        }
    }
}
