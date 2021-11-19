package sort;

import edu.neu.coe.huskySort.sort.huskySort.MergeHuskySort;
import edu.neu.coe.huskySort.sort.huskySort.QuickHuskySort;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskySortable;
import edu.neu.coe.huskySort.util.Config;
import preprocess.NameData;
import edu.neu.coe.huskySort.*;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class HuskySortImplementation {

    static int len;
    static Node[] nodeNames;
    static{
        try {
            config = Config.load(HuskySortImplementation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        len = NameData.len;
        nodeNames = new Node[len];
        for(int i = 0; i < len; i++){
            nodeNames[i] = new Node(NameData.namesArray[i][0], NameData.namesArray[i][1]);
        }

    }

    public static void sort(Node[] node){
        QuickHuskySort<Node> sorter = new QuickHuskySort<>(Node::huskyCode, config);
        System.out.println(sorter.getHelper().sorted(sorter.sort(node)));
    }

    public static void sort(int l, int r){
        Node[] temp = new Node[r + 1];
        int p = 0;
        for(int i = l; i <= r; i++){
            temp[p++] = nodeNames[i];
        }
        QuickHuskySort<Node> sorter = new QuickHuskySort<>(Node::huskyCode, config);
        System.out.println(sorter.getHelper().sorted(sorter.sort(temp)));
    }

    public static void sort(){

        QuickHuskySort<Node> sorter = new QuickHuskySort<>(Node::huskyCode, config);
        System.out.println(sorter.getHelper().sorted(sorter.sort(nodeNames)));
    }

    private static Config config;

    public static void main(String[] args) throws IOException {

        QuickHuskySort<Node> sorter = new QuickHuskySort<>(Node::huskyCode, config);
        System.out.println(sorter.getHelper().sorted(sorter.sort(nodeNames)));
        for(Node n : nodeNames){
            System.out.println(n);
        }


    }

    static class Node implements HuskySortable<Node> {
        String name;
        String str;
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
                longNum = HuskyCoderFactory.asciiToLong(str);
            }
            return longNum;
        }
        @Override
        public String toString() {
            return name;
        }
    }

}
