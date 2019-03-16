public class shellSort {

    private shellSort() {

    }

    public static void sort(Comparable[] arr) {

//  希尔排序（ShellSort）也称增量递减排序算法，即跨多步版的InsertionSort，是InsertionSort基础上的改进版。
//  InsertionSort可以看作ShellSort中gap=1的特例。希尔排序是非稳定排序算法。
//  步长 <> 1  每次 步长递减 直到 1

        int n = arr.length;

        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {

            // h-sort the array
            for (int i = h; i < n; i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for ( ; j >= h && e.compareTo(arr[j-h]) < 0 ; j -= h)
                    arr[j] = arr[j-h];
                arr[j] = e;
            }

            h /= 3;
        }
    }

    public static void main(String[] args) {


        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100000);
        Integer[] arr2 = arr;
        Integer[] arr3 = arr;

        long startTime = System.nanoTime();
        insertionImproveSort.sort(arr);
        long endTime = System.nanoTime();
        System.out.println("insert sort improvement");
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
        startTime = System.nanoTime();
        insertionSort.sort(arr2);
        endTime = System.nanoTime();
        System.out.println("insert sort");
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
        startTime = System.nanoTime();
        shellSort.sort(arr2);
        endTime = System.nanoTime();
        System.out.println("shell sort");
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");





        System.out.println(SortTestHelper.isSorted(arr));
    }

}
