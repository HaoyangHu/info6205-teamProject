package sortWithPinYin4j;

import preprocess.IsSorted;
import preprocess.NameData;

import java.util.Arrays;

public class TimeSort {
    static String[][] names;
    static int len;

    public static void init() {
        len = NameData.len;
        names = new String[len][2];
        for (int i = 0; i < len; i++) {
            names[i][0] = NameData.namesArray[i][0];
            names[i][1] = NameData.namesArray[i][1];
        }

    }


    static int MIN_MERGE = 32;

    public static int minRunLength(int n) {
        assert n >= 0;

        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static boolean less(String a, String b) {
        int res = a.compareTo(b);
        return res < 0;
    }

    public static void insertionSort(String[][] arr, int left,
                                     int right) {
        for (int i = left + 1; i <= right; i++) {
            String temp = arr[i][0];
            String tempName = arr[i][1];
            int j = i - 1;
            while (j >= left && less(temp, arr[j][0])) {
                arr[j + 1][0] = arr[j][0];
                arr[j + 1][1] = arr[j][1];
                j--;
            }
            arr[j + 1][0] = temp;
            arr[j + 1][1] = tempName;
        }
    }

    public static void merge(String[][] arr, int l,
                             int m, int r) {

        int len1 = m - l + 1, len2 = r - m;
        String[][] left = new String[len1][2];
        String[][] right = new String[len2][2];
        for (int x = 0; x < len1; x++) {
            left[x][0] = arr[l + x][0];
            left[x][1] = arr[l + x][1];
        }
        for (int x = 0; x < len2; x++) {
            right[x][0] = arr[m + 1 + x][0];
            right[x][1] = arr[m + 1 + x][1];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < len1 && j < len2) {
            if (less(left[i][0], right[j][0]) || left[i][0].equals(right[j][0])) {
                arr[k][0] = left[i][0];
                arr[k][1] = left[i][1];
                i++;
            } else {
                arr[k][0] = right[j][0];
                arr[k][1] = right[j][1];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k][0] = left[i][0];
            arr[k][1] = left[i][1];
            k++;
            i++;
        }

        while (j < len2) {
            arr[k][0] = right[j][0];
            arr[k][1] = right[j][1];
            k++;
            j++;
        }
    }

    public static void sort(String[][] arr, int n) {
        int minRun = minRunLength(MIN_MERGE);

        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i,
                    Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        for (int size = minRun; size < n; size = 2 * size) {


            for (int left = 0; left < n;
                 left += 2 * size) {


                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),
                        (n - 1));

                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    public static void printArray(String[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i][1] + " ");
        }
        System.out.print("\n");
    }

        public static void main(String[] args){
            init();
            System.out.println("Start sorting");
            sort(names, names.length);

            printArray(names, names.length);
        }

}

