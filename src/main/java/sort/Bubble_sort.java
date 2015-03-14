package sort;

/**
 * 冒泡排序：O(n*n),稳定
 * Created by dingcheng on 2015/3/11.
 */
public class Bubble_sort implements MySort {
    @Override
    public int[] sort(int[] a, int n) {
        int end = n - 1;
        while (end > 0) {
            int pos = 0;
            for (int j = 0; j < end; j++) {
                if (a[j] > a[j + 1]) {//増序
                    pos = j;
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
            end = pos;
        }
        return a;
    }

    public int[] Bubble_2(int r[], int n) {
        int low = 0;
        int high = n - 1; //设置变量的初始值
        int tmp, j;
        while (low < high) {
            for (j = low; j < high; ++j) //正向冒泡,找到最大者
                if (r[j] > r[j + 1]) {
                    tmp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = tmp;
                }
            --high;                 //修改high值, 前移一位
            for (j = high; j > low; --j) //反向冒泡,找到最小者
                if (r[j] < r[j - 1]) {
                    tmp = r[j];
                    r[j] = r[j - 1];
                    r[j - 1] = tmp;
                }
            ++low;                  //修改low值,后移一位
        }
        return r;
    }

    public static void main(String args[]) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        Bubble_sort mysort = new Bubble_sort();
//        int[] b = mysort.sort(a, a.length);
        int[] b = mysort.Bubble_2(a, a.length);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "  ");
        }
    }
}
