package Tree;

import java.util.ArrayList;

/**
 * @author Saurabh
 * @version 30/01/2013
 */
public class Node {


        private String _identifier;
        private ArrayList<Integer> _forwardPointers;

        // constructor
        public Node(String identifier) {
            _identifier = identifier;
            _forwardPointers = new ArrayList<Integer>();
        }

        // properties
        public String getIdentifier() {
            return _identifier;
        }

        public ArrayList<Integer> getForwardPointers() {
            return _forwardPointers;
        }

        // public interface
        public void addForwardPointer(int index) {
            _forwardPointers.add(index);
        }
    }

