package Tree;

import java.util.ArrayList;

/**
 * @author Saurabh
 * @version 30/01/2013
 */
public class Node {


        private String identifier;
        private ArrayList<Integer> forwardPointers;


        public Node(String identifier) {
            identifier = identifier;
            forwardPointers = new ArrayList<Integer>();
        }


        public String getIdentifier() {
            return identifier;
        }

        public ArrayList<Integer> getForwardPointers() {
            return forwardPointers;
        }

        // public interface
        public void addForwardPointer(int index) {
            forwardPointers.add(index);
        }
    }

