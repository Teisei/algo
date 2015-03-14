package sort;

import structure.domain.Person;

/**
 * MergeSort:
 * Created by dingcheng on 2015/3/11.
 */
public class Merge_sort implements MySort {

    public static int[] a_copy;
    public static Comparable[] a_copy2;
    protected static boolean isDes;//是否是降序

    public Merge_sort(int[] a, boolean isDes) {
        a_copy = new int[a.length];
        this.isDes = isDes;
    }

    /* 増序 */
    public void sort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(a, start, mid);
            sort(a, mid + 1, end);
            merge(a, start, end);
        }
    }
    /* merge */
    public void merge(int[] a, int start, int end) {
        int cursor = start;
        int cursor1 = start;
        int cursor2 = (start + end) / 2 + 1;
        while (cursor1 <= (start + end) / 2 && cursor2 <= end) {
            if (isDes) {
                if (a[cursor1] >= a[cursor2]) {
                    a_copy[cursor++] = a[cursor1++];
                } else {
                    a_copy[cursor++] = a[cursor2++];
                }
            } else {
                if (a[cursor1] <= a[cursor2]) {
                    a_copy[cursor++] = a[cursor1++];
                } else {
                    a_copy[cursor++] = a[cursor2++];
                }
            }
        }
        while (cursor1 <= (start + end) / 2)
            a_copy[cursor++] = a[cursor1++];
        while (cursor2 <= end)
            a_copy[cursor++] = a[cursor2++];
        for (int i = start; i <= end; i++) {
            a[i] = a_copy[i];
        }
    }

    /* 増序 */
    public void sort(Comparable[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(a, start, mid);
            sort(a, mid + 1, end);
            merge(a, start, end);
        }
    }
    /* merge */
    public void merge(Comparable[] a, int start, int end) {
        int cursor = start;
        int cursor1 = start;
        int cursor2 = (start + end) / 2 + 1;
        while (cursor1 <= (start + end) / 2 && cursor2 <= end) {
            if (isDes) {
                if (a[cursor1].compareTo(a[cursor2]) >= 0) {
                    a_copy2[cursor++] = a[cursor1++];
                } else {
                    a_copy2[cursor++] = a[cursor2++];
                }
            } else {
                if (a[cursor1].compareTo(a[cursor2]) <= 0) {
                    a_copy2[cursor++] = a[cursor1++];
                } else {
                    a_copy2[cursor++] = a[cursor2++];
                }
            }
        }
        while (cursor1 <= (start + end) / 2)
            a_copy2[cursor++] = a[cursor1++];
        while (cursor2 <= end)
            a_copy2[cursor++] = a[cursor2++];
        for (int i = start; i <= end; i++) {
            a[i] = a_copy2[i];
        }
    }


    @Override
    public int[] sort(int[] a, int n) {
        a_copy = new int[a.length];
        sort(a, 0, a.length - 1);
        return a;
    }

    @Override
    public void sortObject(Comparable[] a, int n) {
        a_copy2 = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void main(String args[]) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        boolean isDes = false;//是否是降序
        Merge_sort mysort = new Merge_sort(a, isDes);
        mysort.sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }


        System.out.println("\n\n************ test2 *************");
        Person persons[] = new Person[a.length];
        for (int i = 0; i < a.length; i++) {
            persons[i] = new Person(""+a[i]);
        }
        mysort.sortObject(persons, persons.length - 1);
        for (int i = 0; i < persons.length; i++) {
            System.out.print(persons[i].getName()+"  ");
        }
    }
}
