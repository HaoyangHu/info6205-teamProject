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

    public static void init(int len){
        String arr[][] = new NameData().getNamesArray();
        names = new String[len];
        if(len <= 1000000){
            for(int i = 0; i < len; i++){
                names[i] = arr[i][1];
                maxLen = Math.max(names[i].length(), maxLen);
            }
            for(int i = 0; i < len; i++){
                while(names[i].length() < maxLen){
                    names[i] += " ";
                }
            }
        }else{
            if(len == 2000000){
                for(int i = 0; i < 1000000; i++){
                    names[i] = arr[i][1];
                    maxLen = Math.max(names[i].length(), maxLen);
                }
                for(int i = 1000000; i < 2000000; i++){
                    names[i] = arr[i - 1000000][1];
                    maxLen = Math.max(names[i].length(), maxLen);
                }
                for(int i = 0; i < len; i++){
                    while(names[i].length() < maxLen){
                        names[i] += " ";
                    }
                }
            }else{
                for(int i = 0; i < 1000000; i++){
                    names[i] = arr[i][1];
                    maxLen = Math.max(names[i].length(), maxLen);
                }
                for(int i = 1000000; i < 2000000; i++){
                    names[i] = arr[i - 1000000][1];
                }
                for(int i = 2000000; i < 4000000; i++){
                    names[i] = names[i - 2000000];
                }
                for(int i = 0; i < len; i++){
                    while(names[i].length() < maxLen){
                        names[i] += " ";
                    }
                }
            }
        }
    }

    public static void sort(int len){
        init(len);
        sort(names);
    }


    public static void sort(String[] a, int w) {
        int n = a.length;
        String[] aux = new String[n];
        for (int d = w-1; d >= 0; d--) {
            int[] count = new int[R+1];
            for (int i = 0; i < n; i++) count[charAt(a[i], d) + 1]++;
            for (int r = 0; r < R; r++) count[r+1] += count[r];
            for (int i = 0; i < n; i++){
                int index = charAt(a[i], d);
                aux[count[index]++] = a[i];
            }
            for (int i = 0; i < n; i++) a[i] = aux[i];
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
        sort(4000000);
        for(String s : names){
            System.out.println(s);
        }

    }
}
