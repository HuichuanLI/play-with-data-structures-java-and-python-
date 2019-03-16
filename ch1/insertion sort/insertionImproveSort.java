public class insertionImproveSort {

    private insertionImproveSort() {

    }
    // 每次 需要找到 arr[i]这个位置 先不交换 找到位置在交换
    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 寻找arr[i]位置
            Comparable postion = arr[i];
            for (int j = i; j > 0; j--) {
                if(arr[j].compareTo(arr[j-1])==-1){
                    arr[j] = arr[j-1];
                }
                // 最终放入进去
                arr[j] = postion;
            }
        }
    }

    public static void main(String[] args) {


        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100000);
        Integer[] arr2 = arr;
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



        System.out.println(SortTestHelper.isSorted(arr));
    }

}
