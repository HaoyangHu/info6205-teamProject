package sortWithCollator;


import preprocess.NameData;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class TimSort {

    static String[] names;
    static int len;

    public static void init() {
        len = NameData.len;
        names = new String[len];
        for (int i = 0; i < len; i++) {
            names[i] = NameData.namesArray[i][1];
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
        int res = collator.compare(a, b);
        return res < 0 ? true : false;
    }

    public static void insertionSort(String[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            String temp = arr[i];
            int j = i - 1;
            while (j >= left && less(temp, arr[j])) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void merge(String[] arr, int l,
                             int m, int r) {

        int len1 = m - l + 1, len2 = r - m;
        String[] left = new String[len1];
        String[] right = new String[len2];
        for (int x = 0; x < len1; x++) {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++) {
            right[x] = arr[m + 1 + x];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < len1 && j < len2) {
            if (less(left[i], right[j]) || left[i].equals(right[j])) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }


    public static void sort(String[] arr, int n) {
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

    public static void printArray(String[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        init();
        System.out.println("Start sorting");
        sort(names, names.length);

        System.out.println("After Sorting Array is");
        printArray(names, names.length);
    }


    private static Collator collator = Collator.getInstance(Locale.CHINA);


}
