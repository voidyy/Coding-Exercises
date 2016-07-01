/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatree;

import java.util.Stack;

class Node {
    int val;
    Node left;
    Node right;
    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 *
 * @author voidyy
 */
public class JavaTree {
    int lastval = Integer.MIN_VALUE;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //       5
        //    3    7
        //  2  6    8
        // 1      4   9
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        
        Node root = n5;
        root.left = n3;
        root.right = n7;
        n3.left = n2;
        n3.right = n6;
        n2.left = n1;
        n7.right = n8;
        n8.left = n4;
        n8.right = n9;
       
        System.out.println("\ntraverseInOrder: ");
        traverseInOrder(root);
        System.out.println("\nprnOutterTree: ");
        prnOutterTree(root);
        
        System.out.println("\nprnZigzag: ");
        prnZigzag(root);

        JavaTree app = new JavaTree();
        System.out.print("isBST? ");
        System.out.println(app.isBST(root)? "yes" : "No");
    }

    // check if tree is BST
    boolean isBST(Node root) {
        if (root == null)
            return true;
        if (!isBST(root.left))
            return false;
        if (root.val < lastval) {
            return false;
        } else {
            lastval = root.val;
        }
        return (isBST(root.right));
    }
    
    static void traverseInOrder(Node root) {
        if (root == null)
            return;
        traverseInOrder(root.left);
        System.out.print(root.val + " ");
        traverseInOrder(root.right);
    }
    
    static void prnOutterTree(Node root) {
        if (root == null)
            return;
        if (root.left != null) {
            prnOutterLeft(root.left);
        }
        System.out.print(root.val + " ");
        while (root.right != null) {
            System.out.print(root.right.val + " ");
            root = root.right;
        }
    }

    
    static void prnZigzag(Node root) {
        Stack<Node> stackL = new Stack();
        Stack<Node> stackR = new Stack();
        Node p;
        if (root == null)
            return;
        stackL.push(root);
        while(!(stackL.empty() && stackR.empty())) {
            while (!stackL.empty()) {
                p = stackL.pop();
                System.out.print(p.val + " ");
                if (p.left != null)
                    stackR.push(p.left);
                if (p.right != null)
                    stackR.push(p.right);
            }
            System.out.println();
            while (!stackR.empty()) {
                p = stackR.pop();
                System.out.print(p.val + " ");
                if (p.right != null)
                    stackL.push(p.right);
                if (p.left != null)
                    stackL.push(p.left);
            }
            System.out.println();
        }
        System.out.println();
    }

    
    
    
    
    
    
    
    
    
    
    static void prnOutterLeft(Node root) {
        if (root == null)
            return;
        prnOutterLeft(root.left);
        System.out.print(root.val  + " ");
    }
}
