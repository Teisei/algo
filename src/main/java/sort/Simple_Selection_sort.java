package sort;

import structure.domain.Person;

/**
 * 简单选择排序:O(n*n)
 * Created by dingcheng on 2015/3/10.
 */
public class Simple_Selection_sort implements MySort {

    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();
    }
    public int[] sort(int[] a, int n, boolean isB) {
        for (int i = 0; i < n/2; i++) {
            int min_index = i;
            int max_index = n - 1 - i;
            System.out.println("<"+min_index+","+max_index+">");

            for (int j = i; j < n - i; j++) {
                if (a[j] < a[min_index]) {
                    min_index = j;
                }else if (a[j] > a[max_index]) {
                    max_index = j;
                }
            }
            int temp;
            //swap
            temp = a[min_index];
            a[min_index] = a[i];
            a[i] = temp;
            if (i == max_index) {
                max_index = min_index;
            }
            temp = a[max_index];
            a[max_index] = a[n - 1 - i];
            a[n - 1 - i] = temp;

            print(a);
        }
        return a;
    }

    @Override
    public int[] sort(int[] a, int n) {
        for (int i = 0; i < n/2; i++) {
            int min_index = i;
            int max_index = n - 1 - i;

            for (int j = i; j < n - i; j++) {
                if (a[j] < a[min_index])
                    min_index = j;
                else if (a[j] > a[max_index])
                    max_index = j;
            }
            int temp;
            //swap
            temp = a[min_index];a[min_index] = a[i];a[i] = temp;
            if (i == max_index)
                max_index = min_index;
            //swap
            temp = a[max_index];a[max_index] = a[n - 1 - i];a[n - 1 - i] = temp;
        }
        return a;
    }

    @Override
    public void sortObject(Comparable[] a, int n) {
        for (int i = 0; i < n/2; i++) {
            int min_index = i;
            int max_index = n - 1 - i;

            for (int j = i; j < n - i; j++) {
                if (a[j].compareTo(a[min_index]) < 0)
                    min_index = j;
                else if (a[j].compareTo(a[max_index]) > 0)
                    max_index = j;
            }
            Comparable temp;
            //swap
            temp = a[min_index];a[min_index] = a[i];a[i] = temp;
            if (i == max_index)
                max_index = min_index;
            //swap
            temp = a[max_index];a[max_index] = a[n - 1 - i];a[n - 1 - i] = temp;
        }
    }

    public static void main(String args[]) {
        //        int[] a = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        int[] a = {1, 9, 3, 10, 7, 6, 5, 4, 2, 8};
        Simple_Selection_sort mySort = new Simple_Selection_sort();
//        a = mySort.sort(a, a.length, true);
        a = mySort.sort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }

        System.out.println("\n\n************ test2 *************");
        Person persons[] = new Person[a.length];
        for (int i = 0; i < a.length; i++) {
            persons[i] = new Person(""+a[i]);
        }
        mySort.sortObject(persons, persons.length - 1);
        for (int i = 0; i < persons.length; i++) {
            System.out.print(persons[i].getName()+"  ");
        }
    }
}
