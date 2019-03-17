public class mergeSortBU {
    private mergeSortBU() {

    }
    private static void Merge(Comparable[] arr, int l, int mid, int r) {
        Comparable [] arr2 = new Comparable[arr.length];
        for(int index = l; index <= r ;index ++){
            arr2[index] = arr[index];
        }

        int i = l, j = mid+1;
        int k = l;
        while (i <= mid && j <= r) {

            if (arr2[i].compareTo(arr2[j]) <= 0) {
                arr[k] = arr2[i];
                i++;
                k++;
            } else if (arr2[i].compareTo(arr2[j]) == 1) {
                arr[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (j > r && i <= mid) {
            arr[k] = arr2[i];
            k++;
            i++;
        }

        while (i > mid && j <= r) {
            arr[k] = arr2[j];
            k++;
            j++;
        }
    }


    public static void sort(Comparable[] arr) {
        int n = arr.length;


        // 从 1 到 2 高层 到底层
        for( int sz = 1; sz < n ; sz *= 2 )
            for( int i = 0 ; i < n - sz ; i += sz+sz )
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    Merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
    }

    public static void main(String[] args) {
        System.out.println("merge sort BU");

        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100000);

        long startTime=System.nanoTime();
        mergeSortBU.sort(arr);
        SortTestHelper.printArray(arr);
        System.out.println(SortTestHelper.isSorted(arr));
        long endTime=System.nanoTime();

        System.out.println("程序运行时间： "+(endTime-startTime)+"s");
    }
}
