package sortWithCollator;

import preprocess.IsSorted;
import preprocess.Name;
import preprocess.NameData;

import java.text.Collator;
import java.util.Locale;

public class DualPivotQuickSort {
    static String[] names;
    static int len;
    public static void init(){
        len = NameData.len;
        System.out.println(len);
        names = new String[len];
        for(int i = 0; i < len; i++){
            names[i] = NameData.names.get(i).name;
        }
    }
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        if (less(a[hi], a[lo])) exch(a, lo, hi);
        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;
        while (i <= gt) {
            if       (less(a[i], a[lo])) exch(a, lt++, i++);
            else if  (less(a[hi], a[i])) exch(a, i, gt--);
            else                         i++;
        }
        exch(a, lo, --lt);
        exch(a, hi, ++gt);
        sort(a, lo, lt-1);
        if (less(a[lt], a[gt])) sort(a, lt+1, gt-1);
        sort(a, gt+1, hi);
    }
    private static Collator collator = Collator.getInstance(Locale.CHINA);
    private static boolean less(Comparable v, Comparable w) {
        int res = collator.compare(v , w);
        return res >= 0 ? false : true;
    }
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        init();
        System.out.println("Begin sorting");
        sort(names);
        int count = 0;
        for(String n : names){
            System.out.println(count + " " + n);
            count++;

        }
        //System.out.println(IsSorted.isSorted(names));
    }

}
