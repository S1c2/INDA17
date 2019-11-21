package se.kth.graph;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Sabrina Chowdhury
 * @version 2018-02-22
 */

import java.util.Random;

public class RandomGraphGenerator {

    int vertices;
    Graph graph;
    Random rand;
    private static int biggestComponent;
    private static int numberOfComponents;


    public RandomGraphGenerator(int n, Graph graph) {
        rand = new Random();
        vertices = n;
        this.graph = graph;

        makeRandomEdges();
        printComponents(graph);

    }
    private void makeRandomEdges(){
        for(int i = 1; i<vertices; i++){
            int a = rand.nextInt(vertices);
            int b = rand.nextInt(vertices);
            graph.add(a, b);
        }
    }

    /**
     * Prints the components of g to stdout. Each component is written on a
     * separate line.
     */
    private static void printComponents(Graph g) {
        int n = g.numVertices();
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                dfs(g, v, visited, 0);
                numberOfComponents++;
            }
        }
    }

    /**
     * Traverses the nodes of g that have not yet been visited. The nodes are
     * visited in depth-first order starting at v. The act() method in the
     * VertexAction object is called once for each node.
     *
     * @param g
     *            an undirected graph
     * @param v
     *            start vertex
     * @param visited
     *            visited[i] is true if node i has been visited
     */
    private static void dfs(Graph g, int v, boolean[] visited, int size) {
        int Component = size;
        if (visited[v])
            return;
        visited[v] = true;
        Component++;

        if(Component > biggestComponent) biggestComponent = Component;
        for (VertexIterator it = g.neighbors(v); it.hasNext();) {
            dfs(g, it.next(), visited, Component);
        }

    }


    public static void main(String[] arg) {

        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        //  prompt for the user to enter the number of nodes
        System.out.print("Enter the number of nodes: ");

        // get their input as a String
        int n = scanner.nextInt();

        HashGraph hgraph = new HashGraph(n);
        MatrixGraph mGraph = new MatrixGraph(n);

        long startTime = System.nanoTime();

        RandomGraphGenerator rGraph = new RandomGraphGenerator(n, mGraph);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("MatrixGraph took: " + estimatedTime + " ns : " + "Number of components: " + numberOfComponents + " \nSize of biggest component: " + biggestComponent);

        startTime = System.nanoTime();
        //it doesn´t actually do anything but we run it to see how long it takes to run
        RandomGraphGenerator a = new RandomGraphGenerator(n, hgraph);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashGraph took: " + estimatedTime + " ns : " + "Number of components: " + numberOfComponents + " \nSize of biggest component: " + biggestComponent);

    }
}