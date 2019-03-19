public class quickSort2 {

    private quickSort2() {

    }


    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 为什么要映入 两路 快速排序 目的就是为了解决 重复数字
    private static int partation(Comparable[] arr, int l, int r) {

        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        int i = l + 1;
        int j = r;
        Comparable v = arr[l];
        while (true) {

            // 双路快速排序 从头到尾巴
            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }
            // 从后面到前面
            while (j >= l + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;

        }
        swap(arr, l, j);
        return j;
    }


    public static void quicksort(Comparable[] arr, int l, int r) {
        if (l > r) {
            return;
        } else {
            int postion = partation(arr, l, r);
            quicksort(arr, l, postion - 1);
            quicksort(arr, postion + 1, r);
        }
    }

    public static void main(String[] args) {
        System.out.println("quick sort2");

        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100000);
        long startTime = System.nanoTime();

        quickSort2.quicksort(arr, 0, arr.length - 1);
        SortTestHelper.printArray(arr);
        long endTime = System.nanoTime();
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
