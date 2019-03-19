public class quickSort {

    private quickSort() {

    }

    public static void quicksort(Comparable[] arr, int l, int r) {
        if(l>=r)
            return;
        int positon = partition(arr, l, r);
        quicksort(arr, l, positon - 1);
        quicksort(arr, positon + 1, r);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        System.out.println("quick sort");
        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100000);

        long startTime=System.nanoTime();
        quickSort.quicksort(arr,0,arr.length-1);
        SortTestHelper.printArray(arr);
        long endTime=System.nanoTime();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");

        System.out.println("merge sort");
        startTime=System.nanoTime();
        mergeSort.sort(arr);
        SortTestHelper.printArray(arr);
        endTime=System.nanoTime();



        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");

    }
}