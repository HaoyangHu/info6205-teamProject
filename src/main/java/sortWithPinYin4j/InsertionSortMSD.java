package sortWithPinYin4j;



public class InsertionSortMSD {
    public static void sort(String[][] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j][0], a[j - 1][0], d); j--)
                swap(a, j, j - 1);
    }

    static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static void swap(Object[][] a, int j, int i) {
        Object temp = a[j][0];
        a[j][0] = a[i][0];
        a[i][0] = temp;

        Object temp1 = a[j][1];
        a[j][1] = a[i][1];
        a[i][1] = temp1;

    }
}
