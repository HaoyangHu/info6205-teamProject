import java.util.ArrayList;
import java.util.List;

public class MSDRadixSort {
    static final int R = 256;
    private static final int cutoff = 15;
    static String[][] names;
    static int len;

    static{
        len = NameData.len;
        System.out.println(len);
        names = new String[len][2];
        for(int i = 0; i < len; i++){
            names[i][0] = NameData.namesArray[i][0];
            names[i][1] = NameData.namesArray[i][1];
        }
    }

    private static void ThreeWaySort(String[][] a){
        sort(a, 0, a.length - 1, 0);
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

    public static void sort(String[][] a) {
        String[][] aux = new String[a.length][2];
        sort(a, aux, 0, a.length - 1, 0);
    }



    private static void sort(String[][] a, String[][] aux, int lo, int hi, int d) {
        if (hi < lo + cutoff){
            InsertionSortMSD.sort(a, lo, hi, d);
            return;
        }

        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++){
            count[charAt(a[i][0], d) + 2]++;
        }
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++){
            int index = count[charAt(a[i][0], d) + 1]++;
            aux[index][0] = a[i][0];
            aux[index][1] = a[i][1];
        }
        for (int i = lo; i <= hi; i++){
            a[i][0] = aux[i -lo][0];
            a[i][1] = aux[i -lo][1];
        }
        for (int r = 0; r < R; r++)
            sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);

    }




    public static void run(){

        sort(names);
        System.out.println(IsSorted.isSorted(names));
    }

    public static void runThreeWay(String[][] a){
        ThreeWaySort(a);
        for(String[] aa : a){
            System.out.println(aa[0] + " " + aa[1]);
        }
        System.out.println(IsSorted.isSorted(a));
    }

    /*sort interface*/
    public static void runThreeWay(){
        ThreeWaySort(names);
        System.out.println(IsSorted.isSorted(names));
    }

    public static void run(String[][] a){
        sort(a);
        for(String[] st : a){
            System.out.println(st[0] + " " + st[1]);
        }
        System.out.println(IsSorted.isSorted(a));
    }

    public static void main(String[] args) {

        runThreeWay();
    }

}
