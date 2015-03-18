package structure.tree;

import org.junit.Test;
import structure.Tree.RBT;

import java.util.Date;

/**
 * test Red Black Tree.
 * Created by dingcheng on 2015/3/16.
 */
public class Test_RBT {
    @Test
    public void testRBT() {
        int N = 50;
        Integer[] nums = new Integer[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i;
        }
        RBT<Integer> tree2 = new RBT<Integer>();
        Date start;
        System.out.println("############### insert RBT ###############");
        start = new Date();
        for (int i = 0; i < nums.length; i++) {
            tree2.insert(nums[i]);
            if (i % 10 == 0) {
            }
        }
        System.out.println("Root: "+tree2.root.element);
        System.out.println(new Date().getTime() - start.getTime());

        System.out.println("############### search RBT ###############");
        start = new Date();
        for (int i = 0; i < nums.length; i++) {
            tree2.search(nums[i]);
        }
        System.out.println(new Date().getTime() - start.getTime());
        System.out.println("############### delete RBT ###############");
        start = new Date();
        for (int i = 0; i < nums.length; i++) {
            tree2.delete(nums[i]);
        }
        System.out.println(new Date().getTime() - start.getTime());
    }
}
