//Note to Students:  You do not need to understand the code in this class.
//                   You only need to know how to use it as shown in TestIntegerBST.java

import java.util.*;

public class BSTPrinter {

    BST<Integer> tree;

    public static final int MAX_HEIGHT = 5;  // cannot print trees > MAX_HEIGHT
    private static final int POWERS_OF_2[] = {1, 2, 4, 8, 16, 32, 64, 128};

    public BSTPrinter(BST<Integer> t) {
        tree = t;
    }

    public void print() {

        ArrayList<BST<Integer>.BSTNode<Integer>> thisLevelNodes = new ArrayList<>();

        int height = tree.getHeight();
        int offset = POWERS_OF_2[height] - 1;

        thisLevelNodes.add(tree.getRoot());

        // Loop to print each level of nodes.
        for (int level = 0; level < height; level++) {
            if (level > MAX_HEIGHT) {
                System.out.println("*** Too many levels to print. ***\n");
                break;
            }

            // Print node data.
            printData(level, offset, thisLevelNodes);

            if (level != height - 1) { //if not last level
                // Print outgoing pointers /\ from each parent node->
                printOutgoingLinks(level, offset, thisLevelNodes);

                offset = POWERS_OF_2[height - level - 1] - 1;

                // Print connecting dashes ----
                if (level < height - 2) {
                    printConnectingDashes(level, offset, thisLevelNodes);
                }

                // Print incoming pointers / and \ to each child node->
                printIncomingLinks(level, offset, thisLevelNodes);

                // Prepare the next level of nodes.
                thisLevelNodes = getNextLevelNodes(level, thisLevelNodes);
            }
        }
    }

    private void printData(int level, int offset, ArrayList<BST<Integer>.BSTNode<Integer>> levelNodes) {
        printSpaces(offset);

        int k = POWERS_OF_2[level];
        for (int i = 0; i < k; i++) {
            BST<Integer>.BSTNode<Integer> p = levelNodes.get(i);

            if (p != null) {
                System.out.print(padSpaces(p.key + "", 3) + " ");
            } else {
                System.out.print("    ");
            }

            // Space over to the next node in this level.
            if (i < k - 1) {
                printSpaces(2 * offset - 2);
            }
        }
        System.out.println();
    }

    private void printOutgoingLinks(int level, int offset, ArrayList<BST<Integer>.BSTNode<Integer>> levelNodes) {
        printSpaces(offset);

        int k = POWERS_OF_2[level];
        for (int i = 0; i < k; i++) {
            BST<Integer>.BSTNode<Integer> p = levelNodes.get(i);;

            // Has left child: print / forward slash
            if ((p != null) && (p.left != null)) {
                System.out.print(" /");
            } // No left child: print space
            else {
                System.out.print("  ");
            }

            // Has right child: print \ backward slash
            if ((p != null) && (p.right != null)) {
                System.out.print("\\ ");
            } // No right child: print space
            else {
                System.out.print("  ");
            }

            // Space over to the next node in this level.
            if (i < k - 1) {
                printSpaces(2 * offset - 2);
            }
        }
        System.out.println();
    }

    public void printConnectingDashes(int level, int offset, ArrayList<BST<Integer>.BSTNode<Integer>> levelNodes) {
        if (offset > 1) {
            printSpaces(offset);
        }

        int k = POWERS_OF_2[level];
        for (int i = 0; i < k; i++) {
            BST<Integer>.BSTNode<Integer> p = levelNodes.get(i);

            // Has left child: print dashes
            if ((p != null) && (p.left != null)) {
                printSpaces(3);
                printDashes(offset - 1);
            } // No left child: print spaces
            else {
                printSpaces(offset + 2);
            }

            // Has right child: print dashes
            if ((p != null) && (p.right != null)) {
                printSpaces(2);
                printDashes(offset - 1);
            } // No right child: print spaces
            else {
                printSpaces(offset + 1);
            }

            // Space over to the next node in this level.
            if (i < k - 1) {
                printSpaces(2 * offset + 1);
            }
        }
        System.out.println();
    }

    private void printIncomingLinks(int level, int offset, ArrayList<BST<Integer>.BSTNode<Integer>> levelNodes) {
        printSpaces(offset);

        int k = POWERS_OF_2[level];
        for (int i = 0; i < k; i++) {
            BST<Integer>.BSTNode<Integer> p = levelNodes.get(i);

            // Left child: print /
            if ((p != null) && (p.left != null)) {
                System.out.print("  /");
            } // No left child: print spaces
            else {
                printSpaces(3);
            }

            // Right child: print \ backward slash
            if ((p != null) && (p.right != null)) {
                printSpaces(2 * offset);
                System.out.print("\\");
            } // No right child: print spaces
            else {
                printSpaces(2 * offset + 1);
            }

            // Space over to the next node in this level.
            if (i < k - 1) {
                printSpaces(2 * offset);
            }
        }
        System.out.println();
    }

    private ArrayList<BST<Integer>.BSTNode<Integer>> getNextLevelNodes(int level, ArrayList<BST<Integer>.BSTNode<Integer>> levelNodes) {
        int size = POWERS_OF_2[level];
        ArrayList<BST<Integer>.BSTNode<Integer>> nextLevelNodes = new ArrayList<>();//BinaryNode *next_level[size];
        for (int i = 0; i < size; i++) {
            BST<Integer>.BSTNode<Integer> p = levelNodes.get(i);

            // Queue the left child nodes of each non-null parent node->
            if ((p != null) && (p.left != null)) {
                nextLevelNodes.add(p.left);
            } else {
                nextLevelNodes.add(null);
            }

            // Queue the right child nodes of each non-null parent node->
            if ((p != null) && (p.right != null)) {
                nextLevelNodes.add(p.right);
            } else {
                nextLevelNodes.add(null);
            }
        }
        return nextLevelNodes;
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private void printDashes(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }

    private String padSpaces(String s, int w) {
        int length = s.length();
        while (length < w) {
            s = " " + s;
            length++;
        }
        return s;
    }
}
