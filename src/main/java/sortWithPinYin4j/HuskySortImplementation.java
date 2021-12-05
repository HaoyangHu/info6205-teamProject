package sortWithPinYin4j;

import edu.neu.coe.huskySort.sort.huskySort.QuickHuskySort;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskySortable;
import edu.neu.coe.huskySort.util.Config;
import preprocess.Name;
import preprocess.NameData;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class HuskySortImplementation {


    static Node[] nodeNames;

    static QuickHuskySort<Node> sorter;

    public static void init(int len){
        try {
            config = Config.load(HuskySortImplementation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sorter = new QuickHuskySort<>(Node::huskyCode, config);

        nodeNames = new Node[len];
        String[][] arr = new NameData().getNamesArray();
        if(len <= 1000000){
            for(int i = 0; i < len; i++){
                nodeNames[i] = new Node(arr[i][0], arr[i][1]);
            }
        }else {
            if (len == 2000000) {
                for (int i = 0; i < 1000000; i++) {
                    nodeNames[i] = new Node(arr[i][0], arr[i][1]);
                }
                for (int i = 1000000; i < 2000000; i++) {
                    nodeNames[i] = new Node(arr[i - 1000000][0], arr[i - 1000000][1]);
                }
            } else {
                for (int i = 0; i < 1000000; i++) {
                    nodeNames[i] = new Node(arr[i][0], arr[i][1]);
                }
                for (int i = 1000000; i < 2000000; i++) {
                    nodeNames[i] = new Node(arr[i - 1000000][0], arr[i - 1000000][1]);

                }
                for (int i = 2000000; i < 3000000; i++) {
                    nodeNames[i] = new Node(arr[i - 2000000][0], arr[i - 2000000][1]);
                }
                for (int i = 3000000; i < 4000000; i++) {
                    nodeNames[i] = new Node(arr[i - 3000000][0], arr[i - 3000000][1]);
                }
            }

        }
    }

    public static void sort(int len){
       init(len);
       sort(nodeNames);
    }
    public static void sort(Node[] node){

        sorter.getHelper().sorted(sorter.sort(node));
    }

    public static void sort(int l, int r){
        Node[] temp = new Node[r + 1];
        int p = 0;
        for(int i = l; i <= r; i++){
            temp[p++] = nodeNames[i];
        }
        System.out.println(sorter.getHelper().sorted(sorter.sort(temp)));
    }

    public static void sort(){
        System.out.println(sorter.getHelper().sorted(sorter.sort(nodeNames)));
    }

    private static Config config;

    public static void main(String[] args) throws IOException {

        System.out.println("begin sorting");
        sort(1000000);
        for(int i = 0; i < 1000; i++){
            System.out.println(nodeNames[i]);
        }
    }
    public static class Node implements HuskySortable<Node> {
        String name;  //Chinese name
        String str;  //pinyin4j name
        long longNum;
        public Node(String str, String name){
            this.str = str;
            this.name = name;
            longNum = huskyCode();
        }
        @Override
        public int compareTo(Node o) {
            return this.str.compareTo(o.str);
        }
        @Override
        public long huskyCode() {
            if(longNum == 0l){
                longNum = HuskyCoderFactory.asciiToLong(name);
            }
            return longNum;
        }
        @Override
        public String toString() {
            return name;
        }
    }

}
