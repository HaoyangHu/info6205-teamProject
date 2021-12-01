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

    static int len;
    static Node[] nodeNames;
    static Name[] names;
    static QuickHuskySort<Node> sorter;
    public static void init(){
        try {
            config = Config.load(HuskySortImplementation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sorter = new QuickHuskySort<>(Node::huskyCode, config);
        len = NameData.len;
        nodeNames = new Node[len];
        names = new Name[len];
        for(int i = 0; i < len; i++){
            nodeNames[i] = new Node(NameData.namesArray[i][0], NameData.namesArray[i][1]);
            names[i] = NameData.names.get(i);
        }
    }
    public static void sort(Node[] node){

        System.out.println(sorter.getHelper().sorted(sorter.sort(node)));
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
        init();
        System.out.println("begin sorting");
        System.out.println(sorter.getHelper().sorted(sorter.sort(nodeNames)));
        for(Node n : nodeNames){
            System.out.println(n);
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
