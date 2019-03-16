public class bubbleSort {
    private bubbleSort() {

    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for(int j= 0; j< n - 1-i ; j++){
                if(arr[j].compareTo(arr[j+1]) == 1){
                    Comparable temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100000);
        long startTime = System.nanoTime();
        bubbleSort.sort(arr);

        long endTime = System.nanoTime();
        SortTestHelper.printArray(arr);
        System.out.println("bubble sort");
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

    }
}
