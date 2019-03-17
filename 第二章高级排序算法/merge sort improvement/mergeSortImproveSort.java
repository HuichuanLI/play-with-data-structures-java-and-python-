public class mergeSortImproveSort {

    // 为什么要改善 归并排序 因为 如果 就是 merge 排序 近乎 排序，merge 可以排序更快
    private mergeSortImproveSort() {

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
        // 或者这里 l-r 使用插入排序
        if (l < r) {
            int mid = (l + r) / 2;
            MergeSort(arr, l, mid);
            MergeSort(arr, mid + 1, r);

            // *** 这里 非常重要 如果 保证 arr[mid] < arr[mid+1]
            if(arr[mid].compareTo(arr[mid+1]) == 1){
                Merge(arr, l, mid, r);
            }

        } else {
            return;
        }
    }



}
