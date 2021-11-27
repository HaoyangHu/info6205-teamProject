package sortWithCollator;

import preprocess.MakeMSD;
import preprocess.NameData;

import java.text.Collator;
import java.util.Locale;
import java.util.Map;

public class LSDsort {
    static int R = 0;
    private static final int cutoff = 15;
    static String[] names;
    static int len;
    static int maxLen = 0;
    static Map<Character, Integer> map;
    static{
        map = MakeMSD.getMap();
        R = map.size() + 1;
    }
    public static void init(){
        len = NameData.len;
        names = new String[len];
        for(int i = 0; i < len; i++){
            names[i] = NameData.namesArray[i][1];
            maxLen = Math.max(maxLen, names[i].length());
        }
        for(int i = 0; i < len; i++){
            while(names[i].length() < maxLen){
                names[i] += " ";
            }
        }
        System.out.println(maxLen);

    }

    public static void sort(String[] a, int w) {
        int n = a.length;
        //int R = 256;   // extend ASCII alphabet size
        String[] aux = new String[n];

        for (int d = w-1; d >= 0; d--) {

            int[] count = new int[R+1];
            for (int i = 0; i < n; i++)
                count[charAt(a[i], d) + 1]++;

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // move data
            for (int i = 0; i < n; i++){
                int index = charAt(a[i], d);
                aux[count[index]++] = a[i];
            }
            // copy back
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }


    public static int charAt(String s, int d){
        return map.get(s.charAt(d));
    }

    public static void sort(String[] s){
        int maxlen = 0;
        for(String each : s){
            maxlen = Math.max(maxlen, each.length());
        }
        int n = s.length;
        for(int i = 0; i < n; i++){
            while(s[i].length() < maxlen){
                s[i] += " ";
            }
        }
        sort(s, maxlen);
    }

    public static void main(String[] args) {
        init();
        sort(names, maxLen);
        for(String s : names){
            System.out.println(s);
        }

    }
}
