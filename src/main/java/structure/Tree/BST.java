package structure.Tree;

/**
 * A general Binary Search Tree.
 * Created by dingcheng on 2015/3/16.
 */
public class BST<T extends Comparable<? super T>> {
    /**
     *  A single node in our Binary Tree.
     */
    public class BinaryNode {
        public T element;
        BinaryNode left;
        BinaryNode right;
        public BinaryNode(T elem) {
            element = elem;
            left = null;
            right = null;
        }
        public BinaryNode(T elem, BinaryNode lt, BinaryNode rt) {
            element = elem;
            left = lt;
            right = rt;
        }
    }

    /** Local variables */
    public BinaryNode root;                    // Pointer to root node, if present
    public boolean removalSuccesful;    // Set to true when remove() succeeds

    /** Initializes an empty BST. */
    public BST() {
        root = null;
    }

    /** Return true if the BST is empty. */
    public boolean isEmpty() {
        return (root == null);
    }



    /**
     * search an element in the BST --- O(h)
     */
    public T search(T elem) {
//        BinaryNode found = search(root, elem);//
        BinaryNode found = search_iterative(root, elem);
        return (found == null) ? null : found.element;
    }
    /** search the element giving the key */
    public BinaryNode search(BinaryNode start, T elem) {
        if (start == null) {
            return null;
        }
        int comparision = start.element.compareTo(elem);
        if (comparision == 0) {
            return start;
        } else if (comparision > 0) {
            return search(start.left, elem);
        } else {
            return search(start.right, elem);
        }
    }
    public BinaryNode search_iterative(BinaryNode x,T elem) {
        while (x != null && x.element.compareTo(elem) != 0) {
            if (x.element.compareTo(elem) > 0)
                x = x.left;
            else
                x = x.right;
        }
        return x;
    }


    /**
     * Inserts an element into the BST, unless it is already stored.
     * O(h).
     */
    public boolean insert(T elem) {
        return insert(root, elem);
    }
    /** This method inserts an element into the BST, unless it is already stored.**/
    public boolean insert(BinaryNode start, T elem) {
        // We've reached the point of insertion
        if (start == null) {
            // Insert our element into a new node
            root = new BinaryNode(elem, null, null);
            return true;
        }

        int comparison = start.element.compareTo(elem);

        if (comparison > 0) {
            if (start.left == null) {
                start.left = new BinaryNode(elem, null, null);
                return true;
            }
            return insert(start.left, elem);
        }
        else if (comparison < 0) {
            if (start.right == null) {
                start.right = new BinaryNode(elem, null, null);
                return true;
            }
            return insert(start.right, elem);
        }
        else {
            // An elem with key equals this.elem is already in the tree.
            return false;
        }
    }
    public boolean insert_iterative(BinaryNode start,T z) {
        BinaryNode y = null;
        BinaryNode x = start;
        int comparison = 0;
        while (x != null) {
            y = x;
            comparison = z.compareTo(x.element);
            if (comparison < 0) {
                x = x.left;
            } else if (comparison > 0) {
                x = x.right;
            } else {
                return false;
            }
        }
        if (y == null) {
            root = new BinaryNode(z, null, null);
            return true;
        }
        if (comparison < 0) {
            y.left = new BinaryNode(z, null, null);
        } else if (comparison > 0) {
            y.right = new BinaryNode(z, null, null);
        } else {
            return false;
        }
        return true;
    }


    /**
     * This method deletes an element from the BST, if it is present.
     */
    public boolean remove(T elem) {
        removalSuccesful = true;
        root = remove(root, elem);
        return removalSuccesful;
    }

