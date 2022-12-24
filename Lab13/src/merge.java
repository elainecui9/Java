public class merge {
    public static void merge(int[] a, int start, int mid, int end, int[] temp) {
        int ptr1 = start;
        int ptr2 = mid + 1;
        int resPtr = start;
        while (ptr1 <= mid && ptr2 <= end) {
            System.out.println("" + a[ptr1] + " " + a[ptr2]); // Note this line
            if (a[ptr1] <= a[ptr2]){
                temp[resPtr++] = a[ptr1++];
            }
            else temp[resPtr++] = a[ptr2++];
        }
        if (ptr1 <= mid)
            for (int i = ptr1; i <= mid; i++)
                temp[resPtr++] = a[i];
        else
            for (int i = ptr2; i <= end; i++)
                temp[resPtr++] = a[i];
        System.arraycopy(temp, start, a, start, end - start + 1);
    } // merge
    public static void mergeSort(int[] a, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid, temp);
            mergeSort(a, mid + 1, end, temp);
            merge(a, start, mid, end, temp);
        }
    } // mergeSort
    public static void main(String[] args){
        int[] a = {4, 3, 2, 1};
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length-1, temp);
    }
}
