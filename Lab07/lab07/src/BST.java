
/** **********************  BST.java  **************************
 *                 generic binary search tree
 */
import java.util.*;

public class BST<T extends Comparable<T>> implements Iterable<T> {

    protected BSTNode<T> root = null;

    public BST() {
    }

    public BST(BSTNode<T> p) {
        root = p;
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    protected void visit(BSTNode<T> p) {
        System.out.print(p.key + " ");
    }

     public BSTNode<T> getRoot() {
        return root;
    }

    public T search(T el) {
        return search(el, root);
    }

    protected T search(T el, BSTNode<T> p) {
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
        BSTNode<T> p = root;
        LLQueue<BSTNode<T>> queue = new LLQueue<BSTNode<T>>();
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

    protected void preorder(BSTNode<T> p) {
        if (p != null) {
            visit(p);
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void inorder() {
        inorder(root);
    }

    protected void inorder(BSTNode<T> p) {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    protected void postorder(BSTNode<T> p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            visit(p);
        }
    }

    public void insert(T el) {
        root = insert(el, root);
    }

    protected BSTNode<T> insert(T el, BSTNode<T> p) {
        if (p == null) {
            p = new BSTNode<T>(el);
        } else if (el.compareTo(p.key) < 0) {
            p.left = insert(el, p.left);
        } else if (el.compareTo(p.key) > 0) {
            p.right = insert(el, p.right);
        }

        return p;
    }

    public void delete(T el) {
        root = delete(el, root);
    }

    protected BSTNode<T> delete(T el, BSTNode<T> p) {
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
                BSTNode<T> tmp = getMinNode(p.right);//get the successor of the p.key
                p.key = tmp.key; //replace p.key with its successor
                p.right = delete(tmp.key, p.right);  //delete the successor from the right subtree.
            }
        }
        return p;
    }
    
    public int getHeight() { //height of the tree
        return getHeight(root);
    }

    protected int getHeight(BSTNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(p.left), getHeight(p.right));
        }
    }


    //given a non-empty tree, retuns the node with the minimum key.
    private BSTNode<T> getMinNode(BSTNode<T> p) {
        BSTNode<T> tmp = p;
        while (tmp.left != null) {
            tmp = tmp.left;
        }

        return tmp;
    }

    public Iterator<T> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<T> {

        BSTNode<T> p = root;
        LLQueue<BSTNode<T>> queue;

        public BSTIterator() {
            queue = new LLQueue<BSTNode<T>>();
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

    //Generic BSTNode class; 
    protected class BSTNode<T extends Comparable<T>> {

        protected T key;
        protected BSTNode<T> left, right;

        public BSTNode() {
            left = right = null;
        }

        public BSTNode(T el) {
            this(el, null, null);
        }

        public BSTNode(T el, BSTNode<T> lt, BSTNode<T> rt) {
            key = el;
            left = lt;
            right = rt;
        }
    }
}
