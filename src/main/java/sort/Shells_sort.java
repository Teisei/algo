package sort;

/**
 * 希尔排序:O(n^1.2)
 * Created by dingcheng on 2015/3/10.
 */
public class Shells_sort implements MySort {
    public int[] sort(int[] a, int n) {
        /* 步长 */
        for (int gap = n / 2; gap > 0; gap /= 2) {
            /* 直接插入排序 */
            for (int start = 0; start < gap; start++) {
                /* 每一组进行插入排序 */
                for (int j = start + gap; j < n; j += gap) {
                    if (a[j] < a[j - gap]) {
                        //从 j 往前
                        int temp = a[j];
                        int k = j - gap;
                        while (k >= 0 && temp < a[k]) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        //结束之后，将a[j]定位
                        a[k + gap] = temp;
                    }
                }
            }
        }
        return a;
    }

    public static void main(String args[]) {
//        int[] a = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MySort mySort = new Shells_sort();
        a = mySort.sort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
        }
    }
}
