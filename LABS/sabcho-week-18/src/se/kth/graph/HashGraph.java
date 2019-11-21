package se.kth.graph;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A graph with a fixed number of vertices implemented using adjacency maps.
 * Space complexity is &Theta;(n + m) where n is the number of vertices and m
 * the number of edges.
 *
 * @author  Sabrina Chowdhury
 * @version 2014-04-15
 */
public class HashGraph implements Graph {
    /**
     * The map edges[v] contains the key-value pair (w, c) if there is an edge
     * from v to w; c is the cost assigned to this edge. The maps may be null
     * and are allocated only when needed.
     */
    private final Map<Integer, Integer>[] edges;
    private final static int INITIAL_MAP_SIZE = 4;

    /** Number of edges in the graph. */
    private int numEdges;

    /**
     * Constructs a HashGraph with n vertices and no edges. Time complexity:
     * O(n)
     *
     * @throws IllegalArgumentException
     *             if n < 0
     */
    public HashGraph(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n = " + n);

        // The array will contain only Map<Integer, Integer> instances created
        // in addEdge(). This is sufficient to ensure type safety.
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] a = new HashMap[n];
        edges = a;
    }

    /**
     * Add an edge without checking parameters.
     */
    private void addEdge(int from, int to, int cost) {
        if (edges[from] == null)
            edges[from] = new HashMap<Integer, Integer>(INITIAL_MAP_SIZE);
        if (edges[from].put(to, cost) == null)
            numEdges++;
    }

    /**
     * {@inheritDoc Graph} Time complexity: O(1).
     */
    @Override
    public int numVertices() {
        return edges.length;
    }

    /**
     * {@inheritDoc Graph} Time complexity: O(1).
     */
    @Override
    public int numEdges() {
        return numEdges;
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public int degree(int v) throws IllegalArgumentException {
        //vertex cannot be smaller than zero or larger than or equal to the number of vertices
        checkVertexParameter(v);
        //if the vertex is null/empty there cant be an edge just appearing from nowhere
        //all edges have to vertices on both of their ends
        if (edges[v] == null) return 0;
        //returns the number of mappings to other vertices that this vertex has
        return edges[v].size();

    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public VertexIterator neighbors(int v) {
        //!<0 or >=numVertices()
        checkVertexParameter(v);

        return new NeighborIterator(v);
    }

    private class NeighborIterator implements VertexIterator {
        Iterator<Integer> iterator;

        NeighborIterator(int v) {
            if(edges[v] == null)
                iterator = null;
            else
                iterator = edges[v].keySet().iterator();
        }


        @Override
        public boolean hasNext() {
            if(iterator != null)
                //returns true if the iteration has more elements
                return iterator.hasNext();

            return false;
        }

        @Override
        public int next() {
            //if iterator is empty and it has a neighbour
            if (iterator != null && iterator.hasNext()) {
                //returns the next element in the iteration
                return iterator.next();
            }
            throw new NoSuchElementException(
                    "This iterator has no more elements.");
        }
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public boolean hasEdge(int v, int w) {
        checkVertexParameters(v,w);
        if (edges[v] != null) {
            if(edges[v].get(w) != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public int cost(int v, int w) throws IllegalArgumentException {
        checkVertexParameters(v,w);
        Map<Integer,Integer> obj = edges[v];

        int cost = NO_COST;

        if(obj != null && obj.containsKey(w))
            cost=obj.get(w);

        return cost;
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void add(int from, int to) {
        checkVertexParameters(from, to);
        addEdge(from, to, NO_COST);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void add(int from, int to, int c) {
        checkVertexParameters(from, to);
        checkNonNegativeCost(c);
        addEdge(from, to, c);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void addBi(int v, int w) {
        checkVertexParameters(v, w);

        addEdge(v, w, NO_COST);
        if (v == w)
            return;
        addEdge(w, v, NO_COST);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void addBi(int v, int w, int c) {
        checkVertexParameters(v, w);
        checkNonNegativeCost(c);

        addEdge(v, w, c);
        //we don´t need to add w --v and v--w two times if they are the same
        if (v == w){
            return;
        }
        addEdge(w, v, c);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void remove(int from, int to) {
        checkVertexParameters(from, to);
        Map<Integer, Integer> obj = edges[from];

        if(obj != null && obj.containsKey(to))
        {
            obj.remove(to);
            numEdges--;

            if(hasEdge(to, from) && to==from)
            {
                numEdges--;
            }
        }
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void removeBi(int v, int w) {
        remove(v, w);
        remove(w, v);
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return a String representation of this graph
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i = 0; i < numVertices(); i++) {
            if(edges[i] != null) {
                Iterator<Map.Entry<Integer, Integer>> it;
                it = edges[i].entrySet().iterator(); //returns a Iterator<Map.Entry<Integer,Integer>>>
                while(it.hasNext()) {
                    Map.Entry<Integer, Integer> entry =  it.next();
                    if(entry.getValue() == -1) { //if there is NO_COST only add the key
                        sb.append("(" + i + "," + entry.getKey() + "), ");
                    }else {
                        sb.append("(" + i + "," + entry.getKey() + "," + entry.getValue() + "), ");

                    }
                }
            }
        }
        if (numEdges > 0)
            sb.setLength(sb.length() - 2); // Remove trailing ", "
        sb.append("}");
        return sb.toString();

    }

    /**
     * Checks a single vertex parameter v.
     *
     * @throws IllegalArgumentException
     *             if v is out of range
     */
    private void checkVertexParameter(int v) {
        if (v < 0 || v >= numVertices())
            throw new IllegalArgumentException("Out of range: v = " + v + ".");
    }

    /**
     * Checks two vertex parameters v and w.
     *
     * @throws IllegalArgumentException
     *             if v or w is out of range
     */
    private void checkVertexParameters(int v, int w) {
        if (v < 0 || v >= numVertices() || w < 0 || w >= numVertices())
            throw new IllegalArgumentException("Out of range: v = " + v
                    + ", w = " + w + ".");
    }

    /**
     * Checks that the cost c is non-negative.
     *
     * @throws IllegalArgumentException
     *             if c < 0
     */
    private void checkNonNegativeCost(int c) {
        if (c < 0)
            throw new IllegalArgumentException("Illegal cost: c = " + c + ".");
    }
}