package sort;

import preprocess.IsSorted;
import preprocess.NameData;

import java.util.Arrays;
public class TimeSort {
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

    public static void timSort(){
        Arrays.sort(names, (o1, o2)-> o1[0].compareTo(o2[0]));
        System.out.println(IsSorted.isSorted(names));
    }

    public static void timSort(int l, int r){
        Arrays.sort(names, l, r, (o1, o2)-> o1[0].compareTo(o2[0]));
        System.out.println(IsSorted.isSorted(names));
    }

    public static void timSort(String[][] a){
        Arrays.sort(a, (o1, o2)-> o1[0].compareTo(o2[0]));
        System.out.println(IsSorted.isSorted(a));
    }

    public static void main(String[] args) {
        timSort();
        int index = 1;
        for(String[] s : names){
            System.out.println(index +" " + s[1]);
            index++;
        }
    }

}
