package sort;


import preprocess.NameData;

public class LSDsort {
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

    public static void sort(String[] a, int w) {
        int n = a.length;
        int R = 256;   // extend ASCII alphabet size
        String[] aux = new String[n];

        for (int d = w-1; d >= 0; d--) {

            int[] count = new int[R+1];
            for (int i = 0; i < n; i++)
                count[a[i].charAt(d) + 1]++;

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // move data
            for (int i = 0; i < n; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            // copy back
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }


    public static int charAt(String s, int d){
        if(d < s.length()){
            return s.charAt(d);
        }
        return -1;
    }
}
