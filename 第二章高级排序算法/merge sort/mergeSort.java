import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;

public class mergeSort {

    private mergeSort() {

    }


    public static void sort(Comparable[] arr) {

        MergeSort(arr,0,arr.length-1);
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


    private static void MergeSort(Comparable[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            MergeSort(arr, l, mid);
            MergeSort(arr, mid + 1, r);
            Merge(arr, l, mid, r);
        } else {
            return;
        }
    }


    public static void main(String[] args) {
        System.out.println("merge sort");

        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100000);

        long startTime=System.nanoTime();
        mergeSort.sort(arr);
        SortTestHelper.printArray(arr);
        System.out.println(SortTestHelper.isSorted(arr));
        long endTime=System.nanoTime();

        System.out.println("程序运行时间： "+(endTime-startTime)+"s");
    }
}
