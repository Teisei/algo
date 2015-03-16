package structure.tree;

import structure.Tree.BST;

/**
 * Created by dingcheng on 2015/3/16.
 */
public class Test_BST {
    public static void main(String args[]) {
        Integer[] nums = new Integer[10];
        nums[0] = 5;
        nums[1] = 2;
        nums[2] = 9;
        nums[3] = 1;
        nums[4] = 1;
        nums[5] = 6;
        nums[6] = 7;
        nums[7] = 8;
        nums[8] = 3;
        nums[9] = 4;

        BST<Integer> tree = new BST<Integer>();

        tree.insert(nums[0]);
        tree.print();
        System.out.println("**************************");
        tree.insert(nums[1]);
        tree.print();
        System.out.println("**************************");
        tree.insert(nums[2]);
        tree.print();
        System.out.println("**************************");
        tree.insert(nums[3]);
        tree.print();
        System.out.println("**************************");
        tree.insert(nums[4]);
        tree.print();
        System.out.println("**************************");
        tree.insert(nums[5]);
        tree.print();
        System.out.println("**************************");
        tree.insert(nums[6]);
        tree.print();
        System.out.println("**************************");
        tree.insert(nums[7]);
        tree.print();
        System.out.println("**************************");
        tree.insert(nums[8]);
        tree.print();
        System.out.println("**************************");
        tree.insert(nums[9]);
        tree.print();
        System.out.println("**************************");
        BST.BinaryNode node = tree.search(nums[3]);
        tree.delete(node);
        tree.print();
        System.out.println("**************************");
        BST.BinaryNode node2 = tree.search(nums[7]);
        tree.delete(node2);
        tree.print();
        System.out.println("**************************");


    }
}
