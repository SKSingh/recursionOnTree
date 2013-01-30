package Tree;

import java.util.*;

/**
 * @author Saurabh
 * @version 30/01/2013
 */
public class Traverser implements Iterator<Node> {

    private static final int ROOT = 0;

    private LinkedList<Node> queue;

    private Map<Integer, ArrayList<Integer>> levels;

    public Traverser(ArrayList<Node> tree) {

        queue = new LinkedList<Node>();

        levels = new HashMap<Integer, ArrayList<Integer>>();

        this.buildTreeLevels(tree, ROOT, 0);

        for (Map.Entry<Integer, ArrayList<Integer>> entry : levels.entrySet()) {

            for (Integer forwardPointer : entry.getValue()) {

                queue.add(tree.get(forwardPointer));
            }
        }
    }

    private void buildTreeLevels(ArrayList<Node> tree, int index, int level) {

        if (level == ROOT) {
            queue.add(tree.get(index));
        }

        ArrayList<Integer> forwardPointers = tree.get(index).getForwardPointers();

        if (!levels.containsKey(level)) {
            levels.put(level, new ArrayList<Integer>());
        }
        for (Integer forwardPointer : forwardPointers) {
            levels.get(level).add(forwardPointer);

            // Recursive call.
            this.buildTreeLevels(tree, forwardPointer, level + 1);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Node next() {
        return queue.poll();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
