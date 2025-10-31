import java.util.*;

class BST {
    // Build Node class
    class Node {
        int value;
        Node left, right;

        Node(int item) {
            value = item;
            left = right = null;
        }
    }

    Node root;

    // Constructor
    BST() {
        this.root = null;
    }

    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value > root.value)
            root.right = insertRec(root.right, value);
        else if (value < root.value)
            root.left = insertRec(root.left, value);

        return root;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    public List<Integer> getLeaves() {
        List<Integer> leaves = new ArrayList<>();
        findLeaves(root, leaves);
        Collections.sort(leaves);
        return leaves;
    }

    private void findLeaves(Node root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.value);
            return;
        }
        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();

        // Read integers until we meet 0
        while (true) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            bst.insert(num);
        }


        List<Integer> leaves = bst.getLeaves();

        // Print the result
        for (int i = 0; i < leaves.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(leaves.get(i));
        }
        System.out.println();

        sc.close();
    }
}