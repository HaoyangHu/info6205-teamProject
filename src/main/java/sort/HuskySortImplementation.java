package sort;

import edu.neu.coe.huskySort.sort.huskySort.MergeHuskySort;
import edu.neu.coe.huskySort.sort.huskySort.QuickHuskySort;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.huskySort.util.Config;
import preprocess.NameData;
import edu.neu.coe.huskySort.*;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class HuskySortImplementation {

    static int len;
    static String[] names;
    static{

        len = NameData.len;
        names = new String[len];
        for(int i = 0; i < len; i++){
            names[i] = NameData.namesArray[i][0];
        }

    }

    /*public static void sort() {

        sort(names, 0, len - 1);
    }*/

   /* private static void sort(Node[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        long v = a[lo].longNum;
        int i = lo;
        while (i <= gt)
            if      (less(v, a[i].longNum)) exch(a, i, gt--);
            else if (less(a[i].longNum, v)) exch(a, lt++, i++);
            else                    i++;

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }*/

    private static boolean less(double v, double w) {
        return v < w;
    }

    private static void exch(Node[] a, int i, int j) {
        Node t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) throws IOException {

       /*sort();
        int index = 1;
        for(Node n : names){
            System.out.println(index + " " + n.str);
            index++;
        }*/

        Config config = Config.load(HuskySortImplementation.class);
        //String[] xs = {"Hello", "Goodbye", "Ciao", "Willkommen"};
        QuickHuskySort<String> sorter = new QuickHuskySort<>(HuskyCoderFactory.asciiCoder, config);
        System.out.println(sorter.getHelper().sorted(sorter.sort(names)));
        //assertTrue("sorted", sorter.getHelper().sorted(sorter.sort(xs)));

    }

    private static long stringToLong(final String str, final int maxLength, final int bitWidth, final int mask) {
        final int length = Math.min(str.length(), maxLength);
        final int padding = maxLength - length;
        long result = 0L;
        if (((mask ^ 0xFFFF) & 0xFFFF) == 0)
            for (int i = 0; i < length; i++) result = result << bitWidth | str.charAt(i);
        else
            for (int i = 0; i < length; i++) result = result << bitWidth | str.charAt(i) & mask;
        result = result << bitWidth * padding;
        return result;
    }

    static class Node implements Comparable<Node>{
        String name;
        String str;
        //Long longNum;
        public Node(String str, String name){
            this.str = str;
            this.name = name;
            /*str = str.replace("1", "");
            str = str.replace("2", "");
            str = str.replace("3", "");
            str = str.replace("4", "");
            str = str.replace("5", "");*/
            //str = str.replace(" ", "");

            this.str = str;
            //longNum = stringToLong(this.str, 10, 6, 0x3F);

        }

        @Override
        public int compareTo(Node o) {
            return this.str.compareTo(o.str);
        }

        /*@Override
        public int compareTo(Node o) {
            return Long.compare(this.longNum, o.longNum);
        }*/
    }

}
