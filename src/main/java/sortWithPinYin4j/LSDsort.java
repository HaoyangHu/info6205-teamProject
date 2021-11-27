package sortWithPinYin4j;


import preprocess.NameData;

public class LSDsort {
    static String[][] names;
    static int len;
    static int maxLen = 0;
    public static void init(){
        len = NameData.len;
        names = new String[len][2];
        for(int i = 0; i < len; i++){

            names[i][0] = NameData.namesArray[i][0];
            names[i][1] = NameData.namesArray[i][1];
            maxLen = Math.max(maxLen, names[i][0].length());
        }
        for(int i = 0; i < len; i++){
            while(names[i][0].length() < maxLen){
                names[i][0] += " ";
            }
        }
    }

    public static void sort(String[][] a, int w) {
        int n = a.length;
        int R = 256;   // extend ASCII alphabet size
        String[][] aux = new String[n][2];

        for (int d = w-1; d >= 0; d--) {

            int[] count = new int[R+1];
            for (int i = 0; i < n; i++)
                count[a[i][0].charAt(d) + 1]++;

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // move data
            for (int i = 0; i < n; i++) {
                int index = count[a[i][0].charAt(d)]++;
                aux[index][0] = a[i][0];
                aux[index][1] = a[i][1];
            }

            // copy back
            for (int i = 0; i < n; i++){
                a[i][0] = aux[i][0];
                a[i][1] = aux[i][1];
            }

        }
    }


    public static int charAt(String s, int d){
        if(d >= s.length()){
            return -1;
        }
        return s.charAt(d);

    }

    public static void sort(String[][] s){
        int maxlen = 0;
        int n = s.length;
        for(String[] each : s){
            maxlen = Math.max(maxlen, each[0].length());
        }
        for(int i = 0; i < n; i++){
            while(s[i][0].length() < maxlen){
                s[i][0] += " ";
            }
        }
        sort(s, maxlen);
    }

    public static void sort(){

        sort(names, maxLen);

    }

    public static void main(String[] args) {
        init();
        System.out.println(maxLen);
        sort();
        for(String[] name : names){
            System.out.println(name[1]);
        }
    }

}
