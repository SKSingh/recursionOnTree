package Tree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Saurabh
 * @version 30/01/2013
 */
public class Tree {

    private static final int NOT_FOUND = -1;

    private ArrayList<Node> nodes;
    private TraversalStrategy traversalStrategy;


    public Tree() {

        this(TraversalStrategy.BREADTHFIRST);
    }

    public Tree(TraversalStrategy traversalStrategy) {

        nodes = new ArrayList<Node>();
        traversalStrategy = traversalStrategy;
    }


    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public TraversalStrategy getTraversalStrategy() {
        return traversalStrategy;
    }

    public void setTraversalStrategy(TraversalStrategy traversalStrategy) {

        traversalStrategy = traversalStrategy;
    }


    public int indexOf(String identifier) {

        int result = NOT_FOUND;
        int index = 0;
        for (Node node : nodes) {
            if (node.getIdentifier().equals(identifier)) {
                result = index;
                break;
            }
            index++;

        }
        return result;
    }

    public Node createNode(String identifier) {

        return this.createNode(identifier, null);
    }

    public Node createNode(String identifier, String parent) {

        Node node = new Node(identifier);
        nodes.add(node);
        this.setForwardPointer(identifier, parent);
        return node;
    }

    public int size() {

        return nodes.size();
    }

    public Iterator<Node> iterator() {

        return (traversalStrategy == TraversalStrategy.BREADTHFIRST) ? new Traverser(nodes) : null;
    }


    private void setForwardPointer(String identifier, String parent) {

        if (parent != null) {
            int parentIndex = this.indexOf(parent);

            nodes.get(parentIndex).addForwardPointer(this.indexOf(identifier));
        }
    }
}
