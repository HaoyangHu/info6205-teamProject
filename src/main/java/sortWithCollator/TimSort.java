package sortWithCollator;

import preprocess.IsSorted;
import preprocess.NameData;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class TimSort {

    static String[] names;
    static int len;

    public static void init(){
        len = NameData.len;
        names = new String[len];
        for(int i = 0; i < len; i++){
            names[i] = NameData.namesArray[i][1];

        }

    }

    private static Collator collator = Collator.getInstance(Locale.CHINA);

    public static void sort(){
        Arrays.sort(names, (o1, o2)-> collator.compare(o1, o2));
    }

    public static void sort(int l, int r){
        Arrays.sort(names, l, r, (o1, o2)-> collator.compare(o1, o2));
    }

    public static void sort(String[] a){
        Arrays.sort(a, (o1, o2)-> collator.compare(o1, o2));
    }

    public static void main(String[] args) {
        init();
        System.out.println("begin sorting");
        sort();
        int index = 1;
        for(String s : names){
            System.out.println(index +" " + s);
            index++;
        }
    }

}
