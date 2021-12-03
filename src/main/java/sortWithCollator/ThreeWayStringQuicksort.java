package sortWithCollator;

import preprocess.IsSorted;
import preprocess.MakeMSD;
import preprocess.NameData;

import java.util.Map;

public class ThreeWayStringQuicksort {
    static int R;
    private static final int CUTOFF = 15;
    static String[] names;
    static int len;
    static Map<Character, Integer> map;
    static{
        map = MakeMSD.getMap();
        R = map.size();
    }
    public static void init(){
        len = NameData.len;
        names = new String[len];
        for(int i = 0; i < len; i++){
            names[i] = NameData.namesArray[i][1];
        }

    }

    private static void exch(String[] a, int i, int j){
        String s1 = a[i];
        a[i] = a[j];
        a[j] = s1;

    }

    private static void sort(String[] a, int lo, int hi, int d){
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while(i <= gt){
            int t = charAt(a[i], d);
            if(t < v){
                exch(a, lt++, i++);
            }else if(t > v){
                exch(a, i, gt--);
            }else{
                i++;
            }
        }

        sort(a, lo, lt - 1, d);
        if(v >= 0){
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);
    }

    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }
    public static int charAt(String s, int d){
        if(d < s.length()){
            return map.get(s.charAt(d));
        }
        return -1;
    }

    private static boolean less(String v, String w, int d) {
        assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
    /*sort interface*/
    public static void sort(){
        sort(names, 0, len - 1, 0);
    }

    public static void sort(String[] a){
        sort(a, 0, a.length - 1, 0);
    }

    public static void sort(int l, int r){
        sort(names, l, r - 1, 0);
    }

    public static void main(String[] args) {
        init();
        System.out.println("start sorting");
        sort(names);
        for(String s : names){
            System.out.println(s);
        }


    }
}
