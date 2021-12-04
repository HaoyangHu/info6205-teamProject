package sortWithCollator;

import preprocess.MakeMSD;
import preprocess.NameData;

import java.util.Map;

public class MSDradixSort {
    private static int R;   // extended ASCII alphabet size
    private static final int CUTOFF = 15;   // cutoff to insertion sort

    static String[] names;

    static Map<Character, Integer> map;
    static{
        map = MakeMSD.getMap();
        R = map.size();
    }
    public static void sort(int len){
        String arr[][] = new NameData().getNamesArray();
        names = new String[len];
        if(len <= 1000000){
            for(int i = 0; i < len; i++){
                names[i] = arr[i][1];
            }
        }else{
            if(len == 2000000){
                for(int i = 0; i < 1000000; i++){
                    names[i] = arr[i][1];
                }
                for(int i = 1000000; i < 2000000; i++){
                    names[i] = arr[i - 1000000][1];
                }
            }else{
                for(int i = 0; i < 1000000; i++){
                    names[i] = arr[i][1];
                }
                for(int i = 1000000; i < 2000000; i++){
                    names[i] = arr[i - 1000000][1];
                }
                for(int i = 2000000; i < 4000000; i++){
                    names[i] = names[i - 2000000];
                }
            }
        }
        sort(names);
    }

    /**
     * Rearranges the array of extended ASCII strings in ascending order.
     *
     * @param a the array to be sorted
     */
    public static void sort(String[] a) {
        int n = a.length;
        String[] aux = new String[n];
        sort(a, 0, n-1, 0, aux);
    }

    // return dth character of s, -1 if d = length of string
    public static int charAt(String s, int d){
        if(d < s.length()){
            return map.get(s.charAt(d));
        }
        return -1;
    }

    // sort from a[lo] to a[hi], starting at the dth character
    private static void sort(String[] a, int lo, int hi, int d, String[] aux) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        // compute frequency counts
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c+2]++;
        }

        // transform counts to indicies
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }
        // copy back
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        // recursively sort for each character (excludes sentinel -1)
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
    }


    // insertion sort a[lo..hi], starting at dth character
    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++){
            for (int j = i; j > lo ; j--){
                if(less(a[j], a[j-1], d)) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // is v less than w, starting at character d
    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (charAt(v, i) < charAt(w, i)) return true;
            if (charAt(v, i) > charAt(w, i)) return false;
        }
        return v.length() < w.length();
    }


    public static void main(String[] args) {

        sort(4000000);
        for(String s : names){
            System.out.println(s);
        }
    }

}
