import java.lang.*;
/**
 * Created by Sabrina on 2/9/18.
 */

public class Tree<T extends Comparable<T>>  {
    protected static class Node<T> {
        private Node<T> left; //null
        private Node<T> right; //null
        private Node<T> parent; //null
        private T data;

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> parent) {
            this.parent = parent;
            this.data = data;
        }
    }

    private Node<T> root; //null
    private int leaves; //0
    public int height; //0
    private int size; //0


    /**
     * Adds an object to the binary tree
     *
     * @param object The data of the element to add.
     * @return true if the object was added.
     */
    public boolean insert(T object) {
        if (object == null) {
            return false;
        }

        boolean addedNode = insertIteratively(object);
        return addedNode;
    }

    /**
     * Insert a new node
     * @param object to be given this new node
     * @return true if the data has been inserted as a node in the tree
     */
    private boolean insertIteratively(T object) {

        if (this.root == null) { //Create root node
            this.height = 0;
            this.root = createLeaf(object, null);
            return true;
        }

        Node<T> currentNode = this.root;

        while (true) {

            int comparator = object.compareTo(currentNode.data);

            if (comparator == 0) {
                return false;
            }

            if (comparator < 0) {
                if (currentNode.left == null) {
                    currentNode.left = createLeaf(object, currentNode);
                    return true;
                } else {
                    currentNode = currentNode.left;
                }

            } else if (comparator > 0) {
                if (currentNode.right == null) {
                    currentNode.right = createLeaf(object, currentNode);
                    return true;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }

    }

    /**
     * Number of elements in the tree.
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns the height of the tree.
     */
    public int height() {

        if(size==0){
            return 0;
        }

        return getHeight(root)-1;
    }

    /**
     * Get the height of the tree
     * @param node start node : root
     * @return height of tree
     */
    public int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        // int height =1 + Math.max(leftHeight, rightHeight);
        return (leftHeight > rightHeight ? leftHeight : rightHeight) +1;
    }

    /**
     * Returns the number leaf nodes in the tree.
     */
    public int leaves() {

        return getLeaves(root);
    }

    /**
     * Returns the number of leaf nodes in the tree.
     * @param node start node : will be the root
     * @return number of leaves in tree
     */
    private int getLeaves(Node<T> node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 1;
        }
        return getLeaves(node.left) + getLeaves(node.right);
    }


    /**
     * True if the given node is a leaf node.
     * @param node to be checked
     * @return true if the given node is a leaf node
     */
    private boolean isLeaf(Node<T> node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Creates a leaf node
     * @param data to be assigned this node
     * @param parent the node the data will be given to
     * @return the node and its data - AKA the newly made leaf
     */
    private Node<T> createLeaf(T data, Node<T> parent) {
        this.size += 1;
        if (!isLeaf(parent)) {
            this.leaves += 1;
        }
        return new Node<T>(data, parent);
    }


    /**
     * Checks if an element with the given data exists in the tree.
     * @param data element with data to be searched
     * @return true if an element with the given data exists in the tree
     */
    public boolean search(T data) {

        if(size == 0){
            return false;
        }
        Node<T> currentNode = this.root;
        int comparator;
        while ((comparator = data.compareTo(currentNode.data)) != 0) {
            if (comparator < 0) {
                if (currentNode.left == null) {
                    return false;
                } else {
                    currentNode = currentNode.left;
                }
            } else if (comparator > 0) {
                if (currentNode.right == null) {
                    return false;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
        return true;
    }

    /**
     * A string representation of the tree.
     */
    public String toString() {

        StringBuilder output = new StringBuilder();
        toStringSorted(this.root, output);
        return "[" + output + "]";
    }

    private void toStringSorted(Node<T> node, StringBuilder builder) {
        if (node != null) {
            if (node.left != null) {
                toStringSorted(node.left, builder);
                builder.append(", ");
            }
            builder.append(node.data.toString());
            if (node.right != null) {
                builder.append(", ");
                toStringSorted(node.right, builder);
            }
        }
    }

}


