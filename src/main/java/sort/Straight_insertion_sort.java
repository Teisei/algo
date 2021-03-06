package sort;

import structure.domain.Person;

/**
 * 直接插入排序:O(n*n)
 * Created by dingcheng on 2015/3/10.
 */
public class Straight_insertion_sort implements MySort {
    @Override
    public int[] sort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                int j = i - 1;
                int x = a[i];
                a[i] = a[i - 1];
                while (x < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                    if(j<0)
                        break;
                }
                a[j + 1] = x;
            }
        }
        return a;
    }

    /**
     * Sort Object[]
     */
    @Override
    public void sortObject(Comparable[] a, int n) {
        for (int i = 1; i < n; i++) {
            if (a[i].compareTo(a[i - 1]) <0) {
                int j = i - 1;
                Comparable x = a[i];
                while (x.compareTo(a[j]) <0) {
                    a[j + 1] = a[j];
                    j--;
                    if (j < 0) {
                        break;
                    }
                }
                a[j + 1] = x;
            }
        }
    }

    public static void main(String args[]) {
        MySort mySort = new Straight_insertion_sort();
        int a[] = {3, 1, 5, 7, 2, 4, 9, 6};
        a = mySort.sort(a, 8);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
        }

        System.out.println("\n\n************ test2 *************");
        Person persons[] = new Person[a.length];
        for (int i = 0; i < a.length; i++) {
            persons[i] = new Person(""+a[i]);
        }
        mySort.sortObject(persons, persons.length - 1);
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].getName());
        }
    }
}
