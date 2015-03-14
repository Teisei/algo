package sort;

/**
 * Created by dingcheng on 2015/3/10.
 */
public class Heap_sort implements MySort {
    private static int[] sort = new int[]{1, 0, 10, 20, 3, 5, 6, 4, 9, 8, 12, 17, 34, 11};

    private static void buildMaxHeapify(int[] data){
        //没有子节点的才需要创建最大堆，从最后一个的父节点开始
        int startIndex = getParentIndex(data.length - 1);
        //从尾端开始创建最大堆，每次都是正确的堆
        for (int i = startIndex; i >= 0; i--) {
            maxHeapify(data, data.length, i);
        }
    }

    private static void buildMaxHeapify(int[] data, int last) {
        //没有子节点的才需要创建最大堆，从最后一个的父节点开始
        int startIndex = getParentIndex(last);
        //从尾端开始创建最大堆，每次都是正确的堆
        for (int i = startIndex; i >= 0; i--) {
            maxHeapify(data, last+1, i);
        }
    }

    /**
     * 创建最大堆
     * @param data
     * @param heapSize 需要创建最大堆的大小，一般在sort的时候用到，因为最多值放在末尾，末尾就不再归入最大堆了
     * @param index 当前需要创建最大堆的位置。（某个父节点）
     */
    private static void maxHeapify(int[] data, int heapSize, int index) {
        // 当前点与左右子节点比较
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        int largest = index;
        if (left < heapSize && data[index] < data[left]) {
            largest = left;
        }
        if (right < heapSize && data[largest] < data[right]) {
            largest = right;
        }
        //得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整
        if (largest != index) {
            int temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeapify(data, heapSize, largest);
        }
    }

    /* 排序，最大值放在末尾，data虽然是最大堆，在排序后就成了递增的 */
    private static void heapSort(int[] data, int n) {
        //末尾与头交换，交换后调整最大堆
        for (int i = n; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeapify(data, i, 0);
        }
    }

    /* 弹出堆顶元素 */
    private static int pop(int[] data, int n) {
        int res = data[0];
        data[0] = data[n];
        buildMaxHeapify(data, n-1);
        heapSort(data, n-1);
        return res;
    }

    /* 父节点位置 */
    private static int getParentIndex(int current){
        return (current - 1) >> 1;
    }

    /* 左子节点position注意括号，加法优先级更高 */
    private static int getChildLeftIndex(int current){
        return (current << 1) + 1;
    }

    /* 右子节点position */
    private static int getChildRightIndex(int current){
        return (current << 1) + 2;
    }

    private static void print(int[] data){
        int pre = -2;
        for (int i = 0; i < data.length; i++) {
            if (pre < (int)getLog(i+1)) {
                pre = (int)getLog(i+1);
                System.out.println();
            }
            System.out.print(data[i] + " |");
        }
    }

    /* 以2为底的对数 */
    private static double getLog(double param){
        return Math.log(param)/Math.log(2);
    }

    @Override
    public int[] sort(int[] a, int n) {
        buildMaxHeapify(a);
        heapSort(a, a.length-1);
        return a;
    }

    @Override
    public void sortObject(Comparable[] a, int n) {

    }

    public static void main(String args[]) {
//        int sort[] = {0, 2, 1};
        System.out.println("\n*********************");
        print(sort);
        buildMaxHeapify(sort);
        System.out.println("\n*********************");
        print(sort);
        heapSort(sort, sort.length - 1);
        System.out.println("\n*********************");
        print(sort);

        System.out.println("\n*********************");
        int res = pop(sort, sort.length - 1);
        System.out.println("pop() = " + res);
        print(sort);
    }
}
