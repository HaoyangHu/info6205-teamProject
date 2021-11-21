package sortWithPinYin4j;

import preprocess.IsSorted;
import preprocess.NameData;

public class MSDRadixSort {
    static final int R = 256;
    private static final int cutoff = 15;
    static String[][] names;
    static int len;

    static{
        len = NameData.len;
        names = new String[len][2];
        for(int i = 0; i < len; i++){
            names[i][0] = NameData.namesArray[i][0];
            names[i][1] = NameData.namesArray[i][1];
        }
    }

    private static void exch(String[][] a, int i, int j){
        String s1 = a[i][0], s2 = a[i][1];
        a[i][0] = a[j][0];
        a[i][1] = a[j][1];
        a[j][0] = s1;
        a[j][1] = s2;
    }

    private static void sort(String[][] a, int lo, int hi, int d){
        if(hi <= lo){
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
        if(v >= 0){
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);
    }

    public static int charAt(String s, int d){
        if(d < s.length()){
            return s.charAt(d);
        }
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

        sort();
        System.out.println(IsSorted.isSorted(names));

    }

}