    /**
     * Deletes an element from the BST, if it is present. *
     */
    public BinaryNode remove(BinaryNode start, T elem) {
        // If the element we want to delete wasn't found
        if (start == null) {
            // the element we wanted to delete wasn't found
            removalSuccesful = false;
            return null;
        }

        // Compare the current node's element to the element we're looking for
        int comparison = start.element.compareTo(elem);

        // If the deletion will happen somewhere down the left tree
        if (comparison > 0) {
            // Attempt to delete down the left tree
            start.left = remove(start.left, elem);
        }
        // If the deletion will happen somewhere down the right tree
        else if (comparison < 0) {
            // Attempt to delete down the right tree
            start.right = remove(start.right, elem);
        }
        // If we are at the element we want to delete
        else {
            // If the node we want to delete has two children
            if (start.left != null && start.right != null) {
                // Back up pointers
                BinaryNode left = start.left;
                BinaryNode right = start.right;

                // current element<->smallest element in right subtree
                start = moveMin(start.right, start);

                // Back up pointer
                BinaryNode minRight = start.right;

                // Fix pointers
                start.left = left;
                start.right = right;

                // We need to fix start.right if it points to the node we just
                // moved
                if (start.right.element == start.element) {
                    start.right = minRight;
                }
            }
            // If the node we want to delete is a leaf
            else if (start.left == null && start.right == null) {
                // Delete the current node from the tree
                start = null;
            }
            // If the node we want to delete just has a left child
            else if (start.left != null) {
                start = start.left;
            }
            // If the node we want to delete just has a right child
            else {
                start = start.right;
            }
        }
        return start;
    }
    /**
     * find the minimum in sub-tree: start
     */
    public BinaryNode moveMin(BinaryNode start, BinaryNode parent) {
        // If there is nothing to traverse or remove
        if (start == null) {
            return null;
        }
        //found the minimum node, [start.left]
        if (start.left == null) {
            // Rewire nodes
            if (parent != root) {
                parent.left = start.right; //deletedRight;
            }
            return start;
        }
        // Recurse until we get to the minimum node
        return moveMin(start.left, start);
    }



    /** This method returns the tree to an empty state. */
    public void clear() {
        root = null;
    }

    /** This method determines the equality of two BSTs.**/
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        // Make sure a BST was passed in
        if (other instanceof BST) {
            // Attempt to determine the equality of the two BSTs
            try {
                BST<T> compare = (BST<T>) other;
                return equals(root, compare.root);
            }
            // In case the user passes a BST filled with different kind of
            // elements
            catch (Exception e) {
                return false;
            }
        }

        return false;
    }


    /** This method determines the equality of two BSTs. */
    public boolean equals(BinaryNode start1, BinaryNode start2) {
        // If we've reached the end of each tree without any differences
        if (start1 == null && start2 == null) {
            // They are the same
            return true;
        }
        // If we've reached the end of one tree but not the other
        else if (start1 == null || start2 == null) {
            // They are different
            return false;
        }

        // Determine whether the left subtrees are equivalent
        boolean leftSame = equals(start1.left, start2.left);

        // Determine whether the current elements are equivalent
        boolean currentSame = start1.element.equals(start2.element);

        // Determine whether the right subtrees are equivalent
        boolean rightSame = equals(start1.right, start2.right);

        // Return true if everything is equivalent
        return (leftSame && currentSame && rightSame);
    }

    /** This method prints the BST. */
    public void print() {
        print(root,0);
        System.out.println();
    }
    public void print(String order) {
        if(order.equals("inorder"))
            print(root, 0);
        else if(order.equals("preorder"))
            print(root, -1);
        else
            print(root, 1);
        System.out.println();
    }

    /** This heper method prints the BST rooted at the given start node. */
    public void print(BinaryNode start, int order) {
        if (start != null) {
            if (order == -1) {
                System.out.print(start.element+" ");
                print(start.left, order);
                print(start.right, order);
            }else if (order == -1) {
                print(start.left, order);
                print(start.right, order);
                System.out.print(start.element+" ");
            }else{
                print(start.left, order);
                System.out.print(start.element+" ");
                print(start.right, order);
            }
        }
    }
}
