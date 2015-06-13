package heap;

/**
 * Created by Teisei on 2015/3/30.
 * @author Teisei
 * @version 1.0
 */
public class SinglePriorityHeap extends SingleHeap {

    int _MIN_INT_ = -10000;

    public SinglePriorityHeap() {
        super(new int[]{-1}, 0);
    }

    /**
     *  O(1)
     */
    public int HEAP_MAXIMUN() {
        return a[1];
    }

    /**
     *  O(lg n)
     */
    public int HEAP_EXTRACT_MAX() {
        if (_Heap_Size_ < 1) {
            System.out.println("ERROR: HEAP UNDERFLOW!");
            return -1;
        }
        int max = a[1];
        a[1] = a[_Heap_Size_];
        _Heap_Size_ -= 1;
        MAX_HEAPIFY(1);
        return max;
    }
    /**
     *  O(lg n)
     */
    public void HEAP_INCREASE_KEY(int i, int key) {
        if (key < a[i]) {
            System.out.println("ERROR: NEW KEY IS SMALLER THAN CURRENT KEY!");
            return;
        }
        a[i] = key;
        while (i > 1 && a[getParent(i)] < a[i]) {
            int tmp = a[i];
            a[i] = a[getParent(i)];
            a[getParent(i)] = tmp;
            i = getParent(i);
        }
    }

    /**
     *  O(lg n)
     */
    public void MAX_HEAP_INSERT(int key) {
        _Heap_Size_ += 1;
        a = extendArray(a);
        a[_Heap_Size_] = _MIN_INT_;
        HEAP_INCREASE_KEY(_Heap_Size_, key);
    }

    public int[] extendArray(int[] a) {
        int[] res = new int[a.length + 1];
        System.arraycopy(a, 0, res, 0, a.length);
        return res;
    }


    public static void main(String args[]) {
        int[] sort = new int[]{-1,10, 20, 3, 5, 6, 4, 9, 8, 12, 17, 34, 11};
        SinglePriorityHeap heap = new SinglePriorityHeap();
        for (int i = 1; i < sort.length; i++) {
            heap.MAX_HEAP_INSERT(sort[i]);
            System.out.println("print max:"+heap.HEAP_MAXIMUN());
        }
//        System.out.println(heap.HEAP_MAXIMUN());
//
        heap.MAX_HEAP_INSERT(100);
        System.out.println("print max:"+heap.HEAP_MAXIMUN());

        heap.print();

        System.out.println("extract max:"+heap.HEAP_EXTRACT_MAX());
        heap.print();
        System.out.println("print max:"+heap.HEAP_MAXIMUN());
        heap.MAX_HEAP_INSERT(100);
        System.out.println("print max:"+heap.HEAP_MAXIMUN());
//        System.out.println(heap.HEAP_MAXIMUN());
//
//        heap.print();

    }}
