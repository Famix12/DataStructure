
import java.util.*;

public class AVLTree<T extends Comparable<T>> implements Iterable<T> {

    protected AVLNode<T> root = null;

    public AVLTree() {
    }

    public AVLTree(AVLNode<T> p) {
        root = p;
    }

    public AVLNode<T> getRoot() {
        return root;
    }

    public int height() { //height of the tree
        return height(root);
    }

    private int height(AVLNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            return p.height;
        }
    }

    public void insert(T el) {
        root = insert(el, root);
    }

    private AVLNode<T> insert(T el, AVLNode<T> p) {
        if (p == null) {
            p = new AVLNode<T>(el);
        } else if (el.compareTo(p.key) < 0) {
            p.left = insert(el, p.left); 
            if (height(p.left) - height(p.right) == 2) {
                if (el.compareTo(p.left.key) < 0) {
                    p = rotateRight(p);
                } else {
                    p = rotateLeftRight(p);
                }
            }
        } else if (el.compareTo(p.key) > 0) {
            p.right = insert(el, p.right);
            if (height(p.right) - height(p.left) == 2) {
                if (el.compareTo(p.right.key) > 0) {
                    p = rotateLeft(p);
                } else {
                    p = rotateRightLeft(p);
                }
            }
        } else
            ;  // Duplicate; do nothing
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        return p;
    }

    public void delete(T el) {
        root = delete(el, root);
    }

    private AVLNode<T> delete(T el, AVLNode<T> p) {
        //Step 1:  Delete using BST deletion by copying method
        if (p == null) {
            return null;
        } else if (el.compareTo(p.key) < 0) //target is less than p.key
        {
            p.left = delete(el, p.left);  // delete from left
        } else if (el.compareTo(p.key) > 0) //target is greater than p.key
        {
            p.right = delete(el, p.right);
        } else { //p.key is the key to be deleted
            if (p.left == null || p.right == null) {//if there is one or no child 
                if (p.left == null) //if no left child
                {
                    p = p.right;
                } else //if no right child or no child at all
                {
                    p = p.left;
                }
            } else { //if p has two children
                AVLNode<T> tmp = getMinNode(p.right);//get the successor of the p.key
                p.key = tmp.key; //replace p.key with its successor
                p.right = delete(tmp.key, p.right);  //delete the successor from the right subtree.
            }
        }
        if (p == null) // if p had only one node and it has been deleted in the above
        {
            return p;
        }

        //Step 2:  Update the height of node p
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        //step 3: Rebalance the tree
        if (balanceFactor(p) < -1) {
            if (balanceFactor(p.left) <= 0) //Left - Left
            {
                p = rotateRight(p);
            } else // Left - Right
            {
                p = rotateLeftRight(p);
            }
        } else if (balanceFactor(p) > 1) {
            if (balanceFactor(p.right) >= 0) // Right - Right
            {
                p = rotateLeft(p);
            } else // Right-Left
            {
                p = rotateRightLeft(p);
            }
        }
        return p;
    }

    //given a non-empty tree, retuns the node with the minimum key.
    private AVLNode<T> getMinNode(AVLNode<T> p) {
        AVLNode<T> tmp = p;
        while (tmp.left != null) {
            tmp = tmp.left;
        }

        return tmp;
    }

    private int balanceFactor(AVLNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            return height(p.right) - height(p.left);
        }
    }

    //given a non-empty tree, retuns the node with the maximum key.
    private AVLNode<T> getMaxNode(AVLNode<T> p) {
        AVLNode<T> tmp = p;
        while (tmp.right != null) {
            tmp = tmp.right;
        }

        return tmp;
    }

    private AVLNode<T> rotateRight(AVLNode<T> p) {
        System.out.println("Rotate Right about node: " + p.key);
        AVLNode<T> parent = p.left;
        p.left = parent.right;
        parent.right = p;
        p.height = 1 + Math.max(height(p.left), height(p.right));
        parent.height = 1 + Math.max(height(parent.left), height(parent.right));
        return parent;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> p) {
        System.out.println("Rotate Left about node: " + p.key);
        AVLNode<T> parent = p.right;
        p.right = parent.left;
        parent.left = p;
        p.height = 1 + Math.max(height(p.left), height(p.right));
        parent.height = 1 + Math.max(height(parent.left), height(parent.right));
        return parent;
    }

    private AVLNode<T> rotateLeftRight(AVLNode<T> p) {
        System.out.println("Doubel Left-Right rotations required");
        p.left = rotateLeft(p.left);
        return rotateRight(p);
    }

    private AVLNode<T> rotateRightLeft(AVLNode<T> p) {
        System.out.println("Doubel Right-Left rotations required");
        p.right = rotateRight(p.right);
        return rotateLeft(p);
    }

    public Iterator<T> iterator() {
        return new AVLIterator();
    }

    private class AVLIterator implements Iterator<T> {

        AVLNode<T> p = root;
        LLQueue<AVLNode<T>> queue;

        public AVLIterator() {
            queue = new LLQueue<AVLNode<T>>();
            queue.enqueue(p);
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

        public T next() {
            p = queue.dequeue();
            if (p.left != null) {
                queue.enqueue(p.left);
            }
            if (p.right != null) {
                queue.enqueue(p.right);
            }
            return p.key;
        }

        public void remove() {
            // not implemented
        }
    }
   
    //Generic AVLNode class; 
    protected class AVLNode<T extends Comparable<T>> {

        protected T key;
        protected int height;
        protected AVLNode<T> left, right;

        public AVLNode() {
            height = 0;
            key = null;
            left = right = null;
        }

        public AVLNode(T el) {
            key = el;
            left = right = null;
            height = 1;
        }

        public AVLNode(T el, AVLNode<T> lt, AVLNode<T> rt) {
            key = el;
            left = lt;
            right = rt;
            height = 1 + Math.max(left.height, right.height);
        }
    }

    //Compied with minor updates from BST
    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    protected void visit(AVLNode<T> p) {
        System.out.println(p.key + " ");
    }

    public T search(T el) {
        return search(el, root);
    }

    //recursive search
    protected T search(T el, AVLNode<T> p) {
        if (p == null) {
            return null;
        } else if (el.compareTo(p.key) < 0) {
            return search(el, p.left);
        } else if (el.compareTo(p.key) > 0) {
            return search(el, p.right);
        } else {
            return p.key;
        }
    }

    public boolean isInTree(T el) {
        return search(el) != null;
    }

    public void breadthFirst() {
        AVLNode<T> p = root;
        LLQueue<AVLNode<T>> queue = new LLQueue<AVLNode<T>>();
        if (p != null) {
            queue.enqueue(p);
            while (!queue.isEmpty()) {
                p = queue.dequeue();
                visit(p);
                if (p.left != null) {
                    queue.enqueue(p.left);
                }
                if (p.right != null) {
                    queue.enqueue(p.right);
                }
            }
        }
    }

    public void preorder() {
        preorder(root);
    }

    protected void preorder(AVLNode<T> p) {
        if (p != null) {
            visit(p);
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void inorder() {
        inorder(root);
    }

    protected void inorder(AVLNode<T> p) {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    protected void postorder(AVLNode<T> p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            visit(p);
        }
    }
}
