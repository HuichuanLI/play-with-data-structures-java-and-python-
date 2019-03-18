public class quickSortImprovement {
    private quickSortImprovement() {

    }

    public static void quicksort(Comparable[] arr, int l, int r) {
        if(l>=r)
            return;

//         添加随机快速排序 (Math.random()*(l-r+1))+l
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );
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
}
