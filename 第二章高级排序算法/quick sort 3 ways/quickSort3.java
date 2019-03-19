public class quickSort3 {
    private quickSort3() {
    }

    public static Comparable[] sort(Comparable[] arr) {

        quicksort(arr, 0, arr.length - 1);
        return arr;
    }


    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    // 为什么要映入 三路 快速排序 目的就是为了解决 重复数字
    // 妈的 就是 2 路 排序 的下一步
    private static void quicksort(Comparable[] arr, int l, int r) {
        if(l>r){
            return;
        }

        Comparable v = arr[l];
        int lt = l;
        int gt = r + 1;
        int i = l + 1; // [lt+1 ... 1]
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr,i,lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        quicksort(arr, l, lt - 1);
        quicksort(arr, gt, r);

    }

    public static void main(String[] args) {
        System.out.println("quick sort2");

        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100000);

        long startTime = System.nanoTime();
        quickSort2.quicksort(arr,0,arr.length-1);
        SortTestHelper.printArray(arr);

        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

        System.out.println("quick sort 3 ways");
        startTime = System.nanoTime();
        quickSort3.quicksort(arr,0,arr.length-1);
        SortTestHelper.printArray(arr);
        endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");


        System.out.println("merge sort");
        startTime = System.nanoTime();
        mergeSort.sort(arr);
        SortTestHelper.printArray(arr);
        endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");


        System.out.println("quick sort random");
        startTime = System.nanoTime();
        quickSortImprovement.quicksort(arr, 0, arr.length - 1);
        SortTestHelper.printArray(arr);
        endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");


    }


}
