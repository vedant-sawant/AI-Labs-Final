import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() { root = null; }

    void printInorder(Node node)
    {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    void bfsTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.key + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(9);
        tree.root.right = new Node(1);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(10);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.left.right = new Node(2);

        System.out.println("\nDFS traversal:");
        tree.printInorder(tree.root);

        System.out.println("\nBFS traversal:");
        tree.bfsTraversal(tree.root);
    }
}