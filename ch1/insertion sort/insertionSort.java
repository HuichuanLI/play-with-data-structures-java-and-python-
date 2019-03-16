public class insertionSort {
    // 我们的算法类不允许产生任何实例
    private insertionSort() {

    }


    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 寻找arr[i]位置
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {


        System.out.println("insert sort");
        long startTime = System.nanoTime();
        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100000);
        insertionSort.sort(arr);
        long endTime = System.nanoTime();


        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
        SortTestHelper.printArray(arr);
        System.out.println(SortTestHelper.isSorted(arr));
    }
}
