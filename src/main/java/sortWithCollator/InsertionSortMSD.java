package sortWithCollator;

import java.text.Collator;
import java.util.Locale;

public class InsertionSortMSD {
    public static void sort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                swap(a, j, j - 1);
    }

    /*static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }*/

    private static Collator collator = Collator.getInstance(Locale.CHINA);

    private static boolean less(String v, String w, int d) {
        int res = collator.compare(v.substring(d) , w.substring(d));
        return res >= 0 ? false : true;
    }

    private static void swap(Object[] a, int j, int i) {
        Object temp = a[j];
        a[j] = a[i];
        a[i] = temp;

    }
}
