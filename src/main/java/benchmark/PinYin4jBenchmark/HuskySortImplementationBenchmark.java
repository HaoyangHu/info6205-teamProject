package benchmark.PinYin4jBenchmark;

import benchmark.Utils.Benchmark_Timer;
import edu.neu.coe.huskySort.sort.huskySort.QuickHuskySort;
import edu.neu.coe.huskySort.util.Config;
import preprocess.Name;
import preprocess.NameData;
import sortWithPinYin4j.HuskySortImplementation;

import java.io.IOException;

public class HuskySortImplementationBenchmark {
    static int len;
    static HuskySortImplementation.Node[] nodeNames;
    static Name[] names;
    static QuickHuskySort<HuskySortImplementation.Node> sorter;
    private static Config config;

    public static void initAQuarterOfOneMegabyte(){
        try {
            config = Config.load(HuskySortImplementation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sorter = new QuickHuskySort<>(HuskySortImplementation.Node::huskyCode, config);
        len = NameData.len/4;
        nodeNames = new HuskySortImplementation.Node[len];
        names = new Name[len];
        for(int i = 0; i < len; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i][0], NameData.namesArray[i][1]);
            names[i] = NameData.names.get(i);
        }
    }

    public static void initAHalfOfOneMegabyte(){
        try {
            config = Config.load(HuskySortImplementation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sorter = new QuickHuskySort<>(HuskySortImplementation.Node::huskyCode, config);
        len = NameData.len/2;
        nodeNames = new HuskySortImplementation.Node[len];
        names = new Name[len];
        for(int i = 0; i < len; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i][0], NameData.namesArray[i][1]);
            names[i] = NameData.names.get(i);
        }
    }

    public static void initOneMegabyte(){
        try {
            config = Config.load(HuskySortImplementation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sorter = new QuickHuskySort<>(HuskySortImplementation.Node::huskyCode, config);
        len = NameData.len;
        nodeNames = new HuskySortImplementation.Node[len];
        names = new Name[len];
        for(int i = 0; i < len; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i][0], NameData.namesArray[i][1]);
            names[i] = NameData.names.get(i);
        }
    }

    public static void initTwoMegabyte(){
        try {
            config = Config.load(HuskySortImplementation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sorter = new QuickHuskySort<>(HuskySortImplementation.Node::huskyCode, config);
        len = NameData.len*2;
        nodeNames = new HuskySortImplementation.Node[len];
        names = new Name[len];
        for(int i = 0; i < len/2; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i][0], NameData.namesArray[i][1]);
            names[i] = NameData.names.get(i);
        }
        for(int i = len/2; i < len; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i-len/2][0], NameData.namesArray[i-len/2][1]);
            names[i] = NameData.names.get(i-len/2);
        }
    }

    public static void initFourMegabyte(){
        try {
            config = Config.load(HuskySortImplementation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sorter = new QuickHuskySort<>(HuskySortImplementation.Node::huskyCode, config);
        len = NameData.len*4;
        nodeNames = new HuskySortImplementation.Node[len];
        names = new Name[len];
        for(int i = 0; i < len/4; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i][0], NameData.namesArray[i][1]);
            names[i] = NameData.names.get(i);
        }
        for(int i = len/4; i < len/2; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i-len/4][0], NameData.namesArray[i-len/4][1]);
            names[i] = NameData.names.get(i-len/4);
        }
        for(int i = len/2; i < len*3/4; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i-len/2][0], NameData.namesArray[i-len/2][1]);
            names[i] = NameData.names.get(i-len/2);
        }
        for(int i = len*3/4; i < len; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i-len*3/4][0], NameData.namesArray[i-len*3/4][1]);
            names[i] = NameData.names.get(i-len*3/4);
        }
    }


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 8; i++) {
            initAQuarterOfOneMegabyte();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 250K test: ", null , (t)-> sorter.getHelper().sorted(sorter.sort(nodeNames)), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            initAHalfOfOneMegabyte();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 500K test: ", null , (t)-> sorter.getHelper().sorted(sorter.sort(nodeNames)), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            initOneMegabyte();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 1M test: ", null , (t)-> sorter.getHelper().sorted(sorter.sort(nodeNames)), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            initTwoMegabyte();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 2M test: ", null , (t)-> sorter.getHelper().sorted(sorter.sort(nodeNames)), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            initFourMegabyte();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 4M test: ", null , (t)-> sorter.getHelper().sorted(sorter.sort(nodeNames)), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
    }

}
