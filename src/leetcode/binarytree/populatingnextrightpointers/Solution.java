package leetcode.binarytree.populatingnextrightpointers;
import java.util.*;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution {

    public Node connect(Node root) {
        if (root == null){
            return null;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;
            while(current != null) {
                current.left.next = current.right;
                if(current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public void printNextPointers(Node root) {
        Node level = root;

        while (level != null) {
            Node current = level;

            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }

            System.out.println("null");
            level = level.left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
        */

        solution.connect(root1);
        solution.printNextPointers(root1);

        Node root2 = new Node(1);

        /*
                1
        */

        solution.connect(root2);
        solution.printNextPointers(root2);

        Node root3 = null;

        solution.connect(root3);
        solution.printNextPointers(root3);
    }
}