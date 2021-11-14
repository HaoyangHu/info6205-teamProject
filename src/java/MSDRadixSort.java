import java.util.ArrayList;
import java.util.List;

public class MSDRadixSort {
    static List<Name> names = new ArrayList<>();
    static String[][] namesArray;
    static int len = 0;
    static final int R = 256;
    private static final int cutoff = 15;
    public static void setNames(){
        Initalize.init(names);
        MSDRadixSort.len = names.size();
        namesArray = new String[len][2];

        for(int i = 0; i < len; i++){
            namesArray[i][0] = names.get(i).pinyin;
            namesArray[i][1] = names.get(i).name;
        }

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


    public static boolean isSorted(String[][] a){
        for(int i = 0; i < len - 1; i++){
            if(a[i][0].compareTo(a[i + 1][0]) > 0){
                return false;
            }

        }
        return true;
    }

    public static void run(){
        setNames();
        sort(namesArray);
        System.out.println(isSorted(namesArray));
    }

    public static void run(String[][] a){
        sort(a);
        for(String[] st : a){
            System.out.println(st[0] + " " + st[1]);
        }
        System.out.println(isSorted(a));
    }

    public static void main(String[] args) {

        run();
    }

}
