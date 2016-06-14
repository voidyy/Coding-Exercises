/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatree;

class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 *
 * @author wu
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
        // 1
        Node root = new Node(5);
        Node n7 = new Node(7);
        n7.right = new Node(8);
        root.right = n7;
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        n2.left = new Node(1);
        n3.left = n2;
        n3.right = new Node(6);
        root.left = n3;
        
       
        traverseInOrder(root);
        System.out.println("\nprnOutterRoot: ");
        prnOutterRoot(root);
        
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
    
    static void prnOutterRoot(Node root) {
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
        System.out.println();
    }

    static void prnOutterLeft(Node root) {
        if (root == null)
            return;
        prnOutterLeft(root.left);
        System.out.print(root.val  + " ");
    }
}
