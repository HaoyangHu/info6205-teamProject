package sortWithPinYin4j;

import preprocess.IsSorted;
import preprocess.NameData;

public class ThreeWayStringQuicksort {
    static final int R = 256;
    private static final int CUTOFF = 15;
    static String[][] names;
    static int len;

    public static void init(int len){
        String arr[][] = new NameData().getNamesArray();
        names = new String[len][2];
        if(len <= 1000000){
            for(int i = 0; i < len; i++){
                names[i][0] = arr[i][0];
                names[i][1] = arr[i][1];
            }
        }else{
            if(len == 2000000){
                for(int i = 0; i < 1000000; i++){
                    names[i][0] = arr[i][0];
                    names[i][1] = arr[i][1];
                }
                for(int i = 1000000; i < 2000000; i++){
                    names[i][0] = arr[i - 1000000][0];
                    names[i][1] = arr[i - 1000000][1];
                }
            }else{
                for(int i = 0; i < 1000000; i++){
                    names[i][0] = arr[i][0];
                    names[i][1] = arr[i][1];
                }
                for(int i = 1000000; i < 2000000; i++){
                    names[i][0] = arr[i - 1000000][0];
                    names[i][1] = arr[i - 1000000][1];
                }
                for(int i = 2000000; i < 4000000; i++){
                    names[i][0] = names[i - 2000000][0];
                    names[i][1] = names[i - 2000000][1];
                }
            }
        }
    }

    public static void sort(int len){
       init(len);
        sort(names, 0, len - 1, 0);
    }

    private static void exch(String[][] a, int i, int j){
        String s1 = a[i][0], s2 = a[i][1];
        a[i][0] = a[j][0];
        a[i][1] = a[j][1];
        a[j][0] = s1;
        a[j][1] = s2;
    }

    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }

    private static void insertion(String[][] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j][0], a[j-1][0], d); j--)
                exch(a, j, j-1);
    }

    private static void sort(String[][] a, int lo, int hi, int d){
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }
        int lt = lo, gt = hi;
        int v = charAt(a[lo][0], d);
        int i = lo + 1;
        while(i <= gt){
            int t = charAt(a[i][0], d);
            if(t < v){
                exch(a, lt++, i++);
            }else if(t > v){
                exch(a, i, gt--);
            }else{
                i++;
            }
        }
        sort(a, lo, lt - 1, d);
        if(v >= 0) sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }
    public static int charAt(String s, int d){
        if(d < s.length()) return s.charAt(d);
        return -1;
    }

    /*sort interface*/

    public static void sort(){
        sort(names, 0, len - 1, 0);
    }

    public static void sort(String[][] a){
        sort(a, 0, a.length - 1, 0);
    }

    public static void sort(int l, int r){
        sort(names, l, r - 1, 0);
    }

    public static void main(String[] args) {

        sort(1000000);
        for(int i = 0; i < 1000; i++){
            System.out.println(names[i][1]);
        }

    }

}
