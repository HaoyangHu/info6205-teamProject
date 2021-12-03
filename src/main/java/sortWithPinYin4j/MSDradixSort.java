package sortWithPinYin4j;

import preprocess.NameData;

public class MSDradixSort {
    private static final int R             = 256;   // extended ASCII alphabet size
    private static final int CUTOFF        =  15;   // cutoff to insertion sort
    static String[][] names;
    static int len;
    public static void init(){
        len = NameData.len;
        names = new String[len][2];
        for(int i = 0; i < len; i++){
            names[i][0] = NameData.namesArray[i][0];
            names[i][1] = NameData.namesArray[i][1];
        }
    }
    /**
     * Rearranges the array of extended ASCII strings in ascending order.
     *
     * @param a the array to be sorted
     */
    public static void sort(String[][] a) {
        int n = a.length;
        String[][] aux = new String[n][2];
        sort(a, 0, n-1, 0, aux);
    }

    private static int charAt(String s, int d) {

        if (d >= s.length()) return -1;
        return s.charAt(d);
    }

    // sort from a[lo] to a[hi], starting at the dth character
    private static void sort(String[][] a, int lo, int hi, int d, String[][] aux) {
        // cutoff to insertion sort for small subarrays
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }
        // compute frequency counts
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i][0], d);
            count[c+2]++;
        }
        // transform counts to indicies
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];
        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i][0], d);
            aux[count[c+1]++] = a[i];
        }
        // copy back
        for (int i = lo; i <= hi; i++){
            a[i][0] = aux[i - lo][0];
            a[i][1] = aux[i - lo][1];
        }



        // recursively sort for each character (excludes sentinel -1)
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
    }

    // insertion sort a[lo..hi], starting at dth character
    private static void insertion(String[][] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j][0], a[j-1][0], d); j--)
                exch(a, j, j-1);
    }

    // exchange a[i] and a[j]
    private static void exch(String[][] a, int i, int j) {
        String temp = a[i][0];
        a[i][0] = a[j][0];
        a[j][0] = temp;
        String temp1 = a[i][1];
        a[i][1] = a[j][1];
        a[j][1] = temp1;
    }

    // is v less than w, starting at character d
    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }


    public static void main(String[] args) {
        init();
        sort(names);
        for(int i = 0; i < 100; i++){
            System.out.println(names[i][0]);
        }
    }

}
